package solitaire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * Classe constituant l'aspect visuel du programme
 * @author Laurent & Jonathan
 */
public class PlateauUI extends JPanel {


	private static final long serialVersionUID = 745306872625426774L;
	private PlateauTech plateauTech;
	private Pion PionSelect = null;
	private int nbLignes=7;
	private int nbColonnes=7;
	
	/** Tableau contenant un certain nombre de cases "pion" */
	private Pion[][] tabPions = new Pion[nbColonnes][nbLignes];
	/**
	 * Tableau reprenant les differents chemins des images utilisees
	 */
	private String[] tabCheminImg = {"images/jonathan.gif","images/laurent.gif", "images/solitaireVidesTransp.gif"};

	public PlateauUI(PlateauTech pT){


		this.plateauTech = pT;
		GridBagLayout JPanel1Layout = new GridBagLayout();
		setLayout(JPanel1Layout);
		this.setOpaque(false);


		GridBagConstraints gridbag;

		for (int i = 0; i < 7; i++) {
			for( int j = 0; j<7; j++)  {
				gridbag = new GridBagConstraints(i, j, 1, 1, 0.0, 0.0, 
						GridBagConstraints.CENTER, 
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
				tabPions[i][j] = new Pion(i,j);
				tabPions[i][j].setBorder(null);
				tabPions[i][j].setContentAreaFilled(false);
				tabPions[i][j].addMouseListener(tabPions[i][j]);
				tabPions[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
				JPanel1Layout.setConstraints(tabPions[i][j],gridbag);
				this.add(tabPions[i][j]);
			}
		}
		majPlateau();
	}

	/**
	 * methode permettant de garder a jour les images constituant le JButton
	 */
	public void majPlateau() {


		for(int i = 0;i <7; i++) {
			for (int j = 0; j<7; j++) {
				if((i+j)%2==0){
					tabPions[i][j].setVisible(true);
					if(plateauTech.tabPions[i][j] == 1) {
						tabPions[i][j].setIcon(new ImageIcon(tabCheminImg[0]));
					}
					else {
						if (plateauTech.tabPions[i][j] == 0) {
							tabPions[i][j].setIcon(new ImageIcon(tabCheminImg[2]));
						}
						else {
							tabPions[i][j].setVisible(false);
						}
					}
				} 
				else {
					tabPions[i][j].setVisible(true);
					if(plateauTech.tabPions[i][j] == 1) {
						tabPions[i][j].setIcon(new ImageIcon(tabCheminImg[1]));
					}
					else {
						if (plateauTech.tabPions[i][j] == 0) {
							tabPions[i][j].setIcon(new ImageIcon(tabCheminImg[2]));
						}
						else {
							tabPions[i][j].setVisible(false);
						}
					}
				}
			}
		}



	}
	
	/**
	 * Classe etendue d'un JButton implementant un MouseListener et definissant la dimension des cases "pion"
	 * @author Laurent & Jonathan
	 *
	 */
	public class Pion extends JButton implements MouseListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		int l;    	//Ligne
		int c;		//Colonne

		public Pion(int ligne, int colonne) {
			l = ligne;
			c = colonne;
			setPreferredSize(new Dimension(61,61));
			setSize(getPreferredSize());

		}


		@Override
		public void mouseClicked(MouseEvent arg0) {

			if (PionSelect == null && plateauTech.tabPions[this.l][this.c] == 1)  {
				PionSelect = this;
				PionSelect.setBorder(BorderFactory.createLineBorder(Color.BLUE,4));
			} 
			else
			{
				if ((plateauTech.sautPion(PionSelect.l,PionSelect.c,this.l,this.c) == 1)){
					PionSelect.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
					PionSelect = null;
				}
				else {
					PionSelect.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
					PionSelect = this;
					if (plateauTech.tabPions[this.l][this.c] == 1){
						this.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
					}
				}	
			}
			majPlateau();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

			if (this != PionSelect){
				this.setBorder(BorderFactory.createLineBorder(Color.GREEN,4));
			}
			majPlateau();
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

			if (this != PionSelect){
				this.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
			}
			majPlateau();
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}

