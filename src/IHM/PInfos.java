package IHM;

import java.awt.Canvas;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JPanel;

public class PInfos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8339747386561181649L;
	private Fenetre fenetre;
PInfos(Fenetre f){
	super();
	fenetre = f;
	setLayout(new GridLayout(1,7));
	Canvas joueur = new Canvas();
	joueur.setBackground(fenetre.getJoueuractif().getCouleur());
	this.add(new Label("joueur actif"));
	this.add(joueur);
	
}
}
