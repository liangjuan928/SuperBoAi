<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <script type="text/javascript" src="res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>
 <%--
      String username = "";
      String password = "";
      String s;
      Cookie [] cookies =request.getCookies();
      for (Cookie cookie:cookies) {
        s=cookie.getName(); //通过getName方法获得cookie的名称
        if (s.equals("username")) {
          if (cookie.getValue()!=null) {
            username=username+cookie.getValue(); //通过getValue方法获得cookie的值
          }
        } else 
        if (s.equals("password")) {
          if (cookie.getValue()!=null) {
            password=password+cookie.getValue();
          }
        }
      }
    --%>

    <%=request.getAttribute("fasong") %>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="#">首页我改动啦</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login"><a href="login.jsp">登录</a></div>
        <div class="sp-cart"><a href="shopcart.jsp">购物车</a><span>2</span></div>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="母婴商城">
            <img src="res/static/img/logo.png">
          </a>
        </h1>
        <div class="mallSearch">
          <form  action="login.jsp" method="post" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="content content-nav-base  login-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.jsp" class="active">所有商品</a>
            <a href="buytoday.jsp">今日团购</a>
            <a href="information.jsp">母婴资讯</a>
            <a href="about.jsp">关于我们</a>
            
          </div>
        </div>
      </div>
    </div>
    <div class="login-bg">
      <div class="login-cont w1200">
        <div class="form-box">
          <form class="layui-form" method="post" action="login_check.do" id="myform">
          <input type="hidden" name="param" value="logintest"/>
            <legend>账号登录|<a href="register.jsp">点我注册</a></legend>
            <div class="layui-form-item">
              <div class="layui-inline">
                <div class="layui-input-inline">
                  <input id="uname"  type="tel" name="uname" lay-verify="required"
                   placeholder="请输入你的用户名" autocomplete="off" class="layui-input" onblur="check1()">
                     <div><label id="span1"></label></div>
                </div>
              </div>
              <div class="layui-inline veri-code">
                <div class="layui-input-inline">
                  <input id="upass" type="password" name="upass" lay-verify="required" 
                  placeholder="请输入你的密码" autocomplete="off" class="layui-input" onblur="check2()">
                    <div><label id="span2"></label></div>
                </div>
              </div>
            </div>
            <div class="layui-input-line">
                   <div class="layui-form-inline">
                      <input type="checkbox" name="" >记住密码
                      <input type="checkbox" name="" >自动登录
                   </div>
            </div>
            <div class="layui-form-item login-btn">
              <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1" id="login_btn" onclick="click()" >登录</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <div class="footer">
    <div class="ng-promise-box">
      <div class="ng-promise w1200">
        <p class="text">
          <a class="icon1" href="javascript:;">7天无理由退换货</a>
          <a class="icon2" href="javascript:;">满99元全场免邮</a>
          <a class="icon3" style="margin-right: 0" href="javascript:;">100%品质保证</a>
        </p>
      </div>
    </div>
    <div class="mod_help w1200">                                     
      <p>
        <a href="javascript:;">关于我们</a>
        <span>|</span>
        <a href="javascript:;">帮助中心</a>
        <span>|</span>
        <a href="javascript:;">售后服务</a>
        <span>|</span>
        <a href="javascript:;">母婴资讯</a>
        <span>|</span>
        <a href="javascript:;">关于货源</a>
      </p>
      <p class="coty">母婴商城版权所有 &copy; 2012-2020</p>
    </div>
  </div>
  <script type="text/javascript">
  function check1(){
		if(document.getElementById("uname").value==""){
			document.getElementById("span1").innerHTML = "用户名不能为空！";
			   document.getElementById("span1").style.color="red";
		}else{
			document.getElementById("span1").innerHTML="";  			
		}
	   }
  
  function check2(){
		if(document.getElementById("upass").value==""){
			document.getElementById("span2").innerHTML = "密码不能为空！";
			   document.getElementById("span2").style.color="red";
		}else{
			document.getElementById("span2").innerHTML="";  			
		}
	   }
    function click(){
    	if(document.getElementById("uname").value==""||document.getElementById("upass").value==""){
    		alert("请先填写用户名和密码！");   		
    	}
    	if(window.XMLHttpRequest){
			 xmlHttp = new XMLHttpRequest();
		  }else{//IE内核
			 try{
				 xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			 }catch(e){
				 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	   }
		    	 }
		 
			//获得要发送的数据
			var vname = document.getElementById("uname").value;
			var vpass = document.getElementById("upass").value;
			//将数据进行编码(安全考虑应该编2次)
			vname = encodeURI(encodeURI(vname));
			vpass = encodeURI(encodeURI(vpass));
			//定位要发送的目的
			xmlHttp.open("GET","login_addForm.do?uname="+vname,true);
			xmlHttp.open("GET","login_addForm.do?upass="+vpass,true);
			//指定一个回调函数			
			xmlHttp.onreadystatechange=callback;
			
			//发送
			xmlHttp.send();			
			
		  }
    
		  function callback(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					//一切正常并能开始获得返回的结果
					var result= xmlHttp.responseText;
					if(result=="true"){
						window.location="commodity.jsp";
					}
					else window.location="login.jsp";
				}
			}
    	
    }
  </script>

</body>
</html>