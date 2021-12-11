<%-- 
    Document   : add_teacher
    Created on : Dec 10, 2021, 3:43:24 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>add_teacher</title>
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
                        <a class="nav-link" href="home_admin.jsp" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
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
                                <td><a href="../student/add" style="color: black;">Student</a></td>
                            </tr>
                            <tr>
                                <td><a href="add" style="color: black;">Teacher</a></td>
                            </tr>
                            <tr>
                                <td><a href="../schedule/add" style="color: black;">Schedule</a></td>
                            </tr>
                            <tr>
                                <td><a href="student.jsp" style="color: black;">Attendence Report</a></td>
                            </tr>
                        </table>
                    </div>
                    <div class="col-md-10 " style="border: 1px solid #EF7F1B;">
                        <h5 style="color: #EF7F1B;
                            margin-top: 15px;">ADD NEW TEACHER</h5>
                        <form action="add" method="POST">
                            <table style="margin-top: 20px;">
                                <tr>
                                    <td>Teacher Name: </td>
                                    <td><input type="text" name="teacher_name" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Image: </td>
                                    <td><input type="file" name="teacher_image" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Teacher Gender: </td>
                                    <td><input type="radio" name="teacher_gender" value="true" />Male
                                    <input type="radio" name="teacher_gender" value="false" />Female</td>
                                </tr>
                                <tr>
                                    <td>Teacher Address: </td>
                                    <td><textarea type="text" name="teacher_adress" value="" /></textarea></td>
                                </tr>
                                <tr>
                                    <td>Teacher Email: </td>
                                    <td><input type="text" name="teacher_email" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Teacher Phone: </td>
                                    <td><input type="text" name="teacher_phone" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Date of birth: </td>
                                    <td><input type="date" name="teacher_dob" value="" /></td>
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
