<%@page import="java.util.Map"%>
<%@page import="cn.boai.dao.hydao.impl.HyDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="cn.boai.service.hyservice.HyService"%>
<%@page import="cn.boai.service.hyservice.impl.HyServiceImpl"%>
<%@page import="cn.boai.pojo.Order1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	HyDaoImpl hd=new HyDaoImpl();
	HyServiceImpl hs=new HyServiceImpl();
	List<Order1> list=null;
	
	Map map = (Map)request.getAttribute("map");
	String size = request.getParameter("pageSize");
	int pageSize = 3;
	if(size!=null){
		pageSize = Integer.parseInt(size);
	}
	int maxPage = hd.getMaxPageNo(pageSize);
	int pageNo  = 1;
	  		String no = request.getParameter("pageNo");
	  		if(no!=null){
	  			pageNo = Integer.parseInt(no);
	  			if(pageNo < 1){
	  				pageNo=1;
	  			}
	  			if(pageNo > maxPage){
	  				pageNo=maxPage;
	  			}
	  		}
	  		
	  		if(map==null){
	  			list = hd.splitQuery(pageSize,pageNo);
  			}else{
  				list =  hs.queryMohu(map);
  			}	
	  			
  			pageContext.setAttribute("list",list);
  			pageContext.setAttribute("pageNo",pageNo);
	  		pageContext.setAttribute("maxPage",maxPage);
	  		pageContext.setAttribute("pageSize",pageSize);
  			
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="css/shop.css" type="text/css" rel="stylesheet" />
<link href="css/Sellerber.css" type="text/css"  rel="stylesheet" />
<link href="css/bkg_ui.css" type="text/css"  rel="stylesheet" />
<link href="font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/laydate/laydate.js" type="text/javascript"></script>
<!--[if lt IE 9]>
<script src="js/html5shiv.js" type="text/javascript"></script>
<script src="js/respond.min.js"></script>
<script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<title>订单</title>

  <script type="text/javascript">
  	function newOr(flag){
  		if(flag){
  			alert("您的新订单来啦！");
  		}else{
  			//alert("暂无新订单！");
  		}
  	}
  	
  	function jump(){
			var ps = document.getElementById("ps").value;
			var pn = document.getElementById("pn").value;
			if(ps==""){
				ps = 3;
			}
			if(pn==""){
				pn = 1;
			}
			location.href="Order.jsp?pageSize="+ps+"&pageNo="+pn;
		}
		
		function submitData(){
			var form=document.getElementById("moForm");
			var hao=document.getElementById("hao").value;
			form.action="mohu.do?hao="+hao;
			form.method="post";
			form.submit();
		}
  </script>
</head>

<body onload="newOr(<%=(Boolean)session.getAttribute("newOrder") %>)">
<div class="margin order_style" id="page_style">
<div class="sum_style margin-bottom ">
 <ul class="clearfix">
  <li class="col-xs-3 "><div class="sum_zone Amount">交易总额<span><em>￥</em>35446元</span></div></li>
  <li class="col-xs-3 "><div class="sum_yifu Amount">已付金额<span><em>￥</em>35465元</span></div></li>
  <li class="col-xs-3 "><div class="sum_daifu Amount">代付金额<span><em>￥</em>3545元</span></div></li>
  <li class="col-xs-3 "><div class="sum_tuikuan Amount">退款金额<span><em>￥</em>3545元</span></div></li>
 </ul>
</div>
<div class="status_order margin-bottom">
  <a href="javascrpit:void" class="btn button_btn btn-info status_btn">所有订单(454)</a>
  <a href="javascrpit:void" class="btn button_btn btn-info status_btn">已完成(454)</a>
  <a href="javascrpit:void" class="btn button_btn btn-info status_btn">未完成(454)</a>
  <a href="javascrpit:void" class="btn button_btn btn-info status_btn">待发货(454)</a>
  <a href="javascrpit:void" class="btn button_btn btn-info status_btn">待付款(454)</a>
<button class="btn button_btn btn-danger" type="button" onclick=""><i class="fa fa-trash-o"></i>&nbsp;删除</button> 
 </div>
<div class="operation clearfix">
<div class="search  clearfix">
	  <form id="moForm">
		    	 <label class="label_name">订单号：</label>
		    	 <input id="hao" type="text"  class="form-control col-xs-6" style=" width:250px;"/>
		    	<label class="label_name">下单时间：</label>
		    	<input class="inline laydate-icon " id="start" type="text"  style=" margin-right:10px; height:auto; float:left; width:150px;" />
    		    <input class="btn button_btn bg-deep-blue "  type="submit" value="查询" onclick="submitData('${min}','${max }')"/>
      </form>
</div>
</div>
<div class="List_display">
 
  <table class="table table_list table_striped table-bordered" id="sample-table">
  <thead>
  <tr>
  <th width="30"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
   <th width="50">排序</th>
   <th width="200">订单编号</th>   
   <th width="150">下单时间</th>
   <th width="80">消费金额</th>
   <th width="50">数量</th>
   <th width="100">状态</th>
   <th width="150">发货时间</th>
   <th width="">备注</th>
   <th width="150">操作</th>
   </tr>   
  </thead>
  <tbody id="tbody">
    				<c:forEach items="${list}" var="u" varStatus="sta">
    					<tr >
	    					<td width="30"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
	    					<td>${sta.count}</td>
	    					<td>${u.order_id}</td>
	    					<td>${u.order_time}</td>
	    					<td>${u.order_total}</td>
	    					<td>${u.order_pay}</td>
	    					<td>娟已发货</td>
	    					<td>${u.order_time}</td>
	    					<td>def</td>
	    					<td><a href="javascript:void()" onclick="picture_del(this,'+10001+')" class="btn btn-danger operation_btn">删除</a> <a href="javascript:void()" onclick="picture_img(this,'+234+')" class="btn bg-deep-blue operation_btn">查看</a></td>
    					</tr>	
    				</c:forEach>
  </tbody>
    			
 </table>
    		<br/><br/>
    		<center>
    		<a href="Order.jsp?pageNo=1&pageSize=${pageSize }">首页</a>
  	 		<a href="Order.jsp?pageNo=${pageNo-1}&pageSize=${pageSize }">上一页</a>
  	 		<a href="Order.jsp?pageNo=${pageNo+1}&pageSize=${pageSize }">下一页</a>
  	 		<a href="Order.jsp?pageNo=${maxPage }&pageSize=${pageSize }">末页</a><br/><br/>
  	 		每页显示<input type="text" id="ps" value="${pageSize }"/>条,
  	 		跳转到第<input type="text" id="pn" value="${pageNo }"/>页
  	 		<button onclick="jump()">跳转</button><br/><br/>
  	 		当前是第<${pageNo }>页，共<${maxPage }>页
    	    </center>
</div>
</div>
</body>
</html>

<script>		
	/*产品-删除*/
function picture_del(obj,id){
	layer.confirm('确认要删除吗？',{icon:0,},function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
/*******滚动条*******/
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});
	
</script>
