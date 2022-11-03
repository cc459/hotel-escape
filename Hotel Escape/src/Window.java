import java.util.Scanner;

/* 
 * For the window in the bedroom
 * User escapes here
 */
public class Window extends Item {

	public boolean play() {
		if (super.play()) {
			printMenu();
			processInput();
		}
		return true;
	}
	
	private void printMenu() {
		System.out.println("The bright sunlight streaming through the window irritates your eyes."
				+ "\n[>] Look outside"
				+ "\n[>] Open window"
				+ "\n[>] Go back");
	}
	
	private void processInput() {
		Scanner reader = READER;;
		String input = reader.nextLine().toLowerCase().trim();
		
		System.out.println();
		
		if (input.equals("look outside")) {
			System.out.println("You see a fire escape below. ");
			play();
		}
		
		else if (input.equals("open window")) {
			if (hasRedKey() && hasPurpleKey() && hasGreenKey() && hasPurpleKey() && hasYellowKey()) {
				System.out.println("You climb down the fire escape to meet your cheering friends on the ground.");
				System.out.println("Congratulations, you escaped in " + getTimeElapsed());
				System.out.println("Hope this surprise was more fun than you thought. ");
				setGameOver(true);
			}
			else {
				System.out.println("5 colored locks keep the window shut. ");
				System.out.println("Red, blue, green, purple, and yellow. ");
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
