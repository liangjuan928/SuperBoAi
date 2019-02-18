package cn.boai.pojo;

import java.io.Serializable;

public class Cart implements Serializable{
	public Cart() {
	}

	private String user_id;
	private String pro_id;
	private String cart_def;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getCart_def() {
		return cart_def;
	}
	public void setCart_def(String cart_def) {
		this.cart_def = cart_def;
	}
	
}
