package cn.boai.dao.daopack.CommentDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.boai.dao.daopack.CommentDao.CommentDao;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Comment;
import cn.boai.pojo.User;

public class CommentDaoImpl implements CommentDao{

	@Override
	public boolean saveComm(Comment comm, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into comment(com_content,com_time,com_type,user_id,pro_id) values(?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, comm.getCom_content());
		ps.setDate(2, comm.getCom_time());
		ps.setInt(3, comm.getCom_type());
		ps.setString(4, comm.getUser_id());
		ps.setString(5, comm.getPro_id());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean deleteComm(String id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from comment where com_id = ?";
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
	public List<Comment> selectCommByProId(String id, Connection conn) throws Exception {
		List<Comment> list = new ArrayList<Comment>();
		String sql = "select * from comment where pro_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			Comment comm = new Comment();
			comm.setCom_id(rs.getInt("com_id"));
			comm.setCom_content(rs.getString("com_content"));
			comm.setCom_time(rs.getDate("com_time"));
			comm.setCom_type(rs.getInt("com_type"));
			comm.setUser_id(rs.getString("user_id"));
			comm.setPro_id(rs.getString("pro_id"));
			comm.setCom_def(rs.getString("com_def"));
			list.add(comm);
		}
		rs.close();
		ps.close();
		return list;
	}

	@Override
	public List<Comment> selectCommByStatus(String id, Integer type, Connection conn) throws Exception {
		List<Comment> list = new ArrayList<Comment>();
		String sql = "select * from comment where pro_id=? and com_type=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setInt(2, type);
		rs = ps.executeQuery();
		while (rs.next()) {
			Comment comm = new Comment();
			comm.setCom_id(rs.getInt("com_id"));
			comm.setCom_content(rs.getString("com_content"));
			comm.setCom_time(rs.getDate("com_time"));
			comm.setCom_type(rs.getInt("com_type"));
			comm.setUser_id(rs.getString("user_id"));
			comm.setPro_id(rs.getString("pro_id"));
			comm.setCom_def(rs.getString("com_def"));
			list.add(comm);
		}
		rs.close();
		ps.close();
		return list;
	}

//	public static void main(String[] args) {
//		Connection conn=DBHelper.getConnection();
//		CommentDao cd=new CommentDaoImpl();
//		Comment comment=new Comment();
//		comment.setCom_content("awegwe");
//		comment.setUser_id("11");
//		comment.setCom_type(1);
//		comment.setPro_id("123");
//		Date date=new Date();
//		java.sql.Date d= new java.sql.Date(date.getTime());
//		comment.setCom_time(d);
//		try {
//			cd.saveComm(comment, conn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
