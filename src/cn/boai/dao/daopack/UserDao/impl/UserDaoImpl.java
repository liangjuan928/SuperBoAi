package cn.boai.dao.daopack.UserDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.boai.dao.daopack.UserDao.UserDao;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Order1;
import cn.boai.pojo.User;
import cn.boai.util.UUIDHelp;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean saveUser(User user, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into user(user_id,user_name,user_password,user_sex,user_photo,user_time) values(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		String id=UUIDHelp.GetUUID();
		ps.setString(1, id);
		ps.setString(2, user.getUser_name());
		ps.setString(3, user.getUser_password());
		ps.setString(4, user.getUser_sex());
		ps.setString(5, user.getUser_photo());
		ps.setDate(6, user.getUser_time());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	
	@Override
	public boolean updateUser(User user, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update user set user_name=?,user_password=?,user_sex=?,user_photo=?,user_level=?,user_def=? where user_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getUser_password());
		ps.setString(3, user.getUser_sex());
		ps.setString(4, user.getUser_photo());
		ps.setString(5, user.getUser_level());
		ps.setString(6, user.getUser_def());
		ps.setString(7, user.getUser_id());
		
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean deleteUser(String id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from user where user_id = ?";
		PreparedStatement ps = null;

		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public User selectUserById(String id, Connection conn) throws Exception {
		User user = null;
		String sql = "select * from user where user_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setUser_id(rs.getString("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_sex(rs.getString("user_sex"));
			user.setUser_photo(rs.getString("user_photo"));
			user.setUser_time(rs.getDate("user_time"));
			user.setUser_level(rs.getString("user_level"));
			user.setUser_def(rs.getString("user_def"));
		}
		rs.close();
		ps.close();

		return user;
	}

	@Override
	public List<User> selectAllUser(Connection conn) throws Exception {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setUser_id(rs.getString("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_sex(rs.getString("user_sex"));
			user.setUser_photo(rs.getString("user_photo"));
			user.setUser_time(rs.getDate("user_time"));
			user.setUser_level(rs.getString("user_level"));
			user.setUser_def(rs.getString("user_def"));
			list.add(user);
		}
		rs.close();
		ps.close();
		return list;
	}
	
//	public static void main(String[] args) {
//		Connection conn=DBHelper.getConnection();
//		UserDao ud=new UserDaoImpl();
////		List<User> u=new ArrayList<User>();
////		User user=new User();
////		try {
////			user=ud.selectUserById("123", conn);
////			System.out.println(user.getUser_name());
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		for (User user : u) {
////			System.out.println(user.getUser_name());
////		}
//		
////		Date date=new Date();
////		java.sql.Date d= new java.sql.Date(date.getTime());
////		User user=new User();
////		user.setUser_id("hs44");
////		user.setUser_name("gulei");
////		user.setUser_password("4645");
////		user.setUser_sex("1");
////		user.setUser_photo("fre.rdhre");
////		user.setUser_time(d);
////		try {
////			ud.updateUser(user, conn);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
////		try {
////			ud.deleteUser("hs44", conn);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
//		
//	}

}
