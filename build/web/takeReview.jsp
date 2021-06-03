<%-- 
    Document   : takeReview
    Created on : Apr 19, 2021, 3:29:47 AM
    Author     : eslam
--%>

<%@page import="java.util.List"%>
<%@page import="proj.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="userHeader.html" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Feedback </title>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="login.css">
        <style>
            .userfooter{
        position:absolute;
        height: 50px;
        left:0px;
        width:100%;
        background-color: #23463f;
        bottom: 0;
    }
    .footerimg{
        left: 0px;
        height: 50px;
        width:150px;
        position:absolute;
        
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
        right:18px;
    }
    .review-form{
        position:relative;
        left:35%;
    }

    ul{
        position: relative;
        right:7px;
    }
        </style>
    </head>
    <%
        int res = AccessHandler.checkStatus(session);
  
        if (res == 1 && request.getParameter("order_id") != null && request.getParameter("prod_id") != null) {
    
        User curUser = (User) session.getAttribute("userinfo");
        int bill_No = Integer.parseInt(request.getParameter("order_id"));
        int prod_Id = Integer.parseInt(request.getParameter("prod_id"));
    Product prod_to_review = AccessHandler.getProduct(prod_Id);
    
        int totalPurchases = 0;
        if (session.getAttribute("cart") != null) {
            List<Integer> totalCartItems = (List<Integer>) (session.getAttribute("cart"));
            totalPurchases = totalCartItems.size();
        }


%>
<li class="currentprods"><%=totalPurchases%></li>
</ul>
</nav>
  
<form action="addreviewtodb" method="GET" class="review-form">
            <br><br>
            <label for="feedback" style="color: black; font-weight: bolder;" >Review of <%=prod_to_review.name %>:</label> <br>
            <br>
            <textarea id="feedback" name="review" rows="4" cols="50" placeholder="Type Your Feedback Here"></textarea>
            <br><br>
             <input type="hidden" name="order_id" value="<%=bill_No %>">
                    <input type="hidden" name="prod_id" value="<%=prod_Id %>">
                     <input type="hidden" name="user_name" value="<%=curUser.uname %>">
                    <input type="hidden" name="user_id" value="<%=curUser.id %>">
            <input type="submit" value="Submit" style="position:relative; left:10%;">
        </form>
    </body>
</html>
<%
    } else {
        response.sendRedirect("Login_Page.jsp");

    }
%>
<%@include file="User_Footer.html" %>