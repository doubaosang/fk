
                                <div class="widget-box transparent">
                                    <div class="widget-header widget-header-flat">
                                        <h4 class="widget-title lighter">
                                            <i class="ace-icon fa fa-star orange"></i>信息读取日志
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

<script >

$(function() {
    function getPageReadLog() {
         var pageTable = $('#readLogPageTable');
         var tableColumns = [ /* jsPageTableColumnsRiskItem */
             {
                 field : 'USER_TYPE',
                 title : '用户名 ',
                 sortable : true
             },
             {
                 field : 'CREATE_TIME_STR',
                 title : '读取时间',
                 sortable : true
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
         var url = 'readLogPage.json?pid=${RequestParameters.pid}';
         getPage(pageTable, tableColumns, bootstrapTableVar, url);
         sortName = "";
         sortOrder = "asc";
    }
    getPageReadLog();
});

 </script>
