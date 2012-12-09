package solitaire;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Jeu {

	public static void main(String[] args) {

		JFrame jeu = new JFrame();
		jeu.setTitle("Projet Java - Solitaire - Janvier 2013");
		PlateauTech plateau = new PlateauTech();
		Menu men = new Menu(plateau);
		try {
			jeu.add(new JLabel(new ImageIcon(ImageIO.read(new File("images/fond.gif")))));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		jeu.add(men, BorderLayout.NORTH);
		jeu.pack();
		jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeu.setResizable(false);
		jeu.setSize(600,600);
		jeu.setLocationRelativeTo(null);
		jeu.setVisible(true);
	}
}