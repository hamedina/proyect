/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controller;

import com.edu.espol.entrega.App;
import ec.edu.espol.funciones.Sistema;
import ec.edu.espol.model.Personas;
import ec.edu.espol.model.TipoPersona;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RegistarCompradoresController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField usuario;
    @FXML
    private TextField contrasena;
    @FXML
    private TextField correo;
    @FXML
    private CheckBox comprador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
   
    
    
    
    
    @FXML
    private void registrar(MouseEvent event) throws Exception {
     String nombres = nombre.getText().trim();
            String apellido = apellidos.getText().trim();
            String usuarios = usuario.getText().trim();
            String clave = contrasena.getText().trim();
            String co = correo.getText().trim();
             TipoPersona tipo = TipoPersona.Comprador;
             
             
            if(comprador.isSelected()){
                    tipo = TipoPersona.Comprador; 
                    Personas per = new Personas(nombres,apellido,co,usuarios,clave,tipo);                    
                
                //Validar que el empleado no exista
                boolean verificarPersona = Sistema.verificarExistenciaPersona(per);
                if(verificarPersona)
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR),"Creación de cuenta",null,"Correo ya se encuentra registrado!!!!");                                                
                else{
                per.guardarPersonas(per);
                
                  
                }}
            
            else{
                
            Sistema.showMessage(new Alert(Alert.AlertType.ERROR),"Creación de cuenta",null,"Debe seleccionarla por favor!!!!");
            }
    }

 








}          
             
    
    
    
   