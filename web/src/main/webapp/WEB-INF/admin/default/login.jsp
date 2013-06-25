<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>管理后台登录页面</title>
    <jsp:include page="../../../common/charisma-head.jsp"/>
</head>

<body>
<div class="container-fluid">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="span12 center login-header">
                <h2>欢迎回来</h2>
            </div>
            <!--/span-->
        </div>
        <!--/row-->

        <div class="row-fluid">
            <div class="well span5 center login-box">
                <div class="alert alert-info">
                    请输入用户名和密码
                    ${SPRING_SECURITY_LAST_EXCEPTION.message}
                </div>
                <form class="form-horizontal" action="${path}/sysadmin/user/login" method="post">
                    <fieldset>
                        <div class="input-prepend" title="用户名" data-rel="tooltip">
                            <span class="add-on"><i class="icon-user"></i></span>
                            <input autofocus class="input-large span10" name="userName" id="username" type="text"
                                   value="admin"/>
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend" title="密码" data-rel="tooltip">
                            <span class="add-on"><i class="icon-lock"></i></span>
                            <input class="input-large span10" name="password" id="password" type="password"
                                   value=""/>
                        </div>
                        <div class="clearfix"></div>
                        <div class="input-prepend">
                            <label class="remember" for="remember"><input type="checkbox" id="remember"/>记住我</label>
                        </div>
                        <div class="clearfix"></div>

                        <p class="center span5">
                            <button type="submit" class="btn btn-primary">登录</button>
                        </p>
                    </fieldset>
                </form>
            </div>
            <!--/span-->
        </div>
        <!--/row-->
    </div>
    <!--/fluid-row-->

</div>
<!--/.fluid-container-->
<jsp:include page="../../../common/charisma-footer.jsp"/>


</body>
</html>
