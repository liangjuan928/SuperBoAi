<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!--[if lt IE 9]>
<script src="js/html5shiv.js" type="text/javascript"></script>
<script src="js/respond.min.js"></script>
<script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<title>添加文章</title>
</head>

<body>
<div class="margin" id="page_style">
  <div class="add_style">
  <form action="add_articl.do" >
    <ul>
  <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>标题名称：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="title" type="text"  class="col-xs-6"/></div>  </li>
  <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>简单描述：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="describe" type="text" class="col-xs-4"/></div>
  </li>

    
     <li class="clearfix">
   <label class="label_name col-xs-1"><i>*</i>所属分类：&nbsp;&nbsp;</label>
   <div class="Add_content col-xs-11">
   <span class="classification_name l_f"><label ><input type="radio" name="type" class="ace" value="1"><span class="lbl">新生父母必读</span></label></span>
   <span class="classification_name l_f"><label ><input type="radio" name="type" class="ace" value="2"><span class="lbl">笑话集</span></label></span>
   <span class="classification_name l_f"><label ><input type="radio" name="type" class="ace" value="3"><span class="lbl">好医术</span></label></span>
   <span class="classification_name l_f"><label ><input type="radio" name="type" class="ace" value="4"><span class="lbl">服饰搭配</span></label></span>
   <span class="classification_name l_f"><label ><input type="radio" name="type" class="ace" value="5"><span class="lbl">家教微刊</span></label></span>
   <span class="relative l_f">
   </span>
   </div> 
   </li>
      <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>内容介绍：&nbsp;&nbsp;</label>
     <div class="Add_content col-xs-11"><script id="editor" type="text/plain" style="width:100%;height:300px;" name="conent"></script></div>
     </li> 
  </ul>
  <div class="Button_operation btn_width">
  <input type="hidden" name="param" value="addArticle"></input>
    <button class="btn button_btn bg-deep-blue" type="submit">保存并提交</button>
    <button class="btn button_btn bg-gray" type="button" onclick="getContent()">取消添加</button>
 </div>
 </form>
  </div>
</div>
</body>
</html>
   <!--复文本编辑框-->
    <script type="text/javascript" charset="utf-8" src="js/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/utf8-jsp/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script>
$(function(){
 var ue = UE.getEditor('editor');
 
});
function getContent() {
    var arr = [];
    arr.push("使用editor.getContent()方法可以获得编辑器的内容");
    arr.push("内容为：");
    arr.push(UE.getEditor('editor').getContent());
    alert(arr.join("\n"));
}

 function add_category(){$(".add_category_style").toggle();}
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
