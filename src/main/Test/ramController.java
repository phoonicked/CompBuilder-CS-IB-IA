package com.application.compbuilder;


import com.mysql.cj.xdevapi.Table;
import customer_detail.myConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ramController implements Initializable {
    private Connection con = null;
    private ObservableList<RAM> data;

    @FXML
    private TableColumn<RAM, String> colPartNumber;

    @FXML
    private TableColumn<RAM, String> colBrand;

    @FXML
    public TableColumn<RAM, String> colModel;

    @FXML
    public TableColumn<RAM, String> colBenchmark;

    @FXML
    public TableColumn<RAM, Button> colAction;

    @FXML
    private TableView<RAM> ramTable;

    @FXML
    private ChoiceBox<String> chooseBrand;

    private String[] brand = {"Crucial", "G.SKILL", "HyperX", "Corsair"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = myConnection.getConnection();
        data = FXCollections.observableArrayList();
        setCellTable();
        loadDataFromDatabase();
        chooseBrand.getItems().addAll(brand);
    }

    @FXML
    private void filterDB(){
        if(chooseBrand.getValue().equalsIgnoreCase("Corsair")){
            data.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Brand LIKE 'Corsair'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    data.add(new RAM(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(ramController.class.getName()).log(Level.SEVERE, null, exception);
            }
            ramTable.setItems(data);
        }
        if(chooseBrand.getValue().equalsIgnoreCase("Crucial")){
            data.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Brand LIKE 'Crucial'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    data.add(new RAM(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(ramController.class.getName()).log(Level.SEVERE, null, exception);
            }
            ramTable.setItems(data);
        }
        if(chooseBrand.getValue().equalsIgnoreCase("G.SKILL")){
            data.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Brand LIKE 'G.SKILL'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    data.add(new RAM(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(ramController.class.getName()).log(Level.SEVERE, null, exception);
            }
            ramTable.setItems(data);
        }
        if(chooseBrand.getValue().equalsIgnoreCase("HyperX")){
            data.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Brand LIKE 'HyperX'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    data.add(new RAM(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(ramController.class.getName()).log(Level.SEVERE, null, exception);
            }
            ramTable.setItems(data);
        }
    }

    @FXML
    private void resetTable(){
        data.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.add(new RAM(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
            chooseBrand.getSelectionModel().clearSelection();
        } catch (SQLException ex){
            Logger.getLogger(ramController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ramTable.setItems(data);
    }

    private void setCellTable(){
        colPartNumber.setCellValueFactory(new PropertyValueFactory<>("partNumber"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        colBenchmark.setCellValueFactory(new PropertyValueFactory<>("Benchmark"));
    }

    private void loadDataFromDatabase(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.add(new RAM(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
        } catch (SQLException ex){
            Logger.getLogger(ramController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ramTable.setItems(data);
    }
}