

/* 
 * Represents room 
 * Escape room includes bedroom and bathroom
 */
public abstract class Room extends Resource {

	private String type;
	 
	public String getType() {
		return type;
	}
	
	protected boolean play() {
		if (isGameOver()) {
			return false;
		}
		else {
			return !hasTimeExpired();
		}
			
	}
	
}
