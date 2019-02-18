package cn.boai.dao.daopack.ArticleDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Article;
import cn.boai.pojo.Product;

public interface ArticleDao {
	public boolean saveArticle(Article article,Connection conn) throws Exception;
	public boolean updateArticle(Article article,Connection conn) throws Exception;
	public boolean deleteArticle(String id,Connection conn) throws Exception;
	public Article selectArticleById(int id,Connection conn) throws Exception;
	public List<Article> selectAllArticle(Connection conn) throws Exception;
}
