/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.MODEL;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mokhtar
 */


    
    
public class Randonnee {
    private int randonnee_id;
    private StringProperty nom;
    private StringProperty description;
    private StringProperty date_depart;
    private Date creation_date;
    private Date last_modification_date;
    private StringProperty address_randonnee;
    private String photo_profil_path;
    private Profil creator;
    private Profil guide;
    
    public Randonnee() {
        this(null,null,null,null,null,null,null,null,null);
    }

    public Randonnee(String nom, String description, String date_depart, Date creation_date, Date last_modification_date, String address_randonnee, String photo_profil_path, Profil creator, Profil guide) {
        this.nom = new SimpleStringProperty(nom);
        this.description = new SimpleStringProperty(description);
        this.date_depart = new SimpleStringProperty(date_depart);
        this.creation_date = creation_date;
        this.last_modification_date = last_modification_date;
        this.address_randonnee = new SimpleStringProperty(address_randonnee);
        this.photo_profil_path = photo_profil_path;
        this.creator = creator;
     
        this.guide = guide;
    }

    public int getRandonnee_id() {
        return randonnee_id;
    }
    
    public String getNom() {
        return nom.get();
    }
    public StringProperty nomProperty()
    {
        return nom;
    }
    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getDescription() {
        return description.get();
    }
    public StringProperty descriptionProperty()
    {
        return description;
    }
    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDate_depart() {
        return date_depart.get();
    }
    public StringProperty dateDepartProperty()
    {
        return date_depart;
    }
    public void setDate_depart(String date_depart) {
        this.date_depart.set(date_depart);
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getLast_modification_date() {
        return last_modification_date;
    }

    public void setLast_modification_date(Date last_modification_date) {
        this.last_modification_date = last_modification_date;
    }

    public String getAddress_randonnee() {
        return address_randonnee.get();
    }
    public StringProperty addressProperty()
    {
        return address_randonnee;
    }
    public void setAddress_randonnee(String address_randonnee) {
        this.address_randonnee.set(address_randonnee);
    }

    public String getPhoto_profil_path() {
        return photo_profil_path;
    }

    public void setPhoto_profil_path(String photo_profil_path) {
        this.photo_profil_path = photo_profil_path;
    }

    public Profil getCreator() {
        return creator;
    }

    public void setCreator(Profil creator) {
        this.creator = creator;
    }

    public Profil getGuide() {
        return guide;
    }

    public void setGuide(Profil guide) {
        this.guide = guide;
    }

    public void setRandonnee_id(int randonnee_id) {
        this.randonnee_id = randonnee_id;
    }

    @Override
    public String toString() {
        return "Randonnee{" + "randonnee_id=" + randonnee_id + ", nom=" + nom + ", description=" + description + ", date_depart=" + date_depart + ", creation_date=" + creation_date + ", last_modification_date=" + last_modification_date + ", address_randonnee=" + address_randonnee + ", photo_profil_path=" + photo_profil_path + ", creator=" + creator.toString() + ", guide=" + guide.toString() + '}';
    }
  
    
}
