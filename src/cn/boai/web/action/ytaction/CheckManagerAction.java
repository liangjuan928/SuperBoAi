package cn.boai.web.action.ytaction;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.dao.ytdao.YtDao;
import cn.boai.dao.ytdao.impl.YtDaoImpl;
import cn.boai.db.DBHelper;
import cn.boai.pojo.User;
import cn.boai.util.ChangePass;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.DispatcherAction;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;

public class CheckManagerAction extends DispatcherAction{
    YtDao yd=new YtDaoImpl();
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException{
		System.out.print("aaa");
		Connection conn=DBHelper.getConnection();
		User user=new User();
		boolean result=false;
		ActionResult ar=null;
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		System.out.println(uname);
//		s = URLDecoder.decode(s,"UTF-8");
//		System.out.println("解码："+s);
		try{
			result=yd.checkUserByUserName(uname,conn);
			if(result){
				user=yd.selectUserByUserName(uname, conn);
				String pass_database=user.getUser_password();
				String pass_form=ChangePass.Change(upass);
				if(pass_database.equals(pass_form)){
					System.out.println("密码正确");
					ResultContent rc = new ResultContent("login_success",result); // 转发到在属性文件中对应的页面
					ar = new ActionResult(rc, ResultType.Forward);					
				}else{
					
					ResultContent rc = new ResultContent("to_login",result);
					ar = new ActionResult(rc, ResultType.Forward);	
				}				
			}
			else{
				  ResultContent rc = new ResultContent("to_login",result);
				  ar = new ActionResult(rc, ResultType.Forward);
			}
			System.out.println("result:"+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return ar;
	}
}
