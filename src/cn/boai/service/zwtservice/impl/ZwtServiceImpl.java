package cn.boai.service.zwtservice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import cn.boai.dao.daopack.AddressDao.AddressDao;
import cn.boai.dao.daopack.CartDao.CartDao;
import cn.boai.dao.daopack.CartDao.impl.CartDaoImpl;
import cn.boai.dao.daopack.CommentDao.CommentDao;
import cn.boai.dao.daopack.CommentDao.impl.CommentDaoImpl;
import cn.boai.dao.daopack.ProductDao.ProductDao;
import cn.boai.dao.daopack.ProductDao.impl.ProductDaoImpl;
import cn.boai.dao.daopack.UserDao.UserDao;
import cn.boai.dao.daopack.UserDao.impl.UserDaoImpl;
import cn.boai.dao.zwtdao.ZwtDao;
import cn.boai.dao.zwtdao.impl.ZwtDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.Address;
import cn.boai.pojo.Article;
import cn.boai.pojo.Cart;
import cn.boai.pojo.Comment;
import cn.boai.pojo.Product;
import cn.boai.pojo.User;
import cn.boai.service.zwtservice.ZwtService;
import cn.boai.web.form.zwtform.AddCartForm;
import cn.boai.web.form.zwtform.AddCommForm;
import cn.boai.web.form.zwtform.AddProductForm;

public class ZwtServiceImpl implements ZwtService{
	
	CommentDao cd=new CommentDaoImpl();
	UserDao ud=new UserDaoImpl();
	ProductDao pd=new ProductDaoImpl();
	ZwtDao zd=new ZwtDaoImpl();
	CartDao cad=new CartDaoImpl();
   
	@Override
	public boolean addComm(AddCommForm form) {
		Connection conn=DBHelper.getConnection();
		Comment comm=new Comment();
		comm.setCom_content(form.getComm_content());
		comm.setCom_type(Integer.valueOf(form.getComm_type()));
		comm.setPro_id(form.getPro_id());
		comm.setUser_id(form.getUser_id());
		Date date=new Date();
		java.sql.Date d =new java.sql.Date(date.getTime());
		comm.setCom_time(d);
		boolean flag=false;
		try {
			conn.setAutoCommit(false);
			flag = cd.saveComm(comm, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Comment> queryCommByProid(String pro_id) {
		Connection conn=DBHelper.getConnection();
		List<Comment> list=null;
		try {
			list=cd.selectCommByProId(pro_id, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User queryUserById(String user_id) {
		Connection conn=DBHelper.getConnection();
		User user=null;
		try {
			user=ud.selectUserById(user_id, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Product queryProductById(String pro_id) {
		Connection conn=DBHelper.getConnection();
		Product product=null;
		try {
			product=pd.selectProductById(pro_id, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean addProduct(AddProductForm form) {
		Connection conn=DBHelper.getConnection();
		Product pro=new Product();
		pro.setPro_title(form.getPro_title());
		pro.setPro_describe(form.getPro_describe());
		pro.setPro_key(form.getPro_key());
		pro.setPro_oldprice(form.getPro_oldprice());
		pro.setPro_newprice(form.getPro_newprice());
		pro.setPro_photo(form.getPro_photo());
		pro.setType_id(Integer.valueOf(form.getPro_type()));
		pro.setPro_intro(form.getPro_intro());
		pro.setPro_def(form.getPro_def());
		System.out.println(form.getPro_photo()+"==="+form.getPro_intro());
		
		boolean flag=false;
		try {
			conn.setAutoCommit(false);
			flag = pd.saveProduct(pro, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public int getCommMaxPageNum(String pro_id,int pagesize) {
		Connection conn=DBHelper.getConnection();
		int result=0;
		try {
			 result=zd.getCommMaxPageNum(pro_id,pagesize, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
			return result;
	}

	@Override
	public List<Comment> SplitCommList(String pro_id,int curpage, int pagesize) {
		Connection conn=DBHelper.getConnection();
		List<Comment> list=null;
		try {
			 list=zd.SplitCommList(pro_id,curpage, pagesize, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean addCart(AddCartForm form) {
		Connection conn=DBHelper.getConnection();
		Cart cart=new Cart();
		cart.setPro_id(form.getPro_id());
		cart.setUser_id(form.getUser_id());
		cart.setCart_def(form.getCart_def());
		cart.setPro_num(Integer.valueOf(form.getPro_num()));

		boolean flag=false;
		try {
			conn.setAutoCommit(false);
			flag = cad.saveCart(cart, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	

}
