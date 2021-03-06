<%--
  Created by IntelliJ IDEA.
  User: Cuong
  Date: 2015/11/13
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>List User</title>
    <!-- Input css file -->
    <%@include file="../inc/linkcss.jsp" %>
</head>
<body>

<div id="content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h4>MANAGE USER INFORMATION</h4>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <!-- Customer filter by classes -->
                <div class="row form-group">
                    <div class="col-sm-6 col-xs-12">
                        <%--{{ Form::label('classes', 'Classes') }}--%>
                        <%--{{ Form::select('classes',$classes, '0', array('class' => 'form-control col-sm-6 col-xs-12', 'id' => 'classes-select')) }}--%>
                    </div>
                </div>
                <!-- End Customer filter by classes -->
                <table id="student-list-table" class="table table-striped table-bordered table-hover table-green">
                    <thead>
                    <tr>
                        <th style="width:2%;">ID</th>
                        <th>FULL_NAME</th>
                        <th>FULL_NAME_KANA</th>
                        <th>EMAIL</th>
                        <th>TEL</th>
                        <th>BIRTHDAY</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="footer">
            <button class="btn btn-success" id="add-student"><i class="glyphicon glyphicon-plus"></i>Add</button>
        </div>
    </div>
</div>
<!--  Add Modal Container -->
<div class="modal modal-flex fade" id="studentAddModal" tabindex="-1" role="dialog"
     aria-labelledby="studentAddModalLabel" aria-hidden="true">
</div>
<div class="modal modal-flex fade" id="studentEditModal" tabindex="-1" role="dialog"
     aria-labelledby="studentEditModalLabel" aria-hidden="true">
</div>
<!--  Edit Modal Container -->

<!--Input js file -->
<%@include file="../inc/linkjs.jsp" %>
</body>
</html>
