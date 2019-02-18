package cn.boai.dao.daopack.TypeDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Type;

public interface TypeDao {
	public List<Type> selectAllType(Connection conn) throws Exception;
}
