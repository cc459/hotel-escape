import java.util.Scanner;

/* For riddles that the user can solve to receive clues */
public class Riddle extends Puzzle {
	
	private String specialCode;
	private String specialResponse;
	
	public Riddle(String desc, String code) {
		super(desc, code);
	}
	
	public Riddle(String desc, String code, String specialCode, String specialResponse) {
		super(desc, code);
		this.specialCode = specialCode;
		this.specialResponse = specialResponse;
	}
	
	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("[>] Solve riddle"
				+ "\n[>] Go back ");
	}
	
	private void processInput() {
		Scanner reader = READER;;
	
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();

		if (input.equals("solve riddle")) {		
			System.out.println("What is the answer? ");
			input = reader.nextLine().toLowerCase().trim();
			
			System.out.println();
			
			if (input.equals(code)) {
				printRandomResponse(rightAnswerResponses);
				System.out.println("I wonder how \"" + code + "\" could help you... \n");
				solved = true;
				return;
			}
			
			else if (specialCode != null && input.equals(specialCode)) {
				System.out.println(specialResponse);
			}
			else {
				printRandomResponse(wrongAnswerResponses);
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
