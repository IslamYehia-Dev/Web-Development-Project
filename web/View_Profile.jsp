<%-- 
    Document   : viewProfile
    Created on : Apr 8, 2021, 4:35:32 PM
    Author     : eslam
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proj.*"%>
<%@include  file="userHeader.html" %>
<!DOCTYPE html>

<%
    int result = AccessHandler.checkStatus(session);
    if (result == 1) {

        int totalPurchases = 0;
        if (session.getAttribute("cart") != null) {
            List<Integer> totalCartItems = (List<Integer>) (session.getAttribute("cart"));
            totalPurchases = totalCartItems.size();
        }


%>
<li class="currentprods"><%=totalPurchases%></li>
</ul>
</nav>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" type="text/css" href="login.css">    
        <style>
            input{
                color: white;
            }
            a{
                text-decoration: none;
            }
            .currentprods{
                color: white;
                font-size:xx-large;
            }

            .userfooter{

                height: 50px;
                width:100%;
                background-color: #23463f;
                bottom: 0;
            }


            .footerimg{
                height: 50px;
                width:150px;
            }
            .about{
                text-decoration: none;
                font-size: xx-large;
                right:45%;
                position:absolute;
                        color:black;

            }
            .about:hover{
                color:white;
            }
            .single-product-area {
                padding: 10px 0 10px;
                display: inline-block;
                position:absolute;
                border: solid;

            }
            del{
                color: black;
            }
            ins{
                text-decoration: none;
                font-size: larger;
                font-weight: bolder;
                color: white;
            }
            .search{
                width:500px;
                margin-left: 20%;
            }
            .currentprods{
                font-size: xx-large;
                color: white;
                position:relative;
                bottom:10px;
                right:15px;
            }
        </style>
    </head>
    <body>
        <%
            User cur = (User) session.getAttribute("userinfo");

        %>
        <br>
        <br><br>
        <br>
        <div class="login">    
            <form id="login" method="POST">    
                <label><b>User Name </b> </label>    
                <input type="text" name="username" id="Uname" value="<%=cur.uname%>" disabled="true">    
                <br>
                <br>
                <label><b>Email Address </b> </label>    
                <input type="text" name="email" id="Uname" value="<%=cur.email%>" disabled="true">    
                <br>
                <br>    
                <label><b>Password </b>    
                </label>    
                <input type="text"  id="Uname" value="<%=cur.password%>" disabled="true">    
                <br>
                <br>
                <label><b>Birthdate </b> </label>    
                <input type="date" name="birthday" id="Uname" value="<%=cur.birthday%>" disabled="true" >    
                <br>
                <br>    
                <label><b>Job </b> </label>    
                <input type="text" name="job" id="Uname" value="<%=cur.job%>" disabled="true">    
                <br>
                <br>    
                <label><b>Address </b> </label>    
                <input type="text" name="address" id="Uname" value="<%=cur.address%>" disabled="true">    
                <br>
                <br> 

                <br><br>    
            </form>
        </div>
        <br>
        <br><br>
        <br>

        <%

            } else {

                response.sendRedirect("Login_Page.jsp");

            }
        %>
        <%@include file="User_Footer.html" %>