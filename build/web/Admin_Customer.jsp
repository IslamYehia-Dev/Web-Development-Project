<%-- 
    Document   : Admin_Customer
    Created on : Mar 19, 2021, 10:53:45 PM
    Author     : Al Badr
--%>

<%@page import="proj.*"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="Admin_Header.html"%>
<head>
    <style>
        table{

            margin-left: 120px;
            background-color: #277582;
        }
        label {
            font-weight: bolder;
            color: white;
            width: 300px;
            display: inline-block;
        }

        table,
        th,
        td {
            font-weight: bolder;
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
        nav{
            text-align: center;
            margin-top: 0;
            background-color:#23463f;
            padding: 25px;

        }

        p{
            display: inline-block;
            width: 100px;
            color: black;
        }
        input{
            width: 100px;
            height: 20px;  
            border: none;  
            border-radius: 17px;  
            color: #23463f;
            background-color: #277582;
            font-size: medium;
            font-weight: bolder;
        }
    </style>
</head>

<%
    int validLogin = 0;

    validLogin = AccessHandler.checkStatus(session);
    if (validLogin == -1) {
%>
<h1>Current Users :</h1>

<%
    Vector<User> users = new Vector<>();
    int deleteStatus = 0;
    String username = request.getParameter("username");
    if (username != null && !username.isEmpty()) {
        deleteStatus = AccessHandler.deleteUser(username);
    }
    users = AccessHandler.listUsers();
    for (User customer : users) {
%>
<nav>
    <form action="Admin_Customer.jsp" method="POST">

        <table border="1" style="width: 80%">
            <tr>
                <th>ID  : <%=customer.id%></th>
                <th>Name : <%=customer.uname%></th>
            </tr>
            <tr>
                <th>Job : <%=customer.job%> </th>
                <th>Email : <%=customer.email%></th>
            </tr>
            <tr>
                <th>CreditLimit : <%=customer.credit_Limit%> </th>
                <th>Address : <%=customer.address%></th>
            </tr>
            <tr>
                <th>Birthday : <%=customer.birthday%> </th>
                <input type="hidden" name="username"  value="<%=customer.uname %>">

                <th><input type="submit" value="Delete">
                    <a href="EditProfile.jsp?oldUsername=<%out.println(customer.uname);%>" style=" font-weight: bolder; color: #23463f; height: 20px; font-size: medium;">Edit Profile</a>
                </th>

            </tr>
        </table>

    </form>
</nav>
<br>


<%
        }

    } else {
        response.sendRedirect("Login_Page.jsp");
    }
%>


