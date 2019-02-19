package cn.boai.dao.hydao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;


import cn.boai.dao.daopack.ProductDao.impl.ProductDaoImpl;
import cn.boai.dao.hydao.HyDao;
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
	

}
