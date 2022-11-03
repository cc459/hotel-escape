import java.util.Scanner;

/* 
 * Represents the bathroom
 * User can travel here from the bedroom
 */
public class Bathroom extends Room {
		
	public boolean play() {
		while (super.play()) {
			printMenu();
			if (! processInput()) {
				return true;
			}
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("The bathroom appears quite small.");
		System.out.println("You see a bathtub, a mirror, a sink, and a toilet.");
		System.out.println("Nice floral tiling! ");
		System.out.println("[>] Go to bathtub"
				+ "\n[>] Go to mirror"
				+ "\n[>] Go to sink"
				+ "\n[>] go to toilet"
				+ "\n[>] Go to bedroom");
	}
	
	private boolean processInput() {
		Scanner reader = READER;
		String input = reader.nextLine().toLowerCase().trim();
		
		
		if (input.equals("go to bathtub")) {
			BATHTUB.play();
		}
		
		else if (input.equals("go to mirror")) {
			MIRROR.play();
		}
		
		else if (input.equals("go to sink")) {
			SINK.play();
		}
		
		else if (input.equals("go to toilet")) {
		 	System.out.println("\nIt's just a toilet. ");
		 	System.out.println("What did you expect to find here... \n");
		}
		
		else if (input.equals("go to bedroom")) {
			return false;
		}
	
		else {
			System.out.println("\nInvalid input! Please try again.\n ");
		}
		
		return true;
	}
}
