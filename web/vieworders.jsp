<%-- 
    Document   : vieworders
    Created on : Mar 25, 2021, 4:51:49 PM
    Author     : eslam
--%>

<%@page import="java.util.*"%>
<%@page import="proj.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="Admin_Header.html" %>
<!DOCTYPE html>
<%
    String[] states = {"In Warehouse", "Shipped", "Delivered"};
%>
<html>

    <head>
        <style>
            table{

                margin-left: 120px;
                background-color: #277582;
            }
            label {
                font-weight: bolder;
                color: white;
                width: 300px;
                display: inline-block;
            }

            table,
            th,
            td {
                font-weight: bolder;
                border: 1px solid black;
                border-collapse: collapse;
                text-align: center;
            }
            nav{
                text-align: center;
                margin-top: 0;
                background-color:#23463f;
                padding: 25px;

            }
            nav a {
                text-decoration: none;
                margin-right: 50px;
                font-size: xx-large;
                color:#277582;
                font-weight: bolder;
            }
            p{
                display: inline-block;
                width: 100px;
                color: black;
            }
        </style>
    </head>

    <body>

        <%
            int res = AccessHandler.checkStatus(session);
            if (res == -1) {
                List<Order> allOrders = AccessHandler.getOrders();
                for (int i = 0; i < allOrders.size(); i++) {
                    Order temp = allOrders.get(i);
        %> 
        <br>
        <nav>
            <label for="username"> <p>Username : </p><%=temp.uname%></label>
            <label for="billno"><p>BillNo   :</p> <%=temp.billNO%></label>
            <label for="date"><p>Date      : </p><%=temp.date%></label>
            <label for="total"><p>Total    :</p> <%=temp.total%></label>
            <label for="state"><p>State    :</p> <%= states[temp.orderState]%> <br>
             
                <form action="editState.jsp">
                    <input type="hidden" name="orderId" value="<%=temp.billNO %>">
                    <input type="submit" value="Change Order State">
                </form>
            </label>
                         
        </nav>

        <nav>
            <table style="width: 80%;">
                <tr>
                    <th>Category Name</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>

                </tr>
                <%
                    for (int j = 0; j < temp.orderItems.size(); j++) {
                        OrderedItem tempo = temp.orderItems.get(j);
                %>
                <tr>
                    <td><%=tempo.catName%></td>
                    <td><%=tempo.name%></td>
                    <td><%=tempo.quantity%></td>
                    <td><%=tempo.price%></td>
                </tr>    
                <%

                    }
                %>

            </table>

        </nav> 
        <%
                }
            } else {
                response.sendRedirect("Login_Page.jsp");

            }
        %>

    </body>

</html>