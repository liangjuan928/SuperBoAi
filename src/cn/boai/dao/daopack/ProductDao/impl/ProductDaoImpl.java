package cn.boai.dao.daopack.ProductDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.boai.dao.daopack.ProductDao.ProductDao;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Address;
import cn.boai.pojo.Product;
import cn.boai.pojo.User;
import cn.boai.util.UUIDHelp;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean saveProduct(Product product, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into product(pro_id,pro_title,pro_describe,pro_key,pro_oldprice,pro_newprice,pro_sales,pro_photo,pro_intro,type_id,pro_def) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		String id=UUIDHelp.GetUUID();
		ps.setString(1, id);    //使用uuid作为主键
		ps.setString(2, product.getPro_title());
		ps.setString(3, product.getPro_describe());
		ps.setString(4, product.getPro_key());
		ps.setString(5, product.getPro_oldprice());
		ps.setString(6, product.getPro_newprice());
		ps.setString(7, product.getPro_sales());
		ps.setString(8, product.getPro_photo());
		ps.setString(9, product.getPro_intro());
		ps.setInt(10, product.getType_id());
		ps.setString(11,product.getPro_def());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	

	@Override
	public boolean updateProduct(Product product, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update product set pro_title=?,pro_describe=?,pro_key=?,pro_oldprice=?,pro_newprice=?,pro_sales=?,pro_photo=?,pro_intro=?,type_id=?,pro_def=? where pro_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, product.getPro_title());
		ps.setString(2,product.getPro_describe());
		ps.setString(3,product.getPro_key());
		ps.setString(4,product.getPro_oldprice());
		ps.setString(5,product.getPro_newprice());
		ps.setString(6,product.getPro_sales());
		ps.setString(7,product.getPro_photo());
		ps.setString(8,product.getPro_intro());
		ps.setInt(9,product.getType_id());
		ps.setString(10,product.getPro_def());
		ps.setString(11,product.getPro_id());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean deleteProduct(String id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from product where pro_id = ?";
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

	@Override
	public Product selectProductById(String id, Connection conn) throws Exception {
		Product product = null;
		String sql = "select * from product where pro_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			product = new Product();
			product.setPro_id(rs.getString("pro_id"));
			product.setPro_title(rs.getString("pro_title"));
			product.setPro_describe(rs.getString("pro_describe"));
			product.setPro_key(rs.getString("pro_key"));
			product.setPro_oldprice(rs.getString("pro_oldprice"));
			product.setPro_newprice(rs.getString("pro_newprice"));
			product.setPro_sales(rs.getString("pro_sales"));
			product.setPro_photo(rs.getString("pro_photo"));
			product.setPro_intro(rs.getString("pro_intro"));
			product.setType_id(rs.getInt("type_id"));
			product.setPro_def(rs.getString("pro_def"));
		}
		rs.close();
		ps.close();

		return product;
		
	}

	@Override
	public List<Product> selectAllProduct(Connection conn) throws Exception {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from product";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		Product product=null;
		while (rs.next()) {
			product = new Product();
			product.setPro_id(rs.getString("pro_id"));
			product.setPro_title(rs.getString("pro_title"));
			product.setPro_describe(rs.getString("pro_describe"));
			product.setPro_key(rs.getString("pro_key"));
			product.setPro_oldprice(rs.getString("pro_oldprice"));
			product.setPro_newprice(rs.getString("pro_newprice"));
			product.setPro_sales(rs.getString("pro_sales"));
			product.setPro_photo(rs.getString("pro_photo"));
			product.setPro_intro(rs.getString("pro_intro"));
			product.setType_id(rs.getInt("type_id"));
			product.setPro_def(rs.getString("pro_def"));
			list.add(product);
		}
		rs.close();
		ps.close();
		return list;
	}

}
