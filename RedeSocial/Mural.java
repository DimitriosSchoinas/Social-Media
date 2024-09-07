package RedeSocial;

public interface Mural {

	/**
	 * 
	 * @return who sent the message
	 */
	String getMessageOwner();
	
	/**
	 * 
	 * @return what was written in the post
	 */
	String getMessagePost();
}
