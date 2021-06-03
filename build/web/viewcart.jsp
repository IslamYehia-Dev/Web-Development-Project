<%-- 
    Document   : viewcart
    Created on : Mar 19, 2021, 2:21:28 AM
    Author     : eslam
--%>

<%@page import="proj.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="userHeader.html" %>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>


    <link rel="stylesheet" href="/OnlineOrder/bootstrap.min.css">
    <link rel="stylesheet" href="/OnlineOrder/font-awesome.min.css">

    <link rel="stylesheet" href="/OnlineOrder/owl.carousel.css">
    <link rel="stylesheet" href="/OnlineOrder/responsive.css">
    <link rel="stylesheet" href="style.css">


</head>    
<style>
    body{
        background-color: skyblue;
    }
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
        text-decoration: none;
    }
    .currentprods{
        font-size: xx-large;
        color: white;
        position:relative;
        top:15px;
        right:25px;
    }
    .user-img{
        position:relative;
        bottom:24px;
        left:2px;
    }

    li{
        position: relative;
        right:9px;
        top:24px;
    }
    .arrow{
        bottom:4px;
    }
    .cart{
        position:relative;
        top:8px;
    }
    .single-shop-product{
        background-color: #23463f;
    }
    .empty-cart-msg{
        text-align: center;
        margin-top: 5%;
        
    }
</style>

<%
    int result = AccessHandler.checkStatus(session);
    int footerMarg = 0;
    boolean isCartEmpty = true;
    if (result == 1) {

        HttpSession hSes = request.getSession();
        List<Integer> productsCart = new ArrayList<>();
        if (hSes.getAttribute("cart") != null) {
            productsCart = (List<Integer>) hSes.getValue("cart");
            hSes.setAttribute("cart", productsCart);
        }
        List<Product> prods = AccessHandler.getProducts(productsCart);
        if (prods.size() != 0) {
            isCartEmpty = false;
        }
        if (prods.size() % 3 != 0) {
            footerMarg = (prods.size() / 3) + 1;
        } else {
            footerMarg = prods.size() / 3;
        }

        int totalPurchases = 0;
        if (session.getAttribute("cart") != null) {
            List<Integer> totalCartItems = (List<Integer>) (session.getAttribute("cart"));
            totalPurchases = totalCartItems.size();
        }


%>
<li class="currentprods"><%=totalPurchases%></li>
</ul>
</nav>

<%  if(isCartEmpty){
%>
<h1 class="empty-cart-msg">Your cart is currently empty</h1>
<%
}
    double total = 0;
    int margLeft = 0;
    int margTop = 0;

    for (int i = 0; i < prods.size(); i++) {
        Product temp = prods.get(i);
%>

<div class="single-product-area" style=" margin-left: <%=margLeft * 300%>px; margin-top:<%=margTop * 500%>px">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">

                <div class="single-shop-product" style="  border: 3px; border-color: #277582; border-style: solid;">
                    <div class="product-upper" style="width: 250px; height: 210px;">
                        <img src="<%=temp.img%>" alt="" style="padding:10px; width: 250px; height: 210px; ">
                    </div>
                    <h2><a href="" style="padding:10px"><%=temp.name%></a></h2>
                    <div class="product-carousel-price" style="padding:10px">
                        <ins><%=temp.price * temp.orderedQuantity%></ins>
                    </div>  
                    <div class="product-option-shop"style="padding:10px">
                        <a class="add_to_cart_button"  href="removefromcart?itemid=<%=temp.id%>">Remove From Cart</a>
                    </div>                       
                </div>


            </div></div></div></div>

<%
        total += temp.price * temp.orderedQuantity;

        margLeft++;
        if (margLeft == 3) {
            margLeft = 0;
            margTop++;
        }
    }

%>
<div>
    <form action="checkout" style="margin-top:<%=footerMarg * 450%>px; margin-left: 90%">    
        <label id="total" for="total">Total : <%=total%></label>
        <br>
        <input id="checkout" type="submit" value="Checkout">   
    </form>

</div>
<%
    } else {

        response.sendRedirect("Login_Page.jsp");
    }
%>
<script>
    function applyStyle() {
        var displayedElements = document.getElementsByClassName("single-product-area")


        if (displayedElements.length != 0) {

            document.getElementById("user_footer").style.setProperty("height", "50px");
            document.getElementById("user_footer").style.setProperty("background-color", "#25463f");
            document.getElementById("user_footer").style.setProperty("width", "100%");

        } else {
            document.getElementById("user_footer").style.setProperty("height", "50px");
            document.getElementById("user_footer").style.setProperty("background-color", "#23463f");
            document.getElementById("user_footer").style.setProperty("width", "100%");
            document.getElementById("user_footer").style.setProperty("position", "absolute");
            document.getElementById("user_footer").style.setProperty("bottom", "0");
            document.getElementById("total").style.setProperty("visibility", "hidden");
            document.getElementById("checkout").style.setProperty("visibility", "hidden");



        }
    }

</script>
<%@include file="User_Footer.html" %>