/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection myconObj=null;
        Statement mystatObj=null;
        ResultSet myresObj=null;
        ResultSetMetaData mymeta=null;
        String query="Select *from Apple.ResourcesTable";
        try
        {
            myconObj=DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase","Apple","1234");
            mystatObj=myconObj.createStatement();
            myresObj=mystatObj.executeQuery(query);
            mymeta=myresObj.getMetaData();
            int columnNo=mymeta.getColumnCount();
            //System.out.println(columnNo);
            for(int i=1;i<=columnNo;i++)
            {
                System.out.print(mymeta.getColumnName(i)+"\t");
                                
            }
            System.out.println();
            while(myresObj.next())
                    {
                       for(int i=1;i<=columnNo;i++)
                       {
                           //System.out.print(myresObj.getObject(i)+"\t");
                       }
                       //System.out.println();
                        
                        
                       int code=myresObj.getInt("code");
                       String hallName=myresObj.getString("hallName");
                       int capacity=myresObj.getInt("capacity");
                       int costPerDay=myresObj.getInt("costPerDay");
                       System.out.println(code+"\t"+hallName+"\t\t"+capacity+"\t\t"+costPerDay);
                    }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    
}
