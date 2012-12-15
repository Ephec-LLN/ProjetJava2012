package solitaire;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Jeu {

	public static void main(String[] args) {

		JFrame jeu = new JFrame();
		PlateauTech plateau = new PlateauTech();
		Menu menu = new Menu(plateau);
		PlateauUI pUI = new PlateauUI(plateau);
		Fond fond = new Fond();

		jeu.setContentPane(fond);
		jeu.setTitle("Projet Java - Solitaire - Janvier 2013");
		jeu.add(menu, BorderLayout.NORTH);
		jeu.add(pUI, BorderLayout.CENTER);
		jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeu.setResizable(false);
		jeu.setSize(500,500);
		jeu.setLocationRelativeTo(null);
		jeu.setVisible(true);
	}
}