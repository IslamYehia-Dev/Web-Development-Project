<%-- 
    Document   : Login_Page
    Created on : Mar 18, 2021, 3:09:43 AM
    Author     : Al Badr
--%>

<%@page import="proj.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file="Main_Header.html" %>
<html>
    <head>    
        <title>Login Form</title>    
        <link rel="stylesheet" type="text/css" href="login.css">    

    </head> 
    <style>
        .Logo{
            height: 87px;
        }

        .LogoDiv{
            position:absolute;
            top:0px;
            left:0px;
        }
    </style>

    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean userLogin = false;
        boolean adminLogin = false;
        session = request.getSession(false);
        int loginStatus = 0;

        if (session.getAttribute("successfulLogin") == null) {


    %>
    <body>
        <div class="LogoDiv">
            <img src="https://storage.tbcpay.ge/serviceimages/8466a41b-31b7-4a6d-b4d8-681c574a2ac3.jpg" class="Logo">
        </div>        
        <h2>Login Page</h2><br>    
        <div class="login">    
            <form id="login" method="POST" action="Login_Page.jsp">    
                <label><b>User Name     
                    </b>    
                </label>    
                <input type="text" name="username" id="Uname" placeholder="Username">    
                <br><br>    
                <label><b>Password     
                    </b>    
                </label>    
                <input type="Password" name="password" id="Pass" placeholder="Password">    
                <br><br>    
                <input type="submit" name="log" id="log" value="Login">       
                <br><br>    
            </form>     
        </div>    
        <%            if (session.getAttribute("invalidLogin")!=null) {
        %>
        <h2>Wrong username or password, please re-enter your credentials</h2>
        <%
            }
        %>
    </body>
    <%                if (username != null && !username.isEmpty()) {
                if (password != null && !password.isEmpty()) {
                    User user = new User();
                    loginStatus = AccessHandler.verifyLogin(username, password, user);
                    if (loginStatus == 1) {
                        session.setAttribute("successfulLogin", "true");
                        session.setAttribute("usertype", "user");
                        session.setAttribute("userinfo", user);
                        out.println("successful user login for" + user.id);
                        response.sendRedirect("viewitem.jsp");
 
                    } else if (loginStatus == -1) {
                        session.setAttribute("successfulLogin", "true");
                        session.setAttribute("usertype", "admin");
                        out.println("successful admin login");
                        response.sendRedirect("Admin_Page");
                    } else {
                         session.setAttribute("invalidLogin", true);
                    }
                }
            }

        } else {

            if (session.getAttribute("successfulLogin").equals("true")) {
                if (loginStatus == -1) {
                    response.sendRedirect("Admin_Page");
                } else {
                    response.sendRedirect("viewitem.jsp");
                }

            }
        }


    %>
</html>
<%@include file="Main_Footer.html" %>