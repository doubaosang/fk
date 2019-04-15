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
<link rel="stylesheet" href="${request.contextPath}/components/font-awesome/css/font-awesome.css" />

<link rel="stylesheet" href="${request.contextPath}/components/bootstrap-duallistbox/dist/bootstrap-duallistbox.css" />
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

    <script src="${request.contextPath}/components/bootstrap-table/js/tableExport.min.js"></script>
<link rel="stylesheet" href="${request.contextPath}/components/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<link rel="stylesheet" href="${request.contextPath}/components/bootstrap3-editable/css/bootstrap-editable.css" type="text/css"></link>


<link rel="stylesheet" href="${request.contextPath}/assets/css/common.css">

    <script src="${request.contextPath}/components/vue/vue.js"></script>

    <!-- basic_styles end -->

</head>
<body class="no-skin">

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

var startDate = "";
var endDate = "";

  function getPage(pageTable, tableColumns, bootstrapTableVar, url) {

    pageTable.bootstrapTable(bootstrapTableVar);

    $.ajax({
      url: url,
      data: {
        "pageNumber": pageNumber,
        "pageSize": pageSize,
        "sortName": sortName,
        "sortOrder": sortOrder,
        "searchValue": searchText,
        "endDate":endDate,
        "startDate":startDate,
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

function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }

</script>
