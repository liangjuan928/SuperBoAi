<%@page import="cn.boai.pojo.Article"%>
<%@page import="cn.boai.service.ljservice.impl.LjServiceImpl"%>
<%@page import="cn.boai.service.ljservice.LjService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1, user-scalable=no">
    <title>打造宝宝好睡眠，请遵守以下规则_新生父母必读文章</title>
    <meta name="keywords" content="打造宝宝好睡眠，请遵守以下规则,新生父母必读文章," />
    <meta name="description" content="新生父母必读公众号发布的《打造宝宝好睡眠，请遵守以下规则》" />
    <link href="/style/css/zi.css" rel="stylesheet">
    <link href="/style/css/common.css" rel="stylesheet">
<link href="/favicon.ico" rel="shortcut icon"/>
    <link rel="stylesheet" href="/style/css/share_style0_24.css">
<script src="/style/js/all.js"></script>
<script type="text/javascript">
show_ad();
</script>
</head>
<body  style="text-align: center">
            <% 
            String strid=request.getParameter("artid");
            LjService ls=new LjServiceImpl();
            int id=Integer.parseInt(strid);
            Article article=ls.getArticleById(id);
            pageContext.setAttribute("article", article);
            
            %>
            <!---con-header-->
            <div style="width: 80%; height: 800px ;margin: auto" >
            <div class="main-con article-page" >
                <div class="article-container">
                    <h1 class="article-title">
                        ${article.article_title }
                    </h1>
                    <div class="author">
                        <div class="author-name">
                            <c:if test="${article.article_type eq  1  }">
                             <a href="#" class="mr5" title="新生父母必读最新文章">
                             <strong>新生父母必读</strong></a>
                            </c:if>
                            <c:if test="${article.article_type eq  2  }">
                             <a href="#" class="mr5" title="笑话集" style="color: ">
                             <strong>笑话集</strong></a>
                            </c:if>
                            <c:if test="${article.article_type eq  3  }">
                             <a href="#" class="mr5" title="好医术">
                             <strong>好医术</strong></a>
                            </c:if>
                            <c:if test="${article.article_type eq  4  }">
                             <a href="#" class="mr5" title="服饰搭配">
                             <strong> 服饰搭配</strong></a>
                            </c:if>
                             <c:if test="${article.article_type eq  5  }">
                             <a href="#" class="mr5" title="家教微刊">
                             <strong> 家教微刊</strong></a>
                            </c:if>
                                &nbsp;   &nbsp; &nbsp; &nbsp;${article.article_time } 
                        </div>
                        <div class="share-box fl">
                            <div class="bdsharebuttonbox" data-tag="share_1">
                                <a class="bds_weixin" data-cmd="weixin"></a>
                                <a class="bds_sqq" data-cmd="sqq"></a>
                                <a class="bds_qzone" data-cmd="qzone" href="#"></a>
                                <a class="bds_tsina" data-cmd="tsina"></a>
                                <a class="bds_tqq" data-cmd="tqq"></a>
                                <a class="bds_more" data-cmd="more"></a>
                            </div>
                        </div>
                    </div>
                    <div class="article-content">
                        <div class="main-tg-area">
                                                        
                            <!-- 文章内容顶部自适应 -->
                          
                       </div>     
                        </div>
                        <!--main-tg-area-->
<!-- <p><qqmusic scrolling="no" frameborder="0" musicid="1231209" mid="0041GDo80BpUTu" albumurl="/d/m/002Gu90m4HCSdm.jpg" audiourl="http://ws.stream.qqmusic.qq.com/C1000041GDo80BpUTu.m4a?fromtag=46" music_name="When&nbsp;You&nbsp;Say&nbsp;Nothing&nbsp;At&nbsp;All" commentid="318737240" singer="Alison&nbsp;Krauss&nbsp;-&nbsp;Alison&nbsp;Krauss&nbsp;&amp;&nbsp;Union&nbsp;Station&nbsp;Live" play_length="261000" src="/cgi-bin/readtemplate?t=tmpl/qqmusic_tmpl&amp;singer=Alison%20Krauss%20-%20Alison%20Krauss%20%26%20Union%20Station%20Live&amp;music_name=When%20You%20Say%20Nothing%20At%20All"></qqmusic></p>
<p><strong>打造宝宝好睡眠，请遵守以下规则</strong></p><blockquote>0-3个月的新生儿，每天需要睡眠时间20小时<blockquote><p>以上睡眠时间是指［白天几次小睡时间］与［晚上长时间睡眠］的总和。举一个月大的宝宝为例，晚上连睡12小时，白天3-4次小睡加总是8小时，总计20个小时。</p>
<p>生活作息应该是爸妈引导孩子，不是让玩心越来越重的孩子来主导作息！</p>
<p>不要舍不得叫醒他，不要担心硬把宝宝叫起来这样是不是对宝宝不好，日夜颠倒违反生理时钟才对宝宝不好！当然，实施上还是要有些弹性的。</p> -->
        ${article.article_body }
    
           
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?8d3811a94d0ab21d6fd7ebaa0d46b1e3";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<div style="display:none"><script src='https://w.cnzz.com/q_stat.php?id=1261073202&l=3' language='JavaScript'></script></div>
    </footer>


    </div>
    
<script src="/style/js/jquery.min.js"></script>
<script type="text/javascript" src="/style/js/home.min.js"></script>
<script src="/style/js/slick.js"></script>
<script src="/style/js/index.js"></script>
<script type="text/javascript">
    function change(type)
    {
        var searchBox = document.getElementById("searchBox");
        searchBox.value = type;
    }
    function changea(type)
    {
        var searchBoxa = document.getElementById("searchBoxa");
        searchBoxa.value = type;
    }
  function submitForm()
    {
       
            document.getElementById('formSearch').submit();
        
    }
  self.init()
   
</script>


    <script src="/style/js/echo.min.js"></script>
    <script>
        var latetime=150;
        echo.init({
            offset: 100,
            throttle: latetime,
            unload: false,
            callback: function (element, op) {
            }
        });
    </script>
    <script>
        self.share();
        var s = "";
    </script>
    

</body>
</html><script src="/e/public/onclick/?enews=donews&classid=79&id=1237281"></script>

