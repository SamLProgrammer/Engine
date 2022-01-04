package models;

import java.awt.Toolkit;

public class ProjectionMatrix {

	private double[][] projectionMatrix;
	private double aspectRatio;
	private static final double FIELD_OF_VIEW = Math.PI / 2;
	private static final double Z_FAR = 1;
	private static final double Z_NEAR = -1;
	private static final double FOV = Math.atan(FIELD_OF_VIEW);

	public ProjectionMatrix() {
		initAspectRatio();
		initProjectionMatrix();
	}

	private void initAspectRatio() {
		aspectRatio = (float) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / Toolkit.getDefaultToolkit().getScreenSize().getWidth());
	}

	public double[][] initProjectionMatrix() {
		double[][] matrix = new double[4][4];
		matrix[0][0] = aspectRatio * FOV * 100;
		matrix[1][1] = FOV * 100;
		matrix[2][2] = (-((Z_NEAR + Z_FAR) / (Z_NEAR - Z_FAR)));
		matrix[2][3] = (2 * (Z_FAR * Z_NEAR) / (Z_NEAR - Z_FAR));
		matrix[3][2] = 1;
		projectionMatrix = matrix;
		return matrix;
	}

	public double[][] getProjectionMatrix() {
		return projectionMatrix;
	}
}
