package com.application.compbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpController {
    @FXML
    private Button quitButton;

    @FXML
    private TextField tf_firstName;

    @FXML
    private TextField tf_lastName;

    @FXML
    private TextField tf_userID;

    @FXML
    private TextField tf_emailAddress;

    @FXML
    private TextField tf_Password;

    @FXML
    private TextField tf_cfmPassword;

    @FXML
    private void RegisterActionPerformed() throws SQLException {
        String fname = tf_firstName.getText();
        String lname = tf_lastName.getText();
        String username = tf_userID.getText();
        String email = tf_emailAddress.getText();
        String pass = tf_Password.getText();
        String confirmPass = tf_cfmPassword.getText();

        String query = "INSERT INTO userDB (firstName, lastName, userID, emailAddress, passwordSalt) VALUES(?, ?, ?, ?, ?)";
        String checkQuery = "SELECT * from userDB WHERE userID = '" + username + "'";
        PreparedStatement ps;
        PreparedStatement checkForExistingUser;
        try {
            checkForExistingUser = myConnection.getConnection().prepareStatement(checkQuery);
            ps = myConnection.getConnection().prepareStatement(query);
            ResultSet userIDTemp = checkForExistingUser.executeQuery();
            if (userIDTemp.next()) {
                System.out.println("Username");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Check Your Username!");
                alert.setContentText("Username already exists. Please choose another username");
                alert.showAndWait();
            }else {
                    if (fname.isEmpty() || lname.isEmpty() || username.isEmpty() || email.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
                        alert1.setHeaderText("Please make sure all fields are filled in!");
                        alert1.setContentText("Ensure all fields are filled.");
                        alert1.show();
                    } else if (confirmPass.compareTo(pass) != 0) {
                        System.out.println("Password mismatched!");
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
                        alert1.setHeaderText("Check Your Password!");
                        alert1.setContentText("Password is different. Please retype your password.");
                        alert1.show();
                    } else if (pass.length() < 8) {
                        System.out.println(pass.length());
                        System.out.println("Password needs to be at least 8 characters long!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error!");
                        alert.setContentText("Password needs to be at least 8 characters");
                        alert.show();
                    } else if (!email.contains("@") && !email.contains(".com")) {
                        System.out.println("Illegal argument! Email is not valid.");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Illegal Argument");
                        alert.setContentText("Please enter a valid email");
                        alert.show();

                    }
                    else{
                        ps.setString(1, fname);
                        ps.setString(2, lname);
                        ps.setString(3, username);
                        ps.setString(4, email);
                        ps.setString(5, pass);
                        System.out.println(fname);
                        ps.execute();
                        System.out.println("New user added");
                        Stage stage = (Stage) quitButton.getScene().getWindow();
                        stage.close();
                        Alert registrationCompleted = new Alert(Alert.AlertType.INFORMATION);
                        registrationCompleted.setContentText("Sign Up Successful! You may now log-in.");
                        registrationCompleted.show();
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void windowDispose(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
