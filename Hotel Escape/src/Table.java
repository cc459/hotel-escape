import java.util.Scanner;

/* For the table in the bedroom */

public class Table extends Item {

	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		
		return true;
	}
	
	private void printMenu() {
		System.out.println("A green and white chessboard lies at the center of the table");
		System.out.println("A small scribbled note is tucked under a corner of the board.");
		System.out.println("[>] Read note"
				+ "\n[>] Play chess"
				+ "\n[>] Go back");
	}
	
	private void processInput() {
		Scanner reader = READER;;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("read note")) {
			System.out.println("It reads: How many squares are in a chessboard?");
			CHESSBOARD.play(); 
			System.out.println("\"That's a tough puzzle.\" You tell yourself."); 
		}
		
		else if (input.equals("play chess")) {
			System.out.println("There are no pieces, silly!");
			System.out.println("You're not Beth Harmon.");
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
