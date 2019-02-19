package cn.boai.dao.daopack.ProductDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Product;
import cn.boai.pojo.User;

public interface ProductDao {
	public boolean saveProduct(Product product,Connection conn) throws Exception;
	public boolean updateProduct(Product product,Connection conn) throws Exception;
	public boolean deleteProduct(String id,Connection conn) throws Exception;
	public Product selectProductById(String id,Connection conn) throws Exception;
	public List<Product> selectAllProduct(Connection conn) throws Exception;
}
