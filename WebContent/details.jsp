<%@page import="java.io.Console"%>
<%@page import="cn.boai.pojo.Product"%>
<%@page import="cn.boai.service.zwtservice.impl.ZwtServiceImpl"%>
<%@page import="cn.boai.service.zwtservice.ZwtService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  <script>
  	function showiframe(val){
  		document.getElementById("myiframe").src=val;
  		setIframeHeight(document.getElementById('myiframe'));
  	}
  	function setIframeHeight(iframe) {
	  	if (iframe) {
		  	var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
		 	if (iframeWin.document.body) {
			  	iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
		  	}	
      	}
	};
	window.onload = function () {
		setIframeHeight(document.getElementById('myiframe'));
	};
  	function choose(val,length){
  		for(var i=0;i<length;i++){
  			document.getElementById(i).setAttribute("class","btn");
  		}
  		document.getElementById(val).setAttribute("class","btn active");
  	}
  	function add(addcart){
  		var i=document.getElementById("iii");
	  	var target=document.querySelector(".sn-quick-menu");
		//1. 克隆一个当前元素
		var _gd = addcart.cloneNode(true);

		//2. 设置透明度 style.opacity=0.5
		_gd.style.opacity=0.5;
		
		//3. 设置定位方式
		_gd.style.position="absolute";
		_gd.value="";
		//i.parentNode.removeChild(i);
		addcart.parentNode.appendChild(_gd);
		
		//4. 获取克隆元素的位置和宽高，获取目标的位置和宽高 
		//当前
		var cX = addcart.offsetLeft;
		var cY = addcart.offsetTop;
		var cW = addcart.offsetWidth;
		var cH = addcart.offsetHeight;
		//目标
		var tX = target.offsetLeft+200;
		var tY = target.offsetTop;
		var tW = target.offsetWidth-45;
		var tH = target.offsetHeight;
		//console.log(tX+"-"+tY+"-"+tW+"-"+tH);
		
		//5. 通过定时器setInterval来改变当前位置和宽高向目标靠拢
		var timeid=setInterval(function(){
			cX = cX+(tX-cX)/50;
			cY = cY+(tY-cY)/50;
			cW = cW+(tW-cW)/50;
			cH = cH+(tH-cH)/50;
			
			
			_gd.style.top = cY+"px";
			_gd.style.left = cX+"px";
			_gd.style.width = cW+"px";
			_gd.style.height = cH+"px";
			
			//6. 判断克隆元素的offsetLeft和offsetTop是否等于目标的offsetLeft和offsetTop
			if(_gd.offsetTop===target.offsetTop){
			     //console.log(888);
			     //_gd.parentNode.removeChild(_gd);
			     //addcart.parentNode.removeChild(addcart);
			     _gd.remove();
			     window.clearInterval(timeid);
			}
		},1);
  	}
  </script>
</head>
<body>
	<%
		session.setAttribute("user_id", "321");
		String user_id=(String)session.getAttribute("user_id");
		session.setAttribute("pro_id", "123");
		String pro_id=(String)session.getAttribute("pro_id");
		ZwtService zs=new ZwtServiceImpl();
		Product product=zs.queryProductById(pro_id);
		String color=product.getPro_def();
		String[] colors=color.split(",");
	%>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="#">首页</a>
      </p>
      <div class="sn-quick-menu">
       <div class="login"><a href="login.jsp">登录</a></div>
        <div id="cart2" class="sp-cart"><a href="shopcart.jsp">购物车</a><span>2</span></div>
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


  <div class="content content-nav-base datails-content">
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
    <div class="data-cont-wrap w1200">
      <div class="crumb">
        <a href="javascript:;">首页</a>
        <span>></span>
        <a href="javascript:;">所有商品</a>
        <span>></span>
        <a href="javascript:;">产品详情</a>
      </div>
      <div class="product-intro layui-clear">
        <div class="preview-wrap">
          <a href="javascript:;"><img src="res/static/img/details_img1.jpg"></a>
        </div>
        <div class="itemInfo-wrap">
          <div class="itemInfo">
            <div class="title">
              <h4>男女宝宝秋冬装套装0一1岁婴儿衣服潮加厚连体衣保暖冬季外出抱衣 </h4>
              <span><i class="layui-icon layui-icon-rate-solid"></i>收藏</span>
            </div>
            <div class="summary">
              <p class="reference"><span>参考价</span> <del>￥<%=product.getPro_oldprice() %></del></p>
              <p class="activity"><span>活动价</span><strong class="price"><i>￥</i><%=product.getPro_newprice() %></strong></p>
              <p class="address-box"><span>送&nbsp;&nbsp;&nbsp;&nbsp;至</span><strong class="address">江西&nbsp;&nbsp;南昌&nbsp;&nbsp;东湖区</strong></p>
            </div>
            <div class="choose-attrs">
              <div class="color layui-clear"><span class="title">颜&nbsp;&nbsp;&nbsp;&nbsp;色</span>
              	<div class="color-cont">
              		<%
              			for(int i=0;i<colors.length;i++){
              		%>
              		<span id="<%=i %>" class="btn" onclick="choose(this.id,<%=colors.length %>)"><%=colors[i] %></span>
					<%
              			}
              		%>
              		<!-- <span id="white" class="btn active" onclick="choose(this.id)"><%=colors[0] %></span>
					<span id="pink" class="btn" onclick="choose(this.id)"><%=colors[1] %></span> -->
              	</div>
              </div>
              <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont"><span class="cut btn">-</span><input onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="" name="" value="1"><span class="add btn">+</span></div></div>
            </div>
            <div class="choose-btns">
              <button class="layui-btn layui-btn-primary purchase-btn">立刻购买</button>
              <button id="addcart" class="layui-btn  layui-btn-danger car-btn" onclick="add(this)"><i id="iii" class="layui-icon layui-icon-cart-simple"></i>加入购物车</button>  
            </div>
          </div>
        </div>
      </div>
      <div class="layui-clear">
        <div class="aside">
          <h4>热销推荐</h4>
          <div class="item-list">
            <div class="item">
              <img src="res/static/img/details_img2.jpg">
              <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
            </div>
            <div class="item">
              <img src="res/static/img/details_img2.jpg">
              <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
            </div>
            <div class="item">
              <img src="res/static/img/details_img2.jpg">
              <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
            </div>
            <div class="item">
              <img src="res/static/img/details_img2.jpg">
              <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
            </div>
            <div class="item">
              <img src="res/static/img/details_img2.jpg">
              <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
            </div>
            <div class="item">
              <img src="res/static/img/details_img2.jpg">
              <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
            </div>
          </div>
        </div>
        <div class="detail">
          <h4 style="display:inline-block;" onclick="showiframe('prodetails.jsp')">详情</h4>
          <h4 style="display:inline-block;" onclick="showiframe('comment.jsp')">评论</h4>
          <div class="item">
          	 <iframe id="myiframe" src="prodetails.jsp" width="820px" style="border:none;" scrolling="no" onload="changeFrameHeight()">
          	
          	</iframe> 
          </div>
        </div>
      </div>
    </div>
  </div>
<script type="text/javascript">
  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','jquery'],function(){
      var mm = layui.mm,$ = layui.$;
      var cur = $('.number-cont input').val();
      $('.number-cont .btn').on('click',function(){
        if($(this).hasClass('add')){
          cur++;
         
        }else{
          if(cur > 1){
            cur--;
          }  
        }
        $('.number-cont input').val(cur)
      })
      
  });
</script>


</body>
</html>