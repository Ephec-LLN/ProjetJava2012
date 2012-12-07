package solitaire;

/**
 * @author Laurent et Jonathan
 *@PlateauTech une classe qui g�re le plateau niveau technique.
 *Le plateauUI sera dans une autre classe
 */

public class PlateauTech {

	private int nombreCoups = 0;
	private int nombrePions = 32;   // initial : 32 pions
	private int[][] tabPions = new int [7][7];

	public PlateauTech(){
		initPlateau();
	} //Fin PlateauTech

	// 1 = Pion prŽsent ; 0 = Pion absent ; -1 = Pion interdit
	public void initPlateau(){
		for (int i = 0; i < 7 ; i++){
			for (int j = 0; j < 7; j++){
				tabPions[i][j] = 1;
			}
		}
		for (int i=0; i < 2; i++){
			for (int j=0; j<2; j++){
				tabPions[i][j] = -1;
			}
			for (int j=5; j<7; j++){
				tabPions[i][j] = -1;
			}
		}
		for (int i=5; i < 7; i++){
			for (int j=0; j<2; j++){
				tabPions[i][j] = -1;
			}
			for (int j=0; j<2; j++){
				tabPions[i][j] = -1;
			}
		}
		tabPions[3][3] = 0; //Pas de pion au centre du plateau
	} // fin initPlateau

	public void recommencer(){
		initPlateau();
		this.nombreCoups = 0;
		this.nombrePions = 32;
	}

	public int sautPion(int x1, int y1, int x2, int y2){
		int xM = (x1+x2)/2; // coordonnŽe en x du pion au dessus duquel on saute
		int yM = (x1+x2)/2; // coordonnŽe en y du pion au dessus duquel on saute

		if ((x1 == x2 && Math.abs(y1 - y2) == 2 && tabPions[xM][yM] == 1 && tabPions[xM][yM] == 1 && tabPions[x2][y2] == 0)||(y1 == y2 && Math.abs(x1 - x2) == 2 && tabPions[xM][yM] == 1 && tabPions[x2][y2] == 0)) {
			tabPions[x1][y1] = 0;
			tabPions[xM][yM] = 0;
			tabPions[x2][y2] = 1;
			setNombreCoups(getNombreCoups() + 1);
			nombrePions--;
			return 1;
		} else return -1;

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