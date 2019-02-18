package cn.boai.dao.zwtdao;

import java.sql.Connection;
import java.util.List;
import cn.boai.pojo.Article;
import cn.boai.pojo.Comment;

public interface ZwtDao{
	public int getCommMaxPageNum(String pro_id,int pagesize,Connection conn)throws Exception;  //获得最大页码数
	public List<Comment> SplitCommList(String pro_id,int curpage,int pagesize,Connection conn)throws Exception;  //获得最大页码数
}  
