package cn.boai.web.form.ytform;

import cn.boai.web.form.ActionForm;

public class CheckManagersForm extends ActionForm{
	String managername;
	String managerpass;
	
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerpass() {
		return managerpass;
	}
	public void setManagerpass(String managerpass) {
		this.managerpass = managerpass;
	}
}
