<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<div>
	<input id="queryName" value="${queryName}"/>
	<button type="button" class="btn btn-primary" onclick="query()">
   	查询 </button>
   	
   	<button type="button" class="btn btn-danger" onclick="delBatch()">
   	批量删除</button>
   	
   	
	<button type="button" class="btn btn-success" data-toggle="modal" data-target="#staticBackdrop">
   	添加 </button>
   	
   	
   	
</div>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加商标</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="add">
        		 <div class="form-group">
    				<label for="name">名称</label>
    				<input type="text" class="form-control" name="name" id="name" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入名称</small>
  				</div>
  				<div class="form-group form-group-proper">
    				<label for="inputAddress">首字母</label>
    				<input type="text" name="firstChar" class="form-control" id="inputAddress" >
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commit()">提交</button>
      </div>
    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade" id="staticBackdropUpdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
         <button type="button" onclick="addProp('#updatespec')"> 添加属性</button>
         
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
      <div class="modal-body">
        	<form id="update">
        		 <input type="hidden" name="id" id="upId">
        		 <div class="form-group">
    				<label for="name">名称</label>
    				<input type="text" class="form-control" name="name" id="upspecName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入规格名称</small>
  				</div>
  				<div class="form-group form-group-proper">
    				<label for="inputAddress">首字母</label>
    				<input type="text" name="firstChar" class="form-control" id="inputAddress" placeholder="1234 Main St">
    				
  				</div>
  				
    			
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitUpdate()">提交</button>
      </div>
    </div>
  </div>
</div>


<table class="table">
	
	<tr> 
		<th><input type="checkbox" id="allSel" onchange="selectedAll()">  
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(1)">全选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(2)">全不选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(3)">反选</button>
		 </th>
		<th>名称</th>
		<th>首字母</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${pageInfo.list}" var="brand">
		<tr>
			<td><input type="checkbox" name="ids" value="${brand.id}" onchange="selectedOne()"> ${brand.id}</td>
			<td>${brand.name}</td>
			<td>${brand.firstChar}</td>
			
			<td>
				<button type="button" class="btn btn-danger" onclick="delBrand(${brand.id})">删除</button>
				<button type="button" class="btn btn-warning" onclick="openUpdateSpec(${brand.id})">修改</button>
			</td>
			
		</tr>
	</c:forEach>
	
	<!-- pageInfo -->
	<tr>
		<td colspan="3">
			<jsp:include page="../common/page.jsp"></jsp:include>
		</td>
	</tr>
</table>    

<script type="text/javascript">
	
	
	
	// 提交修改
	function commitUpdate(){
		
		//addspec
		var formData = new FormData($("#update")[0]);
		$.ajax({url:"/brand/update",
			 // dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(flag){
				 if(flag){
					 alert("数据提交成功");
					 $('#staticBackdropUpdate').modal('hide');
				 }else{
					 alert("数据保存失败");
				 }
				 
			  }
			  })
		
	}
	// 弹出修改的窗口
	function openUpdateSpec(id){
		
		
		
		
		$.post("/brand/get",{id:id},function(data){
			//规格的id
			$("[name=id]").val(data.id)
			$("[name=name]").val(data.name)
			$("[name=firstChar]").val(data.firstChar)
			
			
		});
		
		$("#staticBackdropUpdate").modal('show')
	}
	
	/**
	* 删除规格
	*/
	function delBrand(id){
		if(confirm("您确认删除该条数据么？")){
			$.post("/brand/delBrand",{id:id},function(flag){
				if(flag){
					alert("删除成功");
					refresh();
				}else{
					alert("删除失败");
				}
				
			});
		}else{
			return;
		}
	}
	
	/**
		批量删除
	*/
	function delBatch(){
		
		if($("[name=ids]:checked").length<=0){
			alert("没有数据被选中，不能删除")
			return;
		}
		
		
		
		// 组织删除的数据
		var delIds  = new Array();
		$("[name=ids]:checked").each(function(){
			delIds.push($(this).val());
		})
		
		
		if(confirm("您确认删除这些数据么？")){
			$.post("/brand/delBrandBatch",{ids:delIds},function(flag){
				if(flag){
					alert("删除成功");
					refresh();
				}else{
					alert("删除失败")
				}
				
			});
		}else{
			return;
		}
	}
	
	/**
	 	点击全选的checkbox
	*/
	function selectedAll(){
		var checked = $("#allSel").prop("checked")
		// 让每个checkbox 都等于 总的checkbox
		$("[name=ids]").each(function(){
				$(this).prop("checked",checked)
			}
		)
	}
	
	/**
	* 修改一个checkbox
	*/
	function selectedOne(){
		// 判断是否所有的都被选中了
		var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
		//设置全选的框
		$("#allSel").prop("checked",allSelected)
	}
	
	/**
	点击三个按钮
	*/
	function selAll(flag){
		
	 	if(flag==1){
			//全选
			$("[name=ids]").each(function(){
				$(this).prop("checked",true)
			}
			)
		}
		
		if(flag==2){
			//全不选
			$("[name=ids]").each(function(){
				$(this).prop("checked",false)
			})
		}
		if(flag==3){
			//反选
			$("[name=ids]").each(function(){
				var ch = !$(this).prop("checked")
				$(this).prop("checked",ch)
			}
			)
		} 
		// 判断是否所有的都被选中了
		var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
		//设置全选的框
		$("#allSel").prop("checked",allSelected)
		
	}
	
	
	
	/* function clearData(){
		alert('test')
		console.log('start clear')
		$("div .addform-grop").each(function(){
			console.log('ff')
			$(this).remove()
		})
	} */
	// 如何清空数据
    // 删除规格属性
    // 修改规格属性的名称
    // 分页
    //
    // 修改的时候   modul onshow  onhidden
    // 
    // 删除规格
    // 查询条件回显
    // 分页带条件 
	
    /**
          查询
    */
    function query(){
		var url="/brand/list?name="+$("#queryName").val();
		$("#main").load(url);
	}
	
	/**
	* 分页 
	*/
	function goPage(pagenum){
		
		var url="/brand/list?name="+$("#queryName").val()+'&page='+pagenum;
		$("#main").load(url);
	}
	
	/**
	* 刷新 而且保持查询条件和页码
	*/
	function refresh(){
		
		var url="/brand/list?name=${queryName}"+'&page=${pageInfo.pageNum}';
		$("#main").load(url);
	}
	
	
	
	
	
	
	
	// 给添加规格模态框增加关闭以后的事件  
	$('#staticBackdrop').on('hidden.bs.modal', function (e) {
		  // do something...
		refresh();
	})
	
	// 给修改规格模态框增加关闭以后的事件  
	$('#staticBackdropUpdate').on('hidden.bs.modal', function (e) {
		  // do something...
		refresh();
	})
	
	
	
	/**
	  提交数据	
	*/
	function commit(){
		//addspec
		var formData = new FormData($("#add")[0]);
		$.ajax({url:"/brand/add",
			 // dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(flag){
				 if(flag){
					 alert("数据提交成功");
					 $('#staticBackdrop').modal('hide');
				 }else{
					 alert("数据保存失败");
				 }
				 
			  }
			  })
		
	}
</script>