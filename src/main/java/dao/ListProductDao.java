package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



import context.DBContext;
import model.Category;
import model.Product;

public class ListProductDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// ham lay du lieu san pham tu database
	public List<Product> getAllProduct(int index) {
		List<Product> list = new ArrayList<>();
		String query = "SELECT *\r\n"
				+ "FROM products\r\n"
				+ "ORDER BY product_id\r\n"
				+ "LIMIT 6\r\n"
				+ "OFFSET ?";
		try {
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1)*6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		return list;
	}
	// ham lay tong san pham
	public int getTotalProduct() {
		String query = "select count(*) from products" ;
		try {
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return 0;
		
	}
	// lay du lieu category tu product database
		public List<Category> getCategory(){
			List<Category> listct = new ArrayList<>();
			String query = "select product_brand from products\r\n"
					+ "group by product_brand;";
			try {
				conn = new DBContext().getJDBCConnection();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					listct.add(new Category(rs.getString(1)));
				}
				ps.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return listct;
		}
		// ham lay mot san pham
		public Product getProductByid(String id) {
			
			String query = "select * from products\r\n"
					+ "where product_id = ?;";
			try {
				conn = new DBContext().getJDBCConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					return (new Product(rs.getInt(1),
							rs.getString(2), 
							rs.getString(3), 
							rs.getFloat(4), 
							rs.getString(5),
							rs.getString(6),
							rs.getString(7)));
				}
				ps.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return null;
		}
		// ham search product
		public List<Product> searchProduct(String txt) {
			List<Product> list = new ArrayList<>();
			String query = "select * from products\r\n"
					+ "where product_name like ?;";
			try {
				conn = new DBContext().getJDBCConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, "%" +txt + "%");
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Product(rs.getInt(1),
							rs.getString(2), 
							rs.getString(3), 
							rs.getFloat(4), 
							rs.getString(5),
							rs.getString(6),
							rs.getString(7)));
				}
				ps.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return list;
		}
		// tra ve tong san pham search duoc
		public int totalSearch(String txt) {
			String query = "select count(*) from (\r\n"
					+ "SELECT * FROM products\r\n"
					+ "where product_name like ?) as b;";
			try {
				conn = new DBContext().getJDBCConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, "%" +txt + "%");
				rs = ps.executeQuery();
				while (rs.next()) {
					return rs.getInt(1);
				}
				ps.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return 0;
		}
	
}
