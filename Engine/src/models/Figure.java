package models;

import java.util.LinkedList;

public class Figure {

	private LinkedList<PVector> figurePoints;

	public Figure() {
		initFigurePoints();
	}

	private void initFigurePoints() {
		figurePoints = new LinkedList<PVector>();
		
		figurePoints.add(new PVector(-0.25, -0.25, -0.25, 1));
		figurePoints.add(new PVector(-0.25, 0.25, -0.25, 1));
		figurePoints.add(new PVector(0.25, 0.25, -0.25, 1));
		figurePoints.add(new PVector(0.25, -0.25, -0.25, 1));
		
		figurePoints.add(new PVector(-0.25, -0.25, 0.25, 1));
		figurePoints.add(new PVector(-0.25, 0.25, 0.25, 1));
		figurePoints.add(new PVector(0.25, 0.25, 0.25, 1));
		figurePoints.add(new PVector(0.25, -0.25, 0.25, 1));
	}
	
	public int[] getFigureLines() {
		int[] indexes = {
			0,1, 1,2, 2,3, 3,0,
			4,7, 4,5, 5,6, 6,7,
			1,5, 0,4, 2,6, 3,7 
		};
		return indexes;
	}
	
	
	public int[][] getFigureTrianglesIndexes() {
		int[][] indexes = {
				//front
				{0,1,2},{0,2,3},
				//right
				{3,2,6},{3,6,7},
				//left
				{4,5,1},{4,1,0},
				//behind
				{7,6,5},{7,5,4},
				//above
				{1,5,6},{1,6,2},
				//below
				{4,0,3},{4,3,7}
				};
		return indexes;
	}
	
	public LinkedList<PVector> getFigurePointsCopy() {
		LinkedList<PVector> figurePointsCopy = new LinkedList<PVector>();
		for (PVector pVector : figurePoints) {
			figurePointsCopy.add(new PVector(pVector.getX(), pVector.getY(), pVector.getZ(), pVector.getW()));
		}
		return figurePointsCopy;
	}
	
	public LinkedList<PVector> getFigurePoints() {
		return figurePoints;
	}
}
