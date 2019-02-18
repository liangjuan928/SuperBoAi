package cn.boai.web.action.ljaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.boai.pojo.Article;
import cn.boai.service.ljservice.LjService;
import cn.boai.service.ljservice.impl.LjServiceImpl;
import cn.boai.web.core.Action;
import cn.boai.web.core.ActionResult;
import cn.boai.web.core.DispatcherAction;
import cn.boai.web.core.ResultContent;
import cn.boai.web.core.ResultType;
import cn.boai.web.form.ActionForm;
import cn.boai.web.form.ljform.AddArticleForm;

public class ShowArticleAction implements Action  {
	LjService ls = new LjServiceImpl();

	@Override
	public ActionResult execute(HttpServletRequest request, HttpServletResponse reponse, ActionForm form)
			throws ServletException, IOException {
		String strpage=request.getParameter("page");
		if(strpage==null){  //如果是第一次加载就默认在第一页
			strpage="1";
		}
		int page=Integer.parseInt(strpage);
		int maxpagenum=ls.getArticleMaxPageNum(6);
		if(page==-1||(page>maxpagenum)){   
			page=maxpagenum;
		}
		if(page<1){
			page=1;
		}
		List< Article> list=ls.SplitArticleList(page, 6); 
		request.setAttribute("page",page);
		request.setAttribute("articllist", list);   //将添加结果返回给页面
		ActionResult ar = null;
		if(list!=null){
			ResultContent rc = new ResultContent("information_jsp");
			ar = new ActionResult(rc, ResultType.Forward); // 转发到add_articl在属性文件中对应的jsp页面
		}else{
			ResultContent rc = new ResultContent("error_jsp");
			ar = new ActionResult(rc, ResultType.Forward); // 转发到add_articl在属性文件中对应的jsp页面
		}
		return ar;
	}

}
