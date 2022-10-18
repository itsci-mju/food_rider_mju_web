package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
	@Id
	private int orderDetailID;
	@Column(length=100 ,nullable = false)
	private double totaPrice;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int orderDetailID, double totaPrice) {
		super();
		this.orderDetailID = orderDetailID;
		this.totaPrice = totaPrice;
	}
	public int getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public double getTotaPrice() {
		return totaPrice;
	}
	public void setTotaPrice(double totaPrice) {
		this.totaPrice = totaPrice;
	}
	

}
