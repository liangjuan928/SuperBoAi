package cn.boai.web.action.hyaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.service.hyservice.HyService;
import cn.boai.service.hyservice.impl.HyServiceImpl;
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;

public class DeleteCartAction implements Action{
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		HyService hs=new HyServiceImpl();
		
		String uid=request.getParameter("uid");
		String pid=request.getParameter("proid");
		boolean flag=hs.removeCart(uid,pid);
		System.out.println(uid);
		System.out.println(pid);
		System.out.println(flag);
		return new ActionResult(new ResultContent("shopcart",flag),ResultType.Forward);
	}
}
