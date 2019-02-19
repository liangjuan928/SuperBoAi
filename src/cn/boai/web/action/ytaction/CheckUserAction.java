package cn.boai.web.action.ytaction;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.dao.ytdao.YtDao;
import cn.boai.dao.ytdao.impl.YtDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.User;
import cn.boai.service.ytservice.YtService;
import cn.boai.service.ytservice.impl.YtServiceImpl;
import cn.boai.util.ChangePass;
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.DispatcherAction;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;
import cn.boai.web.form.ytform.CheckUserForm;

public class CheckUserAction extends DispatcherAction{
	YtService ys=new YtServiceImpl();
	public ActionResult login(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException{
		CheckUserForm cf=(CheckUserForm)form;
		boolean result=false;
		ActionResult ar=null;
		
		result=ys.checkUser(cf);
		
		if(result){
			ResultContent rc = new ResultContent("to_index");			
			ar = new ActionResult(rc, ResultType.Forward); // 转发到to_login在属性文件中对应的jsp页面

		}else{
			ResultContent rc = new ResultContent("to_login");			
			ar = new ActionResult(rc, ResultType.Forward); // 转发到to_login在属性文件中对应的jsp页面
			
		}
		
		return ar;
	}
}
