/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.coffe.ui;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Tinh
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void pnQLopen(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnTrangChu = new javax.swing.JPanel();
        lbTC = new javax.swing.JLabel();
        pnQuanLy = new javax.swing.JPanel();
        lbQL = new javax.swing.JLabel();
        pnBanHang = new javax.swing.JPanel();
        lbBH = new javax.swing.JLabel();
        pnThongKe = new javax.swing.JPanel();
        lbTK = new javax.swing.JLabel();
        pnTong = new javax.swing.JPanel();
        pnQL = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnSPcon = new javax.swing.JPanel();
        lbSPcon = new javax.swing.JLabel();
        pnNVcon = new javax.swing.JPanel();
        lbNVcon = new javax.swing.JLabel();
        pnDHcon = new javax.swing.JPanel();
        lbDHcon = new javax.swing.JLabel();
        pnKHcon = new javax.swing.JPanel();
        lbKHcon = new javax.swing.JLabel();
        pnTong1 = new javax.swing.JPanel();
        pnSP1 = new javax.swing.JPanel();
        pnNV1 = new javax.swing.JPanel();
        pnDH1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        pnKH1 = new javax.swing.JPanel();
        pnTK = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnBH = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnTC = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(63, 49, 49));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đăng xuất");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        pnTrangChu.setBackground(new java.awt.Color(221, 190, 169));

        lbTC.setBackground(new java.awt.Color(255, 255, 255));
        lbTC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTC.setForeground(new java.awt.Color(0, 0, 0));
        lbTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTC.setText("Trang chủ");
        lbTC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbTC, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTrangChuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbTC)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnQuanLy.setBackground(new java.awt.Color(63, 49, 49));

        lbQL.setBackground(new java.awt.Color(255, 255, 255));
        lbQL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbQL.setForeground(new java.awt.Color(255, 255, 255));
        lbQL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQL.setText("Quản lý");
        lbQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnQuanLyLayout = new javax.swing.GroupLayout(pnQuanLy);
        pnQuanLy.setLayout(pnQuanLyLayout);
        pnQuanLyLayout.setHorizontalGroup(
            pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbQL, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnQuanLyLayout.setVerticalGroup(
            pnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbQL)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnBanHang.setBackground(new java.awt.Color(63, 49, 49));

        lbBH.setBackground(new java.awt.Color(255, 255, 255));
        lbBH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbBH.setForeground(new java.awt.Color(255, 255, 255));
        lbBH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBH.setText("Bán hàng");
        lbBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnBanHangLayout = new javax.swing.GroupLayout(pnBanHang);
        pnBanHang.setLayout(pnBanHangLayout);
        pnBanHangLayout.setHorizontalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanHangLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbBH, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnBanHangLayout.setVerticalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanHangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbBH)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnThongKe.setBackground(new java.awt.Color(63, 49, 49));

        lbTK.setBackground(new java.awt.Color(255, 255, 255));
        lbTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTK.setForeground(new java.awt.Color(255, 255, 255));
        lbTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTK.setText("Thống kê");
        lbTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnThongKeLayout = new javax.swing.GroupLayout(pnThongKe);
        pnThongKe.setLayout(pnThongKeLayout);
        pnThongKeLayout.setHorizontalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongKeLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        pnThongKeLayout.setVerticalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongKeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbTK)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnTong.setBackground(new java.awt.Color(221, 190, 169));

        pnQL.setBackground(new java.awt.Color(221, 190, 169));

        jPanel2.setBackground(new java.awt.Color(60, 49, 49));
        jPanel2.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnSPcon.setBackground(new java.awt.Color(255, 255, 255));

        lbSPcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbSPcon.setForeground(new java.awt.Color(0, 0, 0));
        lbSPcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSPcon.setText("SẢN PHẨM");
        lbSPcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSPconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnSPconLayout = new javax.swing.GroupLayout(pnSPcon);
        pnSPcon.setLayout(pnSPconLayout);
        pnSPconLayout.setHorizontalGroup(
            pnSPconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSPconLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSPcon, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnSPconLayout.setVerticalGroup(
            pnSPconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSPconLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSPcon, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnNVcon.setBackground(new java.awt.Color(255, 255, 255));
        pnNVcon.setPreferredSize(new java.awt.Dimension(236, 104));

        lbNVcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbNVcon.setForeground(new java.awt.Color(0, 0, 0));
        lbNVcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNVcon.setText("NHÂN VIÊN");
        lbNVcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNVconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnNVconLayout = new javax.swing.GroupLayout(pnNVcon);
        pnNVcon.setLayout(pnNVconLayout);
        pnNVconLayout.setHorizontalGroup(
            pnNVconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
            .addGroup(pnNVconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnNVconLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbNVcon, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnNVconLayout.setVerticalGroup(
            pnNVconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(pnNVconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnNVconLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbNVcon, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnDHcon.setBackground(new java.awt.Color(255, 255, 255));

        lbDHcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbDHcon.setForeground(new java.awt.Color(0, 0, 0));
        lbDHcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDHcon.setText("ĐƠN HÀNG");
        lbDHcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDHconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnDHconLayout = new javax.swing.GroupLayout(pnDHcon);
        pnDHcon.setLayout(pnDHconLayout);
        pnDHconLayout.setHorizontalGroup(
            pnDHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
            .addGroup(pnDHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDHconLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbDHcon, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnDHconLayout.setVerticalGroup(
            pnDHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(pnDHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDHconLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbDHcon, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnKHcon.setBackground(new java.awt.Color(255, 255, 255));

        lbKHcon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbKHcon.setForeground(new java.awt.Color(0, 0, 0));
        lbKHcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbKHcon.setText("KHO");
        lbKHcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbKHconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnKHconLayout = new javax.swing.GroupLayout(pnKHcon);
        pnKHcon.setLayout(pnKHconLayout);
        pnKHconLayout.setHorizontalGroup(
            pnKHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
            .addGroup(pnKHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKHconLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbKHcon, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnKHconLayout.setVerticalGroup(
            pnKHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(pnKHconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnKHconLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbKHcon, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnTong1.setBackground(new java.awt.Color(221, 190, 169));

        pnSP1.setBackground(new java.awt.Color(220, 190, 169));

        javax.swing.GroupLayout pnSP1Layout = new javax.swing.GroupLayout(pnSP1);
        pnSP1.setLayout(pnSP1Layout);
        pnSP1Layout.setHorizontalGroup(
            pnSP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        pnSP1Layout.setVerticalGroup(
            pnSP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnNV1Layout = new javax.swing.GroupLayout(pnNV1);
        pnNV1.setLayout(pnNV1Layout);
        pnNV1Layout.setHorizontalGroup(
            pnNV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        pnNV1Layout.setVerticalGroup(
            pnNV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        pnDH1.setBackground(new java.awt.Color(220, 190, 169));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Xóa");

        jLabel3.setBackground(new java.awt.Color(220, 190, 169));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("TRA CỨU THEO NGÀY");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("NGÀY");

        jButton2.setText("Tìm");

        javax.swing.GroupLayout pnDH1Layout = new javax.swing.GroupLayout(pnDH1);
        pnDH1.setLayout(pnDH1Layout);
        pnDH1Layout.setHorizontalGroup(
            pnDH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDH1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(pnDH1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnDH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDH1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnDH1Layout.setVerticalGroup(
            pnDH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDH1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pnKH1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnKH1Layout = new javax.swing.GroupLayout(pnKH1);
        pnKH1.setLayout(pnKH1Layout);
        pnKH1Layout.setHorizontalGroup(
            pnKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        pnKH1Layout.setVerticalGroup(
            pnKH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnTong1Layout = new javax.swing.GroupLayout(pnTong1);
        pnTong1.setLayout(pnTong1Layout);
        pnTong1Layout.setHorizontalGroup(
            pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnNV1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDH1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTong1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnTong1Layout.setVerticalGroup(
            pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnNV1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnDH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnKH1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnQLLayout = new javax.swing.GroupLayout(pnQL);
        pnQL.setLayout(pnQLLayout);
        pnQLLayout.setHorizontalGroup(
            pnQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQLLayout.createSequentialGroup()
                .addGroup(pnQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnNVcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnSPcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnDHcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnKHcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnTong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnQLLayout.setVerticalGroup(
            pnQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQLLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(pnSPcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnNVcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnDHcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnKHcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
            .addComponent(pnTong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnTK.setBackground(new java.awt.Color(221, 190, 169));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Thống kê nè");

        javax.swing.GroupLayout pnTKLayout = new javax.swing.GroupLayout(pnTK);
        pnTK.setLayout(pnTKLayout);
        pnTKLayout.setHorizontalGroup(
            pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1002, Short.MAX_VALUE)
            .addGroup(pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnTKLayout.createSequentialGroup()
                    .addGap(446, 446, 446)
                    .addComponent(jLabel5)
                    .addContainerGap(491, Short.MAX_VALUE)))
        );
        pnTKLayout.setVerticalGroup(
            pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
            .addGroup(pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnTKLayout.createSequentialGroup()
                    .addGap(295, 295, 295)
                    .addComponent(jLabel5)
                    .addContainerGap(295, Short.MAX_VALUE)))
        );

        pnBH.setBackground(new java.awt.Color(221, 190, 169));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Bán hàng nè");

        javax.swing.GroupLayout pnBHLayout = new javax.swing.GroupLayout(pnBH);
        pnBH.setLayout(pnBHLayout);
        pnBHLayout.setHorizontalGroup(
            pnBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBHLayout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel4)
                .addContainerGap(524, Short.MAX_VALUE))
        );
        pnBHLayout.setVerticalGroup(
            pnBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBHLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(290, 290, 290))
        );

        pnTC.setBackground(new java.awt.Color(221, 190, 169));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffe/img/1.png"))); // NOI18N

        javax.swing.GroupLayout pnTCLayout = new javax.swing.GroupLayout(pnTC);
        pnTC.setLayout(pnTCLayout);
        pnTCLayout.setHorizontalGroup(
            pnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTCLayout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );
        pnTCLayout.setVerticalGroup(
            pnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTCLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTongLayout = new javax.swing.GroupLayout(pnTong);
        pnTong.setLayout(pnTongLayout);
        pnTongLayout.setHorizontalGroup(
            pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTongLayout.setVerticalGroup(
            pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addComponent(pnTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLMouseClicked
        pnTC.setVisible(false);
        pnBH.setVisible(false);
        pnQL.setVisible(true);
        pnTK.setVisible(false);
        pnTrangChu.setBackground(new Color(60, 49, 49));
        pnQuanLy.setBackground(new Color(221, 190, 169));
        pnBanHang.setBackground(new Color(60, 49, 49));
        lbQL.setForeground(new Color(0, 0, 0));
        lbTC.setForeground(new Color(255, 255, 255));
        lbBH.setForeground(new Color(255, 255, 255));
        lbTK.setForeground(new Color(255, 255, 255));
        pnThongKe.setBackground(new Color(60,49,49));
        pnSPcon.setBackground(new Color(60,49,49));
        lbSPcon.setForeground(Color.white);
        //221,190,169
        //60,49,49
    }//GEN-LAST:event_lbQLMouseClicked

    private void lbTCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTCMouseClicked
        pnQL.setVisible(false);
        pnBH.setVisible(false);
        pnTC.setVisible(true);
        pnTK.setVisible(false);
        pnQuanLy.setBackground(new Color(60, 49, 49));
        pnTrangChu.setBackground(new Color(221, 190, 169));
        lbTC.setForeground(new Color(0, 0, 0));
        lbQL.setForeground(new Color(255, 255, 255));
        lbBH.setForeground(new Color(255, 255, 255));
        lbTK.setForeground(new Color(255, 255, 255));
        pnBanHang.setBackground(new Color(60, 49, 49));
        pnThongKe.setBackground(new Color(60,49,49));
    }//GEN-LAST:event_lbTCMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_jLabel2MouseClicked

    private void lbBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBHMouseClicked
        pnBH.setVisible(true);
        pnQL.setVisible(false);
        pnTC.setVisible(false);
        pnTK.setVisible(false);
        lbBH.setForeground(new Color(0, 0, 0));
        lbTC.setForeground(new Color(255, 255, 255));
        lbQL.setForeground(new Color(255, 255, 255));
        lbTK.setForeground(new Color(255, 255, 255));
        pnBanHang.setBackground(new Color(221,190,169));
        pnQuanLy.setBackground(new Color(60,49,49));
        pnTrangChu.setBackground(new Color(60,49,49));
        pnThongKe.setBackground(new Color(60,49,49));

    }//GEN-LAST:event_lbBHMouseClicked

    private void lbTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTKMouseClicked
        pnTC.setVisible(false);
        pnBH.setVisible(false);
        pnQL.setVisible(false);
        pnTK.setVisible(true);
        lbTK.setForeground(new Color(0, 0, 0));
        lbTC.setForeground(new Color(255, 255, 255));
        lbQL.setForeground(new Color(255, 255, 255));
        lbBH.setForeground(new Color(255, 255, 255));
        pnThongKe.setBackground(new Color(221,190,169));
        pnQuanLy.setBackground(new Color(60,49,49));
        pnTrangChu.setBackground(new Color(60,49,49));
        pnBanHang.setBackground(new Color(60,49,49));
    }//GEN-LAST:event_lbTKMouseClicked

    private void lbSPconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSPconMouseClicked
        pnSPcon.setBackground(new Color(60,49,49));
        pnNVcon.setBackground(Color.white);
        pnDHcon.setBackground(Color.white);
        pnKHcon.setBackground(Color.white);
        lbKHcon.setForeground(Color.black);
        lbDHcon.setForeground(Color.black);
        lbNVcon.setForeground(Color.black);
        lbSPcon.setForeground(Color.white);
        pnNV1.setVisible(false);
        pnSP1.setVisible(true);
        pnDH1.setVisible(false);
        pnKH1.setVisible(false);
        
    }//GEN-LAST:event_lbSPconMouseClicked

    private void lbNVconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNVconMouseClicked
        pnSPcon.setBackground(Color.white);
        pnNVcon.setBackground(new Color(60,49,49));
        pnDHcon.setBackground(Color.white);
        pnKHcon.setBackground(Color.white);
        lbKHcon.setForeground(Color.black);
        lbDHcon.setForeground(Color.black);
        lbNVcon.setForeground(Color.white);
        lbSPcon.setForeground(Color.black);
        pnNV1.setVisible(true);
        pnSP1.setVisible(false);
        pnDH1.setVisible(false);
        pnKH1.setVisible(false);
    }//GEN-LAST:event_lbNVconMouseClicked

    private void lbDHconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDHconMouseClicked
        pnSPcon.setBackground(Color.white);
        pnNVcon.setBackground(Color.white);
        pnDHcon.setBackground(new Color(60,49,49));
        pnKHcon.setBackground(Color.white);
        lbKHcon.setForeground(Color.black);
        lbDHcon.setForeground(Color.white);
        lbNVcon.setForeground(Color.black);
        lbSPcon.setForeground(Color.black);
        pnNV1.setVisible(false);
        pnSP1.setVisible(false);
        pnDH1.setVisible(true);
        pnKH1.setVisible(false);
    }//GEN-LAST:event_lbDHconMouseClicked

    private void lbKHconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbKHconMouseClicked
        pnSPcon.setBackground(Color.white);
        pnNVcon.setBackground(Color.white);
        pnDHcon.setBackground(Color.white);
        pnKHcon.setBackground(new Color(60,49,49));
        lbKHcon.setForeground(Color.white);
        lbDHcon.setForeground(Color.black);
        lbNVcon.setForeground(Color.black);
        lbSPcon.setForeground(Color.black);
        pnNV1.setVisible(false);
        pnSP1.setVisible(false);
        pnDH1.setVisible(false);
        pnKH1.setVisible(true);
    }//GEN-LAST:event_lbKHconMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbBH;
    private javax.swing.JLabel lbDHcon;
    private javax.swing.JLabel lbKHcon;
    private javax.swing.JLabel lbNVcon;
    private javax.swing.JLabel lbQL;
    private javax.swing.JLabel lbSPcon;
    private javax.swing.JLabel lbTC;
    private javax.swing.JLabel lbTK;
    private javax.swing.JPanel pnBH;
    private javax.swing.JPanel pnBanHang;
    private javax.swing.JPanel pnDH1;
    private javax.swing.JPanel pnDHcon;
    private javax.swing.JPanel pnKH1;
    private javax.swing.JPanel pnKHcon;
    private javax.swing.JPanel pnNV1;
    private javax.swing.JPanel pnNVcon;
    private javax.swing.JPanel pnQL;
    private javax.swing.JPanel pnQuanLy;
    private javax.swing.JPanel pnSP1;
    private javax.swing.JPanel pnSPcon;
    private javax.swing.JPanel pnTC;
    private javax.swing.JPanel pnTK;
    private javax.swing.JPanel pnThongKe;
    private javax.swing.JPanel pnTong;
    private javax.swing.JPanel pnTong1;
    private javax.swing.JPanel pnTrangChu;
    // End of variables declaration//GEN-END:variables
}
