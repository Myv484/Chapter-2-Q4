/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.File;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jit
 */
public class Form extends Application {
     static Scanner x;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(4);
        grid.setVgap(4);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(grid, 400, 350);

        Text text = new Text("Welcome : ");
        Label userName = new Label("User Name : ");
        TextField nameField = new TextField();
        nameField.setMinWidth(200);
        nameField.setMaxWidth(200);
        nameField.setPromptText("Enter the name here.");
        Label password = new Label("Password : ");
        PasswordField passField = new PasswordField();
        passField.setMinWidth(200);
        passField.setMaxWidth(200);
        passField.setPromptText("Enter the password here.");
        
        grid.add(text, 0, 0);
        grid.add(userName, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(password, 0, 2);
        grid.add(passField, 1, 2);

        Button btn1 = new Button("Sign in");
        HBox hbtn1 = new HBox(10);
        hbtn1.setAlignment(Pos.CENTER_RIGHT);
        hbtn1.getChildren().add(btn1);
        grid.add(hbtn1, 1, 3);
        Button btn2 = new Button("Exit");
        HBox hbtn2 = new HBox(10);
        hbtn2.setAlignment(Pos.CENTER_LEFT);
        hbtn2.getChildren().add(btn2);
        grid.add(hbtn2, 2, 3);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        btn1.setOnAction(actionEvent -> {
            openFile();
            if (checklog(nameField.getText(), passField.getText())) {
                GridPane grid2 = new GridPane();
                grid2.setAlignment(Pos.CENTER);
                Scene scene2 = new Scene(grid2, 400, 350);
                Button btn3 = new Button("Add Student");
                HBox hbtn3 = new HBox(10);
                hbtn3.setAlignment(Pos.CENTER);
                hbtn3.getChildren().add(btn3);
                grid2.add(hbtn3, 1, 2);
                Button btn4 = new Button("View Student");
                HBox hbtn4 = new HBox(10);
                hbtn4.setAlignment(Pos.CENTER);
                hbtn4.getChildren().add(btn4);
                grid2.add(hbtn4, 1, 3);
                
                scene2.getStylesheets().add("file:///C:/Users/jit/Documents/NetBeansProjects/Form/src/form/stylee.css");
                primaryStage.setTitle("Options Page");
                primaryStage.setScene(scene2);
                primaryStage.show();

            } else {
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("In Valid User Name Or Password");
            }
        }
        );
        btn2.setOnAction(actionEvent -> Platform.exit());

        scene.getStylesheets().add("file:///C:/Users/jit/Documents/NetBeansProjects/Form/src/form/stylee.css");
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void openFile() {
        try {
            x = new Scanner(new File("user.txt"));
        } catch (Exception e) {
            System.out.println("Couldn't find file");
            System.exit(0);
        }
    }

    public boolean checklog(String username, String password) {
        String temp;
        boolean result = false;
        String[] info;
        while (x.hasNextLine()) {
            temp = x.nextLine();
            info = temp.split(",");
            if (info[0].equals(username) && info[1].equals(password)) {
                result = true;
            }
        }
        x.close(); 
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
