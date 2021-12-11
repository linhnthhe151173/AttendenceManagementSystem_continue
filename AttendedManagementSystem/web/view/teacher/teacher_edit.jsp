<%-- 
    Document   : teacher_edit
    Created on : Dec 10, 2021, 6:37:18 PM
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
        <title>teacher_edit</title>
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
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
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
                    <input type="hidden" name="teacherID" value="${t.getTeacherID()}" />
                    <tr>
                        <td>Teacher Name: </td>
                        <td><input type="text" name="name" value="${t.getTeacherName()}" /></td>
                    </tr>
                    <tr>
                        <td>Image: </td>
                        <td><input type="file" name="image" value="${t.getTeacherImage()}" /></td>
                    </tr>
                    <tr>
                        <td>Teacher Gender: </td>
                        <td><input type="radio" name="gender"${t.isTeacherGender() == true? "checked":""} value="${t.isTeacherGender()}" />Male
                        <input type="radio" name="gender" value="${t.isTeacherGender()}" ${t.isTeacherGender() == false? "checked":""}/>Female</td>
                    </tr>
                    <tr>
                        <td>Teacher Address: </td>
                        <td><input type="text" name="address" value="${t.getTeacherAddress()}" /></td>
                    </tr>
                    <tr>
                        <td>Teacher Email: </td>
                        <td><input type="text" name="email" value="${t.getTeacherEmail()}" /></td>
                    </tr>
                    <tr>
                        <td>Teacher Phone: </td>
                        <td><input type="text" name="phone" value="${t.getTeacherPhone()}" /></td>
                    </tr>
                    <tr>
                        <td>Date of birth: </td>
                        <td><input type="date" name="date" value="${t.getTeacherDOB()}" /></td>
                    </tr>
                </table>
                <button type="submmit" class="btn" style="background-color: #EF7F1B;
                        margin-top: 15px;">Save</button>
            </form>

        </div>
    </body>
</html>
