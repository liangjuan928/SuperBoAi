package cn.boai.web.action.zwtaction;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
import cn.boai.web.form.zwtform.AddProductForm;
import sun.misc.BASE64Decoder;

public class AddProductAction extends DispatcherAction {
	ZwtService zs = new ZwtServiceImpl();

	public ActionResult addProduct(HttpServletRequest request, HttpServletResponse response, ActionForm form)
	 		throws ServletException, IOException {
		AddProductForm af = (AddProductForm) form;
		BASE64Decoder decoder = new BASE64Decoder();
		String photo=af.getPro_photo();
		byte[] b = decoder.decodeBuffer(photo.substring(photo.indexOf(",")+1));
		String path = request.getServletContext().getRealPath("/");
		path +="upload/"+new Date().getTime()+"."+af.getPhoto_type();
		System.out.println(path);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
		bos.write(b);
		bos.flush();
		bos.close();
		af.setPro_photo(path);
		boolean result = zs.addProduct(af);
		ActionResult ar = null;
		ResultContent rc = new ResultContent("add_product_jsp", result);
		if(result){
			System.out.println("添加产品成功");
		}else{
			System.out.println("添加产品失败");
		}
		ar = new ActionResult(rc, ResultType.Redirect);
		return ar;
	}
}
