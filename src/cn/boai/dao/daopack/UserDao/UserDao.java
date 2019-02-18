package cn.boai.dao.daopack.UserDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.User;


public interface UserDao {
	public boolean saveUser(User user,Connection conn) throws Exception;
	public boolean updateUser(User user,Connection conn) throws Exception;
	public boolean deleteUser(String id,Connection conn) throws Exception;
	public User selectUserById(String id,Connection conn) throws Exception;
	public List<User> selectAllUser(Connection conn) throws Exception;
}
