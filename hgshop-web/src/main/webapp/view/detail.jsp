<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Floating labels example · Bootstrap</title>

    <!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >
	<script type="text/javascript" src="${pageContext.request.contextPath}/resource/jquery/jquery-3.4.1.js"></script>
    <script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >

<meta name="theme-color" content="#563d7c">
<style type="text/css">
	
	.selectedDiv {
		border: solid 2px red;
	}
	
	.noselectedDiv {
		border: solid 2px blue;
	}
	
</style>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md=2"></div>
			<div class="col-md=4"><img src="/pic/${spu.smallPic}" width="400" height="400"></div>
			<!-- 列出各个sku的属性 -->
			<div class="col-md=4" >
				<c:forEach items="${spu.skuList}" var="sku">
					<div style="margin-top:10px" class="sku" > 
					   <input type="hidden" value="${sku.id}">
					    ${sku.title}  &nbsp;&nbsp;&nbsp;
						<c:forEach items="${sku.optionList}" var="op">
							&nbsp;${op.specName}：${op.optionName};
						</c:forEach>
					</div>
				</c:forEach>
				<div style="margin-top:10px" >
					<label>购买数量</label> <input type="number" id="buyNum">
					<input type="button" class="btn" value="加入购物车" onclick="addCart()">
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(".sku").click(function(){
			//alert('tt')	
			$(".sku").each(function(){
				//alert('ff')
				$(this).removeClass("selectedDiv");
				$(this).addClass("noselectedDiv");
			})
			
			$(this).removeClass("noselectedDiv");
			$(this).addClass("selectedDiv");
			
			// 获取sku的id
		})
		
	 function addCart(){
			//获取被选中的sku id
			var skuId = $(".selectedDiv").children().val();
			var buyNum = $("#buyNum").val()
			$.post('/addCart',{skuId:skuId,num:buyNum},function(data){
				alert(data);
			})
		}	
	</script>
</body>
</html>