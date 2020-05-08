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
<title>分类管理</title>
<%-- <link  href="<%=request.getContextPath() %>/css/index3.css"     rel="stylesheet"   type="text/css">
 --%><script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<!-- <link rel="stylesheet" type="text/css"href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
 --><script type="text/javascript"src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script> 
<script type="text/javascript"  src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" > 
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 左侧显示树状图 -->
			<div class="col-md-5">
				<div id=catTree>
				
				</div>
			</div>
			<!-- 右侧显示添加删除等 -->
			<div class="col-md-5">
				<!-- 用于添加的 -->
				<form id="addForm">
				  <div class="form-group row">
				  	<input type="hidden" name="parentId"  id="parentId">
				    <label for="parentNodeName" class="col-sm-2 col-form-label">父节点</label>
				    <div class="col-sm-10">
				      <input type="text" readonly class="form-control-plaintext" id="parentNodeName" value="">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="parentNodePath" class="col-sm-2 col-form-label">父节点</label>
				    <div class="col-sm-10">
				      <input type="text" readonly class="form-control-plaintext" id="parentNodePath" value="">
				    </div>
				  </div>
				 <div class="form-group row">
				    <label for="addNodeName" class="col-sm-2 col-form-label">节点名称</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="name"  id="addNodeName">
				    </div>
				  </div>
				  
				   <div class="form-group row">
				    <label for="addButton" class="col-sm-2 col-form-label"></label>
				    <div class="col-sm-10">
				      <input type="button" class="btn btn-outline-warning" name="name" onclick="addNode()" value="添加" id="addButton">
				    </div>
				  </div>
				  
				</form>
				
				<hr/>
				
				<!-- 用于修改和删除 -->
				<form id="updateForm">
				  <div class="form-group row">
				  	<input type="hidden" id="currentNodeId" value="0">
				    <label for="currentNodeName" class="col-sm-2 col-form-label">节点名称</label>
				    <div class="col-sm-10">
				      <input type="text"  class="form-control" id="currentNodeName" value="">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="currentNodePath" class="col-sm-2 col-form-label">路径</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="currentNodePath">
				    </div>
				  </div>
				   <div class="col-sm-10">
				      <input type="button" class="btn btn-outline-warning"  onclick="updateNode()" value="修改" id="updateButton">
				      <input type="button" class="btn btn-outline-danger"  onclick="delNode()" value="删除" id="delButton">
				    </div>
				</form>
			</div>
		</div>
	</div>  
	<script>
		function initTree(){
			
			$.post("/cat/treeData", {},
					function(treeData) {
						//初始化添加的时候分类的树
						$("#catTree").treeview({
							data : treeData,
							levels : 2,
							onNodeSelected : function(event, node) {
								//alert(node.text)
								$("#parentId").val(node.id)
								$("#parentNodeName").val(node.text)
								$("#parentNodePath").val(node.path)	
								
								
								$("#currentNodeId").val(node.id)
								$("#currentNodeName").val(node.text)
								$("#currentNodePath").val(node.path)	
								
								//末级节点
								if(node.nodes.length==0){
									$("#delButton").attr("disabled",false)
								}else{
									
									$("#delButton").attr("disabled",true)
								}
								
						}
					});
						$("#parentId").val(0)
						$("#parentNodeName").val("")
						$("#parentNodePath").val("")
						
						$("#currentNodeId").val(0)
						$("#currentNodeName").val("")
						$("#currentNodePath").val("")	
						//末级节点					
						$("#delButton").attr("disabled",true)
	
				}, "json");
		}
		initTree();
		
		//添加节点
		function addNode(){
			
			$.post("/cat/add",{parentId:$("#parentId").val(),
				               name:$("#addNodeName").val(),
				               path:$("#parentNodePath").val() + "/" + $("#addNodeName").val() 
							  },
				function(data){
				if(data==true){
					alert("添加成功")
					//刷新数据
					initTree();
				}else{
					alert("添加失败")
				}
				}		
			)
		}
		//修改节点
		function updateNode(){
			$.post("/cat/update",{id:$("#currentNodeId").val(),
	            name:$("#currentNodeName").val(),
	            path:$("#currentNodePath").val()
				  },
					function(data){
					if(data==true){
						alert("修改成功")
						//刷新数据
						initTree();
					}else{
						alert("修改失败")
					}
				}		
			)
		}
		//删除节点
		function delNode(){
			
			var result = confirm("亲，真的要删除么?")
			if(!result)
				return ;	
			
			$.post("/cat/del",{id:$("#currentNodeId").val()},
					function(data){
					if(data==true){
						alert("删除成功")
						//刷新数据
						initTree();
					}else{
						alert("删除失败")
					}
				}		
			)	
		}
	</script>  
</body>
</html>