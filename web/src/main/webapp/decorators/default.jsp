<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    request.setAttribute("path", path);
%>
<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Somiyar">
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }
    </style>

    <link id="bs-css" href="${path}/css/bootstrap-cerulean.css" rel="stylesheet">
    <%--<link href="${path}/css/bootstrap-cerulean.css" rel="stylesheet">--%>
    <link href="${path}/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${path}/css/charisma-app.css" rel="stylesheet">
    <link href="${path}/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
    <link href='${path}/css/fullcalendar.css' rel='stylesheet'>
    <link href='${path}/css/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='${path}/css/chosen.css' rel='stylesheet'>
    <link href='${path}/css/uniform.default.css' rel='stylesheet'>
    <link href='${path}/css/colorbox.css' rel='stylesheet'>
    <link href='${path}/css/jquery.cleditor.css' rel='stylesheet'>
    <link href='${path}/css/jquery.noty.css' rel='stylesheet'>
    <link href='${path}/css/noty_theme_default.css' rel='stylesheet'>
    <link href='${path}/css/elfinder.min.css' rel='stylesheet'>
    <link href='${path}/css/elfinder.theme.css' rel='stylesheet'>
    <link href='${path}/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='${path}/css/opa-icons.css' rel='stylesheet'>
    <link href='${path}/css/uploadify.css' rel='stylesheet'>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- The fav icon -->
    <link rel="shortcut icon" href="../../img/favicon.ico">

    <decorator:head/>

</head>
<body>
<decorator:body/>


<!-- jQuery -->
<script src="${path}/js/jquery-1.7.2.min.js"></script>
<!-- jQuery UI -->
<script src="${path}/js/jquery-ui-1.8.21.custom.min.js"></script>
<!-- transition / effect library -->
<script src="${path}/js/bootstrap-transition.js"></script>
<!-- alert enhancer library -->
<script src="${path}/js/bootstrap-alert.js"></script>
<!-- modal / dialog library -->
<script src="${path}/js/bootstrap-modal.js"></script>
<!-- custom dropdown library -->
<script src="${path}/js/bootstrap-dropdown.js"></script>
<!-- scrolspy library -->
<script src="${path}/js/bootstrap-scrollspy.js"></script>
<!-- library for creating tabs -->
<script src="${path}/js/bootstrap-tab.js"></script>
<!-- library for advanced tooltip -->
<script src="${path}/js/bootstrap-tooltip.js"></script>
<!-- popover effect library -->
<script src="${path}/js/bootstrap-popover.js"></script>
<!-- button enhancer library -->
<script src="${path}/js/bootstrap-button.js"></script>
<!-- accordion library (optional, not used in demo) -->
<script src="${path}/js/bootstrap-collapse.js"></script>
<!-- carousel slideshow library (optional, not used in demo) -->
<script src="${path}/js/bootstrap-carousel.js"></script>
<!-- autocomplete library -->
<script src="${path}/js/bootstrap-typeahead.js"></script>
<!-- tour library -->
<script src="${path}/js/bootstrap-tour.js"></script>
<!-- library for cookie management -->
<script src="${path}/js/jquery.cookie.js"></script>
<!-- calander plugin -->
<script src='${path}/js/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='${path}/js/jquery.dataTables.min.js'></script>

<!-- chart libraries start -->
<script src="${path}/js/excanvas.js"></script>
<script src="${path}/js/jquery.flot.min.js"></script>
<script src="${path}/js/jquery.flot.pie.min.js"></script>
<script src="${path}/js/jquery.flot.stack.js"></script>
<script src="${path}/js/jquery.flot.resize.min.js"></script>
<!-- chart libraries end -->

<!-- select or dropdown enhancer -->
<script src="${path}/js/jquery.chosen.min.js"></script>
<!-- checkbox, radio, and file input styler -->
<script src="${path}/js/jquery.uniform.min.js"></script>
<!-- plugin for gallery image view -->
<script src="${path}/js/jquery.colorbox.min.js"></script>
<!-- rich text editor library -->
<script src="${path}/js/jquery.cleditor.min.js"></script>
<!-- notification plugin -->
<script src="${path}/js/jquery.noty.js"></script>
<!-- file manager library -->
<script src="${path}/js/jquery.elfinder.min.js"></script>
<!-- star rating plugin -->
<script src="${path}/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="${path}/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="${path}/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="${path}/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="${path}/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="${path}/js/charisma.js"></script>

</body>
</html>
