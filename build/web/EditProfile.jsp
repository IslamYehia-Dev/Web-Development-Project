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

    String credit = request.getParameter("credit");
    String oldUsername = request.getParameter("oldUsername");
    int validLogin = 0;
    int updateStatus=0;
    validLogin = proj.AccessHandler.checkStatus(session);

    session.setAttribute("isCreditValid", "false");

    if (oldUsername != null && !oldUsername.isEmpty()) {
        session.setAttribute("oldUsername", oldUsername);

    } else {
        if (session.getAttribute("oldUsername") != null) {
            oldUsername = session.getAttribute("oldUsername").toString();
        } else {
            if (validLogin != 0) {
                response.sendRedirect("Admin_Page");
            }
        }
    }

    if (credit != null && !credit.isEmpty()) {

        if (oldUsername != null && !oldUsername.isEmpty()) {
            if (Double.parseDouble(credit) > 0) {

                session.setAttribute("isCreditValid", "true");
               

            }

        }

    }
    if(session.getAttribute("isCreditValid")!=null && session.getAttribute("isCreditValid").equals("true")){
    updateStatus=AccessHandler.editProfile(credit, oldUsername);
    }


%>

<%    if (validLogin == -1) {
%>
<head>
    <style>
        label{
            color: brown;
            width: 100px;
            display: inline-block;
        }
    </style>
</head>
<%@include file="Admin_Header.html" %>
<h1>     Modify <%=oldUsername%>'s credit :</h1>
<form action="EditProfile.jsp" method="GET" style="margin-left: 200px   ">
    <label for="credit">Credit</label>
    <input type="number" name="credit"><br><br>
    <input type="Submit" value="Save Changes">
</form>
<%
    if (session.getAttribute("isCreditValid") != null && session.getAttribute("isCreditValid").toString().equals("false") && credit!=null) {
%>
<h3>Please enter a valid credit value (example: 1000.100,500) </h3>
<%
    }
    if(updateStatus==1){
%>
<h3>Credit updated successfully for <%=oldUsername%> </h3>

<%
    }
    %>
 

<%
    } else {

        out.println("<html>\n"
                + "    <body>\n"
                + "        <style>\n"
                + "            img{\n"
                + "                width: 100%;\n"
                + "                height: 100%;\n"
                + "            }\n"
                + "        </style>\n"
                + "        <div>\n"
                + "<img src=\"https://s3.envato.com/files/222779205/Access%20Denied%20590x332.jpg\" alt=\"\">\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>");

    }
%>
