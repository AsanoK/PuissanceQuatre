package puissance4;
/**
 * Déroulement de jeu.
 * Classe qui faire fonctionner le Jeu sous forme de plateau + 2 joueurs
 * @author Hugin
 */
public class Jeu {
private Joueur[] joueurs = new Joueur[2];
private Plateau plateau;
private Joueur joueurActif;
public Jeu(Joueur joueur1, Joueur joueur2) {
	    joueurs[0] = joueur1;
	    joueurs[1] = joueur2;
	    joueurActif = joueurs[0];
	    plateau = new Plateau();
}
/**
 * méthode pour obtenir le numéro d'un joueur (utilisé pour ses pions par exemple)
 * @param j le joueur visé
 * @return son numéro
 */
public int getNumero(Joueur j){
	int ret =1;
	if(j.equals(joueurs[1])){
		ret = 2;
	}
	return ret;
}
public Joueur[] getJoueurs() {
	return joueurs;
}
/**
 * Permet d'obtenir le joueur qui n'est pas celui qu'on a
 * @param j un joueur dont on dispose
 * @return l'autre joueur
 */
public Joueur getAutreJoueur(Joueur j){
	if(j.equals(joueurs[0])){
		return joueurs[1];
	}else return joueurs[0];
	
}
public Joueur getJoueurActif() {
	return joueurActif;
}

public Plateau getPlateau() {
	return plateau;
}
public void setPlateau(Plateau plat){
	plateau = plat;
}

public void joue() {
	    boolean gagner = false;
	    int cJoueur = 0;

	    while (gagner==false && !plateau.PlateauPlein()) {
	      joueurs[cJoueur].joue(plateau);
	      if (plateau.PlateauPlein()) {
	        gagner=false;
	      }

	      // Conditions gagnante
	      if (plateau.victoire()) {
	    gagner=true;

	      }

	      // Faire le tour des joueurs
	      cJoueur++;
	      cJoueur %= 2;
	    }

	    if (gagner == false) {
	      System.out.println("Partie nul.");
	    } 
	else {
	      System.out.println("Partie finie, on a un gagnant");
	    }
	  }


}
