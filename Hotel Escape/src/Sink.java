import java.util.Scanner;

/* For the sink in the bathroom */
public class Sink extends Item {

	public boolean play() {
		if (super.play()) {
			printMenu(); 
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("You take a few steps toward the sink. A small jewelry box is present on the counter. ");
		System.out.println("[>] Wash hands"
				+ "\n[>] Examine box"
				+ "\n[>] Go back"
				+ "\n[>] Hint");
	}
	
	private void processInput() {
		Scanner reader = READER;;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("examine box")) {
			if (JEWELRY_BOX.isSolved()) {
				System.out.println("The box is empty. ");
			}
			else {
				System.out.println("The box has a purple lock. ");
				JEWELRY_BOX.play();
			}
		}
		
		else if (input.equals("wash hands")) {
			System.out.println("Did you know that 69% of men don't wash their hands after using the bathroom?");
			System.out.println("Eww, gross.");
		}
		
		else if (input.equals("go back")) {
			return;
		}
		
		else if (input.equals("hint")) {
			if (anyMoreHints()) {
				System.out.println("Have you checked the writing on the desk?");
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
