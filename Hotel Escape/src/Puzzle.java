/* For puzzles that the user can solve to receive clues or keys */
public class Puzzle extends Resource{
	
	protected String desc;
	protected String code;
	protected boolean solved = false;
	
	public Puzzle(String desc, String code) {
		this.desc = desc;
		this.code = code;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getcode() {
		return code;
	}
	
	public boolean isSolved() {
		return solved;
	}
	
	public void solve(String input) {
		if (input.equals(code)) {
			solved = true;
		}
	}
	
	protected boolean play() {
		System.out.println();
		return !hasTimeExpired();
			
	}
	
}
