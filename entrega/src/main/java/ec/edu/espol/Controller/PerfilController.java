/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controller;

import ec.edu.espol.funciones.Sistema;
import ec.edu.espol.model.Personas;
import ec.edu.espol.model.TipoPersona;
import static ec.edu.espol.model.TipoPersona.Comprador;
import static ec.edu.espol.model.TipoPersona.Vendedor;
import ec.edu.espol.model.Vendedor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class PerfilController implements Initializable {

    @FXML
    private TextField ingresousuario;
    @FXML
    private PasswordField ingroscontrasena;

    Personas persona;
    Vendedor vendedor;
    @FXML
    private VBox dato;
    @FXML
    private VBox actualizar;
    @FXML
    private VBox clavenueva;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Personas.desserializarPersonas("Personas.ser");
    }    

    @FXML
    private void mostrar(ActionEvent event) {
   
    try
        {          
            TipoPersona comp = TipoPersona.Comprador;
            TipoPersona ve = TipoPersona.Vendedor;
            TipoPersona am = TipoPersona.Ambos;
            
            String usuario = ingresousuario.getText().trim();
            String con = ingroscontrasena.getText().trim();            
            
            
            
            PasswordField verificar = new PasswordField ();
            verificar.setPromptText ("Coloque clave actual...");
            actualizar.getChildren().add(verificar);
            String veri = verificar.getText().trim(); 
             
            
            
            
            Button b;
             b = new Button( "Aceptar");
             actualizar.getChildren().add(b);
            
             
              
            
            
             
             if(Sistema.verificarExistencia(usuario,con))          
            {
                     
                persona = Sistema.obtenerPersona(usuario, con);
                System.out.println("Persona iniciar sesion=>"+persona.getUsuario());
                System.out.println(persona.getTipo());
                if(persona != null)  {
                  dato.getChildren().removeAll(dato.getChildren()); 
                    Text n = new Text("Nombres:");
                    Text nombre = new Text(persona.getNombres());
                    Text s = new Text(" ");
                    
                    Text a = new Text("Apellidos:");
                    Text apellido = new Text(persona.getApellidos());
                    Text ss = new Text(" ");
                    
                    Text c = new Text("Correo:");
                     Text co = new Text(persona.getCorreoElectronico());
                     Text sss = new Text(" ");
                    
                    Text u = new Text("Usuario:");
                    Text usu = new Text(persona.getUsuario());   
                    Text ssss = new Text(" ");
                                   
                     Text cl = new Text("Clave:");
                     Text cll = new Text(persona.getClave());
                     Text sssss = new Text(" ");
                                    
                    dato.getChildren().add(n);
                    dato.getChildren().add(nombre);
                    dato.getChildren().add(s);
                    
                    dato.getChildren().add(a);
                    dato.getChildren().add(apellido);
                    dato.getChildren().add(ss);
                                  
                    dato.getChildren().add(c);
                    dato.getChildren().add(co);
                    dato.getChildren().add(sss);               
                                        
                    dato.getChildren().add(u);
                    dato.getChildren().add(usu);
                    dato.getChildren().add(ssss);
                                       
                    dato.getChildren().add(cl);
                    dato.getChildren().add(cll);
                    dato.getChildren().add(sssss);
                    
                    
                    {
                        if(persona.getTipo().equals(TipoPersona.Comprador)){
                        
                        Text p = new Text("Tipo:");
                        Text pe = new Text("Comprador");
                        Text per = new Text(" ");
                        dato.getChildren().add(p);
                        dato.getChildren().add(pe);
                        dato.getChildren().add(per);
                        
                        }
                        else if (persona.getTipo().equals(TipoPersona.Vendedor)){
                        
                        Text p = new Text("Tipo:");
                        Text pe = new Text("Vendedor");
                        Text per = new Text(" ");
                        dato.getChildren().add(p);
                        dato.getChildren().add(pe);
                        dato.getChildren().add(per);
                         }                        
                        
                        else{
                                               
                        
                        Text p = new Text("Tipo:");
                        Text pe = new Text("Ambos");
                        Text per = new Text(" ");
                        dato.getChildren().add(p);
                        dato.getChildren().add(pe);
                        dato.getChildren().add(per);
                        
                          
                        }
                    }
                }
                    else
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "No existe un usuario con esos datos.\nIngrese correctamente los datos");
             
                
                
                
                
              
                
                
            b.setOnMouseClicked((MouseEvent m)->{
                     
                    
            
            if(Sistema.verificarExistencia(veri))      
            {
            Sistema.showMessage(new Alert(Alert.AlertType.INFORMATION), "Sesión", "Sesión iniciada", "Los datos fueron correctamente cargados"); 
                    persona = Sistema.obtenerPersona(usuario, veri);
                    
            
            
            
            
            
            
            
            
            
            }    else
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "NO es correcto");
           
            actualizar.getChildren().removeAll(actualizar.getChildren()); 
            
            });
                    
           
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
                
        }}
        catch(Exception e)
        {
            Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "ERROR EN EL SISTEMA");
        }     
    }  
}

// actualizar.getChildren().removeAll(actualizar.getChildren()); 
                    //clavenueva.getChildren().removeAll(clavenueva.getChildren()); 
                   
                       
                   
                    
                 
                    
                    
                    
                 
                      
                 
                    
/*

                        PasswordField nueva = new PasswordField ();
                        nueva.setPromptText ("Clave nueva...");
                        String nuevas = nueva.getText().trim();
                        clavenueva.getChildren().add(nueva);
                      persona.setClave(nuevas);
                      
                      
                      
                     
                    
                    
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR),"CAMBIO CONTRASENA",null,"EXITO EN CAMBIO CONTRASENA!!!!");                                                
                


                if(Sistema.verificarExistencia(usuario,clave))          
            {
                Sistema.showMessage(new Alert(Alert.AlertType.INFORMATION), "Sesión", "Sesión iniciada", "Los datos fueron correctamente cargados");                
                persona = Sistema.obtenerPersona(usuario, con);
                System.out.println("Persona iniciar sesion=>"+persona.getUsuario());
                if(persona != null)                                    
                    System.out.println("hpla");       
                else                   
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "No existe un usuario con esos datos.\nIngrese correctamente los datos");
            }
            else
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Sesión", "Error al iniciar", "No existe un usuario con esos datos.\nIngrese correctamente los datos");
                    
            














*/






