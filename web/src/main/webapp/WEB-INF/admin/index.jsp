<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>管理首页</title>
    <jsp:include page="../../common/charisma-head.jsp"/>
</head>

<body>
<!-- topbar starts -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse"
               data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="index"> <img alt="Charisma Logo" src="img/logo20.png"/> <span>Somiyar</span></a>

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-tint"></i><span class="hidden-phone"> 选择主题 / 皮肤</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="icon-blank"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="icon-blank"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="icon-blank"></i> Cyborg</a></li>
                    <li><a data-value="redy" href="#"><i class="icon-blank"></i> Redy</a></li>
                    <li><a data-value="journal" href="#"><i class="icon-blank"></i> Journal</a></li>
                    <li><a data-value="simplex" href="#"><i class="icon-blank"></i> Simplex</a></li>
                    <li><a data-value="slate" href="#"><i class="icon-blank"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="icon-blank"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="icon-blank"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"></i><span class="hidden-phone"> admin</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">用户资料</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html">退出</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <div class="top-nav nav-collapse">
                <ul class="nav">
                    <li><a href="#">浏览主页</a></li>
                    <li>
                        <form class="navbar-search pull-left">
                            <input placeholder="Search" class="search-query span2" name="query" type="text">
                        </form>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<!-- topbar ends -->
<div class="container-fluid">
<div class="row-fluid">

<!-- left menu starts -->
<div class="span2 main-menu-span">
    <div class="well nav-collapse sidebar-nav">
        <ul class="nav nav-tabs nav-stacked main-menu">
            <li class="nav-header hidden-tablet">功能菜单</li>
            <li><a class="ajax-link" href="index.jsp"><i class="icon-home"></i><span
                    class="hidden-tablet"> 仪表盘</span></a></li>
            <li><a class="ajax-link" href="ui.html"><i class="icon-user"></i><span class="hidden-tablet"> 用户管理</span></a>
            </li>
        </ul>
        <label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on
            menu</label>
    </div>
    <!--/.well -->
</div>
<!--/span-->
<!-- left menu ends -->

<noscript>
    <div class="alert alert-block span10">
        <h4 class="alert-heading">Warning!</h4>
        <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to
            use this site.</p>
    </div>
</noscript>

<div id="content" class="span10">
<!-- content starts -->


<div>
    <ul class="breadcrumb">
        <li>
            <a href="#">菜单</a> <span class="divider">/</span>
        </li>
        <li>
            <a href="#">仪表盘</a>
        </li>
    </ul>
</div>
<div class="sortable row-fluid">
    <a data-rel="tooltip" title="6个新用户." class="well span3 top-block" href="#">
        <span class="icon32 icon-red icon-user"></span>

        <div>会员人数</div>
        <div>507</div>
        <span class="notification">6</span>
    </a>



    <a data-rel="tooltip" title="最近一笔￥300的交易" class="well span3 top-block" href="#">
        <span class="icon32 icon-color icon-cart"></span>

        <div>购买金额</div>
        <div>$13320</div>
        <span class="notification yellow">￥300</span>
    </a>

    <a data-rel="tooltip" title="收到12条新信息" class="well span3 top-block" href="#">
        <span class="icon32 icon-color icon-envelope-closed"></span>

        <div>站内信息</div>
        <div>25</div>
        <span class="notification red">12</span>
    </a>
</div>



<div class="row-fluid sortable">


    <div class="box span4">
        <div class="box-header well" data-original-title>
            <h2><i class="icon-list-alt"></i> 实时流量监控</h2>

            <div class="box-icon">
                <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
                <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
            </div>
        </div>
        <div class="box-content">
            <div id="realtimechart" style="height:190px;"></div>
            <p class="clearfix">这是实时更新的流量数据图</p>

            <p>更新间隔<input id="updateInterval" type="text" value=""
                                            style="text-align: right; width:5em"> 毫秒</p>
        </div>
    </div>
    <!--/span-->
</div>
<!--/row-->

<!-- content ends -->
</div>
<!--/#content.span10-->
</div>
<!--/fluid-row-->

<hr>

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>

<footer>
    <p class="pull-left">&copy; <a href="http://www.neaghfoz.com" target="_blank">Somiyar</a> 2012</p>

    <p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">NeaghFoz </a></p>
</footer>

</div>
<!--/.fluid-container-->
<jsp:include page="../../common/charisma-footer.jsp"/>


</body>
</html>
