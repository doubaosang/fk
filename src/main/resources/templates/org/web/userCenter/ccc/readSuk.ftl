<div class="widget-box transparent">
    <div class="widget-header widget-header-flat">
        <h4 class="widget-title lighter">
            <i class="ace-icon fa fa-star orange"></i>商品上架
        </h4>
        <div class="widget-toolbar">
            <a  href="#"><i class="ace-icon fa fa-refresh"></i></a>&nbsp;&nbsp;
            <a href="#" data-action="collapse"> <i class="ace-icon fa fa-chevron-up"></i> </a>
        </div>
    </div>
    <div class="widget-body" style="display: block;">
        <div class="widget-main padding-4">
            <table id="readLogPageTable" class="table table-bordered table-striped"></table>
        </div>
    </div>
</div>



<div class="modal fade" id="chkModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title"> 主管授权验证 </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateForm">
                    <input type="text" value="解决bootstrap与AJAX异步提交表单的冲突" hidden />
                    <input type="hidden" name="pid" hidden />
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 用户名 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input  type="text" name="username" id="username" class="width-100">
                                <input type="hidden" id="sellprime" name="sellprime">
                                <input type="hidden" id="skupid" name="skupid">
							</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-xs-12 col-sm-2 control-label no-padding-right"> 密码 </label>
                        <div class="col-xs-12 col-sm-8">
							<span class="block input-icon input-icon-right">
								<input  type="password" name="password11" id="password11" class="width-100">
							</span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <#--<button type="button" class="btn btn-default" data-dismiss="modal"> 关 闭</button>-->
                <button type="button" class="btn btn-primary" id="btnSubmitUpdate111"> 验 证</button>
            </div>

        </div>
    </div>
</div>


<script >

$(function() {
    function getPageReadLog() {
         var pageTable = $('#readLogPageTable');
         var tableColumns = [ /* jsPageTableColumnsRiskItem */
             {
                 field : 'COM_NAME',
                 title : '商品名称',
             },
             {
                 field : 'CREATE_USER_NAME',
                 title : '入库用户',
             },
             {
                 field : 'PRIME',
                 title : '进货价格',
             },
             {
                 field : 'SELL_PRIME',
                 title : '出售价格',
                 editable: {
                     type: 'text',
                     title: '售价',
                     validate: function (v) {
                         if (isNaN(v)) {
                             return '售价必须是数字'
                         } else if (v <= 0) {
                             return '售价必须是正整数';
                         } else {
                             var pid = $(this).closest('tr').attr('data-uniqueId');
                             aaa(v, pid);
                         }

                     }
                 }
             },
             {
                 field : 'COLOR',
                 title : '颜色',
             },
             {
                 field : 'SECREEN',
                 title : '屏幕尺寸',
             },
             {
                 field : 'CPU',
                 title : 'CPU',
             },
             {
                 field : 'STOCK',
                 title : '库存',
                 editable: {
                     type: 'text',
                     title: '库存',
                     validate: function (v) {
                         if (isNaN(v)) {
                             return '库存必须是数字'
                         } else if (v < 0) {
                             return '库存必须是正整数';
                         } else {
                             var pid = $(this).closest('tr').attr('data-uniqueId');
                             ccc(pid, v);
                         }

                     }
                 }
             },
             {
                 field : 'PID',
                 title : '操 作',
                 formatter : function(value, row, index) {
                     var a = ' <a id="111" style="cursor:hand" > 查 看 </a><!-- &nbsp; &nbsp; <a id="222" style="cursor:hand" > 修 改 </a> &nbsp; &nbsp; --><!--<a class="deleteRow" style="cursor:hand" > 删 除 </a>--><!-- &nbsp;&nbsp; <a class="noticeLog" style="cursor:hand" > 查看读取日志 </a>-->  ';
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
                 getPageReadLog();
             },
             onSort : function(name, order) {
                 sortName = name;
                 sortOrder = order;
                 getPageReadLog();
             },
             onSearch : function(text) {
                 searchText = text;
                 getPageReadLog();
             }
         };
         var url = 'readSkuPage.json?pid=${RequestParameters.pid}';
         getPage(pageTable, tableColumns, bootstrapTableVar, url);
    }
    getPageReadLog();
    $(document).on(
        'click',
        '#111',
        function() {
            var trId = $(this).closest('tr').attr('data-uniqueid');
            $.ajax({
                url: "looksku.json?M=" + Math.random(),
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
    function aaa (sellprime, pid){
        var pid = pid;
        $("#sellprime").attr("value", sellprime);
        $("#skupid").attr("value", pid);
        $.ajax({
            url: "chkPrime.json?M=" + Math.random(),
            data: {
                "pid" : pid,
                "sellprime" : sellprime
            },
            dataType: "text",
            type : "post",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
                if (data == 'no'){

                    if (confirm("售价小于进货价格需要主管授权")) {
                        bbb();
                    } else {
                        getPageReadLog();
                    }

                } else {
                    alert("修改成功");
                }
            },
            error: function(data, status, e) {
                alert(JSON.stringify(data));
            }
        });
    };
    function bbb(){
        $('#chkModal').modal('show');
    };
    function ccc(pid, v) {
        var skupid = pid;
        var stock = v;
        $.ajax({
            url: "chkstock.json",
            data: {
                "pid": skupid,
                "stock": stock
            },
            dataType: "text",
            type : "post",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function(data) {
                if (data == "no") {
                    alert("修改失败！！！库存数不能大于进货数量！！！");
                    getPageReadLog();
                } else {
                    alert("修改成功！！！");
                    getPageReadLog();
                }
            },
            error: function(data, status, e) {
                alert(JSON.stringify(data));
            }
        });
    };
    $(document).on(
        'click',
        '#btnSubmitUpdate111',
        function() {
            var username = $("#username").val();
            var password = $("#password11").val();
            var sellprime = $("#sellprime").val();
            var pid = $("#skupid").val();
            $.ajax({
                url: "chklogin.json",
                data: {
                    "username": username,
                    "password": password,
                    "sellprime": sellprime,
                    "pid": pid
                },
                dataType: "text",
                type : "post",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function(data) {
                    if (data == "no") {
                        alert("授权失败！！！");
                        getPageReadLog();
                        $('#chkModal').modal('hide');
                    } else {
                        alert("授权成功！！！");
                        getPageReadLog();
                        $('#chkModal').modal('hide');
                    }
                },
                error: function(data, status, e) {
                    alert(JSON.stringify(data));
                }
            });
        }
    );
});

 </script>
