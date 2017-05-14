/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.SERVICE;

import EDU.PI.MODEL.Randonnee_participant;
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
public class Randonnee_participantService {
     public void insertRandonnee_participant (Randonnee_participant r) throws SQLException {
        String req ="insert into randonnee_participant (profil_id,randonnee_id) values (?,?)";
        
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ps.setInt(1, r.getProfil().getProfil_id());
        ps.setInt(2, r.getRandonnee().getRandonnee_id());
        ps.executeUpdate();
        }
        catch(SQLException e){
        e.printStackTrace();
        }
    }
    
    public List<Randonnee_participant> readAll() throws SQLException {
        List<Randonnee_participant> list =new ArrayList<>();
        String req ="select * from randonnee_participant";
        ProfilService pser = new ProfilService();
        RandonneeService fser= new RandonneeService();
        try{
            Statement statement =MyConnection.getInstance().createStatement();
            ResultSet resultat =  statement.executeQuery(req);
      
            while (resultat.next()){
                Randonnee_participant r=new Randonnee_participant();
                r.setRandonnee(fser.FindById(resultat.getInt("randonnee_id")));
                r.setProfil(pser.FindById(resultat.getInt("profil_id")));
                list.add(r);
            }
            return list;
    
        }catch (SQLException e){
             e.printStackTrace();
            
        }
        return null;
    }
    
    public  void deleteRandonnee_participant (int randonnee_id,int profil_id ) throws SQLException{
        String req ="delete from randonnee_participant where randonnee_id=? AND profil_id=?";

        try{
            PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, randonnee_id);
            ps.setInt(2, profil_id);
            ps.executeUpdate();
            System.out.println("randonnee participat supprimé");
        }
        catch(SQLException ex){
            System.out.println("erreur lors de la suppression"+ ex.getMessage());
        }
    }
    
    public Randonnee_participant FindById(int randonnee_id,int profil_id) throws SQLException{
        Randonnee_participant r = new Randonnee_participant();
        String req ="select * from randonnee_participant where randonnee_id ="+randonnee_id+" AND profil_id="+profil_id;
        ProfilService pser = new ProfilService();
        RandonneeService fser= new RandonneeService();
        try{
        PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
        ResultSet resultat =  ps.executeQuery(req);
        while(resultat.next()){
            r.setRandonnee(fser.FindById(resultat.getInt("randonnee_id")));
            r.setProfil(pser.FindById(resultat.getInt("profil_id")));
        }
        }catch(SQLException ex){
            System.out.println("Aucun participant trouvé"+ ex.getMessage());
        }
        
        return r;
    }
    
}
