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
<title>规格管理</title>
<%-- <link  href="<%=request.getContextPath() %>/css/index3.css"     rel="stylesheet"   type="text/css">
 --%><script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script> 
<script type="text/javascript"  src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script> 
</head>
<body>
	<div class="container">
		<div class="container">
			<button type="button" class="btn btn-danger" onclick="add()">添加</button> 
			<button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button>
		</div>
			<table class="table">
				<tr>
					<th>id  <input type="checkbox"></th>
					<th>名称</th>
					<th>规格属性值</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageInfo.list }" var="spec">
					<tr>
						<td>${spec.id } <input name="ids" type="checkbox" value=${spec.id }></td>
						<td>${spec.specName }</td>
						<td>
							<c:forEach items="${spec.specOption }" var="op" varStatus="index">
								<c:if test="${index.index>0}">,</c:if>${op.optionName }
							</c:forEach>
						</td>
						<td>
							<button type="button" class="bth bth-outline-success" onclick="update(${spec.id})">修改</button>
							<button type="button" class="bth bth-outline-danger" onclick="del(${spec.id})">删除</button>
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
	<script type="text/javascript">
		function goPage(page) {
			var url="/spec/list?page="+page;
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
			}
			)
			
		}
		/**
			添加
		*/
		function add(){
			//跳转到添加页面
			var url="/spec/toAdd";
			$("#workArea").load(url)
		}
		/**
			修改
		*/
		function update(id){
			//跳转到修改页面
			var url="/spec/toUpdate?id="+id;
			$("#workArea").load(url)
		}
	</script>
</body>
</html>