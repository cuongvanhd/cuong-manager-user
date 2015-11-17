<%--
  Created by IntelliJ IDEA.
  User: Cuong
  Date: 2015/11/13
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
    <%@include file="inc/linkcss.jsp" %>
    <style>
        body {
            background: #357385;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="portlet portlet-green">
                <div class="portlet-heading">
                    <div class="portlet-title text-center">
                        <h4><strong>LOGIN</strong></h4>
                    </div>
                </div>
                <!-- Start display error login -->
                <div class="text-center">
                    <label class="error"></label>
                </div>
                <!-- End display error login -->
                <div class="portlet-body">
                    <!-- Start create form by Spring tag form -->
                    <form:form id="loginForm" action="/login" method="post">
                    <!-- <form action="/login" method="post">-->
                        <fieldset>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" placeholder="Login Name" class="form-control">
                                <%--<form:input path="loginName" Class="form-control" type="text" placeholder="LoginName"></form:input>--%>
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <%--<input type="password" placeholder="Password" class="form-control">--%>
                                <form:input path="password" Class="form-control" type="password" placeholder="Password"></form:input>
                            </div>
                            <form:button type="submit" class="btn btn-lg btn-block btn-square btn-success" id="btnLogin">Login</form:button>
                            <%--<form:button type="button" class="btn btn-lg btn-block btn-square btn-success" id="btnRegister">Register</form:button>--%>
                        </fieldset>
                    <%--</form>--%>
                    </form:form>
                    <!-- End create form by Spring tag form -->
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal-->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel"
     aria-hidden="true">

</div>
<!-- End Modal -->

</body>
</html>
