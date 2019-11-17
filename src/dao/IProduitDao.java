package dao;

import dao.entities.Produit;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProduitDao {

    public Produit save(Produit p)throws SQLException;
    public ArrayList<Produit> chercherParMC(String mc)throws SQLException;


}
