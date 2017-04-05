package puissance4;

import java.awt.Color;
/**
 * Classe représentant une case du plateau de jeu
 * @author Hugin
 *
 */
public class Case {
private Color couleur;

public Color getCouleur() {
	return couleur;
}
/**
 * Constructeur de la classe.
 * On met par défaut la couleur blanche (case vide).
 */
public Case (){
	couleur = Color.WHITE;
}
}
