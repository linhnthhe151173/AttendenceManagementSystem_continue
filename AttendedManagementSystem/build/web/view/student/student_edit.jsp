<%-- 
    Document   : student_edit
    Created on : Dec 10, 2021, 7:15:23 PM
    Author     : Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>student_edit</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="home" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user">Welcome: </span>Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container" style="margin-top: 20px">
            <h4 style="color: #EF7F1B;text-align: center;padding-bottom: 10px;">EDIT SUBJECT</h4>
            <form action="edit" method="POST">
                <table class="table table-bordered">
                    <input type="hidden" name="studentID" value="${s.getStudentID()}" />
                    <tr>
                        <td>Student Name: </td>
                        <td><input type="text" name="name" value="${s.getStudentName()}" /></td>
                    </tr>
                    <tr>
                        <td>Image: </td>
                        <td><input type="file" name="image" value="${s.getStudentImage()}" /></td>
                    </tr>
                    <tr>
                        <td>Student Gender: </td>
                        <td><input type="radio" name="gender"${s.isStudentGender() == true? "checked":""} value="${s.isStudentGender()}" />Male
                            <input type="radio" name="gender" value="${s.isStudentGender()}" ${s.isStudentGender() == false? "checked":""}/>Female</td>
                    </tr>
                    <tr>
                        <td>Student Address: </td>
                        <td><input type="text" name="address" value="${s.getStudentAddress()}" /></td>
                    </tr>
                    <tr>
                        <td>Student Email: </td>
                        <td><input type="text" name="email" value="${s.getStudentEmail()}" /></td>
                    </tr>
                    <tr>
                        <td>Student Phone: </td>
                        <td><input type="text" name="phone" value="${s.getStudentPhone()}" /></td>
                    </tr>
                    <tr>
                        <td>Date of birth: </td>
                        <td><input type="date" name="date" value="${s.getStudentDOB()}" /></td>
                    </tr>
                    <tr>
                        <td>Semster: </td>
                        <td><select name="semester">
                                <c:forEach items="${list_semester}" var="s1">
                                    <option value="${s1.getSemesterID()}" ${s1.getSemesterID() == s.getSemesterID().getSemesterID()?"selected":""}> ${s1.getSemesterName()}</option>
                                </c:forEach>

                            </select></td>
                    </tr>
                </table>
                <button type="submmit" class="btn" style="background-color: #EF7F1B;
                        margin-top: 15px;">Save</button>
            </form>

        </div>
    </body>
</html>
