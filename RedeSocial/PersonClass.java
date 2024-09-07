package RedeSocial;

public class PersonClass implements Person {

	private static final int FRIENDS_CAP = 50;
	private static final int INI_FRIEND_NUMBER = 0;

	private String name;
	private String mail;
	private String state;
	private FriendRelationClass[] friends;
	private int countFriends;
	private Mural[] mural;
	private int countPosts;

	public PersonClass(String name, String mail, String state) {

		this.name = name;
		this.mail = mail;
		this.state = state;
		friends = new FriendRelationClass[FRIENDS_CAP];
		this.countFriends = INI_FRIEND_NUMBER;
		mural = new MuralClass[INI_FRIEND_NUMBER];
		this.countPosts = INI_FRIEND_NUMBER;
	}
	/**
	 * 
	 * @param name of the person that we want to find the ID
	 * @return the ID of the user
	 */
	private int findPersonID(String name) {
		
		int iniIndex = 0;
		int result = -1;
		boolean found = false;
		
		while(iniIndex < countFriends && !found) {
			if(name.equals(friends[iniIndex].getName())) {
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
	public String getName() {
		
		return name;
	}

	@Override
	public String getMail() {
		
		return mail;
	}

	@Override
	public String getState() {
		
		return state;
	}

	@Override
	public void addFriend(String name, String mail) {
		
		friends[countFriends++] = new FriendRelationClass(name , mail);

	}

	@Override
	public Iterator listFriends() {

		return new Iterator(friends, countFriends);

	}

	@Override
	public int numberOfFriends() {
		
		return countFriends;
	}

	@Override
	public void changeState(String state) {
		
		this.state = state;

	}

	@Override
	public String getFriendName(int index) {
		
		return friends[index].getName();
	}

	@Override
	public boolean isFriendshipExistent(String name) {
		
		boolean result = false;
		if(findPersonID(name) != -1) {
			result = true;
		}
		return result;
		
	}
	@Override
	public void postPublic(String name, String message) {
		
		if( countPosts == mural.length) {
			grow();
		}
		mural[countPosts++] = new MuralClass(name , message);
		
	}
	/**
	 * resize the array
	 */
	private void grow() {
		Mural tmp[] = new MuralClass[mural.length + 1];
		
		for(int i = 0; i < countPosts; i++) {
			tmp[i] = mural[i];
		}
		mural = tmp;
		
	}
	@Override
	public Iterator3 listMural() {
		
		return new Iterator3(mural, countPosts);
	}

	
	
	
	
	

}
