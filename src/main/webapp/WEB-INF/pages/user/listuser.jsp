<%--
  Created by IntelliJ IDEA.
  User: Cuong
  Date: 2015/11/13
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <div class="table table-responsive ">
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
                        <th>GROUP_NAME</th>
                        <th>FULL_NAME</th>
                        <th>FULL_NAME_KANA</th>
                        <th>EMAIL</th>
                        <th>TEL</th>
                        <th>BIRTHDAY</th>
                        <th>NAME_LEVEL</th>
                        <th>START_DATE</th>
                        <th>END_DATE</th>
                        <th>TOTAL</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userInforCommands}" var="user">
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.groupName}</td>
                            <td>${user.fullName}</td>
                            <td>${user.fullNameKata}</td>
                            <td>${user.email}</td>
                            <td>${user.tel}</td>
                            <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
                            <td>${user.nameLevel}</td>
                            <td><fmt:formatDate value="${user.startDate}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${user.endDate}" pattern="yyyy-MM-dd"/></td>
                            <td>${user.total}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="panel-footer col-md-12">
            <div class="pull-left col-md-6">
                <button class="btn btn-success pull-left" id="add-student"><i class="glyphicon glyphicon-plus"></i>Add
                </button>
            </div>

            <!-- Start Pagination -->
            <div class="pull-right col-md-6">
                <div class="pull-left">
                    <span>${pagination.numberOfFirstElement}</span> - <span>${pagination.numberOfLastElement}</span> /
                    <span>${pagination.totalElements}</span>
                </div>
                <div class="pull-right">
                    <ul style="margin-top: 0;" class="pagination pull-right">
                        <li class="${pagination.hasPreviousPage()?'':'disabled'}"><a
                                href="listuser?page=${pagination.previousPageNumber}">&laquo;</a></li>
                        <c:forEach var="p" items="${pagination.getPageables(pageable)}">
                            <%--<c:if test="${p.pageNumber eq pagination.currentPageNumber?'active':''}">--%>
                            <li><a href="listuser?page=${p.pageNumber},size=${p.pageSize}">${p.pageNumber + 1}</a></li>
                            <%--</c:if>--%>
                        </c:forEach>
                        <li class="${pagination.hasNextPage()?'':'disable'}"><a
                                href="listuser?page=${pagination.nextPageNumber}">&raquo;</a></li>
                    </ul>
                </div>
                <!-- End Pagination -->
            </div>
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
