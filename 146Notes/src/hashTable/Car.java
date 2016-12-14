package hashTable;

public class Car {
	private String make;
	private String model;
	private int year;
	
	public Car()
	{
		make=model=null;
		year=1900;
	}
	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + "]";
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year>0)
		 this.year = year;
	}
	
}
