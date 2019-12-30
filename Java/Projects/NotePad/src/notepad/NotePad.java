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
        
        // Create menubar
        MenuBar menuBar = new MenuBar();
        
        // Create textArea
        TextArea textArea = new TextArea();
        
        // create menus in menuBar (File, Edit, Help)
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        
        // add menus to menuBar
        menuBar.getMenus().addAll(file, edit, help);
        
        // Create menuItems in for File_Menu (new, Open..., Save, Exit)
        MenuItem new_MenuItem = new MenuItem("new");
        MenuItem open_MenuItem = new MenuItem("Open...");
        MenuItem save_MenuItem = new MenuItem("Save");
        
        SeparatorMenuItem separator2_MenuItem = new SeparatorMenuItem();
        MenuItem exit_MenuItem = new MenuItem("Exit");
        
        // Add menu_items to File_Menu
        file.getItems().addAll(new_MenuItem, open_MenuItem, save_MenuItem, separator2_MenuItem, exit_MenuItem);
        
        
        // Create menuItems for Edit_Menu (Undo, Cut, Copy, Paste, Delete, Select All)
        MenuItem undo_MenuItem = new MenuItem("Undo"); 
        SeparatorMenuItem separator1_MenuItem = new SeparatorMenuItem();
        
        MenuItem cut_MenuItem = new MenuItem("Cut");
        MenuItem copy_MenuItem = new MenuItem("Copy");
        MenuItem paste_MenuItem = new MenuItem("Paste");
        MenuItem delete_MenuItem = new MenuItem("Delete");
        
        SeparatorMenuItem separator3_MenuItem = new SeparatorMenuItem();
        MenuItem selectAll_MenuItem = new MenuItem("Select All");
        
        edit.getItems().addAll(undo_MenuItem, separator1_MenuItem, cut_MenuItem, copy_MenuItem, paste_MenuItem, delete_MenuItem, separator3_MenuItem, selectAll_MenuItem);
        
        
        // TO-DO: Create menuItems for Help Menu (About NotePad)
        MenuItem about_MenuItem = new MenuItem("About NotePad");
        
        // Adding menuItems to Help menu
        help.getItems().addAll(about_MenuItem);
        
        
        
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
