package UI;

import DAO.BanVeDAO;
import Model.Phim;
import UI.BanVe.DialogChonVe;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class BanVePanel extends javax.swing.JPanel {

    public BanVePanel() {
        initComponents();
        fillTablePhim();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPhim = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnChonGhe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSuatChieu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));

        tblDSPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phim", "Tên phim"
            }
        ));
        jScrollPane1.setViewportView(tblDSPhim);
        if (tblDSPhim.getColumnModel().getColumnCount() > 0) {
            tblDSPhim.getColumnModel().getColumn(0).setMinWidth(100);
            tblDSPhim.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblDSPhim.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Danh sách phim");

        btnChonGhe.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnChonGhe.setText("Chọn ghế");
        btnChonGhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonGheActionPerformed(evt);
            }
        });

        tblSuatChieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblSuatChieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Suất", "Ngày chiếu", "Giờ", "Loại", "Ngôn ngữ", "Phòng", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(tblSuatChieu);

        jPanel1.setBackground(new java.awt.Color(255, 30, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(15, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChonGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnChonGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonGheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonGheActionPerformed
        // TODO add your handling code here:
        DialogChonVe chonVe = new DialogChonVe();
        chonVe.setVisible(true);
    }//GEN-LAST:event_btnChonGheActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonGhe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable tblDSPhim;
    private javax.swing.JTable tblSuatChieu;
    // End of variables declaration//GEN-END:variables

    void fillTablePhim() {
        BanVeDAO bvDao = new BanVeDAO();
        List<Phim> list = bvDao.getPhimList();
        DefaultTableModel model = (DefaultTableModel) tblDSPhim.getModel();
        model.setRowCount(0);
        for (Phim p : list) {
            Object[] o = new Object[]{
                p.getID(), p.getTenPhim()
            };
            model.addRow(o);
        }
    }

}
