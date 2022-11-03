import java.util.Scanner;

/* For the refrigerator in the bedroom */
public class Refrigerator extends Item {

	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("A small black mini-fridge faces you. "
				+ "\nOn the front of the fridge, a yellow magnet holds a newspaper clipping."
				+ "\n[>] Open fridge"
				+ "\n[>] Examine newspaper"
				+ "\n[>] Go back");
	}
	
	private void processInput() {
		Scanner reader = READER;;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("open fridge")) {
			
			if (CAKE.isSolved()) {
				System.out.println("You open the fridge.");
				System.out.println("There's only a basket of eggs left.");
				System.out.println("Hope you're not too hungry!");	
				CAKE.play();
			}
			else {
				System.out.println("You open the fridge.");
				System.out.println("It contains a birthday cake with bright red candles as well as a basket of eggs.");
				CAKE.play();
			}
			System.out.println("You close the fridge door. ");
			play();
		}
		
		else if (input.equals("examine newspaper")) {
			System.out.println("You approach the fridge.");
			System.out.println("A fragment of a crossword puzzle is visible on the newspaper clipping. ");
			System.out.println("It reads: \"17. A sweet golden substance derived from bees.\"");
			CROSSWORD.play();
			System.out.println("You take a few steps back.");
			play();
		}
		
		else if (input.equals("go back")) {
			return;
		}
		
		else {
			System.out.println("Invalid input! Please try again. ");
			play();
		}
	}
}
