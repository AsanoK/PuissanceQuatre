package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import puissance4.Plateau;
/**
 * classe représentant le plateau de jeu et les cases qui le compose
 * @author Hugin
 *
 */
public class JPlateau extends JPanel {
	private static final long serialVersionUID = 1L;
	private Plateau plateau;
	//private Fenetre fenetre;
	/**
	 * Couleur de l'arrière du plateau
	 */
	private static Color BACKGROUNDCOLOR = Color.BLUE;
	
	/** 
	 * constructeur de la classe
	 * on fixe la taille par défaut de l'affichage
	 */
	public JPlateau(Plateau plat){
		this.plateau = plat;
		this.setPreferredSize(new Dimension(Fenetre.XPREF,Fenetre.YPLAT));
	}

	/**
	 * Méthode de "peinture" des différents éléments du JPlateau
	 * On y met le fond, mais aussi les cases qui composent le plateau
	 */
	public void paintComponent(Graphics g){
		g.setColor(BACKGROUNDCOLOR);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for (int i = 0;i<7;i++){
			for (int j = 0;j<6;j++){
				paintCase(g,i,j);
			}
		}
	}
	/**
	 * méthode permettant la peinture d'une case précise du plateau
	 * @param g : le graphics utilisé pour peindre
	 * @param i : l'indice en x de la case (par rapport au plateau, pas en pixel)
	 * @param j: l'indice en y de la case (par rapport au plateau, pas en pixel)
	 */
	public void paintCase(Graphics g, int i, int j){
		int pasx =Fenetre.pasX;
		int pasy =Fenetre.pasY;
		Color couleur;
		if(plateau.getPlateau()[i][j]==Plateau.VIDE){
			couleur = Color.white;
		}else if(plateau.getPlateau()[i][j]==Plateau.BLEU){
			couleur = Color.RED;
		} else if(plateau.getPlateau()[i][j]==Plateau.ORANGE){
			couleur = Color.orange;
		}else couleur = Color.BLACK;
		g.setColor(couleur);
		g.fillOval(i*(pasx-1)+5, j*(pasy-1)+5, pasx-5, pasy-5);
	}
}
