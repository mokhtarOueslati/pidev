/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.SERVICE;

import EDU.PI.MODEL.Rate;
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

    public void insertRating(Rate r) throws SQLException {
        String req = "insert into isr_rating (id,average,total_count,count) values (?,?,?,?)";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, r.getId());
            ps.setFloat(2, r.getAverage());
            ps.setFloat(3, r.getTotalcount());
            ps.setInt(4, r.getCount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rating> readAll() throws SQLException {
        List<Rating> list = new ArrayList<>();
        String req = "select * from rating";
        RandonneeService rs = new RandonneeService();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(req);

            while (resultat.next()) {
                Rating r = new Rating();
                r.setRating_id(resultat.getInt("rating_id"));
                r.setRate(resultat.getInt("rate"));
                r.setRandonnee(rs.FindById(resultat.getInt("randonnee_id")));
                list.add(r);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void deleteRating(int id) throws SQLException {
        String req = "delete from rating where rating_id=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("rating supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression" + ex.getMessage());
        }
    }

    public Rate FindById(int id) throws SQLException {
        Rate r = new Rate();
        String req = "select * from isr_rating where id =" + id + "";
        ProfilService pser = new ProfilService();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ResultSet resultat = ps.executeQuery(req);
            while (resultat.next()) {
                r.setId(resultat.getInt("id"));
                r.setAverage(resultat.getFloat("average"));
                r.setTotalcount(resultat.getFloat("total_count"));
                r.setCount(resultat.getInt("count"));

            }
        } catch (SQLException ex) {
            System.out.println("Aucun randonnee trouvé" + ex.getMessage());
        }
        return r;
    }

    public void updateRating(Rate r) throws SQLException {
        String req = "update isr_rating set average=? , total_count=? ,count=? where id = ?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setFloat(1, r.getAverage());
            ps.setFloat(2, r.getTotalcount());
            ps.setInt(3, r.getCount());
            ps.setInt(4, r.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
