package cn.boai.web.form.zwtform;

import cn.boai.web.form.ActionForm;

public class AddCartForm extends ActionForm {
	private String pro_id;
	private String user_id;
	private String cart_def;
	private String pro_num;
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCart_def() {
		return cart_def;
	}
	public void setCart_def(String cart_def) {
		this.cart_def = cart_def;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	
}
