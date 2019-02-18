package cn.boai.pojo;

import java.io.Serializable;

public class Product implements Serializable{
	public Product() {
	}
	
	private String pro_id="";
	private String pro_title="";
	private String pro_describe="";
	private String pro_key="";
	private String pro_oldprice="";
	private String pro_newprice="";
	private String pro_sales="";
	private String pro_photo="";
	private String pro_intro="";
	private Integer type_id=0;
	private String pro_def="";
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_title() {
		return pro_title;
	}
	public void setPro_title(String pro_title) {
		this.pro_title = pro_title;
	}
	@Override
	public String toString() {
		return "Product [pro_id=" + pro_id + ", pro_title=" + pro_title + ", pro_describe=" + pro_describe
				+ ", pro_key=" + pro_key + ", pro_oldprice=" + pro_oldprice + ", pro_newprice=" + pro_newprice
				+ ", pro_sales=" + pro_sales + ", pro_photo=" + pro_photo + ", pro_intro=" + pro_intro + ", type_id="
				+ type_id + ", pro_def=" + pro_def + "]";
	}
	public String getPro_describe() {
		return pro_describe;
	}
	public void setPro_describe(String pro_describe) {
		this.pro_describe = pro_describe;
	}
	public String getPro_key() {
		return pro_key;
	}
	public void setPro_key(String pro_key) {
		this.pro_key = pro_key;
	}
	public String getPro_oldprice() {
		return pro_oldprice;
	}
	public void setPro_oldprice(String pro_oldprice) {
		this.pro_oldprice = pro_oldprice;
	}
	public String getPro_newprice() {
		return pro_newprice;
	}
	public void setPro_newprice(String pro_newprice) {
		this.pro_newprice = pro_newprice;
	}
	public String getPro_sales() {
		return pro_sales;
	}
	public void setPro_sales(String pro_sales) {
		this.pro_sales = pro_sales;
	}
	public String getPro_photo() {
		return pro_photo;
	}
	public void setPro_photo(String pro_photo) {
		this.pro_photo = pro_photo;
	}
	public String getPro_intro() {
		return pro_intro;
	}
	public void setPro_intro(String pro_intro) {
		this.pro_intro = pro_intro;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getPro_def() {
		return pro_def;
	}
	public void setPro_def(String pro_def) {
		this.pro_def = pro_def;
	}
	
	
}
