package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import puissance4.Jeu;
import puissance4.Joueur;
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
	/**
	 * panneau d'information lat�ral
	 */
	private PInfos infos;
	/**
	 * le plateau dont d�pend la fen�tre
	 */
	
	private Plateau plateau;
	/**
	 * le pannel du haut, sur lequel sont les boutons de colonne pour jouer
	 */
	private JPanel boutons;
	/**
	 * le panel central, dans lequel s'affiche le plateau
	 */
	private JPlateau jplateau;
	/**
	 * joueur dont c'est le tour
	 */
	private Joueur joueuractif;
	/**
	 * partie dont d�pend la fen�tre
	 */
	private Jeu partie;
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
	 * Constructeur de la classe fen�tre
	 * @param p la partie dont d�pend la fen�tre
	 */
	public Fenetre (Jeu p){
		super("puissance quatre");
		plateau = p.getPlateau();
		partie = p;
		joueuractif = p.getJoueurActif();
		initComponent();
		this.pack();
		this.setVisible(true);
	}
	/**
	 * constructeur de la classe fenetre, utilis�e pour des tests
	 */
	
	public Fenetre(Plateau p){
		super("puissance quatre");
		plateau = p;
		partie = new Jeu(new Joueur(), new Joueur());
		joueuractif = partie.getJoueurs()[0];
		partie.setPlateau(plateau);
		initComponent();
		this.pack();
		this.setVisible(true);
	}
	public JPanel getBoutons(){
		return boutons;
	}
	public Jeu getPartie(){
		return partie;
	}
	public Joueur getJoueuractif() {
		return joueuractif;
	}

	public void setJoueuractif(Joueur joueuractif) {
		this.joueuractif = joueuractif;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	/**
	 * initialisation des composants graphiques de la fen�tre
	 */
	private void initComponent(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jplateau = new JPlateau(plateau);
		this.setLayout(new BorderLayout());
		// plateau, au centre
		this.add(jplateau, BorderLayout.CENTER);
		//ligne de boutons, en haut
		boutons = new JPanel();
		boutons.setLayout(new GridLayout(1,7));
		for (int i = 0;i<7;i++){
			// on affiche les boutons avec le num�ro normal, mais le bouton garde le num�ro "tableau" i
			BoutonColonne bouton= new BoutonColonne(Integer.toString(i+1),i);
			bouton.setPreferredSize(new Dimension(pasX, MARGEY));
			bouton.addActionListener(new ActionBouton(bouton, this));
			boutons.add(bouton);
		}
		this.add(boutons, BorderLayout.NORTH);
		//informations diverses, en bas
		infos = new PInfos(this);
		this.add(infos, BorderLayout.SOUTH);
		
	}
	public Plateau getPlateau() {
		return plateau;
	}
	public JPlateau getJPlateau() {
		return jplateau;
	}
	public PInfos getInfos() {
		return infos;
	}
	
}
/**
 * Classe g�rant les boutons de choix de colonne
 * @author Hugin
 *
 */
class ActionBouton implements ActionListener{
	/**
	 * le bouton auquel est li� le listener
	 */
	private BoutonColonne bouton;
	/**
	 * fen�tre � laquelle le bouton est li�.
	 */
	private Fenetre fen;
	ActionBouton(BoutonColonne b, Fenetre f){
		super();
		bouton = b;
		fen = f;
	}
	@Override
	/**
	 * M�thode d�finissant ce qui se passe apr�s l'activation d'un des boutons de colonne
	 * On joue le coup demand�, puis si besoin, on change le joueur actif, on met � jour l'affichage et l'�ventuel panneau de victoire
	 */
	public void actionPerformed(ActionEvent e) {
		//on r�cup�re le num�ro du joueur actif, qui sera utilis� pour affichage et m�tier
		int j = fen.getPartie().getNumero(fen.getJoueuractif());
		//on r�cup�re la colonne jou�e
		int col = bouton.getNumero();
		//on garde en m�moire pour comparaison la taille de la colonne avant jeu
		int valeurPrec = fen.getPartie().getPlateau().hauteurColonne(col);
		//on joue le coup demand�
		fen.getPartie().getPlateau().jouer(j, col);
		//si le coup est jou�, on continue
		if(fen.getPartie().getPlateau().hauteurColonne(col)!=valeurPrec){
			//mise � jour de l'affichage
			fen.repaint();
			//panneau de victoire au cas o�
			if(fen.getPlateau().victoire()){
				JOptionPane.showMessageDialog(fen, "victoire du joueur " + j);
				System.exit(0);
			}
			//changement du joueur actif
			fen.setJoueuractif(fen.getPartie().getAutreJoueur(fen.getJoueuractif()));
			//mise � jour affichage
			fen.repaint();
			//si c'est une partie solo, lancement du tour de l'IA
			if(fen.getPartie().partieSolo()){
				//on d�sactive les boutons?
				fen.getBoutons().setEnabled(false);
				//on cherche le coup, et on le joue. On suppose le coup jou� dans tous les cas
				fen.getPartie().getPlateau().jouer(2, fen.getPartie().getIA().obtenirCoup());
				//test de victoire
				if(fen.getPlateau().victoire()){
					JOptionPane.showMessageDialog(fen, "victoire du joueur " + fen.getPartie().getNumero(fen.getPartie().getIA()));
					System.exit(0);
				}
				//on change � nouveau le joueur actif
				fen.setJoueuractif(fen.getPartie().getAutreJoueur(fen.getJoueuractif()));
				//mise � jour affichage
				fen.repaint();
				//on r�active les boutons
				fen.getBoutons().setEnabled(true);
				
			}
		}
	}
	
	
	
}
