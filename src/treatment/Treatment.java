package treatment;

import java.util.List;

import javax.swing.JFrame;

import logger.Logger;
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
	
	private Logger log;
	
	public Treatment(JFrame f, List<WeaponBean> weaponBeanList, InfoBean ib) {
		this.setF(f);
		this.setWeaponBeanList(weaponBeanList);
		this.setIb(ib);
		log = new Logger(ib.getPath());
		
		while(nbOpen < ib.getNombreCaisseToOpen()) {
			openCase();
		}
		log.write("Argent dépensé :"+String.format( "%.2f", realMoneyput)+" Wallet:"+String.format( "%.2f", wallet));
	}
	
	private void openCase() {
		log.write("----------\nOuverture Caisse");
		nbOpen ++;
		if(ib.getPrixCaisse()<=wallet) {
			log.write("Achat caisse avec le wallet : "+ib.getPrixCaisse());
			wallet-=ib.getPrixCaisse();
		} else {
			log.write("Achat caisse avec argent réel : "+wallet+(ib.getPrixCaisse()-wallet));
			realMoneyput+=wallet+(ib.getPrixCaisse()-wallet);
		}
		double montantGagne=0.0;
		double r = Math.random()*100;
		double cumul = 0.0;
		for (WeaponBean weaponBean : weaponBeanList) {
			cumul += weaponBean.getDroprate();
			if(cumul>r) {
				log.write("Gain de "+weaponBean.getAmout()+" : "+weaponBean.getName());
				montantGagne=weaponBean.getAmout();
				break;
			}
		}
		wallet+=montantGagne;
		log.write("Wallet : "+wallet+"----------\n");
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
