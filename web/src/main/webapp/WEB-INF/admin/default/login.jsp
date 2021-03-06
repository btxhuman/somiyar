<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../../common/charisma_head.jsp"/>
    <meta charset="utf-8">
    <title>管理后台登录页面</title>
</head>

<body>
<div class="container-fluid">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="span12 center login-header">
                <h2>欢迎回来</h2>
            </div>
        </div>

        <div class="row-fluid">
            <div class="well span5 center login-box">
                <div class="alert alert-info">
                    请输入用户名和密码
                    ${SPRING_SECURITY_LAST_EXCEPTION.message}
                </div>
                <form class="form-horizontal" action="${path}/sysadmin/login" method="post">
                    <fieldset>
                        <div class="input-prepend" title="用户名" data-rel="tooltip">
                            <span class="add-on"><i class="icon-user"></i></span>
                            <input autofocus class="input-large span10" name="userName" id="username" type="text"
                                   value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/>
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
        </div>
    </div>
</div>
<jsp:include page="../../../common/charisma_bottom.jsp"/>
</body>
</html>
