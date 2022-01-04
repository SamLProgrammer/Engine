package views;

import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.JFrame;

import models.PVector;

public class MainFrame extends JFrame{
	
	private FigurePanel figurePanel;

	public MainFrame(LinkedList<PVector> figurePoints, int[][] indexedVertexes, int[] indexedLines) {
		initProperties();
		initComponents(figurePoints, indexedVertexes, indexedLines);
	}

	private void initComponents(LinkedList<PVector> figurePoints, int[][] indexedVertexes, int[] indexedLines) {
		figurePanel = new FigurePanel(figurePoints, indexedVertexes, indexedLines);
		add(figurePanel);
	}

	private void initProperties() {
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setSize(width,height);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void refreshFigurePanel(LinkedList<PVector> figurePoints) {
		figurePanel.refreshFigure(figurePoints);
	}
	
}
