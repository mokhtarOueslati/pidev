/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXINTERFACE;

import EDU.PI.MODEL.Randonnee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mokhtar
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TextField depart;
    @FXML
    private TextField destination;
    @FXML
    private ComboBox<?> creator;
    @FXML
    private ComboBox<?> guide;
    
    private Stage dialogStage;
    private Randonnee randonnee;
    private boolean updateClicked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setDialog(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    public void setRandonnee(Randonnee randonnee){
        this.randonnee =randonnee;
        nom.setText(randonnee.getNom());
        description.setText(randonnee.getDescription());
        depart.setText(randonnee.getDate_depart());
        destination.setText(randonnee.getAddress_randonnee());
    }
    
    public boolean updateClicked(){
        return updateClicked;
    }

    @FXML
    private void Update(ActionEvent event) {
        randonnee.setNom(nom.getText());
        randonnee.setDescription(description.getText());
        randonnee.setDate_depart(depart.getText());
        randonnee.setAddress_randonnee(destination.getText());
        
        updateClicked = true;
        dialogStage.close();
    }
    
}
