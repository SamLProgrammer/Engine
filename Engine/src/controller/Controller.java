package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Timer;

import models.PVector;
import models.Rotator;
import views.MainFrame;

public class Controller {

	private MainFrame mainFrame;
	private Rotator rotator;
	private Timer rotationTimer;

	public Controller() {
		initComponents();
	}

	private void initComponents() {
		rotator = new Rotator();
		mainFrame = new MainFrame(rotator.getFigure().getFigurePoints(), rotator.getFigure().getFigureTrianglesIndexes(), rotator.getFigure().getFigureLines());
		initRotationTimer();
	}

	public void initRotationTimer() {
		rotationTimer = new Timer(20, new ActionListener() {
			double angle = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(angle == 360) {
					angle = 0;
				}
				rotator.setAngle(angle++);
				LinkedList<PVector> points = rotator.getFigure().getFigurePointsCopy();
				mainFrame.refreshFigurePanel(
						rotator.translateFigurePoints(
						rotator.projectFigurePoints(
						rotator.rotateFigureY(rotator.rotateFigureX(
						rotator.rotateFigureZ(points)))), 650, 350));
			}
		});
		rotationTimer.start();
	}
}
