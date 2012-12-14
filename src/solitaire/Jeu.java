package solitaire;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Jeu {

	public static void main(String[] args) {

		JFrame jeu = new JFrame();

		class fond extends JPanel {
			private Image image;

			public fond() {
				image = Toolkit.getDefaultToolkit().getImage("images/fond.gif");
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage (image, 0, 0, null);
				repaint();
			}
		}

		jeu.setContentPane(new fond());

		jeu.setTitle("Projet Java - Solitaire - Janvier 2013");
		PlateauTech plateau = new PlateauTech();
		Menu menu = new Menu(plateau);
		
		PlateauUI pUI = new PlateauUI(plateau);

		

		jeu.add(menu, BorderLayout.NORTH);

		jeu.add(pUI, BorderLayout.CENTER);
		
		jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeu.setResizable(false);
		jeu.setSize(500,500);
		jeu.setLocationRelativeTo(null);
		
		jeu.setVisible(true);
	}
}