<%@page import="cn.boai.service.hyservice.impl.HyServiceImpl"%>
<%@page import="cn.boai.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@page import="cn.boai.dao.daopack.CartDao.impl.CartDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String id="1";
	session.setAttribute("uid", id);
	
	String proid="1";
	session.setAttribute("proid", proid);
	
	HyServiceImpl hs=new HyServiceImpl();
	List<Cart> list=hs.queryAllCart();
	pageContext.setAttribute("list", list);
 %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <script type="text/javascript" src="res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
  <script type="text/javascript">
  		
	  	function tan1(){
	  		alert("您已免密支付成功，您的宝贝正在向您飞奔。。。 ");
	  		var check=document.getElementsByTagName("input");
	  		for(var i=0;i<check.length;i++){
	  			if(check[i].checked){
	  				var p=check[i].parentNode.parentNode.parentNode.parentNode;//ul
	  				p.parentNode.removeChild(p);
	  				
	  				/* alert(p.tagName);
	  				var c=p.childNodes;
	  				for(var j=0;j<c.length;j++){
	  					p.removeChild(c[i]);
	  				}
	  				p.removeChild(p.firstChild);
	  				p.removeChild(p.lastChild); */
	  			}
	  		}
	  	}
	  	
	  	//后台删除cart      a
	  	function deleteCart(ud,pd){
	  		var form=document.getElementById("mForm");
			form.action="deleteCart.do?uid="+ud+"&proid="+pd;
			form.method="post";
			form.submit();
	  	}
	  	
	  	
	  	//加入后台订单
	  	function addOrder(ud,pd){
	  		var form=document.getElementById("mForm");
	  		var tol=document.getElementById("tol").textContent.substr(1);
	  		form.action="addOrder.do?uid="+ud+"&pids="+pd+"&total="+tol;
			form.method="post";
			form.submit();
	  	}
  </script>
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="#">首页</a>
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


  <div class="content content-nav-base shopcart-content">
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
    <div class="banner-bg w1200">
      <h3>夏季清仓</h3>
      <p>宝宝被子、宝宝衣服3折起</p>
    </div>
    <div class="cart w1200">
      <div class="cart-table-th">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="allCheckked" type="checkbox" value="true">
            </div>
          <label>&nbsp;&nbsp;全选</label>
          </div>
        </div>
        <div class="th th-item">
          <div class="th-inner">
            商品
          </div>
        </div>
        <div class="th th-price">
          <div class="th-inner">
            单价
          </div>
        </div>
        <div class="th th-amount">
          <div class="th-inner">
            数量
          </div>
        </div>
        <div class="th th-sum">
          <div class="th-inner">
            小计
          </div>
        </div>
        <div class="th th-op">
          <div class="th-inner">
            操作
          </div>
        </div>  
      </div>
      <div class="OrderList">
        <div class="order-content" id="list-cont">
        <c:forEach items="${list}" var="u" varStatus="sta">
          <ul class="item-content layui-clear">
            <li class="th th-chk">
              <div class="select-all">
                <div class="cart-checkbox">
                  <input class="CheckBoxShop check" id="ch_1" type="checkbox" num="all" name="select-all" value="true">
                </div>
              </div>
            </li>
            <li class="th th-item">
              <div class="item-cont">
                <a href="javascript:;"><img src="res/static/img/paging_img1.jpg" alt=""></a>
                <div class="text">
                  <div class="title">宝宝T恤棉质小衫</div>
                  <p><span>${u.cart_def }</span>  <span>130</span>cm</p>
                </div>
              </div>
            </li>
            <li class="th th-price">
              <span class="th-su">189.00</span>
            </li>
            <li class="th th-amount">
              <div class="box-btn layui-clear">
                <div class="less layui-btn">-</div>
                <input class="Quantity-input" type="" name="" value="1" disabled="disabled">
                <div class="add layui-btn">+</div>
              </div>
            </li>
            <li class="th th-sum">
              <span class="sum">189.00</span>
            </li>
            <li class="th th-op">
              <span class="dele-btn">删除</span>
            </li>
          </ul>
      </c:forEach>
        </div>
      </div>


      <div class="FloatBarHolder layui-clear">
        <div class="th th-chk">
          <div class="select-all">
            <div class="cart-checkbox">
              <input class="check-all check" id="" name="select-all" type="checkbox"  value="true">
            </div>
            <label>&nbsp;&nbsp;已选<span class="Selected-pieces">0</span>件</label>
          </div>
        </div>
        <div class="th batch-deletion">
          <span class="batch-dele-btn">批量删除</span>
        </div>
        <div class="th Settlement">
          <button class="layui-btn" onclick="tan1();deleteCart('${uid}','${proid}');addOrder('${uid}','${proid}');">结算</button>
          <form id="mForm"></form>
        </div>
        <div class="th total">
          <p>应付：<span class="pieces-total" id="tol">0</span></p>
        </div>
      </div>
    </div>
  </div>

<script type="text/javascript">
  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery','element','car'],function(){
    var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;
    
    // 模版导入数据
    // var html = demo.innerHTML,
    // listCont = document.getElementById('list-cont');
    // mm.request({
    //   url: '../json/shopcart.json',
    //   success : function(res){
    //     listCont.innerHTML = mm.renderHtml(html,res)
    //     element.render();
    //     car.init()
    //   },
    //   error: function(res){
    //     console.log(res);
    //   }
    // })
    // 
    car.init()


});
</script>
</body>
</html>