/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.SERVICE;

import EDU.PI.MODEL.Profil;
import EDU.PI.TECH.MyConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mokhtar
 */
public class ProfilService {
      public void insertProfil (Profil p) throws SQLException {
        String req ="insert into Profil (nom,prenom,email,tel,date_naic,description,guide,travail,creation_date,last_modification_date,photo_profil_path,address,user_id,sexe) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
        PreparedStatement ps =(PreparedStatement) MyConnection.getInstance().prepareStatement(req);
        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getTel());
        ps.setDate(5, p.getDate_naic());
        ps.setString(6, p.getDescription());
        ps.setBoolean(7, p.isGuide());
        ps.setString(8, p.getTravail());
        ps.setDate(9, p.getCreation_date());
        ps.setDate(10, p.getLast_modification_date());
        ps.setString(11, p.getPhoto_profil_path());
        ps.setString(12, p.getAddress());
        ps.setInt(13, p.getUser().getUser_id());
        ps.setString(14, p.getSexe());
        ps.executeUpdate();
        }
        catch(SQLException e){
        e.printStackTrace();
        }
    }
    
    public List<Profil> readAll() throws SQLException {
        List<Profil> list =new ArrayList<>();
        String req ="select * from profil ";
        UserService us = new UserService();
        try{
            Statement statement =MyConnection.getInstance().createStatement();
            ResultSet resultat =  statement.executeQuery(req);
      
            while (resultat.next()){
                Profil p=new Profil();
                p.setProfil_id(resultat.getInt("profil_id"));
                p.setNom(resultat.getString("nom"));
                p.setPrenom(resultat.getString("prenom"));
                p.setEmail(resultat.getString("email"));
                p.setTel(resultat.getString("tel"));
                p.setDate_naic(resultat.getDate("date_naic"));
                p.setDescription(resultat.getString("description"));
                p.setGuide(resultat.getBoolean("guide"));
                p.setTravail(resultat.getString("travail"));
                p.setCreation_date(resultat.getDate("creation_date"));
                p.setLast_modification_date(resultat.getDate("last_modification_date"));
                p.setPhoto_profil_path(resultat.getString("photo_profil_path"));
                p.setAddress(resultat.getString("address"));
                p.setUser_id(us.FindById(resultat.getInt("user_id")));
                p.setSexe(resultat.getString("sexe"));
                list.add(p);
            }
            return list;
    
        }catch (SQLException e){
             e.printStackTrace();
            
        }
        return null;
    }
    
    public  void deleteProfil (int id ) throws SQLException{
        String req ="delete from profil where profil_id=?";

        try{
            PreparedStatement ps =(PreparedStatement) MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("profil supprimé");
        }
        catch(SQLException ex){
            System.out.println("erreur lors de la suppression"+ ex.getMessage());
        }
    }
    
    public Profil FindById(int id) throws SQLException{
        Profil p = new Profil();
        String req ="select * from profil where profil_id ="+id+"";
        UserService us = new UserService();
        try{
        PreparedStatement ps =(PreparedStatement) MyConnection.getInstance().prepareStatement(req);
        ResultSet resultat =  ps.executeQuery(req);
        while(resultat.next()){
            p.setProfil_id(resultat.getInt("profil_id"));
            p.setNom(resultat.getString("nom"));
            p.setPrenom(resultat.getString("prenom"));
            p.setEmail(resultat.getString("email"));
            p.setTel(resultat.getString("tel"));
            p.setDate_naic(resultat.getDate("date_naic"));
            p.setDescription(resultat.getString("description"));
            p.setGuide(resultat.getBoolean("guide"));
            p.setTravail(resultat.getString("travail"));
            p.setCreation_date(resultat.getDate("creation_date"));
            p.setLast_modification_date(resultat.getDate("last_modification_date"));
            p.setPhoto_profil_path(resultat.getString("photo_profil_path"));
            p.setAddress(resultat.getString("address"));
            p.setUser_id(us.FindById(resultat.getInt("user_id")));
            p.setSexe(resultat.getString("sexe"));
        }
        }catch(SQLException ex){
            System.out.println("Aucun profil trouvé"+ ex.getMessage());
        }
        
        return p;
    }

   
        
}
    

