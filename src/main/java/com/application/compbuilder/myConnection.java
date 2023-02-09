package com.application.compbuilder;

import java.sql.Connection;
import java.sql.DriverManager;

public class myConnection {
    public static Connection getConnection(){
        Connection con = null;
        try{
            String DRIVER = "com.mysql.jdbc.Driver";
            Class.forName(DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/compBuilder", "root", "");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
