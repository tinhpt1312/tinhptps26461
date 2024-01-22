/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.KetnoiDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Tinh
 */
public class SendEmail extends javax.swing.JFrame {

    public SendEmail() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public int returnEmail() {
        int count = 0;
        try (Connection con = KetnoiDatabase.openConnection(); Statement stm = con.createStatement();) {
            ResultSet rs = stm.executeQuery("select Email from TaiKhoan tk inner join NhanVien nv on tk.TenDangNhap = nv.MaNV where email like '" + txtEmail.getText() + "'");
            while (rs.next()) {
                count++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
    
    public String returnTK(String email) {
        String user = "";
        try (Connection con = KetnoiDatabase.openConnection(); Statement stm = con.createStatement();) {
            ResultSet rs = stm.executeQuery("Select tendangnhap from TaiKhoan tk inner join NhanVien nv on tk.TenDangNhap = nv.MaNV where email like '" + email + "'");
            while (rs.next()) {
                user = rs.getString("tendangnhap");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
    
    public String returnMK(String email) {
        String pass = "";
        try (Connection con = KetnoiDatabase.openConnection(); Statement stm = con.createStatement();) {
            ResultSet rs = stm.executeQuery("Select Matkhau from TaiKhoan tk inner join NhanVien nv on tk.TenDangNhap = nv.MaNV where email like '" + email + "'");
            while (rs.next()) {
                pass = rs.getString("MatKhau");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pass;
    }
    
    public void check() {
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", 587);
        final String accountName = "phamthetinhcop1312@gmail.com";
        final String accountPass = "nqokqttfzhnwqkbb";
        //final String accountName = "khoantps26524@fpt.edu.vn";
        //final String accountPass = "nbdvdgejouiukomz";
        Session s;
        s = Session.getInstance(p,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountName, accountPass);
            }
        });
        String to = txtEmail.getText().trim();
        Message msg = new MimeMessage(s);
        if (to.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mail để check lại mk");
        } else {
            if (returnEmail() == 0) {
                JOptionPane.showMessageDialog(null, "Email không có trong danh sách");
            } else {
                try {
                    msg.setFrom(new InternetAddress(accountName));
                    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    msg.setSubject("Thông báo đổi mật khẩu");
                    msg.setText("Yêu cầu đổi mật khẩu của Mã NV: " + returnTK(to) + " và Password: " + returnMK(to) + ".Nếu bạn muốn đổi mật khẩu. Xin vui lòng liên hệ Admin của hệ thống!");
                    Transport.send(msg);
                    JOptionPane.showMessageDialog(this, "Mail was sent successfully");
                    this.setVisible(false);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUÊN MẬT KHẨU");

        jLabel2.setText("Email:");

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        check();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
