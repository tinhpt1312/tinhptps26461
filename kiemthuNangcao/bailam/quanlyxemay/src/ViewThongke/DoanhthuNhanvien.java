/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ViewThongke;

import DAO.ThongKeDAO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ADMIN
 */
public class DoanhthuNhanvien extends javax.swing.JPanel {

    ThongKeDAO DAO = new ThongKeDAO();

    /**
     * Creates new form ThongkeTongthu
     */
    public DoanhthuNhanvien() {
        initComponents();
        setYearCbo();

    }

    private void setYearCbo() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);//lấy năm
        for (int i = 0; i < 10; i++) {
            cboYear.addItem(String.valueOf(currentYear));
            currentYear -= 1; //lay nam hien tai và 10 nam truoc            
        }
    }

    private void loadThongKeDoanhthuNV() {
        DefaultTableModel model = (DefaultTableModel) tblThongke.getModel();
        model.setRowCount(0);
//        String chuoiNam=(String) cboYear.getSelectedItem();
//        String chuoiThang=(String) cboMonth.getSelectedItem();
        int Nam = Integer.parseInt((String) cboYear.getSelectedItem());
        int Thang = Integer.parseInt((String) cboMonth.getSelectedItem());
        List<Object[]> list = DAO.getThongKeDoanhthuNV(Nam, Thang);
        for (Object[] objects : list) {
            double gia = (double) objects[3];
            objects[3] = Utility.UtilityFormat.DinhdangVnd(gia);
            model.addRow(objects);
        }
    }

    private void exportToExcel(String path) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblThongke.getModel();

            // Tạo một tệp Excel mới
            WritableWorkbook workbook = Workbook.createWorkbook(new File(path + "\\ThongKeTongThuNhanVien.xls"));
            WritableSheet sheet = workbook.createSheet("ThongKeTongThuNhanVien", 0);

            // Ghi tên các cột vào tệp Excel
            for (int i = 0; i < model.getColumnCount(); i++) {
                Label label = new Label(i, 0, model.getColumnName(i));
                sheet.addCell(label);
            }

            // Ghi dữ liệu từ bảng vào tệp Excel
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Object cellValue = model.getValueAt(i, j);
                    Label label = new Label(j, i + 1, cellValue.toString());
                    sheet.addCell(label);
                }
            }

            // Lưu tệp Excel
            workbook.write();
            workbook.close();

            JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tạo hoặc ghi file Excel: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }

    private void createBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Lấy dữ liệu từ bảng và thêm vào dataset
        for (int i = 0; i < tblThongke.getRowCount(); i++) {
            String label = tblThongke.getValueAt(i, 1).toString(); // Nhãn tháng

            String valueStr = tblThongke.getValueAt(i, 3).toString();
            float x = Utility.UtilityFormat.DinhdangVndToFloat(valueStr);
            // Loại bỏ tất cả kí tự không phải là số hoặc dấu chấm        
            dataset.addValue(x, "Doanh số", label);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ doanh số theo tháng", // Tiêu đề biểu đồ
                "Mã nhân viên", // Nhãn trục x
                "Doanh số", // Nhãn trục y
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, true, false);

        barChart.setBackgroundPaint(Color.WHITE);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));

        JFrame frame = new JFrame("Biểu đồ cột");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        cboYear = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongke = new javax.swing.JTable();
        cboMonth = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnchart = new javax.swing.JButton();
        Excel = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 228, 228));

        jLabel1.setText("Năm");

        cboYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboYearActionPerformed(evt);
            }
        });

        tblThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tháng ", "Mã nhân viên", "Tên nhân viên", "Doanh số"
            }
        ));
        jScrollPane1.setViewportView(tblThongke);

        cboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMonthActionPerformed(evt);
            }
        });

        jLabel2.setText("Tháng");

        btnchart.setText("Biểu đồ");
        btnchart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchartActionPerformed(evt);
            }
        });

        Excel.setText("Excel");
        Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnchart, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnchart)
                    .addComponent(Excel))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboYearActionPerformed
        loadThongKeDoanhthuNV();
    }//GEN-LAST:event_cboYearActionPerformed

    private void cboMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMonthActionPerformed
        loadThongKeDoanhthuNV();
    }//GEN-LAST:event_cboMonthActionPerformed

    private void btnchartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchartActionPerformed
        createBarChart();
    }//GEN-LAST:event_btnchartActionPerformed

    private void ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcelActionPerformed
        String pathSave = Utility.UtilityImage.chooseFilePath();
        if (pathSave != null) {
            exportToExcel(pathSave);
        }
    }//GEN-LAST:event_ExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Excel;
    private javax.swing.JButton btnchart;
    private javax.swing.JComboBox<String> cboMonth;
    private javax.swing.JComboBox<String> cboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongke;
    // End of variables declaration//GEN-END:variables
}
