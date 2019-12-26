/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.Reflection;

/**
 *
 * @author maha
 */
public class HelloJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Text txt = new Text("Hello World!");
        Rectangle rectangle = new Rectangle(0, 0, 300, 250);
        Reflection reflection = new Reflection();
        
        StackPane root = new StackPane();
        root.getChildren().add(rectangle);
        root.getChildren().add(txt);
        
    
        Scene scene = new Scene(root, 300, 250);
        
        txt.setFill(Color.RED);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        txt.setId("text");
        rectangle.setId("rectangle");
        reflection.setFraction(0.7);
        txt.setEffect(reflection);
        //rectangle.setStyle("-fx-fill: linear-gradient(black 0%, white 50%, white 50%, black 100%);");
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
