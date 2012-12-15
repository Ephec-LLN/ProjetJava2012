package solitaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private PlateauTech plateau;
	private PlateauUI pUI;
	private int choix = 1;

	private static final String Aide = "Règles du jeu\n" +
			"-------------\n\n"+
			"Les regles sont simples, vous disposez d'un plateau\n" +
			"en forme de croix, la case centrale etant vide, le\n" +
			"reste est rempli de pions. Pour éliminer un pion,\n" +
			"il suffit de sauter au dessus avec un autre pion. Le\n" +
			"but étant de n'avoir plus qu'un pion, au centre du\n" +
			"plateau.\n\nBon Jeu !";


	public Menu(final PlateauTech plateau) {
		super();
		this.plateau = plateau;
		pUI = new PlateauUI(plateau);

		JMenuItem partie = new JMenuItem("Nouvelle Partie");
		partie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Recommencer?", "Nouvelle Partie",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choixPlateau(choix);
				}
			}
		});
		this.add(partie);

		JMenuItem aide = new JMenuItem("Aide");
		aide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,Aide,"Aide",JOptionPane.INFORMATION_MESSAGE);
			}
		});	

		JMenuItem apd = new JMenuItem("A propos");
		apd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Decembre 2012\nAuteurs : Jonathan et Laurent","A propos",JOptionPane.INFORMATION_MESSAGE);
			}
		});	

		JMenu perso = new JMenu("Personnalisation");
		JMenu submenu = new JMenu("Plateau");
		
		JMenuItem croix = new JMenuItem("Croix");
		croix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 1;
					choixPlateau(choix);
				}
				repaint();
				revalidate();
			}
		});	
		submenu.add(croix);

		JMenuItem carre = new JMenuItem("Carre");
		carre.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						choix = 2;
						choixPlateau(choix);
					}
					repaint();
					revalidate();
				}
		});

		submenu.add(carre);

		JMenuItem coeur = new JMenuItem("Coeur");
		coeur.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 3;
					choixPlateau(choix);
				}
				repaint();
				revalidate();
			}
		});
		submenu.add(coeur);


		JMenuItem moz = new JMenuItem("Mozaique");
		moz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 4;
					choixPlateau(choix);
				}
				repaint();
				revalidate();				
			}
		});
		submenu.add(moz);

		JMenuItem smiley = new JMenuItem("Smiley");
		smiley.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 5;
					choixPlateau(choix);
				}
				repaint();
				revalidate();					
			}
		});
		submenu.add(smiley);
		perso.add(submenu);
		this.add(perso);
		this.add(aide);
		this.add(apd);
	}

	public void choixPlateau(int choix){
		switch (choix) {
		case 1 : pUI.majPlateau();plateau.initPlateauCroix(); break;
		case 2 : pUI.majPlateau();plateau.initPlateauCarre();break;
		case 3 : pUI.majPlateau();plateau.initPlateauCoeur();break;
		case 4 : pUI.majPlateau();plateau.initPlateauMoz();break;
		case 5 : pUI.majPlateau();plateau.initPlateauSmiley();break;
		}
	}

}