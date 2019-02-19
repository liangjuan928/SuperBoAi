package cn.boai.dao.ytdao.impl;

import java.sql.Connection;
import cn.boai.util.ChangePass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.boai.dao.ytdao.YtDao;
import cn.boai.pojo.User;
import cn.boai.util.UUIDHelp;

public class YtDaoImpl implements YtDao{

	@Override
	public boolean saveUser(User user, java.sql.Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into user(user_id,user_name,user_password,user_sex,user_photo,user_time,user_level) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		String id=UUIDHelp.GetUUID();
		ps.setString(1, id);
		ps.setString(2, user.getUser_name());
		String pw=null;
		pw=ChangePass.Change(user.getUser_password());
		ps.setString(3,pw);
		ps.setString(4, user.getUser_sex());
		ps.setString(5, user.getUser_photo());
		Date date=new Date();
		java.sql.Date d= new java.sql.Date(date.getTime());
		ps.setDate(6, d);
		ps.setString(7, "0");
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	@Override
	public boolean updateUser(User user, java.sql.Connection conn) throws Exception {
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
	public boolean deleteUser(String id, java.sql.Connection conn) throws Exception {
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
	public User selectUserById(String id, java.sql.Connection conn) throws Exception {
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
	public List<User> selectAllUser(java.sql.Connection conn) throws Exception {
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

	@Override
	public User selectUserByUserName(String username, Connection conn) throws Exception {
		User user = null;
		String sql = "select * from user where user_name = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
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
	public boolean checkUserByUserName(String username, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "select * from user where user_name = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs=ps.executeQuery();
		if(rs.next()){
			flag=true;
		}
		ps.close();
		rs.close();
		return flag;
	}

}
