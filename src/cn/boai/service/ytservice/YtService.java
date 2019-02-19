package cn.boai.service.ytservice;

import cn.boai.web.form.ytform.AddUsersForm;
import cn.boai.web.form.ytform.CheckUserForm;

public interface YtService {
	public boolean addUser(AddUsersForm form);
	public boolean checkUser(CheckUserForm form);
}
