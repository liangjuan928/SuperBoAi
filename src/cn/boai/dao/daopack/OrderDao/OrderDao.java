package cn.boai.dao.daopack.OrderDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Order1;
import cn.boai.pojo.Product;

public interface OrderDao {
	public boolean saveOrder(Order1 order,Connection conn) throws Exception;
	public boolean updateOrder(Order1 order,Connection conn) throws Exception;
	public boolean deleteOrder(String id,Connection conn) throws Exception;
	public Order1 selectOrderById(String id,Connection conn) throws Exception;
	public List<Order1> selectAllOrder(Connection conn) throws Exception;
}
