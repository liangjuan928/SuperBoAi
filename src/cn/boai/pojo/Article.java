package cn.boai.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Article implements Serializable{
	public Article() {
	}
	
	private Integer article_id;
	private String article_title;
	private Date article_time;
	private String article_body;
	private String article_def;
	private String article_describe;
	private String article_type;
	public String getArticle_type() {
		return article_type;
	}
	public void setArticle_type(String article_type) {
		this.article_type = article_type;
	}
	public String getArticle_describe() {
		return article_describe;
	}
	public void setArticle_describe(String article_describe) {
		this.article_describe = article_describe;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public Date getArticle_time() {
		return article_time;
	}
	public void setArticle_time(Date article_time) {
		this.article_time = article_time;
	}
	public String getArticle_body() {
		return article_body;
	}
	public void setArticle_body(String article_body) {
		this.article_body = article_body;
	}
	public String getArticle_def() {
		return article_def;
	}
	public void setArticle_def(String article_def) {
		this.article_def = article_def;
	}
	
}
