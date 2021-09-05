/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.funciones;

import com.edu.espol.entrega.App;
import ec.edu.espol.model.Ambos;
import ec.edu.espol.model.Auto;
import ec.edu.espol.model.Camioneta;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Moto;
import ec.edu.espol.model.Personas;
import ec.edu.espol.model.TipoPersona;
import ec.edu.espol.model.Vendedor;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;

/**
 *
 * @author Lenovo
 */
public class Sistema {
    
    
    
    
    
    
    
   
     //-----------------------------------------TRATAMIENTO  COMPRADOR AL INICIAR SESION Y REGISTRAR
    
   public static boolean verificarExistenciaPersona(Personas persona)
    {
        //Este método permite verificar si el usuario a crear es vendedor, comprador o ninguno. Validacion en el main y para el metodo que agrega los tipo de usuario
        ArrayList<Personas> personas = Personas.desserializarPersonas("Personas.ser");
        for(Personas pe: personas)
        {
            if(pe.getCorreoElectronico().equals(persona.getCorreoElectronico())  &&  pe.getTipo().equals(pe.getTipo())   ) 
                                    
                return true;
        }
        return false;
    }

    public static boolean verificarExistencia(String usuario, String clave)
    {
        //Este método permite verificar si el usuario a crear es vendedor, comprador o ninguno. Validacion en el main y para el metodo que agrega los tipo de usuario
        ArrayList<Personas> personas = Personas.desserializarPersonas("Personas.ser");
        for(Personas per: personas)
        {
            if(per.getUsuario().equals(usuario) && 
               per.getClave().equals(clave))                        
                return true;
        }
        return false;
    }
    
    public static Personas obtenerPersona(String usuario, String clave)
    {       
        ArrayList<Personas> personas = Personas.desserializarPersonas("Personas.ser");
        for(Personas p: personas)
        {
            if(p.getUsuario().equals(usuario) && 
               p.getCorreoElectronico().equals(clave))  
                return p;
        }
        return null;
    }
    
     public static boolean verificarExistencia( String clave)
    {
        //Este método permite verificar si el usuario a crear es vendedor, comprador o ninguno. Validacion en el main y para el metodo que agrega los tipo de usuario
        ArrayList<Personas> personas = Personas.desserializarPersonas("Personas.ser");
        for(Personas per: personas)
        {
            if( 
               per.getClave().equals(clave))                        
                return true;
        }
        return false;
    }
    
    
    
    
    
    
    



public static Comprador convertirComprador(Comprador co)
    {
        String nombre      = co.getNombres();
        String apellido    = co.getApellidos();
        String usuario     = co.getUsuario();
        String clave       = co.getClave();
        String email       = co.getCorreoElectronico();
        return new Comprador(nombre, apellido, email,usuario,clave , TipoPersona.Comprador);
    
    
    }
    
  
   public static Vendedor convertirVendedor(Vendedor ve)
    {
        String nombre      = ve.getNombres();
        String apellido    = ve.getApellidos();
        String usuario     = ve.getUsuario();
        String clave       = ve.getClave();
        String email       = ve.getCorreoElectronico();
        return new Vendedor(nombre, apellido, email,usuario,clave , TipoPersona.Vendedor);
    
    }
    
    
    
     public static Ambos convertirAmbos(Ambos am)
    {
        String nombre      = am.getNombres();
        String apellido    = am.getApellidos();
        String usuario     = am.getUsuario();
        String clave       = am.getClave();
        String email       = am.getCorreoElectronico();
        return new Ambos(nombre, apellido, email,usuario,clave,TipoPersona.Ambos);
    
    
    
    
    
}  
    
    
  //-----------------------------------------------------------------------------------------------------------  
    
    public static boolean verificarAuto(Auto autos)
    {
        //Este método permite verificar si el usuario a crear es vendedor, comprador o ninguno. Validacion en el main y para el metodo que agrega los tipo de usuario
        ArrayList<Auto> auto = Auto.desseAuto("Auto.ser");
        for(Auto a: auto)
        {
            if(a.getPlaca().equals(a.getPlaca())   ) 
                                    
                return true;
        }
        return false;
    }
   

     public static Auto obtenerAuto(String placa)
    {       
        ArrayList<Auto> autos = Auto.desseAuto("Auto.ser");
        for(Auto a: autos)
        {
            if(a.getPlaca().equals(placa))  
                return a;
        }
        return null;
    }
    
     
    
    
    
 //--------------------------------------------------------------------------------------------------------
    
     
     public static boolean verificarCamioneta(Camioneta camioneta)
    {
        //Este método permite verificar si el usuario a crear es vendedor, comprador o ninguno. Validacion en el main y para el metodo que agrega los tipo de usuario
        ArrayList<Camioneta> camionetas = Camioneta.desseCamioneta("Camioneta.ser");
        for(Camioneta c: camionetas)
        {
            if(c.getPlaca().equals(c.getPlaca())   ) 
                                    
                return true;
        }
        return false;
    }
   

     public static Camioneta obtenerCamioneta(String placa)
    {       
        ArrayList<Camioneta> camionetas = Camioneta.desseCamioneta("Camioneta.ser");
        for(Camioneta c: camionetas)
        {
            if(c.getPlaca().equals(placa))  
                return c;
        }
        return null;
    }
     
     
     
     
     
     //--------------------------------------------------------------------------------------------------------
     
     
      public static boolean verificarMoto(Moto moto)
    {
        //Este método permite verificar si el usuario a crear es vendedor, comprador o ninguno. Validacion en el main y para el metodo que agrega los tipo de usuario
        ArrayList<Moto> motos = Moto.desseMoto("Moto.ser");
        for(Moto m: motos)
        {
            if(m.getPlaca().equals(m.getPlaca())   ) 
                                    
                return true;
        }
        return false;
    }
   

     public static Moto obtenerMoto(String placa)
    {       
        ArrayList<Moto> motos = Moto.desseMoto("Moto.ser");
        for(Moto m: motos)
        {
            if(m.getPlaca().equals(placa))  
                return m;
        }
        return null;
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     //--------------------------------------------------------------------------------------------------------
     public static void showMessage(Alert show,String titulo, String encabezado, String mensaje){
        show.setHeaderText(encabezado);
        show.setTitle(titulo);
        show.setContentText(mensaje);
        show.showAndWait();
    }
    
    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    
    
    
    
    public static int validarNumeroEntero(String valor)
    {
        try
        {
            return Integer.parseInt(valor);
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public static double validarNumeroDouble(String valor)
    {
        try
        {
            return Double.parseDouble(valor);
        }
        catch(Exception e)
        {
            return 0;
        }
    }

   
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
}
