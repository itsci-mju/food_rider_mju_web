package bean;
public class Post {

	private int postID;
	private String restaurant;
	private String meun;
	private String postDate;
	private String postTime;
	private String detail;
	private int amount;
	private int deliveryfee;
	private String location;
	private String profile_pic;
	private int member_PostID;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int postID, String restaurant, String meun, String postDate, String postTime, String detail, int amount,
			int deliveryfee, String location, String profile_pic, int member_PostID) {
		super();
		this.postID = postID;
		this.restaurant = restaurant;
		this.meun = meun;
		this.postDate = postDate;
		this.postTime = postTime;
		this.detail = detail;
		this.amount = amount;
		this.deliveryfee = deliveryfee;
		this.location = location;
		this.profile_pic = profile_pic;
		this.member_PostID = member_PostID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getMeun() {
		return meun;
	}
	public void setMeun(String meun) {
		this.meun = meun;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDeliveryfee() {
		return deliveryfee;
	}
	public void setDeliveryfee(int deliveryfee) {
		this.deliveryfee = deliveryfee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public int getMember_PostID() {
		return member_PostID;
	}
	public void setMember_PostID(int member_PostID) {
		this.member_PostID = member_PostID;
	}
	
}