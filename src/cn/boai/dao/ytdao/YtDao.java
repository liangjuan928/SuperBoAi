package cn.boai.dao.ytdao;

import java.sql.Connection;
import java.util.List;

import cn.boai.dao.daopack.UserDao.UserDao;
import cn.boai.pojo.User;

public interface YtDao extends UserDao{
	public User selectUserByUserName(String username,Connection conn) throws Exception;
	public boolean checkUserByUserName(String username,Connection conn) throws Exception;
}
