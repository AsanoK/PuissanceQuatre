package puissance4;

import javax.swing.JOptionPane;

/**
 * Plateau de jeu qui est une matrix de taille [7][6] de Integer
 * Classe abstraite qui sera divisée entre plateau à 1 ou 2 joueurs
 * @author Hugin
 *
 */
public class Plateau {

public final static int VIDE = 0;
public final static int BLEU = 1;
public final static int ORANGE = 2;
	
private int[][] plateau;

public Plateau (Plateau p){
	plateau = new int[7][6];
    for (int col = 0; col < 7 ; col++) {
      for (int ligne = 0; ligne < 6; ligne++) {
        plateau[col][ligne] = p.getPlateau()[col][ligne];
      }
    }
}
public Plateau(){
	plateau = new int[7][6];
    for (int col = 0; col < 7 ; col++) {
      for (int ligne = 0; ligne < 6; ligne++) {
        plateau[col][ligne] = VIDE;
      }
    }
}

/**
 * Condition gagnante pour terminer le jeu. Il s'agit de vérifier si nous avons 4 pions alignés verticalement, horizontalement ou diagonalement (/ ou \)
*/  	
public boolean victoire() {
	    // Vérifie les horizontales
	    for (int ligne = 0; ligne < 6; ligne++) {
	      if (verifierpions(0, ligne, 1, 0)) {
	        return true;
	      }
	    }

	    // Vérifie les verticales 
	    for (int col = 0; col < 7; col++) {
	      if (verifierpions(col, 0, 0, 1)) {
	        return true;
	      }
	    }

	    // Diagonales (cherche depuis la ligne du bas)
	    for (int col = 0; col < 7; col++) {
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
	    for (int ligne = 0; ligne < 6; ligne++) {
	      //Diagonale de gauche à droite ( / )
	      if (verifierpions(0, ligne, 1, 1)) {
	        return true;
	      }
	      // Diagonale de droite à gauche ( \ )
	      if (verifierpions(6, ligne, -1, 1)) {
	        return true;
	      }
	    }

	    // sinon
	    return false;
	  }

public int[][] getPlateau() {
	return plateau;
}

/**
Cette fonction sert à trouver un alignement de 4 pions. Elle retourne le booléen 	    en prenant comme entrée:  
les coordonnées du point de départ(oCol,oLigne), et par le déplacement
delta (dCol,dLigne). En utilisant des valeurs appropriées pour dCol et dLigne on peut vérifier toutes les directions:
	- horizontale:    dCol = 1, dLigne = 0
	- vérticale  :    dCol = 0, dLigne = 1
	- Diagonale /:    dCol = 1, dLigne = 1
	- Diagonale \:    dCol = -1, dLigne = 1
*/
	  private boolean verifierpions(int oCol, int oLigne, int dCol, int dLigne) {
	    int couleur = VIDE;
	    int compteur = 0;

	    int curCol = oCol;
	    int curRow = oLigne;

	    while ((curCol >= 0) && (curCol <= 6) && (curRow >= 0) && (curRow < 6)) {
	      if (plateau[curCol][curRow] != couleur) {
	        // Si la couleur change, on réinitialise le compteur
	        couleur = plateau[curCol][curRow];
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
* Vérifie s'il est encore possible de placer des pions. On cherche une case vide. S'il n'y en a plus, le plateau  est plein
**/
	  public boolean PlateauPlein() {
	    	    for (int col = 0; col < 7; col++) {
	      for (int ligne = 0; ligne < 6; ligne++) {
	        if (plateau[col][ligne] == VIDE) {
	          return false;
	        }
	      }
	    }

	    return true;
	  }

/**
* Joue un coup après avoir vérifier le plateau et le coup du joueur
**/

	public void jouer(int j, int col){
		if(verifier(col)==true){
			boolean overflow = effectuer(j,col);
			if(overflow==false){
				JOptionPane.showMessageDialog(null, "la colonne est déjà remplie");
			}
		}
		/*if(victoire()){
			JOptionPane.showMessageDialog(null, "victoire!");
			System.exit(0);
		}*/
	}

/**
* Vérifie si le joueur mettre les bons paramètres (facultatif)
**/	
	
	private boolean verifier(int col){
		if ((col < 0) || (col > 6)){
		return false;}
		return true;
	}

/**
* Vérifie si le coup du joueur est faisable et l'effectuer
**/
	private boolean effectuer(int j, int col){
		for (int ligne = 0; ligne < 6; ligne++) {
		      if (plateau[col][ligne] == VIDE) {
		        plateau[col][ligne] = j;
		        return true;
		      }
		}
		return false;
	}
/**
 * Méthode indiquant la hauteur totale d'une colonne
 * @param i la colonne dont on veut obtenir la hauteur
 * @return la hauteur de la colonne
 */
public int hauteurColonne(int i){
		int h = 0;
		for (int j = 0; j<6;j++){
			if(plateau[i][j]!=0){
				h=j;
			}
		}
		return h;
	}
/**
 * méthode pour compter l'alignement de pions verticaux en i,j
 * @param i colonne visée
 * @param j rangée visée
 * @return le nombre total de pions alignés.
 */
public int nbPionsVerticaux(int i, int j){
	int total = 0;
	int k = j;
	int caseDepart =plateau[i][j];
	while(k>0&&caseDepart==plateau[i][k]){
		total++;
		k--;
	}
	k = j;
	while(k<6&&caseDepart==plateau[i][k]){
		total++;
		k++;
	}
	return total;
}
/**
 * méthode pour compter l'alignement de pions horizontaux en i,j
 * @param i colonne visée
 * @param j rangée visée
 * @return le nombre total de pions alignés.
 */
public int nbPionsHorizontaux(int i, int j){
	int total = 0;
	int k = i;
	int caseDepart = plateau[i][j];
	while(k>0&&caseDepart==plateau[k][j]){
		total++;
		k--;
	}
	k = j;
	while(k<7&&caseDepart==plateau[k][j]){
		total++;
		k++;
	}
	return total;
}
/**
 * méthode pour compter l'alignement de pions dans la diagonale de gauche à droite en i,j
 * @param i colonne visée
 * @param j rangée visée
 * @return le nombre total de pions alignés.
 */
public int nbPionsDiagGaD(int i, int j){
	int total = 0;
	int k = i;
	int l = j;
	int caseDepart = plateau[i][j];
	while(k>0&&caseDepart==plateau[k][l]&&l<6){
		total++;
		k--;
		l++;
	}
	k = j;
	while(k<7&&caseDepart==plateau[k][l]&&l>0){
		total++;
		k++;
		l--;
	}
	return total;
}
/**
 * méthode pour compter l'alignement de pions dans la diagonale de droite à gauche en i,j
 * @param i colonne visée
 * @param j rangée visée
 * @return le nombre total de pions alignés.
 */
public int nbPionsDiagDaG(int i, int j){
	int total = 0;
	int k = i;
	int l = j;
	int caseDepart = plateau[i][j];
	while(k<7&&caseDepart==plateau[k][l]&&l<6){
		total++;
		k++;
		l++;
	}
	k = j;
	while(k>0&&caseDepart==plateau[k][l]&&l>0){
		total++;
		k--;
		l--;
	}
	return total;
}
}
