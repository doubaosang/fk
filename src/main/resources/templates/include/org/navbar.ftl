
<div id="navbar" class="navbar navbar-default ace-save-state">
	<div class="navbar-container ace-save-state" id="navbar-container">
		<!-- #section:basics/sidebar.mobile.toggle -->
		<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<!-- /section:basics/sidebar.mobile.toggle -->
		<div class="navbar-header pull-left">
			<!-- #section:basics/navbar.layout.brand -->
			<a href="#" class="navbar-brand"> <small> <i class="fa fa-leaf"></i> 生产安全管理系统 </small> </a>

			<!-- /section:basics/navbar.layout.brand -->

			<!-- #section:basics/navbar.toggle -->

			<!-- /section:basics/navbar.toggle -->
		</div>

		<!-- #section:basics/navbar.dropdown -->
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<#--<li class="grey dropdown-modal">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="ace-icon fa fa-tasks"></i> <span class="badge badge-grey">0</span> </a>

					<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header"><i class="ace-icon fa fa-check"></i> 0 Tasks to complete</li>

						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar">
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">Task Name</span> <span class="pull-right">65%</span>
										</div>

										<div class="progress progress-mini">
											<div style="width:65%" class="progress-bar"></div>
										</div>
									</a>
								</li>
							</ul>
						</li>

						<li class="dropdown-footer">
							<a href="#"> See tasks with details <i class="ace-icon fa fa-arrow-right"></i> </a>
						</li>
					</ul>
				</li>-->

				<#--<li class="purple dropdown-modal">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="ace-icon fa fa-bell icon-animated-bell"></i> <span class="badge badge-important">0</span> </a>

					<ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header"><i class="ace-icon fa fa-exclamation-triangle"></i> 0 Notifications</li>

						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar navbar-pink">
								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left"> <i class="btn btn-xs no-hover btn-pink fa fa-comment"></i> New Comments </span> <span class="pull-right badge badge-info">+12</span>
										</div>
									</a>
								</li>
							</ul>
						</li>

						<li class="dropdown-footer">
							<a href="#"> See all notifications <i class="ace-icon fa fa-arrow-right"></i> </a>
						</li>
					</ul>
				</li>-->

				<#--<li class="green dropdown-modal">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="ace-icon fa fa-envelope icon-animated-vertical"></i> <span class="badge badge-success">0</span> </a>

					<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header"><i class="ace-icon fa fa-envelope-o"></i> 0 Messages</li>

						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar">
								<li>
									<a href="#" class="clearfix"> <img src="${request.contextPath}/assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" /> <span class="msg-body"> <span class="msg-title"> <span class="blue">Alex:</span> Message Summary </span> <span class="msg-time"> <i class="ace-icon fa fa-clock-o"></i> <span>Message Time</span> </span> </span> </a></li>
							</ul>
						</li>

						<li class="dropdown-footer">
							<a href="inbox.html"> See all messages <i class="ace-icon fa fa-arrow-right"></i> </a>
						</li>
					</ul>
				</li>-->

				<!-- #section:basics/navbar.user_menu -->
				<li class="light-blue dropdown-modal">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="${request.contextPath}/assets/avatars/avatar2.png" alt="" />
						<span class="user-info" style="    max-width: 100px;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    text-align: left;
    vertical-align: top;
    line-height: 15px;
    position: relative;
    top: 6px;">
							<small>欢迎您</small> </span>
						<i class="ace-icon fa fa-caret-down"></i>
					</a>

					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">

						<li><a href="#" onclick="updatePass()"> <i class="ace-icon fa fa-user"></i> 修改密码 </a></li>

						<li><a href="${request.contextPath}/org/web/frontPage/passport/login.htm"> <i class="ace-icon fa fa-power-off"></i> 退 出 </a></li>
					</ul>
				</li>

				<!-- /section:basics/navbar.user_menu -->
			</ul>
		</div>

		<!-- /section:basics/navbar.dropdown -->
	</div>
	<!-- /.navbar-container -->
</div>

<div id="admin-update-pass-modal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"> 修改密码 </h4>
            </div>
            <div class="modal-body">
                <p>
                <form class="form-horizontal" id="admin-update-pass-form">
                <input type="text" value="解决bootstrap与AJAX异步提交表单的冲突" hidden />
                <#--<div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="username" autocomplete="off" value="" readonly id="username" placeholder="用户名">
                        </div>
                    </div>-->
					<div class="form-group">
						<label for="yPassword" class="col-sm-2 control-label">原密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" autocomplete="off" name="yPassword" id="yPassword" onblur="chkPwd()" placeholder="原密码">
							<span id="zhengzepwd"></span>
						</div>
					</div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">新密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" autocomplete="off" name="password" id="password" placeholder="新密码">
                        </div>
                    </div>
					<div class="form-group">
						<label for="vsPassword" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" autocomplete="off" name="vsPassword" id="vsPassword" placeholder="确认密码">
						</div>
					</div>
                </form>
				</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" onclick="close()" data-dismiss="modal"> 关 闭 </button>
                <button type="button" class="btn btn-primary" id="admin-update-newPass-btn" onclick="updatePassSubmit()"> 保 存 </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
	function chkPwd() {
		$.ajax({
			url: "${request.contextPath}/org/web/userCenter/userInfo/org/chkpwd.json?M=" + Math.random(),
			data: "yPassword=" + $('#yPassword').val(),
			dataType: "text",
			type: "post",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			success: function(data) {
				if(data == 'true'){
					$("#zhengzepwd").html("√");
					$("#zhengzepwd").css("color","green");
					$("#admin-update-newPass-btn").attr("disabled",false);
				} else if (data == 'no') {
					$("#zhengzepwd").html("请输入原密码");
					$("#zhengzepwd").css("color","red");
					$("#admin-update-newPass-btn").attr("disabled",true);
				} else {
					$("#zhengzepwd").html("原密码错误");
					$("#zhengzepwd").css("color","red");
					$("#admin-update-newPass-btn").attr("disabled",true);
				}
			},
			error: function(data, status, e) {
				alert(JSON.stringify(data));
			}
		});
	}
	function close() {
		location.reload();
	}

	function updatePass() {
		$('#admin-update-pass-modal').modal('show');
		$("#admin-update-newPass-btn").attr("disabled",true);
    }

    function updatePassSubmit() {
        //var yPassword = $('#admin-update-pass-form [name="yPassword"]').val();
        var newPass = $('#admin-update-pass-form [name="password"]').val();
        var vsPassword = $('#admin-update-pass-form [name="vsPassword"]').val();
        if(newPass==""){
            bootbox.alert("新密码不能为空！");
		}else if(vsPassword==""){
            bootbox.alert("确认密码不能为空！");
		}else if(newPass!=vsPassword){
            bootbox.alert("新密码与确认密码不一致！");
		}else {
            $.ajax({
                cache: false,
                type: "POST",
                url: '${request.contextPath}/org/web/userCenter/userInfo/org/upPass.json',
                data: "nPassword=" + newPass,
                async: false,
                success: function (data) {
                    if(data=="success"){
                    	alert("密码更新完成");
                        $('#admin-update-pass-modal').modal('hide');
						location.reload();
                    }else {
                        bootbox.alert(data);
                    }
                }
            });
		}
    }

    //关闭tabs选项卡
    function closeTabs(tabId){
        var $thisTabs = $("a[href='#"+tabId+"']").parent(); 	//删除tabs头

        var $tabs = $(document).find("#recent-tab");
        var $tabContents = $(document).find(".tab-content");
        $tabs.children().removeClass("active");
        $tabContents.children().removeClass("active");

        $thisTabs.prev().addClass("active");
        $("#"+tabId+"").prev().addClass("active");
        $thisTabs.remove();
        $("#"+tabId+"").remove();	//删除内容面板
    }

    function insertTab(tabId, tabName, url) {

                var $tabs = $(document).find("#recent-tab");
                var $tabContents = $(document).find(".tab-content");

                var count= $tabContents.find("#" + tabId).size();
                $tabs.children().removeClass("active");
                $tabContents.children().removeClass("active");

                if(count==0){
                    //动态tab头和tabContent内容面板
                    var tab = ' <li> <a data-toggle="tab" href="#' + tabId + '" aria-expanded="false"> <span> ' + tabName + ' </span> <i onclick=closeTabs(' + JSON.stringify(tabId) + ') class="ace-icon fa fa-times red close-btn"> </i> </a> </li> ';
                    $tabs.children().last().after(tab);
                    var tabContent = $('<div class="tab-pane" id="' + tabId + '"></div>').load(url);
                    $tabContents.children().last().after(tabContent);
                    //选中新tab页
                    $(document).find("#recent-tab").children().last().addClass("active");
                    $(document).find(".tab-content").children().last().addClass("active");
                }else{
                    closeTabs(tabId);
                    insertTab(tabId, tabName, url);
                }

    }


</script>