package com.application.compbuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainController {

    public static String idToPass;

    @FXML
    private Button quitButton;

    @FXML
    private TextField tf_userID;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField adminUsername;

    @FXML
    private PasswordField adminPassword;

    @FXML
    private Button logOutButton;

    @FXML
    private void windowDispose() {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void SignInBoot() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signupPage.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ex) {
            System.out.println("Can't load signupPage.fxml");
        }
    }

    @FXML
    private void logInValidation() {
        String userID = tf_userID.getText();
        String pass = pf_password.getText();
        ResultSet rs;
        String query = "SELECT * FROM userDB WHERE userID=? AND passwordSalt=?";
        PreparedStatement ps;
        try {
            ps = myConnection.getConnection().prepareStatement(query);
            ps.setString(1, userID);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                idToPass = rs.getString("userID");
                System.out.println(idToPass);
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
            System.out.println(rs.getString("userID"));
        } catch (SQLException exception) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("MySQL is offline");
        }
    }

    public static String tempData() throws IOException {
        System.out.print(idToPass);
        return idToPass;
    }


    @FXML
    private void guestWindow(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homeGuest.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            Stage closeLoginPage = (Stage) quitButton.getScene().getWindow();
            closeLoginPage.close();
        } catch (Exception ex) {
            System.out.println("Can't load homeGuest.fxml");
        }
    }



    @FXML
    private void adminWindow() {
        Stage closeLoginPage = (Stage) quitButton.getScene().getWindow();
        closeLoginPage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminLogin.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Can't access adminLogin.fxml");
        }
    }

    @FXML
    private void adminValidation(){
        if (Objects.equals(adminUsername.getText(), "admin") && Objects.equals(adminPassword.getText(), "")) {
            Stage closeHome = (Stage) quitButton.getScene().getWindow();
            closeHome.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homeAdmin.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                System.out.println("Can't access homeAdmin.fxml");
            }
            System.out.println("Success");
        }
        else{
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Please check your username and password again. If you are not an admin please log-in via the first window.");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
    }

    @FXML
    private void AdminlogOutAction() throws IOException {
        Stage closeAdminpage = (Stage) logOutButton.getScene().getWindow();
        closeAdminpage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void BootAdminEditWindow() throws IOException{
        Stage closeHomeAdmin = (Stage) logOutButton.getScene().getWindow();
        closeHomeAdmin.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void disposeAdminLoginPage() throws IOException {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage1 = new Stage();
        assert root != null;
        stage1.setScene(new Scene(root));
        stage1.show();
    }

}
