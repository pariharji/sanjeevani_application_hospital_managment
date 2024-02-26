/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dbutil;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class DBConnection {
    private static Connection conn = null;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loded successfully");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
            System.exit(0);
        }
        try{
         
            
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-PR06QDU:1521/XE","projectjava","975495");
            System.out.println("connection open Successfully");
        }
         catch (SQLException ex) {
//             JOptionPane.showMessageDialog(null,"Problem in DB:"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             System.exit(0);
        }
      }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection() {
        if(conn != null){
            try{
                conn.close();
                System.out.println("conn close Successfully");
            }
             catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Problem in DB:"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             System.exit(0);
        }
    }
    }
}
