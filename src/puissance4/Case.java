package puissance4;

import java.awt.Color;
/**
 * Classe repr�sentant une case du plateau de jeu
 * @author Hugin
 *
 */
@Deprecated
public class Case {
private Color couleur;

public Color getCouleur() {
	return couleur;
}
/**
 * Constructeur de la classe.
 * On met par d�faut la couleur blanche (case vide).
 */
public Case (){
	couleur = Color.WHITE;
}
}
