package RedeSocial;

public class Iterator {

	private FriendRelationClass[] friends;
	private int nextIndex;
	private int numOfFriends;

	public Iterator(FriendRelationClass[] friends, int numOfFriends) {
		this.friends = friends;
		nextIndex = 0;
		this.numOfFriends = numOfFriends;
	}

	/**
	 * 
	 * @return if there is a next friend in the list
	 */
	public boolean hasNext() {
		return nextIndex < numOfFriends;
	}

	/**
	 * 
	 * @return the next friend in the list
	 */
	public FriendRelationClass Next() {
		return friends[nextIndex++];
	}
}
