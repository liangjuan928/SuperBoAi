package cn.boai.web.core;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.web.form.ActionForm;


public class DispatcherAction implements Action{

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		System.out.println("DispatcherAction");
		String methodName = form.getParam();
		Class c = this.getClass();
		ActionResult af = null;
		if (methodName == null) {
			methodName = "undefined";
		}
		try {
			Method m = c.getMethod(methodName, new Class[] {
					HttpServletRequest.class, HttpServletResponse.class,
					ActionForm.class });
			af = (ActionResult) m.invoke(this, new Object[] { request,
					reponse, form });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return af;
		
	}
	public ActionResult undefined(HttpServletRequest request,
			HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		ResultContent rc=new ResultContent("error");
		
		return new ActionResult(rc,ResultType.Redirect);  //跳转到错误页面
	}
	

     
}
