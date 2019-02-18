package cn.boai.web.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.web.form.ActionForm;


public interface Action {
	public ActionResult execute(HttpServletRequest request,HttpServletResponse reponse,ActionForm  form)throws ServletException, IOException;
	
}
