package bean;

public class ReportOrder {
	
	private int reportID;
	private String reportRemark;
	private String reportDate;
	private String reportTime;
	private int qtyFood;
	public ReportOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportOrder(int reportID, String reportDate, String reportTime, String reportRemark, int qtyFood) {
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
