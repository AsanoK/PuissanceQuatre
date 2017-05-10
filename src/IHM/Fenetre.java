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
		joueuractif = p.getJoueurs()[0];
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
		JPanel boutons = new JPanel();
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
class ActionBouton implements ActionListener{
	private BoutonColonne bouton;
	private Fenetre fen;
	ActionBouton(BoutonColonne b, Fenetre f){
		super();
		bouton = b;
		fen = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int j = 1;
		//System.out.println("test");
		if(fen.getJoueuractif().equals(fen.getPartie().getJoueurs()[1])){
			j = 2;
		}
		fen.getPartie().getPlateau().jouer(j, bouton.getNumero());
		fen.repaint();
		if(fen.getPlateau().victoire()){
			JOptionPane.showMessageDialog(fen, "victoire du joueur " + j);
			System.exit(0);
		}
		if(fen.getJoueuractif().equals(fen.getPartie().getJoueurs()[1])){
			fen.setJoueuractif(fen.getPartie().getJoueurs()[0]);
		}else fen.setJoueuractif(fen.getPartie().getJoueurs()[1]);
		fen.repaint();
		fen.getInfos().getJoueur().setBackground(fen.getJoueuractif().getCouleur());
		fen.getInfos().repaint();
	}
	
	
}
