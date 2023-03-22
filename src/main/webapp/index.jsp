<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet"
              type="text/css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
              type="text/css">

        <link href="CSS/Student.css" rel="stylesheet" type="text/css">

    </head>
    <title>Student portal</title>
</head>
<body>
    <nav class="nav navbar-dark bg-dark">
        <h3 id="header-tittle">Student Registration</h3>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <form class="formStudent" action="ServletStudent" method="POST">   
                    <div align="left">
                        <strong>${message}</strong>
                    </div>

                    <div align="left" class="formCreateStudent">
                        <div class="form-group">
                            <input class="form-control" type="text" name="stdName"
                                   id="stdName" placeholder="Student Name" required>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" name="course" id="course"
                                   placeholder="Course" required>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" name="fee" id="fee"
                                   placeholder="Course fee" value="" required>
                        </div>
                        <div class="form-group">
                            <input class="btn btn-success" type="submit" value="Create">
                            <input class="btn btn-warning" type="reset" value="Reset">
                        </div>
                    </div>
                </form>
            </div>

            <div class="col-sm-8">

                <div class="panel-body">
                    <table class="table table-dark" id="tbl-student" cellpading="0" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Student name</th>
                                <th>Course</th>
                                <th>Fee</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <c:forEach var="student" items="${listStudents}">

                            <c:url var="urlEditStudent" value="StudentUpdate">
                                <c:param name="command" value="EDIT"></c:param>
                                <c:param name="id" value="${student.id}"></c:param>
                                <c:param name="name" value="${student.name}"></c:param>
                                <c:param name="course" value="${student.course}"></c:param>
                                <c:param name="fee" value="${student.fee}"></c:param>
                            </c:url>

                            <c:url var="urlDeleteStudent" value="ServletStudent">
                                <c:param name="command" value="DELETE"></c:param>
                                <c:param name="id" value="${student.id}"></c:param>
                            </c:url>

                            <tr>
                                <th>${student.name}</th>
                                <th>${student.course}</th>
                                <th>${student.fee}</th>
                                <th><a href="${urlEditStudent}">Edit</a></th>
                                <th><a href="${urlDeleteStudent}">Delete</a></th>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>

</body>
</html>