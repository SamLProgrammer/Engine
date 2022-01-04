package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.JPanel;
import models.PVector;

public class FigurePanel extends JPanel {

	private LinkedList<PVector> figurePoints;
	private int[] figureIndexes;
	private int[][] indexedVertexes;
	private static final Color[] COLOR_CONSTANT = {Color.green, Color.yellow, Color.pink,
			Color.orange, Color.magenta, Color.blue, Color.white, Color.gray, Color.red,
			Color.pink, Color.green, Color.yellow};

	public FigurePanel(LinkedList<PVector> figurePoints, int[][] indexedVertexes, int[] figureIndexes) {
		this.figurePoints = figurePoints;
		this.indexedVertexes = indexedVertexes;
		this.figureIndexes = figureIndexes;
		initProperties();
	}

	private void initProperties() {
		setBackground(Color.black);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		paintFigurePoints(g2);
		paintFigureLines(g2);
	}

	public void paintFigurePoints(Graphics2D g2) {
		for (PVector pVector : figurePoints) {
			g2.setColor(Color.red);
			g2.fillOval((int) (pVector.getX()-5), (int) (pVector.getY()-5), 10, 10);
		}
	}

	public void paintFigureLines(Graphics2D g2) {
		for(int i = 0; i < figureIndexes.length; i++) {			
			g2.drawLine((int) figurePoints.get(figureIndexes[i]).getX(), (int) figurePoints.get(figureIndexes[i]).getY(),
					(int) figurePoints.get(figureIndexes[++i]).getX(), (int) figurePoints.get(figureIndexes[i]).getY());
		}

//		for (int i = 0; i < indexedVertexes.length; i++) {
//			g2.setColor(COLOR_CONSTANT[i]);
//			drawTriangle(g2, figurePoints.get(indexedVertexes[i][0]),
//					figurePoints.get(indexedVertexes[i][1]),
//					figurePoints.get(indexedVertexes[i][2]));
//		}
	}
	
	public void drawTriangle(Graphics2D g2, PVector point1, PVector point2, PVector point3) {
		int[] xVector = {(int) point1.getX(), (int) point2.getX(), (int) point3.getX()};
		int[] yVector = {(int) point1.getY(), (int) point2.getY(), (int) point3.getY()};
		g2.fillPolygon(xVector, yVector, 3);
	}
	
	public void refreshFigure(LinkedList<PVector> figurePoints) {
		this.figurePoints = figurePoints;
		removeAll();
		repaint();
	}
}
