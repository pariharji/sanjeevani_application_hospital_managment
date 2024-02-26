/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.dao;

import SanjeevniApp.dbutil.DBConnection;
import SanjeevniApp.pojo.EmpPojo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.management.Query;

/**
 *
 * @author Acer
 */
public class EmpDao {

    public static String getNextEmpId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(emp_id) from employees");
        rs.next();
        String str = rs.getString(1);
        int empId = 101;
        if (str != null) {
            String id = str.substring(1);
            empId = Integer.parseInt(id);
            empId++;
        }
        String newId = "E" + empId;
        return newId;
    }

    public static boolean addEmp(EmpPojo emp) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setString(1, emp.getEmpId());
        ps.setString(2, emp.getEmpName());
        ps.setString(3, emp.getEmpDept());
        ps.setDouble(4, emp.getEmpSal());
        return ps.executeUpdate() == 1;
    }

    public static List<String> getAllemployeeId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select emp_id from employees");
        List<String> empIdList = new ArrayList<>();
        while (rs.next()) {
            empIdList.add(rs.getString(1));
        }
        return empIdList;
    }

    public static boolean updateEmployee(EmpPojo emp) throws SQLException {
        updateName(emp);
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update employees set emp_name=?,emp_sal=? where emp_id=?");
        ps.setString(1, emp.getEmpName());
        ps.setDouble(2, emp.getEmpSal());
        ps.setString(3, emp.getEmpId());
        return ps.executeUpdate() == 1;
    }

    public static void updateName(EmpPojo emp) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select emp_name from employees where emp_id=?");
        ps.setString(1, emp.getEmpId());
        ResultSet rs = ps.executeQuery();
        rs.next();
        String currName = rs.getString(1);
        String newName = emp.getEmpName();
        UserDao.updateName(currName, newName);
        if (emp.getEmpDept().equalsIgnoreCase("Receptionist")) {
            ReceptionistDao.updateName(currName, newName);
        } else if (emp.getEmpDept().equalsIgnoreCase("Doctor")) {
            DoctorsDao.updateName(currName, newName);
        }

    }

    public static EmpPojo getEmployeeDetails(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from employees where emp_id=?");
        ps.setString(1, empId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        EmpPojo emp = new EmpPojo();
        emp.setEmpId(rs.getString(1));
        emp.setEmpName(rs.getString(2));
        emp.setEmpDept(rs.getString(3));
        emp.setEmpSal(rs.getDouble(4));
        return emp;

    }

    public static List<EmpPojo> getAllEmployeeDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from employees order by emp_id");
        List<EmpPojo> empList = new ArrayList<>();
        while (rs.next()) {
            EmpPojo emp = new EmpPojo();
            emp.setEmpId(rs.getString(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpDept(rs.getString(3));
            emp.setEmpSal(rs.getDouble(4));
            empList.add(emp);
        }
        return empList;

    }

    public static boolean deleteEmployeeById(String empid) throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Delete from employees where emp_id=?");
     ps.setString(1, empid);
     return ps.executeUpdate()==1;
    
    }
    
    public static Map<String, String> getUnRegisterDoctors() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("Select emp_id,emp_name from employees where emp_department='Doctor' and emp_name not in (select user_name from users where user_type ='Doctor')order by emp_id");
         Map<String,String> unRegDocList = new HashMap<>();
         while(rs.next()){
             String id = rs.getString(1);
             String name = rs.getString(2);
             unRegDocList.put(id, name);
             System.out.println(id+ ""+name);
         }
         return unRegDocList;
    }
    public static Map<String, String> getUnRegisterReceptionist() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("Select emp_id,emp_name from employees where emp_department='Receptionist' and emp_name not in (select user_name from users where user_type ='Receptionist')order by emp_id");
         Map<String,String> unRegRecepList = new HashMap<>();
         while(rs.next()){
             String id = rs.getString(1);
             String name = rs.getString(2);
             unRegRecepList.put(id, name);
             System.out.println(id+ ""+name);
         }
         return unRegRecepList;
    }
    
}
