package solitaire;

/**
 * @author Laurent et Jonathan
 *@PlateauTech une classe qui genere le plateau niveau technique.
 *Le plateauUI sera dans une autre classe
 */

public class PlateauTech {

	private int nombreCoups = 0;
	private int nombrePions = 32;   // initial : 32 pions
	private Menu menu;
	private PlateauUI pUI;

	protected int[][] tabPions = new int [7][7];

	public PlateauTech(){
		menu = new Menu(this);
		pUI = new PlateauUI(this);
		choixPlateau(1);
		System.out.println("initdébutPlateau");
	} //Fin PlateauTech

	// 1 = Pion present ; 0 = Pion absent ; -1 = Pion interdit
	public void initPlateauCroix(){
		for (int i = 0; i < 7 ; i++){
			for (int j = 0; j < 7; j++){
				tabPions[i][j] = 1;		// mettre des pions dans toutes les cases
			}
		}
		for (int i=0; i < 2; i++){
			for (int j=0; j<2; j++){
				tabPions[i][j] = -1; 	// mettre les cases inaccessibles en mode "pion interdit" 
			}
			for (int j=5; j<7; j++){
				tabPions[i][j] = -1;	// mettre les cases inaccessibles en mode "pion interdit" 
			}
		}
		for (int i=5; i < 7; i++){
			for (int j=0; j<2; j++){
				tabPions[i][j] = -1;	// mettre les cases inaccessibles en mode "pion interdit" 
			}
			for (int j=5; j<7; j++){
				tabPions[i][j] = -1;	// mettre les cases inaccessibles en mode "pion interdit" 
			}
		}
		tabPions[3][3] = 0; //Pas de pion au centre du plateau
	} // fin initPlateau

	public void initPlateauCarre(){
		for (int i = 0; i < 7 ; i++){
			for (int j = 0; j < 7; j++){
				tabPions[i][j] = 1;		// mettre des pions dans toutes les cases
			}
		}
		tabPions[3][3] = 0;
	}

	public void initPlateauCoeur(){
		for (int i = 0; i < 7 ; i++){
			for (int j = 0; j < 7; j++){
				tabPions[i][j] = 1;		// mettre des pions dans toutes les cases
			}
		}
		tabPions[0][0] = -1;
		tabPions[3][0] = -1;
		tabPions[6][0] = -1;
		tabPions[0][3] = -1;
		tabPions[3][3] = 0;
		tabPions[6][3] = -1;
		tabPions[0][5] = -1;
		tabPions[1][5] = -1;
		tabPions[5][5] = -1;
		tabPions[6][5] = -1;
		tabPions[0][4] = -1;
		tabPions[6][4] = -1;
		tabPions[0][6] = -1;
		tabPions[1][6] = -1;
		tabPions[2][6] = -1;
		tabPions[4][6] = -1;
		tabPions[5][6] = -1;
		tabPions[6][6] = -1;		
	}

	public void initPlateauMoz(){
		for (int i = 0; i < 7 ; i++){
			for (int j = 0; j < 7; j++){
				tabPions[i][j] = 1;		// mettre des pions dans toutes les cases
			}
		}
		for (int i = 2; i < 5; i++){
			int j = 0;
			tabPions[i][j] = -1;
		}
		for (int i = 2; i < 5; i++){
			int j = 6;
			tabPions[i][j] = -1;
		}
		for (int j = 2; j < 5; j++){
			int i = 0;
			tabPions[i][j] = -1;
		}
		for (int j = 2; j < 5; j++){
			int i = 6;
			tabPions[i][j] = -1;
		}
		tabPions[2][2] = 0;
		tabPions[2][4] = 0;
		tabPions[4][2] = 0;
		tabPions[4][4] = 0;
		tabPions[3][3] = 0;
	}
	
	public void initPlateauSmiley(){
		for (int i = 0; i < 7 ; i++){
			for (int j = 0; j < 7; j++){
				tabPions[i][j] = 1;		// mettre des pions dans toutes les cases
			}
		}
		tabPions[0][0] = -1;
		tabPions[0][1] = -1;
		tabPions[1][0] = -1;
		tabPions[6][0] = -1;
		tabPions[5][0] = -1;
		tabPions[6][1] = -1;
		tabPions[0][6] = -1;
		tabPions[0][5] = -1;
		tabPions[1][6] = -1;
		tabPions[6][6] = -1;
		tabPions[5][6] = -1;
		tabPions[6][5] = -1;
		tabPions[2][2] = 0;
		tabPions[4][2] = 0;
		for (int i = 2; i<5 ; i++){
			int j = 4;
			tabPions[i][j] = 0;
		}
	}

	public void recommencer(){
		choixPlateau(1);
		System.out.println("recommencer");
		/*this.nombreCoups = 0;
		this.nombrePions = 32;*/
	}

	public int sautPion(int x1, int y1, int x2, int y2){
		int xM = (x1+x2)/2; // coordonnee en x du pion au dessus duquel on saute
		int yM = (y1+y2)/2; // coordonnee en y du pion au dessus duquel on saute

		if ((x1 == x2 && Math.abs(y1 - y2) == 2 && tabPions[x1][y1] == 1 && tabPions[xM][yM] == 1 && tabPions[x2][y2] == 0)||(y1 == y2 && Math.abs(x1 - x2) == 2 && tabPions[x1][y1] == 1 && tabPions[xM][yM] == 1 && tabPions[x2][y2] == 0)) {
			tabPions[x1][y1] = 0;    // on "efface" le pion de départ
			tabPions[xM][yM] = 0;	 // on "efface" le pion "sauté"
			tabPions[x2][y2] = 1;	 // on "ajoute" le pion de l'arrivée
			setNombreCoups(getNombreCoups() + 1);
			nombrePions--;
			return 1;
		} else return -1;

	}
	public void choixPlateau(int choix){
		switch (choix) {
		case 1 : pUI.majPlateau();initPlateauCroix(); break;
		case 2 : pUI.majPlateau();initPlateauCarre();break;
		case 3 : pUI.majPlateau();initPlateauCoeur();break;
		case 4 : pUI.majPlateau();initPlateauMoz();break;
		case 5 : pUI.majPlateau();initPlateauSmiley();break;
		}
	}

	public int getNombrePions() {
		return nombrePions;
	}

	public void setNombrePions(int nombrePions) {
		this.nombrePions = nombrePions;
	}

	public int getNombreCoups() {
		return nombreCoups;
	}

	public void setNombreCoups(int nombreCoups) {
		this.nombreCoups = nombreCoups;
	}



}