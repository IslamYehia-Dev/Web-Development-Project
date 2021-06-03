<%-- 
    Document   : editState
    Created on : Jun 1, 2021, 8:12:14 PM
    Author     : eslam
--%>



<%@page import="java.util.List"%>
<%@page import="proj.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="Admin_Header.html"%>
<%int res = AccessHandler.checkStatus(session);
    if (res == -1) {
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="login.css">    

    <style>             
        .footer{
            bottom:0px;
            position:absolute;
            background-color: #17a78b
        }
    </style>
</head>
<br><br>
<%
    int billNo = 0 ;
   try {
    billNo = Integer.parseInt(request.getParameter("orderId"));       
       } catch (Exception e) {
     response.sendRedirect("vieworders.jsp");

       }
    

%>
<div class="login">  
    <form id="login" method="Post" action="editState">    
        <label><b>Order State : </b></label>    
                            <input type="hidden" name="orderId" value="<%=billNo%>">
        <select name="states">
            <!--           String[] states = {"In Warehouse", "Shipped", "Delivered"};-->

            <option value=0>In Warehouse</option>
            <option value=1>Shipped</option>
            <option value=2>Delivered</option>

        </select>
        <br><br>  
        <input type="submit" name="log" id="log" value="Update Order">

    </form>     
</div>    


<%    } else {
        response.sendRedirect("Login_Page.jsp");

    }
%>
