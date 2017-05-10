package puissance4;

import java.util.ArrayList;

public class IA extends Joueur {
	private int profondeur;
	private Jeu partie;
	
public IA(Jeu part, int pro){
	super();
	partie = part;
	profondeur = pro;
}
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
public ArrayList<Integer> coupsPossibles(Plateau p){
	ArrayList<Integer> resultat = new ArrayList<Integer>();
	for(int i =0;i<7;i++){
		if(p.hauteurColonne(i)<6){
			resultat.add(i);
		}
	}
	return resultat;
}


public int scoreCoup(Plateau p, int c, int prof,Joueur actif){
	int j = 1;
	
	if(partie.getJoueurActif().equals(partie.getJoueurs()[1])){
		j = 2;
	}
	p.jouer(j, c);
	Joueur joueurRef = partie.getAutreJoueur(actif);
	if((p.PlateauPlein()||p.victoire())||prof==0){
		
		return evaluer(p,joueurRef);
	}else return minMax(p,joueurRef, actif,prof-1);
}
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
private int evaluer(Plateau p, Joueur jref){
	
	return 0;
}
}
