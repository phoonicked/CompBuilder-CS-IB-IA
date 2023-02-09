package com.application.compbuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class adminEditController implements Initializable{
    private Connection con = null;
    private ObservableList<CPU> cpuData;
    private ObservableList<GPU> gpuData;
    private ObservableList<RAM> ramData;
    private ObservableList<Monitor> monitorData;
    private ObservableList<Motherboard> motherboardData;
    private ObservableList<powerSupply> powerSupplyData;
    private ObservableList<Storage> storageData;


    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteCPU;

    @FXML
    private Button deleteGPU;

    @FXML
    private Button deleteRAM;

    @FXML
    private Button deleteMotherboard;

    @FXML
    private Button deleteStorage;

    @FXML
    private Button deletePowerSupply;

    @FXML
    private Button deleteMonitor;

    @FXML
    private Button editCPU;

    @FXML
    private Button editGPU;

    @FXML
    private Button editRAM;

    @FXML
    private Button editMonitor;

    @FXML
    private Button editMotherboard;

    @FXML
    private Button editStorage;

    @FXML
    private Button editPowerSupply;


    @FXML
    public TableView<CPU> cpuTable;

    @FXML
    public TableView<RAM> ramTable;

    @FXML
    public TableView<GPU> gpuTable;

    @FXML
    public TableView<Monitor> monitorTable;

    @FXML
    public TableView<powerSupply> powerSupplyTable;

    @FXML
    public TableView<Motherboard> motherboardTable;

    @FXML
    public TableView<Storage> storageTable;

    @FXML
    private TableColumn<CPU, String> colCPUName;

    @FXML
    public TableColumn<CPU, Double> colCPUPrice;

    @FXML
    private TableColumn<CPU, String> colCPUCoreCount;

    @FXML
    public TableColumn<CPU, String> colCPUCoreClock;

    @FXML
    public TableColumn<CPU, String> colCPUBoostClock;

    @FXML
    public TableColumn<CPU, String> colCPUtdp;

    @FXML
    public TableColumn<CPU, String> colCPUIntegratedGraphics;

    @FXML
    public TableColumn<CPU, String> colCPUsmt;

    @FXML
    private TableColumn<GPU, String> colGPUName;

    @FXML
    private TableColumn<GPU, Double> colGPUPrice;

    @FXML
    private TableColumn<GPU, String> colGPUChipset;

    @FXML
    private TableColumn<GPU, Double> colGPUMemory;

    @FXML
    private TableColumn<GPU, Double> colGPUCoreClock;

    @FXML
    private TableColumn<GPU, Double> colGPUBoostClock;

    @FXML
    private TableColumn<GPU, Double> colGPUColour;

    @FXML
    private TableColumn<GPU, Double> colGPULength;

    @FXML
    private TableColumn<RAM, String> colRAMName;

    @FXML
    private TableColumn<RAM, Double> colRAMPrice;

    @FXML
    public TableColumn<RAM, String> colRAMSpeed;

    @FXML
    public TableColumn<RAM, String> colRAMModule;

    @FXML
    public TableColumn<RAM, String> colRAMColour;

    @FXML
    public TableColumn<RAM, String> colRAMFirstWordLatency;

    @FXML
    public TableColumn<RAM, String> colRAMCasLatency;

    @FXML
    private TableColumn<Motherboard, String> colMBName;

    @FXML
    private TableColumn<Motherboard, Double> colMBPrice;

    @FXML
    private TableColumn<Motherboard, String> colMBSocket;

    @FXML
    private TableColumn<Motherboard, String> colMBMemory;

    @FXML
    private TableColumn<Motherboard, Integer> colMBMemorySlots;

    @FXML
    private TableColumn<Motherboard, String> colMBColour;

    @FXML
    private TableColumn<powerSupply, String> colPSName;

    @FXML
    private TableColumn<powerSupply, Double> colPSPrice;

    @FXML
    private TableColumn<powerSupply, String> colPSWattage;

    @FXML
    private TableColumn<powerSupply, String> colPSModular;

    @FXML
    private TableColumn<powerSupply, String> colPSColour;

    @FXML
    private TableColumn<Storage, String> colStorageName;

    @FXML
    private TableColumn<Storage, Double> colStoragePrice;

    @FXML
    private TableColumn<Storage, String> colStorageCapacity;

    @FXML
    private TableColumn<Storage, String> colStorageType;

    @FXML
    private TableColumn<Storage, String> colStorageCache;

    @FXML
    private TableColumn<Storage, String> colStorageInterface;

    @FXML
    private TableColumn<Monitor, String> colMonName;

    @FXML
    private TableColumn<Monitor, Double> colMonPrice;

    @FXML
    private TableColumn<Monitor, String> colMonScreenSize;

    @FXML
    private TableColumn<Monitor, String> colMonResolution;

    @FXML
    private TableColumn<Monitor, String> colMonRefRate;

    @FXML
    private TableColumn<Monitor, String> colMonResponseTime;

    @FXML
    private TableColumn<Monitor, String> colMonPanelType;

    @FXML
    private TableColumn<Monitor, String> colMonAspectRatio;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void windowDispose() throws IOException {
        Stage closeEditWindow = (Stage) cancelButton.getScene().getWindow();
        closeEditWindow.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homeAdmin.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void BootAddCPU() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addCPUWindow.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
    }

    @FXML
    private void removeCPU() throws SQLException {
        String query = "DELETE FROM cpuDB WHERE Name = '" + cpuTable.getSelectionModel().getSelectedItem().getName() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted. Refresh the table by clicking on the CPU button.");
        deletionConfirmation.showAndWait();
    }


    @FXML
    private void BootAddGPU() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addGPUWindow.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void removeGPU() throws SQLException {
        String query = "DELETE FROM gpuDB WHERE Name = '" + gpuTable.getSelectionModel().getSelectedItem().getName() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted. Refresh the table by clicking on the Video Memory button.");
        deletionConfirmation.showAndWait();
    }

    @FXML
    private void BootAddRAM() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addRAMWindow.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void removeRAM() throws SQLException {
        String query = "DELETE FROM ramDB WHERE Name = '" + ramTable.getSelectionModel().getSelectedItem().getName() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted. Refresh the table by clicking on the Memory button.");
        deletionConfirmation.showAndWait();
    }

    @FXML
    private void BootAddMotherboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addMotherboardWindow.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void removeMotherboard() throws SQLException {
        String query = "DELETE FROM motherboardDB WHERE Name = '" + motherboardTable.getSelectionModel().getSelectedItem().getName() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted. Refresh the table by clicking on the Motherboard button.");
        deletionConfirmation.showAndWait();
    }

    @FXML
    private void BootAddMonitor() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addMonitorWindow.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void removeMonitor() throws SQLException {
        String query = "DELETE FROM monitorDB WHERE Name = '" + monitorTable.getSelectionModel().getSelectedItem().getName() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted. Refresh the table by clicking on the Monitor button.");
        deletionConfirmation.showAndWait();
    }

    @FXML
    private void BootAddStorage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addStorageWindow.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void removeStorage() throws SQLException {
        String query = "DELETE FROM storageDB WHERE Name = '" + storageTable.getSelectionModel().getSelectedItem().getName() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted. Refresh the table by clicking on the Storage button.");
        deletionConfirmation.showAndWait();
    }

    @FXML
    private void BootAddPowerSupply() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addPowerSupplyWindow.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void removePowerSupply() throws SQLException {
        String query = "DELETE FROM powerSupplyDB WHERE Name = '" + powerSupplyTable.getSelectionModel().getSelectedItem().getName() + "'";
        PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
        ps.execute();
        Alert deletionConfirmation = new Alert(Alert.AlertType.INFORMATION);
        deletionConfirmation.setContentText("The selected row has been deleted. Refresh the table by clicking on the Power Supply button.");
        deletionConfirmation.showAndWait();
    }



    @FXML
    private void showCPUTable(){
        deleteStorage.setOpacity(0);
        deleteStorage.setDisable(true);
        deletePowerSupply.setOpacity(0);
        deletePowerSupply.setDisable(true);
        deleteMotherboard.setOpacity(0);
        deleteMotherboard.setDisable(true);
        deleteMonitor.setOpacity(0);
        deleteMonitor.setDisable(true);
        deleteCPU.setOpacity(1);
        deleteCPU.setDisable(false);
        deleteGPU.setOpacity(0);
        deleteGPU.setDisable(true);
        deleteRAM.setOpacity(0);
        deleteRAM.setDisable(true);
        editStorage.setOpacity(0);
        editStorage.setDisable(true);
        editPowerSupply.setOpacity(0);
        editPowerSupply.setDisable(true);
        editMotherboard.setOpacity(0);
        editMotherboard.setDisable(true);
        editMonitor.setOpacity(0);
        editMonitor.setDisable(true);
        editCPU.setOpacity(1);
        editCPU.setDisable(false);
        editGPU.setOpacity(0);
        editGPU.setDisable(true);
        editRAM.setOpacity(0);
        editRAM.setDisable(true);
        cpuTable.setOpacity(1);
        cpuTable.setDisable(false);
        gpuTable.setOpacity(0);
        gpuTable.setDisable(true);
        ramTable.setOpacity(0);
        ramTable.setDisable(true);
        monitorTable.setOpacity(0);
        monitorTable.setDisable(true);
        storageTable.setOpacity(0);
        storageTable.setDisable(true);
        powerSupplyTable.setOpacity(0);
        powerSupplyTable.setDisable(true);
        motherboardTable.setOpacity(0);
        motherboardTable.setDisable(true);
        con = myConnection.getConnection();
        cpuData = FXCollections.observableArrayList();
        setCPUCellTable();
        loadCPUDataFromDatabase();
        System.out.println("cpuTable is booted!");
    }

    private void setCPUCellTable() {
        colCPUName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colCPUPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colCPUCoreCount.setCellValueFactory(new PropertyValueFactory<>("coreCount"));
        colCPUCoreClock.setCellValueFactory(new PropertyValueFactory<>("coreClock"));
        colCPUBoostClock.setCellValueFactory(new PropertyValueFactory<>("boostClock"));
        colCPUtdp.setCellValueFactory(new PropertyValueFactory<>("tdp"));
        colCPUIntegratedGraphics.setCellValueFactory(new PropertyValueFactory<>("integratedGraphics"));
        colCPUsmt.setCellValueFactory(new PropertyValueFactory<>("smt"));
    }

    private void loadCPUDataFromDatabase() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpuTable.setItems(cpuData);
        //Getting model name
        //System.out.println(cpuTable.getItems().get(0).getModel());
    }

    @FXML
    private void showGPUTable(){
        deleteStorage.setOpacity(0);
        deleteStorage.setDisable(true);
        deletePowerSupply.setOpacity(0);
        deletePowerSupply.setDisable(true);
        deleteMotherboard.setOpacity(0);
        deleteMotherboard.setDisable(true);
        deleteMonitor.setOpacity(0);
        deleteMonitor.setDisable(true);
        deleteRAM.setOpacity(0);
        deleteRAM.setDisable(true);
        deleteCPU.setOpacity(0);
        deleteCPU.setDisable(true);
        deleteGPU.setOpacity(1);
        deleteGPU.setDisable(false);
        editStorage.setOpacity(0);
        editStorage.setDisable(true);
        editPowerSupply.setOpacity(0);
        editPowerSupply.setDisable(true);
        editMotherboard.setOpacity(0);
        editMotherboard.setDisable(true);
        editMonitor.setOpacity(0);
        editMonitor.setDisable(true);
        editRAM.setOpacity(0);
        editRAM.setDisable(true);
        editCPU.setOpacity(0);
        editCPU.setDisable(true);
        editGPU.setOpacity(1);
        editGPU.setDisable(false);
        cpuTable.setOpacity(0);
        cpuTable.setDisable(true);
        ramTable.setOpacity(0);
        ramTable.setDisable(true);
        gpuTable.setOpacity(1);
        gpuTable.setDisable(false);
        monitorTable.setOpacity(0);
        monitorTable.setDisable(true);
        storageTable.setOpacity(0);
        storageTable.setDisable(true);
        powerSupplyTable.setOpacity(0);
        powerSupplyTable.setDisable(true);
        motherboardTable.setOpacity(0);
        motherboardTable.setDisable(true);
        con = myConnection.getConnection();
        gpuData = FXCollections.observableArrayList();
        setGPUCellTable();
        loadGPUDataFromDatabase();
        System.out.println("gpuTable is booted!");
    }

    private void setGPUCellTable() {
        colGPUName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colGPUPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colGPUChipset.setCellValueFactory(new PropertyValueFactory<>("Chipset"));
        colGPUMemory.setCellValueFactory(new PropertyValueFactory<>("Memory"));
        colGPUCoreClock.setCellValueFactory(new PropertyValueFactory<>("coreClock"));
        colGPUBoostClock.setCellValueFactory(new PropertyValueFactory<>("boostClock"));
        colGPUColour.setCellValueFactory(new PropertyValueFactory<>("Colour"));
        colGPULength.setCellValueFactory(new PropertyValueFactory<>("Length"));
    }

    private void loadGPUDataFromDatabase() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gpuTable.setItems(gpuData);
        //Getting model name
        //System.out.println(cpuTable.getItems().get(0).getModel());
    }

    @FXML
    private void showRAMTable(){
        deleteStorage.setOpacity(0);
        deleteStorage.setDisable(true);
        deletePowerSupply.setOpacity(0);
        deletePowerSupply.setDisable(true);
        deleteMotherboard.setOpacity(0);
        deleteMotherboard.setDisable(true);
        deleteMonitor.setOpacity(0);
        deleteMonitor.setDisable(true);
        deleteRAM.setOpacity(1);
        deleteRAM.setDisable(false);
        deleteCPU.setOpacity(0);
        deleteCPU.setDisable(true);
        deleteGPU.setOpacity(0);
        deleteGPU.setDisable(true);
        editStorage.setOpacity(0);
        editStorage.setDisable(true);
        editPowerSupply.setOpacity(0);
        editPowerSupply.setDisable(true);
        editMotherboard.setOpacity(0);
        editMotherboard.setDisable(true);
        editMonitor.setOpacity(0);
        editMonitor.setDisable(true);
        editRAM.setOpacity(1);
        editRAM.setDisable(false);
        editCPU.setOpacity(0);
        editCPU.setDisable(true);
        editGPU.setOpacity(0);
        editGPU.setDisable(true);
        cpuTable.setOpacity(0);
        cpuTable.setDisable(false);
        gpuTable.setOpacity(0);
        gpuTable.setDisable(true);
        ramTable.setOpacity(1);
        ramTable.setDisable(false);
        monitorTable.setOpacity(0);
        monitorTable.setDisable(true);
        storageTable.setOpacity(0);
        storageTable.setDisable(true);
        powerSupplyTable.setOpacity(0);
        powerSupplyTable.setDisable(true);
        motherboardTable.setOpacity(0);
        motherboardTable.setDisable(true);
        con = myConnection.getConnection();
        ramData = FXCollections.observableArrayList();
        setRAMCellTable();
        loadRAMDataFromDatabase();
        System.out.println("ramTable is booted!");
    }

    private void setRAMCellTable() {
        colRAMName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colRAMPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colRAMSpeed.setCellValueFactory(new PropertyValueFactory<>("Speed"));
        colRAMModule.setCellValueFactory(new PropertyValueFactory<>("Module"));
        colRAMColour.setCellValueFactory(new PropertyValueFactory<>("Colour"));
        colRAMFirstWordLatency.setCellValueFactory(new PropertyValueFactory<>("firstWordLatency"));
        colRAMCasLatency.setCellValueFactory(new PropertyValueFactory<>("casLatency"));
    }

    private void loadRAMDataFromDatabase() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ramTable.setItems(ramData);
        //Getting model name
        //System.out.println(cpuTable.getItems().get(0).getModel());
    }

    @FXML
    private void showStorageTable() {
        deleteStorage.setOpacity(1);
        deleteStorage.setDisable(false);
        deletePowerSupply.setOpacity(0);
        deletePowerSupply.setDisable(true);
        deleteMotherboard.setOpacity(0);
        deleteMotherboard.setDisable(true);
        deleteMonitor.setOpacity(0);
        deleteMonitor.setDisable(true);
        deleteRAM.setOpacity(0);
        deleteRAM.setDisable(true);
        deleteCPU.setOpacity(0);
        deleteCPU.setDisable(true);
        deleteGPU.setOpacity(0);
        deleteGPU.setDisable(true);
        editStorage.setOpacity(1);
        editStorage.setDisable(false);
        editPowerSupply.setOpacity(0);
        editPowerSupply.setDisable(true);
        editMotherboard.setOpacity(0);
        editMotherboard.setDisable(true);
        editMonitor.setOpacity(0);
        editMonitor.setDisable(true);
        editRAM.setOpacity(0);
        editRAM.setDisable(true);
        editCPU.setOpacity(0);
        editCPU.setDisable(true);
        editGPU.setOpacity(0);
        editGPU.setDisable(true);
        cpuTable.setOpacity(0);
        cpuTable.setDisable(false);
        gpuTable.setOpacity(0);
        gpuTable.setDisable(true);
        ramTable.setOpacity(0);
        ramTable.setDisable(true);
        monitorTable.setOpacity(0);
        monitorTable.setDisable(true);
        storageTable.setOpacity(1);
        storageTable.setDisable(false);
        powerSupplyTable.setOpacity(0);
        powerSupplyTable.setDisable(true);
        motherboardTable.setOpacity(0);
        motherboardTable.setDisable(true);
        con = myConnection.getConnection();
        storageData = FXCollections.observableArrayList();
        setStorageCellTable();
        loadStorageDataFromDatabase();
        System.out.println("storageTable is booted!");
    }

    private void setStorageCellTable() {
        colStorageName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colStoragePrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colStorageCapacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        colStorageType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colStorageCache.setCellValueFactory(new PropertyValueFactory<>("Cache"));
        colStorageInterface.setCellValueFactory(new PropertyValueFactory<>("Interface"));
    }

    private void loadStorageDataFromDatabase() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        storageTable.setItems(storageData);
        //Getting model name
        //System.out.println(cpuTable.getItems().get(0).getModel());
    }

    @FXML
    private void showPowerSupplyTable() {
        deleteStorage.setOpacity(0);
        deleteStorage.setDisable(true);
        deletePowerSupply.setOpacity(1);
        deletePowerSupply.setDisable(false);
        deleteMotherboard.setOpacity(0);
        deleteMotherboard.setDisable(true);
        deleteMonitor.setOpacity(0);
        deleteMonitor.setDisable(true);
        deleteRAM.setOpacity(0);
        deleteRAM.setDisable(true);
        deleteCPU.setOpacity(0);
        deleteCPU.setDisable(true);
        deleteGPU.setOpacity(0);
        deleteGPU.setDisable(true);
        editStorage.setOpacity(0);
        editStorage.setDisable(true);
        editPowerSupply.setOpacity(1);
        editPowerSupply.setDisable(false);
        editMotherboard.setOpacity(0);
        editMotherboard.setDisable(true);
        editMonitor.setOpacity(0);
        editMonitor.setDisable(true);
        editRAM.setOpacity(0);
        editRAM.setDisable(true);
        editCPU.setOpacity(0);
        editCPU.setDisable(true);
        editGPU.setOpacity(0);
        editGPU.setDisable(true);
        cpuTable.setOpacity(0);
        cpuTable.setDisable(false);
        gpuTable.setOpacity(0);
        gpuTable.setDisable(true);
        ramTable.setOpacity(0);
        ramTable.setDisable(true);
        monitorTable.setOpacity(0);
        monitorTable.setDisable(true);
        storageTable.setOpacity(0);
        storageTable.setDisable(true);
        powerSupplyTable.setOpacity(1);
        powerSupplyTable.setDisable(false);
        motherboardTable.setOpacity(0);
        motherboardTable.setDisable(true);
        con = myConnection.getConnection();
        powerSupplyData = FXCollections.observableArrayList();
        setPowerSupplyCellTable();
        loadPowerSupplyDataFromDatabase();
        System.out.println("powerSupplyTable is booted!");
    }

    private void setPowerSupplyCellTable() {
        colPSName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colPSPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colPSWattage.setCellValueFactory(new PropertyValueFactory<>("Wattage"));
        colPSModular.setCellValueFactory(new PropertyValueFactory<>("Modular"));
        colPSColour.setCellValueFactory(new PropertyValueFactory<>("Colour"));
    }

    private void loadPowerSupplyDataFromDatabase() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        powerSupplyTable.setItems(powerSupplyData);
        //Getting model name
        //System.out.println(cpuTable.getItems().get(0).getModel());
    }

    @FXML
    private void showMotherboardTable() {
        deleteStorage.setOpacity(0);
        deleteStorage.setDisable(true);
        deletePowerSupply.setOpacity(0);
        deletePowerSupply.setDisable(true);
        deleteMotherboard.setOpacity(1);
        deleteMotherboard.setDisable(false);
        deleteMonitor.setOpacity(0);
        deleteMonitor.setDisable(true);
        deleteRAM.setOpacity(0);
        deleteRAM.setDisable(true);
        deleteCPU.setOpacity(0);
        deleteCPU.setDisable(true);
        deleteGPU.setOpacity(0);
        deleteGPU.setDisable(true);
        editStorage.setOpacity(0);
        editStorage.setDisable(true);
        editPowerSupply.setOpacity(0);
        editPowerSupply.setDisable(true);
        editMotherboard.setOpacity(1);
        editMotherboard.setDisable(false);
        editMonitor.setOpacity(0);
        editMonitor.setDisable(true);
        editRAM.setOpacity(0);
        editRAM.setDisable(true);
        editCPU.setOpacity(0);
        editCPU.setDisable(true);
        editGPU.setOpacity(0);
        editGPU.setDisable(true);
        cpuTable.setOpacity(0);
        cpuTable.setDisable(false);
        gpuTable.setOpacity(0);
        gpuTable.setDisable(true);
        ramTable.setOpacity(0);
        ramTable.setDisable(true);
        monitorTable.setOpacity(0);
        monitorTable.setDisable(true);
        storageTable.setOpacity(0);
        storageTable.setDisable(true);
        powerSupplyTable.setOpacity(0);
        powerSupplyTable.setDisable(true);
        motherboardTable.setOpacity(1);
        motherboardTable.setDisable(false);
        con = myConnection.getConnection();
        motherboardData = FXCollections.observableArrayList();
        setMotherboardCellTable();
        loadMotherboardDataFromDatabase();
        System.out.println("motherboardTable is booted!");
    }

    private void setMotherboardCellTable() {
        colMBName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colMBPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colMBSocket.setCellValueFactory(new PropertyValueFactory<>("Socket"));
        colMBMemory.setCellValueFactory(new PropertyValueFactory<>("Memory"));
        colMBMemorySlots.setCellValueFactory(new PropertyValueFactory<>("memorySlots"));
        colMBColour.setCellValueFactory(new PropertyValueFactory<>("Colour"));
    }

    private void loadMotherboardDataFromDatabase() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        motherboardTable.setItems(motherboardData);
        //Getting model name
        //System.out.println(cpuTable.getItems().get(0).getModel());
    }

    @FXML
    private void showMonitorTable(){
        deleteStorage.setOpacity(0);
        deleteStorage.setDisable(true);
        deletePowerSupply.setOpacity(0);
        deletePowerSupply.setDisable(true);
        deleteMotherboard.setOpacity(0);
        deleteMotherboard.setDisable(true);
        deleteMonitor.setOpacity(1);
        deleteMonitor.setDisable(false);
        deleteRAM.setOpacity(0);
        deleteRAM.setDisable(true);
        deleteCPU.setOpacity(0);
        deleteCPU.setDisable(true);
        deleteGPU.setOpacity(0);
        deleteGPU.setDisable(true);
        editStorage.setOpacity(0);
        editStorage.setDisable(true);
        editPowerSupply.setOpacity(0);
        editPowerSupply.setDisable(true);
        editMotherboard.setOpacity(0);
        editMotherboard.setDisable(true);
        editMonitor.setOpacity(1);
        editMonitor.setDisable(false);
        editRAM.setOpacity(0);
        editRAM.setDisable(true);
        editCPU.setOpacity(0);
        editCPU.setDisable(true);
        editGPU.setOpacity(0);
        editGPU.setDisable(true);
        cpuTable.setOpacity(0);
        cpuTable.setDisable(false);
        gpuTable.setOpacity(0);
        gpuTable.setDisable(true);
        ramTable.setOpacity(0);
        ramTable.setDisable(true);
        monitorTable.setOpacity(1);
        monitorTable.setDisable(false);
        storageTable.setOpacity(0);
        storageTable.setDisable(true);
        powerSupplyTable.setOpacity(0);
        powerSupplyTable.setDisable(true);
        motherboardTable.setOpacity(0);
        motherboardTable.setDisable(true);
        con = myConnection.getConnection();
        monitorData = FXCollections.observableArrayList();
        setMonCellTable();
        loadMonDataFromDatabase();
        System.out.println("monTable is booted!");

    }

    private void setMonCellTable(){
        colMonName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colMonPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colMonScreenSize.setCellValueFactory(new PropertyValueFactory<>("screenSize"));
        colMonResolution.setCellValueFactory(new PropertyValueFactory<>("Resolution"));
        colMonRefRate.setCellValueFactory(new PropertyValueFactory<>("refreshRate"));
        colMonResponseTime.setCellValueFactory(new PropertyValueFactory<>("responseTime"));
        colMonPanelType.setCellValueFactory(new PropertyValueFactory<>("panelType"));
        colMonAspectRatio.setCellValueFactory(new PropertyValueFactory<>("aspectRatio"));
    }

    private void loadMonDataFromDatabase(){
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
            }

        } catch (SQLException exception) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
        }
        monitorTable.setItems(monitorData);
    }
}
