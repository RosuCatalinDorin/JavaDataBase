
package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaDB {

 
    public static void main(String[] args) {
        
        try (Connection  con = DriverManager.getConnection("jdbc:derby://localhost:1527/baza_date","root","123");){
        
            
         Statement stInsert = con.createStatement();
         
        stInsert.execute("insert into UNTITLED (USERNAME,PASSWORD) values('catalin','12342')");
            
        
         Statement stFatch = con.createStatement();
         
            ResultSet rs = stFatch.executeQuery("select * from untitled");
            
            
            while (rs.next())
            {
            
            System.out.println("Tabel: ");
            System.out.println("Username " + rs.getString("username"));
            System.out.println("Password " + rs.getString("password"));
            System.out.println("\n");
         
                
            }
        } catch (SQLException ex) {
    
            System.out.println("Eror in conection "+ ex);
            
        }
    }
    
}
