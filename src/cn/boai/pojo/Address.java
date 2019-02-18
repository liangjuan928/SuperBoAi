package cn.boai.pojo;

import java.io.Serializable;

public class Address implements Serializable{
	public Address() {
	}
	
	private Integer add_id;
	private String user_id;
	private String add_info;
	private Integer add_status;
	private String add_name;
	private String add_number;
	private String add_def;
	public Integer getAdd_id() {
		return add_id;
	}
	public void setAdd_id(Integer add_id) {
		this.add_id = add_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAdd_info() {
		return add_info;
	}
	public void setAdd_info(String add_info) {
		this.add_info = add_info;
	}
	public Integer getAdd_status() {
		return add_status;
	}
	public void setAdd_status(Integer add_status) {
		this.add_status = add_status;
	}
	public String getAdd_name() {
		return add_name;
	}
	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}
	public String getAdd_number() {
		return add_number;
	}
	public void setAdd_number(String add_number) {
		this.add_number = add_number;
	}
	public String getAdd_def() {
		return add_def;
	}
	public void setAdd_def(String add_def) {
		this.add_def = add_def;
	}
	
	
	
}
