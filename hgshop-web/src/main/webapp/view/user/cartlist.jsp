<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<div class="container">

	
	<div class="container" >
		<button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button>
		
	</div> 
	<table class="table">
		<tr>
			<th>id  <input type="checkbox"></th>
			<th>名称</th>
			<td>单价</td>
			<td>数量</td>
			<td>总价</td>
			<td>时间</td>
			
		
			<th>操作</th>
		</tr>
		<c:forEach items="${cartList}" var="cart">
			<tr>
			<td>${cart.id} <input name="ids" type="checkbox" value="${cart.id}"> </td>
			<td>${cart.skuName}</td>
			<td>${cart.unitPrice}</td>
			<td>${cart.pnum}</td>
			<td>
				${cart.pnum * cart.unitPrice}
			</td>
			<td><fmt:formatDate value="${cart.createtime}" pattern="yyyy-MM-dd"/></td>
			<td>
				<button type="button" class="btn-sm btn-outline-success" onclick="update(${spu.id})">修改</button>
				<button type="button" class="btn-sm btn-outline-danger" onclick="del(${spu.id})">删除</button>
				<button type="button" class="btn-sm btn-outline-primary" onclick="addSku(${spu.id})">添加</button>
			</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
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
	<div>
		<label>配送地址</label>
		
		<input id="address" >
		<br>
		<button type="button" class="btn btn-danger" onclick="createOrder()">生成订单</button> 
	
	</div>
</div>    
<script>

	
	
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
				alert('加入成功')
				//刷新当前页面
				goPage(1)
			}else{
				alert("删除失败")
			}
		}
		)
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
		}
		)
		
	}
	
	
	/**
	批量删除
*/
function createOrder(){
	
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
	var re = confirm("是否要根据这些数据生成订单？ " + delIds)
	if(re==false)
		return;
	
	//进行生成订单操作
	$.post('/user/createOrder',{ids:delIds,address:$("#address").val()},function(data){
		if(data==true){
			alert('生成成功')
			//刷新当前页面
			goPage(1)
		}else{
			alert("生成失败")
		}
	}
	)
	
}
	

</script>
