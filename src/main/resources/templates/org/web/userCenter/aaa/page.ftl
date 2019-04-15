<#include "/include/org/head.ftl" >
<#include "/include/org/navbar.ftl" >

<div class="main-container" id="main-container">

<#include "/include/org/sidebar.ftl" >
	<div class="main-content">
		<div class="widget-box transparent" id="recent-box">
			<div class="widget-header">
				<div class="widget-toolbar no-border pull-left">
					<ul class="nav nav-tabs" id="recent-tab">

						<li class="active"><a data-toggle="tab" href="#tabPaneSort" aria-expanded="true"> <i class="ace-icon fa fa-home home-icon"></i> <span> 商品类别管理 </span> </a></li>

					</ul>
				</div>
			</div>
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="widget-body">
						<div class="widget-main padding-4">
							<div class="tab-content padding-8">
								<div id="tabPaneSort" class="tab-pane active">

									<div class="widget-box transparent">
										<div class="widget-header widget-header-flat">
											<h4 class="widget-title lighter">
												<i class="ace-icon fa fa-star orange"></i>商品类别列表
											</h4>
											<div class="widget-toolbar">
												<a  href="#"><i class="ace-icon fa fa-refresh"></i></a>&nbsp;&nbsp;
												<a href="#" data-action="collapse"> <i class="ace-icon fa fa-chevron-up"></i> </a>
											</div>
										</div>

										<div class="widget-body" style="display: block;">
											<div class="widget-main padding-4">

												<p class="pull_right text-right">
													<button id="showSaveModal" class="btn btn-white btn-info btn-bold">
													<i class="ace-icon fa fa-pencil-square-o bigger-120 blue"></i> 新 增 类 别
													</button>
												</p>

												<#--<div> 时间范围: <input type="date" id="startDate" placeholder="请输入开始时间" min="2019-01-01" max="${.now?string["yyyy-MM-dd"]}" value="2019-01-01" > - <input type="date" id="endDate" placeholder="请输入结束时间" min="2019-01-01" value="${.now?string["yyyy-MM-dd"]}" max="${.now?string["yyyy-MM-dd"]}">
													<button id="pageTableSearch" class="btn btn-white btn-info btn-bold">
														<i class="ace-icon fa fa-pencil-square-o bigger-120 blue"></i> 查 询
													</button>
												</div>-->

												<table id="pageTable" class="table table-bordered table-striped"></table>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
</div>


<!--新增商品类别-->
<div class="modal fade" id="saveModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" id="xxx" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
                <h4 class="modal-title"> 新增商品类别 </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="saveForm">
                    <input type="text" value="解决bootstrap与AJAX异步提交表单的冲突" hidden />
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 类别名称 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input  type="text" id="sortName" name="sortName" class="width-100">
							</span>
                        </div>
                    </div>
					<div class="form-group">
						<label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 下级类别 </label>
						<div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input  type="radio" name="isTop" id="isTopy" value="0" checked="checked"/>否
								<input  type="radio" name="isTop" id="isTopn" value="1" />是
							</span>
						</div>
					</div>
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 所属分类 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<#--<textarea  name="content" class="width-100"></textarea>-->
								<select name="topPid" id="topPid" disabled="disabled">

								</select>
							</span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="closeSave"> 关 闭</button>
                <button type="button" class="btn btn-primary" id="btnSubmitSave"> 保 存</button>
            </div>

        </div>
    </div>
</div>
<!--新增商品类别-->


<#include "/include/org/foot.ftl" >

<script >
	startDate = $('#startDate').val();
	endDate = $('#endDate').val();
	$(function() {
		function getPageSort() {
 			var pageTable = $('#tabPaneSort').find('#pageTable');
			var tableColumns = [
				{
					field : "SORT_NAME",
					title : "类别名称",
					sortable : true,
					searchable : true
				},
				{
					field : 'TOP_NAME',
					title : '上级类别'
				},
				{
					field : 'CREATE_TIME_STR',
					title : '创建时间',
					sortable : true
				},
				{
					field : 'LAST_UP_TIME_STR',
					title : '最后修改时间',
					sortable : true
				},
				{
					field : 'PID',
					title : '操 作',
					formatter : function(value, row, index) {
						/*var a = ' <a class="insertDetailTab" style="cursor:hand" > 查 看 </a> &nbsp; &nbsp; <a class="showUpdateModal" style="cursor:hand" > 修 改 </a> &nbsp; &nbsp; <a class="deleteRow" style="cursor:hand" > 删 除 </a> &nbsp;&nbsp; <a class="noticeLog" style="cursor:hand" > 查看读取日志 </a>  ';*/
						var a = ' <a class="deleteRow" style="cursor:hand" > 删 除 </a>  ';
						return a;
					}
				} ];
			var bootstrapTableVar = {
 				idField : 'PID',
 				uniqueId : 'PID',
 				striped : false,
 				cache : false,
 				pagination : true,
 				showExport : false,
 				exportDataType : 'selected',
 				search : true,
 				searchOnEnterKey : true,
 				clickToSelect : true,
 				pageSize : 20,
 				pageNumber : 1,
 				pageList : tablePageList,
 				showColumns : true,
 				showToggle : true,
 				sidePagination : 'server',
 				columns : tableColumns,
 				onPageChange : function(number, size) {
 					pageNumber = number;
 					pageSize = size;
					getPageSort();
 				},
 				onSort : function(name, order) {
 					sortName = name;
 					sortOrder = order;
					getPageSort();
 				},
 				onSearch : function(text) {
 					searchText = text;
					getPageSort();
 				},
 				onReorderRowsDrag : function(table, row) {
 					if (isSort) {
 						return;
 					}
 					$(table).find('td').css('background-color', '');
 					$(row).find('td').css('background-color', 'yellow');
 				},
 				onReorderRowsDrop : function(table, row) {
 					if (isSort) {
 						return;
 					}
 					var thisId = $(row).attr('data-uniqueid');
 					var prevId = $(row).prev().attr('data-uniqueid');
 					var nextId = $(row).next().attr('data-uniqueid');
 					$.ajax({
						url : 'sortOrder.json?M=' + Math.random(),
						data : {
							'pid' : thisId,
							'prevId' : prevId,
							'nextId' : nextId
						},
						dataType : 'json',
						type : 'post',
						contentType : 'application/x-www-form-urlencoded; charset=utf-8',
						success : function(data) {
						},
						error : function(data, status, e) {
							alert('getPageSort error');
						}
					});
 					$(table).find('td').css('background-color', '');
 					$(row).find('td').css('background-color', 'ddebf4');
 				}
 			};
 			var url = 'page.json';
			getPage(pageTable, tableColumns, bootstrapTableVar, url);
		}
		getPageSort();

		$("#closeSave").click(function(){
			getPageSort();
			$('#saveForm')[0].reset();
			$("#topPid").empty();
			$("#topPid").append("<option>--请选择--</option>");
			$('#topPid').attr("disabled",true);
		});

		$("#xxx").click(function(){
			getPageSort();
			$('#saveForm')[0].reset();
			$("#topPid").empty();
			$("#topPid").append("<option>--请选择--</option>");
			$('#topPid').attr("disabled",true);
		});

		$('#isTopy').click(function () {
			$('#topPid').attr("disabled",true);
		});

		$('#isTopn').click(function () {
			$('#topPid').attr("disabled",false);
			$.ajax({
				url: "querytopsort.json?M=" + Math.random(),
				dataType: "text",
				type : "post",
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				success: function(data) {
					var map = eval("(" + data + ")");
					$.each(map, function(idx, obj) {
						$("#topPid").append("<option value='"+obj.PID+"'>"+obj.SORT_NAME+"</option>")
					});
				},
				error: function(data, status, e) {
					alert(JSON.stringify(data));
				}
			});
		});

		$("#showSaveModal").click(function(){
			$('#saveModal').modal('show');
			$("#btnSubmitSave").attr("disabled",true);
			$("#topPid").empty();
			$("#topPid").append("<option>--请选择--</option>");
		});

		$(document).on(
				'blur',
				'#sortName',
				function () {
					var sortname = $("#sortName").val();
					if (sortname == "" || sortname.length < 2) {
						alert("请输入正确的类别名称");
						return;
					};
					$("#btnSubmitSave").attr("disabled",false);
				}
		);

		$(document).on(
				'click',
				'#btnSubmitSave',
				function() {
					$.ajax({
          				url: "save.json?M=" + Math.random(),
          				data:  $('#saveForm').serialize(),
          				dataType: "text",
          				type : "post",
          				contentType: "application/x-www-form-urlencoded; charset=utf-8",
          				success: function(data) {
							var map = eval("(" + data + ")");
							if (map.success == false) {
								alert(map.errorInfo);
								return;
							}
							getPageSort();
							alert("信息新增完成");
							$("#topPid").empty();
							$('#topPid').attr("disabled",true);
							$('#saveModal').modal('hide');
							$('#saveForm')[0].reset();
						},
          				error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);

		$(document).on(
				'click',
				'.deleteRow',
				function() {
					var trId = $(this).closest('tr').attr('data-uniqueid');
					$.ajax({
						url: "chkistop.json?M=" + Math.random(),
						data:  {
							"pid" : trId
						},
						dataType: "text",
						async : false,
						type : "post",
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							if (data == 'yes') {
								if (!confirm("您确定删除此条数据吗?下级类别将会一起删除!!!")) {
									return;
								}
								//var trId = $(this).closest('tr').attr('data-uniqueid');
								$.ajax({
									url: "delete.json?M=" + Math.random(),
									data:  {
										"pid" : trId,
										"top" : "yes"
									},
									dataType: "text",
									async : false,
									type : "post",
									contentType: "application/x-www-form-urlencoded; charset=utf-8",
									success: function(data) {
										alert("信息已删除");
										getPageSort();
									},
									error: function(data, status, e) {
										alert(JSON.stringify(data));
									}
								});
							} else {
								if (!confirm("您确定删除此条数据吗?")) {
									return;
								}
								//var trId = $(this).closest('tr').attr('data-uniqueid');
								$.ajax({
									url: "delete.json?M=" + Math.random(),
									data:  {
										"pid" : trId,
										"top" : "no"
									},
									dataType: "text",
									async : false,
									type : "post",
									contentType: "application/x-www-form-urlencoded; charset=utf-8",
									success: function(data) {
										alert("信息已删除");
										getPageSort();
									},
									error: function(data, status, e) {
										alert(JSON.stringify(data));
									}
								});
							}
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);
		// 检索查询
		/*$('#pageTableSearch').click(function () {
			startDate = $('#startDate').val();
			endDate = $('#endDate').val();
			console.log(startDate);
			console.log(endDate);
			getPageSort();
		});*/
		/*$(document).on(
				'click',
				'.noticeLog',
				function() {
					var trId = $(this).closest('tr').attr('data-uniqueid');
					insertTab("readLogTab", "添加商品", "readLog.htm?pid=" + trId);
				}
		);*/
		/*$(document).on(
				'click',
				'.insertDetailTab',
				function() {
					$('#lookModal').modal('show');
					var trId = $(this).closest('tr').attr('data-uniqueid');
					$.ajax({
						url: "detail.json?M=" + Math.random(),
						data: {
							"pid" : trId
						},
						dataType: "text",
						type : "post",
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							var map = eval("(" + data + ")");
							$("#updateForm [name='pid']").val(map.PID);
							$("#updateForm [name='title']").val(map.TITLE);
							$("#updateForm [name='content']").val(map.CONTENT);
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);*/
		/*$(document).on(
				'click',
				'.showUpdateModal',
				function() {
					$('#updateModal').modal('show');
					var trId = $(this).closest('tr').attr('data-uniqueid');
					$.ajax({
          				url: "detail.json?M=" + Math.random(),
          				data: {
							"pid" : trId
						},
						dataType: "text",
						type : "post",
          				contentType: "application/x-www-form-urlencoded; charset=utf-8",
          				success: function(data) {
							var map = eval("(" + data + ")");
             				$("#updateForm [name='pid']").val(map.PID);
							$("#updateForm [name='title']").val(map.TITLE);
							$("#updateForm [name='content']").val(map.CONTENT);
						},
          				error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);*/
		/*$(document).on(
				'click',
				'#btnSubmitUpdate',
				function() {
					$.ajax({
						url: "update.json?M=" + Math.random(),
						data:  $('#updateForm').serialize(),
						dataType: "text",
						type : "post",
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							var map = eval("(" + data + ")");
							if (map.success == false) {
								alert(map.errorInfo);
								return;
							}
							getPageNotice();
							alert("信息修改完成");
							$('#updateModal').modal('hide');
							$('#updateForm')[0].reset();
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);*/

	});

 </script>
