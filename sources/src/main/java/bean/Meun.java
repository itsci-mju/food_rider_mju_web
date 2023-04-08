package bean;

import javax.persistence.Column;

public class Meun {
	
	@Column(length = 200, nullable = false)
	private String nameMenu;
	@Column(nullable = false)
	private String meunPrice;
	public Meun() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meun( String nameMenu, String meunPrice) {
		super();
		
		this.nameMenu = nameMenu;
		this.meunPrice = meunPrice;
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
