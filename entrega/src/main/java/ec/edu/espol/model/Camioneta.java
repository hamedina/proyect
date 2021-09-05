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
public class Camioneta {
    private String placa;
    private String marca;
    private String modelo;
    private String motor;
    private String ano;
    private String recorrido;
    private String color;
    private String transmision;
    private String combustible;
    private String vidrios;
    private String precio;
    private String traccion;

    public Camioneta(String placa, String marca, String modelo, String motor, String ano, String recorrido, String color, String transmision, String combustible, String vidrios, String precio, String traccion) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.ano = ano;
        this.recorrido = recorrido;
        this.color = color;
        this.transmision = transmision;
        this.combustible = combustible;
        this.vidrios = vidrios;
        this.precio = precio;
        this.traccion = traccion;
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

    public String getTransmision() {
        return transmision;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getVidrios() {
        return vidrios;
    }

    public String getPrecio() {
        return precio;
    }

    public String getTraccion() {
        return traccion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Camioneta other = (Camioneta) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }
    
    
    
    public static void seriCamioneta(ArrayList<Camioneta> listap, String ruta){
        try(ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(ruta))){
            a.writeObject(listap);
        }catch(IOException e){}
    }
    
    //Metodos de Clase
    public static ArrayList<Camioneta> desseCamioneta(String ruta){
        try(ObjectInputStream a = new ObjectInputStream(new FileInputStream(ruta))){
            return (ArrayList<Camioneta>) a.readObject();
        }catch(Exception e){
            return new ArrayList<>();
        }
    }
   
    public static void guardarCamioneta(Camioneta camioneta) throws Exception{
        ArrayList<Camioneta> list= Camioneta.desseCamioneta("Camioneta.ser");
        list.add(camioneta);
        Camioneta.seriCamioneta(list, "Camioneta.ser");
        Sistema.showMessage(new Alert(Alert.AlertType.INFORMATION),"Creación de cuenta",null,"Se ha registrado correctamente !");
    }















}
