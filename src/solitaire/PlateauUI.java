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

	private PlateauTech plateauTech;
	private Pion PionSelect = null;
	private int nbLignes=7;
	private int nbColonnes=7;
	private Pion[][] plateau = new Pion[nbColonnes][nbLignes];

	public PlateauUI(PlateauTech pT){

		this.plateauTech = pT;

		GridBagLayout Layout = new GridBagLayout();
		setLayout(Layout);


		GridBagConstraints g;

		for (int i = 0; i < 7; i++) {
			for( int j = 0; j<7; j++)  {
				g = new GridBagConstraints(i, j, 1, 1, 0.0, 0.0, 
						GridBagConstraints.CENTER, 
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
				plateau[i][j] = new Pion(i,j);
				plateau[i][j].addMouseListener(plateau[i][j]);
				Layout.setConstraints(plateau[i][j],g);
				this.add(plateau[i][j]);
				if (plateauTech.tabPions[i][j] == -1){
					plateau[i][j].setVisible(false);
				}
			}
		}
		majPlateau();
	}

	public void majPlateau() {
		for(int i = 0;i <7;i++) {
			for (int j = 0; j<7; j++) {
				plateau[i][j].setIcon(new ImageIcon("images/solitairePions.gif"));
				if (plateauTech.tabPions[i][j] == 0) 	
					plateau[i][j].setIcon(new ImageIcon("images/solitaireVides.gif"));
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

