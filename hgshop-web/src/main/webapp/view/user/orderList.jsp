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
			<th>用户</th>
			<td>价格</td>
			<td>地址</td>
			<td>创建时间</td>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="list" varStatus="count">
			<tr>
			<td><input type="checkbox" name="ids" value="${list.oid}">${count.count+startRow}</td>
			<td>${user.username}</td>
			<td>${list.sumtotal}</td>
			<td>${list.address}</td>
			<td><fmt:formatDate value="${list.createTime}" pattern="yyyy-MM-dd"/></td>
			<td>
				<button type="button" class="btn-sm btn-outline-success" onclick="update(${spu.id})">修改</button>
				<button type="button" class="btn-sm btn-outline-danger" onclick="del(${spu.id})">删除</button>
				<button type="button" class="btn-sm btn-outline-primary" onclick="addSku(${spu.id})">添加</button>
			</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<label>请点击支付按钮</label>
		<br>
		<button type="button" class="btn btn-danger" onclick="createOrder()">支付</button> 
	
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
			alert('添加成功')
			//刷新当前页面
			goPage(1)
		}else{
			alert("添加失败")
		}
	}
	)
	
}
	

</script>
