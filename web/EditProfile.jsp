<%-- 
    Document   : EditProfile
    Created on : Mar 21, 2021, 9:05:58 PM
    Author     : Al Badr
--%>

<%@page import="proj.AccessHandler"%>
<%@page import="java.util.HashMap"%>
<%@page import="proj.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = new User();
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String job = request.getParameter("job");
    String address = request.getParameter("address");
    String birthday = request.getParameter("birthday");
    String credit = request.getParameter("credit");
    int validLogin =0;
    HashMap <String,String> userData = new HashMap<>();
    if (username != null && !username.isEmpty()) {
        userData.put("uname",username);
        if (email != null && !email.isEmpty()) {
userData.put("email",email);
        }
        if (password != null && !password.isEmpty()) {
userData.put("password",password);
        }
        if (job != null && !job.isEmpty()) {
            userData.put("job",job);
        }
        if (address != null && !address.isEmpty()) {
userData.put("adderss",address);
        }
        if (birthday != null && !birthday.isEmpty()) {
userData.put("birthday",birthday);
        }
        if (credit != null && !credit.isEmpty()) {
userData.put("cerditlimit",credit);
        }
        if(userData.size()!=0){
            AccessHandler.editProfile(userData);
            
        }}

%>

<%
validLogin = proj.AccessHandler.checkStatus(session);
if(validLogin==-1){
%>
<html>
    <body>
         
        <h1>Change Profile</h1>
        <form action="EditProfile.jsp" method="GET">
            <label for="username">User Name</label>
            <input type="text" name="username"><br>
            <label for="email">E-mail</label>
            <input type="text" name="email"><br>
            <label for="password">Password</label>
            <input type="text" name=password><br>
            <label for="job">Job</label>
            <input name="job" type="text"><br>
            <label for="address">Address</label>
            <input name="address" type="text"><br>
            <label for="birthday">Birthday</label>
            <input name="birthday" type="text"><br>
            <label for="credit">Credit</label>
            <input type="number" name="credit"><br>
            <input type="Submit" value="Save Changes">
        </form>
                    
    </body>
</html>
<%
    
}
else{
out.println("Unauthorized access");
}
%>