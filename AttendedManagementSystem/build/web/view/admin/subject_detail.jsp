<%-- 
    Document   : subject_detail
    Created on : Dec 10, 2021, 11:52:40 AM
    Author     : Linh
--%>

<%@page import="model.Subject"%>
<%@page import="model.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>subject_detail</title>
        <%
            ArrayList<Account> list_class = (ArrayList<Account>) request.getAttribute("list_account");
            ArrayList<Subject> subjects = (ArrayList<Subject>) request.getAttribute("subjects");
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
                        <a class="nav-link" href="" style="color: white;"><span class="fas fa-sign-in-alt"></span>| Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <!-- Search form -->
            <form action="subject_detail" method="POST">
                <div style="display: flex;margin-top: 20px;">
                    <input class="form-control" type="text" placeholder="Search for subject code" aria-label="Search" name="search">
                    <input type="submit" style="background-color: #EF7F1B;
                           border: none;" value="Search">
                </div>
            </form>

            <h4 style="text-align: center;
                margin-top: 20px;
                font-weight: bold;
                color: #EF7F1B;">SUBJECT DETAIL</h4>
            <%
                if (subjects != null) {
            %>
            <div style="margin-top: 20px;">

                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Subject Code</th>
                            <th scope="col">Subject Name</th>
                            <th scope="col">Total Slot</th>
                            <th scope="col">Semester</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < subjects.size(); i++) {
                                    %>
                                    <tr>
                                <th scope="row"><%=i+1%></th>
                                <td><%=subjects.get(i).getSubjectCode() %></td>
                                <td><%=subjects.get(i).getSubjectName()%></td>
                                <td><%=subjects.get(i).getTotalSlot()%></td>
                                <td><%=subjects.get(i).getSemesterID().getSemesterName() %></td>
                                <td><a href="subject/edit?subjectID=<%=subjects.get(i).getSubjectID()%>">Edit</a></td>
                                <td><a href="subject/remove?subjectID=<%=subjects.get(i).getSubjectID()%>">Remove</a></td>
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
                            <th scope="col">Subject Code</th>
                            <th scope="col">Subject Name</th>
                            <th scope="col">Total Slot</th>
                            <th scope="col">Semester</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list_subject}" var="s" varStatus="status">
                            <tr>
                                <th scope="row">${status.count}</th>
                                <td>${s.getSubjectCode()}</td>
                                <td>${s.getSubjectName()}</td>
                                <td>${s.getTotalSlot()}</td>
                                <td>${s.getSemesterID().getSemesterName()}</td>
                                <td><a href="subject/edit?subjectID=${s.getSubjectID()}">Edit</a></td>
                                <td><a href="subject/remove?subjectID=${s.getSubjectID()}">Remove</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
