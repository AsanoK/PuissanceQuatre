package IHM;

import puissance4.*;

public class TestIHM {
public static void main(String[] arg){
	Jeu jeu = new Jeu(new Joueur(), new Joueur());
	Fenetre fenetre = new Fenetre(jeu);
}
}
