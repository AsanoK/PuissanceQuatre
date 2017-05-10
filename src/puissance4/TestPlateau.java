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
		partie.getPlateau().jouer(1,1);
		partie.getPlateau().jouer(2,1);
		partie.getPlateau().jouer(1,1);
		/*for (int  i = 0; i<7;i++){
			for (int j = 0; j<6;j++){
				System.out.print(partie.getPlateau().getPlateau()[i][j]);
			}
			System.out.println("");
		}*/
		//test de jeu en dehors du plateau
		partie.getPlateau().jouer(1,7);
		//test de jeu en joueur 3
		partie.getPlateau().jouer(3,0);
		//test de victoire : vertical
		/*partie.getPlateau().jouer(1, 2);
		partie.getPlateau().jouer(1, 2);
		partie.getPlateau().jouer(1, 2);
		partie.getPlateau().jouer(1, 2);
		if(partie.getPlateau().victoire()){
			System.out.println("validé : vertical");
		}*/
		partie.getPlateau().jouer(1, 3);
		partie.getPlateau().jouer(1, 4);
		partie.getPlateau().jouer(1, 5);
		partie.getPlateau().jouer(1, 6);
		partie.getPlateau().jouer(1, 2);
		if(partie.getPlateau().victoire()){
			System.out.println("validé : horizontal");
		}
		
	}
}
