package puissance4;
import java.awt.Color;

/**
 * Classe représentant un joueur, humain ou non.
 * On stocke sa couleur pour le différencier
 * @author Hugin
 *
 */
public class Joueur {
	/**
	 * COMPTEUR permet de connaître le numéro du joueur à sa création
	 */
	static int COMPTEUR = 0;
	/**
	 * Couleur une pour le premier joueur
	 */
	static Color COULEURUNE = Color.RED;
	/**
	 * Couleur deux pour le second joueur
	 */
	static Color COULEURDEUX = Color.ORANGE;
	/**
	 * Couleur noire pour divers tests. N'est pas sensé apparaitre.
	 */
	static Color COULEURDEF = Color.BLACK;
private Color couleur;

public Color getCouleur() {
	return couleur;
}
/**
 * Constructeur de joueur, fixant automatiquement sa couleur.
 */
public Joueur(){
	if(COMPTEUR==0){
		couleur = COULEURUNE;
	}
	else if (COMPTEUR == 1){
		couleur = COULEURDEUX;
	}else couleur = COULEURDEF;
}
public void joue(Plateau plateau) {}
}
