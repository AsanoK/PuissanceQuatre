package puissance4;
/**
 * Déroulement de jeu.
 * Classe qui faire fonctionner le Jeu sous forme de plateau + 2 joueurs
 * @author Hugin
 */
public class Jeu {
private Joueur[] joueurs = new Joueur[2];
private Plateau plateau;

public Jeu(Joueur joueur1, Joueur joueur2) {
	    joueurs[0] = joueur1;
	    joueurs[1] = joueur2;
	    plateau = new Plateau();
}

public Joueur[] getJoueurs() {
	return joueurs;
}

public Plateau getPlateau() {
	return plateau;
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
