package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import proj.*;
import java.util.Vector;

public final class Admin_005fCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Admin_Header.html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<style>\n");
      out.write("    nav{\n");
      out.write("    text-align: center;\n");
      out.write("    margin-top: 0;\n");
      out.write("    background-color:#23463f;\n");
      out.write("    padding: 25px;\n");
      out.write("    }\n");
      out.write("nav a {\n");
      out.write("    text-decoration: none;\n");
      out.write("    margin-right: 50px;\n");
      out.write("    font-size: xx-large;\n");
      out.write("    color:#277582;\n");
      out.write("    font-weight: bolder;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("ul li{\n");
      out.write("    display: inline-block;\n");
      out.write("    position: relative;\n");
      out.write("    line-height: 21px;\n");
      out.write("    text-align: left;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("ul li a:hover{\n");
      out.write("    color: rgb(255, 255, 255);\n");
      out.write("    }\n");
      out.write("ul li ul.dropdown{\n");
      out.write("    min-width: 50%; \n");
      out.write("    background-color:#000000;\n");
      out.write("    display: none;\n");
      out.write("    position: absolute;\n");
      out.write("    z-index: 999;\n");
      out.write("    left: 0;\n");
      out.write("}\n");
      out.write("ul li:hover ul.dropdown{\n");
      out.write("    display: block;\t\n");
      out.write("}\n");
      out.write("ul li ul.dropdown li{\n");
      out.write("    display: block;\n");
      out.write("}\n");
      out.write(".arrow{\n");
      out.write("    width:20px;\n");
      out.write("    height:20px;\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <nav>\n");
      out.write("    \n");
      out.write("    <ul>\n");
      out.write("       <li>        <a href=\"Admin_Customer.jsp\">Manage Customers</a>\n");
      out.write("       </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"\">Manage Products<img src=\"https://image.flaticon.com/icons/png/512/60/60995.png\" class=\"arrow\"> </a>\n");
      out.write("            <ul class=\"dropdown\">\n");
      out.write("                <li><a href=\"editprods.jsp\"><br> Edit Product</a></li>\n");
      out.write("                <li><a href=\"addProduct.jsp\"><br> Add Product <br></a></li><br>\n");
      out.write("               \n");
      out.write("                \n");
      out.write("            </ul>\n");
      out.write("        </li>\n");
      out.write("\n");
      out.write("        <li>\n");
      out.write("            <a href=\"vieworders.jsp\">Orders History</a>\n");
      out.write("\n");
      out.write("        </li>\n");
      out.write("      </ul>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <style>\n");
      out.write("        table{\n");
      out.write("\n");
      out.write("            margin-left: 120px;\n");
      out.write("            background-color: #277582;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            font-weight: bolder;\n");
      out.write("            color: white;\n");
      out.write("            width: 300px;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table,\n");
      out.write("        th,\n");
      out.write("        td {\n");
      out.write("            font-weight: bolder;\n");
      out.write("            border: 1px solid black;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        nav{\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 0;\n");
      out.write("            background-color:#23463f;\n");
      out.write("            padding: 25px;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        p{\n");
      out.write("            display: inline-block;\n");
      out.write("            width: 100px;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("        input{\n");
      out.write("            width: 100px;\n");
      out.write("            height: 20px;  \n");
      out.write("            border: none;  \n");
      out.write("            border-radius: 17px;  \n");
      out.write("            color: #23463f;\n");
      out.write("            background-color: #277582;\n");
      out.write("            font-size: medium;\n");
      out.write("            font-weight: bolder;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");

    int validLogin = 0;

    validLogin = AccessHandler.checkStatus(session);
    if (validLogin == -1) {

      out.write("\n");
      out.write("<h1>Current Users :</h1>\n");
      out.write("\n");

    Vector<User> users = new Vector<>();
    int deleteStatus = 0;
    String username = request.getParameter("username");
    if (username != null && !username.isEmpty()) {
        deleteStatus = AccessHandler.deleteUser(username);
    }
    users = AccessHandler.listUsers();
    for (User customer : users) {

      out.write("\n");
      out.write("<nav>\n");
      out.write("    <form action=\"Admin_Customer.jsp\" method=\"POST\">\n");
      out.write("\n");
      out.write("        <table border=\"1\" style=\"width: 80%\">\n");
      out.write("            <tr>\n");
      out.write("                <th>ID  : ");
      out.print(customer.id);
      out.write("</th>\n");
      out.write("                <th>Name : ");
      out.print(customer.uname);
      out.write("</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Job : ");
      out.print(customer.job);
      out.write(" </th>\n");
      out.write("                <th>Email : ");
      out.print(customer.email);
      out.write("</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>CreditLimit : ");
      out.print(customer.credit_Limit);
      out.write(" </th>\n");
      out.write("                <th>Address : ");
      out.print(customer.address);
      out.write("</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Birthday : ");
      out.print(customer.birthday);
      out.write(" </th>\n");
      out.write("                <input type=\"hidden\" name=\"username\"  value=\"");
      out.print(customer.uname );
      out.write("\">\n");
      out.write("\n");
      out.write("                <th><input type=\"submit\" value=\"Delete\">\n");
      out.write("                    <a href=\"EditProfile.jsp?oldUsername=");
out.println(customer.uname);
      out.write("\" style=\" font-weight: bolder; color: #23463f; height: 20px; font-size: medium;\">Edit Profile</a>\n");
      out.write("                </th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("</nav>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("\n");

        }

    } else {
        response.sendRedirect("Login_Page.jsp");
    }

      out.write("\n");
      out.write("\n");
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
