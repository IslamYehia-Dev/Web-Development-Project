<%-- 
    Document   : newjsp
    Created on : Mar 18, 2021, 10:51:19 PM
    Author     : eslam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form action="addtocart" style="border: 5px; border-color: blue; border-style: solid; display: inline-block;">
       
        <input type="hidden" name="itemid" value="1">
        <input type="submit" value="Add To cart">
    </form>
            <form action="addtocart" style="border: 5px; border-color: blue; border-style: solid; display: inline-block;">
        
        <input type="hidden" name="itemid" value="2">
        <input type="submit" value="Add To cart">
    </form>
            <form action="addtocart" style="border: 5px; border-color: blue; border-style: solid; display: inline-block;">
        <input type="hidden" name="itemid" value="3">
        <input type="submit" value="Add To cart">
    </form>
    </body>
</html>
