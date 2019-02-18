package cn.boai.web.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class FilterCharset implements Filter{
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest )request;
		HttpServletResponse resp=(HttpServletResponse )response;
	
		 String method=req.getMethod();  //��ȡ���ͷ�ʽ
		   if("post".equalsIgnoreCase(method)){
			   req.setCharacterEncoding("utf-8");
		   }
		   if ("get".equalsIgnoreCase(method)){
			   
			  req=new Myservlet(req);
//			 ���в�����Ϣ
//				Map map = req.getParameterMap();
//				Collection coll = map.values();
//				Iterator it = coll.iterator();
//				while(it.hasNext()){
//					String[] strs = (String[])it.next();
//					for(int i=0;i<strs.length;i++){
//						strs[i] = new String(strs[i].getBytes("ISO8859-1"),"UTF-8");
//						 System.out.println("------------��"+strs[i]);
//					}
//				}
//		   }
		   }
//		   response.setContentType("text/html;charset=utf-8");
		   response.setCharacterEncoding("utf-8");
           chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

 
}
class Myservlet extends HttpServletRequestWrapper{

	public Myservlet(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String value=super.getParameter(name);
		String valueLast=null;
		try {
			
			valueLast = value==null?null:new String(value.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return valueLast;
	}
	//重写请求的getParameterMap方法
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String,String[]> map=super.getParameterMap();
		Set<Entry<String,String[]>> set=map.entrySet();
		String valueLast=null;
		
		for (Entry<String, String[]> entry : set) {   
			String key=entry.getKey();
			String[] values=entry.getValue();
			for (int i = 0; i < values.length; i++) {
				try {
					values[i]=values[i]==null?null:new String(values[i].getBytes("ISO-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}



