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
</head>
<body>
	<div calss="container">
		<!-- 导航开始 -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		    <a class="navbar-brand" href="#">豪哥商城--首页</a>
		    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      <li class="nav-item active">
		        <a class="nav-link" href="/user/login">登录</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/user/register">注册</a>
		      </li>
		    </ul>
		    <form class="form-inline my-2 my-lg-0">
		      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		    </form>
		  </div>
		</nav>
		<!-- 导航结束 -->
		<div style="margin-bottom: 60px ;margin-top: 20px">
			<div class="row">
				<div class="col-md-4" >
					<!-- 显示树  -->
					<div id="catTree" style="margin-left: 30px">
						
					</div>
				</div>
				<div class="col-md-8"> 
					<div class="row">
						<c:forEach items="${pageInfo.list}" var="spu">
							<div class="col-md-3" style="margin-top: 20px">
								<a href="spuDetail?spuId=${spu.id}" target="_blank"> <img src="/pic/${spu.smallPic}" width="180" height="180" > </a> 
									${spu.brand.name} ${spu.category.name}
									<br/>
									${spu.goodsName}					
							</div>
						</c:forEach>
					</div>
					
					<div class="row" style="margin-top: 20px">
						<nav aria-label="Page navigation example">
						  <ul class="pagination justify-content-end">
						    <li class="page-item ">
						      <a class="page-link"  href="javascript:void(0)" onclick="goPage(1)">首页</a>
						    </li>
						    <c:forEach begin="${(pageInfo.pageNum-5)>1?pageInfo.pageNum-5:1}"
						       end="${(pageInfo.pageNum+5)>pageInfo.pages?pageInfo.pages:(pageInfo.pageNum+5)}" var="page">
						   		 <c:if test="${pageInfo.pageNum==page}">
						   		 	 <li class="page-item disabled" ><a class="page-link" href="javascript:void(0)" aria-disabled="true" >${page}</a></li> 
						   		 </c:if>
						   		  <c:if test="${pageInfo.pageNum!=page}">
						   		 	 <li class="page-item"><a class="page-link" href="javascript:void(0)" onclick="goPage(${page})">${page}</a></li> 
						   		 </c:if>
						    </c:forEach>
						    
						    <li class="page-item">
						      <a class="page-link"  href="javascript:void(0)" onclick="goPage(${pageInfo.pages})">尾页</a>
						    </li>
						  </ul>
						</nav>
					</div>
					
				</div>
			</div>
		</div>
		
		<nav class="navbar navbar-expand-lg fixed-bottom navbar-light bg-light">
			  底部
		</nav>
	
	</div>
  <script type="text/javascript">
  function initTree(){
		
		$.post("/treeData", {},
				function(treeData) {
					//初始化添加的时候分类的树
					$("#catTree").treeview({
						data : treeData,
						levels : 2,
						onNodeSelected : function(event, node) {
							//alert(node.text)
							if(node.nodes.length==0){
								location.href="/index?catId="+node.id;
							}
							
					}
				});	

			}, "json");
	}
	initTree();
	
	function goPage(page){
		location.href="/index?catId=${catId}&page="+page;
	}
  </script>		
</body>	
</html>