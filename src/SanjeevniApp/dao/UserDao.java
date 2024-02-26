/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.dbutil.DBConnection;
import SanjeevniApp.pojo.DoctorPojo;
import SanjeevniApp.pojo.User;
import SanjeevniApp.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class UserDao {

    public static String ValidateUser(User user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select user_name from users where login_id = ? and password = ? and user_type = ?");
        
        ps.setString(1, user.getLoginId());
        System.out.println(user.getLoginId());
        ps.setString(2, user.getPassword());
        //user.setUserType(user.getUserType().substring(0, 1).toUpperCase() + user.getUserType().substring(1, user.getUserType().length()).toLowerCase());
System.out.println(user.getPassword());
        ps.setString(3, user.getUserType());
        System.out.println(user.getUserType());
        ResultSet rs = ps.executeQuery();

        String name=null;

       while(rs.next())
       {
           name = rs.getString(1);
           System.out.println(name);
       }
       return name;
    }
     public static void updateName(String currName,String newName)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update users set user_name=? where user_name=?");
     ps.setString(1, newName);
     ps.setString(2, currName);
     ps.executeUpdate();
}
     public static boolean addUser(UserPojo user) throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?,?)");
     ps.setString(1, user.getLoginId());
     ps.setString(2, user.getUserName());
     ps.setString(3, user.getPassword());
     ps.setString(4, user.getUserType().toUpperCase());
     return ps.executeUpdate() == 1;

}
     public static void deleteUserByName(String name) throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("delete from users where user_Name = ?");
     ps.setString(1, name);
     ps.executeUpdate();
     }
      public static UserPojo getUserDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select login_id from users");
        ResultSet rs = ps.executeQuery();
        rs.next();
        UserPojo emp = new UserPojo();
        emp.setLoginId(rs.getString(1)); 
        return emp;
      }

}