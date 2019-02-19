package cn.boai.dao.daopack.ManagerDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.boai.dao.daopack.ManagerDao.ManagerDao;
import cn.boai.pojo.Manager;
import cn.boai.util.UUIDHelp;

public class ManagerDaoImpl implements ManagerDao{

	@Override
	public boolean saveManager(Manager manager, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into manager(manager_id,manager_name,manager_password,manager_sex,manager_phone,manager_email,manager_act,manager_dicrib,manager_def) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		String id=UUIDHelp.GetUUID();
		ps.setString(1, id);
		ps.setString(2, manager.getManager_name());
		ps.setString(3, manager.getManager_password());
		ps.setString(4, manager.getManager_sex());
		ps.setString(5, manager.getManager_phone());
		ps.setString(6, manager.getManager_email());
		ps.setString(7, manager.getManager_act());
		ps.setString(8, manager.getManager_dicrib());
		ps.setString(9, manager.getManager_def());
		
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean updateManager(Manager manager, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update manager set manager_name=?,manager_password=?,manager_sex=?,manager_phone=?,manager_email=?,manager_act=?,manager_dicrib=?,mamager_def=? where manager_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		String id=UUIDHelp.GetUUID();
		ps.setString(1, id);
		ps.setString(2, manager.getManager_name());
		ps.setString(3, manager.getManager_password());
		ps.setString(4, manager.getManager_sex());
		ps.setString(5, manager.getManager_phone());
		ps.setString(6, manager.getManager_email());
		ps.setString(7, manager.getManager_act());
		ps.setString(8, manager.getManager_dicrib());
		ps.setString(9, manager.getManager_def());
		
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean deleteManager(String id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from manager where manager_id = ?";
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
	public Manager selectManagerById(String id, Connection conn) throws Exception {
		Manager manager=new Manager();
		String sql="select * from manager where id=?";
		PreparedStatement ps=null;
		ps=conn.prepareStatement(sql);
        ResultSet rs=null;
		ps.setString(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			manager = new Manager();
			manager.setManager_id(rs.getString("manager_id"));
			manager.setManager_name(rs.getString("manager_name"));
			manager.setManager_password(rs.getString("manager_password"));
			manager.setManager_sex(rs.getString("manager_sex"));
			manager.setManager_phone(rs.getString("manager_photo"));
			manager.setManager_email(rs.getString("manager_email"));
			manager.setManager_act(rs.getString("manager_act"));
			manager.setManager_def(rs.getString("manager_dicrib"));
			manager.setManager_def(rs.getString("manager_def"));
		}
		rs.close();
		ps.close();

		return manager;
	}

	@Override
	public List<Manager> selectAllManager(Connection conn) throws Exception {
		List<Manager> list = new ArrayList<Manager>();
		String sql = "select * from manager";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			Manager manager = new Manager();
			manager.setManager_id(rs.getString("manager_id"));
			manager.setManager_name(rs.getString("manager_name"));
			manager.setManager_password(rs.getString("manager_password"));
			manager.setManager_sex(rs.getString("manager_sex"));
			manager.setManager_phone(rs.getString("manager_phone"));
			manager.setManager_email(rs.getString("manager_email"));
			manager.setManager_act(rs.getString("manager_act"));
			manager.setManager_def(rs.getString("manager_dicrib"));
			manager.setManager_def(rs.getString("manager_def"));
			list.add(manager);
		}
		rs.close();
		ps.close();
		return list;
	}

}
