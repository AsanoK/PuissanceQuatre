package puissance4;

import IHM.Fenetre;

public class TestPlateau {

	public static void main(String[] arg){
		Jeu partie = new Jeu(new Joueur(),new Joueur());
		//Fenetre fen = new Fenetre(partie);
		partie.getPlateau().jouer(1,1);
		partie.getPlateau().jouer(1,1);
		partie.getPlateau().jouer(1,1);
		partie.getPlateau().jouer(1,1);
		//System.out.println(partie.getPlateau().hauteurColonne(1));
		partie.getPlateau().jouer(1, 1);
		//System.out.println(partie.getPlateau().hauteurColonne(1));
		partie.getPlateau().jouer(1, 0);
		partie.getPlateau().jouer(1, 2);
		System.out.println("horiz"+partie.getPlateau().nbPionsHorizontaux(0,0));
		System.out.println("horiz"+partie.getPlateau().nbPionsHorizontaux(1,0));
		System.out.println("horiz"+partie.getPlateau().nbPionsHorizontaux(2,0));
		System.out.println("vert"+partie.getPlateau().nbPionsVerticaux(1, 0));
		System.out.println("vert"+partie.getPlateau().nbPionsVerticaux(1, 1));
		System.out.println("vert"+partie.getPlateau().nbPionsVerticaux(1, 2));
		System.out.println("h1"+partie.getPlateau().nbPionsDiagDaG(0, 0));
		System.out.println("h2"+partie.getPlateau().nbPionsDiagGaD(0, 0));
		System.out.println("h1"+partie.getPlateau().nbPionsDiagDaG(2, 0));
		System.out.println("h2"+partie.getPlateau().nbPionsDiagGaD(2, 0));
		Fenetre fen = new Fenetre(partie);
	}
}
