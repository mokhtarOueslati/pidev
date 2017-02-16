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
public class User {
     private int user_id;
    private String email;
    private String user_pass;
    private Date creation_date;
    private Date last_modification_date;
    private int role;

    public User() {
    }

    public User(String email, String user_pass, Date creation_date, Date last_modification_date, int role) {
        this.email = email;
        this.user_pass = user_pass;
        this.creation_date = creation_date;
        this.last_modification_date = last_modification_date;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", email=" + email + ", user_pass=" + user_pass + ", creation_date=" + creation_date + ", last_modification_date=" + last_modification_date + ", role=" + role + '}';
    }
    
    
}
    

