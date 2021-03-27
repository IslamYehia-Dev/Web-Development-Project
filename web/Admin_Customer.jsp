<%-- 
    Document   : Admin_Customer
    Created on : Mar 19, 2021, 10:53:45 PM
    Author     : Al Badr
--%>

<%@page import="DB.AccessHandler"%>
<%@page import="java.util.Vector"%>
<%@page import="DB.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <body>
        <h1>Current Users</h1>

            <%
                Vector<User> users = new Vector<>();
                int deleteStatus = 0;
                String username = request.getParameter("username");
                if (username != null && !username.isEmpty()) {
                    AccessHandler.deleteUser(username);
                }
                users = AccessHandler.listUsers();
                for (User customer : users) {
            %>
           
     <form action="Admin_Customer.jsp?username=<%out.println(customer.uname);%>" method="POST">
        <span style="display: inline-block; border-style: solid; border-color: black;">
            <h2 style="display: inline; margin-right: 10px;">--Id : <% out.println(customer.id);%> </h2>
            <h2 style="display: inline; margin-right: 10px;">--User Name : <% out.println(customer.uname);%></h2>
            <h2 style="display: inline; margin-right: 10px;" >--E-mail : <% out.println(customer.email);%> </h2><br>
            <h2 style="display:inline; margin-right: 10px;">--Birthday : <% out.println(customer.birthday);%></h2>
            <h2 style="display: inline; margin-right: 10px;">--Job : <% out.println(customer.job);%> </h2><br>
            <h2 style="display: inline; margin-right: 10px;">--Current Credit : <% out.println(customer.credit_Limit);%> </h2>
            <h2 style="display: inline; margin-right: 10px;">--Address : <% out.println(customer.address);%> </h2>
        </span>
        <input type="submit" value="Delete">
    </form><br>
       
        
        <%
            }

        %>
    
</body>
</html>
