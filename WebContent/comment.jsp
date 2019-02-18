<%@page import="cn.boai.pojo.User"%>
<%@page import="cn.boai.pojo.Comment"%>
<%@page import="java.util.List"%>
<%@page import="cn.boai.service.zwtservice.impl.ZwtServiceImpl"%>
<%@page import="cn.boai.service.zwtservice.ZwtService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
			<title>评论</title>
			<meta name="keywords" content="" />
			<meta name="description" content="" />
			<link href="res/static/css/base.css" rel="stylesheet">
			<link href="res/static/css/index.css" rel="stylesheet">
			<link href="res/static/css/media.css" rel="stylesheet">
			
			<script type="text/javascript" src="res/static/js/util/time.js"></script>
			<script type="text/javascript" src="res/static/js/util/myfocus-2.0.4.min.js"></script>
			
			<script src="res/static/js/util/modernizr.js"></script>
			
			
			<script type="text/javascript" src="res/static/js/up/jquery.js"></script>
			<script type="text/javascript" src="res/static/js/up/js.js"></script>
			
			<style type="text/css">
			
				#a{
					background-color: pink;
				}
				#b{
					
					background-color: lightskyblue;
				}
				
				#a1{
					line-height: 80px;
				}
				
				body{
					background-color: white;
					
				}
				.topbg{
					font-size: 18px;
					font-family: "微软雅黑";
				}
				#comm{
					margin-left:20px;
				}
				
			</style>
	<script src="res/static/js/util/jquery.min.js"></script>
    <link href="res/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="res/static/css/font-awesome.min.css" rel="stylesheet">
    <script src="res/static/js/util/bootstrap.min.js"></script>
    
    <script type="text/javascript">
		function check1(){
			if(document.getElementById("comm_title").value=="")
				document.getElementById("aaa").innerHTML = "评价不能为空！";
		}
		
		function check2(){
			if(document.getElementById("comm_content").value=="")
				document.getElementById("bbb").innerHTML = "评论内容不能为空！";
		}
		
		function re1(){
			document.getElementById("aaa").innerHTML = "";
		}
		
		function re2(){
			document.getElementById("bbb").innerHTML = "";
		}
		
		function sub(){
			if(!(document.getElementById("good").checked||document.getElementById("normal").checked||document.getElementById("bad").checked)){
				alert("评价不能为空!");
			}else{
				if(document.getElementById("aaa").innerHTML==""&&document.getElementById("bbb").innerHTML==""){
					var form = document.getElementById("myform");
					form.action="comm.do";
					form.method="post";
					form.submit();
					alert("评论成功！");
					return true;
				}
				else{
					document.getElementById("bbb").innerHTML = "评论失败！";
					return false;
				}
			}
		}
    </script>
</head>
<body>

	<%session.setAttribute("user_id", "321"); %>
	<%String user_id=(String)session.getAttribute("user_id"); %>
	<%session.setAttribute("pro_id", "123"); %>
	<%String pro_id=(String)session.getAttribute("pro_id"); %>
	
	
			<div class="topnews">
		<h2><b>&emsp;已收到评论</b></h2>
		<br/>
	</div>
	<div id="show">
	  	 <%
	  	 	ZwtService zs=new ZwtServiceImpl();
	  	 	List<Comment> list =  zs.queryCommByProid(pro_id);
	  	 %>

	    
	    <table>
	    	<%for(int i = 0;i<list.size();i++){ %>
	    		<tr>
	    			<td rowspan="2" align="center" width="150px" height="100px">
	    				<img class="media-object img-circle" src="img/touxiang.jpeg" alt="头像" width="80">
	    			</td>
	    			<td width="50px" align="right" valign="middle">
	    				<b style="color:#db6d4c;">评价：</b>
	    			</td>
	    			<td align="left" valign="middle" width="600px">
	    				<p>
	    					<%
			    				int type=list.get(i).getCom_type();
			    				String commtype=null;
			    				String commphoto=null;
			    			 	switch(type){
			    			 		case 1:
			    			 			commtype="好评";
			    			 			commphoto="res/static/img/good.png";
			    			 			break;
			    			 		case 2:
			    			 			commtype="中评";
			    			 			commphoto="res/static/img/normal.png";
			    			 			break;
			    			 		case 3:
			    			 			commtype="差评";
			    			 			commphoto="res/static/img/bad.png";
			    			 			break;
			    			 	}
			    			 %>
			    			 <div valign="middle">
				    			 <img style="height:35px;weight:35px;display:inline-block;" src="<%=commphoto %>">
				    			 <%=commtype %>
			    			 </div>
	    				</p>
	    			</td>
				</tr>
				<tr>
	    			<td align="right" valign="top">
	    				<b style="color:#db6d4c;">评论：</b>
	    			</td>
	    			<td align="left" valign="top" width="600px">
		    			<p>
		    				<%=list.get(i).getCom_content() %>
		    			</p>
	    			</td>
				</tr>
				<tr>
	    			<td align="center" height="40px">
	    				<b  style="color:#db6d4c;">
							<%
								User user=zs.queryUserById(list.get(i).getUser_id());
							%>
							<%=user.getUser_name() %>
						</b>
	    			</td>
	    			<td colspan="2" align="right">
	    				<span style="font-size:14px; color:gray;"><%=list.get(i).getCom_time() %></span>
	    			</td>
				</tr>
				<tr>
					<td colspan="3">
						<hr/>
					</td>
				</tr>
	    	<%} %>
	    </table>

  	</div>
  	<br/>
  	<br/>
  	<br/>
  	<div class="topnews">
		<h2><b>&emsp;发布评论</b></h2>
	</div>
	<div class="form row" id="comm">
            <div class="form-horizontal">
                <form id="myform">
                <div class="col-md-9">
                    <div class="form-group">
                       <h4 style="color:#db6d4c;">评价：</h4>
                          &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                          <input type="radio" name="comm_type" value="1" id="good"><label for="good"><img title="好评" src="res/static/img/good.png" style="width:40px;height:40px;display:inline-block;"></label>
                          &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                          <input type="radio" name="comm_type" value="2" id="normal"><label for="normal"><img title="中评" src="res/static/img/normal.png" style="width:40px;height:40px;display:inline-block;"></label>
                          &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                          <input type="radio" name="comm_type" value="3" id="bad"><label for="bad"><img title="差评" src="res/static/img/bad.png" style="width:40px;height:40px;display:inline-block;"></label>
                          <br/>
                    	  <span style="color:red" id="aaa"></span>
                    </div>
                    <div class="form-group">
                            
                       <h4 style="color:#db6d4c;">评论内容：</h4>
                       <textarea id="comm_content" name="comm_content" class="form-control required" type="text" placeholder="请书写你的评论内容" style="height: 300px; width: 600px;" maxlength="800"  onblur="check2()" onfocus="re2()"></textarea><br/>
                       <span style="color:red" id="bbb"></span>
                    </div>
        
                    <div class="form-group col-md-offset-9">
                        <input type="hidden" name="param" value="addComm"/>
                        <input type="hidden" name="pro_id" value="<%=pro_id %>"/>
                        <input type="hidden" name="user_id" value="<%=user_id %>"/>
                        <button class="btn" onclick="return sub()">发表</button><br/>
                        <span style="color:red" id="comm_msg"></span>
                    </div>
                </div>
                </form>
    		</div>
    </div>
</body>
</html>