<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
 <base href="<%=basePath%>">
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <link href="res/bootstrap.min.css" rel="stylesheet" type="text/css" />
	    <link href="res/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <script src="res/jquery.min.js" type="text/javascript"></script>
	    <script src="res/bootstrap.min.js" type="text/javascript"></script>
  
  
  <script type="text/javascript" src="res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
  <style>
  #arttilte{
  text-decoration: none;
  color: orange;
  font-size: 23px;
  }
  #arttilte:HOVER{
     text-decoration: underline;
  }
  
  
  </style>


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
  <div class="content content-nav-base information-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.jsp">所有商品</a>
            <a href="buytoday.jsp">今日团购</a>
            <a href="information.jsp"  class="active">母婴资讯</a>
            <a href="about.jsp">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <div class="info-list-box">
      <div class="info-list w1200">
        <div class="item-box layui-clear" id="list-cont">
        
        <c:forEach items="${articllist}" var="art" >
            <div class="item">
            <div class="img">
           <c:if test="${art.article_id mod 5 eq 0 }">
           <img src="res/static/img/new2.jpg" alt="" width="323 px" height="322 px">
           </c:if>
           <c:if test="${art.article_id mod 5 eq 1 }">
           <img src="res/static/img/new1.jpg" alt="" width="323 px" height="322 px">
           </c:if>
            <c:if test="${art.article_id mod 5 eq 2 }">
           <img src="res/static/img/new3.jpg" alt="" width="323 px" height="322 px">
           </c:if>
            <c:if test="${art.article_id mod 5 eq 3 }">
           <img src="res/static/img/new4.jpg" alt="" width="323 px" height="322 px">
           </c:if>
            <c:if test="${art.article_id mod 5 eq 4 }">
           <img src="res/static/img/new5.jpeg" alt="" width="323 px" height="322 px">
           </c:if>
             
            </div>
            <div class="text">
              <a href="articlelist/article1.jsp?artid=${art.article_id }"  id="arttilte">${art.article_title }</a>
             
              <p class="data" style="margin-top: 15px">${art.article_time }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <c:if test="${art.article_type eq  1  }"> 新生父母必读</c:if>
                   <c:if test="${art.article_type eq  2  }"> 笑话集</c:if>
                   <c:if test="${art.article_type eq  3  }"> 好医术</c:if>
                   <c:if test="${art.article_type eq  4  }"> 服饰搭配</c:if>
                   <c:if test="${art.article_type eq  5  }"> 家教微刊</c:if>
              </p>
              <p class="info-cont">${art.article_describe }</p>
            </div>
          </div>
        </c:forEach>
        </div>
        
        <div id="fenye" style="text-align: center">
        <nav aria-label="Page navigation">
  <ul class="pagination">
  <li><a href="information.jsp?page=1">首页</a></li>
    <li>
      <a href="information.jsp?page=${page-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">${page}</a></li>
    <li>
      <a href="information.jsp?page=${page+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    <li><a href="information.jsp?page=-1">末页</a></li>
     <li><a href="#">总共10页</a></li>
  </ul>
</nav>
        </div>
        
      </div>
    </div>
  </div>
  <!-- 模版引擎导入 -->
  <!-- <script type="text/html" id="demo">
    {{# layui.each(d.listCont,function(index,item){}}
    <div class="item">
      <div class="img">
        <img src="../res/img/new1.jpg" alt="">
      </div>
      <div class="text">
        <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
        <p class="data">2016-12-24 16:33:26</p>
        <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
      </div>
    </div>
    {{# })}}
  </script> -->
<script>
  /* layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage'],function(){
      var
      mm = layui.mm,laypage = layui.laypage;
      laypage.render({
         elem: 'demo0',
         count: 100 ,
         next:">>", 
         theme:"#0099ff", 
         layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'], 
         count:total, 
         curr:page,
         /* jump:function(data, first){ 
        	 var page=data.curr;
        	 $("#currPage").val(page); 
        	 var limt=data.limit; 
        	 $("#limit").val(limt);
        	 if(!first){ 
        		 //点击右下角分页时调用 studentInfo(); 
        		 alert("hahahahah")
        		 } 
        	 }
        
      }); */
    // 模版引擎导入
     // var html = demo.innerHTML;
     // var listCont = document.getElementById('list-cont');
     //  mm.request({
     //    url: '../json/information.json',
     //    success : function(res){
     //      console.log(res)
     //      listCont.innerHTML = mm.renderHtml(html,res)
     //    },
     //    error: function(res){
     //      console.log(res);
     //    }
     //  })   
//});

</script>


</body>
</html>