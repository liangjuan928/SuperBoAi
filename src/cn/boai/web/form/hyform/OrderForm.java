package cn.boai.web.form.hyform;

import cn.boai.web.form.ActionForm;

public class OrderForm extends ActionForm{
	private String uid;
	private String pids;
	private String total;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPids() {
		return pids;
	}
	public void setPids(String pids) {
		this.pids = pids;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
}
