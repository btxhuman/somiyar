<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    request.setAttribute("path",path);
    //String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Somiyar">
<meta name="author" content="neaghfoz">

<!-- The styles -->

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
<link href='${path}/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
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