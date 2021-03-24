<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>

<%
    try {
        Statement smt = com.db.dbconnection.con.createStatement();
        String Find = "iphone12";
        //request.getParameter("find");
        String sql = "select * from item where name='" + Find + "'";
        ResultSet item = smt.executeQuery(sql);

        while (item.next()) {

            String imagePath = item.getString("img");
            String Name = item.getString("name");
            Double Price = item.getDouble("price");
%>
<form style="border:5px; border-color: black; border-style: solid; display: inline-block;">
    <img src="<%=imagePath%>" width="200px" height="200px">
    <br>
   Name: <p style="display: inline-block;"><%=Name%></p>
   <br>
   Price:<p style="display: inline-block;"><%=Price%></p>
   <br
</form>
   <form>
           <input type="submit" value="Add to cart">

   </form>
<%}
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>