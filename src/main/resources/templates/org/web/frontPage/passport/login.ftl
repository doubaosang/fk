<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>生产安全管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${request.contextPath}/assets/css/bootstrap.css" />
    <link rel="stylesheet" href="${request.contextPath}/components/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css" />
    <link rel="stylesheet" href="${request.contextPath}/components/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="${request.contextPath}/components/bootstrap-table/css/bootstrap-table.min.css" />
    <link rel="stylesheet" href="${request.contextPath}/components/font-awesome/css/font-awesome.css" /><link rel="stylesheet" href="${request.contextPath}/components/bootstrap-duallistbox/dist/bootstrap-duallistbox.css" />
    <link rel="stylesheet" href="${request.contextPath}/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css" />
    <link rel="stylesheet" href="${request.contextPath}/components/select2/dist/css/select2.css" />
    <!-- page specific plugin styles -->
    <!-- text fonts -->
    <link rel="stylesheet" href="${request.contextPath}/assets/css/ace-fonts.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="${request.contextPath}/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${request.contextPath}/assets/css/ace-part2.css" class="ace-main-stylesheet"/>
    <![endif]-->
    <link rel="stylesheet" href="${request.contextPath}/assets/css/ace-skins.css" />
    <link rel="stylesheet" href="${request.contextPath}/assets/css/ace-rtl.css" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${request.contextPath}/assets/css/ace-ie.css"/>
    <![endif]-->
    <!-- inline styles related to this page -->
    <!-- ace settings handler -->
    <script src="${request.contextPath}/assets/js/ace-extra.js"></script>
    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
    <!--[if lte IE 8]>
    <script src="${request.contextPath}/components/html5shiv/dist/html5shiv.min.js"></script>
    <script src="${request.contextPath}/components/respond/dest/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="${request.contextPath}/components/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
    <link rel="stylesheet" href="${request.contextPath}/components/bootstrap3-editable/css/bootstrap-editable.css" type="text/css"></link>
    <link rel="stylesheet" href="${request.contextPath}/assets/css/common.css">
    <script src="${request.contextPath}/components/vue/vue.js"></script>
    <!-- basic_styles end -->

    <script type = "text/javascript" >
        if (typeof jQuery == "undefined") {
            // document.write("<div style='width:100%;height:50px;line-heigth:50px;color:yellow;background-color:black' id='warningExplorerDiv'><center><br>系统检测发现您正在使用低版本浏览器,本系统的一些主要功能可能无法运行,强烈推荐你不要使用此浏览器,而使用搜狗浏览器/360浏览器等浏览器访问本系统,并使用高速/极速模式<br></center></div>");
        }
        function randomUUID() {
            var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		    var maxPos = chars.length;
		    var uuid = "";
		    for(var i = 0; i < 64 ; i++) {
			    uuid += chars.charAt(Math.floor(Math.random()*maxPos));
		    }
		    return uuid;
        }
        var pageNumber = 1;
        var tablePageList = [10, 20, 40, 100, 500, 1000, 10000];
        var pageSize = 20;
        var sortName = null;
        var sortOrder = null;
        var searchText = "";
        function getPage(pageTable, tableColumns, bootstrapTableVar, url) {
            pageTable.bootstrapTable(bootstrapTableVar);
            $.ajax({
                url: url,
                data: {
                    "pageNumber": pageNumber,
                    "pageSize": pageSize,
                    "sortName": sortName,
                    "sortOrder": sortOrder,
                    "searchValue": searchText
                },
                dataType: "json",
                type : "post",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function(data) {
                    pageTable.bootstrapTable("load", data);

                },
                error: function(data, status, e) {
                    alert(e);
                }
            });
        }
    </script>

<body class="login-layout blur-login">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="ace-icon fa fa-leaf green"></i>
                            <span class="white" id="id-text2">生产安全管理系统</span>
                        </h1>
                        <h4 class="blue" id="id-company-text">&copy; Company </h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="ace-icon fa fa-coffee green"></i> 请输入登录信息
                                    </h4>

                                    <div class="space-6"></div>

                                    <form id="loginForm" action="/admin/login" method="post">
                                        <input type="text" value="解决bootstrap与AJAX异步提交表单的冲突" hidden />
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input  type="text" id="username" name="username"
                                                           class="form-control" placeholder="用户名" value=""/>
                                                    <i class="ace-icon fa fa-user"></i>
                                                </span>
                                            </label>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input  type="password" id="password" name="password"
                                                             class="form-control" placeholder="密 码"
                                                           value=""/>
                                                    <i class="ace-icon fa fa-lock"></i>
                                                </span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">

                                                <button id="loginButton" type="button"
                                                        class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="ace-icon fa fa-key"></i>
                                                    <span class="bigger-110"> 登 录 </span>
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                </div>
                                <!-- /.widget-main -->
                            </div>
                            <!-- /.widget-body -->
                        </div>
                        <!-- /.login-box -->
                    </div>
                    <!-- /.position-relative -->
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.main-content -->
</div>
<!-- /.main-container -->

<!-- basic scripts -->

<#include "/include/org/foot.ftl" >

<script >
    $(function() {
        $("#loginButton").click(function() {
            var username = $("#username").val();
            var password = $("#password").val();
            if (username == "" || username.length < 2) {
                alert("请输入正确的用户名");
                return;
            }
            if (password == "" || password.length < 2) {
                alert("请输入正确的密码");
                return;
            }
            $.ajax({
                url: "login.json",
                data: {
                    "username": username,
                    "password": password
                },
                dataType: "text",
                type : "post",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function(data) {
                    var map = eval("(" + data + ")");
                    if (data == "1"){
                        /*alert(map.errorInfo);*/
                        return;
                    }
                    /*if (typeof(map.userId) == "undefined") {
                        alert(map.errorInfo);
                        return;
                    }*/
                    window.location.href = "../../userCenter/index.htm";
                },
                error: function(data, status, e) {
                    alert(JSON.stringify(data));
                }
            });
        });
    });
</script>