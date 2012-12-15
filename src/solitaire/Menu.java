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
	private int choix = 1;
	private int choixImg;
	private boolean pionNormal = true;
	private String[] tabCheminImg = {"images/solitairePionsTransp.gif", "images/solitaireVidesTransp.gif", "images/laurent.gif"};

	

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

		JMenuItem partie = new JMenuItem("Nouvelle Partie");
		partie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Recommencer?", "Nouvelle Partie",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					plateau.choixPlateau(choix);
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
		this.add(aide);

		JMenuItem apd = new JMenuItem("A propos");
		apd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Decembre 2012\nAuteurs : Jonathan et Laurent","A propos",JOptionPane.INFORMATION_MESSAGE);
			}
		});	
		this.add(apd);

		JMenu perso = new JMenu("Personnalisation");
		JMenu submenu = new JMenu("Plateau");

		JMenuItem croix = new JMenuItem("Croix");
		croix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				choix = 1;
				plateau.choixPlateau(choix);
				repaint();
				revalidate();
			}
		});	
		submenu.add(croix);

		JMenuItem carre = new JMenuItem("Carre");
		carre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				choix = 2;
				plateau.choixPlateau(choix);
				System.out.println("carre");
				repaint();
				revalidate();
			}
		});

		submenu.add(carre);

		JMenuItem coeur = new JMenuItem("Coeur");
		coeur.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				choix = 3;
				plateau.choixPlateau(choix);
				repaint();
				revalidate();
			}
		});
		submenu.add(coeur);


		JMenuItem moz = new JMenuItem("Mozaique");
		moz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				choix = 4;
				plateau.choixPlateau(choix);
				repaint();
				revalidate();				
			}
		});
		submenu.add(moz);

		JMenuItem smiley = new JMenuItem("Smiley");
		smiley.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				choix = 5;
				plateau.choixPlateau(choix);
				repaint();
				revalidate();					
			}
		});
		submenu.add(smiley);
		perso.add(submenu);
		JMenu submenu2 = new JMenu("Pions");

		JMenuItem normal = new JMenuItem("Pions normaux");
		normal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setChoixImg(0);
				System.out.println(getChoixImg());

				System.out.println("pion normal");
			}
		});	
		submenu2.add(normal);
		JMenuItem laurent = new JMenuItem("Pions Laurent");
		laurent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setChoixImg(2);
				System.out.println(getChoixImg());
				System.out.println("pion Laurent Menu");
			}
		});	
		submenu2.add(laurent);
		perso.add(submenu2);
		this.add(perso);
	}


	public int getChoixImg() {
		return choixImg;
	}


	public int getChoix() {
		return choix;
	}


	public void setChoixImg(int choixImg) {
		
		this.choixImg = choixImg;
	}


	public void setChoix(int choix) {
		this.choix = choix;
	}
	






/*	public void choixPlateau(int choix){
		switch (choix) {
		case 1 : pUI.majPlateau();plateau.initPlateauCroix(); break;
		case 2 : pUI.majPlateau();plateau.initPlateauCarre();break;
		case 3 : pUI.majPlateau();plateau.initPlateauCoeur();break;
		case 4 : pUI.majPlateau();plateau.initPlateauMoz();break;
		case 5 : pUI.majPlateau();plateau.initPlateauSmiley();break;
		}
	}*/



}