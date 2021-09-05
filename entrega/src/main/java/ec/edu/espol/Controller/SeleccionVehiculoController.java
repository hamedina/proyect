/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controller;

import com.edu.espol.entrega.App;
import ec.edu.espol.funciones.Sistema;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SeleccionVehiculoController implements Initializable {

    @FXML
    private CheckBox auto;
    @FXML
    private CheckBox moto;
    @FXML
    private CheckBox camioneta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Aceptar(ActionEvent event) throws IOException {
    
    
         if(auto.isSelected()&& !camioneta.isSelected() &&!moto.isSelected()){
         
           FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "auto" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage(); 
        
        stage.setTitle("AUTO");
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.setScene(new Scene(root));  
        stage.show(); 
         
         }
    
         else if(camioneta.isSelected()&&!moto.isSelected() && !auto.isSelected()){
         
           FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "camioneta" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage(); 
        
        stage.setTitle("CAMIONETA");
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.setScene(new Scene(root));  
        stage.show(); 
         }
         
         
          else if(moto.isSelected()&&  !camioneta.isSelected()   && !auto.isSelected()){
         
           FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "moto" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage(); 
        
        stage.setTitle("MOTO");
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.setScene(new Scene(root));  
        stage.show(); 
 
        }
         
          
         else if(moto.isSelected()&&camioneta.isSelected()&&auto.isSelected()){
         
             Sistema.showMessage(new Alert(Alert.AlertType.ERROR),"Registro de vehiculo",null,"SOLO  SELECCIONA UNO POR FAVOR!!!!"); 
         }  
          
          
         else if(!moto.isSelected()&&!camioneta.isSelected()&&!auto.isSelected()){
                
             Sistema.showMessage(new Alert(Alert.AlertType.ERROR),"Registro de vehiculo",null,"SELECCIONA UNO POR FAVOR!!!!");   
                
                
                } 
         
         
}
}