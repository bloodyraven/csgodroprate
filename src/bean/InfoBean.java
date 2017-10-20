package bean;

public class InfoBean {

	private double prixCaisse;
	private int nombreCaisseToOpen;
	private String path;
	
	public InfoBean(double prixCaisse, int nombreCaisseToOpen, String path) {
		this.setPrixCaisse(prixCaisse);
		this.setNombreCaisseToOpen(nombreCaisseToOpen);
		this.path=path;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
