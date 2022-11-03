import java.util.Scanner;

/* For the cake in the fridge in the bedroom */
public class Cake extends Puzzle {
	
	public Cake() {
		super("desc", "code");
	}
	
	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("[>] Crack egg");
		System.out.println("[>] Eat cake");
		System.out.println("[>] Go back");
	}
	
	private void processInput() {	
		Scanner reader = READER;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("crack egg")) {
			printRandomResponse(crackedEggResponses);
			play();
			/* int eggNum = (int) (Math.random() * 4);
			if (eggNum != 3) {
				printRandomResponse(crackedEggResponses);
				play();
			}
			else {
				System.out.println("CLUE");
				super.solved = true;
			}*/
		}
		
		else if (input.equals("eat cake")) {
			if (!CAKE.isSolved()) {
				System.out.println("Yum, chocolate! ");
				System.out.println("...");
				System.out.println("OWWWWWWWWW. ");
				System.out.println("You carefully remove a red key from your mouth. ");
				System.out.println("Now, whose idea was it to hide a key in the cake?");
				super.solved = true;
			}
			else {
				System.out.println("You already devoured the cake. ");
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
