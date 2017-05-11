package puissance4;

import IHM.Fenetre;

public class TestPlateau {

	public static void main(String[] arg){
		Jeu partie = new Jeu(new Joueur(),new Joueur());
		Fenetre fen = new Fenetre(partie);
		partie.getPlateau().jouer(1,1);
		partie.getPlateau().jouer(2,1);
		partie.getPlateau().jouer(1,1);
		partie.getPlateau().jouer(2,1);
		System.out.println(partie.getPlateau().hauteurColonne(1));
		partie.getPlateau().jouer(1, 1);
		System.out.println(partie.getPlateau().hauteurColonne(1));
		
	}
}
