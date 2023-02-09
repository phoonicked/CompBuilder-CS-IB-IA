package com.application.compbuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

public class addComponentController implements Initializable {
    private Connection con = null;

    @FXML
    private Button cancelButton;

    @FXML
    private Button editCPU;

    @FXML
    private TextField cpuName;

    @FXML
    private TextField cpuPrice;

    @FXML
    private TextField cpuCoreCount;

    @FXML
    private TextField cpuCoreClock;

    @FXML
    private TextField cpuBoostClock;

    @FXML
    private TextField cpuTDP;

    @FXML
    private TextField cpuIntegratedGraphics;

    @FXML
    private TextField cpuSMT;

    @FXML
    private TextField gpuName;

    @FXML
    private TextField gpuPrice;

    @FXML
    private TextField gpuChipset;

    @FXML
    private TextField gpuMemory;

    @FXML
    private TextField gpuCoreClock;

    @FXML
    private TextField gpuBoostClock;

    @FXML
    private TextField gpuColour;

    @FXML
    private TextField gpuLength;

    @FXML
    private TextField ramName;

    @FXML
    private TextField ramPrice;

    @FXML
    private TextField ramSpeed;

    @FXML
    private TextField ramModule;

    @FXML
    private TextField ramColour;

    @FXML
    private TextField ramFirstWordLatency;

    @FXML
    private TextField ramCasLatency;

    @FXML
    private TextField monitorName;

    @FXML
    private TextField monitorPrice;

    @FXML
    private TextField monitorScreenSize;

    @FXML
    private TextField monitorResolution;

    @FXML
    private TextField monitorRefreshRate;

    @FXML
    private TextField monitorResponseTime;

    @FXML
    private TextField monitorPanelType;

    @FXML
    private TextField monitorAspectRatio;

    @FXML
    private TextField storageName;

    @FXML
    private TextField storagePrice;

    @FXML
    private TextField storageType;

    @FXML
    private TextField storageCapacity;

    @FXML
    private TextField storageCache;

    @FXML
    private TextField storageInterface;

    @FXML
    private TextField motherboardName;

    @FXML
    private TextField motherboardPrice;

    @FXML
    private TextField motherboardSocket;

    @FXML
    private TextField motherboardMemory;

    @FXML
    private TextField motherboardMemorySlots;

    @FXML
    private TextField motherboardColour;

    @FXML
    private TextField powerSupplyName;

    @FXML
    private TextField powerSupplyPrice;

    @FXML
    private TextField powerSupplyWattage;

    @FXML
    private TextField powerSupplyModular;

    @FXML
    private TextField powerSupplyColour;

    String query = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void windowDispose() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void addCPUToTable() {
        con = myConnection.getConnection();
        String name = cpuName.getText();
        if(name.isEmpty()){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Name cannot be empty!");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
        else{
            getQueryCPU();
            insertCPU();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage closeAddCPU = (Stage) cancelButton.getScene().getWindow();
                closeAddCPU.close();
            }catch (IOException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void insertCPU() {
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpuName.getText());
            ps.setDouble(2, Double.parseDouble(cpuPrice.getText()));
            ps.setString(3, cpuCoreCount.getText());
            ps.setString(4, cpuCoreClock.getText());
            ps.setString(5, cpuBoostClock.getText());
            ps.setString(6, cpuTDP.getText());
            ps.setString(7, cpuIntegratedGraphics.getText());
            ps.setString(8, cpuSMT.getText());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void getQueryCPU() {
        query = "INSERT INTO cpuDB (Name, Price, coreCount, coreClock, boostClock, tdp, integratedGraphics, smt) VALUES (?, ?, ?, ?, ? , ?, ?, ?)";
    }

    @FXML
    private void addGPUToTable() {
        con = myConnection.getConnection();
        String name = gpuName.getText();
        if(name.isEmpty()){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Name cannot be empty!");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
        else{
            getQueryGPU();
            insertGPU();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage closeAddGPU = (Stage) cancelButton.getScene().getWindow();
                closeAddGPU.close();
            }catch (IOException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void insertGPU() {
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, gpuName.getText());
            ps.setDouble(2, Double.parseDouble(gpuPrice.getText()));
            ps.setString(3, gpuChipset.getText());
            ps.setString(4, gpuMemory.getText());
            ps.setString(5, gpuCoreClock.getText());
            ps.setString(6, gpuBoostClock.getText());
            ps.setString(7, gpuColour.getText());
            ps.setString(8, gpuLength.getText());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void getQueryGPU() {
        query = "INSERT INTO gpuDB (Name, Price, Chipset, Memory, coreClock, boostClock, Colour, Length) VALUES (?, ?, ?, ?, ? ,?, ?, ?)";
    }

    @FXML
    private void addRAMToTable() {
        con = myConnection.getConnection();
        String name = ramName.getText();
        if(name.isEmpty()){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Name cannot be empty!");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
        else{
            getQueryRAM();
            insertRAM();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage closeAddRAM = (Stage) cancelButton.getScene().getWindow();
                closeAddRAM.close();
            }catch (IOException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getQueryRAM() {
        query = "INSERT INTO ramDB (Name, Price, Speed, Module, Colour, firstWordLatency, casLatency, Length) VALUES (?, ?, ?, ?, ? ,?, ?, ?)";
    }

    private void insertRAM() {
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ramName.getText());
            ps.setDouble(2, Double.parseDouble(ramPrice.getText()));
            ps.setString(3, ramSpeed.getText());
            ps.setString(4, ramModule.getText());
            ps.setString(5, ramColour.getText());
            ps.setString(6, ramFirstWordLatency.getText());
            ps.setString(7, ramCasLatency.getText());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    private void addMonitorToTable() {
        con = myConnection.getConnection();
        String name = monitorName.getText();
        if(name.isEmpty()){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Name cannot be empty!");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
        else{
            getQueryMonitor();
            insertMonitor();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage closeAddMonitor = (Stage) cancelButton.getScene().getWindow();
                closeAddMonitor.close();
            }catch (IOException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getQueryMonitor() {
        query = "INSERT INTO monitorDB (Name, Price, screenSize, Resolution, refreshRate, responseTime, panelType, aspectRatio) VALUES (?, ?, ?, ?, ? ,?, ?, ?)";
    }

    private void insertMonitor() {
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, monitorName.getText());
            ps.setDouble(2, Double.parseDouble(monitorPrice.getText()));
            ps.setString(3, monitorScreenSize.getText());
            ps.setString(4, monitorResolution.getText());
            ps.setString(5, monitorRefreshRate.getText());
            ps.setString(6, monitorResponseTime.getText());
            ps.setString(7, monitorPanelType.getText());
            ps.setString(8, monitorAspectRatio.getText());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    private void addStorageToTable() {
        con = myConnection.getConnection();
        String name = storageName.getText();
        if(name.isEmpty()){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Name cannot be empty!");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
        else{
            getQueryStorage();
            insertStorage();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage closeAddStorage = (Stage) cancelButton.getScene().getWindow();
                closeAddStorage.close();
            }catch (IOException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getQueryStorage() {
        query = "INSERT INTO storageDB (Name, Price, Capacity, Type, Cache, Interface) VALUES (?, ?, ?, ?, ? ,?)";
    }

    private void insertStorage() {
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, storageName.getText());
            ps.setDouble(2, Double.parseDouble(storagePrice.getText()));
            ps.setString(3, storageCapacity.getText());
            ps.setString(4, storageType.getText());
            ps.setString(5, storageCache.getText());
            ps.setString(6, storageInterface.getText());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    private void addPowerSupplyToTable() {
        con = myConnection.getConnection();
        String name = powerSupplyName.getText();
        if(name.isEmpty()){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Name cannot be empty!");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
        else{
            getQueryPowerSupply();
            insertPowerSupply();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage closeAddPowerSupply = (Stage) cancelButton.getScene().getWindow();
                closeAddPowerSupply.close();
            }catch (IOException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getQueryPowerSupply() {
        query = "INSERT INTO powerSupplyDB (Name, Price, Wattage, Modular, Colour) VALUES (?, ?, ?, ?, ?)";
    }

    private void insertPowerSupply() {
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, powerSupplyName.getText());
            ps.setDouble(2, Double.parseDouble(powerSupplyPrice.getText()));
            ps.setString(3, powerSupplyWattage.getText());
            ps.setString(4, powerSupplyModular.getText());
            ps.setString(5, powerSupplyColour.getText());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    private void addMotherboardToTable() {
        con = myConnection.getConnection();
        String name = motherboardName.getText();
        if(name.isEmpty()){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Name cannot be empty!");
            errorDialog.showAndWait();
            System.out.println("Error!");
        }
        else{
            getQueryMotherboard();
            insertMotherboard();
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminEditWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage closeAddMotherboard = (Stage) cancelButton.getScene().getWindow();
                closeAddMotherboard.close();
            }catch (IOException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getQueryMotherboard() {
        query = "INSERT INTO motherboardDB (Name, Price, Socket, Memory, memorySlots, colour) VALUES (?, ?, ?, ?, ? ,?)";
    }

    private void insertMotherboard() {
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, motherboardName.getText());
            ps.setDouble(2, Double.parseDouble(motherboardPrice.getText()));
            ps.setString(3, motherboardSocket.getText());
            ps.setString(4, motherboardMemory.getText());
            ps.setString(5, motherboardMemorySlots.getText());
            ps.setString(6, motherboardColour.getText());
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
