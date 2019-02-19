package cn.boai.dao.hydao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.boai.dao.daopack.ProductDao.impl.ProductDaoImpl;
import cn.boai.dao.hydao.HyDao;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Order1;
import cn.boai.pojo.Product;

public class HyDaoImpl implements HyDao{
	ProductDaoImpl pd=new ProductDaoImpl();

	public boolean upProNum(String pid, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update product set pro_sales=? where pro_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		Product p=pd.selectProductById(pid, conn);
		int i=Integer.parseInt(p.getPro_sales())+1;
		ps.setString(1, String.valueOf(i));
		ps.setString(2, pid);
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	
	public List<Order1> selectOrderMohu(Connection conn,Map<String, String> condition) throws Exception {
		List<Order1> list = new ArrayList<Order1>();
		String sql = "select * from order1 where 1=1";
		Set<Map.Entry<String, String>> me = condition.entrySet();
		int index = 0;
		for (Map.Entry<String, String> entry : me) {
			String k = entry.getKey();
			if("order_id".equals(k)){
				sql += " and uname like ?";
			}
		}
		System.out.println("sql完成");
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		for (Map.Entry<String, String> entry : me) {
			String k = entry.getKey();
			if("order_id".equals(k)){
				ps.setString(++index, "%"+entry.getValue()+"%");
			}
		}
		ResultSet rs = null;
		rs = ps.executeQuery();
		while (rs.next()) {
			Order1 order = new Order1();
			
			order.setOrder_id(rs.getString("order_id"));
			order.setUser_id(rs.getString("user_id"));
			order.setPro_id(rs.getString("pro_id"));
			order.setOrder_status(rs.getInt("order_status"));
			order.setOrder_time(rs.getDate("order_time"));
			order.setOrder_pay(rs.getInt("order_pay"));
			order.setOrder_total(rs.getDouble("order_total"));
			order.setOrder_def(rs.getString("order_def"));
			list.add(order);
		}
		rs.close();
		ps.close();
		return list;
		
	}
	
	/**
	 * 分页的方法
	 */
	public List<Order1> splitQuery(int pageSize,int pageNo){
		List<Order1> list = new ArrayList<Order1>();
		Connection conn = DBHelper.getConnection();
		String sql = "select * from order1 limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Order1 order = new Order1();
				order.setOrder_id(rs.getString("order_id"));
				order.setUser_id(rs.getString("user_id"));
				order.setPro_id(rs.getString("pro_id"));
				order.setOrder_status(rs.getInt("order_status"));
				order.setOrder_time(rs.getDate("order_time"));
				order.setOrder_pay(rs.getInt("order_pay"));
				order.setOrder_total(rs.getDouble("order_total"));
				order.setOrder_def(rs.getString("order_def"));
				list.add(order);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}
	/**
	 * 获得最大页码的方法
	 */
	public int getMaxPageNo(int pageSize){
		int count = 0;
		Connection conn = DBHelper.getConnection();
		String sql = "select count(*) from order1";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		//return (count-1)/pageSize+1;
		System.out.println(count);
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}
	

}
