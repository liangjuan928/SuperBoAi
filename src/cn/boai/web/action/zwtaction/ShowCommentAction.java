package cn.boai.web.action.zwtaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boai.pojo.Comment;
import cn.boai.service.zwtservice.ZwtService;
import cn.boai.service.zwtservice.impl.ZwtServiceImpl;
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;


public class ShowCommentAction implements Action  {
	ZwtService zs=new ZwtServiceImpl();

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		System.out.println("=====");
		String strpage=request.getParameter("page");
		String pro_id=(String)request.getSession().getAttribute("pro_id");
		if(strpage==null){  //如果是第一次加载就默认在第一页
			strpage="1";
		}
		int page=Integer.parseInt(strpage);
		int maxpagenum=zs.getCommMaxPageNum(pro_id,6);
		if(page==-1||(page>maxpagenum)){   
			page=maxpagenum;
		}
		if(page<1){
			page=1;
		}
		List<Comment> list=zs.SplitCommList(pro_id,page, 6); 
		request.setAttribute("page",page);
		request.setAttribute("commlist", list);   //将添加结果返回给页面
		ActionResult ar = null;
		if(list!=null){
			ResultContent rc = new ResultContent("comm_jsp");
			ar = new ActionResult(rc, ResultType.Forward); // 转发到add_articl在属性文件中对应的jsp页面
		}else{
			ResultContent rc = new ResultContent("error_jsp");
			ar = new ActionResult(rc, ResultType.Forward); // 转发到add_articl在属性文件中对应的jsp页面
		}
		return ar;
	}

}
