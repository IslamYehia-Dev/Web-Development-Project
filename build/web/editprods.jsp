<%-- 
    Document   : editprods
    Created on : Mar 20, 2021, 9:06:18 PM
    Author     : eslam
--%>

<%@page import="proj.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="Admin_Header.html"%>
            <%int res = AccessHandler.checkStatus(session);
            if(res==-1)
            {
                %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="login.css">    

    <style>
        label{  
            color:#23463f; 
            width: 100px;
            display: block;
            font-size: 17px;
            margin-left: 12px;
        }   
        input{
            margin: 10px;
        }
        .footer{
            bottom:0px;
            position:absolute;
            background-color: #17a78b
        }
    </style>
</head>
<br>
<br>
<%

    List<Product> prods = AccessHandler.getProducts();
    for (int i = 0; i < prods.size(); i++) {
        Product temp = prods.get(i);
%>
<form id="login" method="GET" action="editProduct" style="background-color: #277582; margin: 5px; border: 5px; border-color: #23463f; border-style: solid; display: inline-block;">    
    <img src="<%=temp.img%>" alt="" width="300px" height="300px">

    <br>
    <label><b>Name     
        </b>    
    </label>    
    <input type="text" name="name" id="Uname" value="<%=temp.name%>">    
    <br><br>    
    <label><b>Price     
        </b>    
    </label>    
    <input type="text" name="price" id="Pass" value="<%=temp.price%>">    
    <br><br>    
    <label><b>Quantity     
        </b>    
    </label>    
    <input type="text" name="quantity" id="Pass" value="<%=temp.quantity%>">    
    <br><br>    

    <input type="submit" name="log" id="log" value="Save">
    <input type="hidden" name="itemid"  value="<%=temp.id%>">
    <br><br>    
</form> 

<%
    }
%>
<%
}
else {
        response.sendRedirect("Login_Page.jsp");

}
%>



