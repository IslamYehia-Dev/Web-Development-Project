/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eslam
 */
public class editState extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int billNo = 0 ;
          int state = 0 ;
   try {
    billNo = Integer.parseInt(req.getParameter("orderId"));       
    state  = Integer.parseInt(req.getParameter("states"));
    AccessHandler.updateOrderState(billNo,state);
   }
   catch (Exception e) {
    }       
    resp.sendRedirect("vieworders.jsp");

            
    }

   
}
