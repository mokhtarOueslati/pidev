/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXINTERFACE;

import EDU.PI.MODEL.Profil;
import EDU.PI.MODEL.Randonnee;
import EDU.PI.MODEL.Randonnee_participant;
import EDU.PI.SERVICE.RandonneeService;
import EDU.PI.SERVICE.Randonnee_participantService;
import EDU.PI.SERVICE.RatingService;
import EDU.PI.SERVICE.testRating;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
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
    private DatePicker depart;
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
     
    public static String address;
   
    @FXML
    private TextField nbr_place;
    @FXML
    private TextField recherche;
    
    ObservableList<Randonnee> listRand = FXCollections.observableArrayList();
    @FXML
    private Slider S;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RandonneeService rs=new RandonneeService();
        try {
            listRand.addAll(rs.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilRandonneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                randoTable.setItems(listRand);
        try {
            setMainApp(mainApp);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        recherche.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterRandonneeList((String) oldValue, (String) newValue);
            }
        });
        
        randoTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
         NomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
         DescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
         DateDepartColumn.setCellValueFactory(cellData -> cellData.getValue().dateDepartProperty());
         DestinationColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
         
    }    
    
    private void filterRandonneeList(String oldValue, String newValue){
        ObservableList<Randonnee> filteredList = FXCollections.observableArrayList();
        if (recherche == null || (newValue.length() < oldValue.length()) || newValue == null) {
                randoTable.setItems(listRand);
        } else {
            newValue = newValue.toUpperCase();
            for (Randonnee rando : randoTable.getItems()) {
                String filterName = rando.getNom();
                String filterDestination = rando.getAddress_randonnee();
                if (filterName.toUpperCase().contains(newValue)/* || filterDestination.toUpperCase().contains(newValue)*/) {
                    filteredList.add(rando);
                }
            }
            randoTable.setItems(filteredList);
        }
    }

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
       RandonneeService Rs = new RandonneeService();
       Randonnee R = new Randonnee();
       R.setNom(nom.getText());
       R.setDescription(description.getText());
       R.setDate_depart(depart.getValue().toString());
       R.setAddress_randonnee(destination.getText());
       R.setNbrPlace(Integer.parseInt(nbr_place.getText()));
       Profil p = new Profil();
       R.setCreator(p);
       R.setGuide(p);
       Rs.insertRandonnee(R);
       randoTable.setItems(new RandonneeService().readAll());
       
       
    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        Randonnee rand = new Randonnee();
        rand = randoTable.getSelectionModel().getSelectedItem();
        RandonneeService rs = new RandonneeService();
        System.out.println(rand.getRandonnee_id());
        rs.deleteRandonnee(rand.getRandonnee_id());
        randoTable.setItems(new RandonneeService().readAll());
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
  //  boolean okClicked = mainApp.showMapEditDialog;
    
    }
    
    
     public void setMainApp(testajout mainApp) throws SQLException {
        this.mainApp = mainApp;
                
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
    private void Participer(ActionEvent event) throws SQLException {
        Randonnee r = new Randonnee();
        r = (Randonnee) randoTable.getSelectionModel().getSelectedItem();
        Profil p = new Profil();
        p.setProfil_id(2);
        new Randonnee_participantService().insertRandonnee_participant(new Randonnee_participant(p, r));
    }

    @FXML
    private void Rate(ActionEvent event) {
         Randonnee rand = new Randonnee();
        rand = randoTable.getSelectionModel().getSelectedItem();
        testRating RT = new testRating();
        RT.rateAction((int) S.getValue(), rand.getRandonnee_id());
        
        
       
        System.out.println(S.getValue());
        
    }

    
    
}
