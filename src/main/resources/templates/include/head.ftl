<#assign path=request.contextPath />
<html>
<head>
</head>
<body>
<script type="text/javascript" src="${path}/script/jquery/3.1.1/jquery-3.1.1.min.js" ></script>
<!-- 引入YDUI样式 -->
<link rel="stylesheet" href="${path}/script/ydui/build/css/ydui.css" />
<!-- 引入YDUI自适应解决方案类库 -->
<script src="${path}/script/ydui/build/js/ydui.flexible.js"></script>
<script src="${path}/script/ydui/build/js/ydui.js"></script>
<script>
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
    var closeTab = false;
    function deleteCloseSpan() {
        $(".closeSpan").remove();
    }
    function showModal(modalTitle, modalBody) {
        var modalId = randomUUID();
        return showModalHasPid(modalTitle, modalId, modalBody);
    }
    function showModalHasParentId(modalTitle, parentId, modalBody) {
        var modalId = randomUUID();
        return showModalHasPidAndParentId(modalTitle, modalId, parentId, modalBody);
    }
    function showModalHasPid(modalTitle, pid, modalBody) {
        var modalStr = " <!-- 模态框（Modal） --> <div class='modal fade' id='modal" + pid + "' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'> <div class='modal-dialog'> <div class='modal-content'> <div class='modal-header' style='background-color:#008de5'> <button type='button' class='close' data-dismiss='modal' aria-hidden='true' style='color:#ffffff'>&times;</button> <h4 class='modal-title' id='myModalLabel' style='color:#ffffff'> " + modalTitle + " </h4> </div> <div class='modal-body'> <div id='modalBodyDiv'>" + modalBody + "</div> <div style='background-color: #0463cd; color: #FFFFFF; height: 28px; width: 180px;margin: 0px; line-height: 28px; font-size: 14px; font-family: Microsoft YaHei; border-radius: 3px; float: right; margin-right: 10px; cursor: hand' id='closeModal' data-dismiss='modal' aria-hidden='true' > <center> 关 闭 </center> </div> <br> </div> </div> <!-- /.modal-content --> </div></div><!-- /.modal --> ";
        if ($("#content").find("#modal" + pid).length > 0) {
            $("#content").find("#modal" + pid).modal("show");
            return "modal" + pid;
        }
        $("#content").append(modalStr);
        $("#content").find("#modal" + pid).modal("show");
        return "modal" + pid;
    }
    function showModalHasPidAndParentId(modalTitle, pid, parentId, modalBody) {
        var modalStr = " <!-- 模态框（Modal） --> <div class='modal fade' id='modal" + pid + "' parentId='" + parentId + "' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'> <div class='modal-dialog'> <div class='modal-content'> <div class='modal-header' style='background-color:#008de5'> <button type='button' class='close' data-dismiss='modal' aria-hidden='true' style='color:#ffffff'>&times;</button> <h4 class='modal-title' id='myModalLabel' style='color:#ffffff'> " + modalTitle + " </h4> </div> <div class='modal-body'> <div id='modalBodyDiv'>" + modalBody + "</div> <div style='background-color: #0463cd; color: #FFFFFF; height: 28px; width: 180px;margin: 0px; line-height: 28px; font-size: 14px; font-family: Microsoft YaHei; border-radius: 3px; float: right; margin-right: 10px; cursor: hand' id='closeModal' data-dismiss='modal' aria-hidden='true' > <center> 关 闭 </center> </div> <br> </div> </div> <!-- /.modal-content --> </div></div><!-- /.modal --> ";
        if ($("#content").find("#modal" + pid).length > 0) {
            $("#content").find("#modal" + pid).modal("show");
            return "modal" + pid;
        }
        $("#content").append(modalStr);
        $("#content").find("#modal" + pid).modal("show");
        return "modal" + pid;
    }
    function showModalSelect(urlStr, modal, select) {
        $.ajax({
            url: urlStr,
            data: {},
            dataType: "json",
            async: false,
            type : "post",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
                var list = eval("(" + data + ")");
                $.each(list,
                    function(key, val) {
                        var option = " <option value='" + val.PID + "'> " + val.PNAME + " </option> ";
                        modal.find("#" + select).append(option);
                    }
                );
            },
            error: function(data, status, e) {
                alert(urlStr + " error");
            }
        });
    }
    function getPage(pageTable, tableColumns, bootstrapTableVar, url) {
        var isSort = false;
        pageTable.bootstrapTable(bootstrapTableVar);
        $.ajax({
            url: url,
            data: {
                "pageNumber": pageNumber,
                "pageSize": pageSize,
                "sortName": sortName,
                "sortOrder": sortOrder,
                "searchValue": searchText,
            },
            dataType: "json",
            type : "post",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
                var pageInfo = data;
                pageTable.bootstrapTable("load", pageInfo);
            },
            error: function(data, status, e) {
                alert(e);
            }
        });
    }
</script>
