<#include "/include/org/head.ftl" >
<#include "/include/org/navbar.ftl" >

<div class="main-container" id="main-container">
	<#include "/include/org/sidebar.ftl" >
	<div class="main-content">
		<div class="widget-box transparent" id="recent-box">
			<div class="widget-header">
				<div class="widget-toolbar no-border pull-left">
					<ul class="nav nav-tabs" id="recent-tab">
						<li class="active">
							<a data-toggle="tab" href="#tabPaneManager" aria-expanded="true">
								<i class="ace-icon fa fa-home home-icon"></i>
								<span> WEB人员 </span>
							</a>
						</li>
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
								<div id="tabPaneManager" class="tab-pane active">
									<div class="widget-box transparent">
										<div class="widget-header widget-header-flat">
											<h4 class="widget-title lighter">
												<i class="ace-icon fa fa-star orange"></i>WEB人员管理
											</h4>
											<div class="widget-toolbar">
												<a href="#">
													<i class="ace-icon fa fa-refresh"></i>
												</a>
												&nbsp;&nbsp;
												<a href="#" data-action="collapse">
													<i class="ace-icon fa fa-chevron-up"></i>
												</a>
											</div>
										</div>
										<div class="widget-body" style="display: block;">
											<div class="widget-main padding-4">
												<p class="pull_right text-right">
													<button id="showSaveModal" class="btn btn-white btn-info btn-bold">
													<i class="ace-icon fa fa-pencil-square-o bigger-120 blue"></i> 新 增
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

<!--查看-->
<div class="modal fade" id="lookModal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title"> 查看 </h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="lookForm">
					<input type="text" value="解决bootstrap与AJAX异步提交表单的冲突" hidden />
					<div class="form-group">
						<label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 头像 </label>
						<div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<img width="150px" height="150px" id="lookimg" name="lookimg">
							</span>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" id="closeLook"> 关 闭</button>
			</div>
		</div>
	</div>
</div>
<!--查看-->

<!--新增WEB人员-->
<div class="modal fade" id="saveModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
				<button type="button" class="close" id="xxx" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
                <h4 class="modal-title"> 新增WEB人员 </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="saveForm">
                    <input type="text" value="解决bootstrap与AJAX异步提交表单的冲突" hidden />
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 用户名 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input  type="text" name="username" id="usernameaaa" class="width-100">
								<span id="zhengzeloginname" style="display:none;"></span>
							</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 初始密码 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right" style="color: red; font-size: 16px;">
								123
							</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 姓名 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input  type="text" name="trueName" id="trueName" class="width-100">
							</span>
                        </div>
                    </div>
					<div class="form-group">
						<label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 头像 </label>
						<div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input type="file" name="file" id="file">
								<br/>
								<img width="50px" height="50px" style="display:none;" id="img1" name="img1">
								<input type="hidden" id="pic" name="pic" />
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
<!--新增WEB人员-->


<!--修改WEB人员-->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"> 修改WEB人员 </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateForm">
                    <input type="text" value="解决bootstrap与AJAX异步提交表单的冲突" hidden />
                    <input type="hidden" id="pid" name="pid" hidden />
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 用户名 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input type="text" id="userName" name="username" class="width-100">
							</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 姓名 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input type="text" id="TrueName" name="trueName" class="width-100">
							</span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"> 关 闭</button>
                <button type="button" class="btn btn-primary" id="btnSubmitUpdate"> 保 存</button>
            </div>

        </div>
    </div>
</div>
<!--修改WEB人员-->

<#include "/include/org/foot.ftl" >

<script >

	startDate = $('#startDate').val();
	endDate = $('#endDate').val();

	$(function() {
		function getPageManager() {
 			var pageTable = $('#tabPaneManager').find('#pageTable');
			var tableColumns = [
				{
					field : "USERNAME",
					title : "用户名",
					sortable : true,
					searchable : true
				}, /* jsPageTableColumnsManager */
				{
					field : "TRUE_NAME",
					title : "姓名",
					sortable : true,
					searchable : true
				}, /* jsPageTableColumnsManager */
				{
					field : 'CREATE_USER_NAME',
					title : '创建用户'
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
						var a = ' <a class="insertDetailTab" style="cursor:hand" > 查 看 </a> &nbsp; &nbsp; <a class="showUpdateModal" style="cursor:hand" > 修 改 </a> &nbsp; &nbsp; <a class="deleteRow" style="cursor:hand" > 删 除 </a> ';
						return a;
					}
				}
			];
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
 					getPageManager();
 				},
 				onSort : function(name, order) {
 					sortName = name;
 					sortOrder = order;
					getPageManager();
 				},
 				onSearch : function(text) {
 					searchText = text;
					getPageManager();
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
							alert('getPageManager error');
						}
					});
 					$(table).find('td').css('background-color', '');
 					$(row).find('td').css('background-color', 'ddebf4');
 				}
 			};
 			var url = 'page.json';
			getPage(pageTable, tableColumns, bootstrapTableVar, url);
		}
		getPageManager();

		$("#showSaveModal").click(function(){
			$("#btnSubmitSave").attr("disabled",true);
			$('#saveModal').modal('show');
		});

		$("#xxx").click(function(){
			getPageManager();
			$("#zhengzeloginname").attr("style", "display:none;");
			$('#img1').attr("style", "display:none;");
			$('#saveForm')[0].reset();
		});

		$("#closeSave").click(function(){
			getPageManager();
			$("#zhengzeloginname").attr("style", "display:none;");
			$('#img1').attr("style", "display:none;");
			$('#saveForm')[0].reset();
		});

		$(document).on(
				'blur',
				'#usernameaaa',
				function () {
					$.ajax({
						url: "chkusername.json?M=" + Math.random(),
						data: "username=" + $('#usernameaaa').val(),
						dataType: "text",
						type: "post",
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							if(data == 'true'){
								$("#zhengzeloginname").removeAttr("style");
								$("#zhengzeloginname").html("用户名可用");
								$("#zhengzeloginname").css("color","green");
								$("#btnSubmitSave").attr("disabled",false);
							} else if (data == 'no') {
								$("#zhengzeloginname").removeAttr("style");
								$("#zhengzeloginname").html("请输入用户名");
								$("#zhengzeloginname").css("color","red");
								$("#btnSubmitSave").attr("disabled",true);
							} else {
								$("#zhengzeloginname").removeAttr("style");
								$("#zhengzeloginname").html("用户名已存在");
								$("#zhengzeloginname").css("color","red");
								$("#btnSubmitSave").attr("disabled",true);
							}
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);

		$(document).on(
				'change',
				'#file',
				function () {
					var formData = new FormData();
					formData.append('file', $('#file')[0].files[0]);
					$.ajax({
						url: "uploda.json?M=" + Math.random(),
						data: formData,
						dataType: "text",
						type: "post",
						contentType:false,//ajax上传图片需要添加
						processData:false,//ajax上传图片需要添加
						success: function(data) {
							$("#img1").removeAttr("style");
							$("#img1").attr("src", "../../../../../upload/" +data);
							$("#pic").val(data);
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);

		$(document).on(
				'click',
				'#btnSubmitSave',
				function() {
					var truename = $("#trueName").val();
					if (truename == "" || truename.length < 2) {
						alert("请输入正确的姓名");
						return;
					};
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
							getPageManager();
							alert("信息新增完成");
							$("#zhengzeloginname").attr("style", "display:none;");
							$('#img1').attr("style", "display:none;");
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
					if (!confirm("您确定删除此条数据吗?")) {
						return;
					}
					var trId = $(this).closest('tr').attr('data-uniqueid');
					$.ajax({
						url: "delete.json?M=" + Math.random(),
						data:  {
							"pid" : trId
						},
						dataType: "text",
						type : "post",
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							alert("信息已删除");
							getPageManager();
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);

		$(document).on(
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
							$("#pid").val(map.PID);
							$("#userName").val(map.USERNAME);
							$("#TrueName").val(map.TRUE_NAME);
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);

		$(document).on(
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
							getPageManager();
							alert("信息修改完成");
							$('#updateModal').modal('hide');
							$('#updateForm')[0].reset();
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);

		$(document).on(
				'click',
				'.insertDetailTab',
				function() {
					var trId = $(this).closest('tr').attr('data-uniqueid');
					$.ajax({
						url: "look.json?M=" + Math.random(),
						data: {
							"pid" : trId
						},
						dataType: "text",
						type : "post",
						contentType: "application/x-www-form-urlencoded; charset=utf-8",
						success: function(data) {
							$('#lookModal').modal('show');
							$("#lookimg").attr("src", "../../../../../upload/" +data);
						},
						error: function(data, status, e) {
							alert(JSON.stringify(data));
						}
					});
				}
		);

		/*$(document).on(
				'click',
				'.managerLog',
				function() {
					var trId = $(this).closest('tr').attr('data-uniqueid');
					insertTab("readLogTab", "读取日志", "readLog.htm?pid=" + trId);
				}
		);*/

		// 检索查询
		/*$('#pageTableSearch').click(function () {
			startDate = $('#startDate').val();
			endDate = $('#endDate').val();
			console.log(startDate);
			console.log(endDate);
			getPageManager();
		});*/

	});

 </script>
