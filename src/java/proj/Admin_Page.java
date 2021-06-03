package proj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Al Badr
 */
public class Admin_Page extends HttpServlet {


 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int loginStatus=0;
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);
        loginStatus=AccessHandler.checkStatus(session);
        if(loginStatus == -1){
        RequestDispatcher rd = req.getRequestDispatcher("Admin_Header.html");
        rd.include(req, resp);
        writer.println("        <style>\n" +
"            img{\n" +
"                width: 100%;\n" +
"                height: 100%;\n" +
"            }\n" +
"        </style>\n" +
"        <div>\n" +
"<img src=\"https://gvf.lt/en/files/2016/11/wordpress-website-maintenance-service.jpg\" alt=\"\">\n" +
"        </div>");

        }
        else{
        writer.println("<html>\n" +
"    <body>\n" +
"        <style>\n" +
"            img{\n" +
"                width: 100%;\n" +
"                height: 100%;\n" +
"            }\n" +
"        </style>\n" +
"        <div>\n" +
"<img src=\"https://s3.envato.com/files/222779205/Access%20Denied%20590x332.jpg\" alt=\"\">\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
        }
    }


}
