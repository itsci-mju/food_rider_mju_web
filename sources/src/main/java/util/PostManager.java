package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;

import bean.*;

public class PostManager {
	public int insertPost(Post PO) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into project.post values(" + PO.getPostID() + ",'" + PO.getRestaurant() + "','" 
																+ PO.getMeun() + "','" + PO.getPostDate() + "','" 
																+ PO.getPostTime() + "','" + PO.getDetail() + "'," 
																+ PO.getAmount() + "," + PO.getDeliveryfee() + ",'" 
																+ PO.getLocation()  + "','" + PO.getProfile_pic() + "','" + PO.getMember_PostID() + "')");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public int getMaxPost() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Statement stmt = null;

		int result = 0;
		try {
			stmt = con.createStatement();
			String sql = "Select MAX(postID) from Post";
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
	public int EditPost(Post p) {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = " UPDATE project.post SET postID = " + p.getPostID() + ",restaurant = '"+p.getRestaurant()
												+"',meun = '"+p.getMeun()+"',postDate = '"+p.getPostDate()
												+"',postTime = '"+p.getPostTime()+"',detail = '"+p.getDetail()
												+"',amount = "+p.getAmount()+",deliveryfee = "+p.getDeliveryfee()
												+",location = '"+p.getLocation()+"',profile_pic = '"+p.getProfile_pic()
												+"' WHERE member_PostID = " + p.getMember_PostID() + "";
			int result = stmt.executeUpdate(sql);
			con.close();
			return 1;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}
	public List<Post> Showpost(int id) {
		List<Post> list = new ArrayList<>();
		
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.post where member_PostID = "+id+" ";
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
	public int deletePost(String postID) {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			System.out.println(postID);
			Statement stmt = con.createStatement();
			String sql = "delete from project.post where postID = '"+postID+"'";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public Post getpost(String id) {
		Post m = new Post();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM project.post where PostID = "+id+" ";
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
				m = new Post(postID, restaurant, meun, postDate, postTime
								 ,detail, amount, deliveryfee, location, profile_pic,member_PostID);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;

	}

}
