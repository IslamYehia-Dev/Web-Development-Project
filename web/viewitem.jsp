<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proj.*"%>
<%@include  file="userHeader.html" %>
<!DOCTYPE html> 
<%
    int result = AccessHandler.checkStatus(session);
    int totalPurchases = 0;
    int margLeft = 0;
    int margTop = 0;
    int footerMarg = 0;
    if (result == 1) {

        if (session.getAttribute("cart") != null) {
            List<Integer> totalCartItems = (List<Integer>) (session.getAttribute("cart"));
            totalPurchases = totalCartItems.size();
        }


%>
<li class="currentprods"><%=totalPurchases%></li>
</ul>
</nav>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop</title>
    <link rel="stylesheet" type="text/css" href="style.css"> 
    <link rel="stylesheet" type="text/css" href="login.css">    


</head>
<style>
    a{
        text-decoration: none;
    }
    .currentprods{
        font-size: xx-large;
        color: white;
        position:relative;
        bottom:10px;
        right:15px;
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
    }
    .single-product-area {
        padding: 10px 0 10px;
        display: inline-block;
        position: absolute;
        border: solid;

    }
    del{
        color: black;
    }
    ins{
        text-decoration: none;
        font-size: larger;
        font-weight: bolder;
        color: white;
    }
    .search{
        width:50%;
        margin-left: 18%;
        margin-top:1%;
    }
    .product-img{
        background-color: white;
    }
    
</style>

<form method="GET" action="viewitem.jsp">
    <input placeholder="Search for a product here" type="text" name="productname" class="search">
    <input value="Search" type="submit" class="add_to_cart_button">
    <br><br><br>
</form>
<%
    String productName = request.getParameter("productname");
    String category = request.getParameter("cat");
    boolean displaySearchResult = false;
    boolean filterByCat = false;
    List<Product> products;
    if (productName != null && !productName.isEmpty()) {
        List<Product> searchProducts = AccessHandler.searchProducts(productName);
        if (searchProducts.size() != 0) {
            displaySearchResult = true;
        }
    }
    if (category != null && !category.isEmpty()) {
        filterByCat = true;
        session.setAttribute("cat", category);

    } else {
        session.removeAttribute("cat");
    }
    if (!displaySearchResult) {
        products = AccessHandler.getProducts();
    } else {
        products = AccessHandler.searchProducts(productName);

    }
    if (filterByCat) {
        products = AccessHandler.getProductsByCat(Integer.parseInt(category));

    }

    for (int i = 0; i < products.size(); i++) {
        Product temp = products.get(i);
        if (temp.quantity == 0) {
            continue;
        }

%>
<div class="single-product-area"  style="background: #23463f; margin-left: <%=margLeft * 340 + 250%>px; margin-top:<%=margTop * 550%>px">

    <img src="<%=temp.img%>" alt="" style="padding:10px; width: 250px; height: 210px; " class="product-img">

    <br>
    <h2 style="padding:10px; color:white"><%=temp.name%></h2>
    <br><br>    
    <div class="product-carousel-price" style="padding:10px">
        <del><%=temp.price + (temp.price * 0.1)%> </del> <ins><%= "   " + temp.price + " LE"%></ins>
    </div>  
    <br><br>    
    <a class="add_to_cart_button" style="margin-left: 70px;" href="addtocart?itemid=<%=temp.id%>">Add to cart</a>
    <br><br>  
    <a href="Product_Review.jsp?prod_id=<%=temp.id%>&prod_name=<%=temp.name%>" class="add_to_cart_button" style="margin-left: 70px; width: 80px; text-align: center" >Reviews</a>
</div>


<%
            margLeft++;
            if (margLeft == 3) {
                margLeft = 0;
                margTop++;

            }
        }
        margTop = ((margTop+1) % 3 == 0) ? --margTop : margTop ;

        footerMarg = (margTop != 0) ? (margTop + 1) * 550 : (margTop + 1) * 550;

    } else {

        response.sendRedirect("Login_Page.jsp");

    }
%>
<script>
    function applyStyle() {
        var displayedElements = document.getElementsByClassName("single-product-area")
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