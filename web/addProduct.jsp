<%-- 
    Document   : addProduct
    Created on : Mar 21, 2021, 12:56:20 AM
    Author     : eslam
--%>

<%@page import="java.util.List"%>
<%@page import="proj.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            label{
                color: brown;
                width: 70px;
                display: inline-block;
            }
        </style>
    </head>
    <body>
        <form action="addProductTodb">
            <label for="name">Name </label><input type="text" name="name" id=""><br>
            <label for="quantity">Quantity</label><input type="text" name="quantity" id=""> <br>
            <label for="price">Price</label><input type="text" name="price" id=""> <br>
            <label for="img">ImgURL</label><input type="text" name="img" id=""><br>
            <label for="category">Category</label>
            <select name="category">
                <%
                    List<Category> cats = AccessHandler.getCats();
                    for (int i = 0; i < cats.size(); i++) {


                %>
                <option value="<%= cats.get(i).cat_id%>"><%= cats.get(i).cat_name%></option>
                <% } %>
            </select>
            
            <br>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
