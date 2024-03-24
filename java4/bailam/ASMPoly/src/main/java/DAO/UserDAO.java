package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.User;

public class UserDAO extends ConnectDAO {

	public UserDAO() {

	}

	public User checkLogin(String username, String password) {
		User user = null;

		try {

			PreparedStatement ps = conn.prepareStatement("select * from user where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("Email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public User findByID(int id) {
		User user = null;
		
		try {

			PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("Email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean update(User user) {
		boolean result = false;
		
		try {

			PreparedStatement ps = conn.prepareStatement("update user set username = ? , fullname = ?, email = ?, phone = ?, role = ? where id = ?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getRole());
			ps.setInt(6, user.getId());
			
			if(ps.executeUpdate() > 0) {
				result = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean deleteUser(int id) {
		
		boolean result = false;
		
		try {

			PreparedStatement ps = conn.prepareStatement("delete user set id = ?");
			ps.setInt(1, id);
			
			if(ps.executeUpdate() > 0) {
				result = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insertUser(User user) {
		boolean result = false;
		
		try {

			PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setInt(6, user.getRole());
			
			
			if(ps.executeUpdate() > 0) {
				result = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}
}
