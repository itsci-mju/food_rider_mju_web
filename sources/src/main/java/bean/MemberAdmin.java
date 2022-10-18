package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MemberAdmin")
public class MemberAdmin {
	@Id
	private int memAID;
	@Column(length=100 ,nullable = false)
	private String memAName;
	@Column(length=10 ,nullable = false)
	private String memAPhone;
	@Column(length=100 ,nullable = false)
	private String memAEmail;
	@Column(length=45 ,nullable = false)
	private String memAaddress;
	@Column(length=45 ,nullable = false)
	private String memAImageProfile;
	@Column(length = 100, nullable = false)
	private String Apassword;
	
	public MemberAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberAdmin(int memAID, String memAName, String memAPhone, String memAEmail, String memAaddress,
			String memAImageProfile, String apassword) {
		super();
		this.memAID = memAID;
		this.memAName = memAName;
		this.memAPhone = memAPhone;
		this.memAEmail = memAEmail;
		this.memAaddress = memAaddress;
		this.memAImageProfile = memAImageProfile;
		Apassword = apassword;
	}
	public int getMemAID() {
		return memAID;
	}
	public void setMemAID(int memAID) {
		this.memAID = memAID;
	}
	public String getMemAName() {
		return memAName;
	}
	public void setMemAName(String memAName) {
		this.memAName = memAName;
	}
	public String getMemAPhone() {
		return memAPhone;
	}
	public void setMemAPhone(String memAPhone) {
		this.memAPhone = memAPhone;
	}
	public String getMemAEmail() {
		return memAEmail;
	}
	public void setMemAEmail(String memAEmail) {
		this.memAEmail = memAEmail;
	}
	public String getMemAaddress() {
		return memAaddress;
	}
	public void setMemAaddress(String memAaddress) {
		this.memAaddress = memAaddress;
	}
	public String getMemAImageProfile() {
		return memAImageProfile;
	}
	public void setMemAImageProfile(String memAImageProfile) {
		this.memAImageProfile = memAImageProfile;
	}
	public String getApassword() {
		return Apassword;
	}
	public void setApassword(String apassword) {
		Apassword = apassword;
	}
	
	
}
	