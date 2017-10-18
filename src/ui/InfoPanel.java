package ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constantes;
import bean.InfoBean;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {
	
	private JFrame f;
	private JTextField fieldPrixCaisse;
	private JTextField fieldNombreCaisse;
	
	public InfoPanel(JFrame f) {
		this.setF(f);
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Informations"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
		this.setLayout(new GridLayout(0, 1));
		
		JPanel jp = new JPanel();
		jp.add(new JLabel("Prix caisse : "));
		fieldPrixCaisse = new JTextField();
		fieldPrixCaisse.setPreferredSize(new Dimension(70, 30));
		jp.add(fieldPrixCaisse);
		this.add(jp);
		
		JPanel jp2 = new JPanel();
		jp.add(new JLabel("Nombre de caisses à ouvrir : "));
		fieldNombreCaisse = new JTextField();
		fieldNombreCaisse.setPreferredSize(new Dimension(70, 30));
		jp.add(fieldNombreCaisse);
		this.add(jp2);
	}

	public InfoBean getInfoBean() {
		double fieldPrixCaisse2 = 0.0;
		int fieldNombreCaisse2 = 0;
		try {
			fieldPrixCaisse2 = Double.parseDouble(fieldPrixCaisse.getText());
			fieldNombreCaisse2 = Integer.parseInt(fieldNombreCaisse.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Constantes.VERIFY_PARAMETERS_LEFT, "", JOptionPane.WARNING_MESSAGE);
			System.out.println("Cannot parse prix caisse and number cases to open.");
		}
		return new InfoBean(fieldPrixCaisse2, fieldNombreCaisse2);
	}

	public JFrame getF() {
		return f;
	}


	public void setF(JFrame f) {
		this.f = f;
	}

}
