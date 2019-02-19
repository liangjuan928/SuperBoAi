package cn.boai.dao.daopack.CartDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.boai.dao.daopack.CartDao.CartDao;
import cn.boai.pojo.Cart;
import cn.boai.util.UUIDHelp;

public class CartDaoImpl implements CartDao{
	public boolean deleteCart(String uid, String pid, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from cart where user_id = ? and pro_id = ?";
		PreparedStatement ps = null;

		ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setString(2, pid);
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	public boolean saveCart(Cart c, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into cart(user_id,pro_id) values(?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		String id=UUIDHelp.GetUUID();
		ps.setString(1, id);
		ps.setString(2, c.getPro_id());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean updateCart(Cart c, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update cart set pro_id=? where user_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, c.getPro_id());
		ps.setString(2, c.getUser_id());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public Cart selectCartById(String uid, String pid, Connection conn) throws Exception {
		Cart c = null;
		String sql = "select * from cart where user_id = ? and pro_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setString(2, pid);
		rs = ps.executeQuery();
		if (rs.next()) {
			c=new Cart();
			c.setPro_id(rs.getString("pro_id"));
			c.setUser_id(rs.getString("user_id"));
		}
		rs.close();
		ps.close();

		return c;
	}

	@Override
	public List<Cart> selectAllCart(Connection conn) throws Exception {
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select * from cart";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			Cart c = new Cart();
			c.setUser_id(rs.getString("user_id"));
			c.setPro_id(rs.getString("pro_id"));
			list.add(c);
		}
		rs.close();
		ps.close();
		return list;
	}

}
