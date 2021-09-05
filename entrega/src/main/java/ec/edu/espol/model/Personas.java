/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;


import ec.edu.espol.funciones.Sistema;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author Lenovo
 */
public class Personas implements Serializable {
    
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private String usuario;
    private String clave;
    private TipoPersona    tipo;
    
    
    public Personas(String nombres,String apellidos,String correoElectronico,String usuario, String clave,TipoPersona tipo )
    {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo=tipo;
    }
    
    public String getNombres()
    {
        return this.nombres;
    }
    
    public String getApellidos()
    {
        return this.apellidos;
    }
    
    public String getCorreoElectronico()
    {
        return this.correoElectronico;
    }
    
   
    
    public String getUsuario()
    {
        return this.usuario;
    }
    
    public String getClave()
    {
        return this.clave;
    }    

    public TipoPersona getTipo() {
        return tipo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTipo(TipoPersona tipo) {
        this.tipo = tipo;
    }


      
    
public static void serializarPersonas(ArrayList<Personas> listap, String ruta){
        try(ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(ruta))){
            a.writeObject(listap);
        }catch(IOException e){}
    }
    
    //Metodos de Clase
    public static ArrayList<Personas> desserializarPersonas(String ruta){
        try(ObjectInputStream a = new ObjectInputStream(new FileInputStream(ruta))){
            return (ArrayList<Personas>) a.readObject();
        }catch(Exception e){
            return new ArrayList<>();
        }
    }
   
    public static void guardarPersonas(Personas personas) throws Exception{
        ArrayList<Personas> lista= Personas.desserializarPersonas("Personas.ser");
        lista.add(personas);
        Personas.serializarPersonas(lista, "Personas.ser");
        Sistema.showMessage(new Alert(Alert.AlertType.INFORMATION),"Creación de cuenta",null,"Se ha registrado correctamente !");
    }



}

