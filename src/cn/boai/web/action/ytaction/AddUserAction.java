package cn.boai.web.action.ytaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.pojo.User;
import cn.boai.service.ytservice.YtService;
import cn.boai.service.ytservice.impl.YtServiceImpl;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.DispatcherAction;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;
import cn.boai.web.form.ytform.AddUsersForm;

public class AddUserAction extends DispatcherAction{
	YtService ys=new YtServiceImpl(); 
	
	public ActionResult addUser(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)throws ServletException, IOException{
		AddUsersForm af = (AddUsersForm) form;
		ActionResult ar=null;
		boolean result = ys.addUser(af);
		System.out.println(result);
		request.setAttribute("fasong", result);
		if(result){
			ResultContent rc = new ResultContent("to_login");			
			ar = new ActionResult(rc, ResultType.Forward); // 转发到to_login在属性文件中对应的jsp页面

		}else{
			ResultContent rc = new ResultContent("to_register");			
			ar = new ActionResult(rc, ResultType.Forward); // 转发到to_login在属性文件中对应的jsp页面
			
		}
		return ar;		
	}
	
}
