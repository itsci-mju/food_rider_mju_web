package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;

import bean.Member;
import bean.MemberAdmin;


public class LoginManager {
	public int insertMemberA(MemberAdmin m) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into memberadmin values('" + m.getMemAID() + "','" + m.getMemAName() + "','"
					+ m.getMemAPhone() + "','" + m.getMemAEmail() + "','" + m.getMemAaddress() + "','"
					+ m.getMemAImageProfile() + "','" + m.getApassword() + "')");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public int getMaxMemberAdmin() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Statement stmt = null;

		int result = 0;
		try {
			stmt = con.createStatement();
			String sql = "Select MAX(memAID) from memberadmin";
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

	public List<Member> SearchMember(String sname,String pw) {
		List<Member> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.member where where memEmail = '"+sname+"'and password = '"+pw+"'";
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

				Member m = new Member(memID, memName, memPhone, memEmail, memAddress, memFeature, memImageProfile,
						password);
				list.add(m);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

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

	

}
