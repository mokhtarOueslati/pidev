/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXINTERFACE;
import EDU.PI.MODEL.Randonnee;
import EDU.PI.SERVICE.RandonneeService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author mokhtar
 */

public class DisplayController implements Initializable{

    
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

    testajout mainApp;
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
    public void setMainApp(testajout mainApp) throws SQLException {
        this.mainApp = mainApp;
                RandonneeService rs=new RandonneeService();
                randoTable.setItems(rs.readAll());
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
    private void localisation(ActionEvent event) throws SQLException, IOException{
        
        Randonnee rand = new Randonnee();
        rand = randoTable.getSelectionModel().getSelectedItem();
        RandonneeService rs = new RandonneeService();
        
        
        address=rand.getAddress_randonnee();
        System.out.println(rand.getAddress_randonnee());
        address=rand.getAddress_randonnee();
        
        testajout.changeScene("Map.fxml");
        
         
        
       // rs.deleteRandonnee(rand.getRandonnee_id());
        //setMainApp(mainApp);
    }
    
}
