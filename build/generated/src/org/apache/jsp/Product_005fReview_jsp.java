package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Random;
import proj.Product;
import java.util.Vector;
import java.util.Set;
import java.util.HashMap;
import proj.AccessHandler;

public final class Product_005fReview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/userHeader.html");
    _jspx_dependants.add("/User_Footer.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            a\n");
      out.write("            {\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            nav{\n");
      out.write("                text-align: center;\n");
      out.write("                margin-top: 0;\n");
      out.write("                background-color:#23463f;\n");
      out.write("                height:87px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            nav a {\n");
      out.write("                text-decoration: none;\n");
      out.write("                margin-right: 50px;\n");
      out.write("                font-size: xx-large;\n");
      out.write("                color:#277582;\n");
      out.write("                font-weight: bolder;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ul li{\n");
      out.write("                display: inline-block;\n");
      out.write("                position: relative;\n");
      out.write("                line-height: 21px;\n");
      out.write("                text-align: left;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            ul li a:hover{\n");
      out.write("                color: rgb(255, 255, 255);\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            ul li ul.dropdown{\n");
      out.write("                min-width: 50%; \n");
      out.write("                background-color:#000000;\n");
      out.write("                display: none;\n");
      out.write("                position: absolute;\n");
      out.write("                z-index: 999;\n");
      out.write("                left: 0;\n");
      out.write("            }\n");
      out.write("            ul li:hover ul.dropdown{\n");
      out.write("                display: block;\t\n");
      out.write("            }\n");
      out.write("            ul li ul.dropdown li{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            .arrow{\n");
      out.write("                width:20px;\n");
      out.write("                height:20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .cart {\n");
      out.write("                margin-left: 10%;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            ul li ul.dropdown  a{\n");
      out.write("                font-size: medium;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            nav ul{\n");
      out.write("                margin-top:0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onload=\"applyStyle()\">\n");
      out.write("\n");
      out.write("        <nav>\n");
      out.write("\n");
      out.write("            <ul>\n");
      out.write("                <li> <a href=\"viewitem.jsp\">All Categories</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li> <a href=\"viewitem.jsp?cat=2\">Mobile Phones</a>\n");
      out.write("                </li>\n");
      out.write("                <li> <a href=\"viewitem.jsp?cat=1\">Laptops</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li >\n");
      out.write("                    <a href=\"\"> <img class=\"user-img\" src=\"https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png\" style=\"width: 100px; height: 60px; margin-top: 5px;\" alt=\"UserInfo\"> <img class=\"arrow\" src=\"https://image.flaticon.com/icons/png/512/60/60995.png\" class=\"arrow\"> </a>\n");
      out.write("                    <ul class=\"dropdown\">\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"View_Profile.jsp\">Profile<br></a><br>\n");
      out.write("                        <a href=\"viewCustomerOrders.jsp\">My Orders<br></a><br>\n");
      out.write("                        <a href=\"EditUserProfile.jsp\">Edit Profile<br></a><br>\n");
      out.write("                        <a href=\"logout\">Logout<br></a><br>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </li>            \n");
      out.write("                <li class=\"cart\">\n");
      out.write("                    <a href=\"viewcart.jsp\"><img style=\"width:80px; height: 50px ; \" alt=\"Cart\"\n");
      out.write("                                                src=\"http://pngimg.com/uploads/shopping_cart/small/shopping_cart_PNG13.png\"></a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </li>");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Product Review</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"login.css\">    \n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("\n");
      out.write("    .footerimg{\n");
      out.write("        height: 50px;\n");
      out.write("        width:150px;\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("    .about{\n");
      out.write("        text-decoration: none;\n");
      out.write("        font-size: xx-large;\n");
      out.write("        right:45%;\n");
      out.write("        position:absolute;\n");
      out.write("                color:black;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .about:hover{\n");
      out.write("        color:white;\n");
      out.write("    }\n");
      out.write("    .user_review{\n");
      out.write("        border: solid 3px;\n");
      out.write("        text-align:left;\n");
      out.write("        width: 70%;\n");
      out.write("        background-color: #23463f;\n");
      out.write("        margin-left: 1%;\n");
      out.write("    }\n");
      out.write("    .product-img{\n");
      out.write("        height:250px;\n");
      out.write("        width:300px;\n");
      out.write("        display: inline;\n");
      out.write("        position: relative;\n");
      out.write("\n");
      out.write("        top:1%;\n");
      out.write("        background-color: white;\n");
      out.write("    }\n");
      out.write("    .product-view{\n");
      out.write("        border:5px solid;\n");
      out.write("        width: 300px;\n");
      out.write("        margin-top:5%;\n");
      out.write("        background-color: #23463f;\n");
      out.write("        margin-left: 1%;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    .displayed-info{\n");
      out.write("        display: inline;\n");
      out.write("        postion:relative;\n");
      out.write("        bottom:-10px;\n");
      out.write("    }\n");
      out.write("    h2{\n");
      out.write("        text-align: left;\n");
      out.write("    }\n");
      out.write("    h3{\n");
      out.write("        display:inline;\n");
      out.write("    }\n");
      out.write("    p{\n");
      out.write("        font-size: large;\n");
      out.write("    }\n");
      out.write("    .currentprods{\n");
      out.write("        font-size: xx-large;\n");
      out.write("        color: white;\n");
      out.write("        position:relative;\n");
      out.write("        bottom:10px;\n");
      out.write("        right:15px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>\n");

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



      out.write("\n");
      out.write("<li class=\"currentprods\">");
      out.print(totalPurchases);
      out.write("</li>\n");
      out.write("</ul>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
    if (prodId != null && !prodId.isEmpty()) {
        reviews = AccessHandler.getReviews(Integer.parseInt(prodId));
    }
    if (prodName != null && !prodName.isEmpty()) {
        viewedProduct = AccessHandler.getProductDetails(prodName);

    }
    if (reviews.size() != 0) {
        footerMarg = reviews.size();

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"product-view\">\n");
      out.write("\n");
      out.write("    <img class=\"product-img\" src=");
      out.print(viewedProduct.img);
      out.write(">\n");
      out.write("    <div class=\"displayed-info\">\n");
      out.write("        <h2>");
      out.print(prodName);
      out.write(" </h2>\n");
      out.write("        <h2>Price: ");
      out.print(viewedProduct.price);
      out.write("</h2>\n");
      out.write("    </div>\n");
      out.write("</div>\n");

    for (int i = 0; i < reviews.size(); i++) {

        if (i % 2 == 0) {
            nameNdate = reviews.get(i).split("-", 2);

      out.write("\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<div class=\"user_review\">\n");
      out.write("    <h3 style=\"color: white; margin-right: 20px;\">");
      out.print(nameNdate[0]);
      out.write("</h3>\n");
      out.write("    <h3 >");
      out.print(nameNdate[1]);
      out.write("</h3><br>\n");
      out.write("    ");

    } else {

    
      out.write("\n");
      out.write("    <p style=\"color: skyblue\">");
      out.print(reviews.get(i));
      out.write("</p>\n");
      out.write("</div><br>\n");

        }
    }
} else {

      out.write("\n");
      out.write("<h2 style=\"text-align: center;\">\n");
      out.write("    No reviews for this product yet \n");
      out.write("</h2>\n");

        }
    } else {
        response.sendRedirect("Login_Page.jsp");
    }

      out.write("\n");
      out.write("<script>\n");
      out.write("    function applyStyle() {\n");
      out.write("        var displayedElements = document.getElementsByClassName(\"user_review\")\n");
      out.write("        if (displayedElements.length != 0) {\n");
      out.write("\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"height\", \"50px\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"background-color\", \"#23463f\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"width\", \"100%\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"position\", \"relative\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"margin-top\", \"");
      out.print(footerMarg);
      out.write("px\");\n");
      out.write("        } else {\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"height\", \"50px\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"background-color\", \"#23463f\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"width\", \"100%\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"position\", \"absolute\");\n");
      out.write("            document.getElementById(\"user_footer\").style.setProperty(\"bottom\", \"0\");\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<footer id=\"user_footer\" class=\"userfooter\"  >\n");
      out.write("            \n");
      out.write("            <img src=\"https://storage.tbcpay.ge/serviceimages/8466a41b-31b7-4a6d-b4d8-681c574a2ac3.jpg\"  class=\"footerimg\">\n");
      out.write("            <a href=\"aboutus.html\" class=\"about\" style=\"font-size: large\">About Us</a>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("        \n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
