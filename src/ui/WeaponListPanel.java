package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import bean.WeaponBean;

@SuppressWarnings("serial")
public class WeaponListPanel extends JPanel {
	
	private JPanel entriesWrapper = new JPanel();
	private JFrame f;
	private JButton button = new JButton("Ajouter");
	private double actualPercentage = 0.0;
	private JLabel percentage;
	
	public WeaponListPanel(JFrame f) {
		this.f=f;
		this.setPreferredSize(new Dimension(f.getWidth()/2, f.getHeight()));
		this.setLayout(new BorderLayout());
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addEntry();
			}
		});
		JPanel buttonWrapper = new JPanel();
		buttonWrapper.add(button);
//		entriesWrapper.setLayout(new BoxLayout(entriesWrapper, BoxLayout.Y_AXIS));
		entriesWrapper.setLayout(new GridLayout(0, 1));
		this.add(new JScrollPane(entriesWrapper), BorderLayout.CENTER);
		this.add(buttonWrapper, BorderLayout.SOUTH);
		percentage = new JLabel("Pourcentage : 0%", SwingConstants.RIGHT);
		this.add(percentage, BorderLayout.NORTH);
	}
	
	public List<WeaponBean> getWeaponBeans() {
		ArrayList<WeaponBean> toReturn = new ArrayList<WeaponBean>();
		for (Component component : entriesWrapper.getComponents()) {
			toReturn.add(((WeaponEntryPanel)component).getWeaponBean());
		}
		return toReturn;
	}
	
	public void updateLabel() {
		actualPercentage=0.0;
		for (Component component : entriesWrapper.getComponents()) {
			try {
				actualPercentage+=Double.parseDouble(((WeaponEntryPanel)component).getDroprate().getText());
			} catch(Exception e) {}
		}
		if(actualPercentage==100.0) {
			percentage.setForeground(Color.BLACK);
		} else {
			percentage.setForeground(Color.RED);
		}
		percentage.setText("Pourcentage : "+actualPercentage+"%");
		f.repaint();
		f.revalidate();
	}
	
	public void addEntry() {
		entriesWrapper.add(new WeaponEntryPanel(this));
		f.repaint();
		f.revalidate();
	}
	
	public void removeEntry(WeaponEntryPanel wep) {
		entriesWrapper.remove(wep);
		f.repaint();
		f.revalidate();
	}
	
}
