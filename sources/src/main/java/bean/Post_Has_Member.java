package bean;
public class Post_Has_Member {
	
	private String post_ID;
	private String Member_Email;
	private String status ;
	public Post_Has_Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post_Has_Member(String post_ID, String member_Email, String status) {
		super();
		this.post_ID = post_ID;
		Member_Email = member_Email;
		this.status = status;
	}
	public String getPost_ID() {
		return post_ID;
	}
	public void setPost_ID(String post_ID) {
		this.post_ID = post_ID;
	}
	public String getMember_Email() {
		return Member_Email;
	}
	public void setMember_Email(String member_Email) {
		Member_Email = member_Email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
