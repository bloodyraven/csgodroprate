package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import treatment.Treatment;
import bean.InfoBean;
import bean.WeaponBean;
import constants.Constantes;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	
	private JFrame f;
	private WeaponListPanel wlp;
	private InfoPanel ip;
	
	private final int OFFSET_BORDER = 15;
	
	public InputPanel(JFrame f) {
		this.f=f;
		this.setLayout(new BorderLayout());
		JButton go = new JButton("Go");
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<WeaponBean> wblist = wlp.getWeaponBeans();
				InfoBean ib = ip.getInfoBean();
				if(wblist.size()==0) {
					JOptionPane.showMessageDialog(null, Constantes.EMPTY_WEAPON_LIST, "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				for (WeaponBean	wb : wblist) {
					if(wb.getName().equals("")) {
						JOptionPane.showMessageDialog(null, Constantes.EMPTY_WEAPON_NAME, "", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				double percentage = 0.0;
				for (WeaponBean	wb : wblist) {
					percentage+=wb.getDroprate();
				}
				if(percentage!=100.0) {
					JOptionPane.showMessageDialog(null, Constantes.NOT_100_PERCENT, "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(ib.getNombreCaisseToOpen()<=0) {
					JOptionPane.showMessageDialog(null, Constantes.NOT_100_PERCENT, "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(ib.getPath()==null || ib.getPath().equals("")) {
					JOptionPane.showMessageDialog(null, Constantes.PATH_EMPTY, "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				new Treatment(f, wlp.getWeaponBeans(), ip.getInfoBean());
			}
		});
		wlp = new WeaponListPanel(f);
		ip = new InfoPanel(f);
		this.add(wlp, BorderLayout.EAST);
		this.add(Box.createRigidArea(new Dimension(10,0)), BorderLayout.CENTER);
		this.add(ip, BorderLayout.WEST);
		JPanel buttonWrapper = new JPanel();
		buttonWrapper.add(go);
		this.add(buttonWrapper, BorderLayout.SOUTH);
	}
	
	@Override
	public void repaint() {
		super.repaint();
		if(wlp!=null && ip!=null) {
			wlp.setPreferredSize(new Dimension(f.getWidth()/2-OFFSET_BORDER, f.getHeight()));
			ip.setPreferredSize(new Dimension(f.getWidth()/2, f.getHeight()));
		}
	}

}
