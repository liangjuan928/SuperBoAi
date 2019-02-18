package cn.boai.dao.ljdao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Article;
import cn.boai.pojo.Product;

public interface LjDao {
	 public int getArticleMaxPageNum(int pagesize,Connection conn)throws Exception;  //获得最大页码数
	 public List<Article> SplitArticleList(int curpage,int pagesize,Connection conn)throws Exception;  //获得最大页码数
       
	 public List<Product> SplitProductListByKey(String keys,Connection conn) throws Exception;
     public List<Product> SplitProductListByType(int type,Connection conn) throws Exception;
     public List<Product> SplitProductListBySale(Connection conn) throws Exception;
     public List<Product> SplitProductListByPrice(double price,Connection conn) throws Exception;
     

}
