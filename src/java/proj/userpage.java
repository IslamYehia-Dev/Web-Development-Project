import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userpage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userheader.html");
        requestDispatcher.include(req, resp);

        try {
            Statement smt = com.db.dbconnection.con.createStatement();
            String sql = "select * from item ;";
            ResultSet item = smt.executeQuery(sql);

            while (item.next()) {
                String imagePath = item.getString("img");
                String Name = item.getString("name");
                Double Price = item.getDouble("price");
                //out.println("<html><img src=\""+imagePath+"\" width=\"200px\" height=\"200px\"></html>");
                //out.println(item.getString("name"));
                out.println("<html>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <form style=\"border:5px; border-color: black; border-style: solid; display: inline-block;\">\n"
                        + "        <img src=\"" + imagePath + "\"\" width=\"200px\" height=\"200px\">\n"
                        + "        <br>\n"
                        + " PName:  <p style=\"display: inline-block;\">"+Name+"</p><br>\n"
                        + " price:  <p style=\"display: inline-block;\">"+Price+"</p><br>\n"        
                        + "        <input type=\"submit\" value=\"Add to cart\">\n"
                        + "    </form>\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("/userfooter.html");
        requestDispatcher1.include(req, resp);

    }
}
