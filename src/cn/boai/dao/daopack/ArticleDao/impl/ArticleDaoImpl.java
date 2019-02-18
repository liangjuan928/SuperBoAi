package cn.boai.dao.daopack.ArticleDao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.boai.dao.daopack.ArticleDao.ArticleDao;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Article;
import cn.boai.pojo.Order1;
import cn.boai.pojo.Product;
import cn.boai.util.UUIDHelp;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public boolean saveArticle(Article article, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into article(article_title,article_time,article_body,article_defalt,article_describe,article_type) values(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1,article.getArticle_title());
		ps.setDate(2,article.getArticle_time());
		ps.setString(3,article.getArticle_body());
		ps.setString(4,article.getArticle_def());
		ps.setString(5, article.getArticle_describe());
		ps.setString(6, article.getArticle_type());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	

	
	

	@Override
	public boolean updateArticle(Article article, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update article set article_title=?,article_time=?,article_body=?,article_defalt=?,article_describe=?,article_type where article_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, article.getArticle_title());
		ps.setDate(2, article.getArticle_time());
		ps.setString(3, article.getArticle_body());
		ps.setString(4, article.getArticle_def());
		ps.setInt(5, article.getArticle_id());
		ps.setString(6, article.getArticle_describe());
		ps.setString(7, article.getArticle_type());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	
	
	
	

	@Override
	public boolean deleteArticle(String id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from article where article_id = ?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		int n = ps.executeUpdate();
		System.out.println("nnn:"+n);
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}
	
	
	@Override
	public Article selectArticleById(int id, Connection conn) throws Exception {
		Article article = null;
		String sql = "select * from article where article_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			article = new Article();
			article.setArticle_id(rs.getInt("article_id"));
			article.setArticle_title(rs.getString("article_title"));
			article.setArticle_time(rs.getDate("article_time"));
			article.setArticle_body(rs.getString("article_body"));
			article.setArticle_def(rs.getString("article_defalt"));
			article.setArticle_describe(rs.getString("article_describe"));
			article.setArticle_type(rs.getString("article_type"));
		}
		rs.close();
		ps.close();
		return article;
	}
	

	@Override
	public List<Article> selectAllArticle(Connection conn) throws Exception {
		List<Article> list = new ArrayList<Article>();
		String sql = "select * from article ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		Article article=null;
		while (rs.next()) {
			article = new Article();
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
	
}
