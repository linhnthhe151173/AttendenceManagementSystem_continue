<%-- 
    Document   : profile
    Created on : Dec 9, 2021, 11:37:53 PM
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
        <title>profile_teacher</title>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-expand-md sticky-top" style="background-color: #EF7F1B;margin-bottom: 20px;">
            <a class="navbar-brand" href="today_schedule" style="color: white;">Attendence Management</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navb" class="navbar-collapse collapse hide">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="profile?teacherID=${t.getTeacherID()}" style="color: white;"><span class="fas fa-user"></span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container rounded bg-white mt-5 mb-5" style="border: 1px solid #EF7F1B;">
            <div class="row">
                <div class="col-md-5 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img style="width: 200px;height: 300px;" src="../img/${t.getTeacherImage()}"><span class="font-weight-bold">${t.getTeacherName()}</span><span class="text-black-50">${t.getTeacherEmail()}</span><span> </span></div>
                </div>
                <div class="col-md-7 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile</h4>
                        </div>
                        <div class="row mt-3">
                            <table class="table table-bordered">
                                <tr>
                                    <td>Gender</td>
                                    <td>${t.isTeacherGender() == true ? "Male" : "Female"}</td>
                                </tr>
                                <tr>
                                    <td>Date Of Birth</td>
                                    <td>${t.getTeacherDOB()}</td>
                                </tr>
                                <tr>
                                    <td>Address</td>
                                    <td>${t.getTeacherAddress()}</td>
                                </tr>
                                <tr>
                                    <td>Phone number</td>
                                    <td>${t.getTeacherPhone()}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
