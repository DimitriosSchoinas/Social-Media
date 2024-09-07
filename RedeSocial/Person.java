package RedeSocial;

public interface Person {

	/**
	 * 
	 * @return name of the person
	 */
	String getName();

	/**
	 * 
	 * @return mail of the person
	 */
	String getMail();

	/**
	 * 
	 * @return state of the person
	 */
	String getState();

	/**
	 * Is to add a new friend in your friends list
	 * 
	 * @param name
	 */
	void addFriend(String name, String mail);

	/**
	 * 
	 * @return a list of the name and mail of the friends
	 */
	Iterator listFriends();

	/**
	 * 
	 * @return the number of friends of the user
	 */
	int numberOfFriends();

	/**
	 * Changes the state of the user
	 * 
	 * @param state is the new state to change
	 */
	void changeState(String state);
	/**
	 * 
	 * @param index numero do index do amigo
	 * @return o nome do amigo da lista de amigos
	 */
	String getFriendName(int index);
	/**
	 * 
	 * @param name of friend that we are searching
	 * @return is friend exists or not
	 */
	boolean isFriendshipExistent(String name);
	/**
	 * posts a new message
	 * @param name of the message owner
	 * @param message that the owner wants to post
	 */
	void postPublic(String name, String message);
	/**
	 * 
	 * @return the objects of the mural array
	 */
	Iterator3 listMural();
}
