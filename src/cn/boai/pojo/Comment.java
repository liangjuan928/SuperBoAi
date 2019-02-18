package cn.boai.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable{
	public Comment() {
	}
	
	private Integer com_id;
	private String com_content;
	private Date com_time;
	private Integer com_type;
	private String user_id;
	private String pro_id;
	private String com_def;
	public Integer getCom_id() {
		return com_id;
	}
	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public Date getCom_time() {
		return com_time;
	}
	public void setCom_time(Date com_time) {
		this.com_time = com_time;
	}
	public Integer getCom_type() {
		return com_type;
	}
	public void setCom_type(Integer com_type) {
		this.com_type = com_type;
	}
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
	public String getCom_def() {
		return com_def;
	}
	public void setCom_def(String com_def) {
		this.com_def = com_def;
	}
	
	

}
