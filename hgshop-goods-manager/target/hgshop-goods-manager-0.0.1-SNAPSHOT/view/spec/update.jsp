<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 --%>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"
	src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="container">
		<form id="specForm">
			<div class="form-group row">
				<input type="hidden" name="id" value="${spec.id}"> <label
					for="specName" class="col-sm-2 col-form-label">规格名称</label>
				<div class="col-sm-10">
					<input type="text" id="specName" name="specName"
						value="${spec.specName}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
						name="" class="btn btn-success" value="增加属性值" onclick="addLin()">
				</div>
			</div>
			<div class="form-group row">
				<table class="table" id="optionTable">
					<tr>
						<th>属性值</th>
						<th>排序</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${spec.specOption}" var="op" varStatus="opIndex">
						<tr>
							<td><input type="text"
								name="specOption[${opIndex.index}].optionName"
								value="${op.optionName}"></td>
							<td><input type="number"
								name="specOption[${opIndex.index}].orders" value="${op.orders}"></td>
							<td><input type="button" name="" class="btn btn-success"
								onclick="delLin($(this))" value="删除"></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="form-group row">
				<div class="col-sm-10">
					<input type="button" name="" class="btn btn-success" value="提交数据"
						onclick="commitData()">
				</div>
			</div>
		</form>

	</div>

	<script>
			//删除自己的行
			function delLin(jObj){
				jObj.parent().parent().remove();
			}
			
			var linIndex=parseInt("${spec.specOption.size()}");
			//alert(linIndex)
			// 添加行
			function addLin(){
				$("#optionTable").append('<tr>' +
		    			'<td><input type="text" name="specOption['+linIndex+'].optionName"></td> ' +
		    			'<td><input type="number" name="specOption['+linIndex+'].orders"></td> ' +
		    			'<td><input type="button" name="" class="btn btn-success" onclick="delLin($(this))" value="删除"></td> ' +
		    		'</tr>')
		    		linIndex++;	
			}
			
			/**
				提交数据
			*/
			function commitData(){
				var formData = new FormData($("#specForm")[0])
				$.ajax({url:'/spec/update',
						data:formData,
						type:"post",
						processData:false,
						contentType:false,
						success:function(data){
							if(data==true){
								alert('修改成功')
								//跳转到列表页面
								var url="/spec/list";
								$("#workArea").load(url)
							}else{
								alert('修改失败')
							}
						}
							
				})
			}
		</script>
</body>
</html>