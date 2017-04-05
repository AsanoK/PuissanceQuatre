package puissance4;
/**
 * Plateau de jeu.
 * Classe abstraite qui sera divisée entre plateau à 1 ou 2 joueurs
 * @author Hugin
 *
 */
public abstract class Plateau {
private Case[][] plateau;

public Case[][] getPlateau() {
	return plateau;
}
public Case getCase(int i, int j){
	return plateau[i][j];
}
public Plateau(){
	plateau = new Case[7][6];
}
public boolean Victoire(){
	return false;
}
public void jouer(Joueur j, int col){
	if(verifier(col)){
		effectuer(j,col);
	}
}
private boolean verifier(int col){
	return false;
}
private void effectuer(Joueur j, int col){
	
}
}
