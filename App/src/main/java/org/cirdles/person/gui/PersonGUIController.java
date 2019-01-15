/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.cirdles.person.Person; 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author meagangould
 */
public class PersonGUIController implements Initializable {

    @FXML
    private TextField nameBox;

    @FXML
    private TextField dateOfBirthBox;

    @FXML
    private Button save;

    @FXML
    private Button open;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    public void serializeToAction(ActionEvent event){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile!=null){
            String filePath= selectedFile.getAbsolutePath();
            Person person=new Person(nameBox.getText(),Long.parseLong(dateOfBirthBox.getText()));
            Person.serializationXML(person,filePath);
        }
        else{
            System.out.println("file not valid ");
        }
    }
    @FXML
    public void setDeserializeFromAction(ActionEvent event){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile!=null){
            String filePath= selectedFile.getAbsolutePath();
            Person person= Person.deserializationXML(filePath);
            nameBox.setText(person.getName());
            dateOfBirthBox.setText(Long.toString(person.getDOB()));
        }
        else{
            System.out.println("file not valid ");
        }
    }
    
    
  
    


    
}
