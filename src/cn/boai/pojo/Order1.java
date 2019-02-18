package cn.boai.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Order1 implements Serializable{
	public Order1() {
	}

	private String order_id;
	private String user_id;
	private String pro_id;
	private Integer order_status;
	private Date order_time;
	private Integer order_pay;
	private Double order_total;
	private String order_def;
	public String getOrder_id() {
		return order_id;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", pro_id=" + pro_id + ", order_status="
				+ order_status + ", order_time=" + order_time + ", order_pay=" + order_pay + ", order_total="
				+ order_total + ", order_def=" + order_def + "]";
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public Integer getOrder_pay() {
		return order_pay;
	}
	public void setOrder_pay(Integer order_pay) {
		this.order_pay = order_pay;
	}
	public Double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(Double order_total) {
		this.order_total = order_total;
	}
	public String getOrder_def() {
		return order_def;
	}
	public void setOrder_def(String order_def) {
		this.order_def = order_def;
	}
	
}
