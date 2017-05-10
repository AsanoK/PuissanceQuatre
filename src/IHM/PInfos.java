package IHM;

import java.awt.Canvas;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JPanel;

import puissance4.Joueur;

public class PInfos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8339747386561181649L;
	private Fenetre fenetre;
	private Joueur actif;
	private Canvas joueur;
public Canvas getJoueur() {
		return joueur;
	}
PInfos(Fenetre f){
	super();
	fenetre = f;
	actif = fenetre.getJoueuractif();
	setLayout(new GridLayout(1,7));
	joueur = new Canvas();
	joueur.setBackground(actif.getCouleur());
	this.add(new Label("joueur actif"));
	this.add(joueur);
	
}
	/*public void repaint(){
		actif = fenetre.getJoueuractif();
		joueur.setBackground(actif.getCouleur());
		super.repaint();
		
	}*/
}
