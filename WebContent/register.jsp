<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>注册 </title>
  <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <script type="text/javascript" src="res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>
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
          <form action="" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" 
            autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
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
          <form class="layui-form" action="register_add.do" id="myform"  method="post">  
            <legend>账号注册|<a href="login.jsp">点我登录</a></legend>
             <div class="layui-form-item">
              <div class="layui-inline">
               <div class="layui-input-inline">
                    <input type="text" name="uname" id="uname" lay-verify="required"  
                    placeholder="请输入用户名" autocomplete="off" class="layui-input" onblur="myfunction()">                    
                    
               </div>
               <div><label id="span1"></label></div>
             </div>       
             <div class="layui-inline veri-code">
                <div class="layui-input-inline">   
                   <input id="upass" type="password" name="upass" lay-verify="required" 
                   placeholder="请输入你的密码" autocomplete="off" class="layui-input" onblur="check1()">
                   <div><label id="span2"></label></div>
                </div> 
             </div>
                 <div class="layui-inline veri-code">
                    <div class="layui-input-inline">                
                              <label>性&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;</label>                       
                              <input type="radio" name="usex" id="man" value="1" title="男" >
                              <input type="radio" name="usex" id="woman" value="2" title="女"> 
                        </div> 
                 </div>
                    <div >
                      <div class="layui-input-inline">
                        <label for="">头像</label>
                        <input type="file" id="uphoto" onchange="change(this)">
                        <input type="hidden" name="photo" id="photo"/>
                        <input type="hidden" name="photo_type" id="photo_type"/> -->
                        <div><label id="span3"></label></div>
                        <br/>
  		                 <div id="show"></div>   		
                      </div>
	              </div>                
              </div>
              <div>
                  <div class="layui-input-inline"> 
                  <input type="hidden" name="param" value="addUser"/>
                  <button  type="submit" class="layui-btn layui-btn-warm" id="btn-register" >注册</button> 
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;               
                  <button type="reset" class="layui-btn"  id="btn-login">重置</button>
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
		    var str = document.getElementById("upass");    
  function check1(){
		if(document.getElementById("upass").value==""){
			document.getElementById("span2").innerHTML = "密码不能为空！";
			   document.getElementById("span2").style.color="red";
		}else{     
		    if(str.length!=6){    
		    	var reg = new RegExp("/^\d{6}$/");   
			    if(!reg.test(str)){    
			    	document.getElementById("span2").innerHTML = "请输入六位数字密码！";
			    	document.getElementById("span2").style.color="red";
			     }
		     }
			document.getElementById("span2").innerHTML="";  			
		}
  }
	   
       
	  //单选按钮
  layui.use('form', function () {
        	var $ = layui.jquery, form = layui.form;
        	$.ajax({
        		type: "post",
        		url: "/Shared/GetPiDate", 
        		data: {},
        		async: true,
        		dataType: "json",
        		success: function (data) {
        			$("input[name=sex][value=1]").attr("checked", data.UserSex == 1 ? true : false);
        			$("input[name=sex][value=2]").attr("checked", data.UserSex == 2 ? true : false);
        			form.render(); //更新全部                   
        			}
        		});
        	});
	  
	  //检查用户名是否重复
	  var xmlHttp;
     function myfunction(){
	   if(document.getElementById("uname").value==""){
			document.getElementById("span1").innerHTML = "用户名不能为空!";
	        document.getElementById("span1").style.color="red";	   
	   }
	   else{
	         document.getElementById("span1").innerHTML="";  
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
			var v = document.getElementById("uname").value;
			//将数据进行编码(安全考虑应该编2次)
			v = encodeURI(encodeURI(v));
			//定位要发送的目的
			xmlHttp.open("GET","register_check.do?uname="+v,true);
			//指定一个回调函数			
			xmlHttp.onreadystatechange=callback;
			
			//发送
			xmlHttp.send();			
			
		  }
	   }	        
		  function callback(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					//一切正常并能开始获得返回的结果
					var result= xmlHttp.responseText;
					
					var div = document.getElementById("span1");
					if(result.trim()=="true"){
						div.innerHTML="用户名已经占用";
						div.style.color="red";
					}else{
						div.innerHTML="用户名可以使用";
						div.style.color="green";
					}
				}
			}
		  }
		  
		  function change(obj){
				var fr = new FileReader();
				var f = obj.files[0];
				fr.readAsDataURL(f);
				fr.onload=function(e){
					document.getElementById("photo").value=e.target.result;
					var val=obj.value;
					val=val.substring(val.lastIndexOf(".")+1);
					document.getElementById("photo_type").value=val;
				};
			}
 
	</script>

</body>
</html>