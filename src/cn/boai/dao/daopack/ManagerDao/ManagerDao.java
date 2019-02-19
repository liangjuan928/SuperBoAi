package cn.boai.dao.daopack.ManagerDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Manager;

public interface ManagerDao {
	public boolean saveManager(Manager manager,Connection conn) throws Exception;
	public boolean updateManager(Manager manager,Connection conn) throws Exception;
	public boolean deleteManager(String id,Connection conn) throws Exception;
	public Manager selectManagerById(String id,Connection conn) throws Exception;
	public List<Manager> selectAllManager(Connection conn) throws Exception;

}
