/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev;

import EDU.PI.MODEL.Profil;
import EDU.PI.MODEL.Randonnee;
import EDU.PI.MODEL.Rating;
import EDU.PI.MODEL.User;
import EDU.PI.SERVICE.ProfilService;
import EDU.PI.SERVICE.RandonneeService;
import EDU.PI.SERVICE.RatingService;
import EDU.PI.TECH.MyConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mokhtar
 */
public class PI_DEV {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection con =(Connection) MyConnection.getInstance();
       // Profil p = new Profil();
        //ProfilService ps = new ProfilService();
        //ps.insertProfil(p);
        User u = new User("hdfs","fds",null,null,1);
        Profil p1 = new Profil("jhdfs","fdsjk","jhdfs@dsfds","56367623",null,"khdfs",true,"kjdfs",null,null,"kjdfs","fdskjhd",u,"hjdfsd");
        Profil p2 = new Profil("jhdfs","fdsjk","jhdfs@dsfds","56367623",null,"khdfs",true,"kjdfs",null,null,"kjdfs","fdskjhd",u,"hjdfsd");
        Randonnee R = new Randonnee("hdgzd","dshjfsdf", null,null,null,"cdsdfdsfs","jkdfds", p1, p2,1);
        R.setRandonnee_id(26);
        RandonneeService rs = new RandonneeService();
       // rs.updateRandonnee(R);
        //Rating r =new Rating(1,R);
        //RatingService rsev  =new RatingService();
       //rsev.insertRating(r);
        //rsev.deleteRandonnee(9);
        rs.readAll();
        //rsev.FindById(1);
       //rsev.ModifierRandonne(r);
        //System.out.println("hh");
    }
    }
    
