/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.SERVICE;
import EDU.PI.TECH.MyConnection;
import EDU.PI.MODEL.Randonnee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author mokhtar
 */
public class RandonneeService {
  public void insertRandonnee (Randonnee r) throws SQLException {
        String req ="insert into randonnee (nom,description,date_depart,creation_date,last_modification_date,address_randonnee,photo_profil_path,creator_id,guide_id,nbr_place) values (?,?,?,?,?,?,?,?,?,?)";
        
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ps.setString(1, r.getNom());
        ps.setString(2, r.getDescription());
        ps.setString(3, r.getDate_depart());
        ps.setDate(4, r.getCreation_date());
        ps.setDate(5, r.getLast_modification_date());
        ps.setString(6, r.getAddress_randonnee());
        ps.setString(7, r.getPhoto_profil_path());
        ps.setInt(8, r.getCreator().getProfil_id());
        ps.setInt(9, r.getGuide().getProfil_id());
        ps.setInt(10, r.getNbrPlace());
        ps.executeUpdate();
        }
        catch(SQLException e){
        e.printStackTrace();
        }
    }
    
 public ObservableList<Randonnee> readAll() throws SQLException {
        ObservableList<Randonnee> list = FXCollections.observableArrayList();
        String req ="select * from randonnee";
        ProfilService pser = new ProfilService();
        try{
            Statement statement =MyConnection.getInstance().createStatement();
            ResultSet resultat =  statement.executeQuery(req);
      
            while (resultat.next()){
                Randonnee r=new Randonnee();
                r.setRandonnee_id(resultat.getInt("randonnee_id"));
                r.setNom(resultat.getString("nom"));
                r.setDescription(resultat.getString("description"));
                r.setDate_depart(resultat.getString("date_depart"));
                r.setCreation_date(resultat.getDate("creation_date"));
                r.setLast_modification_date(resultat.getDate("last_modification_date"));
                r.setAddress_randonnee(resultat.getString("address_randonnee"));
                r.setPhoto_profil_path(resultat.getString("photo_profil_path"));
                r.setCreator(pser.FindById(resultat.getInt("creator_id")));
                r.setGuide(pser.FindById(resultat.getInt("guide_id")));
                list.add(r);
            }
            return list;
    
        }catch (SQLException e){
             e.printStackTrace();
            
        }
        return null;
    }
    
  
  
  
    public  void deleteRandonnee (int id ) throws SQLException{
        String req ="delete from randonnee where randonnee_id=?";

        try{
            PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("randonnee supprimé");
        }
        catch(SQLException ex){
            System.out.println("erreur lors de la suppression"+ ex.getMessage());
        }
    }
    
    public Randonnee FindById(int id) throws SQLException{
        Randonnee r = new Randonnee();
        String req ="select * from randonnee where randonnee_id ="+id+"";
        ProfilService pser = new ProfilService();
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ResultSet resultat =  ps.executeQuery(req);
        while(resultat.next()){
            r.setRandonnee_id(resultat.getInt("randonnee_id"));
            r.setNom(resultat.getString("nom"));
            r.setDescription(resultat.getString("description"));
            r.setDate_depart(resultat.getString("date_depart"));
            r.setCreation_date(resultat.getDate("creation_date"));
            r.setLast_modification_date(resultat.getDate("last_modification_date"));
            r.setAddress_randonnee(resultat.getString("address_randonnee"));
            r.setPhoto_profil_path(resultat.getString("photo_profil_path"));
            r.setCreator(pser.FindById(resultat.getInt("creator_id")));
            r.setGuide(pser.FindById(resultat.getInt("guide_id")));
        }
        }catch(SQLException ex){
            System.out.println("Aucun randonnee trouvé"+ ex.getMessage());
        }
        
        return r;
    }
    public  void updateRandonnee (Randonnee r ) throws SQLException{
        String req ="update randonnee SET nom = ? ,description = ? ,date_depart = ?,address_randonnee =? ,creator_id =? ,guide_id =? where randonnee_id=?";

        try{
            PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, r.getNom());
            ps.setString(2, r.getDescription());
            ps.setString(3, r.getDate_depart());
            ps.setString(4, r.getAddress_randonnee());
            ps.setInt(5, r.getCreator().getProfil_id());
             ps.setInt(6, r.getGuide().getProfil_id());
             ps.setInt(7, r.getRandonnee_id());
            ps.executeUpdate();
            System.out.println("Randonnee modifier");
        }
        catch(SQLException ex){
            System.out.println("erreur lors de la modification"+ ex.getMessage());
        }
    }
}

   
    

    
   


