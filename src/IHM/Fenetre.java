package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import puissance4.Plateau;
/**
 * classe repr�sentant la fen�tre dans son ensemble : le plateau de jeu, mais aussi tous ce qui est autour
 * @author Hugin
 *
 */
public class Fenetre extends JFrame {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plateau plateau;
	private JPlateau jplateau;
	/**
	 * marge laiss�e par d�faut aux bandeaux en haut et en bas du plateau
	 */
	public static int MARGEY = 100;
	/**
	 * largeur de r�f�rence pour la fen�tre
	 */
	public static int XPREF  = 700;
	/**
	 * hauteur de r�f�rence pour la fen�tre
	 */
	public static int YPREF  = 800;
	/**
	 * hauteur de r�f�rence de la partie centrale (plateau)
	 */
	public static int YPLAT = YPREF-2*MARGEY;
	/**
	 * subdivision de r�f�rence en largeur
	 */
	public static int pasX = XPREF/7;
	/**
	 * subdivion de r�f�rence en hauteur
	 */
	public static int pasY = (YPREF-2*MARGEY)/6;
	
	/**
	 * constructeur de la classe fenetre
	 */
	public Fenetre(Plateau p){
		plateau = p;
		initComponent();
		this.pack();
		this.setVisible(true);
	}
	/**
	 * initialisation des composants graphiques de la fen�tre
	 */
	private void initComponent(){
		jplateau = new JPlateau(plateau);
		this.setLayout(new BorderLayout());
		// plateau, au centre
		this.add(jplateau, BorderLayout.CENTER);
		//ligne de boutons, en haut
		JPanel boutons = new JPanel();
		boutons.setLayout(new GridLayout(1,7));
		for (int i = 0;i<7;i++){
			BoutonColonne bouton= new BoutonColonne(Integer.toString(i+1),i);
			bouton.setPreferredSize(new Dimension(pasX, MARGEY));
			//ajouter un listener au bouton
			boutons.add(bouton);
		}
		this.add(boutons, BorderLayout.NORTH);
		//informations diverses, en bas?
		
	}
	public JPlateau getJPlateau() {
		return jplateau;
	}
}
