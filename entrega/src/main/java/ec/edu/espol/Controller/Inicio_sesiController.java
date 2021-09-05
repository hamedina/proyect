/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controller;

import com.edu.espol.entrega.App;
import ec.edu.espol.funciones.Sistema;
import ec.edu.espol.model.Personas;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Inicio_sesiController implements Initializable {

    @FXML
    private TextField ingresousuario;
    @FXML
    private PasswordField ingroscontrasena;

    Personas  persona;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ingroscontrasena.setTextFormatter(new TextFormatter<>(condicion -> (condicion.getControlNewText().matches("\\w{0,15}"))? condicion: null ));
    }    
    
    
    
    
    public void regresar(MouseEvent event) throws IOException{
        App.setRoot("inicio_sesi");
    }
    
    
    
     private void asignarOpcion()
    {
        try
        {            
            System.out.println("Se crea panel principal");
            //Muestra la pantalla del Menu Principal            
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu" + ".fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();  
            MenuController controlador = fxmlLoader.<MenuController>getController();                                
            controlador.cargarMenuTipoPersona(persona,false);
            stage.setTitle("Menu Principal");
            stage.setMaxWidth(800);
            stage.setMaxHeight(600);
            stage.setScene(new Scene(root));  
            stage.show(); 
            
            Stage stageActual = (Stage) ingresousuario.getScene().getWindow();            
            stageActual.close();                       
        }
        catch(Exception e)
        {
                       
        }                
    }        
    
     
     @FXML
    private void registrarUsuario(ActionEvent event) throws IOException {
        App.setRoot("registrarUsuarios");
    
    }
    
     
    
    @FXML
    private void iniciarSesion(ActionEvent event) {
    try
        {            
            String usuario = ingresousuario.getText().trim();
            String con = ingroscontrasena.getText().trim();            
            if(Sistema.verificarExistencia(usuario,con))          
            {
                Sistema.showMessage(new Alert(Alert.AlertType.INFORMATION), "Sesión", "Sesión iniciada", "Los datos fueron correctamente cargados");                
                persona = Sistema.obtenerPersona(usuario, con);
                System.out.println("Persona iniciar sesion=>"+persona.getUsuario());
                if(persona != null)                                    
                    asignarOpcion();
                else                   
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "No existe un usuario con esos datos.\nIngrese correctamente los datos");
            }
            else
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "No existe un usuario con esos datos.\nIngrese correctamente los datos");
        }
        catch(Exception e)
        {
            Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "ERROR EN EL SISTEMA");
        }     
    }
    
    
    
             
          
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    }

   
    
