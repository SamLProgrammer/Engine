package models;

import java.util.LinkedList;

public class Rotator {

	private LinkedList<PVector> projectedPoints;
	private Figure figure;
	private ProjectionMatrix pm;
	private MatrixOperations mo;
	private Rotations r;
	private double angle;

	public Rotator() {
		initComponents();
	}

	public void initComponents() {
		initPointsLists();
		figure = new Figure();
		pm = new ProjectionMatrix();
		mo = new MatrixOperations();
		r = new Rotations();
	}

	private void initPointsLists() {
		projectedPoints = new LinkedList<PVector>();
	}

	public LinkedList<PVector> projectFigurePoints(LinkedList<PVector> figurePoints) {
		for (PVector vector : figurePoints) {
			mo.multiplyMatrixByVector(pm.getProjectionMatrix(), vector);
		}
		return figurePoints;
	}

	public LinkedList<PVector> translateFigurePoints(LinkedList<PVector> figurePoints, int positionX, int positionY) {
		for (PVector pVector : figurePoints) {
			if (pVector.getW() != 0) {
				pVector.setW(pVector.getW() + 0.8);
				pVector.setX(pVector.getX() / pVector.getW() + positionX);
				pVector.setY(pVector.getY() / pVector.getW() + positionY);
			}
		}
		return figurePoints;
	}
	
	public LinkedList<PVector> rotateFigureX(LinkedList<PVector> figurePoints) {
		for (PVector pVector : figurePoints) {
			XrotateVector(pVector, angle);
		}
		return figurePoints;
	}
	
	public LinkedList<PVector> rotateFigureY(LinkedList<PVector> figurePoints) {
		for (PVector pVector : figurePoints) {
			YrotateVector(pVector, angle);
		}
		return figurePoints;
	}
	
	public LinkedList<PVector> rotateFigureZ(LinkedList<PVector> figurePoints) {
		for (PVector pVector : figurePoints) {
			ZrotateVector(pVector, angle);
		}
		return figurePoints;
	}
	
	private void XrotateVector(PVector vector, double angle) {
		mo.multiplyMatrixByVector(r.getXRotationMatrix(angle), vector);
	}
	
	private void YrotateVector(PVector vector, double angle) {
		mo.multiplyMatrixByVector(r.getYRotationMatrix(angle), vector);
	}
	
	private void ZrotateVector(PVector vector, double angle) {
		mo.multiplyMatrixByVector(r.getZRotationMatrix(angle), vector);
	}

	public LinkedList<PVector> getProjectedPoints() {
		return projectedPoints;
	}

	public void setProjectedPoints(LinkedList<PVector> projectedPoints) {
		this.projectedPoints = projectedPoints;
	}

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public ProjectionMatrix getPm() {
		return pm;
	}

	public void setPm(ProjectionMatrix pm) {
		this.pm = pm;
	}

	public MatrixOperations getMo() {
		return mo;
	}

	public void setMo(MatrixOperations mo) {
		this.mo = mo;
	}

	public Rotations getR() {
		return r;
	}

	public void setR(Rotations r) {
		this.r = r;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
}
