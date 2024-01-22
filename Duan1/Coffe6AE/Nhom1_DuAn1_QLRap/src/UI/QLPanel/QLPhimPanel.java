package UI.QLPanel;

import DAO.PhimDAO;
import Model.Phim;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class QLPhimPanel extends javax.swing.JPanel {

    PhimDAO phimDAO = new PhimDAO();

    public QLPhimPanel() {
        initComponents();
        eventFind();
        fillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachPhim = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(250, 30, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 30, 0));
        jLabel1.setText("Tra Cứu Phim");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 249, 253));
        jLabel2.setText("Theo tên phim:");

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setPreferredSize(new java.awt.Dimension(300, 30));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        tblDanhSachPhim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDanhSachPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phim", "Tên phim", "Thời lượng", "Rated", "Ngày chiếu", "Quốc gia", "Trạng thái"
            }
        ));
        tblDanhSachPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhimMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachPhim);
        if (tblDanhSachPhim.getColumnModel().getColumnCount() > 0) {
            tblDanhSachPhim.getColumnModel().getColumn(0).setMinWidth(50);
            tblDanhSachPhim.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDanhSachPhim.getColumnModel().getColumn(0).setMaxWidth(50);
            tblDanhSachPhim.getColumnModel().getColumn(1).setMinWidth(120);
            tblDanhSachPhim.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblDanhSachPhim.getColumnModel().getColumn(1).setMaxWidth(120);
            tblDanhSachPhim.getColumnModel().getColumn(2).setMinWidth(200);
            tblDanhSachPhim.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblDanhSachPhim.getColumnModel().getColumn(2).setMaxWidth(200);
            tblDanhSachPhim.getColumnModel().getColumn(3).setMinWidth(70);
            tblDanhSachPhim.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblDanhSachPhim.getColumnModel().getColumn(3).setMaxWidth(70);
            tblDanhSachPhim.getColumnModel().getColumn(4).setMinWidth(50);
            tblDanhSachPhim.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDanhSachPhim.getColumnModel().getColumn(4).setMaxWidth(50);
            tblDanhSachPhim.getColumnModel().getColumn(7).setMinWidth(100);
            tblDanhSachPhim.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblDanhSachPhim.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(100, 35));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setPreferredSize(new java.awt.Dimension(120, 30));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setPreferredSize(new java.awt.Dimension(100, 35));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(186, 186, 186)))
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        DiaLogPhim phimDiaLogs = new DiaLogPhim();
        phimDiaLogs.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        deletePhim();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        findPhim();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblDanhSachPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhimMouseClicked
        // TODO add your handling code here:
        int i = tblDanhSachPhim.getSelectedRow();
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            DiaLogPhim d = new DiaLogPhim();
            Phim p = new Phim();
            p.setID(tblDanhSachPhim.getValueAt(i, 1).toString());
            p.setTenPhim(tblDanhSachPhim.getValueAt(i, 2).toString());
            p.setThoiLuong((int) tblDanhSachPhim.getValueAt(i, 3));
            p.setID_LoaiPhim((int) tblDanhSachPhim.getValueAt(i, 4));
            p.setDienVien(tblDanhSachPhim.getValueAt(i, 5).toString());
            p.setNSX(tblDanhSachPhim.getValueAt(i, 6).toString());
            p.setNgonNgu(tblDanhSachPhim.getValueAt(i, 7).toString());
            p.setQuocGia(tblDanhSachPhim.getValueAt(i, 8).toString());
            p.setGioiHanTuoi((int) tblDanhSachPhim.getValueAt(i, 9));
            p.setTrangThai(tblDanhSachPhim.getValueAt(i, 10).toString());
            p.setNgayCongChieu((Date) tblDanhSachPhim.getValueAt(i, 11));
            p.setTomTat(tblDanhSachPhim.getValueAt(i, 12).toString());
            d.setForm(p);
            d.setVisible(true);
        }
    }//GEN-LAST:event_tblDanhSachPhimMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable tblDanhSachPhim;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    void eventFind() {
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtTimKiem.getText().trim().length() == 0) {
                    fillTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachPhim.getModel();
        model.setRowCount(0);
        int i = 1;
        try {
            List<Phim> list = phimDAO.selectAll();
            for (Phim phim : list) {
                Object[] row = {
                    i++, phim.getID(), phim.getTenPhim(), phim.getThoiLuong(), phim.getID_LoaiPhim(),
                    phim.getDienVien(), phim.getNSX(), phim.getNgonNgu(), phim.getQuocGia(),
                    phim.getGioiHanTuoi(), phim.getTrangThai(), phim.getNgayCongChieu(), phim.getTomTat()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn!");
        }
    }

    void findPhim() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachPhim.getModel();
        model.setRowCount(0);
        int i = 1;
        try {
            for (Phim phim : phimDAO.findPhim(txtTimKiem.getText())) {
                Object[] row = {
                    i++, phim.getID(), phim.getTenPhim(), phim.getThoiLuong(), phim.getGioiHanTuoi(),
                    phim.getNgayCongChieu(), phim.getQuocGia(), phim.getTrangThai()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn!");
        }
    }

    void deletePhim() {
        int i = tblDanhSachPhim.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblDanhSachPhim.getModel();
        String id = model.getValueAt(i, 1).toString();
        try {
            phimDAO.delete(id);
            this.fillTable();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }
}
