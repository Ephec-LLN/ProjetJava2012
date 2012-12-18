package solitaire;

/**
 * genere le plateau de jeu au niveau technique.
 * @author Laurent et Jonathan
 */

public class PlateauTech {

	private Menu menu;

	/**
	 * tableau contenant des entiers qui permettent de déterminer si une case 
	 * contient un pion (1), n'en contient pas (0) ou est inaccessible (-1)
	 */
	protected int[][] tabPions = new int [7][7];

	public PlateauTech(){
		menu = new Menu(this);
		menu.choixPlateau(1);
	} //Fin PlateauTech

	// 1 = Pion present ; 0 = Pion absent ; -1 = Pion interdit
	/**
	 * initialise un plateau en forme de croix
	 */
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
	/**
	 * initialise un plateau en forme de carré
	 */
	public void initPlateauCarre(){
		for (int i = 0; i < 7 ; i++){
			for (int j = 0; j < 7; j++){
				tabPions[i][j] = 1;		// mettre des pions dans toutes les cases
			}
		}
		tabPions[3][3] = 0;
	}
	/**
	 * initialise un plateau en forme de coeur
	 */
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
	/**
	 * initialise un plateau en forme de mozaïque
	 */
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
	/**
	 * initialise un plateau en forme de smiley
	 */
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

	/**
	 * permet de jouer un coup
	 * @param x1 ligne du pion de départ
	 * @param y1 colonne du pion de départ
	 * @param x2 ligne du pion après le "saut"
	 * @param y2 colonne du pion après le "saut"
	 * @return 1 si possiblité de "sauter" un pion, 0 sinon
	 */
	public int sautPion(int x1, int y1, int x2, int y2){
		int xM = (x1+x2)/2; // coordonnee en x du pion au dessus duquel on saute
		int yM = (y1+y2)/2; // coordonnee en y du pion au dessus duquel on saute

		if ((x1 == x2 && Math.abs(y1 - y2) == 2 && tabPions[x1][y1] == 1 && tabPions[xM][yM] == 1 && tabPions[x2][y2] == 0)||(y1 == y2 && Math.abs(x1 - x2) == 2 && tabPions[x1][y1] == 1 && tabPions[xM][yM] == 1 && tabPions[x2][y2] == 0)) {
			tabPions[x1][y1] = 0;    // on "efface" le pion de départ
			tabPions[xM][yM] = 0;	 // on "efface" le pion "sauté"
			tabPions[x2][y2] = 1;	 // on "ajoute" le pion de l'arrivée
			return 1;
		} else return -1;

	}
}