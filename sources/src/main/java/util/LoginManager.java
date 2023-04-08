package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.CallableStatement;
import bean.Member;

public class LoginManager {

	public int insertMember(Member m) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into member values('" + m.getMemID() + "','" + m.getMemName() + "','"
					+ m.getMemPhone() + "','" + m.getMemEmail() + "','" + m.getMemFeature() + "','"
					+ m.getMemImageProfile() + "','" + m.getMemAddress() + "','" + m.getPassword() + "')");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public int getMaxMember() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Statement stmt = null;

		int result = 0;
		try {
			stmt = con.createStatement();
			String sql = "Select MAX(memID) from member";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				result = id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/*public Member SearchMemberA(String sname, String pw) {
		Member me = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.member where where memEmail = '" + sname + "'and password = '" + pw
					+ "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int memID = rs.getInt(1);
				String memName = rs.getString(2);
				String memPhone = rs.getString(3);
				String memEmail = rs.getString(4);
				String memAddress = rs.getString(5);
				String memFeature = rs.getString(6);
				String memImageProfile = rs.getString(7);
				String password = rs.getString(8);

				 me = new Member(memID, memName, memPhone, memEmail, memAddress, memFeature, memImageProfile,
						password);
			
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return me;

	}

	public List<Member> SearchCustomer() {
		List<Member> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.member";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int memID = rs.getInt(1);
				String memName = rs.getString(2);
				String memPhone = rs.getString(3);
				String memEmail = rs.getString(4);
				String memAddress = rs.getString(5);
				String memFeature = rs.getString(6);
				String memImageProfile = rs.getString(7);
				String password = rs.getString(8);
				Member s = new Member(memID, memName, memPhone, memEmail, memAddress, memFeature, memImageProfile,
						password);
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}*/

public Member verifyLogin(Member mr) {
		Member m = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			/*String sql = "select * from project.member where memEmail = '" + mr.getMemEmail() + "'and password = '"
					+ mr.getPassword() + "' and memFeature = '"+ mr.getMemFeature() + "'";*/
			String sql = "select * from member where memEmail = '"+mr.getMemEmail()+"' and password = '"+mr.getPassword()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() && rs.getRow() == 1) {
				int memID = rs.getInt(1);
				String memName = rs.getString(2);
				String memPhone = rs.getString(3);
				String memEmail = rs.getString(4);
				String memAddress = rs.getString(5);
				String memFeature = rs.getString(6);
				String memImageProfile = rs.getString(7);
				String password = rs.getString(8);
				m = new Member(memID, memName, memPhone, memEmail, memAddress, memFeature, memImageProfile, password);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

}
