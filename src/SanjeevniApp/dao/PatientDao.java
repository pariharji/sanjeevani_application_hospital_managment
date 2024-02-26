/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.dbutil.DBConnection;
import SanjeevniApp.pojo.PatientPojo;
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
public class PatientDao {
    public static String getNewPatientId() throws SQLException{
    Connection conn = DBConnection.getConnection();
    Statement st = conn.createStatement();
    ResultSet vs = st.executeQuery("Select max(patient_id) from patients");
    vs.next();
    int patId = 101;
    String id = vs.getString(1);
    if(id != null){
        String num = id.substring(3);
        patId = Integer.parseInt(num) + 1;
    }
    return "PAT"+patId;
    }
public static boolean addPatient(PatientPojo pat)throws SQLException {
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("Insert into patients values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
     ps.setString(1, pat.getPatientId());
     ps.setString(2, pat.getFirstName());
     ps.setString(3,pat.getLastName());
     ps.setInt(4, pat.getAge());
     ps.setString(5, pat.getGender());
     ps.setString(6, pat.getMarriedStatus());
     ps.setString(7, pat.getAddress());
     ps.setString(8,pat.getCity());
     ps.setString(9, pat.getMno());
     ps.setDate(10, pat.getDate());
     ps.setInt(11, pat.getOtp());
     ps.setString(12,pat.getOpd());
     ps.setString(13, pat.getDoctorId());
     ps.setString(14, pat.getAptStatus());
     return ps.executeUpdate()== 1;
   }    
public static List<PatientPojo> getAllPatientsByDoctorId(String doctorId)throws SQLException{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select * from patients where doctor_id=? and status='REQUEST' order by patient_id");
    ps.setString(1,doctorId);
    ResultSet rs=ps.executeQuery();
    List<PatientPojo>patList=new ArrayList<>();
    while(rs.next()){
    PatientPojo pat=new PatientPojo();
    pat.setPatientId(rs.getString("patient_id"));
    pat.setFirstName(rs.getString("first_name")+" "+rs.getString("last_name"));
    pat.setDate(rs.getDate("p_date"));
    pat.setOpd(rs.getString("opd"));
    patList.add(pat);   
    
    }
    return patList;
} public static List<PatientPojo> getAllPatientDetals() throws SQLException{
         Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet set = st.executeQuery("select * from patients order by patient_id");
         List<PatientPojo> list = new ArrayList<>();
         while(set.next()){
             PatientPojo pat = new PatientPojo();
             pat.setPatientId(set.getString("patient_id"));
             pat.setFirstName(set.getNString("first_Name"));
             pat.setLastName(set.getString("last_Name"));
             pat.setAge(set.getInt("age"));
             pat.setGender(set.getString("gender"));
             pat.setAptStatus(set.getString("status"));
             pat.setAddress(set.getString("address"));
             pat.setCity(set.getString("city"));
             pat.setMno(set.getString("mobile_no"))
     ;
             pat.setOpd(set.getString("opd"));
             pat.setDate(set.getDate("p_date"));
             pat.setMarriedStatus(set.getString("m_status"));
             pat.setDoctorId(set.getString("doctor_id"));
             list.add(pat);
         }
          return list;   
         }
         
     
     public static boolean updateStatus(String patientId)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update patients set status='CONFIRM' where patient_id=?" );
     ps.setString(1, patientId);
     return ps.executeUpdate()==1;
     
     
 }
     public static boolean PatientDeleteByID(String id) throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Delete from patients where patient_id=?");
     ps.setString(1, id);
     return ps.executeUpdate()==1;
}
     public static List<String> getAllPatientId() throws SQLException {
     Connection conn=DBConnection.getConnection();
     Statement st=conn.createStatement();
     ResultSet rs = st.executeQuery("Select patient_id from patients");
     List<String> patientList = new ArrayList<>();
     while(rs.next()){
         patientList.add(rs.getString(1));
     }
     return patientList;
    }
      public static boolean AppointmentDeleteByID(String id) throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Delete from appointments where patient_id=?");
     ps.setString(1, id);
     return ps.executeUpdate()==1;
}
       public static PatientPojo getPatientDetails(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from patients where patient_id=?");
        ps.setString(1, empId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        PatientPojo emp = new PatientPojo();
        emp.setPatientId(rs.getString(1));
        emp.setFirstName(rs.getString(2));
        emp.setLastName(rs.getString(3));
        emp.setOpd(rs.getString(12));
        emp.setDate(rs.getDate(10));
        emp.setAddress(rs.getString(7));
        emp.setGender(rs.getString(5));
        emp.setDoctorId(rs.getString(13));
        emp.setAge(rs.getInt(4));
        emp.setMarriedStatus(rs.getString(6));
        emp.setMno(rs.getString(9));
        emp.setCity(rs.getString(8));
        
        return emp;

    }
        public static boolean updatePatient(PatientPojo emp) throws SQLException {
      
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update Patients set first_name=?,last_name=?,age=?,address=?,city=?,mobile_no=?,opd=? where patient_id=?");
        ps.setString(1, emp.getFirstName());
        ps.setString(2, emp.getLastName());
        ps.setString(3, String.valueOf(emp.getAge()));
        ps.setString(4, emp.getAddress());
        ps.setString(5, emp.getCity());
        ps.setString(6, emp.getMno());
        ps.setString(7, emp.getOpd());
        ps.setString(8, emp.getPatientId());
        return ps.executeUpdate() == 1;
    }
        
}  
    
    
    

