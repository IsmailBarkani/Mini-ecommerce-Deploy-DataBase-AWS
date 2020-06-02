package web.Controler;

import dao.ProduitDaoImpl;
import dao.entities.Produit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "eServlet",urlPatterns = {"/"})
public class ControleurServlet extends HttpServlet {

    ProduitDaoImpl metier;
    @Override
    public void init() throws ServletException {
         metier = new ProduitDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet(req,resp);
        String product = req.getParameter("product");
        ArrayList<Produit> produits = new ArrayList<>();
        try {
            produits = metier.chercherParMC(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("produits",produits);
        RequestDispatcher view = req.getRequestDispatcher("/liste.jsp");
        view.forward(req,resp);

    }


}
