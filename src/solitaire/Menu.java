package solitaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


/**
 * Classe constituant la barre du menu se situant en haut de la JFrame du programme
 * @author Laurent et Jonathan
 */
public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private PlateauTech plateau;

	/** Variable qui sera utilisé pour déterminer quel plateau il faudra initialiser */
	private int choix = 1;

	/** The Constant Aide. */
	private static final String Aide = "Règles du jeu\n" +
			"-------------\n\n"+
			"Les regles sont simples, vous disposez d'un plateau\n" +
			"en forme de croix, la case centrale etant vide, le\n" +
			"reste est rempli de pions. Pour éliminer un pion,\n" +
			"il suffit de sauter au dessus avec un autre pion. Le\n" +
			"but étant de n'avoir plus qu'un pion, au centre du\n" +
			"plateau.\n\nBon Jeu !";


	/**
	 * Instancie un nouveau menu.
	 *
	 * @param PlateauTech Plateau Technique
	 */
	public Menu(PlateauTech plateau) {
		super();
		this.plateau = plateau;

		JMenuItem partie = new JMenuItem("Recommencer");
		partie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
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
		aide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
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
		croix.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
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
		carre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
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
		coeur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
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
		moz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
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
		smiley.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
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

	/**
	 * procédure permettant d'initialiser un plateau à partir du choix sélectionné
	 *
	 * @param choix qui est modifié par les ActionListener du menu Plateau de Personnalisation
	 */
	public void choixPlateau(int choix){
		switch (choix) {
		case 1 : plateau.initPlateauCroix(); break;
		case 2 : plateau.initPlateauCarre();break;
		case 3 : plateau.initPlateauCoeur();break;
		case 4 : plateau.initPlateauMoz();break;
		case 5 : plateau.initPlateauSmiley();break;
		}
	}

}