package com.application.compbuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sysBuildController implements Initializable {
    private Connection con = null;
    private ObservableList<CPU> cpuData;
    private ObservableList<GPU> gpuData;
    private ObservableList<RAM> ramData;
    private ObservableList<Monitor> monitorData;
    private ObservableList<Motherboard> motherboardData;
    private ObservableList<powerSupply> powerSupplyData;
    private ObservableList<Storage> storageData;

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


//--------------------------------------------------------------------------

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

//--------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------

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


    //--------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------

    @FXML
    public TableView<CPU> cpuTable;

    @FXML
    public TableView<GPU> gpuTable;

    @FXML
    public TableView<RAM> ramTable;

    @FXML
    public TableView<Monitor> monTable;

    @FXML
    public TableView<powerSupply> powerSupplyTable;

    @FXML
    public TableView<Motherboard> motherboardTable;

    @FXML
    public TableView<Storage> storageTable;
    //--------------------------------------------------------------------------

    @FXML
    private ChoiceBox<String> chooseCPUBrand;

    @FXML
    private ChoiceBox<String> chooseGPUBrand;

    @FXML
    private ChoiceBox<String> chooseStorageBrand;

    @FXML
    private ChoiceBox<String> chooseRAMBrand;

    @FXML
    private ChoiceBox<String> chooseMonBrand;

    @FXML
    private ChoiceBox<String> chooseMBBrand;

    @FXML
    private ChoiceBox<String> choosePSBrand;

    @FXML
    private ChoiceBox<String> chooseCPUPrice;

    @FXML
    private ChoiceBox <String> chooseGPUPrice;

    @FXML
    private ChoiceBox <String> chooseStoragePrice;

    @FXML
    private ChoiceBox <String> chooseRAMPrice;

    @FXML
    private ChoiceBox <String> chooseMonitorPrice;

    @FXML
    private ChoiceBox <String> chooseMotherboardPrice;

    @FXML
    private ChoiceBox<String> choosePowerSupplyPrice;

    //--------------------------------------------------------------------------

    @FXML
    private Button cancelCPUSelection;

    @FXML
    private Button cancelPSSelection;

    @FXML
    private Button cancelGPUSelection;

    @FXML
    private Button cancelRAMSelection;

    @FXML
    private Button cancelMonSelection;

    @FXML
    private Button cancelMotherboardSelection;

    @FXML
    private Button cancelStorageSelection;

    //--------------------------------------------------------------------------

    @FXML
    private Button selectCPU;

    @FXML
    private Button selectGPU;

    @FXML
    private Button selectMotherboard;

    @FXML
    private Button selectStorage;

    @FXML
    private Button selectRAM;

    @FXML
    private Button selectMon;

    @FXML
    private Button selectPS;

    @FXML
    private Text totalPrice;

    @FXML
    private TextField displayTotalPrice;

    @FXML
    private TextField displayStorageName;

    @FXML
    private TextField displayStoragePrice;

    @FXML
    private TextField displayPSName;

    @FXML
    private TextField displayPSPrice;

    @FXML
    private TextField displayCPUModel;

    @FXML
    private TextField displayCPUPrice;

    @FXML
    private TextField displayRAMPrice;

    @FXML
    private TextField displayMotherboardName;

    @FXML
    private TextField displayMotherboardPrice;

    @FXML
    private TextField displayGPUPrice;

    @FXML
    private TextField displayMonPrice;

    @FXML
    private TextField displayGPUModel;

    @FXML
    private TextField displayRAMModel;

    @FXML
    private TextField displayMonModel;

    @FXML
    private TextField searchTextCPU;

    @FXML
    private TextField searchTextGPU;

    @FXML
    private TextField searchTextRAM;

    @FXML
    private TextField searchTextMon;

    @FXML
    private TextField searchTextPS;

    @FXML
    private TextField searchTextMotherboard;

    @FXML
    private TextField searchTextStorage;

    private final String[] cpuBrand = {"Intel", "AMD"};

    private final String[] gpuBrand = {"AMD", "Gigabyte", "Asus", "EVGA", "MSI", "Nvidia", "PNY", "PowerColor", "XFX", "Sapphire", "Zotac"};

    private final String[] ramBrand = {"Crucial", "G.SKILL", "Corsair", "Team", "OLOy", "Kingston", "ADATA"};

    private final String[] monBrand = {"Dell", "Asus", "VIOTEK", "Sceptre", "Samsung", "Philips", "MSI", "LG", "HP", "BenQ", "Gigabyte", "Alienware", "AOC"};

    private final String[] motherboardBrand = {"ASRock", "Gigabyte", "NZXT", "Asus", "MSI"};

    private final String[] powerSupplyBrand = {"Antec", "Corsair", "Cooler Master", "EVGA", "Gigabyte", "NZXT", "SeaSonic", "Asus", "Thermaltake", "MSI", "ARESGAME", "be quiet!", "Aerocool"};

    private final String[] storageBrand = {"Western Digital", "Team", "SK Hynix", "Seagate", "Samsung", "Sabrent", "Mushkin", "Kingston", "Intel", "Crucial", "Corsair", "Angelbird", "ADATA"};

    private final String[] cpuPriceRange = {"$0-200", "$201-400", "$401-600", "$600+"};

    private final String[] gpuPriceRange = {"$0-200", "$201-400", "$401-600","$601-800", "$801-1000", "$1000+"};

    private final String[] monitorPriceRange = {"$0-200", "$201-400", "$401-600", "$601-800", "$800+"};

    private final String[] ramPriceRange = {"$0-200", "$201-400", "$401-600", "$600+"};

    private final String[] motherboardPriceRange ={"$0-200", "$201-400", "$401-600", "$600+"};

    private final String[] storagePriceRange = {"$0-200", "$201-400", "$401-600","$601-800", "$801-1000", "$1000+"};

    private final String[] powerSupplyPriceRange = {"$0-200", "$201-400", "$401-600", "$600+"};

    @FXML
    private Button quitButton;

    @FXML
    private AnchorPane addCPU;

    @FXML
    private AnchorPane addStorage;

    @FXML
    private AnchorPane addGPU;

    @FXML
    private AnchorPane addRAM;

    @FXML
    private AnchorPane addMon;

    @FXML
    private AnchorPane addMotherboard;

    @FXML
    private AnchorPane addPowerSupply;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Choice boxes are filled here to stop them from re-filled again everytime the reset button is clicked
        chooseCPUBrand.getItems().addAll(cpuBrand);
        chooseGPUBrand.getItems().addAll(gpuBrand);
        chooseRAMBrand.getItems().addAll(ramBrand);
        chooseMonBrand.getItems().addAll(monBrand);
        chooseMBBrand.getItems().addAll(motherboardBrand);
        choosePSBrand.getItems().addAll(powerSupplyBrand);
        chooseStorageBrand.getItems().addAll(storageBrand);
        chooseCPUPrice.getItems().addAll(cpuPriceRange);
        chooseRAMPrice.getItems().addAll(ramPriceRange);
        chooseMonitorPrice.getItems().addAll(monitorPriceRange);
        chooseStoragePrice.getItems().addAll(storagePriceRange);
        chooseMotherboardPrice.getItems().addAll(motherboardPriceRange);
        chooseGPUPrice.getItems().addAll(gpuPriceRange);
        choosePowerSupplyPrice.getItems().addAll(powerSupplyPriceRange);
    }


    @FXML
    public void totalPrice(Double price) {
        double total;
        if (displayTotalPrice.getText().isBlank()) {
            total = price;
        } else {
            total = Double.parseDouble(displayTotalPrice.getText()) + price;
        }
        displayTotalPrice.setText(String.valueOf(total));
    }

           /*
SEPARATION
 */

    @FXML
    private void showStorageTable() {
        totalPrice.setOpacity(0);
        totalPrice.setDisable(true);
        displayTotalPrice.setOpacity(0);
        displayTotalPrice.setDisable(false);
        addPowerSupply.setOpacity(0);
        addPowerSupply.setDisable(true);
        addGPU.setOpacity(0);
        addGPU.setDisable(true);
        addRAM.setOpacity(0);
        addRAM.setDisable(true);
        addMon.setOpacity(0);
        addMon.setDisable(true);
        addCPU.setOpacity(0);
        addCPU.setDisable(true);
        addMotherboard.setOpacity(0);
        addMotherboard.setDisable(true);
        addStorage.setOpacity(1);
        addStorage.setDisable(false);
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
    }

    @FXML
    private void resetStorageTable() {
        storageData.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
            }
            chooseStorageBrand.getSelectionModel().clearSelection();
            searchTextStorage.clear();
            chooseStoragePrice.getSelectionModel().clearSelection();
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        storageTable.setItems(storageData);
    }

    @FXML
    private void resetStorageSelection() {
        cancelStorageSelection.setDisable(true);
        displayStorageName.setPrefWidth(23);
        displayStorageName.setText(" ");
        displayStorageName.setOpacity(0);
        displayStorageName.setDisable(true);
        displayStoragePrice.setOpacity(0);
        displayStoragePrice.setDisable(true);
        selectStorage.setDisable(false);
        selectStorage.setOpacity(1);
        chooseStorageBrand.getSelectionModel().clearSelection();
        searchTextStorage.clear();
        cancelStorageSelection.setOpacity(0);
        totalPrice(Double.parseDouble(displayStoragePrice.getText()) * -1.0);
    }

    @FXML
    private void filterStorageDB() {
        String searchCommand = searchTextStorage.getText();
        String choice = chooseStorageBrand.getValue();
        if (searchCommand != null && choice == null && chooseStoragePrice.getValue() == null) {
            storageData.clear();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Name LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
            }
            storageTable.setItems(storageData);
        }else if(choice != null && searchCommand != null){
            if (Objects.equals(chooseStoragePrice.getValue(), "$0-200")) {
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Price BETWEEN 0 AND 200 AND Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                storageTable.setItems(storageData);
            } else if (Objects.equals(chooseStoragePrice.getValue(), "$201-400")) {
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                storageTable.setItems(storageData);
            } else if (Objects.equals(chooseStoragePrice.getValue(), "$401-600")) {
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 401 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                storageTable.setItems(storageData);
            } else if (Objects.equals(chooseStoragePrice.getValue(), "$601-800")){
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 601 AND 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                storageTable.setItems(storageData);
            }
            else if(Objects.equals(chooseStoragePrice.getValue(), "$801-1000")){
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 801 AND 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                storageTable.setItems(storageData);
            }
            else{
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price > 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                storageTable.setItems(storageData);
            }
        }
        else{
            if (Objects.equals(chooseStoragePrice.getValue(), "$0-200")) {
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Price BETWEEN 0 AND 200");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                storageTable.setItems(storageData);
            } else if (Objects.equals(chooseStoragePrice.getValue(), "$201-400")) {
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Price BETWEEN 201 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                storageTable.setItems(storageData);
            } else if (Objects.equals(chooseStoragePrice.getValue(), "$401-600")) {
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Price BETWEEN 401 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                storageTable.setItems(storageData);
            } else if(Objects.equals(chooseStoragePrice.getValue(), "601-800")){
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Price BETWEEN 601 AND 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                storageTable.setItems(storageData);
            }
            else if(Objects.equals(chooseStoragePrice.getValue(), "$801-1000")){
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Price BETWEEN 801 AND 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                storageTable.setItems(storageData);
            }
            else {
                storageData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM storageDB WHERE Price > 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        storageData.add(new Storage(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Capacity"), rs.getString("Type"), rs.getString("Cache"), rs.getString("Interface")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                storageTable.setItems(storageData);
            }
        }
    }

    @FXML
    private void displayStorageData(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            cancelStorageSelection.setOpacity(1);
            cancelStorageSelection.setDisable(false);
            totalPrice.setOpacity(1);
            totalPrice.setDisable(false);
            displayTotalPrice.setOpacity(1);
            displayTotalPrice.setDisable(false);
            Storage storage = storageTable.getSelectionModel().getSelectedItem();
            if (storage == null) {
                System.out.println("Error! No storage device is selected!");
            } else {
                String selectedStorageName = storage.getName();
                Double selectedStoragePrice = storage.getPrice();
                selectStorage.setDisable(true);
                selectStorage.setOpacity(0);
                displayStorageName.setDisable(false);
                displayStorageName.setPrefWidth(200);
                displayStorageName.setOpacity(1);
                displayStorageName.setText(selectedStorageName);
                addStorage.setDisable(true);
                addStorage.setOpacity(0);
                displayStoragePrice.setDisable(false);
                displayStoragePrice.setOpacity(1);
                if (selectedStoragePrice == 0.0) {
                    displayStoragePrice.setText("Price is not available!");
                } else {
                    displayStoragePrice.setText(String.valueOf(selectedStoragePrice));
                    totalPrice(selectedStoragePrice);
                }
                addStorage.setDisable(true);
                addStorage.setOpacity(0);
            }
        }
    }
        /*
SEPARATION
 */

    @FXML
    private void showPowerSupplyTable() {
        totalPrice.setOpacity(0);
        totalPrice.setDisable(true);
        displayTotalPrice.setOpacity(0);
        displayTotalPrice.setDisable(false);
        addStorage.setOpacity(0);
        addStorage.setDisable(true);
        addGPU.setOpacity(0);
        addGPU.setDisable(true);
        addRAM.setOpacity(0);
        addRAM.setDisable(true);
        addMon.setOpacity(0);
        addMon.setDisable(true);
        addCPU.setOpacity(0);
        addCPU.setDisable(true);
        addMotherboard.setOpacity(0);
        addMotherboard.setDisable(true);
        addPowerSupply.setOpacity(1);
        addPowerSupply.setDisable(false);
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
    private void resetPowerSupplyTable() {
        powerSupplyData.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
            }
            choosePSBrand.getSelectionModel().clearSelection();
            searchTextPS.clear();
            choosePowerSupplyPrice.getSelectionModel().clearSelection();
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        powerSupplyTable.setItems(powerSupplyData);
    }

    @FXML
    private void resetPowerSupplySelection() {
        cancelPSSelection.setDisable(true);
        displayPSName.setPrefWidth(23);
        displayPSName.setText(" ");
        displayPSName.setOpacity(0);
        displayPSName.setDisable(true);
        displayPSPrice.setOpacity(0);
        displayPSPrice.setDisable(true);
        selectPS.setDisable(false);
        selectPS.setOpacity(1);
        choosePSBrand.getSelectionModel().clearSelection();
        searchTextPS.clear();
        cancelPSSelection.setOpacity(0);
        totalPrice(Double.parseDouble(displayPSPrice.getText()) * -1.0);
    }

    @FXML
    private void filterPowerSupplyDB() {
        String searchCommand = searchTextPS.getText();
        String choice = choosePSBrand.getValue();
        if (searchCommand != null && choice == null && choosePowerSupplyPrice.getValue() == null) {
            powerSupplyData.clear();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Name LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
            }
            powerSupplyTable.setItems(powerSupplyData);
        }else if(choice != null && searchCommand != null){
            if (Objects.equals(choosePowerSupplyPrice.getValue(), "$0-200")) {
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Price BETWEEN 0 AND 200 AND Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                powerSupplyTable.setItems(powerSupplyData);
            } else if (Objects.equals(choosePowerSupplyPrice.getValue(), "$201-400")) {
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 201 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                powerSupplyTable.setItems(powerSupplyData);
            } else if (Objects.equals(choosePowerSupplyPrice.getValue(), "$401-600")) {
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 401 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                powerSupplyTable.setItems(powerSupplyData);
            } else{
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                powerSupplyTable.setItems(powerSupplyData);
            }
        }
        else{
            if (Objects.equals(choosePowerSupplyPrice.getValue(), "$0-200")) {
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Price BETWEEN 0 AND 200");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                powerSupplyTable.setItems(powerSupplyData);
            }
            else if (Objects.equals(choosePowerSupplyPrice.getValue(), "$201-400")) {
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Price BETWEEN 201 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                powerSupplyTable.setItems(powerSupplyData);
            }
            else if (Objects.equals(choosePowerSupplyPrice.getValue(), "$401-600")) {
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Price BETWEEN 401 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                powerSupplyTable.setItems(powerSupplyData);
            } else{
                powerSupplyData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM powerSupplyDB WHERE Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        powerSupplyData.add(new powerSupply(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Wattage"), rs.getString("Modular"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                powerSupplyTable.setItems(powerSupplyData);
            }
        }
    }

    @FXML
    private void displayPowerSupplyData(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            cancelPSSelection.setOpacity(1);
            cancelPSSelection.setDisable(false);
            totalPrice.setOpacity(1);
            totalPrice.setDisable(false);
            displayTotalPrice.setOpacity(1);
            displayTotalPrice.setDisable(false);
            powerSupply ps = powerSupplyTable.getSelectionModel().getSelectedItem();
            if (ps == null) {
                System.out.println("Error! No motherboard is selected!");
            } else {
                String selectedPSName = ps.getName();
                Double selectedPSPrice = ps.getPrice();
                selectPS.setDisable(true);
                selectPS.setOpacity(0);
                displayPSName.setDisable(false);
                displayPSName.setPrefWidth(200);
                displayPSName.setOpacity(1);
                displayPSName.setText(selectedPSName);
                addPowerSupply.setDisable(true);
                addPowerSupply.setOpacity(0);
                displayPSPrice.setDisable(false);
                displayPSPrice.setOpacity(1);
                if (selectedPSPrice == 0.0) {
                    displayPSPrice.setText("Price is not available!");
                } else {
                    displayPSPrice.setText(String.valueOf(selectedPSPrice));
                    totalPrice(selectedPSPrice);
                }
                addPowerSupply.setDisable(true);
                addPowerSupply.setOpacity(0);
            }
        }
    }

    /*
SEPARATION
 */
    @FXML
    private void showMotherboardTable() {
        totalPrice.setOpacity(0);
        totalPrice.setDisable(true);
        displayTotalPrice.setOpacity(0);
        displayTotalPrice.setDisable(false);
        addStorage.setOpacity(0);
        addStorage.setDisable(true);
        addGPU.setOpacity(0);
        addGPU.setDisable(true);
        addRAM.setOpacity(0);
        addRAM.setDisable(true);
        addMon.setOpacity(0);
        addMon.setDisable(true);
        addCPU.setOpacity(0);
        addCPU.setDisable(true);
        addPowerSupply.setOpacity(0);
        addPowerSupply.setDisable(true);
        addMotherboard.setOpacity(1);
        addMotherboard.setDisable(false);
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
    private void resetMotherboardTable() {
        motherboardData.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
            }
            chooseMBBrand.getSelectionModel().clearSelection();
            searchTextMotherboard.clear();
            chooseMotherboardPrice.getSelectionModel().clearSelection();
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        motherboardTable.setItems(motherboardData);
    }

    @FXML
    private void resetMotherboardSelection() {
        cancelMotherboardSelection.setDisable(true);
        displayMotherboardName.setPrefWidth(23);
        displayMotherboardName.setText(" ");
        displayMotherboardName.setOpacity(0);
        displayMotherboardName.setDisable(true);
        displayMotherboardPrice.setOpacity(0);
        displayMotherboardPrice.setDisable(true);
        selectMotherboard.setDisable(false);
        selectMotherboard.setOpacity(1);
        chooseMBBrand.getSelectionModel().clearSelection();
        searchTextMotherboard.clear();
        cancelMotherboardSelection.setOpacity(0);
        totalPrice(Double.parseDouble(displayMotherboardPrice.getText()) * -1.0);
    }

    @FXML
    private void filterMotherboardDB() {
        String searchCommand = searchTextMotherboard.getText();
        String choice = chooseMBBrand.getValue();
        if (searchCommand != null && chooseCPUBrand.getValue() == null && chooseCPUPrice.getValue() == null) {
            motherboardData.clear();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Name LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
            }
            motherboardTable.setItems(motherboardData);
        } if (chooseMotherboardPrice.getValue() == null) {
            if (choice != null && searchCommand != null) {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                motherboardTable.setItems(motherboardData);
            }
        }
        else if(choice != null && searchCommand != null){
            if (Objects.equals(chooseMotherboardPrice.getValue(), "$0-200")) {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Price BETWEEN 0 AND 200 AND Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                motherboardTable.setItems(motherboardData);
            } else if (Objects.equals(chooseMotherboardPrice.getValue(), "$201-400")) {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                motherboardTable.setItems(motherboardData);
            } else if (Objects.equals(chooseMotherboardPrice.getValue(), "$401-600")) {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                motherboardTable.setItems(motherboardData);
            } else {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                motherboardTable.setItems(motherboardData);
            }
        }
        else{
            if (Objects.equals(chooseMotherboardPrice.getValue(), "$0-200")) {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Price BETWEEN 0 AND 200");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                motherboardTable.setItems(motherboardData);
            } else if (Objects.equals(chooseMotherboardPrice.getValue(), "$201-400")) {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                motherboardTable.setItems(motherboardData);
            } else if (Objects.equals(chooseMotherboardPrice.getValue(), "$401-600")) {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                motherboardTable.setItems(motherboardData);
            } else {
                motherboardData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM motherboardDB WHERE Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        motherboardData.add(new Motherboard(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Socket"), rs.getString("Memory"), rs.getInt("memorySlots"), rs.getString("Colour")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                motherboardTable.setItems(motherboardData);
            }
        }
    }

    @FXML
    private void displayMotherboardData(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            cancelMotherboardSelection.setOpacity(1);
            cancelMotherboardSelection.setDisable(false);
            totalPrice.setOpacity(1);
            totalPrice.setDisable(false);
            displayTotalPrice.setOpacity(1);
            displayTotalPrice.setDisable(false);
            Motherboard mb = motherboardTable.getSelectionModel().getSelectedItem();
            if (mb == null) {
                System.out.println("Error! No motherboard is selected!");
            } else {
                String selectedMBName = mb.getName();
                Double selectedMBPrice = mb.getPrice();
                selectMotherboard.setDisable(true);
                selectMotherboard.setOpacity(0);
                displayMotherboardName.setDisable(false);
                displayMotherboardName.setPrefWidth(200);
                displayMotherboardName.setOpacity(1);
                displayMotherboardName.setText(selectedMBName);
                addMotherboard.setDisable(true);
                addMotherboard.setOpacity(0);
                displayMotherboardPrice.setDisable(false);
                displayMotherboardPrice.setOpacity(1);
                if (selectedMBPrice == 0.0) {
                    displayMotherboardPrice.setText("Price is not available!");
                } else {
                    displayMotherboardPrice.setText(String.valueOf(selectedMBPrice));
                    totalPrice(selectedMBPrice);
                }
                addMotherboard.setDisable(true);
                addMotherboard.setOpacity(0);
            }
        }
    }

    /*
SEPARATION
 */

    //CPU Section:
    @FXML
    private void showCPUTable() {
        totalPrice.setOpacity(0);
        totalPrice.setDisable(true);
        displayTotalPrice.setOpacity(0);
        displayTotalPrice.setDisable(false);
        addStorage.setOpacity(0);
        addStorage.setDisable(true);
        addPowerSupply.setOpacity(0);
        addPowerSupply.setDisable(true);
        addMotherboard.setOpacity(0);
        addMotherboard.setDisable(true);
        addGPU.setOpacity(0);
        addGPU.setDisable(true);
        addRAM.setOpacity(0);
        addRAM.setDisable(true);
        addMon.setOpacity(0);
        addMon.setDisable(true);
        addCPU.setOpacity(1);
        addCPU.setDisable(false);
        con = myConnection.getConnection();
        cpuData = FXCollections.observableArrayList();
        setCPUCellTable();
        loadCPUDataFromDatabase();
        System.out.println("cpuTable is booted!");
    }

    @FXML
    private void resetCPUSelection() {
        cancelCPUSelection.setDisable(true);
        displayCPUModel.setPrefWidth(23);
        displayCPUModel.setText(" ");
        displayCPUModel.setOpacity(0);
        displayCPUModel.setDisable(true);
        displayCPUPrice.setOpacity(0);
        displayCPUPrice.setDisable(true);
        selectCPU.setDisable(false);
        selectCPU.setOpacity(1);
        chooseCPUBrand.getSelectionModel().clearSelection();
        searchTextCPU.clear();
        cancelCPUSelection.setOpacity(0);
        totalPrice(Double.parseDouble(displayCPUPrice.getText()) * -1.0);
    }

    @FXML
    private void filterCPUDB() {
        String searchCommand = searchTextCPU.getText();
        String choice = chooseCPUBrand.getValue();
        if (searchCommand != null && chooseCPUBrand.getValue() == null && chooseCPUPrice.getValue() == null) {
            cpuData.clear();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Name LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
            }
            cpuTable.setItems(cpuData);
        }
        if (chooseCPUPrice.getValue() == null) {
            if (choice != null && searchCommand != null) {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                cpuTable.setItems(cpuData);
            }
        }
        else if(choice != null && searchCommand != null){
            if (Objects.equals(chooseCPUPrice.getValue(), "$0-200")) {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Price BETWEEN 0 AND 200 AND Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                cpuTable.setItems(cpuData);
            } else if (Objects.equals(chooseCPUPrice.getValue(), "$201-400")) {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                cpuTable.setItems(cpuData);
            } else if (Objects.equals(chooseCPUPrice.getValue(), "$401-600")) {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                cpuTable.setItems(cpuData);
            } else {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                cpuTable.setItems(cpuData);
            }
        }
        else{
            if (Objects.equals(chooseCPUPrice.getValue(), "$0-200")) {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Price BETWEEN 0 AND 200");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                cpuTable.setItems(cpuData);
            } else if (Objects.equals(chooseCPUPrice.getValue(), "$201-400")) {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                cpuTable.setItems(cpuData);
            } else if (Objects.equals(chooseCPUPrice.getValue(), "$401-600")) {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                cpuTable.setItems(cpuData);
            } else {
                cpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                cpuTable.setItems(cpuData);
            }
        }
    }

    @FXML
    private void resetCPUTable() {
        cpuData.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cpuData.add(new CPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("coreCount"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("tdp"), rs.getString("integratedGraphics"), rs.getString("smt")));
            }
            chooseCPUBrand.getSelectionModel().clearSelection();
            searchTextCPU.clear();
            chooseCPUPrice.getSelectionModel().clearSelection();
        } catch (SQLException ex) {
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpuTable.setItems(cpuData);
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
    private void displayCPUData(MouseEvent mouseEvent){
        if(mouseEvent.getClickCount() == 2){
            cancelCPUSelection.setOpacity(1);
            cancelCPUSelection.setDisable(false);
            totalPrice.setOpacity(1);
            totalPrice.setDisable(false);
            displayTotalPrice.setOpacity(1);
            displayTotalPrice.setDisable(false);
            CPU cpu = cpuTable.getSelectionModel().getSelectedItem();
            if(cpu== null){
                System.out.println("Error! No CPU is selected!");
            }
            else{
                String selectedCPUModel = cpu.getName();
                Double selectedCPUPrice = cpu.getPrice();
                selectCPU.setDisable(true);
                selectCPU.setOpacity(0);
                displayCPUModel.setDisable(false);
                displayCPUModel.setPrefWidth(200);
                displayCPUModel.setOpacity(1);
                displayCPUModel.setText(selectedCPUModel);
                displayCPUPrice.setDisable(false);
                displayCPUPrice.setOpacity(1);
                addCPU.setDisable(true);
                addCPU.setOpacity(0);
                if(selectedCPUPrice == 0.0){
                    displayCPUPrice.setText("Price is not available!");
                }else{
                    displayCPUPrice.setText(String.valueOf(selectedCPUPrice));
                    totalPrice(selectedCPUPrice);
                }
                addCPU.setDisable(true);
                addCPU.setOpacity(0);
            }
        }
    }

/*
SEPARATION
 */

    //GPU(Virtual Memory) Section:
    @FXML
    private void showGPUTable(){
        totalPrice.setOpacity(0);
        totalPrice.setDisable(true);
        displayTotalPrice.setOpacity(0);
        displayTotalPrice.setDisable(false);
        addStorage.setOpacity(0);
        addStorage.setDisable(true);
        addPowerSupply.setOpacity(0);
        addPowerSupply.setDisable(true);
        addMotherboard.setOpacity(0);
        addMotherboard.setDisable(true);
        addCPU.setOpacity(0);
        addCPU.setDisable(true);
        addRAM.setOpacity(0);
        addRAM.setDisable(true);
        addMon.setOpacity(0);
        addMon.setDisable(true);
        addGPU.setOpacity(1);
        addGPU.setDisable(false);
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
    private void resetGPUSelection(){
        cancelGPUSelection.setDisable(true);
        displayGPUModel.setPrefWidth(23);
        displayGPUModel.setText(" ");
        displayGPUModel.setOpacity(0);
        displayGPUModel.setDisable(true);
        displayGPUPrice.setOpacity(0);
        displayGPUPrice.setDisable(true);
        selectGPU.setDisable(false);
        selectGPU.setOpacity(1);
        chooseGPUBrand.getSelectionModel().clearSelection();
        searchTextGPU.clear();
        cancelGPUSelection.setOpacity(0);
        totalPrice(Double.parseDouble(displayGPUPrice.getText()) * -1.0);
    }

    @FXML
    private void filterGPUDB(){
        String searchCommand = searchTextGPU.getText();
        String choice = chooseGPUBrand.getValue();
        if(searchCommand != null && choice == null && chooseGPUPrice.getValue() == null){
            gpuData.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Name LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
            }
            gpuTable.setItems(gpuData);
        }
        if (chooseGPUPrice.getValue() == null) {
            if (choice != null && searchCommand != null) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(gpuData);
            }
        }
        else if(choice != null && searchCommand != null){
            if (Objects.equals(chooseGPUPrice.getValue(), "$0-200")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM cpuDB WHERE Price BETWEEN 0 AND 200 AND Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if (Objects.equals(chooseGPUPrice.getValue(), "$201-400")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 201 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if (Objects.equals(chooseGPUPrice.getValue(), "$401-600")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 401 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if(Objects.equals(chooseGPUPrice.getValue(), "$601-800")){
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 601 AND 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(gpuData);
            }
            else if(Objects.equals(chooseGPUPrice.getValue(), "$801-1000")){
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 801 AND 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(gpuData);
            }
            else{
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price > 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                gpuTable.setItems(gpuData);
            }
        }
        else {
            if (Objects.equals(chooseGPUPrice.getValue(), "$0-200")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Price BETWEEN 0 AND 200");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if (Objects.equals(chooseGPUPrice.getValue(), "$201-400")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Price BETWEEN 201 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if (Objects.equals(chooseGPUPrice.getValue(), "$401-600")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Price BETWEEN 401 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if (Objects.equals(chooseGPUPrice.getValue(), "$601-800")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Price BETWEEN 601 AND 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if (Objects.equals(chooseGPUPrice.getValue(), "$801-1000")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Price BETWEEN 801 AND 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            } else if (Objects.equals(chooseGPUPrice.getValue(), "$1000+")) {
                gpuData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB WHERE Price > 1000");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                gpuTable.setItems(gpuData);
            }
        }
    }

    @FXML
    private void resetGPUTable(){
        gpuData.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gpuDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                gpuData.add(new GPU(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Chipset"), rs.getString("Memory"), rs.getString("coreClock"), rs.getString("boostClock"), rs.getString("Colour"), rs.getString("Length")));
            }
            chooseGPUBrand.getSelectionModel().clearSelection();
            searchTextGPU.clear();
            chooseGPUPrice.getSelectionModel().clearSelection();
        } catch (SQLException ex){
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gpuTable.setItems(gpuData);
    }

    @FXML
    private void displayGPUModel(MouseEvent mouseEvent){
        if(mouseEvent.getClickCount() == 2){
            cancelGPUSelection.setOpacity(1);
            cancelGPUSelection.setDisable(false);
            totalPrice.setOpacity(1);
            totalPrice.setDisable(false);
            displayTotalPrice.setOpacity(1);
            displayTotalPrice.setDisable(false);
            GPU gpu = gpuTable.getSelectionModel().getSelectedItem();
            if(gpu == null){
                System.out.println("Error! No GPU is selected");
            }
            else{
                String selectedGPU = gpu.getName();
                Double selectedGPUPrice = gpu.getPrice();
                selectGPU.setDisable(true);
                selectGPU.setOpacity(0);
                displayGPUModel.setDisable(false);
                displayGPUModel.setPrefWidth(200);
                displayGPUModel.setOpacity(1);
                displayGPUModel.setText(selectedGPU);
                addGPU.setDisable(true);
                addGPU.setOpacity(0);
                displayGPUPrice.setDisable(false);
                displayGPUPrice.setOpacity(1);
                if(selectedGPUPrice == 0.0){
                    displayGPUPrice.setText("Price is not available!");
                }else{
                    displayGPUPrice.setText(String.valueOf(selectedGPUPrice));
                    totalPrice(selectedGPUPrice);
                }
                addCPU.setDisable(true);
                addCPU.setOpacity(0);
            }
        }
    }

/*
----------------------------------------------------------------------------------------
 */

    //RAM(Memory) Section:
    @FXML
    private void showRAMTable(){
        totalPrice.setOpacity(0);
        totalPrice.setDisable(true);
        displayTotalPrice.setOpacity(0);
        displayTotalPrice.setDisable(false);
        addStorage.setOpacity(0);
        addStorage.setDisable(true);
        addPowerSupply.setOpacity(0);
        addPowerSupply.setDisable(true);
        addMotherboard.setOpacity(0);
        addMotherboard.setDisable(true);
        addCPU.setOpacity(0);
        addCPU.setDisable(true);
        addGPU.setOpacity(0);
        addGPU.setDisable(true);
        addMon.setOpacity(0);
        addMon.setDisable(true);
        addRAM.setOpacity(1);
        addRAM.setDisable(false);
        con = myConnection.getConnection();
        ramData = FXCollections.observableArrayList();
        setRAMCellTable();
        loadRAMDataFromDatabase();
        System.out.println("ramTable is booted!");
    }

    @FXML
    private void resetRAMSelection(){
        cancelRAMSelection.setDisable(true);
        displayRAMModel.setPrefWidth(23);
        displayRAMModel.setText(" ");
        displayRAMModel.setOpacity(0);
        displayRAMModel.setDisable(true);
        displayRAMPrice.setOpacity(0);
        displayRAMPrice.setDisable(true);
        selectRAM.setDisable(false);
        selectRAM.setOpacity(1);
        chooseRAMBrand.getSelectionModel().clearSelection();
        searchTextRAM.clear();
        cancelRAMSelection.setOpacity(0);
        totalPrice(Double.parseDouble(displayRAMPrice.getText()) * -1.0);
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
    private void filterRAMDB(){
        String searchCommand = searchTextRAM.getText();
        String choice = chooseRAMBrand.getValue();
        if(searchCommand != null && choice == null && chooseRAMPrice.getValue() == null){
            ramData.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Name LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                }
            } catch (SQLException exception) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
            }
            ramTable.setItems(ramData);
        }
        if (chooseRAMPrice.getValue() == null) {
            if (choice != null && searchCommand != null) {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                ramTable.setItems(ramData);
            }
        }
        else if(choice != null && searchCommand != null){
            if (Objects.equals(chooseRAMPrice.getValue(), "$0-200")) {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Price BETWEEN 0 AND 200 AND Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                ramTable.setItems(ramData);
            } else if (Objects.equals(chooseRAMPrice.getValue(), "$201-400")) {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                ramTable.setItems(ramData);
            } else if (Objects.equals(chooseRAMPrice.getValue(), "$401-600")) {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                ramTable.setItems(ramData);
            } else {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                ramTable.setItems(ramData);
            }
        }
        else{
            if (Objects.equals(chooseRAMPrice.getValue(), "$0-200")) {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Price BETWEEN 0 AND 200");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                ramTable.setItems(ramData);
            } else if (Objects.equals(chooseRAMPrice.getValue(), "$201-400")) {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                ramTable.setItems(ramData);
            } else if (Objects.equals(chooseRAMPrice.getValue(), "$401-600")) {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                ramTable.setItems(ramData);
            } else {
                ramData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB WHERE Price > 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                ramTable.setItems(ramData);
            }
        }
    }
    
    @FXML
    private void resetRAMTable(){
        ramData.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ramDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ramData.add(new RAM(rs.getString("Name"), rs.getDouble("Price"), rs.getString("Speed"), rs.getString("Module"), rs.getString("Colour"), rs.getString("firstWordLatency"), rs.getInt("casLatency")));
            }
            chooseRAMBrand.getSelectionModel().clearSelection();
            searchTextRAM.clear();
            chooseRAMPrice.getSelectionModel().clearSelection();
        } catch (SQLException ex){
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ramTable.setItems(ramData);
    }

    @FXML
    private void displaySelectedRAM(MouseEvent mouseEvent){
        if(mouseEvent.getClickCount() == 2){
            cancelRAMSelection.setOpacity(1);
            cancelRAMSelection.setDisable(false);
            totalPrice.setOpacity(1);
            totalPrice.setDisable(false);
            displayTotalPrice.setOpacity(1);
            displayTotalPrice.setDisable(false);
            RAM ram = ramTable.getSelectionModel().getSelectedItem();
            if(ram == null){
                System.out.println("Error! No RAM is selected!");
            }
            else{
                Double selectedRAMPrice = ram.getPrice();
                String selectedRAM = ram.getName();
                selectRAM.setDisable(true);
                selectRAM.setOpacity(0);
                displayRAMModel.setDisable(false);
                displayRAMModel.setPrefWidth(200);
                displayRAMModel.setOpacity(1);
                displayRAMModel.setText(selectedRAM);
                addRAM.setDisable(true);
                addRAM.setOpacity(0);
                displayRAMPrice.setDisable(false);
                displayRAMPrice.setOpacity(1);
                if(selectedRAMPrice == 0.0){
                    displayRAMPrice.setText("Price is not available!");
                }else{
                    displayRAMPrice.setText(String.valueOf(selectedRAMPrice));
                    totalPrice(selectedRAMPrice);
                }
            }
        }
    }

    /*
    ----------------------------------------------------------------------------------------
     */

    //Monitor Section:
    @FXML
    private void showMonTable(){
        totalPrice.setOpacity(0);
        totalPrice.setDisable(true);
        displayTotalPrice.setOpacity(0);
        displayTotalPrice.setDisable(false);
        addStorage.setOpacity(0);
        addStorage.setDisable(true);
        addPowerSupply.setOpacity(0);
        addPowerSupply.setDisable(true);
        addMotherboard.setOpacity(0);
        addMotherboard.setDisable(true);
        addCPU.setOpacity(0);
        addCPU.setDisable(true);
        addGPU.setOpacity(0);
        addGPU.setDisable(true);
        addRAM.setOpacity(0);
        addRAM.setDisable(true);
        addMon.setOpacity(1);
        addMon.setDisable(false);
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
        monTable.setItems(monitorData);
    }

    @FXML
    private void filterMonDB() {
        String searchCommand = searchTextMon.getText();
        String choice = chooseMonBrand.getValue();
        if(searchCommand != null && choice == null && chooseMonitorPrice.getValue() == null){
            monitorData.clear();
            try{
                PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Model LIKE '%" + searchCommand + "%'");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
            }
            monTable.setItems(monitorData);
        }
        if (chooseMonitorPrice.getValue() == null) {
            if (choice != null && searchCommand != null) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                monTable.setItems(monitorData);
            }
        }
        else if(choice != null && searchCommand != null){
            if (Objects.equals(chooseMonitorPrice.getValue(), "$0-200")) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Price BETWEEN 0 AND 200 AND Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%'");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                monTable.setItems(monitorData);
            } else if (Objects.equals(chooseMonitorPrice.getValue(), "$201-400")) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                monTable.setItems(monitorData);
            } else if (Objects.equals(chooseMonitorPrice.getValue(), "$401-600")) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                monTable.setItems(monitorData);
            } else if(Objects.equals(chooseMonitorPrice.getValue(), "$601-800")){
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price BETWEEN 601 AND 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                monTable.setItems(monitorData);
            }
            else{
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Name LIKE '%" + choice + "%' AND Name LIKE '%" + searchCommand + "%' AND Price > 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                monTable.setItems(monitorData);
            }
        }
        else{
            if (Objects.equals(chooseMonitorPrice.getValue(), "$0-200")) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB WHERE Price BETWEEN 0 AND 200");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                monTable.setItems(monitorData);
            } else if (Objects.equals(chooseMonitorPrice.getValue(), "$201-400")) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM MonitorDB WHERE Price BETWEEN 200 AND 400");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                monTable.setItems(monitorData);
            } else if (Objects.equals(chooseMonitorPrice.getValue(), "$401-600")) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM MonitorDB WHERE Price BETWEEN 400 AND 600");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                monTable.setItems(monitorData);
            } else if(Objects.equals(chooseMonitorPrice.getValue(), "$601-800")) {
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM MonitorDB WHERE Price BETWEEN 601 AND 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                monTable.setItems(monitorData);
            }
            else{
                monitorData.clear();
                try {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM MonitorDB WHERE Price > 800");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
                    }
                } catch (SQLException exception) {
                    Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, exception);
                }
                monTable.setItems(monitorData);
            }
        }
    }

    @FXML
    private void resetMonTable(){
        monitorData.clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM monitorDB");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                monitorData.add(new Monitor(rs.getString("Name"), rs.getDouble("Price"), rs.getString("screenSize"), rs.getString("Resolution"), rs.getString("refreshRate"), rs.getString("responseTime"), rs.getString("panelType"), rs.getString("aspectRatio")));
            }
            chooseMonBrand.getSelectionModel().clearSelection();
            searchTextMon.clear();
            chooseMonitorPrice.getSelectionModel().clearSelection();
        } catch (SQLException ex){
            Logger.getLogger(sysBuildController.class.getName()).log(Level.SEVERE, null, ex);
        }
        monTable.setItems(monitorData);
    }

    @FXML
    private void resetMonSelection(){
        cancelMonSelection.setDisable(true);
        displayMonModel.setPrefWidth(23);
        displayMonModel.setText(" ");
        displayMonModel.setOpacity(0);
        displayMonModel.setDisable(true);
        displayMonPrice.setOpacity(0);
        displayMonPrice.setDisable(true);
        selectMon.setDisable(false);
        selectMon.setOpacity(1);
        chooseMonBrand.getSelectionModel().clearSelection();
        searchTextMon.clear();
        cancelMonSelection.setOpacity(0);
        totalPrice(Double.parseDouble(displayMonPrice.getText()) * -1.0);
    }

    @FXML
    private void displayMonModel(MouseEvent mouseEvent){
        if(mouseEvent.getClickCount() == 2){
            cancelMonSelection.setOpacity(1);
            cancelMonSelection.setDisable(false);
            totalPrice.setOpacity(1);
            totalPrice.setDisable(false);
            displayTotalPrice.setOpacity(1);
            displayTotalPrice.setDisable(false);
            Monitor monitor = monTable.getSelectionModel().getSelectedItem();
            if(monitor == null){
                System.out.println("Error! No RAM is selected!");
            }
            else{
                Double selectedMonPrice = monitor.getPrice();
                String selectedMon= monitor.getName();
                selectMon.setDisable(true);
                selectMon.setOpacity(0);
                displayMonModel.setDisable(false);
                displayMonModel.setPrefWidth(200);
                displayMonModel.setOpacity(1);
                displayMonModel.setText(selectedMon);
                addMon.setDisable(true);
                addMon.setOpacity(0);
                displayMonPrice.setDisable(false);
                displayMonPrice.setOpacity(1);
                if(selectedMonPrice == 0.0){
                    displayMonPrice.setText("Price is not available!");
                }else{
                    displayMonPrice.setText(String.valueOf(selectedMonPrice));
                    totalPrice(selectedMonPrice);
                }
                addCPU.setDisable(true);
                addCPU.setOpacity(0);
            }
        }
    }


//----------------------------------------------------------------------------------------

    @FXML
    private void windowDispose() throws IOException {
        mainController id = new mainController();
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
        if(id.tempData() == null){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homeGuest.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root));
            stage1.show();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root));
            stage1.show();
        }
    }

    @FXML
    private void resetWindow(){
        addCPU.setOpacity(0);
        addCPU.setDisable(true);
        addGPU.setOpacity(0);
        addGPU.setDisable(true);
        addRAM.setOpacity(0);
        addRAM.setDisable(true);
        addMon.setOpacity(0);
        addMon.setDisable(true);
        addPowerSupply.setOpacity(0);
        addPowerSupply.setDisable(true);
        addMotherboard.setOpacity(0);
        addMotherboard.setDisable(true);
        addStorage.setOpacity(0);
        addStorage.setDisable(true);

        displayTotalPrice.setText(" ");

        displayCPUModel.setPrefWidth(23);
        displayCPUModel.setText(" ");
        displayCPUModel.setOpacity(0);
        displayCPUModel.setDisable(true);
        displayCPUPrice.setOpacity(0);
        displayCPUPrice.setDisable(true);
        cancelCPUSelection.setOpacity(0);
        cancelCPUSelection.setDisable(true);

        displayGPUModel.setPrefWidth(23);
        displayGPUModel.setText(" ");
        displayGPUModel.setOpacity(0);
        displayGPUModel.setDisable(true);
        displayGPUPrice.setOpacity(0);
        displayGPUPrice.setDisable(true);
        cancelGPUSelection.setOpacity(0);
        cancelGPUSelection.setDisable(true);

        displayMonModel.setPrefWidth(23);
        displayMonModel.setText(" ");
        displayMonModel.setOpacity(0);
        displayMonModel.setDisable(true);
        displayMonPrice.setOpacity(0);
        displayMonPrice.setDisable(true);
        cancelMonSelection.setOpacity(0);
        cancelMonSelection.setDisable(true);

        displayRAMModel.setPrefWidth(23);
        displayRAMModel.setText(" ");
        displayRAMModel.setOpacity(0);
        displayRAMModel.setDisable(true);
        displayRAMPrice.setOpacity(0);
        displayRAMPrice.setDisable(true);
        cancelRAMSelection.setOpacity(0);
        cancelRAMSelection.setDisable(true);

        displayMotherboardName.setPrefWidth(23);
        displayMotherboardName.setText(" ");
        displayMotherboardName.setOpacity(0);
        displayMotherboardName.setDisable(true);
        displayMotherboardPrice.setOpacity(0);
        displayMotherboardPrice.setDisable(true);
        cancelMotherboardSelection.setOpacity(0);
        cancelMotherboardSelection.setDisable(true);

        displayPSName.setPrefWidth(23);
        displayPSName.setText(" ");
        displayPSName.setOpacity(0);
        displayPSName.setDisable(true);
        displayPSPrice.setOpacity(0);
        displayPSPrice.setDisable(true);
        cancelPSSelection.setOpacity(0);
        cancelPSSelection.setDisable(true);

        displayStorageName.setPrefWidth(23);
        displayStorageName.setText(" ");
        displayStorageName.setOpacity(0);
        displayStorageName.setDisable(true);
        displayStoragePrice.setOpacity(0);
        displayStoragePrice.setDisable(true);
        cancelStorageSelection.setOpacity(0);
        cancelStorageSelection.setDisable(true);

        selectCPU.setDisable(false);
        selectCPU.setOpacity(1);

        selectRAM.setDisable(false);
        selectRAM.setOpacity(1);

        selectGPU.setDisable(false);
        selectGPU.setOpacity(1);

        selectMon.setDisable(false);
        selectMon.setOpacity(1);

        selectPS.setDisable(false);
        selectPS.setOpacity(1);

        selectMotherboard.setDisable(false);
        selectMotherboard.setOpacity(1);

        selectStorage.setDisable(false);
        selectStorage.setOpacity(1);

        //Ensuring chooseBrand, searchText, and  (Text Area) are fully cleared
        chooseCPUBrand.getSelectionModel().clearSelection();
        chooseGPUBrand.getSelectionModel().clearSelection();
        chooseRAMBrand.getSelectionModel().clearSelection();
        chooseMonBrand.getSelectionModel().clearSelection();
        choosePSBrand.getSelectionModel().clearSelection();
        chooseMBBrand.getSelectionModel().clearSelection();
        chooseStorageBrand.getSelectionModel().clearSelection();
        searchTextStorage.clear();
        searchTextCPU.clear();
        searchTextGPU.clear();
        searchTextRAM.clear();
        searchTextMon.clear();
        searchTextMotherboard.clear();
        searchTextPS.clear();
    }


    @FXML
    private void saveBuild() throws IOException {
        mainController id = new mainController();
        if(id.tempData() == null){
            Alert errorDialog = new Alert(Alert.AlertType.ERROR);
            errorDialog.setContentText("Error! User is not logged in!");
            errorDialog.showAndWait();
        }
        else{
            con = myConnection.getConnection();
            getQuery();
            insert();
            resetWindow();
            Alert saveSuccesful = new Alert(Alert.AlertType.INFORMATION);
            saveSuccesful.setContentText("Build is saved. Your build is available on 'My Build'");
            saveSuccesful.showAndWait();
        }
    }

    String saveQuery = null;
    private void getQuery() {
        saveQuery = "INSERT INTO savedBuildDB (CPU, Motherboard, RAM, Storage, GPU, powerSupply, Monitor, Price, user) VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?)";
    }

    private void insert(){
        mainController id = new mainController();
        try{
            PreparedStatement ps = con.prepareStatement(saveQuery);
            ps.setString(1, displayCPUModel.getText());
            ps.setString(2, displayMotherboardName.getText());
            ps.setString(3, displayRAMModel.getText());
            ps.setString(4, displayStorageName.getText());
            ps.setString(5, displayGPUModel.getText());
            ps.setString(6, displayPSName.getText());
            ps.setString(7, displayMonModel.getText());
            ps.setString(8, displayTotalPrice.getText());
            ps.setString(9, id.tempData());
            ps.execute();
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
    }


}
