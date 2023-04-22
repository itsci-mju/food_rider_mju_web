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
	/*
	 * public String insertPost(Post PO) { ConnectionDB dbcon = new ConnectionDB();
	 * Connection conn = dbcon.getConnection(); try {
	 * 
	 * Statement statment = conn.createStatement();
	 * statment.execute("insert into project.post values('" + PO.getPostID() + "','"
	 * + PO.getRestaurant() + "','" + PO.getPostDate() + "','" + PO.getPostTime() +
	 * "','" + PO.getDetail() + "','" + PO.getAmount() + "','" + PO.getDeliveryfee()
	 * + "','" + PO.getLocation() + "','" + PO.getProfile() + "'");
	 * 
	 * CallableStatement cstmt = (CallableStatement)
	 * conn.prepareCall("insert into project.post values('" + PO.getPostID() + "','"
	 * + PO.getPostPhone() + "',,'" + PO.getRestaurant() + "','" + PO.getPostDate()
	 * + "','" + PO.getPostTime() + "','" + PO.getDetail() + "','" + PO.getAmount()
	 * + "','" + PO.getDeliveryfee() + "','" + PO.getLocation() + "'");
	 * cstmt.setInt(1, PO.getPostID()); cstmt.setString(2, PO.getPostPhone());
	 * cstmt.setString(3, PO.getRestaurant()); cstmt.setString(4, PO.getPostDate());
	 * cstmt.setString(5, PO.getPostTime()); cstmt.setString(6, PO.getDetail());
	 * cstmt.setString(7, PO.getAmount()); cstmt.setString(8, PO.getDeliveryfee());
	 * cstmt.setString(9, PO.getLocation()); boolean result = cstmt.execute();
	 * conn.close(); if (result == false) { return " ลงทะเบียนสำเร็จ... "; } else {
	 * return " มีบางอย่างผิดพลาด โปรดลองอีกครั้ง!!! "; } } catch (SQLException e) {
	 * e.printStackTrace(); } return " มีบางอย่างผิดพลาด โปรดลองอีกครั้ง!!! ";
	 * 
	 * }
	 */

	public int insertPost(Post PO) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into post values('" + PO.getPostID() + "','" + PO.getRestaurant() + "','"
					+ PO.getPostDate() + "','" + PO.getPostTime() + "','" + PO.getDetail() + "','" + PO.getAmount()
					+ "','" + PO.getDeliveryfee() + "','" + PO.getLocation() + "'");
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

	public int insertMeun(Meun m) {
		try {
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into project.meun values('" + m.getIdmeun() + "','" + m.getNameMenu() + "','"
					+ m.getMeunPrice() + "')");
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
			statment.execute(
					"insert into reportorder values('" + ro.getReportRemark() + "','" + ro.getQtyFood() + "')");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public int getMaxMaun() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Statement stmt = null;

		int result = 0;
		try {
			stmt = con.createStatement();
			String sql = "Select MAX(idmeun) from Meun";
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
