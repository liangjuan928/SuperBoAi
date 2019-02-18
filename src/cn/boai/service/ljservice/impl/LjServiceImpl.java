package cn.boai.service.ljservice.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.boai.dao.daopack.ArticleDao.ArticleDao;
import cn.boai.dao.daopack.ArticleDao.impl.ArticleDaoImpl;
import cn.boai.dao.ljdao.LjDao;
import cn.boai.dao.ljdao.impl.LjDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Article;
import cn.boai.service.ljservice.LjService;
import cn.boai.web.form.ljform.AddArticleForm;

public class LjServiceImpl implements LjService{
      ArticleDao ad=new ArticleDaoImpl();
      LjDao ld=new LjDaoImpl();
	@Override
	public boolean addArticle(AddArticleForm form) {
		Connection conn=DBHelper.getConnection();
		Article article=new Article();
		article.setArticle_title(form.getTitle());
		article.setArticle_body(form.getConent());
		article.setArticle_describe(form.getDescribe());
		Date date=new Date();
		java.sql.Date date2 =new java.sql.Date(date.getTime());
		article.setArticle_time(date2);
		article.setArticle_type(form.getType());
		boolean result=false;
		try {
			result=ad.saveArticle(article, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return result;
	}

	@Override
	public List<Article> selectAllActicle() {
		Connection conn=DBHelper.getConnection();
		List<Article> list=null;
		try {
			list=ad.selectAllArticle(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public int getArticleMaxPageNum(int pagesize) {
		Connection conn=DBHelper.getConnection();
		int result=0;
	try {
		 result=ld.getArticleMaxPageNum(pagesize, conn);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBHelper.closeConnection(conn);
	}
		return result;
	}

	@Override
	public List<Article> SplitArticleList(int curpage, int pagesize) {
		Connection conn=DBHelper.getConnection();
		List<Article> list=null;
	try {
		 list=ld.SplitArticleList(curpage, pagesize, conn);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBHelper.closeConnection(conn);
	}
		return list;
	}

	@Override
	public Article getArticleById(int id) {
		Connection conn=DBHelper.getConnection();
		Article article=new Article();
	try {
		article=ad.selectArticleById(id, conn);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBHelper.closeConnection(conn);
	}
		return article;
	}
	
	}
      
	

