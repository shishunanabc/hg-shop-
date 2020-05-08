<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>品牌管理</title>
<%-- <link  href="<%=request.getContextPath() %>/css/index3.css"     rel="stylesheet"   type="text/css">
 --%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"
	src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="container">
		<button type="button" class="btn btn-success" onclick="add()">添加</button>
		<button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button>
		  <div class="input-group-prepend" align="center">
		    <span class="input-group-text rounded" id="basic-addon1" style="height: 40px;margin-top: 15px">商品名:</span>
		  	<input type="text" class="form-control rounded" name="firstChar" placeholder="请输入你要查询的商品名" 
		 	 aria-label="Username" aria-describedby="basic-addon1" style="margin-top: 15px">
		 	 <button class="btn btn-light" onclick="list()">查询</button>
		  </div>
	</div>
	<div>
		<table class="table">
			<tr>
				<th>id  <input type="checkbox" onclick="fx()" ></th>
				<th>名称</th>
				<th>型号</th>
				<th>flag</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageInfo.list}" var="brand">
				<tr>
					<td>${brand.id}  <input name="ids" type="checkbox" value=${brand.id }></td>
					<td>${brand.name}</td>
					<td>${brand.firstChar}</td>
					<td>${brand.deletedFlag}</td>
					<td>
						<button type="button" class="btn btn-success"
							onclick="update(${brand.id})">修改</button>
						<button type="button" class="btn btn-danger" onclick="del(${brand.id})">删除</button>
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
			<tr>
				<td colspan="10">当前页${ pageInfo.pageNum}/${pageInfo.pages}
					共${pageInfo.total}个品牌</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		//反选
		function fx() {
		    $("[name=ids]").each(function() {
		          this.checked=!this.checked;
		    })
		}
		//模糊查寻
		function list(){
				var url="/brand/list?firstChar="+$("[name=firstChar]").val();
				$("#workArea").load(url);
		}
		function goPage(page) {
			var url="/brand/list?page="+page;
			$("#workArea").load(url);
		}
		function add(){
			//跳转到添加页面
			var url="/brand/toAdd";
			$("#workArea").load(url);
		}
		function update(id){
			//跳转到添加页面
			var url="/brand/toUpdate?id="+id;
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
			$.post('/brand/delBatch',{ids:delIds},function(data){
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
			$.post('/brand/delBatch',{ids:delIds},function(data){
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
	</script>
</body>
</html>