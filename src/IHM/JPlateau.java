package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import puissance4.Plateau;
/**
 * classe repr�sentant le plateau de jeu et les cases qui le compose
 * @author Hugin
 *
 */
public class JPlateau extends JPanel {
	private static final long serialVersionUID = 1L;
	private Plateau plateau;
	//private Fenetre fenetre;
	/**
	 * largeur par d�faut du composant
	 */
	private static int XPREF= 700;
	/**
	 * hauteur par d�faut du composant
	 */
	private static int YPREF = 700;
	/**
	 * Couleur de l'arri�re du plateau
	 */
	private static Color BACKGROUNDCOLOR = Color.BLUE;
	
	/** 
	 * constructeur de la classe
	 * on fixe la taille par d�faut de l'affichage
	 */
	public JPlateau(Plateau plat){
		this.plateau = plat;
		this.setPreferredSize(new Dimension(XPREF,YPREF));
	}

	/**
	 * M�thode de "peinture" des diff�rents �l�ments du JPlateau
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
	 * m�thode permettant la peinture d'une case pr�cise du plateau
	 * @param g : le graphics utilis� pour peindre
	 * @param i : l'indice en x de la case (par rapport au plateau, pas en pixel)
	 * @param j: l'indice en y de la case (par rapport au plateau, pas en pixel)
	 */
	public void paintCase(Graphics g, int i, int j){
		int pasx =(int) this.getSize().getWidth()/7;
		int pasy =(int) this.getSize().getHeight()/7;
		//g.setColor(plateau.getCase(i, j).getCouleur());[TODO]
		g.fillOval(i*(pasx-1), j*(pasy-1), pasx, pasy);
	}
}
