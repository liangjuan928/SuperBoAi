package cn.boai.dao.daopack.TypeDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.boai.dao.daopack.TypeDao.TypeDao;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Type;

public class TypeDaoImpl implements TypeDao{

	@Override
	public List<Type> selectAllType(Connection conn) throws Exception {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from type";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		Type type=null;
		while (rs.next()) {
			type = new Type();
			type.setType_id(rs.getInt("type_id"));
			type.setType_name(rs.getString("type_name"));
			type.setType_def(rs.getString("type_def"));
			list.add(type);
		}
		rs.close();
		ps.close();
		return list;
	}
}
