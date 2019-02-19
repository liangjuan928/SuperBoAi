package cn.boai.dao.hydao;

import java.sql.Connection;

public interface HyDao {
	public boolean upProNum(String pid,Connection conn) throws Exception;
}
