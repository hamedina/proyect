/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controller;

import com.edu.espol.entrega.App;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Personas;
import ec.edu.espol.model.TipoPersona;
import ec.edu.espol.model.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MenuController implements Initializable {

    @FXML
    private Label regresar;
    @FXML
    private MenuItem registrarVendedor;
    @FXML
    private MenuItem IngresarVehiculo;
    @FXML
    private MenuItem AceptarOferta;
    @FXML
    private MenuItem RegistrarComprador;
    @FXML
    private MenuItem OfertarVehiculo;

    private   TipoPersona tipoPersona; 
    private Personas persona;
    private Vendedor vendedor;
    private Comprador comprador;
    @FXML
    private Menu menuOpciones;
    @FXML
    private MenuItem perfil;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
    
    
    
    @FXML
    private void salir(ActionEvent event) {
            System.exit(0);
    
    }
        
    

    @FXML//(cuando  se cliekea sesion)
    private void regresar_sesion(ActionEvent event) {
         try
        {                        
            //Muestra la pantalla del Menu Principal            
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("inicio_sesi" + ".fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage(); 
            stage.setTitle("sesi1");
            stage.setMaxWidth(800);
            stage.setMaxHeight(600);
            stage.setScene(new Scene(root));  
            stage.show(); 
            
            Stage stageActual = (Stage) regresar.getScene().getWindow();            
            stageActual.close();                       
        }
        catch(Exception e)
        {
                       
        }  
    }
    
    
    
     public void cargarMenuTipoPersona(Personas p,boolean mostrarPlano)
    {   
        persona = p;
        menuOpciones.setVisible(true);
        perfil.setVisible(false);
        registrarVendedor.setVisible(false);
        IngresarVehiculo.setVisible(false);
        AceptarOferta.setVisible(false);
        RegistrarComprador.setVisible(false);
        OfertarVehiculo.setVisible(false);

      
        
        if(persona.getTipo().equals(TipoPersona.Comprador))
        {
            RegistrarComprador.setVisible(true);
            OfertarVehiculo.setVisible(true);
            perfil.setVisible(true);
        }
        else if (persona.getTipo().equals(TipoPersona.Vendedor))  {         
            registrarVendedor.setVisible(true);
            IngresarVehiculo.setVisible(true);
            AceptarOferta.setVisible(true);
            perfil.setVisible(true);
        }             
        else{
               registrarVendedor.setVisible(true);
               IngresarVehiculo.setVisible(true);
               AceptarOferta.setVisible(true);
               RegistrarComprador.setVisible(true);
               OfertarVehiculo.setVisible(true); 
                perfil.setVisible(true);
                }
    
    
    
    
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    

    

    @FXML
    private void RegistrarVendedor(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("registrarVendedor" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();  
        stage.setTitle("Vendedores");
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.setScene(new Scene(root));  
        stage.show(); 
         
    }
    
    
    
   
    
     @FXML
    private void RegistrarComprador(ActionEvent event) throws IOException {
       
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "registarCompradores" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage(); 
        
        stage.setTitle("Compradores");
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.setScene(new Scene(root));  
        stage.show(); 
               
                
    
    }

    @FXML
    private void IngresarVehiculo(ActionEvent event) throws IOException {
    
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "seleccionVehiculo" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage(); 
        
        stage.setTitle("TIPO-VEHICULO");
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.setScene(new Scene(root));  
        stage.show(); 
    
    
    
    
    
   
    
    
    
    
    
    
    
    }
    
    
    

    @FXML//comprador
    private void AceptarOferta(ActionEvent event) throws IOException {
         
    
    
    
    
    
    
    }

   
    @FXML
    private void OfertarVehiculo(ActionEvent event) throws IOException {
    
    
    
    
    
    
    
    
    }

    @FXML
    private void perfil(ActionEvent event) throws IOException {
    
     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "perfil" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage(); 
        
        stage.setTitle("Perfil");
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.setScene(new Scene(root));  
        stage.show(); 
    
    
    
    
    
    
    }
    



    
}