package solitaire;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;



public class Jeu {

	public static void main(String[] args) {

		JFrame jeu = new JFrame();
		jeu.setTitle("Projet Java - Solitaire - Janvier 2013");
		PlateauTech plateau = new PlateauTech();

		PlateauUI pUI = new PlateauUI(plateau);
		
		Menu menu = new Menu(plateau);
		
		jeu.setBackground(Color.ORANGE);
		
		jeu.add(menu, BorderLayout.NORTH);
		
		jeu.add(pUI, BorderLayout.CENTER);
		
		jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeu.setResizable(false);
		jeu.setSize(600,600);
		jeu.setLocationRelativeTo(null);
		jeu.setVisible(true);
	}
}