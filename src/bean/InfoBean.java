package bean;

public class InfoBean {

	private double prixCaisse;
	private int nombreCaisseToOpen;
	
	public InfoBean(double prixCaisse, int nombreCaisseToOpen) {
		this.setPrixCaisse(prixCaisse);
		this.setNombreCaisseToOpen(nombreCaisseToOpen);
	}

	public double getPrixCaisse() {
		return prixCaisse;
	}

	public void setPrixCaisse(double prixCaisse) {
		this.prixCaisse = prixCaisse;
	}

	public int getNombreCaisseToOpen() {
		return nombreCaisseToOpen;
	}

	public void setNombreCaisseToOpen(int nombreCaisseToOpen) {
		this.nombreCaisseToOpen = nombreCaisseToOpen;
	}
}
