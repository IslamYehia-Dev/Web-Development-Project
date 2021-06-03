<%-- 
    Document   : Register_Page
    Created on : Mar 18, 2021, 12:14:04 AM
    Author     : Al Badr
--%>

<%@page import="proj.AccessHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proj.User"%>
<!DOCTYPE html>
<%@include file="Main_Header.html" %>
<html>
    <head>    
        <title>Register Form</title>    
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
        int registerStatus = 0;
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String job = request.getParameter("job");
        String address = request.getParameter("address");
        boolean invaliduser = false;
        if (username != null && !username.isEmpty()) {
            if (email != null && !email.isEmpty()) {
                if (password != null && !password.isEmpty()) {
                    if (birthday != null && !birthday.isEmpty()) {
                        if (job != null && !job.isEmpty()) {
                            if (address != null && !address.isEmpty()) {
                                User user = new User();
                                user.uname = username;
                                user.email = email;
                                user.password = password;
                                user.birthday = birthday;
                                user.job = job;
                                user.address = address;
                                if (request.getParameter("sports") != null) {
                                    user.myInts.add("sports");
                                }
                                if (request.getParameter("mobiles") != null) {
                                    user.myInts.add("mobiles");
                                }
                                if (request.getParameter("laps") != null) {
                                    user.myInts.add("laps");
                                }
                                registerStatus = AccessHandler.registerUser(user);
                                if (registerStatus == 0) {
                                    invaliduser = true;
                                } else {
                                    
                                    session.setAttribute("userinfo", user);
                                    session.setAttribute("usertype", "user");
                                    session.setAttribute("successfulLogin", "true");
                                    //Go to product browsing here
                                    response.sendRedirect("viewitem.jsp");
                                }
                            }
                        }
                    }
                }
            }
        }
    %>
    <body>
<div class="LogoDiv">
            <img src="https://storage.tbcpay.ge/serviceimages/8466a41b-31b7-4a6d-b4d8-681c574a2ac3.jpg" class="Logo">
        </div>        
        <h2>Register Page</h2><br>    
        <div class="login">    
            <form id="login" method="POST" action="Register_Page.jsp">    
                <label><b>User Name </b> </label>    
                <input type="text" name="username" id="Uname" placeholder="Username">    
                <br>
                <br>
                <label><b>Email Address </b> </label>    
                <input type="text" name="email" id="Uname" placeholder="Email Address">    
                <br>
                <br>    
                <label><b>Password </b>    
                </label>    
                <input type="Password" name="password" id="Pass" placeholder="Password">    
                <br>
                <br>
                <label><b>Birthdate </b> </label>    
                <input type="date" name="birthday" id="Uname" >    
                <br>
                <br>    
                <label><b>Job </b> </label>    
                <input type="text" name="job" id="Uname" placeholder="Job">    
                <br>
                <br>    
                <label><b>Address </b> </label>    
                <input type="text" name="address" id="Uname" placeholder="Address">    
                <br>
                <br> 
                <input type="checkbox"  name="sports" >
                <label for="sports"> Sports</label><br>
                <input type="checkbox"  name="mobiles" >
                <label for="mobiles"> MobilePhones</label><br>
                <input type="checkbox"  name="laps" >
                <label for="laps"> Laptops</label><br>
                <br>
                <input type="submit" name="log" id="log" value="Register">       
                <br><br>    
            </form>
            <a href="Login_Page.jsp" style="color: white">Login</a>
        </div>
        <%
            if (invaliduser) {
        %>
        <h2>Invalid user name, please re-enter your user name</h2>
        <%    }
        %>
    </body>
</html>
<%@include file="Main_Footer.html" %>