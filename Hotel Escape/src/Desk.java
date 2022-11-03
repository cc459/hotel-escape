import java.util.Scanner;

/* For the desk in the bedroom */
public class Desk extends Item {

	
	public boolean play() {
		if (super.play()) {	
			printMenu();
			processInput();
		}
		return true;
	}
	
	private void printMenu() {
		System.out.println("A cookbook, a lamp, and a vase of tulips line the back of the desk. ");
		System.out.println("Your eyes drift toward a paper marked with bright purple lettering at the center. ");
		System.out.println("You also notice an interesting drawer attached to the desk.");
		System.out.println("[>] Read paper"
				+ "\n[>] Read cookbook"
				+ "\n[>] Examine drawer"
				+ "\n[>] Go back"
				+ "\n[>] Hint");
	}
	
	private void processInput() {
		Scanner reader = READER;;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("read paper")) {
			System.out.println("You take a closer look at the paper. ");
			System.out.println("It reads: \"What is a math teacher's favorite dessert?\"");
			PIE.play();
			System.out.println("You lift your gaze.");
		}
		
		else if (input.equals("read cookbook")) {
			System.out.println("What are you, a chef?");
			System.out.println("Remember that time you burned microwaved food...");
		}
		
		else if (input.equals("examine drawer")) {
			if (DRAWER.isSolved()) {
				System.out.println("The drawer is empty.");
			}
			else {
				System.out.println("The drawer is shut with a green lock.");
				DRAWER.play();

			}
			System.out.println("You return to the desk. ");
		}
		
		else if (input.equals("go back")) {
			return;	
		}
		
		else if (input.equals("hint")) {
			if (anyMoreHints()) {
				System.out.println("Where else do you see green? ");
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
