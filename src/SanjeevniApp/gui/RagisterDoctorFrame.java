/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevniApp.gui;

import SanjeevniApp.dao.DoctorsDao;
import SanjeevniApp.dao.EmpDao;
import SanjeevniApp.dao.UserDao;
import SanjeevniApp.pojo.DoctorPojo;
import SanjeevniApp.pojo.UserPojo;
import SanjeevniApp.utility.PasswordEncryption;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class RagisterDoctorFrame extends javax.swing.JFrame {

  private Map<String,String>unRegDocList;
   private String logId,selEmpId,selEmpName;
   private String pwd1,pwd2;
   private String contactNo,emailId,qualification,specialist;
    public RagisterDoctorFrame() {
  
        initComponents();
         setLocationRelativeTo(null);
        unRegDocList = new HashMap<>();
        loadDoctorDetails();
        genNewDocId();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jcEmployeeId = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPwd1 = new javax.swing.JPasswordField();
        txtLoginId = new javax.swing.JTextField();
        txtPwd2 = new javax.swing.JPasswordField();
        jcGender = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDoctorId = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtQualification = new javax.swing.JTextField();
        txtSpecialist = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel17.setText("Sanjeevani Application");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 480, 60));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 520, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SanjeevniApp/iconsimage/HomePageBG1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doctor's Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setText("Employee ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 130, 20));

        jcEmployeeId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jcEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEmployeeIdActionPerformed(evt);
            }
        });
        jPanel2.add(jcEmployeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 180, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setText("Login ID");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setText("Doctor Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtDoctorName.setEditable(false);
        jPanel2.add(txtDoctorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 180, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setText("Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setText("Retype Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setText("Gender");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtPwd1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel2.add(txtPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 180, -1));

        txtLoginId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtLoginId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtLoginId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 180, -1));

        txtPwd2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel2.add(txtPwd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 180, -1));

        jcGender.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", " " }));
        jcGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcGenderActionPerformed(evt);
            }
        });
        jPanel2.add(jcGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 180, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setText("Doctor ID");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel11.setText("Contact no.");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel12.setText("Qualification");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, 20));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel13.setText("Specialist");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, 20));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel14.setText("Email ID");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, -1, -1));

        txtDoctorId.setEditable(false);
        txtDoctorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtDoctorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 190, -1));

        txtContactNo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel2.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 190, -1));

        txtQualification.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQualificationActionPerformed(evt);
            }
        });
        jPanel2.add(txtQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 190, -1));

        txtSpecialist.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtSpecialist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpecialistActionPerformed(evt);
            }
        });
        jPanel2.add(txtSpecialist, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 190, -1));

        txtEmailId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtEmailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 190, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 840, 350));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Doctor Registration");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-32746, -32354, 41, 16));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel15.setText("Doctor's Registration ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SanjeevniApp/iconsimage/images (2).jpg"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 210, 250));

        btnRegister.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(51, 51, 255));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 180, -1));

        btnBack.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(51, 51, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 330, 100, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 1080, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginIdActionPerformed

    private void txtEmailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailIdActionPerformed

    private void txtSpecialistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpecialistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpecialistActionPerformed

    private void txtQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQualificationActionPerformed

    private void txtDoctorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorIdActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if(validateInputs() == false){
             JOptionPane.showMessageDialog(null, "Please input all the fields");
             return;
        }
        String passwordValid = matchpassword();
        if (passwordValid != null){
             JOptionPane.showMessageDialog(null, passwordValid);
         return;
        }
        if(isContactNoValid() == false){
             JOptionPane.showMessageDialog(null, "Invalid mobile no");
         return;
        }
        try{
            DoctorPojo doc = new DoctorPojo();
         doc.setDoctorId(txtDoctorId.getText());
         doc.setDoctorName(selEmpName);
         doc.setEmailId(emailId);
         doc.setGender(jcGender.getSelectedItem().toString());
         doc.setContactNo(contactNo);
         doc.setQualification(qualification);
         doc.setSpecialist(specialist);
         UserPojo user = new UserPojo();
         user.setLoginId(logId);
         user.setUserName(selEmpName);
         user.setUserType("DOCTOR");
          String encPassword=new String(PasswordEncryption.getEncryptedPassword(pwd1));
          user.setPassword(encPassword);
         boolean result1 = DoctorsDao.addDoctor(doc);
         boolean result2 = UserDao.addUser(user);
           if(result1==true && result2==true){
             JOptionPane.showMessageDialog(null, "Doctor successfully registered!");
             clearAll();
             return;
           }
           JOptionPane.showMessageDialog(null, "Registration unsuccessful!"); 
        return; 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB:"+ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       LoginFrame lf = new LoginFrame();
       lf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       ManageDoctorFrame  mf= new ManageDoctorFrame();
          mf.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jcEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmployeeIdActionPerformed
     if(jcEmployeeId.getSelectedIndex()== -1){
        return ;
     }
        
    selEmpId=jcEmployeeId.getSelectedItem().toString();
    selEmpName=unRegDocList.get(selEmpId);
    txtDoctorName.setText(selEmpName);
    }//GEN-LAST:event_jcEmployeeIdActionPerformed

    private void jcGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcGenderActionPerformed
       
    }//GEN-LAST:event_jcGenderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RagisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RagisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RagisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RagisterDoctorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RagisterDoctorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcEmployeeId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDoctorId;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JPasswordField txtPwd1;
    private javax.swing.JPasswordField txtPwd2;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JTextField txtSpecialist;
    // End of variables declaration//GEN-END:variables

    private void loadDoctorDetails() {
       try{
           unRegDocList = EmpDao.getUnRegisterDoctors();
           Set <String> empIdSet = unRegDocList.keySet();
           for(String empId:empIdSet){
               jcEmployeeId.addItem(empId);
           }
       }    catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB:"+ex+"RegisterDoctorFrame");
            ex.printStackTrace();
           
       } 
    }

    private void genNewDocId() {
       try{
           String docId = DoctorsDao.getNewDocId();
           txtDoctorId.setText(docId);
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB:"+ex+"RegisterDoctorFrame");
            ex.printStackTrace();
    }
}

    private boolean validateInputs() {
       this.logId = this.txtLoginId.getText().trim();
       char[] p1 = this.txtPwd1.getPassword();
       char[] p2 = this.txtPwd2.getPassword();
       this.contactNo  = txtContactNo.getText();
       this.qualification = txtQualification.getText();
       this.emailId = txtEmailId.getText();
       this.specialist = txtSpecialist.getText();
       if(logId.isEmpty() || p1.length == 0 || p2.length == 0 || contactNo.isEmpty() || qualification.isEmpty() || emailId.isEmpty() || specialist.isEmpty()){
           return false;
       }
       pwd1 =new String(p1);
        pwd2 =new String(p2);
        return true;
    }

    private String matchpassword() {
       pwd1 = pwd1.trim();
       pwd2 = pwd2.trim();
       if(pwd1.length()<4 || pwd2.length()<4){
           return "Passwords must be of atleast 4 characters in length";
       }
       if(pwd1.equals(pwd2) == false)
           return "Passwords do not Match";
       return null;
    }

    private boolean isContactNoValid() {
        char[] mob = contactNo.toCharArray();
        for(char ch: mob){
            if(Character.isDigit(ch) == false){
                return false;
            }
        }
        if(contactNo.length() == 10){
            return true;
        }
        return false;
    }

    private void clearAll() {
       txtLoginId.setText("");
      this.txtContactNo.setText("");
      this.txtDoctorId.setText("");
      this.txtEmailId.setText("");
      this.txtPwd1.setText("");
      this.txtPwd2.setText("");
      this.txtQualification.setText("");
      this.txtSpecialist.setText("");
      this.unRegDocList.remove(selEmpId);
      this.jcEmployeeId.removeItem(selEmpId);
      if(unRegDocList.size()==0){
          JOptionPane.showMessageDialog(null,"All doctors registered!");
          ManageDoctorFrame manageDoc=new ManageDoctorFrame();
          manageDoc.setVisible(true);
          this.dispose();
    }
    }
}
    
