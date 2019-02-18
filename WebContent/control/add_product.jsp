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
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/laydate/laydate.js" type="text/javascript"></script>
<!--[if lt IE 9]>
<script src="js/html5shiv.js" type="text/javascript"></script>
<script src="js/respond.min.js"></script>
<script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<title>添加产品</title>
<script>
	function change(obj){
		var fr = new FileReader();
		var f = obj.files[0];
		fr.readAsDataURL(f);
		fr.onload=function(e){
			document.getElementById("pro_photo").value=e.target.result;
			var val=obj.value;
			val=val.substring(val.lastIndexOf(".")+1);
			document.getElementById("photo_type").value=val;
		};
	}
</script>
</head>

<body>
<div class="margin">
<div class="add_style">
<form action="add_product.do" method="post">
 <ul>
  <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>标题名称：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="pro_title" type="text"  class="col-xs-6"/></div></li>
  <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>简单描述：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="pro_describe" type="text" class="col-xs-4"/></div></li>
   <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>关&ensp;键&ensp;字：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input name="pro_key" type="text" class="col-xs-4"/><em class="Prompt"> 请用","分隔关键字</em></div></li>
  <li class="clearfix">
   <label class="label_name col-xs-1"><i>*</i>产品分类：&nbsp;&nbsp;</label>
   <div class="Add_content col-xs-11">
   <span class="classification_name l_f"><label ><input type="radio" name="pro_type" class="ace" value="1"><span class="lbl">新品发布</span></label></span>
   <span class="classification_name l_f"><label ><input type="radio" name="pro_type" class="ace" value="2"><span class="lbl">限时促销</span></label></span>
   <span class="classification_name l_f"><label ><input type="radio" name="pro_type" class="ace" value="3"><span class="lbl">特价处理</span></label></span>
   </div> 
   </li>
     <li class="clearfix">
      <div class="col-xs-4">
     <label class="label_name col-xs-3"><i>*</i>商品原价：&nbsp;&nbsp;</label> 
    <div class="Add_content col-xs-9">
    <input name="pro_oldprice" type="text"  class="col-xs-7"/><em class="Prompt">元</em>
    </div>   
    </div>
    <div class="col-xs-4">
    <label class="label_name col-xs-3"><i>*</i>商品现价：&nbsp;&nbsp;</label> 
    <div class="Add_content col-xs-9">
   <input name="pro_newprice" type="text"  class="col-xs-7"/><em class="Prompt">元</em>
    </div>   
    </div>
    <div class="col-xs-4">
    <label class="label_name col-xs-3"><i>*</i>商品颜色：&nbsp;&nbsp;</label> 
    <div class="Add_content col-xs-9">
   <input name="pro_def" type="text"  class="col-xs-7"/><em class="Prompt">以英文逗号隔开</em>
    </div>   
    </div>
    </li>
      <li class="clearfix">
     <label class="label_name col-xs-1"><i>*</i>产品图片：&nbsp;&nbsp;</label>
     <div class="Add_content col-xs-11" id="Upload">
     <div class="images_Upload clearfix margin-bottom" id="images_Upload">
      <span class="Upload_img"><input type="file" onchange="change(this)" /></span>
      <input type="hidden"  name="pro_photo" id="pro_photo"></input>
      <input type="hidden"  name="photo_type" id="photo_type"></input>
      <a href="javascript:ovid()" class="operating delete_Upload" onclick="delete_Upload(this.id)"><i class="fa fa-remove"></i></a>
    </div>
    <button type="button" class="add_Upload bg-deep-blue" id="add_Upload" onclick="add_Upload()"><i class="fa  fa-plus"></i></button>
     </div>
     </li>
     <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>内容介绍：&nbsp;&nbsp;</label>
     <div class="Add_content col-xs-11"><script name="pro_intro" id="editor" type="text/plain" style="width:100%;height:500px;"></script></div>
     </li>
 </ul>
 <div class="Button_operation btn_width">
 	<input type="hidden" name="param" value="addProduct"></input>
    <button class="btn button_btn bg-deep-blue" type="submit">保存并提交</button>
    <button class="btn button_btn bg-orange" type="button">保存草稿</button>
    <button class="btn button_btn bg-gray" type="reset">取消添加</button>
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
$(document).ready(function(){
    var spotMax = 8;
  if($('div.images_Upload').size() >= spotMax) {$(obj).hide();}
  $("#add_Upload").on('click',function(){ 
       var cid =$('.images_Upload').each(function(i){ $(this).attr('id',"Uimages_Upload_"+i)});
       addSpot(this, spotMax, cid);
  });
});
function addSpot(obj, sm ,sid) {
	  $("#Upload").append("<div class='images_Upload clearfix margin-bottom' id='"+sid+"'>"+
	  "<span class='Upload_img'><input name='' type='file' /></span>"+
	  "<a href='javascript:ovid()' class='operating delete_Upload'><i class='fa fa-remove'></i></a>"+
	  "<a href='javascript:ovid()' class='operating' onclick='preview_img(this.id)'><i class='fa  fa-image'></i></a>"+
	  "</div>&nbsp;")  
	.find(".delete_Upload").click(function(){
		if($('div.images_Upload').size()==1){
			layer.msg('请至少保留一张图片!',{icon:0,time:1000});			
			}
			else{
				 $(this).parent().remove();
                 $('#add_Upload').show();
				} 				
				
  });
  if($('.delete_Upload').size() >= sm) {$(obj).hide();layer.msg('当前为最大图片添加量!',{icon:0,time:1000});}}
 /*checkbox激发事件*/
$('#checkbox').on('click',function(){
	if($('input[name="checkbox"]').prop("checked")){
		 $('.Date_selection ').css('display','block');
		}
	else{
		
		 $('.Date_selection').css('display','none');
		}	
	});

/*********滚动事件*********/
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});
</script>
