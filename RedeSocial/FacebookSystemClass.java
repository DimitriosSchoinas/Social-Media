package RedeSocial;

public class FacebookSystemClass implements FacebookSystem {

	private static final int USERS_CAP = 500;
	private static final int INI_NUM_USERS = 0;

	private Person[] person;
	private int registeredUsers;

	public FacebookSystemClass() {

		person = new Person[USERS_CAP];
		registeredUsers = INI_NUM_USERS;
	}

	/**
	 * 
	 * @param name of the person that we want to know the ID
	 * @return the number of the person´s ID
	 */
	private int findPersonID(String name) {
		
		int iniIndex = 0;
		int result = -1;
		boolean found = false;
		
		while(iniIndex < registeredUsers && !found) {
			if(name.equals(person[iniIndex].getName())) {
				found = true;
			}else {
				iniIndex++;
			}		
		}
		if(found == true) {
			result = iniIndex;
		}
			return result;
		
	}

	@Override
	public boolean isRegistered(String name) {
		
		boolean result = false;
		
		if(findPersonID(name) != -1) {
			result = true;
		}
		return result;
	}

	@Override
	public void registerPerson(String name, String mail, String state) {
		
		person[registeredUsers++] = new PersonClass(name, mail, state);

	}

	@Override
	public boolean isFriendshipExistent(String name, String otherName) {
		
		boolean result;
		
		if(isRegistered(name) == false || isRegistered(otherName) == false) {
			result = false;}
		else {
			result = person[findPersonID(name)].isFriendshipExistent(otherName);

		}
		return 	result;	
	}

	@Override
	public void addFriend(String name, String otherName) {
		
		int firstPersonID = findPersonID(name);
		int secondPersonID = findPersonID(otherName);
		String firstPersonMail = person[firstPersonID].getMail();
		String secondPersonMail = person[secondPersonID].getMail();
		
		person[firstPersonID].addFriend(otherName, secondPersonMail);
		person[secondPersonID].addFriend(name, firstPersonMail);

	}

	@Override
	public Iterator listFriends(String name) {

		return person[findPersonID(name)].listFriends();
	}

	@Override
	public int numberOfFriends(String name) {
		
		return person[findPersonID(name)].numberOfFriends();
	}

	@Override
	public void changeState(String name, String state) {
		
		person[findPersonID(name)].changeState(state);

	}

	@Override
	public String getState(String name) {
		
		return person[findPersonID(name)].getState();
	}

	@Override
	public Iterator2 listUsers() {
		
		return new Iterator2(person, registeredUsers);
	}

	@Override
	public int getNumUsers() {
		
		return registeredUsers;
	}

	@Override
	public void postMessage(String name, String message) {
		
		person[findPersonID(name)].postPublic(name, message);
		
	}

	@Override
	public void postToFriendMural(String name, String message, String receiver) {
	
		person[findPersonID(receiver)].postPublic(name, message);
		
	}

	@Override
	public Iterator3 listMural(String name) {
		
		return person[findPersonID(name)].listMural();

	}

	

}
