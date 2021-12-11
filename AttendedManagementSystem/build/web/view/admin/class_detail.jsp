<%-- 
    Document   : class_detail
    Created on : Dec 10, 2021, 12:13:36 PM
    Author     : Linh
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>class_detail</title>
        <%
            ArrayList<model.Class> list_class = (ArrayList<model.Class>) request.getAttribute("list_class");
            ArrayList<model.Class> classS = (ArrayList<model.Class>) request.getAttribute("classS");
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
                        <a class="nav-link" href="home_admin.jsp" style="color: white;"><span class="fas fa-user">Welcome: </span>${sessionScope.account.getDisplayName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <!-- Search form -->
            <form action="class_detail" method="POST">
                <div style="display: flex;margin-top: 20px;">
                    <input class="form-control" type="text" name="search" placeholder="Search for class name" aria-label="Search">
                    <input type="submit" style="background-color: #EF7F1B;
                           border: none;" value="Search">
                </div>
            </form>
            <h4 style="text-align: center;
                margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">CLASS DETAIL</h4>
            <%
                if (classS != null) {
            %>
            <div style="margin-top: 20px;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Class Name</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < classS.size(); i++) {
                        %>
                        <tr>
                            <th scope="row"><%=i + 1%></th>
                            <td><%=classS.get(i).getClassName()%></td>
                            <td><a href="class/edit?classID=<%=classS.get(i).getClassID()%>">Edit</a></td>
                            <td><a href="class/remove?classID=<%=classS.get(i).getClassID()%>">Remove</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <%
            } else {
            %>
            <div style="margin-top: 20px;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Class Name</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int j = 0; j < list_class.size(); j++) {
                        %>
                        <tr>
                            <th scope="row"><%=j + 1%></th>
                            <td><%=list_class.get(j).getClassName()%></td>
                            <td><a href="class/edit?classID=<%=list_class.get(j).getClassID()%>">Edit</a></td>
                            <td><a href="class/remove?classID=<%=list_class.get(j).getClassID()%>">Remove</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <%
                }
            %>

        </div>
    </body>
</html>
