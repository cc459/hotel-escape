import java.util.ArrayList;
import java.util.Scanner;

/* Contains methods and variables for reference */
public class Resource {

	protected static Bedroom BEDROOM;
	protected static Bathroom BATHROOM;
	
	protected static Bed BED;
	protected static Desk DESK;
	protected static Refrigerator REFRIGERATOR;
	protected static Table TABLE;
	protected static Window WINDOW;
	protected static Door DOOR;
	
	protected static Bathtub BATHTUB;
	protected static Mirror MIRROR;
	protected static Sink SINK;
	
	protected static Cake CAKE;

	protected static Riddle CHESSBOARD;
	protected static Riddle PIE;
	protected static Riddle CROSSWORD;
	protected static Lock DRAWER;
	protected static Lock TRUNK;
	protected static Lock JEWELRY_BOX;
	
	protected static Scanner READER = new Scanner(System.in);
	
	private static int hintCount;
	protected static final int HINT_MAX = 2;
	
	private static long startingTime;
	private static long maxTimeAllowed;
	private static long endingTime;
	private static long firstWarningTime;
	private static long secondWarningTime;
	private static long thirdWarningTime;
	private static long fourthWarningTime;
	private static boolean firstWarning;
	private static boolean secondWarning;
	private static boolean thirdWarning;
	private static boolean fourthWarning;
	private static int firstWarningTimeLeft = 15;
	private static int secondWarningTimeLeft = 10;
	private static int thirdWarningTimeLeft = 5;
	private static int fourthWarningTimeLeft = 1;
	
	public static String getTimeElapsed() {
		int minutes;
		int seconds;
		int totalSeconds;
		
		String timeString = "";
		
		totalSeconds = (int) ((System.currentTimeMillis() - startingTime) / 1000);
		
		minutes = (int) (totalSeconds / 60);
		seconds = totalSeconds % 60;
		
		if (minutes != 0) {
			timeString += minutes + " minutes";
		}
		if (seconds != 0) {
			timeString += " and " + seconds + " seconds";
		}
		
		timeString += ".";
		
		return timeString;
		// SECONDS AND MINUTES
	}
	
	public static boolean hasTimeExpired() {
		long currentTime = System.currentTimeMillis();
		
		if (! gameOver) {		
			if (currentTime >= endingTime) {
				System.out.println("Your time has expired. Sorry, you didn't succeed.");
				gameOver = true;
				return true;
			}
			else if (! fourthWarning) {
				if (currentTime >= fourthWarningTime) {
					System.out.println("\n!!!!Warning!!!! You have less than " 
							+ fourthWarningTimeLeft + " minute left.\n");
					fourthWarning = true;
					thirdWarning = true;
					secondWarning = true;
					firstWarning = true;
				}				
				else if (! thirdWarning) {
					if (currentTime >= thirdWarningTime) {
						System.out.println("!!!Warning!!! You have less than " 
								+ thirdWarningTimeLeft + " minutes left.\n");
						thirdWarning = true;
						secondWarning = true;
						firstWarning = true;
					}
					else if (! secondWarning) {
						if (currentTime >= secondWarningTime) {
							System.out.println("!!Warning!! You have less than " 
									+ secondWarningTimeLeft + " minutes left.\n");
							secondWarning = true;
							firstWarning = true;
						}
						else if (! firstWarning) {
							if (currentTime >= firstWarningTime) {
								System.out.println("!Warning! You have less than "
										+ firstWarningTimeLeft + " minutes left.\n");
								firstWarning = true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean hasGreenKey() 
	{
		return DRAWER.isSolved();
	}
	
	public static boolean hasPurpleKey() 
	{
		return JEWELRY_BOX.isSolved();
	}
	
	public static boolean hasBlueKey() {
		return BATHTUB.isSolved();
	}
	
	public static boolean hasYellowKey() {
		return TRUNK.isSolved();
	}
	
	public static boolean hasRedKey() {
		return CAKE.isSolved();
	}
	
	public static boolean anyMoreHints() {
		return hintCount <= HINT_MAX;
	}
	
	public static void increaseHintCount() {
		hintCount++;
		
	}
	
	private static boolean gameOver;
	
	public static boolean isGameOver() {
		return gameOver;
	}
	
	public static void setGameOver(boolean gameOverFlag) {
		gameOver = gameOverFlag;
	}
	
	public static void printRandomResponse(ArrayList<String> responses) {
		System.out.println(responses.get((int) (Math.random() * responses.size())));
	}
	
	public static ArrayList<String> wrongAnswerResponses;
	public static ArrayList<String> rightAnswerResponses;
	public static ArrayList<String> crackedEggResponses;

	public static void initialize() {
		BEDROOM = new Bedroom();
		BATHROOM = new Bathroom();
		
		BED = new Bed();
		DESK = new Desk();
		REFRIGERATOR = new Refrigerator();
		TABLE = new Table();
		WINDOW = new Window();
		DOOR = new Door();
		
		BATHTUB = new Bathtub();
		MIRROR = new Mirror();
		SINK = new Sink();
		
		CAKE = new Cake();
	
		CHESSBOARD = new Riddle("green key riddle", "204", "64", "Close... think about what happens when you put 4 squares together.");
		PIE = new Riddle("purple key riddle", "pi");
		CROSSWORD = new Riddle("yellow key riddle", "honey");
		DRAWER = new Lock("green key lock", "204", "a green key ", 3);
		TRUNK = new Lock("yellow key lock", "honey", "a yellow key", 5);
		JEWELRY_BOX = new Lock("purple key lock", "pi", "an purple key", 2);
		
		startingTime = System.currentTimeMillis();
		maxTimeAllowed = 30 * 60 * 1000;
		endingTime = startingTime + maxTimeAllowed;
		firstWarningTime = startingTime + 15 * 60 * 1000;
		secondWarningTime = startingTime + 20 * 60 * 1000;
		thirdWarningTime = startingTime + 25 * 60 * 1000;
		fourthWarningTime = startingTime + 29 * 60 * 1000;
		firstWarning = false;
		secondWarning = false;
		thirdWarning = false;
		fourthWarning = false;
				
		hintCount = 0;
		
		gameOver = false;
		
		wrongAnswerResponses = new ArrayList<String>();
		wrongAnswerResponses.add("Wrong answer.");
		wrongAnswerResponses.add("Not quite right.");
		wrongAnswerResponses.add("Try again.");
		
		rightAnswerResponses = new ArrayList<String>();
		rightAnswerResponses.add("You got it.");
		rightAnswerResponses.add("Ding ding ding!");
		rightAnswerResponses.add("That's correct.");
	
		crackedEggResponses = new ArrayList<String>();
		crackedEggResponses.add("Now you're covered in egg yolk!");
		crackedEggResponses.add("No, no, do not try to crack an egg with one hand!");
		crackedEggResponses.add("You're making a mess! ");
	}
}
