<%-- 
    Document   : EditProfile
    Created on : Mar 21, 2021, 9:05:58 PM
    Author     : Al Badr
--%>

<%@page import="java.util.List"%>
<%@page import="proj.AccessHandler"%>
<%@page import="java.util.HashMap"%>
<%@page import="proj.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="userHeader.html"%>

<%

    User user = new User();
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String job = request.getParameter("job");
    String address = request.getParameter("address");
    String birthday = request.getParameter("birthday");
    User currentUser = (User) session.getAttribute("userinfo");
    int validLogin = 0;
    int updateStatus = 0;
    HashMap<String, String> userData = new HashMap<>();
    if (username != null && !username.isEmpty()) {
        userData.put("uname", username);
    }
    if (email != null && !email.isEmpty()) {
        userData.put("email", email);
    }
    if (password != null && !password.isEmpty()) {
        userData.put("password", password);
    }
    if (job != null && !job.isEmpty()) {
        userData.put("job", job);
    }
    if (address != null && !address.isEmpty()) {
        userData.put("adderss", address);
    }
    if (birthday != null && !birthday.isEmpty()) {
        userData.put("birthday", birthday);
    }

    if (userData.size() != 0) {

        if (currentUser.uname != null && !currentUser.uname.isEmpty()) {

            AccessHandler.editUserProfile(userData, currentUser.uname);
        }
    }


        int totalPurchases = 0;
        if (session.getAttribute("cart") != null) {
            List<Integer> totalCartItems = (List<Integer>) (session.getAttribute("cart"));
            totalPurchases = totalCartItems.size();
        }


%>
<li class="currentprods"><%=totalPurchases%></li>
</ul>
</nav>

<%    validLogin = proj.AccessHandler.checkStatus(session);
    if (validLogin == 1) {
%>
<head>
    <style>
        label{
            color: brown;
            width: 150px;
            display: inline-block;
        }
        h1{
            margin-left: 33%;
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
            .currentprods{
        font-size: xx-large;
        color: white;
        position:relative;
        bottom:10px;
        right:15px;
    }
    </style>
            <link rel="stylesheet" type="text/css" href="login.css">    

</head>
<h1>Edit Your Profile : </h1>
<div class="login">    
    <form id="login" method="GET" action="EditUserProfile.jsp">    
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
        <label><b>Birthday </b> </label>    
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

        <input type="submit" name="log" id="log" value="Save Changes">       
        <br><br>    
    </form>
</div>
<br><br>
<br><br>
<br><br>

<%
    if (updateStatus != 0) {
%>
<h3 class="updateMsg">Profile updated successfully.</h3>
<%
        }
    } else {

        response.sendRedirect("Login_Page.jsp");

    }
%>
<%@include file="User_Footer.html" %>