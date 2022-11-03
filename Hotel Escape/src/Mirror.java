import java.util.Scanner;

/* For the mirror in the bathroom */
public class Mirror extends Item {
	
	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("You step in front of the mirror. ");
		System.out.println("[>] Smile"
				+ "\n[>] Stare"
				+ "\n[>] Go back");
	}
	
	private void processInput() {
		Scanner reader = READER;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("smile")) {
			System.out.println("You have a lovely smile.");
			play();
		}
		
		else if (input.equals("stare")) {
			System.out.println("Narcissist. ");
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
