package IHM;

import java.awt.BorderLayout;

import javax.swing.JFrame;
/**
 * classe représentant la fenêtre dans son ensemble : le plateau de jeu, mais aussi tous ce qui est autour
 * @author Hugin
 *
 */
public class Fenetre extends JFrame {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPlateau plateau;
	private static int XPREF ;
	private static int YPREF ;
	
	/**
	 * constructeur de la classe fenetre
	 */
	public Fenetre(){
		initComponent();
		this.pack();
		this.setVisible(true);
	}
	/**
	 * initialisation des composants graphiques de la fenêtre
	 */
	private void initComponent(){
		plateau = new JPlateau(this);
		this.setLayout(new BorderLayout());
		this.add(plateau, BorderLayout.CENTER);
		
	}
	public JPlateau getPlateau() {
		return plateau;
	}
}
