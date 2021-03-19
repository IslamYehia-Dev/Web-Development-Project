<%-- 
    Document   : Register_Page
    Created on : Mar 18, 2021, 12:14:04 AM
    Author     : Al Badr
--%>

<%@page import="DB.AccessHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB.User"%>
<!DOCTYPE html>
<html>
    <%  
       int registerStatus=0;
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String job = request.getParameter("job");
        String address = request.getParameter("address");
        boolean invaliduser = false;
        if (username != null && !username.isEmpty()) {
            if (email != null && !email.isEmpty()) {
                if (password != null && !password.isEmpty()) {
                    if (birthday != null && !birthday.isEmpty()) {
                        if (job != null && !job.isEmpty()) {
                            if (address != null && !address.isEmpty()) {
                                User user = new User();
                                user.uname=username;
                                user.email=email;
                                user.password=password;
                                user.birthday=birthday;
                                user.job=job;
                                user.address=address;
                                registerStatus=AccessHandler.registerUser(user);
                                if(registerStatus==0){
                                
                                invaliduser=true;
                                
                                }
                                else{
                                out.println("Registered Successfully");
                                session.setAttribute("userinfo", user);
                                session.setAttribute("successfulLogin", "true");
                                //Go to product browsing here
                                //response.sendRedirect("");
                                }
                            }
                        }
                    }
                }
            }
        }
    %>
    <body>
        <form action="Register_Page.jsp" method="GET">
            <label for="User Name">User Name</label><br>
            <input type="text" name="username"><br>
            <label for="email">E-mail</label><br>
            <input type="text" name="email"><br>
            <label for="password">Password</label><br>
            <input type="password" name="password"><br>
            <label for="birthday">Birthday</label><br>
            <input type="text" name="birthday"><br>
            <label for="job">Job</label><br>
            <input type="text" name="job"><br>
            <label for="address">Address</label><br>
            <input type="text" name="address"><br>
            <input type="submit" value="Register">

        </form>
        <a href="Login_Page.jsp">Login</a>
        <% 
if(invaliduser){
    

%>
<h2>Invalid user name, please re-enter your user name</h2>
<% 
}
%>
    </body>

</html>
