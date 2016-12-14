package linkedLists;

public class Taco implements Comparable<Taco> {
	private String name;
	private String maker;
	private double price;
	private int rating;
	public Taco(){
		name = null;
		maker = null;
		price = 0.0;
		rating = 0;
	}
	public Taco(String aName, String aMaker, double price, int rating){
		//TODO call the mutators
		this.setName(aName);
		this.setPrice(price);
		this.setRating(rating);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price>=0.0)
			this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		if(rating>0 && rating<=4)
			this.rating = rating;
	}
	
	public int compareTo(Taco aTaco) {
		// TODO Auto-generated method stub
		//Taco aTaco = (Taco)obj;
		 double diff = this.price - aTaco.price;
		 if ( diff < 0)
			 return -1;
		 else if (diff > 0 )
			 return 1;
		 else
			 return 0;
	}
	
	/*public int compareTo1(Taco o) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
}





























