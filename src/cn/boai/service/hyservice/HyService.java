package cn.boai.service.hyservice;

import java.util.List;
import java.util.Map;

import cn.boai.pojo.Order1;
import cn.boai.pojo.User;

public interface HyService {
	public User queryUserById(String uid);
	public boolean removeCart(String uid,String pid);
	public boolean addOrder(Order1 order);
	public List<Order1> queryAllOrder();
	public boolean updateProNum(String pid);
	public List<Order1> queryMohu(Map<String, String> condition);
}
