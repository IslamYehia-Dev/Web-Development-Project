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
public class addProductTodb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product newprod = new Product();
        newprod.name = req.getParameter("name");
        newprod.img = req.getParameter("img");
        newprod.quantity = Integer.parseInt(req.getParameter("quantity"));
        newprod.price = Double.parseDouble(req.getParameter("price"));
        newprod.cat_no = Integer.parseInt(req.getParameter("category"));
        AccessHandler.addProduct(newprod);
        resp.sendRedirect("/OnlineOrder/addProduct.jsp");

    }

  
}
