package ru.gb.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductsServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("New Products Request");

        Product[] products = {
                new Product(1, "Bread", 0.5F),
                new Product(2, "Milk", 1.5F),
                new Product(3, "Beef", 4.5F),
                new Product(4, "Chicken", 2.5F),
                new Product(5, "Coke-Cola", 1.5F),
                new Product(6, "Still Water", 0.6F),
                new Product(7, "Lays", 1F),
                new Product(8, "Potatoes", 0.8F),
                new Product(9, "Salami", 4.3F),
                new Product(10, "Cheese", 2.1F),

        };

        String tableStyle = "style=\"border: 1px solid black; border-collapse: collapse;\"";

        resp.getWriter().print(
                "<table " + tableStyle + ">\n" +
                        "  <tr>\n" +
                        "    <th " + tableStyle + ">ID</th>\n" +
                        "    <th " + tableStyle + ">Title</th>\n" +
                        "    <th " + tableStyle + ">Cost</th>\n" +
                        "  </tr>"
        );

        for (Product product : products) {
            resp.getWriter().print(
                    "<tr>\n" +
                            "<td " + tableStyle + ">" + product.getId() + "</td>\n" +
                            "<td " + tableStyle + ">" + product.getTitle() + "</td>\n" +
                            "<td " + tableStyle + ">" + product.getCost() + "</td>\n" +
                            "</tr>"
            );
        }
        resp.getWriter().print("</table>");

    }
}
