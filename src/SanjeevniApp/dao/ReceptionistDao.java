/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.dbutil.DBConnection;
import SanjeevniApp.pojo.ReceptionistPojo;
import SanjeevniApp.pojo.UserPojo;
import SanjeevniApp.utility.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class ReceptionistDao {
         public static void updateName(String currName,String newName)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update receptionists set receptionists_name=? where receptionists_name=?");
     ps.setString(1, newName);
     ps.setString(2, currName);
     ps.executeUpdate();
}
          
     public static boolean addReceptionist(ReceptionistPojo rec) throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into receptionists values(?,?,?)");
    ps.setString(1,rec.getReceptionistId());
    ps.setString(2,rec.getReceptionistName());
    ps.setString(3,rec.getGender());
    return ps.executeUpdate() == 1;
    }
     public static String getNewRecepId() throws SQLException {
     Connection conn=DBConnection.getConnection();
     Statement st=conn.createStatement();
     ResultSet rs = st.executeQuery("Select max(receptionists_Id) from receptionists");
     rs.next();
     int recep = 101;
     String id = rs.getString(1);
     if(id != null){
         String num = id.substring(3);
         recep= Integer.parseInt(num) + 1;
     }
     return "REC"+recep;
     
    }
      public static boolean deleteReceptionistById(String recepId) throws SQLException{
       Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Select receptionists_name from receptionists where receptionists_id = ?");
      ps.setString(1, recepId);
      ResultSet rs = ps.executeQuery();
      rs.next();
      String docName =rs.getString(1);
      UserDao.deleteUserByName(docName);
      ps = conn.prepareStatement("Delete from receptionists where receptionists_id = ?");
      ps.setString(1, recepId);
      return ps.executeUpdate()==1;

    }
       public static List<String> getAllReceptionistId() throws SQLException {
     Connection conn=DBConnection.getConnection();
     Statement st=conn.createStatement();
     ResultSet rs = st.executeQuery("Select receptionists_id from receptionists");
     List<String> recepList = new ArrayList<>();
     while(rs.next()){
         recepList.add(rs.getString(1));
     }
     return recepList;
    }
        public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select * from receptionists order by receptionists_id");
    List<ReceptionistPojo> recepList = new ArrayList<>();
    while(rs.next()){
    ReceptionistPojo recep=new ReceptionistPojo();
    recep.setReceptionistId(rs.getString("receptionists_id"));
    recep.setReceptionistName(rs.getString("receptionists_name"));
    recep.setGender(rs.getString("gender"));
    recepList.add(recep);
    }
    return recepList;
    }
        public static boolean updateReceptionist(UserPojo emp) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update users set login_id=?, password=? where user_name=?");
        ps.setString(1, emp.getLoginId());
        ps.setString(2, emp.getPassword());
        ps.setString(3, emp.getUserName());
        return ps.executeUpdate() == 1;
}
         public static ReceptionistPojo getReceptionistDetails(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from receptionists where receptionists_id=?");
        ps.setString(1, empId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        ReceptionistPojo emp = new ReceptionistPojo();
        emp.setReceptionistId(rs.getString(1));
        emp.setReceptionistName(rs.getString(2));
        emp.setGender(rs.getString(3)); 
        return emp;

    }
}
