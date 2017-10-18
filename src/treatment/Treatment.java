package treatment;

import java.util.List;

import javax.swing.JFrame;

import bean.InfoBean;
import bean.RecapBean;
import bean.WeaponBean;

public class Treatment {
	
	private JFrame f;
	private List<WeaponBean> weaponBeanList;
	
	private RecapBean recapBean;
	private InfoBean ib;
	private double wallet = 0;
	private double realMoneyput = 0;
	private int nbOpen = 0;
	
	//TODO LOGGER & replace sysou

	public Treatment(JFrame f, List<WeaponBean> weaponBeanList, InfoBean ib) {
		this.setF(f);
		this.setWeaponBeanList(weaponBeanList);
		this.setIb(ib);
		
		while(nbOpen < ib.getNombreCaisseToOpen()) {
			openCase();
		}
		System.out.println("argent dépensé :"+String.format( "%.2f", realMoneyput)+" wallet:"+String.format( "%.2f", wallet));
	}
	
	private void openCase() {
		nbOpen ++;
		if(ib.getPrixCaisse()<=wallet) {
			wallet-=ib.getPrixCaisse();
		} else {
			realMoneyput+=wallet+(ib.getPrixCaisse()-wallet);
		}
		double montantGagne=0.0;
		double r = Math.random()*100;
		double cumul = 0.0;
		for (WeaponBean weaponBean : weaponBeanList) {
			cumul += weaponBean.getDroprate();
			if(cumul>r) {
				montantGagne=weaponBean.getAmout();
				break;
			}
		}
		wallet+=montantGagne;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public List<WeaponBean> getWeaponBeanList() {
		return weaponBeanList;
	}

	public void setWeaponBeanList(List<WeaponBean> weaponBeanList) {
		this.weaponBeanList = weaponBeanList;
	}

	public InfoBean getIb() {
		return ib;
	}

	public void setIb(InfoBean ib) {
		this.ib = ib;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public double getRealMoneyput() {
		return realMoneyput;
	}

	public void setRealMoneyput(double realMoneyput) {
		this.realMoneyput = realMoneyput;
	}

	public RecapBean getRecapBean() {
		return recapBean;
	}

	public void setRecapBean(RecapBean recapBean) {
		this.recapBean = recapBean;
	}
	
}
