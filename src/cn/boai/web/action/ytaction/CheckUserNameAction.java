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
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.DispatcherAction;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;

public class CheckUserNameAction extends DispatcherAction{
	YtDao yd=new YtDaoImpl();
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException{
		boolean result=false;
		ActionResult ar=null;
		String s = request.getParameter("uname");
		System.out.println(s);
		s = URLDecoder.decode(s,"UTF-8");
		System.out.println("解码："+s);
		Connection conn=DBHelper.getConnection();
		try{
			result=yd.checkUserByUserName(s,conn);
			System.out.println("result:"+result);
//			request.setAttribute("send", result);
			ResultContent rc = new ResultContent("to_register",result); // 转发到to_register在属性文件中对应的jsp页面
			ar = new ActionResult(rc, ResultType.Ajax);					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return ar;
	}

}
