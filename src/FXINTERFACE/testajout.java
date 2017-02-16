/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXINTERFACE;

import EDU.PI.MODEL.Randonnee;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Mokhtar
 */
public class testajout extends Application {

    public static StringProperty address = new SimpleStringProperty();
    
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//FXMLLoader Loader = new FXMLLoader();
//Loader.setLocation(testajout.class.getResource("Ajouter.fxml"));
//        AnchorPane Ajouter = (AnchorPane)Loader.load();
//        Scene scene = new Scene(Ajouter);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//       
//        
//    }
//    
//    public static void main(String[] args) {
//        launch(args);
//    }
    // pour afficher :

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        changeScene("AcceuilRandonnee.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

    // pour l'api'
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//FXMLLoader Loader = new FXMLLoader();
//Loader.setLocation(testajout.class.getResource("Map.fxml"));
//        AnchorPane Ajouter = (AnchorPane)Loader.load();
//        Scene scene = new Scene(Ajouter);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//       
//        
//    }
//    
//    public static void main(String[] args) {
//        launch(args);
    // }
    public static void changeScene(String fxmlFile) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(testajout.class.getResource(fxmlFile));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static boolean showRandonneDialog(Randonnee randonnee){
        
        try {
            FXMLLoader loader = new FXMLLoader();
        loader.setLocation(testajout.class.getResource("Modifier.fxml"));
        AnchorPane page;
            page = (AnchorPane) loader.load();
             Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Randonnee");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        ModifierController controller = loader.getController();
        controller.setDialog(dialogStage);
        controller.setRandonnee(randonnee);
        
        dialogStage.showAndWait();
        return controller.updateClicked();
        } catch (IOException ex) {
            Logger.getLogger(testajout.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
        
    }
}
