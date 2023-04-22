package bean;

import javax.persistence.Column;

public class Meun {
	
	private int idmeun;
	private String nameMenu;
	private String meunPrice;
	public Meun() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meun(int idmeun, String nameMenu, String meunPrice) {
		super();
		this.idmeun = idmeun;
		this.nameMenu = nameMenu;
		this.meunPrice = meunPrice;
	}
	public int getIdmeun() {
		return idmeun;
	}
	public void setIdmeun(int idmeun) {
		this.idmeun = idmeun;
	}
	public String getNameMenu() {
		return nameMenu;
	}
	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}
	public String getMeunPrice() {
		return meunPrice;
	}
	public void setMeunPrice(String meunPrice) {
		this.meunPrice = meunPrice;
	}
	
}
