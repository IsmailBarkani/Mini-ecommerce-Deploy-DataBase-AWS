package web.Controler;

import dao.ProduitDaoImpl;
import dao.entities.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String path = req.getServletPath();
        if(path.equals("/chercher")){
            ArrayList<Produit> produits;
            String mc = req.getParameter("MotClet");
            try {
                produits = metier.chercherParMC(mc);
                req.setAttribute("produits",produits);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(path.equals("/save")){
            Produit p = new Produit();
            p.setDesignation(req.getParameter("designation"));
            p.setPrix(Double.parseDouble( req.getParameter("prix")));
            p.setQuantite(Integer.parseInt(req.getParameter("quantite")));

            try {
                p = metier.save(p);
                req.setAttribute("id",p.getId());
                req.getRequestDispatcher("confirmation.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
