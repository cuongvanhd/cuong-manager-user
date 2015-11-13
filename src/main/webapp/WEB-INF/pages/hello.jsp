<html>
<head>
    <%@include file="inc/linkcss.jsp" %>
</head>
<body>
<h1>${message}</h1>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <input type="text" placeholder="Login Name" class="form-control">
        </div>
        <div class="col-md-4">
            <input type="password" placeholder="Password" class="form-control">
        </div>

        <div class="col-md-4">
            <input class="btn btn-lg btn-block btn-square btn-success'" type="button" value="Login"/>
        </div>

    </div>
</div>
</body>
</html>