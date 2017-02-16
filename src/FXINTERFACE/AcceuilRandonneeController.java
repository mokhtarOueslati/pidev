/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXINTERFACE;

import EDU.PI.MODEL.Profil;
import EDU.PI.MODEL.Randonnee;
import EDU.PI.SERVICE.RandonneeService;
import static FXINTERFACE.DisplayController.address;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mokhtar
 */
public class AcceuilRandonneeController implements Initializable {

    testajout mainApp;
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
    @FXML
    private TableView<Randonnee> randoTable;
    @FXML
    private TableColumn<Randonnee, String> NomColumn;
    @FXML
    private TableColumn<Randonnee, String> DescriptionColumn;
    @FXML
    private TableColumn<Randonnee, String> DateDepartColumn;
    @FXML
    private TableColumn<Randonnee, String> DestinationColumn;
    @FXML
    private TableColumn<Randonnee, String> CreatorColumn;
    @FXML
    private TableColumn<Randonnee, String> GuideColumn;
     
    public static String address;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setMainApp(mainApp);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayController.class.getName()).log(Level.SEVERE, null, ex);
        }
        randoTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
         NomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
         DescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
         DateDepartColumn.setCellValueFactory(cellData -> cellData.getValue().dateDepartProperty());
         DestinationColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
         //CreatorColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
         //GuideColumn.setCellValueFactory(cellData -> cellData.getValue().ContenuProperty());
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

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        Randonnee rand = new Randonnee();
        rand = randoTable.getSelectionModel().getSelectedItem();
        RandonneeService rs = new RandonneeService();
        System.out.println(rand.getRandonnee_id());
        rs.deleteRandonnee(rand.getRandonnee_id());
        setMainApp(mainApp);
    }

    @FXML
    private void localisation(ActionEvent event) throws IOException {
        Randonnee rand = new Randonnee();
        rand = randoTable.getSelectionModel().getSelectedItem();
        RandonneeService rs = new RandonneeService();
        
        address=rand.getAddress_randonnee();
        System.out.println(rand.getAddress_randonnee());
        address=rand.getAddress_randonnee();
        
        testajout.changeScene("Map.fxml");
    }
    
     public void setMainApp(testajout mainApp) throws SQLException {
        this.mainApp = mainApp;
                RandonneeService rs=new RandonneeService();
                randoTable.setItems(rs.readAll());
    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException {
        Randonnee selectedRandonnee = randoTable.getSelectionModel().getSelectedItem();
            boolean updateClicked = testajout.showRandonneDialog(selectedRandonnee);
        if (updateClicked) {
            RandonneeService rs = new RandonneeService();
            Randonnee r = new Randonnee();
            Profil p = new Profil();
            r = selectedRandonnee;
            r.setGuide(p);
            r.setCreator(p);
            rs.updateRandonnee(r);
            
        }
    }

    @FXML
    private void RechercherDestination(ActionEvent event) {
        
    }
}
