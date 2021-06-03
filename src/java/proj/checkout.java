/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class checkout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> productsCart = new ArrayList<>();
        productsCart = (List<Integer>) req.getSession().getAttribute("cart");
        if (productsCart != null && !productsCart.isEmpty()) {
            List<Product> prods = AccessHandler.getProducts(productsCart);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(date);

            
            User curUser = (User)req.getSession().getAttribute("userinfo");
            int y = curUser.id;
            AccessHandler.makeOrder(y, strDate, prods);
            req.getSession().removeAttribute("cart");
        }
        
        resp.sendRedirect("/OnlineOrder/viewcart.jsp");

    }

}
