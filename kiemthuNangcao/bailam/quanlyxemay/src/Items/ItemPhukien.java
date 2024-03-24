/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Items;

import Model.PhuKien;
import Model.XeMay;
import Utility.UtilityImage;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class ItemPhukien extends javax.swing.JPanel {

    private PhuKien Pk = null;
    int index;
    boolean clicked = false;

    /**
     * Creates new form ItemXemay
     */
    public ItemPhukien(PhuKien x, int i) {
        initComponents();
        Pk = x;
        index = i;
        RemoveChoose();
        lblTen.setToolTipText(Pk.getTenPhuKien());
        lblTen.setText(RutGonChuoi(Pk.getTenPhuKien()));
        lblGiatien.setText(Utility.UtilityFormat.DinhdangVnd(x.getGiaTien()));
        lblMaPhukien.setText(Pk.getMaPhuKien());
        lblHinh.setSize(188, 137);
        if (x.getHinh() != null) {
            ImageIcon icon = UtilityImage.BytesToImageIcon(x.getHinh());
            lblHinh.setIcon(UtilityImage.ResizeHinh(lblHinh, icon));
        }

    }

    public void Choose() {
        if (Pk.getSoluong() == 0) {
            pnlItem.setBackground(new Color(200, 200, 200));
        } else {
            pnlItem.setBackground(new Color(175, 175, 220));
        }
        lblTen.setForeground(Color.white);
        lblGiatien.setForeground(Color.white);
        lblGia.setForeground(Color.white);
        lblMa.setForeground(Color.white);
        lblMaPhukien.setForeground(Color.white);
        clicked = true;
    }

    public void RemoveChoose() {
        if (Pk.getSoluong() == 0) {
            pnlItem.setBackground(new Color(200, 200, 200));
        } else {
            pnlItem.setBackground(Color.WHITE);
        }
        lblTen.setForeground(Color.black);
        lblGiatien.setForeground(Color.black);
        lblGia.setForeground(Color.black);
        lblMa.setForeground(Color.black);
        lblMaPhukien.setForeground(Color.black);
        clicked = false;
    }

    public String RutGonChuoi(String x) {
        String chuoi = x;
        if (chuoi.length() > 19) {//chi rut gon nhung chuoi co do dai tren 19 ky tu
            StringBuilder sb = new StringBuilder(22);//tao do dai toi da cho chuoi la 22;
            for (int i = 0; i < 22; i++) {
                if (i > 18) {
                    sb.append('.');// 3 ky tu cuoi cung là ... 
                } else {
                    sb.append(chuoi.charAt(i));     //nhung ky tu con lai add vao Stringbuilder               
                }
            }
            chuoi = sb.toString();//chuyen sang String;
        }
        return chuoi;
    }

    public int getIndex() {
        return index;
    }

    public boolean isClicked() {
        return clicked;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlItem = new javax.swing.JPanel();
        lblTen = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        lblGiatien = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        lblMa = new javax.swing.JLabel();
        lblMaPhukien = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnlItem.setBackground(new java.awt.Color(255, 255, 255));

        lblTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTen.setText("TEN");

        lblGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGia.setText("Giá :");

        lblGiatien.setText("jLabel4");

        lblHinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinh.setMaximumSize(new java.awt.Dimension(188, 137));
        lblHinh.setMinimumSize(new java.awt.Dimension(188, 137));
        lblHinh.setPreferredSize(new java.awt.Dimension(188, 137));

        lblMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMa.setText("Mã :");

        lblMaPhukien.setText("jLabel4");

        javax.swing.GroupLayout pnlItemLayout = new javax.swing.GroupLayout(pnlItem);
        pnlItem.setLayout(pnlItemLayout);
        pnlItemLayout.setHorizontalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGia, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlItemLayout.createSequentialGroup()
                                .addComponent(lblGiatien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addComponent(lblMaPhukien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlItemLayout.setVerticalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMa)
                    .addComponent(lblMaPhukien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGia)
                    .addComponent(lblGiatien))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblGiatien;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblMaPhukien;
    private javax.swing.JLabel lblTen;
    private javax.swing.JPanel pnlItem;
    // End of variables declaration//GEN-END:variables
}
