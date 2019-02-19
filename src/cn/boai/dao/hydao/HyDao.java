package cn.boai.dao.hydao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import cn.boai.pojo.Order1;

public interface HyDao {
	public boolean upProNum(String pid,Connection conn) throws Exception;
	public List<Order1> splitQuery(int pageSize,int pageNo);
	public List<Order1> selectOrderMohu(Connection conn,Map<String, String> condition) throws Exception;
}
