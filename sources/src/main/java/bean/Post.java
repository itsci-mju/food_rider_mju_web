package bean;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post {
	@Id
	private int postID;
	@Column(length = 45, nullable = false)
	private String restaurant;
	@Column(length = 200, nullable = false)
	private String postDate;
	@Column(nullable = false)
	private String postTime;
	@Column(length = 100, nullable = false)
	private String detail;
	@Column(nullable = false)
	private String amount;
	@Column(length = 100, nullable = false)
	private String deliveryfee;
	@Column(length = 200, nullable = false)
	private String location;
	@Column(length = 200, nullable = false)
	private String profile;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int postID, String restaurant, String postDate, String postTime,
			String detail, String amount, String deliveryfee, String location, String profile) {
		super();
		this.postID = postID;
		this.restaurant = restaurant;
		this.postDate = postDate;
		this.postTime = postTime;
		this.detail = detail;
		this.amount = amount;
		this.deliveryfee = deliveryfee;
		this.location = location;
		this.profile = profile;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDeliveryfee() {
		return deliveryfee;
	}

	public void setDeliveryfee(String deliveryfee) {
		this.deliveryfee = deliveryfee;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	
}
