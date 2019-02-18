package cn.boai.service.ljservice;

import java.util.List;

import com.mysql.jdbc.Connection;

import cn.boai.pojo.Address;
import cn.boai.pojo.Article;
import cn.boai.pojo.Product;
import cn.boai.web.form.ljform.AddArticleForm;

public interface LjService {
	public boolean addArticle(AddArticleForm form);
	public List<Article> selectAllActicle();
	
	 public int getArticleMaxPageNum(int pagesize);  //获得最大页码数
	 public List<Article> SplitArticleList(int curpage,int pagesize);  //获得最大页码数
	 public Article getArticleById(int id);
	 
	 
	 public List<Product> SplitProductListByKey(String keys);
     public List<Product> SplitProductListByType(int type);
     public List<Product> SplitProductListBySale();
     public List<Product> SplitProductListByPrice(double price);
}
