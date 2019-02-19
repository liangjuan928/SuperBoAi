package cn.boai.service.ytservice.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import cn.boai.dao.ytdao.YtDao;
import cn.boai.dao.ytdao.impl.YtDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.User;
import cn.boai.service.ytservice.YtService;
import cn.boai.util.ChangePass;
import cn.boai.web.form.ytform.AddUsersForm;
import cn.boai.web.form.ytform.CheckUserForm;

public class YtServiceImpl implements YtService{
	YtDao yd=new YtDaoImpl();

	@Override
	public boolean addUser(AddUsersForm form) {
		Connection conn=DBHelper.getConnection();
		User user=new User();
		user.setUser_name(form.getUname());
		user.setUser_password(form.getUpass());
		user.setUser_sex(form.getUsex());
		user.setUser_photo(form.getPhoto());
		Date date=new Date();
		java.sql.Date date2 =new java.sql.Date(date.getTime());
		user.setUser_time(date2);
		
		boolean flag=false;
		try {
			conn.setAutoCommit(false);
			flag = yd.saveUser(user, conn);
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
	public boolean checkUser(CheckUserForm form) {
		Connection conn=DBHelper.getConnection();
		boolean flag=false;
		try {
			User user=yd.selectUserByUserName(form.getUname(), conn);
			flag=user.getUser_password().equals(ChangePass.Change(form.getUpass()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}
