/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.MODEL;

/**
 *
 * @author mokhtar
 */
public class Rating {
    private int rating_id;
    private int rate;
    private Randonnee randonnee;

    public Rating() {
    }

    public Rating(int rate, Randonnee randonnee) {
        this.rate = rate;
        this.randonnee = randonnee;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Randonnee getRandonnee() {
        return randonnee;
    }

    public void setRandonnee(Randonnee randonnee) {
        this.randonnee = randonnee;
    }

    @Override
    public String toString() {
        return "Rating{" + "rating_id=" + rating_id + ", rate=" + rate + ", randonnee=" + randonnee.toString() + '}';
    }
    
    
}
    
