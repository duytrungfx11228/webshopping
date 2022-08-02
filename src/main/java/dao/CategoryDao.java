package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;

import model.Product;

public class CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getAllProductbyCategory(String nameCate, int index) {
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM shoppingdb.products\r\n"
				+ "where product_brand = ?\r\n"
				+ "order by product_id\r\n"
				+ "limit 6\r\n"
				+ "offset ?;";
		try {
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,nameCate);
			ps.setInt(2, (index-1)*6);
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
	public int getTotalByCtaegoey(String nameCate) {
		String query = "select count(*) from (\r\n"
				+ "SELECT * FROM products\r\n"
				+ "where product_brand = ?) as b;";
		try {
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, nameCate);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}
	

}
