package cn.boai.web.action.hyaction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;

public class MohuAction implements Action{

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		String hao = request.getParameter("hao");
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("hao============="+hao);
		
		if(!"".equals(hao)){
			map.put("hao",hao);
		}
		
		request.setAttribute("map",map);
		request.setAttribute("hao",hao);
		
		return new ActionResult(new ResultContent("order",map),ResultType.Forward);
	}
	
}
