package cn.boai.web.action.hyaction;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.pojo.Order1;
import cn.boai.service.hyservice.impl.HyServiceImpl;
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;

public class AddOrderAction implements Action{
	private HyServiceImpl hs=new HyServiceImpl();

	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pids=request.getParameter("pids");
		String total=request.getParameter("total");
		System.out.println(uid);
		System.out.println(pids);
		System.out.println(total);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String time=df.format(System.currentTimeMillis()); 
		
		Order1 order=new Order1();
		order.setOrder_id(time);
		order.setOrder_pay(1);
		order.setOrder_status(1);
		order.setOrder_time(new Date(System.currentTimeMillis()));
		order.setOrder_total(Double.parseDouble(total));
		order.setPro_id(pids);
		order.setUser_id(uid);
		
		boolean flag=hs.addOrder(order);
		System.out.println(flag+"=============================addOrder"); 
		
		request.getSession().setAttribute("newOrder", flag);
		
		return new ActionResult(new ResultContent("shopcart"));
	}

}
