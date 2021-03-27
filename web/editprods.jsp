<%-- 
    Document   : editprods
    Created on : Mar 20, 2021, 9:06:18 PM
    Author     : eslam
--%>

<%@page import="proj.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            List<Product> prods = AccessHandler.getProducts();
            for (int i = 0; i < prods.size(); i++) {
                Product temp = prods.get(i);
        %>
        <form action="editProduct" style="border: 5px; border-color: blue; border-style: solid; display: inline-block;">
            <img src="<%=temp.img %>" alt="" width="200px" height="200px">
            <br>
            <label for="name"> Name <input type="text" name="name"  value="<%=temp.name %>" ></label><br>
            <label for="price"> Price <input type="text" name="price"  value="<%=temp.price %>" ></label><br>
            <label for="quantity"> Quantity <input type="text" name="quantity"  value="<%=temp.quantity %>" ></label><br>
            <input type="hidden" name="itemid" value="<%=temp.id %>">
            <input type="submit" value="Save">
        </form>

            <%
                }
            %>

    </body>
</html>
