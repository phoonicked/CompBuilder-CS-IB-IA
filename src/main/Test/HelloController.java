package com.application.compbuilder;

import customer_detail.myConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloController {

    @FXML
    private Button quitButton;

    @FXML
    private Button openSignIn;

    @FXML
    private Button status;

    @FXML
    private Button logInButton;


    @FXML
    private Parent fxml;

    @FXML
    private TextField tf_userID;

    @FXML
    private PasswordField pf_password;

    @FXML
    private void windowDispose(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void SignInBoot(ActionEvent event1) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signupPage.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Can't load signinPage.fxml");
        }
    }

    @FXML
    private void logInValidation(ActionEvent e) {
        int successCheck = 0;
        ResultSet rs;
        String userID = tf_userID.getText();
        String pass = String.valueOf(pf_password.getText());

        String query = "SELECT * FROM userDB WHERE userID=? AND passwordSalt=?";

        PreparedStatement ps;

        try {
            ps = myConnection.getConnection().prepareStatement(query);
            ps.setString(1, userID);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                //successCheck = 1;
                System.out.println("Login successful!");
                Alert welcomeDialog = new Alert(Alert.AlertType.INFORMATION);
                welcomeDialog.setContentText("Welcome, " + rs.getString("firstName"));
                welcomeDialog.showAndWait();
                Stage closeLoginPage = (Stage) quitButton.getScene().getWindow();
                closeLoginPage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                Parent root2 = null;
                try {
                    root2 = fxmlLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Stage stage = new Stage();
                assert root2 != null;
                stage.setScene(new Scene(root2));
                stage.show();

            } else {
                System.out.println("Login failed");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Log In Failed!");
                alert.show();
            }
        } catch (SQLException exception) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, exception);
        }

        //MAKE AN ADMIN ACCOUNT
        /*if(successCheck == 1){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root2 = null;
            try {
                root2 = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Stage stage = new Stage();
            assert root2 != null;
            stage.setScene(new Scene(root2));
            stage.show();
        }
    }

         */
    }
}

    /** Check SQL database connection
    @FXML
    private void open_status(ActionEvent event2){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("statusPage.fxml"));
            Parent root2 = fxmlLoader.load();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2));
            stage2.show();
        }
        catch(Exception ex){
            System.out.println("Can't load statusPage.fxml");
        }
    }
     **/