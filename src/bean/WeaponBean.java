package bean;

public class WeaponBean {

	private String name;
	private double droprate;
	private double amout;
	
	public WeaponBean(String name, double droprate, double amout) {
		this.setName(name);
		this.setDroprate(droprate);
		this.setAmout(amout);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDroprate() {
		return droprate;
	}

	public void setDroprate(double droprate) {
		this.droprate = droprate;
	}

	public double getAmout() {
		return amout;
	}

	public void setAmout(double amout) {
		this.amout = amout;
	}
	
	
}
