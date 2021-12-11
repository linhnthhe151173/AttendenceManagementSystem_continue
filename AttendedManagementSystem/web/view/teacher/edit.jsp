<%-- 
    Document   : edit
    Created on : Dec 7, 2021, 2:16:11 PM
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
        <title>edit</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;margin-bottom: 20px;">
            <a class="navbar-brand" href="today_schedule.jsp" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user"></span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Container -->
        <div class="container">
            <div>
                <button type="button" class="btn" style="background-color: #EF7F1B;"><a href="submitted_attendence.jsp" style="color: white;
                                                                                        text-decoration: none;">Back</a></button>
            </div>
            <form action="edit" method="POST">
                <input type="hidden" name="scheduleID" value="${a_edit.getScheduleID().getScheduleID()}" />
                <div class="row " style="margin-top: 30px;
                     border: 1px solid #EF7F1B;
                     border-radius: 10px;">
                    <div class="col-md-3">
                        <div >
                            <img class="card-img-top" src="../img/${a_edit.getStudentID().getStudentImage()}" alt="Card image cap">
                        </div>
                    </div>

                    <div class="col-md-9">
                        <div style="padding-top: 50px;">
                            <h5>Student Code: <input type="hidden" name="studentID" value="${a_edit.getStudentID().getStudentID()}" />${a_edit.getStudentID().getStudentID()}</h5>
                            <h6>Email: <br>${a_edit.getStudentID().getStudentEmail()}</h6>	
                            <h6>Fullname: <br>${a_edit.getStudentID().getStudentName()}</h6>
                            <h6>Attendence: <br><input type="radio" name="attendence" value="true" ${a_edit.isPresent() == true ? "checked" : ""}/><span style="color: green;">Present</span>
                                <input type="radio" name="attendence" value="false" ${a_edit.isPresent() == false ? "checked" : ""}/><span style="color: red;">Absent</span></h6>
                        </div>
                    </div>
                    <div class="col text-center" style="padding-bottom: 20px;">
                        <button type="submit" class="btn" style="background-color: #EF7F1B;
                                color: white;">Submit</button>
                    </div>

                </div>
            </form>
        </div>
    </body>
</html>
