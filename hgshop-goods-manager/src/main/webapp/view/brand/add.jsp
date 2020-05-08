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
	<form id="brandForm"> 			
	  <div class="form-group row">
	    <label for="specName" class="col-sm-2 col-form-label">名称</label>
	    <div class="col-sm-10">
	      <input type="text" id="name" name="name" value="">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="specName" class="col-sm-2 col-form-label">型号</label>
	    <div class="col-sm-10">
	      <input type="text" id="firstChar" name="firstChar" value="">
	    </div>
	  </div>
	  <div class="form-group row">
	  	<div class="col-sm-10">  
	        <input type="button" name="" class="btn btn-success" value="提交数据" onclick="commitData()">
	    </div>
	  </div>
	</form>   

	<script>
		/**
			提交数据
		*/
		function commitData(){
			var formData = new FormData($("#brandForm")[0])
			$.ajax({url:'/brand/add',
					data:formData,
					type:"post",
					processData:false,
					contentType:false,
					success:function(data){
						if(data==true){
							alert('添加成功')
							//跳转到列表页面
							var url="/brand/list";
							$("#workArea").load(url)
						}else{
							alert('添加失败')
						}
					}	
			})
		}
	</script>
</body>
</html>