package RedeSocial;

public class FriendRelationClass {

	private String name;
	private String mail;

	public FriendRelationClass(String name, String mail) {
		this.name = name;
		this.mail = mail;
	}
	/**
	 * 
	 * @return name of the friend
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return mail of the friend
	 */
	public String getMail() {
		return mail;
	}


}
