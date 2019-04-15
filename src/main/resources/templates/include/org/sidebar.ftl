[#ftl]
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
    <!-- #section:basics/sidebar -->
    <div id="sidebar" class="sidebar responsive ace-save-state">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>
        <ul class="nav nav-list">
        [#--<li class="active">
            <a href="#" data-url="">
                <i class="menu-icon fa fa-desktop"></i>
                <span class="menu-text"> 控制台 </span>
            </a>
            <b class="arrow"></b>
            <li class="">
                <a href="#" data-url="" class="dropdown-toggle">
                    <i class="menu-icon fa fa-leaf"></i>
                    <span class="menu-text"> 风险点管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/riskPointPage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 风险点管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/distinctionPage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 安全风险辨识表 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/managerPage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 安全风险管控清单 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/largePage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 较大风险因素管控方案 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/excludePage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 事故隐患排查清单 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/controlPage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 事故隐患治理方案 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/dangerFormPage/page.htm" data-url="../../wareHouse/list">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 紧急上报管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                </ul>
            </li>--]

            [#--<li class="">
                <a href="#" data-url="" class="dropdown-toggle">
                    <i class="menu-icon fa fa-leaf"></i>
                    <span class="menu-text"> 风险点巡检 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/riskPointFormPage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 风险点巡检记录 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/riskPoint/excludePage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 隐患排查清单 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>--]
            <li class="">
                <a href="#" data-url="" class="dropdown-toggle">
                    <i class="menu-icon fa fa-leaf"></i>
                    <span class="menu-text"> 通知公告管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/notice/noticePage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 通知公告管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    [#--<li class="">
                        <a href="${request.contextPath}/org/web/userCenter/notice/noticePage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 公告管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>--]
                </ul>
            </li>

            [#--<li class="">
                <a href="#" data-url="" class="dropdown-toggle">
                    <i class="menu-icon fa fa-leaf"></i>
                    <span class="menu-text"> 操作规程管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/workBook/workBookPage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 操作规程管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/workBook/bookFolderPage/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 规程文件夹管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                </ul>
            </li>--]

            <li class="">
                <a href="#" data-url="" class="dropdown-toggle">
                    <i class="menu-icon fa fa-leaf"></i>
                    <span class="menu-text"> 商品 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/aaa/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 类别管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/bbb/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 品牌管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/ccc/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 商品管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                </ul>
            </li>

            <li class="">
                <a href="#" data-url="" class="dropdown-toggle">
                    <i class="menu-icon fa fa-cog"></i>
                    <span class="menu-text"> 系统设置 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/userInfo/org/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 用户管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    [#--<li class="">
                        <a href="${request.contextPath}/org/web/userCenter/userInfo/manager/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 监督人员管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${request.contextPath}/org/web/userCenter/userInfo/worker/page.htm" data-url="">
                            <i class="menu-icon fa fa-caret-right"></i>
                            <span> 巡检人员管理 </span>
                        </a>
                        <b class="arrow"></b>
                    </li>--]

                </ul>
            </li>
            
        </ul>
        <!-- /.nav-list -->

        <!-- #section:basics/sidebar.layout.minimize -->
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
               data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>

        <!-- /section:basics/sidebar.layout.minimize -->
    </div>