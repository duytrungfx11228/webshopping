package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import model.Account;


public class AccountDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// lay du lieu nguoi dung tu database
	public Account getAcount(String mail, String pass){
		
		String query = "select * from account\r\n"
				+ "where user_mail = ? and password = ?;";
		try {
			conn = new DBContext().getJDBCConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()) {
				return (new Account(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6)));
				
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
}
