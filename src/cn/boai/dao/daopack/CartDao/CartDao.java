package cn.boai.dao.daopack.CartDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Cart;

public interface CartDao {
	public boolean deleteCart(String uid,String pid,Connection conn) throws Exception;//直接删除商品
	public boolean saveCart(Cart c,Connection conn) throws Exception;
	public boolean updateCart(Cart c,Connection conn) throws Exception;
	public Cart selectCartById(String uid,String pid,Connection conn) throws Exception;
	public List<Cart> selectAllCart(Connection conn) throws Exception;
}
