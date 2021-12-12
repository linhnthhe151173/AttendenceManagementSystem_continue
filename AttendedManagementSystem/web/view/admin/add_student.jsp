<%-- 
    Document   : add_student
    Created on : Dec 10, 2021, 2:32:32 PM
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
        <title>add_student</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="../home" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="content-wrapper" style="margin-top: 20px;">
            <div class="container">
                <div>
                    <h5 style="color: #EF7F1B;
                        margin-bottom: 20px;">Total</h5>
                </div>
                <div class="row">
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-primary o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-comments"></i>
                                </div>
                                <div class="mr-5">Total Subject</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="../subject_detail">
                                <span class="float-left">${total_subject} Subject</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-warning o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-list"></i>
                                </div>
                                <div class="mr-5">Total Class</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="../class_detail">
                                <span class="float-left">${total_class} Class</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-success o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-shopping-cart"></i>
                                </div>
                                <div class="mr-5">Total Account</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="../account_detail">
                                <span class="float-left">${total_account} Account</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-danger o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-support"></i>
                                </div>
                                <div class="mr-5">Total Schedule</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="../schedule_detail">
                                <span class="float-left">${total_schedule} Schedule</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-primary o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-comments"></i>
                                </div>
                                <div class="mr-5">Total Teacher</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="teacher/teacher_detail">
                                <span class="float-left">${total_teacher} Teacher</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-warning o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-list"></i>
                                </div>
                                <div class="mr-5">Total Student</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="student/student_detail">
                                <span class="float-left">${total_student} Student</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-success o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-shopping-cart"></i>
                                </div>
                                <div class="mr-5">Report Attendence</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="account_detail">
                                <span class="float-left">${total_attendence} Report</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- Area Chart Example-->
                <hr>
                <h5 style="color: #EF7F1B;
                    margin-bottom: 20px;">Detail</h5>
                <div class="row">
                    <div style="margin-top: 20px;
                         text-align: center;" class="col-md-2">
                        <table class="table table-bordered table-hover">
                            <tr>
                                <td><a href="../subject/add" style="color: black;">Subject</a></td>
                            </tr>
                            <tr>
                                <td><a href="../class/add" style="color: black;">Class</a></td>
                            </tr>
                            <tr>
                                <td><a href="add" style="color: black;">Student</a></td>
                            </tr>
                            <tr>
                                <td><a href="../teacher/add" style="color: black;">Teacher</a></td>
                            </tr>
                            <tr>
                                <td><a href="../schedule/add" style="color: black;">Schedule</a></td>
                            </tr>
                           
                        </table>
                    </div>
                    <div class="col-md-10" style="border: 1px solid #EF7F1B;">
                        <h5 style="color: #EF7F1B;
                            margin-top: 15px;">ADD NEW STUDENT</h5>
                        <form action="add" method="POST">
                            <table style="margin-top: 20px;">
                                <tr>
                                    <td>Student Code: </td>
                                    <td><input type="text" name="student_code" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Student Name: </td>
                                    <td><input type="text" name="student_name" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Image: </td>
                                    <td><input type="file" name="student_image" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Student Gender: </td>
                                    <td><input type="radio" name="student_gender" value="true" />Male
                                        <input type="radio" name="student_gender" value="false" />Female</td>
                                </tr>
                                <tr>
                                    <td>Student Address: </td>
                                    <td><textarea type="text" name="student_address" value="" /></textarea></td>
                                </tr>
                                <tr>
                                    <td>Student Email: </td>
                                    <td><input type="text" name="student_email" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Student Phone: </td>
                                    <td><input type="text" name="student_phone" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Student DOB: </td>
                                    <td><input type="date" name="student_dob" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Semester: </td>
                                    <td><select name="student_semester">
                                            <c:forEach items="${list_semester}" var="s">
                                                <option value="${s.getSemesterID()}">${s.getSemesterName()}</option>
                                            </c:forEach>
                                        </select></td>
                                </tr>
                            </table>
                            <button type="submmit" class="btn" style="background-color: #EF7F1B;
                                    margin-top: 15px;">Save</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
