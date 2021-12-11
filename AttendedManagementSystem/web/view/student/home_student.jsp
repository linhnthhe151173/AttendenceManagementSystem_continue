<%-- 
    Document   : home_student
    Created on : Dec 7, 2021, 2:48:55 PM
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
        <title>home_student</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;">
            <a class="navbar-brand" href="#" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="profile_student.jsp" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div style="margin-top: 20px;">
                <h5>Your Semester: 5</h5>
                <h5 style="color: #EF7F1B;">Check your attended schedule with:</h5>
                <div>
                    <ul>
                        <li>
                            <a href="attended_schedule_detail.jsp" style="color: black;">PRJ(Java Web Application)</a>
                        </li>
                        <li>
                            <a href="attended_schedule_detail.jsp" style="color: black;">PRJ(Java Web Application)</a>
                        </li>
                        <li>
                            <a href="attended_schedule_detail.jsp" style="color: black;">PRJ(Java Web Application)</a>
                        </li>
                    </ul>
                </div>
            </div>
            <hr>
            <h5 style="color: #EF7F1B;">Or check another your semester:</h5>
            <div class="row">
                <div class="col-md-2">
                    <table class="table table-hover">
                        <thead>
                        <th>Semester</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Semester 1</td>
                            </tr>
                            <tr>
                                <td>Semester 2</td>
                            </tr>
                            <tr>
                                <td>Semester 3</td>
                            </tr>
                            <tr>
                                <td>Semester 4</td>
                            </tr>
                            <tr>
                                <td>Semester 5</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                <div class="col-md-3" style="border-left: 1px solid black;">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Subject's Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td><a>PRJ301(SE1511)</a></td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td><a>PRJ301(SE1511)</a></td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td><a>PRJ301(SE1511)</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-7"  style="border-left: 1px solid black;">
                    <h6>Lecture: LinhNTH</h6>
                    <table class="table table-hover">
                        <thead>
                        <th>STT</th>
                        <th>Date</th>
                        <th>Time Slot</th>
                        <th>Room</th>
                        <th>Class Name</th>
                        <th>Attendance Status</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>02-08-2021</td>
                                <td>7:30-9:30</td>
                                <td>BE157</td>
                                <td>SE1511</td>
                                <td style="color: green;">Present</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>02-08-2021</td>
                                <td>7:30-9:30</td>
                                <td>BE157</td>
                                <td>SE1511</td>
                                <td style="color: green;">Present</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>02-08-2021</td>
                                <td>7:30-9:30</td>
                                <td>BE157</td>
                                <td>SE1511</td>
                                <td style="color: green;">Present</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>02-08-2021</td>
                                <td>7:30-9:30</td>
                                <td>BE157</td>
                                <td>SE1511</td>
                                <td style="color: green;">Present</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>02-08-2021</td>
                                <td>7:30-9:30</td>
                                <td>BE157</td>
                                <td>SE1511</td>
                                <td style="color: green;">Present</td>
                            </tr>
                            <tr>
                                <td colspan="6" style="text-align: center;"><h5>2 ABSENT ON 30 TOTAL</h5></td>
                            </tr>
                        </tbody>
                    </table>
                    
                </div>
            </div>
        </div>
    </body>
</html>
