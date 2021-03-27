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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eslam
 */
public class removefromcart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemid = Integer.parseInt(req.getParameter("itemid"));
        HttpSession hSes = req.getSession();
        List<Integer> productsCart = new ArrayList<>();
        if(hSes.getAttribute("cart")!=null)
        {
             productsCart = (List<Integer>)hSes.getValue("cart");
             productsCart.remove(productsCart.indexOf(itemid));
             hSes.setAttribute("cart", productsCart);
        }
        resp.sendRedirect("/OnlineOrder/viewcart.jsp");

    }

}
