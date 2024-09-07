package RedeSocial;

public class MuralClass implements Mural {
	
	private String postOwner;
	private String postMassage;
	
	public MuralClass(String postOwner, String postMassage) {
		
		this.postOwner = postOwner;
		this.postMassage = postMassage;
	}

	@Override
	public String getMessageOwner() {
		
		return postOwner;
	}

	@Override
	public String getMessagePost() {
	
		return postMassage;
	}

}
