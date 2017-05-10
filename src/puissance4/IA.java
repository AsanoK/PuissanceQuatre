package puissance4;

import java.util.ArrayList;
/**
 * Classe représentant une IA utilisée en remplacmeent d'un joueur humain
 * @author Hugin
 *
 */
public class IA extends Joueur {
	/**
	 * la profondeur utilisée dans l'algorithme min-max
	 */
	private int profondeur;
	/**
	 * la partie à laquelle participe l'IA
	 */
	private Jeu partie;
	/**
	 * constructeur de la classe 
	 * @param part  la profondeur utilisée dans l'algorithme min-max
	 * @param pro la partie à laquelle participe l'IA
	 */
public IA(Jeu part, int pro){
	super();
	partie = part;
	profondeur = pro;
}
/**
 * méthode appelée de l'extérieur pour obtenir le coup qui sera joué par l'IA a un tour donné
 * @return un coup optimal
 */
public int obtenirCoup(){
	Plateau plat = new Plateau (partie.getPlateau());
	ArrayList<Integer> cps = coupsPossibles(plat);
	int resultat = cps.get(0);
	int meilleurScore = scoreCoup(plat,resultat,profondeur,partie.getJoueurActif());
	for (int i = 1;i<cps.size();i++){
		int score = scoreCoup(plat, cps.get(i),profondeur,partie.getJoueurActif());
		if(score>meilleurScore){
			resultat = cps.get(i);
			meilleurScore = score;
		}
	}
	return resultat;
}
/**
 * méthode permettant d'obtenir la liste des coups possibles devant une situation donnée
 * @param p le plateau (la situation du jeu)
 * @return liste des coups jouables
 */
public ArrayList<Integer> coupsPossibles(Plateau p){
	ArrayList<Integer> resultat = new ArrayList<Integer>();
	for(int i =0;i<7;i++){
		if(p.hauteurColonne(i)<6){
			resultat.add(i);
		}
	}
	return resultat;
}
/**
 * méthode renvoyant le score donné par un coup
 * @param p le plateau
 * @param c le numéro de la colonne où on joue
 * @param prof profondeur de l'algorithme
 * @param actif joueur actif
 * @return score de la situation obtenue
 */

public int scoreCoup(Plateau p, int c, int prof,Joueur actif){
	/*int j = 1;
	if(partie.getJoueurActif().equals(partie.getJoueurs()[1])){
		j = 2;
	}*/
	Plateau plat = new Plateau(p);
	int j = partie.getNumero(actif);
	plat.jouer(j, c);
	Joueur joueurRef = partie.getAutreJoueur(actif);
	if((plat.PlateauPlein()||plat.victoire())||prof==0){
		
		return evaluer(plat,joueurRef);
	}else return minMax(plat,joueurRef, actif,prof-1);
}
/**
 * méthode de l'algorithme minmax proprement dit
 * @param p le plateau
 * @param jref le joueur dont on calcule le jeu
 * @param jactif le joueur dont c'est le tour
 * @param prof profondeur de l'algorithme
 * @return
 */
private int minMax(Plateau p,Joueur jref,Joueur jactif, int prof ){
	ArrayList<Integer> cps = coupsPossibles(p);
	int resultat = scoreCoup(p,cps.get(0),prof,jref);
	int score = 0;
	for (int i = 1; i<cps.size();i++){
		score = scoreCoup(p,cps.get(i),prof,jref);
		if(jactif.equals(jref)){
			resultat = Math.max(resultat,score);
		}else{
			resultat = Math.min(resultat, score);
		}
	}
	return resultat;
}
/**
 * méthode donnant le score total d'une situation
 * @param p le plateau (la situation)
 * @param jrefle joueur dont on calcule le score
 * @return score du joueur dans une situation moins score de son adversaire
 */
private int evaluer(Plateau p, Joueur jref){
	return score(p,jref)-score(p,partie.getAutreJoueur(jref));
}
/**
 * score d'un joueur dans une situation
 * @param p la situation
 * @param joueur le joueur dont on calcule le score
 * @return score de ce joueur
 */
private int score(Plateau p, Joueur joueur){
	int resultat = 0;
	for (int i = 0; i<7;i++){
		for (int j = 0; j<6; j++){
			if (partie.getNumero(joueur)==p.getPlateau()[i][j]){
				resultat = resultat+scoreAlignement(p.nbPionsVerticaux(i, j));
				resultat = resultat+scoreAlignement(p.nbPionsHorizontaux(i, j));
				resultat = resultat+scoreAlignement(p.nbPionsDiagDaG(i, j));
				resultat = resultat+scoreAlignement(p.nbPionsDiagGaD(i, j));
			}
		}
	}
	return resultat;
}
/**
 * méthode calculant le score suivant le nombre de pions alignés
 * @param nb nombre de pions alignés
 * @return bonus de score correspondant
 */
private int scoreAlignement(int nb){
	int res = 0;
	switch(nb){
	case 1 : res =1;
	break;
	case 2: res = 5;
	break;
	case 3 : res = 50;
	break;
	case 4 : res =1000;
	break;
	}
	return res;
}
}
