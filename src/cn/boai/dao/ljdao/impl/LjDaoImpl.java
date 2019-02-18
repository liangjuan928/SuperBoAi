package cn.boai.dao.ljdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.boai.dao.ljdao.LjDao;
import cn.boai.pojo.Article;
import cn.boai.pojo.Product;

public class LjDaoImpl implements LjDao {
	/**
	 * 获取文章最大页码
	 */
	@Override
	public int getArticleMaxPageNum(int pagesize, Connection conn) throws Exception {
		String sql = "select count(*) num from article";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int result = -1;
		int number = -1;
		if (rs.next()) {
			result = rs.getInt("num");
		}
		return (result - 1) / pagesize + 1;
	}

	/**
	 * 获取文章的分页数据集合
	 */
	@Override
	public List<Article> SplitArticleList(int curpage, int pagesize, Connection conn) throws Exception {
		List<Article> list = new ArrayList<>();
		String sql = "select * from article limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (curpage - 1) * pagesize);
		ps.setInt(2, pagesize);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Article article = new Article();
			article.setArticle_id(rs.getInt("article_id"));
			article.setArticle_title(rs.getString("article_title"));
			article.setArticle_time(rs.getDate("article_time"));
			article.setArticle_body(rs.getString("article_body"));
			article.setArticle_def(rs.getString("article_defalt"));
			article.setArticle_describe(rs.getString("article_describe"));
			article.setArticle_type(rs.getString("article_type"));
			list.add(article);
		}
		rs.close();
		ps.close();
		return list;
	}

	
	
	@Override
	public List<Product> SplitProductListByKey(String keys, Connection conn) throws Exception {
		String sql="select * from product  where  pro_key like ? ";
		List<Product> list = new ArrayList<Product>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1,keys);
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

	@Override
	public List<Product> SplitProductListByType(int type, Connection conn) throws Exception {
		String sql="select * from product  where  pro_type = ? ";
		List<Product> list = new ArrayList<Product>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1,type);
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

	@Override
	public List<Product> SplitProductListBySale(Connection conn) throws Exception {
		String sql="select * from product ORDER BY pro_sales ";
		List<Product> list = new ArrayList<Product>();
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
	@Override
	public List<Product> SplitProductListByPrice(double price, Connection conn) throws Exception {
		String sql="select * from product ORDER BY pro_newprice";
		List<Product> list = new ArrayList<Product>();
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
