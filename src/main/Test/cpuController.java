package com.application.compbuilder;


import customer_detail.myConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cpuController implements Initializable {
    private Connection con = null;
    private ObservableList<CPU> data;

    @FXML
    private TableColumn<CPU, String> colPartNumber;

    @FXML
    private TableColumn<CPU, String> colBrand;

    @FXML
    public TableColumn<CPU, String> colModel;

    @FXML
    public TableColumn<CPU, String> colBenchmark;

    @FXML
    public TableView<CPU> cpuTable;

    @FXML
    private ChoiceBox<String> chooseBrand;

    @FXML
    private TextField searchText;

    private final String[] brand = {"Intel", "AMD"};


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = myConnection.getConnection();
        data = FXCollections.observableArrayList();
        setCellTable();
        loadDataFromDatabase();
        chooseBrand.getItems().addAll(brand);
        cpuTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cpuTable.getSelectionModel().setCellSelectionEnabled(true);
    }

    @FXML
    private void filterDB() {
        String searchCommand = searchText.getText();
        String choice = chooseBrand.getValue();
        if(chooseBrand.getValue() != null){
            if (chooseBrand.getValue().equalsIgnoreCase("Intel")) {
                data.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Brand LIKE 'Intel'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data.add(new CPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(cpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                cpuTable.setItems(data);
            }
            if (chooseBrand.getValue().equalsIgnoreCase("AMD")) {
                data.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Brand LIKE 'AMD'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data.add(new CPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(cpuController.class.getName()).log(Level.SEVERE, null, exception);
                }
                cpuTable.setItems(data);
            }
        }
        if(searchCommand != null && chooseBrand.getValue() == null){
            data.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Model LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    data.add(new CPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
            }
            cpuTable.setItems(data);
        }
        else {
            data.clear();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Brand LIKE '" + choice + "' AND Model LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    data.add(new CPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(gpuController.class.getName()).log(Level.SEVERE, null, exception);
            }
            cpuTable.setItems(data);
        }
    }

    @FXML
    private void resetTable() {
        data.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(new CPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
            chooseBrand.getSelectionModel().clearSelection();
        } catch (SQLException ex) {
            Logger.getLogger(cpuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpuTable.setItems(data);
    }

    /* @FXML
    public void clickItem(MouseEvent event)
    {
        if (event.getButton() == 2) //Checking double click
        {
            System.out.println(cpuTable.getSelectionModel().getSelectedItem().getModel());
        }
    }
    */


    private void setCellTable() {
        colPartNumber.setCellValueFactory(new PropertyValueFactory<>("partNumber"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        colBenchmark.setCellValueFactory(new PropertyValueFactory<>("Benchmark"));

    }

    private void loadDataFromDatabase() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(new CPU(rs.getString("partNumber"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Benchmark")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(cpuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpuTable.setItems(data);
        //Getting model name
        //System.out.println(cpuTable.getItems().get(0).getModel());
    }

    //public String displaySelected() throws IOException, NoSuchMethodException {
    //}

    public String displaySelected()  {
        TablePosition tablePosition = cpuTable.getSelectionModel().getSelectedCells().get(0);
        int row = tablePosition.getRow();
        CPU item = cpuTable.getItems().get(row);
        TableColumn tableColumn = tablePosition.getTableColumn();
        String selectedItem = (String) tableColumn.getCellObservableValue(item).getValue();
        System.out.println(selectedItem);
        return selectedItem;
    }
}