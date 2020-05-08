<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">

	
	<div class="container" >
		<form id="queryForm">
		 <div class="form-group row">
		    <label for="nameid" >关键字</label>
		    <div class="col-sm-3">
		      <input type="text" name="keyWord"  id="nameid" value="${skuVo.keyWord}">
		    </div>
		    
		    <label for="captionid">价格范围</label>
		    <div class="col-sm-6">
		      	从<input type="text" name="minPrice"  value="${skuVo.minPrice}"> 
		                    到<input type="text" name="maxPrice"  value="${skuVo.maxPrice}">
		    </div>
		    
		  </div>
		  <div class="form-group row">
		  	  <label for="brandDomid" >更新时间</label>
		    <div class="col-sm-4">
		      	从<input type="date" name="minTime"  value="${skuVo.minTime}"> 
		                    到<input type="date" name="maxTime"  value="${skuVo.maxTime}">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		  	<label for="nameid" >排序数据项：</label>
		  	 <div class="col-sm-4">
		  	  
		  	 	&nbsp;&nbsp;<input type="checkbox" value="id"  name="sortColumn"
		  	 	  <c:forEach items="${skuVo.sortColumn}" var="col"> <c:if test="${col=='id'}">checked="checked" </c:if> </c:forEach>
		  	     >id
		  	 	&nbsp;&nbsp;<input type="checkbox"  name="sortColumn"
		  	 		<c:forEach items="${skuVo.sortColumn}" var="col"> <c:if test="${col=='price'}">checked="checked" </c:if> </c:forEach>
		  	 	value="price">价格
		  	 	&nbsp;&nbsp;<input type="checkbox"  name="sortColumn"
		  	 	<c:forEach items="${skuVo.sortColumn}" var="col"> <c:if test="${col=='stock_count'}">checked="checked" </c:if> </c:forEach>
		  	 	value="stock_count"> 库存
		  	 	&nbsp;&nbsp;<input type="checkbox"  name="sortColumn"
		  	 	   <c:forEach items="${skuVo.sortColumn}" var="col"> <c:if test="${col=='update_time'}">checked="checked" </c:if> </c:forEach>
		  	 	value="update_time"> 更新时间
		    </div>
		    
		    <label for="nameid" >排序方式：</label>
		  	 <div class="col-sm-4">
		  	 	  <select name="orderType" id="orderTypeId">
		     		<option value="">请选择</option> 
		     		<option value="ASC" ${spuVo.orderType=='ASC'? 'selected':'' } >升序</option> 
		     		<option value="DESC" ${spuVo.orderType=='DESC'? 'selected':'' } >降序</option> 
		     	</select>
		    </div>
		  </div>
			 
			<button type="button" class="btn btn-danger" onclick="goPage(1)">查询</button> 
			<button type="button" class="btn btn-danger" onclick="add()">添加</button> 
			<button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button>
		</form>
		
		
	</div>
	<table class="table">
		<tr>
			<th>id <input type="checkbox" onclick="fx()"></th>
			<th>商品名称</th>
			<th>品牌</th>
			<th>分类</th>
			<th>标题</th>
			<th>卖点</th>
			<th>价格</th>
			<th>库存</th>
			<th>更新时间</th>
			<th>图片</th>
			
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="sku">
			<tr>
			<td>${sku.id} <input name="ids" type="checkbox" value="${sku.id}"> </td>
			<td>${sku.spu.goodsName}</td>
			<td>${sku.spu.brand.name}</td>
			<td>${sku.spu.category.name}</td>
			<td>${sku.title}</td>
			<td>${sku.sellPoint}</td>
			<td>${sku.price}</td>
			<td>${sku.stockCount}</td>
			<td> <fmt:formatDate value="${sku.updateTime}" pattern="yyyy-MM-dd" /></td>
			<td><img src="${pageContext.request.contextPath}/pic/${sku.image}" width="40" height="40"></td>
			<td>
				<button type="button" class="btn btn-outline-success" onclick="update(${sku.id})">修改</button>
				<button type="button" class="btn btn-outline-danger" onclick="del(${sku.id})">删除</button>
			</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="4">
			  <ul class="pagination">
			    <li class="page-item ">
			      <a class="page-link" href="javascript:void(0)" onclick="goPage(1)">首页</a>
			    </li>
			    
			    <c:forEach begin="1" end="${pageInfo.pages}" var="page">
			    
				    <!-- 不是当前页面 -->
				    <c:if test="${page!=pageInfo.pageNum}">
					    <li class="page-item">
					    	<a class="page-link" href="javascript:void(0)" onclick="goPage(${page})">${page}</a>
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
			      <a class="page-link" href="javascript:void(0)" onclick="goPage(${pageInfo.pages})">尾页</a>
			    </li>
			  </ul>
	</td>
		</tr>
	</table>
</div>    
<script>

	function goPage(page){
		var url="/sku/list?page="+page;
		$("#workArea").load(url,$("#queryForm").serialize());		
	}
	
	/**
	 单个删除	
	*/
	function del(ids) {
		
		//要用户确认
		var re = confirm("是否要删除这些数据？ " + ids)
		if(re==false)
			return;
		//进行删除操作
		$.post('/sku/delBatch',{ids:ids},function(data){
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
		var ids=$("[name='ids']:checked").map(function(){
			return this.value;
		}).get().join();
		
		//要用户确认
		var re = confirm("是否要删除这些数据？ " + ids)
		if(re==false)
			return;
		
		//进行删除操作
		alert(ids)
		$.post('/sku/delBatch',{ids:ids},function(data){
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
		var url="/sku/toAdd";
		$("#workArea").load(url)
	}
	
	/**
	修改
	*/
	function update(id){
		var url="/sku/toUpdate?id="+id;
		$("#workArea").load(url)
	}


	function fx() {
	    $("[name=ids]").each(function() {
	          this.checked=!this.checked;
	    })
	}
</script>
