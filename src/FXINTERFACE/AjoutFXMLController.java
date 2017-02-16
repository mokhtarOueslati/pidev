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
public class AjoutFXMLController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField decription;
    @FXML
    private TextField adress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
        RandonneeService Rs = new RandonneeService();
        Randonnee R = new Randonnee();
        R.setNom(nom.getText());
       R.setAddress_randonnee(adress.getText());
       R.setDescription(decription.getText());
       Profil p = new Profil();
       R.setCreator(p);
       R.setGuide(p);
       Rs.insertRandonnee(R);
       
    }
    
}
