package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {
	@Id
	private int memID;
	@Column(length=100 ,nullable = false)
	private String memName;
	@Column(length=10 ,nullable = false)
	private String memPhone;
	@Column(length=100 ,nullable = false)
	private String memEmail;
	@Column(length=200 ,nullable = false)
	private String memAddress;
	@Column(length=45 ,nullable = false)
	private String memFeature;
	@Column(length=100 ,nullable = false)
	private String memImageProfile;
	@Column(length = 45, nullable = false)
	private String password;
	@Column(length=100 ,nullable = false)
	private String status;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int memID, String memName, String memPhone, String memEmail, String memAddress, String memFeature,
			String memImageProfile, String password, String status) {
		super();
		this.memID = memID;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.memAddress = memAddress;
		this.memFeature = memFeature;
		this.memImageProfile = memImageProfile;
		this.password = password;
		this.status = status;
	}
	public int getMemID() {
		return memID;
	}
	public void setMemID(int memID) {
		this.memID = memID;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemFeature() {
		return memFeature;
	}
	public void setMemFeature(String memFeature) {
		this.memFeature = memFeature;
	}
	public String getMemImageProfile() {
		return memImageProfile;
	}
	public void setMemImageProfile(String memImageProfile) {
		this.memImageProfile = memImageProfile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}