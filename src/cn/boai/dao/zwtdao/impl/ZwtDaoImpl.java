package cn.boai.dao.zwtdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.boai.dao.zwtdao.ZwtDao;
import cn.boai.pojo.Article;
import cn.boai.pojo.Comment;

public class ZwtDaoImpl implements ZwtDao{

	@Override
	public int getCommMaxPageNum(String pro_id,int pagesize, Connection conn) throws Exception {
		String sql="select count(*) num from comment where pro_id=?";
		PreparedStatement ps = null;
		System.out.println(pro_id+"----------aa");
		ps = conn.prepareStatement(sql);
		ps.setString(1, pro_id);
	    ResultSet rs=ps.executeQuery();
	    int result=-1;
	    if(rs.next()){
	    	 result=rs.getInt("num");
	    }
		return (result-1)/pagesize+1;
	}

	@Override
	public List<Comment> SplitCommList(String pro_id,int curpage, int pagesize, Connection conn) throws Exception {
		List<Comment> list=new ArrayList<>();
		String sql="select * from comment WHERE pro_id=? ORDER BY com_id DESC limit ?,?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, pro_id);
		ps.setInt(2,(curpage-1)*pagesize);
		ps.setInt(3,pagesize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Comment comm=new Comment();
			comm.setCom_id(rs.getInt("com_id"));
			comm.setPro_id(rs.getString("pro_id"));
			comm.setUser_id(rs.getString("user_id"));
			comm.setCom_content(rs.getString("com_content"));
			comm.setCom_time(rs.getDate("com_time"));
			comm.setCom_type(rs.getInt("com_type"));
			comm.setCom_def(rs.getString("com_def"));
			
			list.add(comm);
		}
		rs.close();
		ps.close();
		return list;
	}

	

}
