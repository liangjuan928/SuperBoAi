package cn.boai.service.ytservice.impl;

import java.sql.Connection;
import java.util.Date;

import cn.boai.dao.ytdao.YtDao;
import cn.boai.dao.ytdao.impl.YtDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.User;
import cn.boai.service.ytservice.YtService;
import cn.boai.web.form.ytform.AddUsersForm;

public class YtServiceImpl implements YtService{
	YtDao yd=new YtDaoImpl();

	@Override
	public boolean addUser(AddUsersForm form) {
		Connection conn=DBHelper.getConnection();
		User user=new User();
		user.setUser_name(form.getUname());
		user.setUser_password(form.getUpass());
		user.setUser_sex(form.getUsex());
		user.setUser_photo(form.getUphoto());
		Date date=new Date();
		java.sql.Date date2 =new java.sql.Date(date.getTime());
		user.setUser_time(date2);
		boolean result=false;
		try {
			result=yd.saveUser(user, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
