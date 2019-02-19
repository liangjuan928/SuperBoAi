package cn.boai.web.action.hyaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.pojo.User;
import cn.boai.service.hyservice.HyService;
import cn.boai.service.hyservice.impl.HyServiceImpl;
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;

public class MouseDivAction implements Action{
	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		HyService hs=new HyServiceImpl();
		String uid = request.getParameter("divid");
		User u=hs.queryUserById(uid);
		System.out.println("测试得到结果"+u.getUser_id()+u.getUser_name());
		return new ActionResult(new ResultContent("index",u),ResultType.Ajax);
	}
}
