/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.dbutil.DBConnection;
import SanjeevniApp.pojo.AppointmentPojo;
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
public class AppointmentDao {
    public static boolean addAppointment(AppointmentPojo appt) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into appointments values(?,?,?,?,?,?,?)");
        ps.setString(1, appt.getPatientId());
        ps.setString(2, appt.getPatientName());
        ps.setString(3, appt.getStatus());
        ps.setString(4, appt.getOpd());
        ps.setString(5, appt.getAppointmentDate());
        ps.setString(6, appt.getDoctorName());
        ps.setString(7, appt.getMobaileNo());
        return ps.executeUpdate() == 1;
    }
    public static List<AppointmentPojo> getAllAppointmentsByDoctorName(String docName) throws SQLException {
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("Select * from appointments where doctor_name = ? and status='REQUEST' order by patient_id");
         ps.setString(1, docName);
         ResultSet rs = ps.executeQuery();
         List<AppointmentPojo> appList = new ArrayList<>();
         while(rs.next()){
             AppointmentPojo app = new AppointmentPojo();
             app.setPatientId(rs.getString("patient_id"));
             app.setPatientName(rs.getString("patient_name"));
             app.setOpd(rs.getString("opd"));
             app.setAppointmentDate(rs.getString("date_time"));
             app.setStatus(rs.getString("status"));
             app.setMobaileNo(rs.getString("Mobaile_no"));
             app.setDoctorName(rs.getString("doctor_name"));
             appList.add(app);  
         }
         return appList;
    }   
    public static boolean updateStatus(AppointmentPojo app)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update appointments set status=?,date_time=? where patient_id=?" );
     ps.setString(1, app.getStatus());
     ps.setString(2, app.getAppointmentDate());
     ps.setString(3,app.getPatientId());
     return ps.executeUpdate()==1;
    
}
   public static List<AppointmentPojo> getAllAppointmentDetals() throws SQLException{
         Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet set = st.executeQuery("select * from appointments order by patient_id");
         List<AppointmentPojo> list = new ArrayList<>();
         while(set.next()){
             AppointmentPojo app = new  AppointmentPojo();
             app.setPatientId(set.getString("patient_id"));
             app.setPatientName(set.getNString("Patient_Name"));
             app.setOpd(set.getString("opd"));
             app.setAppointmentDate(set.getString("Date_Time"));
            
             list.add(app);
         }
          return list;   
         }
        public static List<AppointmentPojo> getAllAppointmentsByDoctor(String docName) throws SQLException {
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("Select * from appointments where doctor_name = ? and status='CONFIRM' order by patient_id");
         ps.setString(1, docName);
         ResultSet rs = ps.executeQuery();
         List<AppointmentPojo> appList = new ArrayList<>();
         while(rs.next()){
             AppointmentPojo app = new AppointmentPojo();
             app.setPatientId(rs.getString("patient_id"));
             app.setPatientName(rs.getString("patient_name"));
             app.setOpd(rs.getString("opd"));
             app.setAppointmentDate(rs.getString("date_time"));
             app.setStatus(rs.getString("status"));
             app.setMobaileNo(rs.getString("Mobaile_no"));
             app.setDoctorName(rs.getString("doctor_name"));
             appList.add(app);  
         }
         return appList;
    } 
}