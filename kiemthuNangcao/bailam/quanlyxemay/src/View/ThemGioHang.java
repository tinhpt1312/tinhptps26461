/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.KhachHangDAO;
import DAO.PhuKienDAO;
import DAO.XeMayDAO;
import GioHang.ControllerGioHang;
import GioHang.SanPham;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ThemGioHang extends javax.swing.JFrame {

    SanPham sp;

    /**
     * Creates new form ThemGioHang
     */
    public ThemGioHang(SanPham x) {
        initComponents();
        this.sp = x;
        txtMaSanPham.setText(x.getMaSanPham());
        setLocationRelativeTo(null);
        txtSoluong.setValue(1);
    }

    public boolean Validate() {
        String makh = txtMaKhachHang.getText();
        int soluong = (int) txtSoluong.getValue();
        if (new KhachHangDAO().SelectById(makh).isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Mã khách hàng không hợp lệ");
            return false;
        }
        if (soluong <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Số lượng không hợp lệ");
            return false;
        }
        if (sp.getLoaiSanPham().equals("XeMay")) {
            int soluongKho = new XeMayDAO().SelectById(sp.getMaSanPham()).get(0).getSoluong();
            if (soluong > soluongKho) {
                JOptionPane.showMessageDialog(rootPane, "Số lượng không hợp lệ ,còn " + soluongKho + " sản phẩm trong kho");
                return false;
            }
        }
        if (sp.getLoaiSanPham().equals("PhuKien")) {
            int soluongKho = new PhuKienDAO().SelectById(sp.getMaSanPham()).get(0).getSoluong();
            if (soluong > soluongKho) {
                JOptionPane.showMessageDialog(rootPane, "Số lượng không hợp lệ ,còn " + soluongKho + " sản phẩm trong kho");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtMaKhachHang = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtSoluong = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã Khách hàng :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Số lượng :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mã sản phẩm :");

        txtMaSanPham.setBackground(new java.awt.Color(204, 204, 255));
        txtMaSanPham.setFocusable(false);

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        jButton2.setText("hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKhachHang)
                            .addComponent(txtMaSanPham)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 106, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        if (Validate()) {
            String makh = txtMaKhachHang.getText();
            int soluong = (int) txtSoluong.getValue();
            sp.setSoluong(soluong);
            if (ControllerGioHang.ThemSanPhamChoKhach(makh, sp)) {
                JOptionPane.showMessageDialog(rootPane, "Đã thêm vào giỏ hàng");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "thêm vào giỏ hàng thất bại");
            }
        }
    }//GEN-LAST:event_btnThemMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JSpinner txtSoluong;
    // End of variables declaration//GEN-END:variables
}