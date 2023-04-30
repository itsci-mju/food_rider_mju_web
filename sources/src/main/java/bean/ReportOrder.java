package bean;

public class ReportOrder {
	
	private int reportID;
	private String reportRemark;
	private String reportDate;
	private String reportTime;
	private int qtyFood;
	private int member_OrderID;
	public ReportOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportOrder(int reportID, String reportRemark, String reportDate, String reportTime, int qtyFood,
			int member_OrderID) {
		super();
		this.reportID = reportID;
		this.reportRemark = reportRemark;
		this.reportDate = reportDate;
		this.reportTime = reportTime;
		this.qtyFood = qtyFood;
		this.member_OrderID = member_OrderID;
	}
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public String getReportRemark() {
		return reportRemark;
	}
	public void setReportRemark(String reportRemark) {
		this.reportRemark = reportRemark;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public int getQtyFood() {
		return qtyFood;
	}
	public void setQtyFood(int qtyFood) {
		this.qtyFood = qtyFood;
	}
	public int getMember_OrderID() {
		return member_OrderID;
	}
	public void setMember_OrderID(int member_OrderID) {
		this.member_OrderID = member_OrderID;
	}
	
	
}
