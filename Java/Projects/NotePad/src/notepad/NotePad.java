package notepad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
        // Event-Handling for FILE_MENU :
        // Event-handling for new_menuItem
        // TO-DO: if there is unsaved text --> open dialog message to save
        new_MenuItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                // Case 1 --> a file already exists and opened
                if (NotePad.srcFile != null) {
                    try {
                        FileInputStream fis = new FileInputStream(NotePad.srcFile);
                        int size = fis.available();
                        byte[] b = new byte[size];
                        fis.read(b);
                        fis.close();

                        String textFromFile = new String(b);

                        // Case 1.1 --> file already opened & new unsaved changes exists
                        if (!textArea.getText().equals(textFromFile)) {

                            // open dialog to let user choose what to do with unsaved text
                            // create nodes
                            Label unsavedChanges_label = new Label("There are unsaved changes.\nDo you want to save them?");
                            Button save_btn = new Button("Save");
                            save_btn.setPrefSize(100, 20);
                            Button discard_btn = new Button("Discard");
                            discard_btn.setPrefSize(100, 20);

                            // create new stage
                            Stage unsavedChanges_stage = new Stage();

                            // create new BorderPane layout
                            BorderPane unsavedChanges_pane = new BorderPane();

                            // wrap 2 buttons in hbox node to set them in paneBottom
                            HBox hbox = new HBox();
                            //hbox.setPadding(new Insets(15, 12, 15, 12));
                            hbox.setSpacing(10);
                            hbox.getChildren().addAll(save_btn, discard_btn);

                            // position nodes on layout
                            unsavedChanges_pane.setTop(unsavedChanges_label);
                            unsavedChanges_pane.setCenter(hbox);

                            // create new scene
                            Scene unsavedChanges_scene = new Scene(unsavedChanges_pane);

                            // load scene on stage
                            unsavedChanges_stage.setScene(unsavedChanges_scene);

                            // set position (x,y) of stage relative to primaryStage
                            unsavedChanges_stage.setX(primaryStage.getX() + 200);
                            unsavedChanges_stage.setY(primaryStage.getY() + 100);

                            // set stage width & height
                            unsavedChanges_stage.setWidth(500);
                            unsavedChanges_stage.setHeight(200);

                            // show new dialog
                            unsavedChanges_stage.show();

                            // ------------ Event-Handling For Save & Discard Buttons --------------
                            // save_btn event-handling
                            save_btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent event) {
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
                                        unsavedChanges_stage.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            });

                            discard_btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent event) {
                                    textArea.clear();
                                    NotePad.srcFile = null;
                                    unsavedChanges_stage.close();
                                }
                            });

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else // Case 2 --> No opened file
                {
                    // TO-DO: open dialog having an option to save new file.
                    FileChooser fileChooser = new FileChooser();
                    NotePad.srcFile = fileChooser.showOpenDialog(primaryStage);
                }
            }
        }
        );

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
        }
        );
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

        // Event-Handling for Help_Menu :
        // event-handling for aboutNotePad_menuItem 
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
