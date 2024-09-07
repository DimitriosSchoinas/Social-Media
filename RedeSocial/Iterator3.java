package RedeSocial;

public class Iterator3 {

	private Mural[] mural; 
	private int size; 
	private int nextIndex; 

	public Iterator3(Mural[] mural, int size) {
		this.mural = mural;
		this.size = size;
		nextIndex = 0;
	}
	
	public boolean hasNext() {
		return nextIndex < size;
	}

	/** Pre: hasNext() */
	public Mural next() {
		return mural[nextIndex++];
	}
}
