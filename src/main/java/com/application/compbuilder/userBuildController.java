package com.application.compbuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userBuildController implements Initializable {
    private Connection con = null;
    private ObservableList<savedBuild> savedBuildData;

    @FXML
    private Button exitButton;
    @FXML
    public TableView<savedBuild> savedBuildTable;

    @FXML
    private TableColumn<savedBuild, String> colCPU;

    @FXML
    private TableColumn<savedBuild, String> colGPU;

    @FXML
    private TableColumn<savedBuild, String> colRAM;

    @FXML
    private TableColumn<savedBuild, String> colMotherboard;

    @FXML
    private TableColumn<savedBuild, String> colStorage;

    @FXML
    private TableColumn<savedBuild, String> colPowerSupply;

    @FXML
    private TableColumn<savedBuild, String> colMonitor;

    @FXML
    private TableColumn<savedBuild, Double> totalPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        con = myConnection.getConnection();
        savedBuildData = FXCollections.observableArrayList();
        setCellTable();
        loadDataFromDatabase();
        System.out.println("savedBuildTable is booted!");
    }

    private void setCellTable() {
        colCPU.setCellValueFactory(new PropertyValueFactory<>("CPU"));
        colGPU.setCellValueFactory(new PropertyValueFactory<>("GPU"));
        colRAM.setCellValueFactory(new PropertyValueFactory<>("RAM"));
        colMotherboard.setCellValueFactory(new PropertyValueFactory<>("Motherboard"));
        colStorage.setCellValueFactory(new PropertyValueFactory<>("Storage"));
        colPowerSupply.setCellValueFactory(new PropertyValueFactory<>("powerSupply"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("Monitor"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
    }

    private void loadDataFromDatabase() {
        mainController id = new mainController();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM savedBuildDB WHERE user = '" + id.tempData() +"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                savedBuildData.add(new savedBuild(rs.getString("CPU"), rs.getString("RAM"), rs.getString("Motherboard"), rs.getString("powerSupply"), rs.getString("Storage"), rs.getString("GPU"), rs.getString("Monitor"), rs.getDouble("Price")));
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        savedBuildTable.setItems(savedBuildData);
    }

    @FXML
    private void deleteBuild() throws SQLException, IOException {
        String query = "DELETE FROM savedBuildDB WHERE Price = '" + savedBuildTable.getSelectionModel().getSelectedItem().getPrice() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted!");
        deletionConfirmation.showAndWait();
        Stage closeMyBuild = (Stage) exitButton.getScene().getWindow();
        closeMyBuild.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userBuild.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void windowDispose() throws IOException {
        Stage closeMyBuild = (Stage) exitButton.getScene().getWindow();
        closeMyBuild.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }
}
