package solitaire;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * classe etendue d'un JPanel permettant d'obtenir une image de fond pour le jeu
 * @author Laurent & Jonathan
 */

class Fond extends JPanel {

	private static final long serialVersionUID = -5662048289905636355L;
	private Image image;

	public Fond() {
		image = Toolkit.getDefaultToolkit().getImage("images/fond.gif");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage (image, 0, 0, null);
		repaint();
	}
}	