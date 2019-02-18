package cn.boai.web.form.ljform;

import cn.boai.web.form.ActionForm;

public class AddArticleForm extends ActionForm {
	private String title;
	private String describe;
	private String type;
	private String conent;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getConent() {
		return conent;
	}
	public void setConent(String conent) {
		this.conent = conent;
	}
}
