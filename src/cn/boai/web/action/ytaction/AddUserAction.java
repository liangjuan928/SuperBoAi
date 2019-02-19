package cn.boai.web.action.ytaction;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
import sun.misc.BASE64Decoder;

public class AddUserAction extends DispatcherAction{
	YtService ys=new YtServiceImpl(); 
	
	public ActionResult addUser(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)throws ServletException, IOException{
		AddUsersForm af = (AddUsersForm) form;
		
		BASE64Decoder decoder = new BASE64Decoder();
		String photo=af.getPhoto();
		byte[] b = decoder.decodeBuffer(photo.substring(photo.indexOf(",")+1));
		String path = request.getServletContext().getRealPath("/");
		path +="upload/images/"+new Date().getTime()+"."+af.getPhoto_type();
		System.out.println(path);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
		bos.write(b);
		bos.flush();
		bos.close();
		af.setPhoto(path);
		
		ActionResult ar=null;
		boolean result = ys.addUser(af);
		System.out.println("adduser--"+result);
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
