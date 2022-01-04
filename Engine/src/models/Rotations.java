package models;

public class Rotations {

	public double[][] getZRotationMatrix(double angle) {
		double radiansAngle = Math.toRadians(angle);
		double[][] matrix = {
				{Math.cos(radiansAngle), -Math.sin(radiansAngle),0,0},
				{Math.sin(radiansAngle), Math.cos(radiansAngle),0,0},
				{0,0,1,0},
				{0,0,0,1}
		};
		return matrix;
	}

	public double[][] getYRotationMatrix(double angle) {
		double radiansAngle = Math.toRadians(angle);
		double[][] matrix =  {
				{Math.cos(radiansAngle), 0, -Math.sin(radiansAngle),0},
				{0,1,0,0},
				{Math.sin(radiansAngle),0,Math.cos(radiansAngle),0},
				{0,0,0,1}
		};
		return matrix;
	}
	
	public double[][] getXRotationMatrix(double angle) {
		double radiansAngle = Math.toRadians(angle);
		double[][] matrix =  {
				{1,0,0,0},
				{0,Math.cos(radiansAngle),-Math.sin(radiansAngle),0},
				{0,Math.sin(radiansAngle),Math.cos(radiansAngle),0},
				{0,0,0,1}
		};
		return matrix;
	}
}
