package trees;

public class Collider {
	//coordinates of the point collider in 2D space
	private double x;
	private double y;
	
	public Collider()
	{
		this.x = this.y = 0.0;
	}
	public Collider(double aX, double aY)
	{
		//use mutators
		this.setX(aX);
		this.setY(aY);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String aString()
	{
		return this.x+" "+this.y;
	}
}
