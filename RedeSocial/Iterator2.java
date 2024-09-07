package RedeSocial;

public class Iterator2 {

	private Person[] person;
	private int nextIndex;
	private int numberOfUsers;

	public Iterator2(Person[] person, int numberOfUsers) {
		this.person = person;
		nextIndex = 0;
		this.numberOfUsers = numberOfUsers;
	}

	/**
	 * 
	 * @return if there is a next user in the list
	 */
	public boolean hasNext() {
		return nextIndex < numberOfUsers;
	}

	/**
	 * 
	 * @return the next user in the list
	 */
	public Person Next() {
		return person[nextIndex++];
	}
}
