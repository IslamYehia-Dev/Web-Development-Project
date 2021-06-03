/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;

/**
 *             <input type="hidden" name="order_id" value="<%=bill_No %>">
                    <input type="hidden" name="prod_id" value="<%=prod_Id %>">
                     <input type="hidden" name="user_name" value="<%=curUser.uname %>">
                    <input type="hidden" name="user_id" value="<%=curUser.id %>">
 * @author eslam
 */
public class addreviewtodb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //viewCustomerOrders.jsp
    if(req.getParameter("review")!=null && req.getParameter("order_id")!=null && req.getParameter("prod_id")!=null && req.getParameter("user_name")!=null &&req.getParameter("user_id")!=null)
    {

        Map<String , Object> myFeedback = new HashMap<String, Object>();
        
        myFeedback.put("order_id", Integer.parseInt(req.getParameter("order_id"))); 
        myFeedback.put("prod_id", Integer.parseInt(req.getParameter("prod_id")));
        myFeedback.put("user_id", Integer.parseInt(req.getParameter("user_id"))); 
        myFeedback.put("user_name", req.getParameter("user_name"));
        myFeedback.put("review", req.getParameter("review"));
        myFeedback.put("review_date", LocalDate.now().toString());
        DataBaseConnector.coll.insertOne(new Document(myFeedback));
    }
            resp.sendRedirect("viewCustomerOrders.jsp");

    }

  
}
