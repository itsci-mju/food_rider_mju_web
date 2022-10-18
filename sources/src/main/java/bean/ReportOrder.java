package bean;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ReportOrder")
public class ReportOrder {
	@Id
	private int reportID;
	@Column(nullable = false)
	private Date reportDate;
	@Column(nullable = false)
	private Time reportTime;
	@Column(length=100 ,nullable = false)
	private String reportRemark;
	@Column(nullable = false)
	private int qtyFood;
	public ReportOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportOrder(int reportID, Date reportDate, Time reportTime, String reportRemark, int qtyFood) {
		super();
		this.reportID = reportID;
		this.reportDate = reportDate;
		this.reportTime = reportTime;
		this.reportRemark = reportRemark;
		this.qtyFood = qtyFood;
	}
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Time reportTime) {
		this.reportTime = reportTime;
	}
	public String getReportRemark() {
		return reportRemark;
	}
	public void setReportRemark(String reportRemark) {
		this.reportRemark = reportRemark;
	}
	public int getQtyFood() {
		return qtyFood;
	}
	public void setQtyFood(int qtyFood) {
		this.qtyFood = qtyFood;
	}
	
}
