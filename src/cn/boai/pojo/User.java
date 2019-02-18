package cn.boai.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_sex;
	private String user_photo;
	private Date user_time;
	private String user_level;
	private String user_def;
	
	public User() {
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	public Date getUser_time() {
		return user_time;
	}

	public void setUser_time(Date user_time) {
		this.user_time = user_time;
	}

	public String getUser_level() {
		return user_level;
	}

	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}

	public String getUser_def() {
		return user_def;
	}

	public void setUser_def(String user_def) {
		this.user_def = user_def;
	}

	
}
