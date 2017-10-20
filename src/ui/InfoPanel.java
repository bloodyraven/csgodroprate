package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	private JFileChooser pathLog;
	private JLabel pathSelected;
	
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
		jp2.add(new JLabel("Nombre de caisses à ouvrir : "));
		fieldNombreCaisse = new JTextField();
		fieldNombreCaisse.setPreferredSize(new Dimension(70, 30));
		jp2.add(fieldNombreCaisse);
		this.add(jp2);
		
		JPanel jp3 = new JPanel();
		jp3.add(new JLabel("Dossier de destination : "));
		pathLog = new JFileChooser();
		pathLog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		pathLog.setDialogTitle("Sélectionnez un dossier de destination");
		JButton pathButton = new JButton("Selectionner dossier");
		pathSelected = new JLabel();
		pathButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (pathLog.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
					pathSelected.setText(pathLog.getSelectedFile().getPath());
					f.repaint();
					f.revalidate();
				}
			}
		});
		jp3.add(pathButton);
		jp3.add(pathSelected);
		this.add(jp3);
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
		String path = pathSelected.getText();
		return new InfoBean(fieldPrixCaisse2, fieldNombreCaisse2, path);
	}

	public JFrame getF() {
		return f;
	}


	public void setF(JFrame f) {
		this.f = f;
	}

	public JFileChooser getPathLog() {
		return pathLog;
	}

	public void setPathLog(JFileChooser pathLog) {
		this.pathLog = pathLog;
	}

	public JLabel getPathSelected() {
		return pathSelected;
	}

	public void setPathSelected(JLabel pathSelected) {
		this.pathSelected = pathSelected;
	}

}
