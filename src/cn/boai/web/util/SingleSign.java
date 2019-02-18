package cn.boai.web.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.boai.pojo.User;

public class SingleSign implements HttpSessionAttributeListener {
	Map<String,HttpSession>  map=new HashMap<>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("����������ӷ���");
		String name=event.getName();
		if("user".equals(name)){    //ȷ��ֻ�Լ���Ϊuser�����Խ��в���
			 User user=(User)event.getValue();
			   if(map.get(user.getUser_id())!=null){   //˵���������������е�½
				System.out.println("map���Ѿ����ڸ��û�");
				HttpSession session= map.get(user.getUser_id()); //�ó��ϵ��Ǹ�session
			    User user2=(User)session.getAttribute("user");   //���ϵ��Ǹ�seeion���õ�֮ǰ��ip
			    System.out.println(user2.getUser_name()+ "�Ѿ���¼���õ�¼���������ߡ�+=======================");
			    session.removeAttribute(name);
			    session.setAttribute("mesg", "�����ʺ��Ѿ������������ϵ�¼�����������ߡ�+==============");
			   }
			   map.put(user.getUser_id(), event.getSession());  //�����µ�session
			   System.out.println("��һ�ε�½�Ѿ��ɹ�");
			   System.out.println("map"+map.get(user.getUser_id()));
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name=event.getName();
		System.out.println("��"+name+"�����Ƴ�");
		if("user".equals(name)){
			User user=(User)event.getValue();
			map.remove(user.getUser_id());
			System.out.println(user.getUser_name()+"�Ѿ���Map���Ƴ�");
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name=event.getName();
		if("user".equals(name)){
			User olduser=(User)event.getValue();
			map.remove(olduser.getUser_id());
			
			User user=(User)event.getSession().getAttribute(name);//������µ�session
			// ҲҪ����µ�¼���ʺ��Ƿ��ڱ�Ļ����ϵ�¼��
			if(map.get(user.getUser_id())!=null){   //˵���������������е�½
				HttpSession session= map.get(user.getUser_id()); //�ó��ϵ��Ǹ�session
			    User user2=(User)session.getAttribute("user");   //���ϵ��Ǹ�seeion���õ�֮ǰ��ip
			    System.out.println(user2.getUser_name()+ "�Ѿ���¼���õ�¼���������ߡ�+--------------------");
			    session.removeAttribute(name);
			    session.setAttribute("mesg", "�����ʺ��Ѿ������������ϵ�¼�����������ߡ�+---------------");
			   
			}
			
		}
	
	}

}
