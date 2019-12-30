package notepad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import java.io.*;
import javafx.stage.FileChooser;

/**
 *
 * @author maha
 */
public class NotePad extends Application {

    public static File srcFile;

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
        // TO-DO: Add Save_As... menuItem
        // TO-DO: Add Delete menuItem
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

        // Create menuItems for Help Menu (About NotePad)
        MenuItem about_MenuItem = new MenuItem("About NotePad");

        // Adding menuItems to Help menu
        help.getItems().addAll(about_MenuItem);

        // add copyright footer 
        Label copyrightFooter = new Label("Copy Rights: Made by Maha Amin, ITI-intake40. Cloud-Platform-Development Track. 2020.");
        copyrightFooter.setPrefHeight(50);

        /// #######################################################################################
        /// ---------------------- TO-DO: EVENT HANDLING -------------------------------- 
        // TO-DO: Event-Handling for FILE_MENU :
        // Event-handling for new_menuItem
        // TO-DO: if there is unsaved text --> open dialog message to save
        new_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (NotePad.srcFile != null) {
                    try {
                        FileInputStream fis = new FileInputStream(NotePad.srcFile);
                        int size = fis.available();
                        byte[] b = new byte[size];
                        fis.read(b);
                        fis.close();

                        String textFromFile = new String(b);
                        if (textArea.getText() != textFromFile) {
                            
                            // TO-DO: open dialog to let user choose what to do whit unsaved text
                            System.out.println("to open dialog");
                        } else {
                            NotePad.srcFile = null;
                            textArea.clear();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    // TO-DO: open dialog having an option to save new file.
                    NotePad.srcFile = null;
                    textArea.clear();
                }
            }
        });

        // event-handling for open_menuItem with file-browser open dialog
        // move the cursor at the end of text after opening a file
        open_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                NotePad.srcFile = fileChooser.showOpenDialog(primaryStage);
                try {
                    FileInputStream fis = new FileInputStream(NotePad.srcFile);
                    int size = fis.available();
                    byte[] b = new byte[size];
                    fis.read(b);
                    textArea.clear();
                    textArea.setText(new String(b));
                    
                    // move the cursor at the end of text after opening a file
                    textArea.end();
                    
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //System.out.println(file);
            }
        });
        // event-handling for save_menuItem
        save_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (NotePad.srcFile == null) {
                    FileChooser fileChooser = new FileChooser();
                    NotePad.srcFile = fileChooser.showOpenDialog(primaryStage);
                }
                FileWriter fileWriter = null;
                PrintWriter printWriter = null;
                BufferedReader bufferedReader = null;

                // opening a file in write (trancate) mode using FileWriter
                try {
                    fileWriter = new FileWriter(NotePad.srcFile);
                    printWriter = new PrintWriter(fileWriter);
                    String text = textArea.getText();
                    printWriter.println(text);
                    printWriter.close();
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        // event-handling for exit_menuItem
        // TO-DO: before exiting, if there is un-saved text --> open dialog
        exit_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        // TO-DO: Event-Handling for EDIT_MENU :
        // event-handling for undo_menuItem
        undo_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.undo();
            }
        });

        // event-handling for cut_menuItem
        cut_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.cut();
            }
        });

        // event-handling for copy_menuItem
        copy_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.copy();
            }
        });

        // event-handling for paste_menuItem
        paste_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.paste();
            }
        });

        // event-handling for delete_menuItem
        delete_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.deleteText(textArea.getSelection().getStart(), textArea.getSelection().getEnd());
            }
        });

        // event-handling for selectAll_menuItem
        selectAll_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.selectAll();
            }
        });

        // TO-DO: Event-Handling for Help_Menu :
        // TO-DO: event-handling for aboutNotePad_menuItem 
        about_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                // Open new "About NotePad" dialog window
                
                // crating text-node
                Label aboutText = new Label("NotePad:\n    - Created by Maha Amin.\n    - ITI-40, CPD, Java.");
                
                // creating new stage
                Stage aboutStage = new Stage();
                aboutStage.setTitle("About NotePad");
                
                // creating new BorderPane layout
                BorderPane aboutPane = new BorderPane();
                
                // creating new scene in aboutPane BorderPane
                Scene aboutScene = new Scene(aboutPane);
                
                // putting Label aboutText at the center of BorderPane
                aboutPane.setCenter(aboutText);
                
                // loading scene on stage
                aboutStage.setScene(aboutScene);
                
                // setting position (x,y) of aboutStage relative to primaryStage
                aboutStage.setX(primaryStage.getX() + 200);
                aboutStage.setY(primaryStage.getY() + 100);
                
                // set aboutStage width & height
                aboutStage.setHeight(200);
                aboutStage.setWidth(300);
                
                // show new about dialog
                aboutStage.show();
                
                
            }
        });
        // TO-DO: shortcuts key_combinations 
        /// -------------------- SETTING-UP (pane, scene, stage) ------------------------
        // add menuBar to panel
        pane.setTop(menuBar);

        // add textArea to panel
        pane.setCenter(textArea);

        // add footer to panel
        pane.setBottom(copyrightFooter);
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
