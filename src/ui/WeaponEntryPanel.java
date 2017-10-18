package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constantes;
import bean.WeaponBean;

@SuppressWarnings("serial")
public class WeaponEntryPanel extends JPanel {
	
	private JTextField nom, prix, droprate;
	private JButton delete;
	public WeaponEntryPanel wep = this;

	public WeaponEntryPanel(WeaponListPanel wlp) {
		nom = new JTextField();
		nom.setPreferredSize(new Dimension(100, 30));
		prix = new JTextField();
		prix.setPreferredSize(new Dimension(70, 30));
		droprate = new JTextField();
		droprate.setPreferredSize(new Dimension(70, 30));
		droprate.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				wlp.updateLabel();
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		delete = new JButton("X");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				wlp.removeEntry(wep);
			}
		});
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Arme"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
		this.add(new JLabel("Nom arme : "));
		this.add(nom);
		this.add(new JLabel("Prix : "));
		this.add(prix);
		this.add(new JLabel("Drop rate : "));
		this.add(droprate);
		this.add(delete);
	}
	
	public WeaponBean getWeaponBean() {
		double droprate2 = 0.0;
		double prix2 = 0.0;
		try {
			droprate2 = Double.parseDouble(droprate.getText());
			prix2 = Double.parseDouble(prix.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Constantes.VERIFY_PARAMETERS_RIGHT, "", JOptionPane.WARNING_MESSAGE);
			System.out.println("Cannot parse "+nom.getText()+" drop or price value into double");
		}
		return new WeaponBean(nom.getText(), droprate2, prix2);
	}
	
	public JTextField getNom() {
		return nom;
	}

	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	public JTextField getPrix() {
		return prix;
	}

	public void setPrix(JTextField prix) {
		this.prix = prix;
	}

	public JTextField getDroprate() {
		return droprate;
	}

	public void setDroprate(JTextField droprate) {
		this.droprate = droprate;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}
	
}
