package cn.boai.dao.daopack.OrderDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Test;

import com.sun.org.apache.xerces.internal.parsers.DTDConfiguration;

import cn.boai.dao.daopack.OrderDao.OrderDao;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Order1;
import cn.boai.pojo.Product;
import cn.boai.pojo.User;
import cn.boai.util.UUIDHelp;

public class OrderDaoImpl implements OrderDao {
	/**
	 * 此方法sql语句有问题，插入失败(可能是外键对应的表没有)
	 */
	@Override
	public boolean saveOrder(Order1 order, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into order1(order_id,user_id,pro_id,order_status,order_time,order_pay,order_total,order_def) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		String id=UUIDHelp.GetUUID();
		ps.setString(1, id);    //使用uuid作为主键
		ps.setString(2, order.getUser_id());
		ps.setString(3, order.getPro_id());
		ps.setInt(4, order.getOrder_status());
		ps.setDate(5, order.getOrder_time());
		ps.setInt(6, order.getOrder_pay());
		ps.setDouble(7, order.getOrder_total());
		ps.setString(8, order.getOrder_def());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	/**
	 * 测试插入功能（出错）
	 */
	@Test
	public void Test(){
		Connection conn=DBHelper.getConnection();
		Order1 order=new Order1();
		order.setPro_id("123");
		order.setUser_id("456");
		order.setOrder_pay(2);
		order.setOrder_status(0);
		Date date=new Date(12000);
		java.sql.Date date2 =new java.sql.Date(date.getTime());
		order.setOrder_time(date2);
		order.setOrder_total(45.3);
		order.setOrder_def("000000");
		
		try {
			if(saveOrder(order, conn)){
				System.out.println("插入成功");
			}else{
				System.out.println("插入失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean updateOrder(Order1 order, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update order1 set user_id=?,pro_id=?,order_status=?,order_time=?,order_pay=?,order_total=?,order_def=? where order_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, order.getUser_id());
		ps.setString(2, order.getPro_id());
		ps.setInt(3, order.getOrder_status());
		ps.setDate(4, order.getOrder_time());
		ps.setInt(5, order.getOrder_pay());
		ps.setDouble(6, order.getOrder_total());
		ps.setString(7, order.getOrder_def());
		ps.setString(8, order.getOrder_id());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	/**
	 * 测试更新方法（报同上一样的错）
	 */
	@Test
	public void testUpdate(){
		Connection conn=DBHelper.getConnection();
		Order1 order=new Order1();
		order.setOrder_id("123");
		order.setOrder_status(1);
		order.setOrder_pay(1);
		order.setOrder_total(15.5);
		try {
		if(	updateOrder(order, conn)){
			System.out.println("更新成功");
		}else{
			System.out.println("更新失败");
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@Override
	public boolean deleteOrder(String id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from order1 where order_id = ?";
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
	/**
	 * 测试删除方法(报同上一样的错)
	 */
	@Test
	public void testDelete(){
		Connection conn=DBHelper.getConnection();
		
		try {
		if(	deleteOrder("123", conn)){
			System.out.println("更新成功");
		}else{
			System.out.println("更新失败");
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Order1 selectOrderById(String id, Connection conn) throws Exception {
		Order1 order = null;
		String sql = "select * from order1 where order_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			order = new Order1();
			order.setOrder_id(rs.getString("order_id"));
			order.setUser_id(rs.getString("user_id"));
			order.setPro_id(rs.getString("pro_id"));
			order.setOrder_status(rs.getInt("order_status"));
			order.setOrder_time(rs.getDate("order_time"));
			order.setOrder_pay(rs.getInt("order_pay"));
			order.setOrder_total(rs.getDouble("order_total"));
			order.setOrder_def(rs.getString("order_def"));
		}
		rs.close();
		ps.close();
		return order;
	}
	/**
	 * 测试selectOrderById方法（报同上一样的错）
	 */
	@Test
	public void Testsi(){
		Connection conn=DBHelper.getConnection();
		try {
			if(selectOrderById("123", conn)!=null){
				System.out.println("选择成功");
			}else{
				System.out.println("选择失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Order1> selectAllOrder(Connection conn) throws Exception {
		List<Order1> list = new ArrayList<Order1>();
		String sql = "select * from order1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		Order1 order=null;
		while (rs.next()) {
			order = new Order1();
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
	 * 测试selectAllOrder方法 （报同上一样的错）
	 */
	@Test
	public void Testsa(){
		Connection conn=DBHelper.getConnection();
		try {
			if(selectAllOrder(conn).size()==1){
				System.out.println("全选成功");
			}else{
				System.out.println("全选失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Connection conn=DBHelper.getConnection();
		OrderDao od=new OrderDaoImpl();
		Order1 order=new Order1();
		order.setOrder_id("111");
		order.setOrder_pay(50);
		order.setOrder_status(1);
		Date date=new Date();
		java.sql.Date d= new java.sql.Date(date.getTime());
		order.setOrder_time(d);
		order.setOrder_total(45.3);
		order.setOrder_def("000000");
		order.setUser_id("123");
		order.setPro_id("321");
		try {
			od.saveOrder(order, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
