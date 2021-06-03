/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eslam
 */
public class main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("header.html");
        rd.include(req, resp);

        resp.getOutputStream().print("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <img src=\"https://secureservercdn.net/160.153.137.218/8jn.381.myftpupload.com/wp-content/uploads/2020/09/cropped-logo-for-website-1.jpg\" alt=\"\" width=\"100%\" height=\"600px\">\n"
                + "</body>\n"
                + "</html>");
        RequestDispatcher rd1 = req.getRequestDispatcher("footer.html");
        rd1.include(req, resp);
    }

}
