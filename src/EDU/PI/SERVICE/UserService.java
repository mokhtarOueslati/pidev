/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.SERVICE;

import EDU.PI.MODEL.User;
import EDU.PI.TECH.MyConnection;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author mokhtar
 */
public class UserService {
     public void insertUser (User u) throws SQLException {
        String req ="insert into user (email,user_pass,creation_date,last_modification_date,role) values (?,?,?,?,?)";
        
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ps.setString(1, u.getEmail());
        ps.setString(2, u.getUser_pass());
        ps.setDate(3, u.getCreation_date());
        ps.setDate(4, u.getLast_modification_date());
        ps.setInt(5, u.getRole());
        ps.executeUpdate();
        }
        catch(SQLException e){
        e.printStackTrace();
        }
    }
    
    public ArrayList<User> readAll() throws SQLException {
      
      
        ArrayList<User> list = new ArrayList<>();
        
        String req ="select * from user";
        
        try{
            Statement statement =MyConnection.getInstance().createStatement();
            ResultSet resultat =  statement.executeQuery(req);
      
            while (resultat.next()){
                User r=new User();
                r.setUser_id(resultat.getInt("user_id"));
                r.setEmail(resultat.getString("email"));
                r.setUser_pass(resultat.getString("user_pass"));
                r.setCreation_date(resultat.getDate("creation_date"));
                r.setLast_modification_date(resultat.getDate("last_modification_date"));
                r.setRole(resultat.getInt("role"));
                list.add(r);
            }
            return list;
    
        }catch (SQLException e){
             e.printStackTrace();
            
        }
        return null;
    }
    
    public  void deleteUser (int id ) throws SQLException{
        String req ="delete from User where user_id=?";

        try{
            PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("user supprimé");
        }
        catch(SQLException ex){
            System.out.println("erreur lors de la suppression"+ ex.getMessage());
        }
    }
    
    public User FindById(int id) throws SQLException{
        User u = new User();
        String req ="select * from user where user_id ="+id+"";
        UserService us = new UserService();
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ResultSet resultat =  ps.executeQuery(req);
        while(resultat.next()){
            u.setUser_id(resultat.getInt("user_id"));
            u.setEmail(resultat.getString("email"));
            u.setUser_pass(resultat.getString("user_pass"));
            u.setCreation_date(resultat.getDate("creation_date"));
            u.setLast_modification_date(resultat.getDate("last_modification_date"));
            u.setRole(resultat.getInt("role"));
        }
        }catch(SQLException ex){
            System.out.println("Aucun profil trouvé"+ ex.getMessage());
        }
        
        return u;
    }

    private static class list<T> {

        public list() {
        }
    }
}
    

