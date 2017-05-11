package IHM;

import puissance4.Jeu;
import puissance4.Joueur;

public class testIA {
	public static void main(String[] arg){
		Jeu jeu = new Jeu(new Joueur());
		Fenetre fenetre = new Fenetre(jeu);
	}
}
