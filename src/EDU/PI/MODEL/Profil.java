/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.MODEL;

import java.sql.Date;

/**
 *
 * @author mokhtar
 */

    
    public class Profil {
    private int profil_id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Date date_naic;
    private String description;
    private boolean guide;
    private String travail;
    private Date creation_date;
    private Date last_modification_date;
    private String photo_profil_path;
    private String address;
    private User user;
    private String sexe;

    public Profil() {
    }

    public Profil(String nom, String prenom, String email, String tel, Date date_naic, String description, boolean guide, String travail, Date creation_date, Date last_modification_date, String photo_profil_path, String address, User user, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.date_naic = date_naic;
        this.description = description;
        this.guide = guide;
        this.travail = travail;
        this.creation_date = creation_date;
        this.last_modification_date = last_modification_date;
        this.photo_profil_path = photo_profil_path;
        this.address = address;
        this.user = user;
        this.sexe = sexe;
    }

    public int getProfil_id() {
        return profil_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDate_naic() {
        return date_naic;
    }

    public void setDate_naic(Date date_naic) {
        this.date_naic = date_naic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGuide() {
        return guide;
    }

    public void setGuide(boolean guide) {
        this.guide = guide;
    }

    public String getTravail() {
        return travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
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

    public String getPhoto_profil_path() {
        return photo_profil_path;
    }

    public void setPhoto_profil_path(String photo_profil_path) {
        this.photo_profil_path = photo_profil_path;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser_id(User user) {
        this.user = user;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setProfil_id(int profil_id) {
        this.profil_id = profil_id;
    }

    @Override
    public String toString() {
        return "Profil{" + "profil_id=" + profil_id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + ", date_naic=" + date_naic + ", description=" + description + ", guide=" + guide + ", travail=" + travail + ", creation_date=" + creation_date + ", last_modification_date=" + last_modification_date + ", photo_profil_path=" + photo_profil_path + ", address=" + address + ", user=" + user.toString() + ", sexe=" + sexe + '}';
    }
}
    
    
    


