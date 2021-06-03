<%-- 
    Document   : addProduct
    Created on : Mar 21, 2021, 12:56:20 AM
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
<div class="login">    
    <form id="login" method="GET" action="addProductTodb">    
        <label><b>Name</b></label>    
        <input type="text" name="name" id="Uname" placeholder="Product Name">    
        <br><br>    
        <label><b>Quantity</b></label>    
        <input type="text" name="quantity" id="Uname" placeholder="Quantity In Stock">    
        <br><br>   
        <label><b>Price</b></label>    
        <input type="text" name="price" id="Uname" placeholder="Price">    
        <br><br>   
        <label><b>Image URL</b></label>    
        <input type="text" name="img" id="Uname" placeholder="Product Image">    
        <br><br>  
        <label><b>Category</b></label>    
        <select name="category">
            <%
                List<Category> cats = AccessHandler.getCats();
                for (int i = 0; i < cats.size(); i++) {


            %>
            <option value="<%= cats.get(i).cat_id%>"><%= cats.get(i).cat_name%></option>
            <% }%>
        </select>
        <br><br>  
        <input type="submit" name="log" id="log" value="ADD">

    </form>     
</div>    


<%
    } else {
        response.sendRedirect("Login_Page.jsp");

    }
%>
