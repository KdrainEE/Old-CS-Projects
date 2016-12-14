
public class Bort {
	private String name;
	private int numBorts;
	
	public Bort(String name,int borts){
		this.name=name;
		this.numBorts=borts;
	}

	public String getName() {
		return name;
	}

	public int getNumBorts() {
		return numBorts;
	}
	public void setNumBorts(int num){
		this.numBorts=num;
	}
	public String toString(){
		return name+" "+numBorts;
	}
}
