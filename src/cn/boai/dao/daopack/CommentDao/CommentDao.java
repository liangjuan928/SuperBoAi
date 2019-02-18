package cn.boai.dao.daopack.CommentDao;

import java.sql.Connection;
import java.util.List;

import cn.boai.pojo.Comment;

public interface CommentDao {
	public boolean saveComm(Comment comm,Connection conn) throws Exception;
	public boolean deleteComm(String id,Connection conn) throws Exception;
	public List<Comment> selectCommByProId(String id,Connection conn) throws Exception;
	public List<Comment> selectCommByStatus(String id,Integer type,Connection conn) throws Exception;
}
