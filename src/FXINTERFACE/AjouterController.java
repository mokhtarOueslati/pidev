/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXINTERFACE;

import EDU.PI.MODEL.Profil;
import EDU.PI.MODEL.Randonnee;
import EDU.PI.SERVICE.RandonneeService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mokhtar
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TextField depart;
    @FXML
    private TextField destination;
    @FXML
    private TextField creator;
    @FXML
    private TextField guide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
        RandonneeService Rs = new RandonneeService();
        Randonnee R = new Randonnee();
        R.setNom(nom.getText());
       R.setDescription(description.getText());
       R.setDate_depart(depart.getText());
       R.setAddress_randonnee(destination.getText());
       //R.setDate_depart(depart.get());
       
       Profil p = new Profil();
       R.setCreator(p);
       R.setGuide(p);
       Rs.insertRandonnee(R);
       
    }
        // TODO
    }    
    

