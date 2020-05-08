<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
<div class="container">
	<form id="spuForm">
		 <div class="form-group row">
		    <label for="nameId" class="col-sm-2 col-form-label">名称</label>
		    <div class="col-sm-10">
		      <input type="text" name="name" class="form-control" id="nameId">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="captionId" class="col-sm-2 col-form-label">标题</label>
		    <div class="col-sm-10">
		      <input type="text" name="caption" class="form-control" id="captionId">
		    </div>
		  </div>
		  
		  <div class="form-group row" >
		   <div class="col-sm-10" id="catTree" style="display:none ;position: absolute; z-index: 1000;width: 90%" >
		   </div>
		 </div>
		 <div class="form-group row">
		    <label for="captionId" class="col-sm-2 col-form-label">分类</label>
		    <div class="col-sm-6">
		    	<input type="hidden" value="0" name="categoryId" id="categoryId">
		      <input type="text" readonly="readonly" name="categoryName" class="form-control" id="categoryNameId">
		    </div>
		     <div class="col-sm-4">
		       <input type="button" value="..." onclick="showCat()">
		     </div>
		  </div>
		  
		  
		  <div class="form-group row">
		    <legend class="col-form-label col-sm-2 pt-0">是否上架</legend>
		   <div class="col-sm-10">
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="isMarketable" id="gridRadios1" value="1" checked>
		          <label class="form-check-label" for="gridRadios1">
		            	上架
		          </label>
		        </div>
		        <div class="form-check">
		          <input class="form-check-input" type="radio" name="isMarketable" id="gridRadios2" value="0">
		          <label class="form-check-label" for="gridRadios2">
		            	不上架
		          </label>
		        </div>
		      </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="captionId" class="col-sm-2 col-form-label">品牌</label>
		    <div class="col-sm-10">
		     	<select id="brandDomid" name="brandId">
		     		<option value="0">请选择</option> 
		     		<c:forEach items="${brandList}" var="brand">
		     			<option value="${brand.id}" >
		     			    ${brand.name}</option> 
		     		</c:forEach>
		     	</select>
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="captionId" class="col-sm-2 col-form-label">图片</label>
		    <div class="col-sm-10">
		     	<input type="file" name="imgFile">
		    </div>
		  </div>
		  
		   <div class="form-group row">
		    <label for="captionId" class="col-sm-2 col-form-label"></label>
		    <div class="col-sm-10">
		    	<input type="text" value="提交" onclick="commitData()">
		    </div>
		   </div>
		  
	</form>
	<script>
	
	//提交数据
	function commitData(){
		var formData = new FormData($("#spuForm")[0])
		$.ajax({url:'/spu/add',
				data:formData,
				type:"post",
				processData:false,
				contentType:false,
				success:function(data){
					if(data==true){
						alert('添加成功')
						//跳转到列表页面
						var url="/spu/list";
						$("#workArea").load(url)
					}else{
						alert('添加失败')
					}
				}	
		})
	}
	function initTree(){
		
		$.post("/cat/treeData", {},
				function(treeData) {
					//初始化添加的时候分类的树
					$("#catTree").treeview({
						data : treeData,
						levels : 2,
						onNodeSelected : function(event, node) {
							//alert(node.text)
							if(node.nodes.length==0){
								$("#categoryNameId").val(node.text)
								$("#categoryId").val(node.id)
								$("#catTree").hide()
							}
							
					}
				});
			}, "json");
	}
	initTree();
	
		function showCat(){
			$("#catTree").show()
		}
	</script>
</div>