<%-- 
    Document   : viewcart
    Created on : Mar 19, 2021, 2:21:28 AM
    Author     : eslam
--%>

<%@page import="proj.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            HttpSession hSes = request.getSession();
            List<Integer> productsCart = new ArrayList<>();
            if (hSes.getAttribute("cart") != null) {
                productsCart = (List<Integer>) hSes.getValue("cart");
                hSes.setAttribute("cart", productsCart);
            }
            List<Product> prods = AccessHandler.getProducts(productsCart);
            
        %>
        <form action="checkout">
            <br>
            
            <form action=""><h1>Your Cart</h1> </form>
            <br>
            <% 
                double total = 0 ;
                for (int i = 0; i < prods.size(); i++) {
                Product temp = prods.get(i);
%>
            <br>
            <form action="removefromcart" style="border: 5px; border-color: blue; border-style: solid; display: inline-block;">
                <label style="text-align: center;"  for="Name" >   <%= temp.name %>   
                </label>
                <img src="
                     <%= temp.img %>" alt="" width="200px" height="200px">
                <label style="text-align: center;"  for="Price" >Price : <%= temp.price*temp.orderedQuantity %>
                </label> 
                
                <input type="hidden" name="itemid" value="<%= temp.id %>">
                <input type="submit" value="Remove">
            </form>
            <br>

            <%
                total+=temp.price*temp.orderedQuantity;
                }
            %>
            <label for="total">Total : <%=total%></label>
            <br>
            <input type="submit" value="Checkout">   
        </form>
    </body>
</html>
