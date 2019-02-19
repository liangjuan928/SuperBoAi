package cn.boai.web.action.ytaction;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.DispatcherAction;
import cn.boai.web.form.ActionForm;
import cn.boai.web.form.ytform.AddPhotosFrom;
import sun.misc.BASE64Decoder;

public class AddPhotoAction extends DispatcherAction{

	public ActionResult Addphoto(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		System.out.println("hhh");
		AddPhotosFrom ap=(AddPhotosFrom)form;
		BASE64Decoder bDecoder=new BASE64Decoder();
		String photo = ap.getUphoto();
		byte[] dephoto=bDecoder.decodeBuffer(photo.substring(photo.indexOf(",")+1));
		String path=request.getServletContext().getRealPath("/");
		path+="user_photo/"+new Date().getTime()+"."+ap.getPhoto_type();
		System.out.println(path);
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(path));
		bos.write(dephoto);
		bos.flush();
		bos.close();
		//已经改变存入路径
		ap.setPro_photo(path);
		
		return null;
	}

}
