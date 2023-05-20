package bean;

public class ReportOrder {
	
	private int reportID;
	private String reportRemark;
	private String reportDate;
	private String reportTime;
	private double qtyFood;
	private int member_OrderID;
	private int post_postID;
	public ReportOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportOrder(int reportID, String reportRemark, String reportDate, String reportTime, double qtyFood,
			int member_OrderID, int post_postID) {
		super();
		this.reportID = reportID;
		this.reportRemark = reportRemark;
		this.reportDate = reportDate;
		this.reportTime = reportTime;
		this.qtyFood = qtyFood;
		this.member_OrderID = member_OrderID;
		this.post_postID = post_postID;
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
	public double getQtyFood() {
		return qtyFood;
	}
	public void setQtyFood(double qtyFood) {
		this.qtyFood = qtyFood;
	}
	public int getMember_OrderID() {
		return member_OrderID;
	}
	public void setMember_OrderID(int member_OrderID) {
		this.member_OrderID = member_OrderID;
	}
	public int getPost_postID() {
		return post_postID;
	}
	public void setPost_postID(int post_postID) {
		this.post_postID = post_postID;
	}
	
}
