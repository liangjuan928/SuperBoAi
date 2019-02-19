package cn.boai.web.action.zwtaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.service.zwtservice.ZwtService;
import cn.boai.service.zwtservice.impl.ZwtServiceImpl;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.DispatcherAction;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;
import cn.boai.web.form.zwtform.AddCartForm;
import cn.boai.web.form.zwtform.AddCommForm;

public class AddCartAction extends DispatcherAction {
	ZwtService zs=new ZwtServiceImpl();

	public ActionResult addCart(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		AddCartForm af = (AddCartForm) form;
		boolean result = zs.addCart(af);
		ActionResult ar = null;
		ResultContent rc = new ResultContent("add_cart_jsp", result);
		if(result){
			System.out.println("加入购物车成功");
		}else{
			System.out.println("加入购物车失败");
		}
		ar = new ActionResult(rc, ResultType.Redirect);
		return ar;
	}
}
