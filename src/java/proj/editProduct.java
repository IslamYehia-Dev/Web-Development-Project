/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eslam
 */
@WebServlet(name = "editProduct", urlPatterns = {"/editProduct"})
public class editProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
Product newprod = new Product();
        try{
        newprod.id = Integer.parseInt(req.getParameter("itemid"));
        newprod.quantity = Integer.parseInt(req.getParameter("quantity"));
        newprod.price = Double.parseDouble(req.getParameter("price"));
        newprod.name = req.getParameter("name");
        AccessHandler.editProduct(newprod);
        resp.sendRedirect("/OnlineOrder/editprods.jsp");}
		catch(Exception e)
		{
        resp.sendRedirect("/OnlineOrder/editprods.jsp");
                }
    }


}
