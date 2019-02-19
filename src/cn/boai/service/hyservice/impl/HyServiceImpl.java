package cn.boai.service.hyservice.impl;
                          
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.boai.dao.daopack.CartDao.impl.CartDaoImpl;
import cn.boai.dao.daopack.OrderDao.impl.OrderDaoImpl;
import cn.boai.dao.daopack.UserDao.impl.UserDaoImpl;
import cn.boai.dao.hydao.impl.HyDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Cart;
import cn.boai.pojo.Order1;
import cn.boai.pojo.User;
import cn.boai.service.hyservice.HyService;

public class HyServiceImpl implements HyService{
	private UserDaoImpl ud=new UserDaoImpl();
	private CartDaoImpl cd=new CartDaoImpl();
	private OrderDaoImpl od=new OrderDaoImpl();
	private HyDaoImpl hd=new HyDaoImpl();

	public User queryUserById(String uid) {
		Connection conn = DBHelper.getConnection();
		User user = null;
		try {
			conn.setAutoCommit(false);
			user = ud.selectUserById(uid, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return user;
	}

	public boolean removeCart(String uid,String pid) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			conn.setAutoCommit(false);
			flag = cd.deleteCart(uid,pid, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}
	
	@Override
	public boolean addOrder(Order1 order) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			conn.setAutoCommit(false);
			flag = od.saveOrder(order, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	public List<Order1> queryAllOrder() {
		Connection conn = DBHelper.getConnection();
		List<Order1> list = null;
		try {
			conn.setAutoCommit(false);
			list = od.selectAllOrder(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean updateProNum(String pid) {
		Connection conn = DBHelper.getConnection();
		boolean flag = false;
		try {
			conn.setAutoCommit(false);
			flag = hd.upProNum(pid, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	public List<Order1> queryMohu(Map<String, String> condition){
		Connection conn = DBHelper.getConnection();
		List<Order1> list = null;
		try {
			conn.setAutoCommit(false);
			System.out.println("service map==========="+condition);
			list = hd.selectOrderMohu(conn, condition);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		System.out.println("service  ok");
		return list;
	}

	@Override
	public List<Cart> queryAllCart() {
		Connection conn = DBHelper.getConnection();
		List<Cart> list = null;
		try {
			conn.setAutoCommit(false);
			list=cd.selectAllCart(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	
	
}
