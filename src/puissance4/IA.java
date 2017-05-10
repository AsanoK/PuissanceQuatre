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
	ArrayList<Integer> cps = coupsPossibles();
	int resultat = cps.get(0);
	int meilleurScore = 0;
	return 0;
}
public ArrayList<Integer> coupsPossibles(){
	return null;
}
}
