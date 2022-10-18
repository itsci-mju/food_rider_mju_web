package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login {
	@Id
	@Column(length=100 ,nullable = false)
	private String username;
	@Column(length=15 ,nullable = false)
	private String password;
	@Column(length=20 ,nullable = false)
	private String type;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
