import java.util.Scanner;

/* For locks that the user can open to receive keys */
public class Lock extends Puzzle {
		
	private int characterNum;
	private String reward;
	
	public Lock(String desc, String code, String reward, int characterNum) {
		super(desc, code);
		this.reward = reward;
		this.characterNum = characterNum;
	}

	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		return true;
	}
	
	private void printMenu() {
		System.out.println("The lock has " + characterNum + " character inputs.");
		System.out.println("[>] Enter code"
				+ "\n[>] Go back ");
	}
	
	private void processInput() {
		Scanner reader = READER;
	
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();

		if (input.equals("enter code")) {		
			System.out.println("What is the code? ");
			input = reader.nextLine().toLowerCase().trim();
			
			System.out.println();
			if (input.equals(code)) {
				System.out.println("The lock opens. ");
				System.out.println("You receive " + reward + ".");
				solved = true;
				return;
			}
			else {
				System.out.println("Wrong combination.");
			}
				
		}
		else if (input.equals("go back")) {
			return;
		}
		else {
			System.out.println("Invalid input! Please try again. ");
		}
		
		play();
		
	}

	
}
