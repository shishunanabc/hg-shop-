<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
<div class="container">
	<form id="skuForm">
		 <div class="form-group row">
		    <label for="nameId" class="col-sm-2 col-form-label">商品名称</label>
		    <div class="col-sm-8">
		      <input type="hidden" value="${spu.id}" name="spuId"> 	
		      <input type="text" readonly="readonly" value="${spu.goodsName}" class="form-control" id="nameId">
		    </div>
		  </div>
<!-- 		  private String title              ;//标题
	private String sellPoint         ; //卖点
	private BigDecimal price          ; //价格
	private int stockCount        ;  //库存
	private String barcode            ;//条形码
	private String image              ;//图片
	private int status             ; //状态
	private Date createTime        ; // 添加的时间
	private Date updateTime        ;//修改的时间
	private BigDecimal costPrice         ; //成本
	private BigDecimal marketPrice       ;//市场价格
	private int spuId             ;//spu的id
	private String cartThumbnail     ;// 购物车显示的小图           -->     
		  
		  <div class="form-group row">
		    <label for="captionId" class="col-sm-2 col-form-label">标题</label>
		    <div class="col-sm-8">
		      <input type="text" name="title" class="form-control" id="captionId">
		    </div>
		  </div>
		  
		 <div class="form-group row">
		    <label for="sellPointId" class="col-sm-2 col-form-label">卖点</label>
		    <div class="col-sm-8">
		      <input type="text" name="sellPoint" class="form-control" id="sellPointId">
		    </div>
		  </div>
		  
		   <div class="form-group row">
		    <label for="priceId" class="col-sm-2 col-form-label">当前价格</label>
		    <div class="col-sm-8">
		      <input type="text" name="price" class="form-control" id="priceId">
		    </div>
		  </div>
		  
		   <div class="form-group row">
		    <label for="marketPriceId" class="col-sm-2 col-form-label">市场价格</label>
		    <div class="col-sm-8">
		      <input type="text" name="marketPrice" class="form-control" id="marketPriceId">
		    </div>
		  </div>
		  
		   <div class="form-group row">
		    <label for="costPriceId" class="col-sm-2 col-form-label">成本价格</label>
		    <div class="col-sm-8">
		      <input type="text" name="costPrice" class="form-control" id="costPriceId">
		    </div>
		  </div>
		  
		 <div class="form-group row">
		    <label for="stockCountId" class="col-sm-2 col-form-label">库存</label>
		    <div class="col-sm-8">
		      <input type="text" name="stockCount" class="form-control" id="stockCountId">
		    </div>
		  </div>
		  
		 <div class="form-group row">
		    <label for="stockCountId" class="col-sm-2 col-form-label">规格</label>
		    <div class="col-sm-8">
		     	<table class="table" id="tabelProp">
		     		<tr>
		     			<th>属性名称</th><th>属性值</th><th>操作 <button type="button" class="btn-sm btn-outline-danger" onclick="addProp()">添加属性</button></th>
		     		</tr>
		     		
		     	</table>
		    </div>
		  </div>
		  
		   
		  <div class="form-group row">
		    <label for="cartThumbnailId" class="col-sm-2 col-form-label">购物车小图</label>
		    <div class="col-sm-10">
		     	<input type="file" class="btn-sm btn-outline-success"  name="cartThumbnailFile" id="cartThumbnailId">
		    </div>
		  </div>
		  
		  <div class="form-group row">
		    <label for="imageId" class="col-sm-2 col-form-label">购物车小图</label>
		    <div class="col-sm-10">
		     	<input type="file" class="btn-sm btn-outline-success"  name="imageFile" id="imageId">
		    </div>
		  </div>
		  
		  
		   <div class="form-group row">
		    <label for="captionId" class="col-sm-2 col-form-label"></label>
		    <div class="col-sm-10">
		    	<input type="button" value="提交" onclick="commitData()">
		    </div>
		   </div>
		    
		  
	</form>
	
	<table id="trid" style="display: none;">
		    		<tr>
		     			<td>
		     				<select name="specId" onchange="specChange($(this))">
		     					<c:forEach items="${specList}" var="spec">
		     						<option value="${spec.id}">${spec.specName}</option> 
		     					</c:forEach>
		     				</select>
		     			</td>
		     			<td>
		     				<select name="optionId">
		     				</select>
		     			</td>
		     			<td>
		     				<button type="button" class="btn-sm btn-outline-danger" onclick="delprop($(this))">删除</button>
		     			</td>
		     		</tr>
		    	</table>
	
	
</div>

<script>
	function specChange(specObj){
		alert(specObj.val());
		var specId=specObj.val();
		$.post('/spec/getOptions',{specId:specId},function(data){
			// 显示属性值的下拉框
			var optionSelect = specObj.parent().next().children(":first");
			optionSelect.empty();
			for(var op in data){
				//alert(op)
				optionSelect.append("<option value='"+data[op].id+"'>"+data[op].optionName+"</option>")
			}
		})
	}
	
	//添加一行
	function addProp(){
		$("#tabelProp").append($("#trid").html());
	}
	
	//删除一行
	function delprop(btbObj){
		btbObj.parent().parent().remove();
	}
	
	//提交数据
	function commitData(){
		var formData = new FormData($("#skuForm")[0])
		$.ajax({url:'/sku/add',
				data:formData,
				type:"post",
				processData:false,
				contentType:false,
				success:function(data){
					if(data==true){
						alert('添加成功')
						//跳转到列表页面
						var url="/sku/list";
						$("#workArea").load(url)
					}else{
						alert('添加失败')
					}
				}
					
		})
	}
	
	
</script>