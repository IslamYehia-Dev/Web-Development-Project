package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import proj.*;

public final class Login_005fPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Main_Header.html");
    _jspx_dependants.add("/Main_Footer.html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            nav{\n");
      out.write("                text-align: center;\n");
      out.write("                margin-top: 0;\n");
      out.write("                background-color:#23463f;\n");
      out.write("                padding: 25px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            nav a {\n");
      out.write("                text-decoration: none;\n");
      out.write("                margin-right: 50px;\n");
      out.write("                font-size: xx-large;\n");
      out.write("                color:#277582;\n");
      out.write("                font-weight: bolder;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav>\n");
      out.write("            <a href=\"Login_Page.jsp\">Login</a>\n");
      out.write("            <a href=\"Register_Page.jsp\">Register</a>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>    \n");
      out.write("        <title>Login Form</title>    \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"login.css\">    \n");
      out.write("\n");
      out.write("    </head> \n");
      out.write("    <style>\n");
      out.write("        .Logo{\n");
      out.write("            height: 87px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .LogoDiv{\n");
      out.write("            position:absolute;\n");
      out.write("            top:0px;\n");
      out.write("            left:0px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    ");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean userLogin = false;
        boolean adminLogin = false;
        session = request.getSession(false);
        int loginStatus = 0;

        if (session.getAttribute("successfulLogin") == null) {


    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"LogoDiv\">\n");
      out.write("            <img src=\"https://storage.tbcpay.ge/serviceimages/8466a41b-31b7-4a6d-b4d8-681c574a2ac3.jpg\" class=\"Logo\">\n");
      out.write("        </div>        \n");
      out.write("        <h2>Login Page</h2><br>    \n");
      out.write("        <div class=\"login\">    \n");
      out.write("            <form id=\"login\" method=\"POST\" action=\"Login_Page.jsp\">    \n");
      out.write("                <label><b>User Name     \n");
      out.write("                    </b>    \n");
      out.write("                </label>    \n");
      out.write("                <input type=\"text\" name=\"username\" id=\"Uname\" placeholder=\"Username\">    \n");
      out.write("                <br><br>    \n");
      out.write("                <label><b>Password     \n");
      out.write("                    </b>    \n");
      out.write("                </label>    \n");
      out.write("                <input type=\"Password\" name=\"password\" id=\"Pass\" placeholder=\"Password\">    \n");
      out.write("                <br><br>    \n");
      out.write("                <input type=\"submit\" name=\"log\" id=\"log\" value=\"Login\">       \n");
      out.write("                <br><br>    \n");
      out.write("            </form>     \n");
      out.write("        </div>    \n");
      out.write("        ");
            if (session.getAttribute("invalidLogin")!=null) {
        
      out.write("\n");
      out.write("        <h2>Wrong username or password, please re-enter your credentials</h2>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("    ");
                if (username != null && !username.isEmpty()) {
                if (password != null && !password.isEmpty()) {
                    User user = new User();
                    loginStatus = AccessHandler.verifyLogin(username, password, user);
                    if (loginStatus == 1) {
                        session.setAttribute("successfulLogin", "true");
                        session.setAttribute("usertype", "user");
                        session.setAttribute("userinfo", user);
                        out.println("successful user login for" + user.id);
                        response.sendRedirect("viewitem.jsp");
 
                    } else if (loginStatus == -1) {
                        session.setAttribute("successfulLogin", "true");
                        session.setAttribute("usertype", "admin");
                        out.println("successful admin login");
                        response.sendRedirect("Admin_Page");
                    } else {
                         session.setAttribute("invalidLogin", true);
                    }
                }
            }

        } else {

            if (session.getAttribute("successfulLogin").equals("true")) {
                if (loginStatus == -1) {
                    response.sendRedirect("Admin_Page");
                } else {
                    response.sendRedirect("viewitem.jsp");
                }

            }
        }


    
      out.write("\n");
      out.write("</html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
