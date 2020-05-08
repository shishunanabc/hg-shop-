<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%String path=request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%-- <link  href="<%=request.getContextPath() %>/css/index3.css"     rel="stylesheet"   type="text/css">
 --%><script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script> 
<script type="text/javascript"  src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script> 
</head>
<body>
	<div class="container">
		<div class="container" >
			<form id="queryForm">
			 <div class="form-group row">
			    <label for="nameid" class="col-sm-1 col-form-label">名称</label>
			    <div class="col-sm-2">
			      <input type="text" name="goodsName" class="form-control" id="nameid" value="${spuVo.goodsName}">
			    </div>
			    
			    <label for="captionid" class="col-sm-1 col-form-label">标题</label>
			    <div class="col-sm-2">
			      <input type="text" name="caption" class="form-control" id="captionId" value="${spuVo.caption}">
			    </div>
			    
			    <label for="brandDomid" class="col-sm-1 col-form-label">品牌</label>
			    <div class="col-sm-2">
			      	<select id="brandDomid" name="brandId">
			     		<option value="0">请选择</option> 
			     		<c:forEach items="${brandList}" var="brand">
			     			
			     			<option value="${brand.id}" 
			     			   <c:if test="${spuVo.brandId==brand.id}"> selected="selected"</c:if> >
			     			    ${brand.name}</option> 
			     		</c:forEach>
			     	</select>
			    </div>
			  </div>
			  <div class="form-group row">
			  	<label for="nameid" class="col-sm-1 col-form-label">排序数据项：</label>
			  	 <div class="col-sm-2">
			  	 	  <select id="orderFieldId" name="orderField">
			     		<option value="">请选择</option> 
			     		<option value="goods_name" ${spuVo.orderField=='goods_name'? 'selected':'' } >名称</option> 
			     		<option value="caption"  ${spuVo.orderField=='caption'? 'selected':'' } >标题</option> 
			     		<option value="brand_id" ${spuVo.orderField=='brand_id'? 'selected':'' } >品牌</option> 
			     		<option value="category_id" ${spuVo.orderField=='category_id'? 'selected':'' } >分类</option> 
			     		<option value="is_marketable" ${spuVo.orderField=='is_marketable'? 'selected':'' } >是否上线</option> 
			     	</select>
			    </div>
			    
			    <label for="nameid" class="col-sm-1 col-form-label">排序方式：</label>
			  	 <div class="col-sm-2">
			  	 	  <select name="orderType" id="orderTypeId">
			     		<option value="">请选择</option> 
			     		<option value="ASC" ${spuVo.orderType=='ASC'? 'selected':'' } >升序</option> 
			     		<option value="DESC" ${spuVo.orderType=='DESC'? 'selected':'' } >降序</option> 
			     	</select>
			    </div>
			  </div>
				 
				<button type="button" class="btn btn-danger" onclick="goPage(1)">查询</button> 
			</form>
			<button type="button" class="btn btn-danger" onclick="add()">添加</button> 
			<button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button>
			
		</div>
		<table class="table">
			<tr>
				<th>id  <input type="checkbox"></th>
				<th>名称</th>
				<td>图片</td>
				<td>品牌</td>
				<td>分类</td>
				<td>上架</td>
				<th>标题</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageInfo.list}" var="spu">
				<tr>
				<td>${spu.id} <input name="ids" type="checkbox" value="${spu.id}"> </td>
				<td><img src="/pic/${spu.smallPic}" width="100px" height="100px"> </td>
				<td>${spu.goodsName}</td>
				<td>${spu.brand.name}</td>
				<td>${spu.category.name}</td>
				<td>
					<c:choose>
						<c:when test="${spu.isMarketable==1}">上架</c:when>
						<c:when test="${spu.isMarketable==2}">下架</c:when>
						<c:otherwise>
							不知道
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					${spu.caption}
				</td>
				<td>
					<button type="button" class="btn btn-outline-success" onclick="update(${spu.id})">修改</button>
					<button type="button" class="btn btn-outline-danger" onclick="del(${spu.id})">删除</button>
					<button type="button" class="btn-sm btn-outline-primary" onclick="addSku(${spu.id})">添加</button>
				</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="10">
						<ul class="pagination">
						    <li class="page-item ">
						      <a class="page-link" href="javascript:void()" onclick="goPage(1)">首页</a>
						    </li>
						    
						    <c:forEach begin="1" end="${pageInfo.pages}" var="page">
						    
							    <!-- 不是当前页面 -->
							    <c:if test="${page!=pageInfo.pageNum}">
								    <li class="page-item">
								    	<a class="page-link" href="javascript:void()" onclick="goPage(${page})">${page}</a>
								    </li>
							    </c:if>
							    
							    <c:if test="${page==pageInfo.pageNum}">
							    	<li class="page-item active" aria-current="page">
								      <span class="page-link">
								        ${page}<span class="sr-only">(current)</span>
								      </span>
								    </li>
							    </c:if>
						    </c:forEach>
						    <li class="page-item">
						      <a class="page-link" href="javascript:void()" onclick="goPage(${pageInfo.pages})">尾页</a>
						    </li>
						</ul>
					</td>
				</tr>
		</table>
	</div>    
	<script>
		function goPage(page) {
			var url="/spu/list?page="+page;
			$("#workArea").load(url);
		}
		/**
		 单个删除	
		*/
		function del(id) {
			
			//要用户确认
			var re = confirm("是否要删除这些数据？ " + id)
			if(re==false)
				return;
			
			//将被选中的数组放入到数组当中
			var delIds = new Array(); 
			delIds.push(id)
			//进行删除操作
			$.post('/spec/delBatch',{ids:delIds},function(data){
				if(data==true){
					alert('删除成功')
					//刷新当前页面
					goPage(1)
				}else{
					alert("删除失败")
				}
			})
		}
		
		/**
			批量删除
		*/
		function delBatch(){
			if($("[name='ids']:checked").length<=0){
				alert("没有选中数据");
				return;
			}
			//将被选中的数组放入到数组当中
			var delIds = new Array(); 
			$("[name='ids']:checked").each(function(){
				delIds.push($(this).val())
			})
			
			//要用户确认
			var re = confirm("是否要删除这些数据？ " + delIds)
			if(re==false)
				return;
			//进行删除操作
			$.post('/spec/delBatch',{ids:delIds},function(data){
				if(data==true){
					alert('删除成功')
					//刷新当前页面
					goPage(1)
				}else{
					alert("删除失败")
				}
			})
		}
		/**
			添加
		*/
		function add(){
			//跳转到添加页面
			var url="/spu/toAdd";
			$("#workArea").load(url)
		}
		/**
		修改
		*/
		function update(id){
			var url="/spec/toUpdate?id="+id;
			$("#workArea").load(url)
		}
		//跳转到添加sku的页面
		function addSku(id){
			$("#workTitle").html('增加SKU')
			var url="/sku/toAdd?spuId="+id;
			$("#workArea").load(url)
		}
	</script>
</body>
</html>