package cn.boai.service.zwtservice;

import java.util.List;

import cn.boai.pojo.Comment;
import cn.boai.pojo.Product;
import cn.boai.pojo.User;
import cn.boai.web.form.zwtform.AddCartForm;
import cn.boai.web.form.zwtform.AddCommForm;
import cn.boai.web.form.zwtform.AddProductForm;

public interface ZwtService {
	public boolean addComm(AddCommForm form);
	public List<Comment> queryCommByProid(String pro_id);
	public User queryUserById(String user_id);
	public Product queryProductById(String pro_id);
	public boolean addProduct(AddProductForm form);
	public int getCommMaxPageNum(String pro_id,int pagesize);  //获得最大页码数
	public List<Comment> SplitCommList(String pro_id,int curpage,int pagesize);  //获得最大页码数
	public boolean addCart(AddCartForm form);
	
}
