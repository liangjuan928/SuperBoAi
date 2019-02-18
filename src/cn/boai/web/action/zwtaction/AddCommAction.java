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
import cn.boai.web.form.zwtform.AddCommForm;

public class AddCommAction extends DispatcherAction {
	ZwtService zs=new ZwtServiceImpl();

	public ActionResult addComm(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		AddCommForm af = (AddCommForm) form;
		boolean result = zs.addComm(af);
		ActionResult ar = null;
		ResultContent rc = new ResultContent("comm_jsp", result);
		if(result){
			System.out.println("添加评论成功");
		}else{
			System.out.println("添加评论失败");
		}
		ar = new ActionResult(rc, ResultType.Redirect);
		return ar;
	}
}
