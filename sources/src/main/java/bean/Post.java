package bean;

import java.util.Date;
import org.apache.tomcat.jni.Time;

public class Post {

	private int postID;
	private String restaurant;
	private Date postDate;
	private Date postTime;
	private String detail;
	private int amount;
	private int deliveryfee;
	private String location;
	private String profile_pic;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int postID, String restaurant, Date postDate, Date postTime, String detail, int amount, int deliveryfee,
			String location, String profile_pic) {
		super();
		this.postID = postID;
		this.restaurant = restaurant;
		this.postDate = postDate;
		this.postTime = postTime;
		this.detail = detail;
		this.amount = amount;
		this.deliveryfee = deliveryfee;
		this.location = location;
		this.profile_pic = profile_pic;
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
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
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
	
}