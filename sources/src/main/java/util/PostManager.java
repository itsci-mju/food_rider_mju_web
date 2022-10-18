package util;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.*;

public class PostManager {
	public int insertPost(Post PO) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into pj_insertPost values('" + PO.getPostID() + "','" + PO.getRestaurant() + "','"
					+ PO.getPostDate() + "','" + PO.getPostTime() + "','" + PO.getAmount() + "','" + PO.getDeliveryfee()
					+ "','" + PO.getLocation() + "','" + PO.getProfile() + "')");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public List<Post> SearchPost() {
		List<Post> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from pj_posts where restaurant = 'cat' ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int postID = rs.getInt(1);
				String restaurant = rs.getString(2);
				String postDate = rs.getString(3);
				String postTime = rs.getString(4);
				String detail = rs.getString(5);
				String amount = rs.getString(6);
				String deliveryfee = rs.getString(7);
				String location = rs.getString(8);
				String profile = rs.getString(9);
				Post p = new Post(postID, restaurant, postDate, postTime, location, amount,
						deliveryfee, location, profile);
				list.add(p);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

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

	public int insertMeun(Meun m) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into pj_insertMeun values('" + m.getNameMenu() + "','" + m.getMeunPrice() + "')");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	
	public int getMaxOrder() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Statement stmt = null;

		int result = 0;
		try {
			stmt = con.createStatement();
			String sql = "Select MAX(reportID) from reportorder";
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

	public int insertOrder(ReportOrder ro) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into reportorder values('" + ro.getReportRemark() + "','" + ro.getQtyFood() + "')");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}


}
