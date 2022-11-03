import java.util.Scanner;

/* For the bathtub in the bedroom */
public class Bathtub extends Item {
	
	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("You approach the bathtub. A fuzzy blue bathmat lies before it. ");
		System.out.println("\n[>] Examine bathmat"
				+ "\n[>] Go back");
	}
	
	private void processInput() {
		Scanner reader = READER;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("examine bathmat")) {
			if (BATHTUB.isSolved()) {
				System.out.println("There is nothing unusual about the bathmat. ");
				play();
			}
			else {
				System.out.println("You squat down to take a closer look at the bathmat.");
				System.out.println("Noticing a strange rise in the material, you lift up a corner.");
				System.out.println("You pick up a blue key and stand back up. ");
				BATHTUB.solved = true;
				play();
			}
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
