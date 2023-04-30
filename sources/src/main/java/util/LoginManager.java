package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bean.Member;
import bean.Post;

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

	public Member verifyLogin(Member mr) {
		Member m = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from member where memEmail = '" + mr.getMemEmail() + "' and password = '"
					+ mr.getPassword() + "'";
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

	public List<Member> getCustomer(String string) {
		List<Member> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.member where memEmail like '" + string + "'";
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

	public int EditProfile(Member pro) {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = " UPDATE project.member SET memImageProfile = '" + pro.getMemImageProfile() + "',memName = '"
					+ pro.getMemName() + "',memEmail = '" + pro.getMemAddress() + "',memPhone = '" + pro.getMemPhone()
					+ "',memFeature = '" + pro.getMemFeature() + "',password= '" + pro.getPassword() + "'";
			int result = stmt.executeUpdate(sql);
			con.close();
			return 1;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	public List<Member> ShowUSERS() {
		List<Member> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.member  ";
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
	public Member searchMs(String Email,String pw) {
		Member m = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from member where memEmail = '" + Email + "' and password = '"+pw +"'";
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
	public int deletemember(String memId) {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			System.out.println(memId);
			Statement stmt = con.createStatement();
			String sql = "delete from project.member where memID = '"+memId+"'";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public List<Post> Showindex() {
		List<Post> list = new ArrayList<>();
		
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.post ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int postID = rs.getInt(1);
				String restaurant = rs.getString(2);
				String meun = rs.getString(3);
				String postDate = rs.getString(4);
				String postTime = rs.getString(5);
				String detail = rs.getString(6);
				int amount = rs.getInt(7);
				int deliveryfee = rs.getInt(8);
				String location = rs.getString(9);
				String profile_pic = rs.getString(10);
				int member_PostID = rs.getInt(11);
				Post m = new Post(postID, restaurant, meun, postDate, postTime
								 ,detail, amount, deliveryfee, location, profile_pic,member_PostID);
				list.add(m);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
}
