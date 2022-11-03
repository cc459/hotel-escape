
/* For various items in the rooms */
public class Item extends Resource{

	private String type;
	protected boolean solved = false;

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		type = this.type;
	}
	
	public boolean isSolved() {
		return solved;
	}
	
	protected boolean play() {
		System.out.println();
		return !hasTimeExpired();
			
	}
	
	
}
