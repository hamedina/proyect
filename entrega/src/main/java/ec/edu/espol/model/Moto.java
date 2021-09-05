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
import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.control.Alert;

/**
 *
 * @author Lenovo
 */
public class Moto {
    private String placa;
    private String marca;
    private String modelo;
    private String motor;
    private String ano;
    private String recorrido;
    private String color;
    private String combustible;
    private String precio;
    private String urlImagen;
    
    
    
    
    public Moto(String placa, String marca, String modelo, String motor, String ano, String recorrido, String color, String combustible, String precio,String urlImagen) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.ano = ano;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.urlImagen = urlImagen;
    
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMotor() {
        return motor;
    }

    public String getAno() {
        return ano;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public String getColor() {
        return color;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Moto other = (Moto) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }
    
    public static void seriMoto(ArrayList<Moto> listap, String ruta){
        try(ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(ruta))){
            a.writeObject(listap);
        }catch(IOException e){}
    }
    
    //Metodos de Clase
    public static ArrayList<Moto> desseMoto(String ruta){
        try(ObjectInputStream a = new ObjectInputStream(new FileInputStream(ruta))){
            return (ArrayList<Moto>) a.readObject();
        }catch(Exception e){
            return new ArrayList<>();
        }
    }
   
    public static void guardarMoto(Moto moto) throws Exception{
        ArrayList<Moto> list= Moto.desseMoto("Moto.ser");
        list.add(moto);
        Moto.seriMoto(list, "Moto.ser");
        Sistema.showMessage(new Alert(Alert.AlertType.INFORMATION),"Creación de cuenta",null,"Se ha registrado correctamente !");
    }
    
    
    
    
    
    
    
}
