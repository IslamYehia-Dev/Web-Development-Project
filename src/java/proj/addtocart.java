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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eslam
 */
public class addtocart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemid = Integer.parseInt(req.getParameter("itemid"));
        HttpSession hSes = req.getSession();
        
        
        List<Integer> productsCart = new ArrayList<>();
        List<Product> prods = AccessHandler.getProducts();
        List<Product> curProds = new ArrayList<>();
        if (hSes.getAttribute("cart") != null) {
            productsCart = (List<Integer>) hSes.getAttribute("cart");
            curProds = AccessHandler.getProducts(productsCart);
        }
        for (int i = 0; i < curProds.size(); i++) {
            for (int j = 0; j < prods.size(); j++) {
                if (curProds.get(i).id==prods.get(j).id) {
                    prods.get(j).orderedQuantity =curProds.get(i).orderedQuantity;
                }
                else 
                    prods.get(j).orderedQuantity = 0 ;
            }
        }
        boolean available = true;
        for (int i = 0; i < prods.size(); i++) {
            if (itemid == prods.get(i).id) {
                if (prods.get(i).orderedQuantity >= prods.get(i).quantity) {
                    available = false;
                    break;
                }
            }
        }
        if (available) {
                productsCart.add(itemid);
            }
            hSes.setAttribute("cart", productsCart);
            if(hSes.getAttribute("cat")!=null){
            String category = hSes.getAttribute("cat").toString();
            resp.sendRedirect("/OnlineOrder/viewitem.jsp?cat="+category);
            }else{
        resp.sendRedirect("/OnlineOrder/viewitem.jsp");
            }
    }

}
