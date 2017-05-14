/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.SERVICE;

import EDU.PI.MODEL.Rate;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mokhtar
 */
public class testRating {

    public float rateAction(int star, int id) {
        Rate r = new Rate();
        int contentId = id;
        float score = (float) star;

        float average = 0;
        average = this.save(contentId, score);
        return average;
    }

    public float save(int contentId, float score) {

        Rate rating = new Rate();
        rating.setId(contentId);
        try {
            if (test(rating)) {
                rating = this.updateScore(contentId, score);
            } else {
                rating = this.saveNewScore(contentId, score);
            }
        } catch (SQLException ex) {}
        
        return rating.getAverage();
    }

    public float getAverage(int contentId) {
        try {
            return this.load(contentId).getAverage();
        } catch (Exception e) {
            return 0;
        }
    }

    public Rate saveNewScore(int contentId, float score) {
        if (score < 0 || score > 5) {
            System.out.println("must be between 0 and 5");
        }
        Rate rating = new Rate();
        rating.setId(contentId);
        rating.setCount(1);
        rating.setTotalcount(score);
        rating.setAverage(score);
        RatingService rs = new RatingService();
        try {
            rs.insertRating(rating);
        } catch (SQLException ex) {
        }
        return rating;
    }

    public Rate updateScore(int contentId, float score) throws SQLDataException {
        Rate rating = new Rate();
        rating = this.load(contentId);

        int count = rating.getCount() + 1;
        float totalCount = rating.getTotalcount() + score;
        float average = totalCount / count;

        rating.setCount(count);
        rating.setTotalcount(totalCount);
        rating.setAverage(average);
        RatingService rs = new RatingService();
        try {
            rs.updateRating(rating);
        } catch (SQLException ex) {
            Logger.getLogger(testRating.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rating;
    }

    public Rate load(int contentId) {
        RatingService rs = new RatingService();
        Rate rating = new Rate();
        try {
            rating = rs.FindById(contentId);
        } catch (SQLException ex) {
        }
        return rating;
    }

    public boolean test(Rate r) throws SQLException {
        Rate a = new RatingService().FindById(r.getId());
        return r.getId() == a.getId();
    }
}
