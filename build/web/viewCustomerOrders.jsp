<%-- 
    Document   : vieworders
    Created on : Mar 25, 2021, 4:51:49 PM
    Author     : eslam
--%>

<%@page import="java.util.*"%>
<%@page import="proj.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="userHeader.html" %>
<!DOCTYPE html>


    <head>
        <link rel="stylesheet" href="login.css">

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
            div{
                text-align: center;
                display: block;
                width: 90%; 
                position:relative;
                background-color:#23463f;
                padding: 25px;
                left:3%;

            }
            div a {
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

            .footerimg{

                height: 50px;
                width:150px;
                position:absolute;

            }
            .about{
                text-decoration: none;
                font-size: xx-large;
                right:45%;
                position:absolute;
                        color:black;

            }
            .about:hover{
                color:white;
            }
                .currentprods{
        font-size: xx-large;
        color: white;
        position:relative;
        bottom:10px;
        right:15px;
    }
    .order-details{
        margin-bottom: 2%;
    }
    .order-msg{
        text-align: center;
        margin-top: 5%;
    }
        </style>

    </head>
<%
         int totalPurchases = 0;
         boolean isOrderEmpty=true;
        if (session.getAttribute("cart") != null) {
            List<Integer> totalCartItems = (List<Integer>) (session.getAttribute("cart"));
            totalPurchases = totalCartItems.size();
        }


%>
<li class="currentprods"><%=totalPurchases%></li>
</ul>
</nav>

        <%
            int res = AccessHandler.checkStatus(session);
            int footerMarg=258;
            if (res == 1) {
                User curUser = (User) session.getAttribute("userinfo");
                List<Order> allOrders = AccessHandler.getOrders(curUser.id);
                if(allOrders.size()!=0){
                isOrderEmpty=false;
                }
                if(isOrderEmpty){
                
                %>
                <h1 class="order-msg">You haven't ordered anything yet</h1>
                <%
                    }
                for (int i = 0; i < allOrders.size(); i++) {
                    Order temp = allOrders.get(i);
        %> 
        <br>        <br>
        <br>

        <div class="order">
            <label for="username"> <p>Username : </p><%=temp.uname%></label>
            <label for="billno"><p>BillNo   :</p> <%=temp.billNO%></label>
            <label for="date"><p>Date      : </p><%=temp.date%></label>
            <label for="total"><p>Total    :</p> <%=temp.total%></label>
        </div>

        <div class="order-details">
            <table  style="width: 80%; ">
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
                <form action="takeReview.jsp" method="POST">


                    <tr>

                        <td><%=tempo.catName%></td>
                        <td><%=tempo.name%></td>
                        <td><%=tempo.quantity%></td>
                        <td><%=tempo.price%></td>
                    <input type="hidden" name="order_id" value="<%=temp.billNO%>">
                    <input type="hidden" name="prod_id" value="<%=tempo.item_ID%>">
                    <td><input type="submit" value="Submit Your Feedback"></td>
                    <!--<td ><a href="takeReview.jsp" style="text-align: center; font-size: small;  color: black;">Click To Enter Your Review</a></td>-->

                    </tr>    

                </form>
                <%

                    }
                %>

            </table>

        </div> 
        <%
                }
            } else {
                response.sendRedirect("Login_Page.jsp");

            }
        %>

    </body>

</html>
<script>
    function applyStyle() {
        var displayedElements = document.getElementsByClassName("order")
        if (displayedElements.length != 0) {

            document.getElementById("user_footer").style.setProperty("height", "50px");
            document.getElementById("user_footer").style.setProperty("background-color", "#23463f");
            document.getElementById("user_footer").style.setProperty("width", "100%");
            document.getElementById("user_footer").style.setProperty("position", "relative");
            document.getElementById("user_footer").style.setProperty("margin-top", "<%=footerMarg%>px");
            
        } else {
            document.getElementById("user_footer").style.setProperty("height", "50px");
            document.getElementById("user_footer").style.setProperty("background-color", "#23463f");
            document.getElementById("user_footer").style.setProperty("width", "104%");
            document.getElementById("user_footer").style.setProperty("position", "absolute");
            document.getElementById("user_footer").style.setProperty("bottom", "0");
        }   
    }

</script>
<%@include file="User_Footer.html" %>