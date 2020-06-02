package dao;

import dao.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduitDaoImpl implements IProduitDao {


    @Override
    public Produit save(Produit p) throws SQLException {
        Connection con = new SingletonConnection().getMyConnection();

        PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUIT VALUE (?,?,?)");
        ps.setString(1,p.getDesignation());
        ps.setDouble(2,p.getPrix());
        ps.setInt(3,p.getQuantite());
        ps.executeUpdate();

        PreparedStatement ps2 = con.prepareStatement("SELECT MAX(ID) as max_id FROM PRODUIT");
        ResultSet rs = ps2.executeQuery();
        if(rs.next()) p.setId(rs.getLong("id"));

        return p;
    }

    @Override
    public ArrayList<Produit> chercherParMC(String mc) throws SQLException {
        ArrayList<Produit> produits = new ArrayList<Produit>();
        Connection con = new SingletonConnection().getMyConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUIT WHERE DESIGNATION LIKE ?");
        ps.setString(1,"%"+mc+"%");

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Produit p = new Produit();
            p.setId(rs.getLong("id"));
            p.setQuantite(rs.getInt("quantite"));
            p.setPrix(rs.getDouble("prix"));
            p.setDesignation(rs.getString("designation"));

            produits.add(p);
        }


        return produits;
    }
}
