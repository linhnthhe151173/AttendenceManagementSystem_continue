<%-- 
    Document   : account_detail
    Created on : Dec 10, 2021, 12:24:38 PM
    Author     : Linh
--%>

<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>account_detail</title>
        <%
            ArrayList<Account> list_account_admin = (ArrayList<Account>) request.getAttribute("list_account_admin");
            ArrayList<Account> list_account_teacher = (ArrayList<Account>) request.getAttribute("list_account_teacher");
            ArrayList<Account> list_account_student = (ArrayList<Account>) request.getAttribute("list_account_student");

        %>
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
                        <a class="nav-link" href="logout" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <h4 style="text-align: center;
                margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">ACCOUNT DETAIL</h4>
            <hr>
            <h6 style="margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">Account Admin</h6>
            <div style="margin-top: 20px;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Username</th>
                            <th scope="col">Password</th>
                            <th scope="col">Displayname</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                            for (int i = 0; i < list_account_admin.size(); i++) {
                        %>
                    <td><%=i + 1%></td>
                    <td><%=list_account_admin.get(i).getUsername()%></td>
                    <td>***</td>
                    <td><%=list_account_admin.get(i).getDisplayName()%></td>

                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <hr>
            <h6 style="margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">Account Teacher</h6>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Username</th>
                        <th scope="col">Password</th>
                        <th scope="col">Displayname</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int j = 0; j < list_account_teacher.size(); j++) {
                    %>
                    <tr>
                        <td><%=j + 1%></td><br>
                <td><%=list_account_teacher.get(j).getUsername()%></td>
                <td>***</td>
                <td><%=list_account_teacher.get(j).getDisplayName()%></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>

            <hr>
            <h6 style="margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">Account Student</h6>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Username</th>
                        <th scope="col">Password</th>
                        <th scope="col">Displayname</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int k = 0; k < list_account_student.size(); k++) {
                    %>
                    <tr>
                        <td><%=k + 1%></td><br>
                <td><%=list_account_student.get(k).getUsername()%></td>
                <td>***</td>
                <td><%=list_account_student.get(k).getDisplayName()%></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </body>
</html>
