/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controller;
import javafx.stage.FileChooser;
import ec.edu.espol.funciones.Sistema;
import ec.edu.espol.model.Camioneta;
import ec.edu.espol.model.Moto;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MotoController implements Initializable {

    @FXML
    private TextField placa;
    @FXML
    private TextField marca;
    @FXML
    private TextField modelo;
    @FXML
    private TextField motor;
    @FXML
    private TextField ano;
    @FXML
    private TextField recorrido;
    @FXML
    private TextField color;
    @FXML
    private TextField combustible;
    @FXML
    private TextField precio;
    
    
    
    private File imageFile;
    private Path origen,destino;
    @FXML
    private Button registrar;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrar(ActionEvent event) throws Exception {
    String placas=placa.getText().trim();
    String marcas=marca.getText().trim();
    String modelos=modelo.getText().trim();
    String motors=motor.getText().trim();
    String    anos=ano.getText().trim();
    String recorridos=recorrido.getText().trim();
    String colors=color.getText().trim();
    String combustibles=combustible.getText().trim();
    String precios=precio.getText().trim();
    String  imagen = (imageFile != null ? imageFile.getName() : "");
    
    
    Moto moto = new Moto(placas,marcas,modelos,motors,anos,recorridos,colors,combustibles,precios,imagen);                    
       boolean verificar = Sistema.verificarMoto(moto);
                if(verificar)
                    
                    Sistema.showMessage(new Alert(Alert.AlertType.ERROR),"Registro Vehiculo",null,"Moto ya esta registrada con esa placa!!!!");                                                
                    
                
                else{
                if(origen!=null && destino != null) 
                            Files.copy(origen, destino, REPLACE_EXISTING); 
                    
                    moto.guardarMoto(moto);}  
                
    
    
    }

    @FXML
    private void imagen(MouseEvent event) {
    
    try{            
            imageFile = (new FileChooser()).showOpenDialog(null);
            if(imageFile.getName().endsWith(".jpg")||imageFile.getName().endsWith(".png")){
                origen = Paths.get(imageFile.getPath());
                destino = Paths.get(System.getProperty("user.dir")+"/src/main/resources/imagenes/"+imageFile.getName());
                 registrar.setDisable(false);
            }
        }catch(Exception e){
            Sistema.showMessage(new Alert(Alert.AlertType.ERROR), "Cargar una imagen", "Carga Fallida!", "Algo debió ocurrir con el Sistema,\nPor favor, envía un correo notificando tu problema (Ayuda).");
        }
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    

