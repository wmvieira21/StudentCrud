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
        <h3 id="header-tittle">Student Update</h3>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-sm-6 offset-sm-3">
                <form class="formStudent" action="StudentUpdate" method="POST">   
                    <div class="formCreateStudent">
                        <div class="form-group">
                            <input class="form-control" type="text" name="name"
                                   id="stdName" placeholder="Student Name" value="${name}" required>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" name="course" id="course"
                                   placeholder="Course" value="${course}" required>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" name="fee" id="fee"
                                   placeholder="Course fee" value="${fee}" required>
                        </div>
                        <div class="form-group">
                            <input class="btn btn-success" type="submit" value="Update">
                            <input class="btn btn-primary" type="button" value="to List" 
                                   onclick="window.location.href='ServletStudent'; return false">
                        </div>
                    </div>
                </form>
            </div>
        </div>
</body>
</html>