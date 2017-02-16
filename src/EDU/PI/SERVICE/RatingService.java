/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.SERVICE;

import EDU.PI.MODEL.Rating;
import EDU.PI.TECH.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mokhtar
 */
public class RatingService {
     public void insertRating (Rating r) throws SQLException {
        String req ="insert into Rating (rate,randonnee_id) values (?,?)";
        
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ps.setInt(1, r.getRate());
        ps.setInt(2, r.getRandonnee().getRandonnee_id());
        ps.executeUpdate();
        }
        catch(SQLException e){
        e.printStackTrace();
        }
    }
    
    public List<Rating> readAll() throws SQLException {
        List<Rating> list =new ArrayList<>();
        String req ="select * from rating";
        RandonneeService rs= new RandonneeService();
        try{
            Statement statement =MyConnection.getInstance().createStatement();
            ResultSet resultat =  statement.executeQuery(req);
      
            while (resultat.next()){
                Rating r=new Rating();
                r.setRating_id(resultat.getInt("rating_id"));
                r.setRate(resultat.getInt("rate"));
                r.setRandonnee(rs.FindById(resultat.getInt("randonnee_id")));
                list.add(r);
            }
            return list;
    
        }catch (SQLException e){
             e.printStackTrace();
            
        }
        return null;
    }
    
    public  void deleteRating (int id ) throws SQLException{
        String req ="delete from rating where rating_id=?";

        try{
            PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("rating supprimé");
        }
        catch(SQLException ex){
            System.out.println("erreur lors de la suppression"+ ex.getMessage());
        }
    }
    
    public Rating FindById(int id) throws SQLException{
        Rating r = new Rating();
        String req ="select * from rating where rating_id ="+id+"";
        RandonneeService rs= new RandonneeService();
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ResultSet resultat =  ps.executeQuery(req);
        while(resultat.next()){
            r.setRating_id(resultat.getInt("rating_id"));
            r.setRate(resultat.getInt("rate"));
            r.setRandonnee(rs.FindById(resultat.getInt("randonnee_id")));
        }
        }catch(SQLException ex){
            System.out.println("Aucun status trouvé"+ ex.getMessage());
        }
        
        return r;
    }
}
    

