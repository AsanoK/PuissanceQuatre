package IHM;

import javax.swing.JButton;

public class BoutonColonne extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int numero;
public static long getSerialversionuid() {
	return serialVersionUID;
}
public int getNumero() {
	return numero;
}
public BoutonColonne(String t,int i){
	super(t);
	numero = i;
}
}
