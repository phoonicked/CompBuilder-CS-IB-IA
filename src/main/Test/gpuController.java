package com.application.compbuilder;


import customer_detail.myConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import javax.security.auth.callback.Callback;
import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gpuController implements Initializable {
    private Connection con = null;
    private ObservableList<GPU> data;

    @FXML
    private TableColumn<GPU, String> colPartNumber;

    @FXML
    private TableColumn<GPU, String> colBrand;

    @FXML
    public TableColumn<GPU, String> colModel;

    @FXML
    public TableColumn<GPU, String> colBenchmark;

    @FXML
    private TableView<GPU> gpuTable;

    @FXML
    private ChoiceBox<String> chooseBrand;

    @FXML
    private TextField searchText;

    private final String[] brand = {"AMD", "ASRock", "Asus", "EVGA", "Gainward", "Gigabyte", "Intel", "Microsoft", "MSI", "Nvidia", "Parallels", "PNY", "PowerColor", "PwrHis", "Sapphire", "Vmware", "XFX", "Zotac"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = myConnection.getConnection();
        data = FXCollections.observableArrayList();
        setCellTable();
        loadDataFromDatabase();
        chooseBrand.getItems().addAll(brand);

    }

    private void setCellTable(){
        colPartNumber.setCellValueFactory(new PropertyValueFactory<>("partNumber"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        colBenchmark.setCellValueFactory(new PropertyValueFactory<>("Benchmark"));
    }

    /* @FXML
    private void loadNewDisplay(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("test.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }

     */

    @FXML
    private void filterDB(){
        String searchCommand = searchText.getText();
        String choice = chooseBrand.getValue();
        if(choice != null){
            if(chooseBrand.getValue().equalsIgnoreCase("Asus")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Asus'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("AMD")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'AMD'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("ASRock")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'ASRock'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("EVGA")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'EVGA'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Gainward")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Gainward'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Gigabyte")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Gigabyte'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Intel")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Intel'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Microsoft")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Microsoft'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("MSI")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'MSI'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Nvidia")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Nvidia'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Parallels")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Parallels'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("PNY")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'PNY'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("PowerColor")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'PowerColor'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("PwrHis")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'PwrHis'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Sapphire")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Sapphire'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Vmware")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Vmware'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("XFX")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'XFX'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
            if(chooseBrand.getValue().equalsIgnoreCase("Zotac")){
                data.clear();
                try{
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE 'Zotac'");
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(data);
            }
        }
        if(searchCommand != null && choice == null){
            data.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Model LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
            }
            gpuTable.setItems(data);
        }
        else{
            data.clear();
            try{
             PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Brand LIKE '" + choice + "' AND Model LIKE '%" + searchCommand + "%'");
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
        } catch (SQLException exception) {
            Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
        }
        gpuTable.setItems(data);
        }
    }

    @FXML
    private void resetTable(){
        data.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
            chooseBrand.getSelectionModel().clearSelection();
            searchText.clear();
        } catch (SQLException ex){
            Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gpuTable.setItems(data);
    }

   /* @FXML
    private void searchDB(){
        String searchCommand = searchText.getText();
        data.clear();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Model LIKE '" + searchCommand + "'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
        } catch (SQLException exception) {
            Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    */

    private void loadDataFromDatabase(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.add(new GPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
        } catch (SQLException ex){
            Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gpuTable.setItems(data);
    }
}