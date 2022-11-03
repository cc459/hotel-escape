import java.util.Scanner;

/* Contains methods to run the game */
public class GameManager extends Resource {
	
	public void startGame() {
		System.out.println("Welcome to Hotel Escape!");
		System.out.println("Your friends told you they had a surprise planned for your birthday. "
				+ "\nIt sounded fun, until you found yourself awoken at the crack of dawn, blindfolded, and taken to an unfamiliar place. "
				+ "\nJust as you open your mouth to ask where you are, you hear a door click shut behind you. "
				+ "\n\"You have 30 minutes to escape!\" You hear from the other side of the door.");
		System.out.println("[>] Play"
				+ "\n[>] Quit");
		processInput();
	
	}
	
	private void processInput() {
		boolean valid = false;
		Scanner reader = READER;
		
		while (!valid) {
			String input = reader.nextLine().toLowerCase().trim();
			
			if (input.equals("play")) {
				playGame();
				valid = true;
			}
		
			else if (input.equals("quit")) {
				System.out.println("\nMaybe next time, scaredy cat. ");
				break;
			}
	
			else {
				System.out.println("\nInvalid input! Please try again. ");
			}
		}
	}
	
	public void playGame() {
		initialize();
		System.out.println("\nYou take off your blindfold and take in your surroundings.");
		System.out.println("Good luck!");
		System.out.println("(You can have a maximum of " + HINT_MAX + " hints.)\n");
		BEDROOM.play();
		if (isGameOver()) {
			replay();
		}
	}
	
	public void replay() {
		boolean valid = false;
		Scanner reader = READER;;
		
		while (!valid) {
			System.out.println("\nWould you like to play again?");
			System.out.println("[>] Yes"
				+ "\n[>] No");
			String input = reader.nextLine().toLowerCase().trim();
			if (input.equals("yes")) {
				System.out.println();
				startGame();
				valid = true;
			}
			else if (input.equals("no")) {
				System.out.println("\nThank you for playing Hotel Escape!");
				break;
			}
			else {
				System.out.println("\nInvalid input! Please try again. \n");
			}
		}
	}
	
}
