import java.util.Scanner;

/* For the bed in the bedroom */
public class Bed extends Item {
	
	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("You sit down on a comfortable mattress. ");
		System.out.println("The sheets display a blown up image of your face in a party hat. ");
		System.out.println("\"They could have at least chosen a more flattering image,\" you mutter. ");
		System.out.println("[>] Sleep"
				+ "\n[>] Look under bed"
				+ "\n[>] Go back"
				+ "\n[>] Hint");
	}
	
	private void processInput() {
		Scanner reader = READER;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("look under bed")) {
			System.out.println("You spot a dark oak trunk with a yellow lock.");
			if (TRUNK.isSolved()) {
				System.out.println("The trunk is empty.");
			}
			else {
				TRUNK.play();

			}
			System.out.println("You return to the bed. ");
		}
		
		else if (input.equals("sleep")) {
			System.out.println("You can't sleep now or you'll never escape! ");
			System.out.println("Mwahahahahahahah. ");
		}
		
		else if (input.equals("go back")) {
			return;
		}
		
		else if (input.equals("hint")) {
			if (anyMoreHints()) {
				System.out.println("Have you checked the newspaper on the fridge?");
				increaseHintCount();
			}
			else {
				System.out.println("You've used up all your hints, sorry!");
			}
		}
		
		else {
			System.out.println("Invalid input! Please try again. ");
		}
		
		play();
	}
}
