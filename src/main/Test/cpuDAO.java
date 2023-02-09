package components;

import customer_detail.myConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cpuDAO {
    public void selectCPU(ActionEvent e){
        String query =  "SELECT Model FROM cpuDB LIMIT 15";
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = myConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public static ObservableList<CPU> getAllData() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM cpuDB LIMIT 5";
        PreparedStatement ps;
        try{
            ps = myConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("Testing 3");
            ObservableList<CPU> cpuList = getCPUObjects(rs);
            System.out.println(cpuList.size());
            return cpuList;
        } catch (SQLException exception) {
            System.out.println("Error occurred while fetching data from user DB");
            exception.printStackTrace();
            throw exception;
        }
    }

    private static ObservableList<CPU> getCPUObjects(ResultSet rs) throws ClassNotFoundException, SQLException {
        try{
            ObservableList<CPU> cpulist = FXCollections.observableArrayList();

            while(rs.next()){
                CPU cpu = new CPU();
                cpu.setPartNumber(rs.getString("partNumber"));
                cpu.setBrand(rs.getString("Brand"));
                cpu.setModel(rs.getString("Model"));
                cpu.setBenchmark(rs.getInt("Benchmark"));
                cpulist.add(cpu);
            }
            System.out.println(cpulist.size());
            return cpulist;
        } catch (SQLException ex) {
            System.out.println("Error occurred while fetching data from user DB");
            ex.printStackTrace();
            throw ex;
        }
    }
}
