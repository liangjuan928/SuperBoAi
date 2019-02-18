package cn.boai.service.zwtservice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import cn.boai.dao.daopack.AddressDao.AddressDao;
import cn.boai.dao.daopack.CommentDao.CommentDao;
import cn.boai.dao.daopack.CommentDao.impl.CommentDaoImpl;
import cn.boai.dao.daopack.UserDao.UserDao;
import cn.boai.dao.daopack.UserDao.impl.UserDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Address;
import cn.boai.pojo.Article;
import cn.boai.pojo.Comment;
import cn.boai.pojo.User;
import cn.boai.service.zwtservice.ZwtService;
import cn.boai.web.form.zwtform.AddCommForm;

public class ZwtServiceImpl implements ZwtService{
	CommentDao cd=new CommentDaoImpl();
	UserDao ud=new UserDaoImpl();

	@Override
	public boolean addComm(AddCommForm form) {
		Connection conn=DBHelper.getConnection();
		Comment comm=new Comment();
		comm.setCom_content(form.getComm_content());
		comm.setCom_type(Integer.valueOf(form.getComm_type()));
		comm.setPro_id(form.getPro_id());
		comm.setUser_id(form.getUser_id());
		Date date=new Date();
		java.sql.Date d =new java.sql.Date(date.getTime());
		comm.setCom_time(d);
		boolean flag=false;
		try {
			conn.setAutoCommit(false);
			flag = cd.saveComm(comm, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Comment> queryCommByProid(String pro_id) {
		Connection conn=DBHelper.getConnection();
		List<Comment> list=null;
		try {
			list=cd.selectCommByProId(pro_id, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User queryUserById(String user_id) {
		Connection conn=DBHelper.getConnection();
		User user=null;
		try {
			user=ud.selectUserById(user_id, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	

}
