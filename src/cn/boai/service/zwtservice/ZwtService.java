package cn.boai.service.zwtservice;

import java.util.List;

import cn.boai.pojo.Comment;
import cn.boai.pojo.User;
import cn.boai.web.form.zwtform.AddCommForm;

public interface ZwtService {
	public boolean addComm(AddCommForm form);
	public List<Comment> queryCommByProid(String pro_id);
	public User queryUserById(String user_id);
}
