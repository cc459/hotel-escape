import java.util.Scanner;

/* 
 * Represents the bedroom
 * User starts here 
 */
public class Bedroom extends Room {
	
	public boolean play() {
		while (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("Glancing around, you find yourself in a small bedroom."
				+ "\nSunlight streams in from a window to the east, opposite the door."
				+ "\nA bed, a desk, a refrigerator, and a table are located around the bedroom."
				+ "\nFrom the bedroom, you also see a bathroom ahead of you.");
		System.out.println("[>] Go to door"
				+ "\n[>] Go to bed"
				+ "\n[>] Go to desk"
				+ "\n[>] Go to fridge"
				+ "\n[>] Go to table"
				+ "\n[>] Go to window"
				+ "\n[>] Go to bathroom");
	}
	
	private void processInput() {
		Scanner reader = READER;
		String input = reader.nextLine().toLowerCase().trim();
		
		if (input.equals("go to door")) {
			DOOR.play();
		}
		
		else if (input.equals("go to bed")) {
			BED.play();
		}
		
		else if (input.equals("go to desk")) {
			DESK.play();
		}
		
		else if (input.equals("go to fridge")) {
		 	REFRIGERATOR.play();
		}
		
		else if (input.equals("go to table")) {
			TABLE.play();
		}
		
		else if (input.equals("go to window")) {
			WINDOW.play();
		}
		
		else if (input.equals("go to bathroom")) {
			System.out.println();
			BATHROOM.play();
			System.out.println();
		}
	
		else {
			System.out.println("\nInvalid input! Please try again.\n ");
		}
	}
}
