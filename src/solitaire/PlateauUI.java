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


public class PlateauUI extends JPanel {


	private static final long serialVersionUID = 745306872625426774L;
	private PlateauTech plateauTech;
	private Pion PionSelect = null;
	private int nbLignes=7;
	private int nbColonnes=7;
	private Pion[][] tabPions = new Pion[nbColonnes][nbLignes];
	private String[] tabCheminImg = {"images/solitairePion.gif", "images/solitaireVide.gif"};

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
				tabPions[i][j].addMouseListener(tabPions[i][j]);
				JPanel1Layout.setConstraints(tabPions[i][j],gridbag);
				this.add(tabPions[i][j]);
				if (plateauTech.tabPions[i][j] == -1){
					tabPions[i][j].setVisible(false);
				}
			}
		}
		majPlateau();
	}

	public void majPlateau() {
		for(int i = 0;i <7;i++) {
			for (int j = 0; j<7; j++) {
				tabPions[i][j].setIcon(new ImageIcon(tabCheminImg[0]));
				if (plateauTech.tabPions[i][j] == 0) 	
					//tabPions[i][j].setIcon(new ImageIcon(tabCheminImg[1]));
					tabPions[i][j].setVisible(false);
					tabPions[i][j].setOpaque(false);
			}
		}
	}
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
				PionSelect.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
			} 
			else
			{
				if ((plateauTech.sautPion(PionSelect.l,PionSelect.c,this.l,this.c) == 1)){
					PionSelect.setBorder(null);
					PionSelect = null;
				}
				else {
					PionSelect.setBorder(null);
					PionSelect = this;
					if (plateauTech.tabPions[this.l][this.c] == 1){
						this.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
					}
				}	
			}
			majPlateau();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			if (this != PionSelect){
				this.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
			}
			majPlateau();
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
			if (this != PionSelect){
				this.setBorder(null);
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

