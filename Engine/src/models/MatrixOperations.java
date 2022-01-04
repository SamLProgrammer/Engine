package models;

public class MatrixOperations {

	public double[][] multiplyMatrixes(double[][] matrix1, double[][] matrix2) {
		double sum = 0;
		double[][] matrix = new double[matrix1.length][matrix2[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int k = 0; k < matrix.length; k++) {
					sum += matrix1[i][k] * matrix2[k][j];
				}
				matrix[i][j] = sum;
				sum = 0;
			}
		}
		matrix2 = matrix;
		return matrix;
	}
	
	public void multiplyMatrixByVector(double[][] matrix1, PVector pVector) {
		double sum = 0;
		double[][] vectorMatrix = pVector.toMatrix();
		double[][] matrix = new double[matrix1.length][vectorMatrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int k = 0; k < matrix.length; k++) {
					sum += matrix1[i][k] * vectorMatrix[k][j];
				}
				matrix[i][j] = sum;
				sum = 0;
			}
		}
		pVector.setX(matrix[0][0]);
		pVector.setY(matrix[1][0]);
		pVector.setZ(matrix[2][0]);
		pVector.setW(matrix[3][0]);
	}
	
	public double[][] scaleMatrix(double scale) {
		double[][] matrix = {
				{scale,0,0,0},
				{0,scale,0,0},
				{0,0,scale,0},
				{0,0,0,1}
		};
		return matrix;
	}
	
	public PVector transform4VecTo3Vec(double[][] matrix) {
		return new PVector(matrix[0][0], matrix[1][0], matrix[2][0], matrix[3][0]);
	}
}
