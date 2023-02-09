package com.application.compbuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController{

    @FXML
    private Button logOutButton;

    @FXML
    private void startBuild() throws IOException {
        Stage closeHome = (Stage) logOutButton.getScene().getWindow();
        closeHome.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sysBuilder.fxml"));
        Parent root2 = fxmlLoader.load();
        Stage stage = new Stage();
        assert root2 != null;
        stage.setScene(new Scene(root2));
        stage.show();
    }

    @FXML
    private void startBuildGuest() throws IOException {
        Stage closeHome = (Stage) logOutButton.getScene().getWindow();
        closeHome.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sysBuilderGuest.fxml"));
        Parent root2 = fxmlLoader.load();
        Stage stage = new Stage();
        assert root2 != null;
        stage.setScene(new Scene(root2));
        stage.show();
    }

    @FXML
    private void accessBuild() throws IOException{
        Stage closeHome = (Stage) logOutButton.getScene().getWindow();
        closeHome.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userBuild.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void logOutAction() throws IOException {
        Stage closeHome = (Stage) logOutButton.getScene().getWindow();
        closeHome.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }
}
