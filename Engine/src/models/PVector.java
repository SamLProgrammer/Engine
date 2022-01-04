package models;

public class PVector {
	
	private double x;
	private double y;
	private double z;
	private double w;
	
	public PVector(double x, double y, double z, double w) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public double[][] toMatrix() {
		double[][] asMatrix = {
				{x},
				{y},
				{z},
				{w}
		};
		return asMatrix;
	}
	
	public String toString() {
		return x + ", " + y + ", " + z + ", " + w;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getW() {
		return w;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setW(double w) {
		this.w = w;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
}


