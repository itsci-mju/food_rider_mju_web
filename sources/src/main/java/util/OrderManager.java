package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Post;
import bean.ReportOrder;

public class OrderManager {
	public int getMaxOrder() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		Statement stmt = null;

		int result = 0;
		try {
			stmt = con.createStatement();
			String sql = "Select MAX(reportID) from Order";
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

	public int insertReportOrder(ReportOrder RO) {
		try {
			
			ConnectionDB dbcon = new ConnectionDB();
			Connection conn = dbcon.getConnection();
			Statement statment = conn.createStatement();
			statment.execute("insert into project.reportorder values(" + RO.getReportID() + ",'" + RO.getReportRemark() 
																	+ "','"+RO.getReportDate()+"','"+RO.getReportTime()
																	+"',"+RO.getQtyFood()+","+RO.getMember_OrderID()+","+RO.getPost_postID()+")");
			conn.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
		public List<Post> Showpostt(String idp ) {
			List<Post> list = new ArrayList<>();
			
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "SELECT * FROM project.post where PostID = '"+idp+"' ";
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
