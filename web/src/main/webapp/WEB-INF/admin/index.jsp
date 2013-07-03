<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

</head>

<body>
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
</div>

</body>
</html>
