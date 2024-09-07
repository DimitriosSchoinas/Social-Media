package RedeSocial;

public interface FacebookSystem {

	/**
	 * 
	 * @param name of the person
	 * @return if the person exists or not in the system
	 */
	boolean isRegistered(String name);

	/**
	 * Register a new user in the system
	 * 
	 * @param name  of the person to register
	 * @param mail  of the person to register
	 * @param state initial state of the person to register
	 */
	void registerPerson(String name, String mail, String state);

	/**
	 * Shows if 2 people are friends or not
	 * 
	 * @param name      is the name of the first person
	 * @param otherName is the name of the other person
	 * @return true if they are friends
	 */
	boolean isFriendshipExistent(String name, String otherName);

	/**
	 * Add a new friend to your friends list
	 * 
	 * @param name      of the selected person
	 * @param otherName name of the friend that we want to add
	 */
	void addFriend(String name, String otherName);

	/**
	 * 
	 * @param name of the person that we want the list of friends
	 * @return the list of friends of the person
	 */
	Iterator listFriends(String name);

	/**
	 * 
	 * @param name of the user
	 * @return the number of friends of the user
	 */
	int numberOfFriends(String name);

	/**
	 * Changes the state of the selected user
	 * 
	 * @param name  of the user that we want to change the state
	 * @param state of the user
	 */
	void changeState(String name, String state);

	/**
	 * 
	 * @param name of the user
	 * @return the state of the selected user
	 */
	String getState(String name);

	/**
	 * 
	 * @return lists all the users of the facebook
	 */
	Iterator2 listUsers();

	/**
	 * 
	 * @return total number of users
	 */
	int getNumUsers();
	/**
	 * posts a message in the mural
	 * @param name of the post owner
	 * @param message that the owner sent
	 */
	void postMessage(String name , String message);
	/**
	 * adds a the message sent by name to the receiver's mural
	 * @param name of the message owner
	 * @param message that we want to send
	 * @param receiver is who receives the message
	 */
	void postToFriendMural(String name, String message, String receiver);

	/**
	 * 
	 * @return the objects of the mural array
	 * @param name of the message owner of the mural
	 */
	Iterator3 listMural(String name);
}
