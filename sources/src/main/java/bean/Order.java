package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order")
public class Order {
	@Id
	private int orID;
	@Column(length=100 ,nullable = false)
	private int orQty;
	@Column(length=45 ,nullable = false)
	private String orStatus;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orID, int orQty, String orStatus) {
		super();
		this.orID = orID;
		this.orQty = orQty;
		this.orStatus = orStatus;
	}
	public int getOrID() {
		return orID;
	}
	public void setOrID(int orID) {
		this.orID = orID;
	}
	public int getOrQty() {
		return orQty;
	}
	public void setOrQty(int orQty) {
		this.orQty = orQty;
	}
	public String getOrStatus() {
		return orStatus;
	}
	public void setOrStatus(String orStatus) {
		this.orStatus = orStatus;
	}
	

}
