<%-- 
    Document   : Product_Review
    Created on : Apr 17, 2021, 11:49:25 PM
    Author     : Al Badr
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="proj.Product"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="proj.AccessHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="userHeader.html" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product Review</title>
    <link rel="stylesheet" type="text/css" href="login.css">    

</head>
<style>

    .footerimg{
        height: 50px;
        width:150px;
        
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
    .user_review{
        border: solid 3px;
        text-align:left;
        width: 70%;
        background-color: #23463f;
        margin-left: 1%;
    }
    .product-img{
        height:250px;
        width:300px;
        display: inline;
        position: relative;

        top:1%;
        background-color: white;
    }
    .product-view{
        border:5px solid;
        width: 300px;
        margin-top:5%;
        background-color: #23463f;
        margin-left: 1%;

    }
    .displayed-info{
        display: inline;
        postion:relative;
        bottom:-10px;
    }
    h2{
        text-align: left;
    }
    h3{
        display:inline;
    }
    p{
        font-size: large;
    }
    .currentprods{
        font-size: xx-large;
        color: white;
        position:relative;
        bottom:10px;
        right:15px;
    }

</style>
<%
    int loginStatus = AccessHandler.checkStatus(session);
    int footerMarg = 0;
    String[] nameNdate;

    if (loginStatus == 1) {

        Product viewedProduct = new Product();
        String prodId = request.getParameter("prod_id");
        String prodName = request.getParameter("prod_name");
        Vector<String> reviews = new Vector<String>();
        int totalPurchases = 0;
        if (session.getAttribute("cart") != null) {
            List<Integer> totalCartItems = (List<Integer>) (session.getAttribute("cart"));
            totalPurchases = totalCartItems.size();
        }


%>
<li class="currentprods"><%=totalPurchases%></li>
</ul>
</nav>


<%    if (prodId != null && !prodId.isEmpty()) {
        reviews = AccessHandler.getReviews(Integer.parseInt(prodId));
    }
    if (prodName != null && !prodName.isEmpty()) {
        viewedProduct = AccessHandler.getProductDetails(prodName);

    }
    if (reviews.size() != 0) {
        footerMarg = reviews.size();
%>

<div class="product-view">

    <img class="product-img" src=<%=viewedProduct.img%>>
    <div class="displayed-info">
        <h2><%=prodName%> </h2>
        <h2>Price: <%=viewedProduct.price%></h2>
    </div>
</div>
<%
    for (int i = 0; i < reviews.size(); i++) {

        if (i % 2 == 0) {
            nameNdate = reviews.get(i).split("-", 2);
%>
<br>

<div class="user_review">
    <h3 style="color: white; margin-right: 20px;"><%=nameNdate[0]%></h3>
    <h3 ><%=nameNdate[1]%></h3><br>
    <%
    } else {

    %>
    <p style="color: skyblue"><%=reviews.get(i)%></p>
</div><br>
<%
        }
    }
} else {
%>
<h2 style="text-align: center;">
    No reviews for this product yet 
</h2>
<%
        }
    } else {
        response.sendRedirect("Login_Page.jsp");
    }
%>
<script>
    function applyStyle() {
        var displayedElements = document.getElementsByClassName("user_review")
        if (displayedElements.length != 0) {

            document.getElementById("user_footer").style.setProperty("height", "50px");
            document.getElementById("user_footer").style.setProperty("background-color", "#23463f");
            document.getElementById("user_footer").style.setProperty("width", "100%");
            document.getElementById("user_footer").style.setProperty("position", "relative");
            document.getElementById("user_footer").style.setProperty("margin-top", "<%=footerMarg%>px");
        } else {
            document.getElementById("user_footer").style.setProperty("height", "50px");
            document.getElementById("user_footer").style.setProperty("background-color", "#23463f");
            document.getElementById("user_footer").style.setProperty("width", "100%");
            document.getElementById("user_footer").style.setProperty("position", "absolute");
            document.getElementById("user_footer").style.setProperty("bottom", "0");
        }
    }

</script>



<%@include file="User_Footer.html" %>        

