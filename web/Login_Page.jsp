<%-- 
    Document   : Login_Page
    Created on : Mar 18, 2021, 3:09:43 AM
    Author     : Al Badr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB.DataBaseConnector"%>
<%@page import="DB.AccessHandler"%>
<!DOCTYPE html>
<html>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean invalidLogin = false;
        boolean userLogin = false;
        boolean adminLogin = false;
        session = request.getSession(false);
        int loginStatus = 0;

        if (session.getAttribute("successfulLogin") == null) {


    %>
    <body>
        <form action="Login_Page.jsp" method="GET">
            <label for="User Name">User Name</label><br>
            <input type="text" name="username"><br>
            <label for="password">Password</label><br>
            <input type="password" name="password"><br>
            <input type="submit" value="Login">

        </form>
        <%            if (invalidLogin) {
        %>
        <h2>Wrong username or password, please re-enter your credentials</h2>
        <%
            }
        %>
    </body>
    <%                if (username != null && !username.isEmpty()) {
                if (password != null && !password.isEmpty()) {
                    loginStatus = AccessHandler.verifyLogin(username, password);
                    if (loginStatus == 1) {
                        session.setAttribute("successfulLogin", "true");
                        session.setAttribute("usertype", "user");
                        out.println("successful user login");
                        //Go to surfing products here
                        //response.sendRedirect("");

                    } else if (loginStatus == -1) {
                        session.setAttribute("successfulLogin", "true");
                        session.setAttribute("usertype", "admin");
                        out.println("successful admin login");
                        //Go to admin page here
                        //response.sendRedirect("");
                    } else {
                        invalidLogin=true;
                        out.println("Wrong credentials");
                        
                    }
                }
            }

        } else {

            if (session.getAttribute("successfulLogin").equals("true")) {
                out.println("You Are already logged in");
                // Go to home page again
                // response.sendRedirect("");
            }
        }


    %>
</html>
