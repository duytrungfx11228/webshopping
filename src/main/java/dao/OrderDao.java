package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import context.DBContext;
import model.Cart;

import model.ProductOrders;

public class OrderDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void addOders(String email,String discoutCode,String address) {
		LocalDate curDate = java.time.LocalDate.now();
		String date = curDate.toString();
		int status = 1;
		
		try {
			// add vao bang order
			String query = "INSERT into orders (user_mail, order_status, order_date, order_discount_code, order_address) \r\n"
					+ "VALUES (?,?,?,?,?)";
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setInt(2, status);
			ps.setString(3, date);
			ps.setString(4, discoutCode);
			ps.setString(5, address);
			ps.executeUpdate();
			
				
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getIdOrder( ) throws SQLException {
		try {
			String query1 = "select order_id as id from orders\r\n"
					+ "order by order_id desc\r\n"
					+ "limit 2;";
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query1);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void addOrderDetail(Cart cart,int id) {
		
		try {
			
			for (ProductOrders i : cart.getItems()) {
				String query2 = "insert into orders_detail (amount_product,price_product,product_id,order_id) values(?,?,?,?)";
				conn = new DBContext().getJDBCConnection();
				ps = conn.prepareStatement(query2);
				ps.setInt(1, i.getAmountProduct());
				ps.setFloat(2, i.getPrice());
				ps.setInt(3, i.getProduct().getId());
				ps.setInt(4, id);
				
				ps.executeUpdate();
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
