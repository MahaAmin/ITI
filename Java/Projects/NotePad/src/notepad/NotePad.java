package notepad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;

/**
 *
 * @author maha
 */
public class NotePad extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        
        // TO-DO: Create menubar
        MenuBar menuBar = new MenuBar();
        
        // TO-DO: Create textArea
        TextArea textArea = new TextArea();
        
        // TO-DO: create menus in menuBar (File, Edit, Help)
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        
        // TO-DO: add menus to menuBar
        menuBar.getMenus().addAll(file, edit, help);
        
        // TO-DO: Create menuItems in for File_Menu (new, Open..., Save, Exit)
        MenuItem new_MenuItem = new MenuItem("new");
        MenuItem open_MenuItem = new MenuItem("Open...");
        MenuItem save_MenuItem = new MenuItem("Save");
        MenuItem exit_MenuItem = new MenuItem("Exit");
        
        // Add menu_items to File_Menu
        file.getItems().addAll(new_MenuItem, open_MenuItem, save_MenuItem, exit_MenuItem);
        
        
        
        
        // add menuBar to panel
        pane.setTop(menuBar);
        
        // add textArea to panel
        pane.setCenter(textArea);
        // creating scene
        Scene scene = new Scene(pane);
        
        // set title of Stage
        primaryStage.setTitle("NotePad");
        
        
        // adding scene to stage
        primaryStage.setScene(scene);
        
        // show stage --> OPEN CURTAINS <3 
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
