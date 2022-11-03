import java.util.Scanner;

/* For the hotel room door */
public class Door extends Item {
	
	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("You face a beige metal door.");
		System.out.println("You see what looks like a fire evacuation map at the center.");
		System.out.println("[>] Open door"
				+ "\n[>] Kick door"
				+ "\n[>] Examine map"
				+ "\n[>] Go back");
	}
	
	private void processInput() {
		Scanner reader = READER;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("open door")) {
			System.out.println("It's jammed shut.");
			System.out.println("Did you really think it would be this easy?");
			play();
		}
		
		else if (input.equals("kick door")) {
			System.out.println("With your hulk-like strength, you kick open the door and walk out triumphantly. ");
			System.out.println("Just kidding. ");
			System.out.println("You're definitely not that strong. ");
			System.out.println("The door doesn't budge, and you're left with a bruised foot. ");
			play();
		}
		
		else if(input.equals("examine map")) {
			System.out.println("You squint your eyes to make out the diagrams. ");
			System.out.println("It looks like there's a fire escape outside the window. ");
			System.out.println("Interesting...");
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
