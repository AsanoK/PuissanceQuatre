package puissance4;
/**
 * Plateau de jeu.
 * Classe abstraite qui sera divisée entre plateau à 1 ou 2 joueurs
 * @author Hugin
 *
 */
public class Plateau {

public final static int VIDE = 0;
public final static int BLEU = 1;
public final static int ORANGE = 2;
	
private int[][] plateau;


public Plateau(){
	plateau = new int[7][6];
    for (int col = 0; col < 6 ; col++) {
      for (int ligne = 0; ligne < 7; ligne++) {
        plateau[col][ligne] = VIDE;
      }
    }
}
public boolean victoire() {
	    // Vérifie les horizontales
	    for (int ligne = 0; ligne < 7; ligne++) {
	      if (verifierpions(0, ligne, 1, 0)) {
	        return true;
	      }
	    }

	    // Vérifie les verticales 
	    for (int col = 0; col < 6; col++) {
	      if (verifierpions(col, 0, 0, 1)) {
	        return true;
	      }
	    }

	    // Diagonales (cherche depuis la ligne du bas)
	    for (int col = 0; col < 6; col++) {
	      // Diagonale de gauche à droite ( / )
	      if (verifierpions(col, 0, 1, 1)) {
	        return true;
	      }
	      // Diagonale de droite à gauche ( \ )
	      if (verifierpions(col, 0, -1, 1)) {
	        return true;
	      }
	    }

	    // Diagonales (cherche depuis les colonnes gauches et droites)
	    for (int ligne = 0; ligne < 7; ligne++) {
	      //Diagonale de gauche à droite ( / )
	      if (verifierpions(0, ligne, 1, 1)) {
	        return true;
	      }
	      // Diagonale de droite à gauche ( \ )
	      if (verifierpions(5, ligne, -1, 1)) {
	        return true;
	      }
	    }

	    // sinon
	    return false;
	  }

	  /**
	    Cette méthode cherche 4 pions alignés sur une ligne. Cette ligne est définie par
	    le point de départ, ou origine de coordonnées (oCol,oLigne), et par le déplacement
	    delta (dCol,dLigne). En utilisant des valeurs appropriées pour dCol et dLigne
	    on peut vérifier toutes les directions:
	   - horizontale:    dCol = 0, dLigne = 1
	   - vérticale  :    dCol = 1, dLigne = 0
	   - Diagonale /: dCol = 1, dLigne = 1
	   - Diagonale \: dCol = 1, dLigne = -1
	   *
	   * @param oCol   Colonne d'origine de la recherche
	   * @param oLigne Ligne d'origine de la recherche
	   * @param dCol   Direction de déplacement sur une colonne
	   * @param dLigne Direction de déplacement sur une ligne
	   * @return true si on trouve un alignement
	   */
	  private boolean verifierpions(int oCol, int oLigne, int dCol, int dLigne) {
	    int couleur = VIDE;
	    int compteur = 0;

	    int curCol = oCol;
	    int curRow = oLigne;

	    while ((curCol >= 0) && (curCol < 6) && (curRow >= 0) && (curRow < 7)) {
	      if (plateau[curRow][curCol] != couleur) {
	        // Si la couleur change, on réinitialise le compteur
	        couleur = plateau[curRow][curCol];
	        compteur = 1;
	      } else {
	        // Sinon on l'incrémente
	        compteur++;
	      }

	      // On sort lorsque le compteur atteint 4
	      if ((couleur != VIDE) && (compteur == 4)) {
	        return true;
	      }

	      // On passe à l'itération suivante
	      curCol += dCol;
	      curRow += dLigne;
	    }

	    // Aucun alignement n'a été trouvé
	    return false;
	  }

	  /**
	   * Vérifie s'il est encore possible de placer des pions
	   **/
	  public boolean PlateauPlein() {
	    // On cherche une case vide. S'il n'y en a plus, le plateau  est plein
	    for (int col = 0; col < 6; col++) {
	      for (int ligne = 0; ligne < 7; ligne++) {
	        if (plateau[col][ligne] == VIDE) {
	          return false;
	        }
	      }
	    }

	    return true;
	  }



public void jouer(int j, int col){
	if(verifier(col)==true){
		effectuer(j,col);
	}
}
private boolean verifier(int col){
	if ((col < 0) || (col >= 6)){
	return false;}
	return true;
}
private boolean effectuer(int j, int col){
	for (int ligne = 0; ligne < 7; ligne++) {
	      if (plateau[col][ligne] == VIDE) {
	        plateau[col][ligne] = j;
	        return true;
	      }
}
	return false;
}
}