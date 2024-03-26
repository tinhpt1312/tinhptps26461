/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.NhanVienDAO;
import Model.NhanVien;
import Utility.UtilityMail;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class JFrameQuenMatKhau extends javax.swing.JFrame {
    Thread t1;
    Runnable r1;
    boolean check = false;
    String CaptCha = "";
    NhanVienDAO DAO = new NhanVienDAO();

    public JFrameQuenMatKhau() {
        initComponents();
        init();
        Utility.UtilityImage.setIconTitle(this, "Icon-title.png");
        r1 = () -> {
            int thoigian = 30;
            while (thoigian > 0) {
                thoigian--;
                lblTime.setText(String.valueOf(thoigian));
                if (check == true) {
                    init();
                    break;
                }
                try {
                    t1.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JFrameQuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (thoigian == 0) {
                JOptionPane.showMessageDialog(rootPane, "hết thời gian nhập captcha");
                lblTime.setText("30");
                CaptCha = "";
                init();
                t1.interrupt();
            }

        };
        t1 = new Thread(r1);
    }

    public void init() {
        lblTime.setText("30");
        txtcaptcha.setEnabled(false);
        btnxacnhan.setEnabled(false);
        txtcaptcha.setText(null);
        txtmk1.setEnabled(check);
        txtmk2.setEnabled(check);
        btnhoanthanh.setEnabled(check);
        txtID.setEnabled(!check);
        btnguicaptcha.setEnabled(!check);
    }

    public boolean ValidateForm() {

        if (txtmk1.getText().isBlank() || txtmk2.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Điền đầy đủ thông tin");
            return false;
        }
        if (txtmk2.getText().length() < 8) {
            JOptionPane.showMessageDialog(rootPane, "mật khẩu trên 8 ký tự");
            return false;
        }
        if (!txtmk1.getText().equals(txtmk2.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu không khớp");
            return false;
        }

        return true;
    }

    public void GuiCaptCha() {
        CaptCha = "";
        CaptCha = UtilityMail.ChuoiNgauNhien(10);
        new UtilityMail().GuiMail(DAO.SelectMailbyID(txtID.getText()), "Quên mật khẩu", "Mã xác nhận là : " + CaptCha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtcaptcha = new javax.swing.JTextField();
        btnhoanthanh = new javax.swing.JButton();
        btnxacnhan = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        txtmk1 = new javax.swing.JPasswordField();
        txtmk2 = new javax.swing.JPasswordField();
        btnguicaptcha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(213, 213, 235));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quên mật khẩu");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tên đăng nhập :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mã xác nhận :");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Mật khẩu mới :");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nhập lại mật khẩu :");

        btnhoanthanh.setText("Hoàn thành");
        btnhoanthanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhoanthanhActionPerformed(evt);
            }
        });

        btnxacnhan.setText("Xác nhận mã");
        btnxacnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnxacnhanMouseClicked(evt);
            }
        });

        lblTime.setText("30");

        btnguicaptcha.setText("Gửi captcha");
        btnguicaptcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguicaptchaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnhoanthanh, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtmk1)
                            .addComponent(txtmk2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnxacnhan, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(btnguicaptcha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguicaptcha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtcaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnxacnhan))
                    .addComponent(lblTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtmk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtmk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhoanthanh)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnxacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnxacnhanMouseClicked
        if(txtcaptcha.getText().equals(CaptCha)){
           check=true;
       }else{
           JOptionPane.showMessageDialog(rootPane, "sai mã captcha");
       }
    }//GEN-LAST:event_btnxacnhanMouseClicked

    private void btnhoanthanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhoanthanhActionPerformed
       if(ValidateForm()){
          NhanVien x=new NhanVien();
          x.setMaNhanVien(txtID.getText());
          x.setMatKhau(txtmk2.getText());
          int t=DAO.doiMatKhau(x);
          if(t==0){
              JOptionPane.showMessageDialog(rootPane, "không tìm thấy ID");
          }else{
              JOptionPane.showMessageDialog(rootPane, "Đồi mật khẩu thành công");
              this.dispose();
          }
      }
    }//GEN-LAST:event_btnhoanthanhActionPerformed

    private void btnguicaptchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguicaptchaActionPerformed
        GuiCaptCha();
        btnguicaptcha.setEnabled(false);
        txtcaptcha.setEnabled(true);
        btnxacnhan.setEnabled(true);
        t1=new Thread(r1);
        t1.start();
    }//GEN-LAST:event_btnguicaptchaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguicaptcha;
    private javax.swing.JButton btnhoanthanh;
    private javax.swing.JButton btnxacnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtcaptcha;
    private javax.swing.JPasswordField txtmk1;
    private javax.swing.JPasswordField txtmk2;
    // End of variables declaration//GEN-END:variables
}