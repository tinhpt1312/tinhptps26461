/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.KhachHangDAO;
import Model.KhachHang;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import Model.PhuKien;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.MouseInputListener;
import Utility.UtilityDate;
import Model.User;
import Utility.UtilityFormat;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QuanLyKhachHang extends javax.swing.JPanel {

    KhachHangDAO DAO = new KhachHangDAO();
    ArrayList<KhachHang> list;
    int index = -1;

    /**
     * Creates new form NewJPanel
     */
    public QuanLyKhachHang() {
        initComponents();
        clearForm();
        loadAll();
        Status(false);
        dateChooserNgayDangKy.setEnabled(false);
    }

    public void LoadTable() {
        index = -1;
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        int i = 1;
        for (KhachHang x : list) {
            model.addRow(new Object[]{i, x.getMaKhachHang(), x.getHovaTen(), x.isGioiTinh() ? "Nam" : "Nữ", x.getNgaySinh(), x.getSoDT(), x.getNgayDangKy()});
            i++;
        }
    }

    public void loadAll() {
        list = (ArrayList<KhachHang>) DAO.SelectAll();
        LoadTable();
    }

    public void loadByFind() {
        list = (ArrayList<KhachHang>) DAO.SelectbyIDbyNamebySdt(txtTimkiem.getText());
        LoadTable();

    }

    private boolean Validate(String action) {
        String patternMaKhachHang = "^(?i)KH\\d+$";
        String patternSodt = "^\\d{10,11}$";
        String patternTen = "\\d+";
        Date NgaySinh = UtilityDate.StringToDate(txtNgaysinh.getText());
        LocalDate NgayDangKy = UtilityDate.StringToLocalDate(txtNgaydangky.getText());
        LocalDate NgayHienTai = LocalDate.now();

        if (!txtMaKhachHang.getText().matches(patternMaKhachHang)) {
            JOptionPane.showMessageDialog(this, "Sai mã khách hàng");
            return false;
        }
        if (txtHoten.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Nhập tên khách hàng");
            return false;
        }
        if (txtHoten.getText().matches(patternTen)) {
            JOptionPane.showMessageDialog(this, "Họ và tên phải là chữ");
            return false;
        }
        if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Chọn giới tính");
            return false;
        }
        //validate ngay sinh
        if (NgaySinh == null) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng");
            return false;
        }
        if (UtilityDate.tinhTuoi(NgaySinh) < 18) {
            JOptionPane.showMessageDialog(this, "Khách hàng phải trên 18 tuổi");
            return false;
        }
        //validate ngay dang ky
        if (NgayDangKy == null) {
            JOptionPane.showMessageDialog(this, "Ngày đăng ký không đúng định dạng");
            return false;
        }
        if (action.equals("Them")) {
            if (NgayDangKy.isBefore(NgayHienTai)) {
                JOptionPane.showMessageDialog(this, "Ngày đăng ký phải là ngày hiện tại trở đi");
                return false;
            }
        }
        //validate so dien thoai
        if (!txtSodt.getText().matches(patternSodt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng");
            return false;
        }

        return true;
    }

    public void Status(boolean check) {
        txtMaKhachHang.setFocusable(!check);
        btnThem.setEnabled(!check);
        btnSua.setEnabled(check);
        if (User.isTruongPhong()) {
            btnXoa.setEnabled(check);
        } else {
            btnXoa.setEnabled(false);
        }
        txtNgaydangky.setFocusable(check);
        if (!check) {
            LocalDate ld = LocalDate.now();
            DateTimeFormatter dinhdang = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String ngayhientai = ld.format(dinhdang);
            txtNgaydangky.setText(ngayhientai);
        }
        txtMaNhanVien.setFocusable(check);
    }

    public void ShowInfo() {
        if (index > -1 && !list.isEmpty()) {
            tblKhachHang.clearSelection();
            tblKhachHang.setRowSelectionInterval(index, index);
            KhachHang x = list.get(index);
            txtMaKhachHang.setText(x.getMaKhachHang());
            txtHoten.setText(x.getHovaTen());
            if (x.isGioiTinh()) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtNgaysinh.setText(UtilityDate.DateToString(x.getNgaySinh()));
            txtNgaydangky.setText(UtilityDate.DateToString(x.getNgayDangKy()));
            txtSodt.setText(x.getSoDT());
            txtMaNhanVien.setText(x.getMaNhanVien());
            btnThem.setEnabled(false);
            Status(true);
        }
    }

    public KhachHang getForm() {
        KhachHang x = new KhachHang();
        x.setGioiTinh(rdoNam.isSelected());
        x.setHovaTen(txtHoten.getText());
        x.setMaKhachHang(txtMaKhachHang.getText().toUpperCase());
        x.setMaNhanVien(txtMaNhanVien.getText());
        x.setNgayDangKy(UtilityDate.StringToDate(txtNgaydangky.getText()));
        x.setNgaySinh(UtilityDate.StringToDate(txtNgaysinh.getText()));
        x.setSoDT(txtSodt.getText());
        return x;
    }

    public void clearForm() {
        tblKhachHang.clearSelection();
        txtNgaysinh.setText(null);
        txtMaKhachHang.setText(autoId().toUpperCase());
        txtHoten.setText(null);
        txtNgaydangky.setText(null);
        txtSodt.setText(null);
        txtMaNhanVien.setText(User.getUser().getMaNhanVien());
        buttonGroup1.clearSelection();
        Status(false);
    }

    public String autoId() {
        int nextId = DAO.getLastId() + 1;
        return "KH" + nextId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        dateChooserNgayDangKy = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgaysinh = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField(20);
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtSodt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgaydangky = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnforward = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();

        pnlTitle.setBackground(new java.awt.Color(147, 161, 119));
        pnlTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        pnlTitle.setMaximumSize(new java.awt.Dimension(925, 50));
        pnlTitle.setPreferredSize(new java.awt.Dimension(755, 40));

        jTextField1.setBackground(new java.awt.Color(179, 192, 154));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Thứ tự");
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.setFocusable(false);

        jTextField2.setBackground(new java.awt.Color(179, 192, 154));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Mã khách hàng");
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField2.setFocusable(false);

        jTextField3.setBackground(new java.awt.Color(179, 192, 154));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Họ và tên");
        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField3.setFocusable(false);

        jTextField4.setBackground(new java.awt.Color(179, 192, 154));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Giới tính");
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField4.setFocusable(false);

        jTextField5.setBackground(new java.awt.Color(179, 192, 154));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Ngày sinh");
        jTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField5.setFocusable(false);

        jTextField6.setBackground(new java.awt.Color(179, 192, 154));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("Số điện thoại");
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField6.setFocusable(false);

        jTextField7.setBackground(new java.awt.Color(179, 192, 154));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Ngày đăng ký");
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField7.setFocusable(false);

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dateChooserNgayDangKy.setTextRefernce(txtNgaydangky);

        dateChooser2.setTextRefernce(txtNgaysinh);

        setBackground(new java.awt.Color(241, 221, 221));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(940, 500));

        jPanel1.setBackground(new java.awt.Color(171, 171, 215));

        txtMaKhachHang.setBackground(new java.awt.Color(204, 204, 255));
        txtMaKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtMaKhachHang.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã khách hàng :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Họ và tên :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ngày sinh :");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Giới tính :");

        txtHoten.setMaximumSize(new java.awt.Dimension(134, 2147483647));

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(255, 255, 255));
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(255, 255, 255));
        rdoNu.setText("Nữ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số ĐT :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày đăng ký :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nhân viên tạo :");

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaKhachHang))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNhanVien))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNgaysinh))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSodt))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNgaydangky, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNu)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSodt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaydangky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(182, 182, 222));

        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFirst.setText("|<");
        btnFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFirstMouseClicked(evt);
            }
        });

        btnforward.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnforward.setText("<<");
        btnforward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnforwardMouseClicked(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLast.setText(">|");
        btnLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLastMouseClicked(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNext.setText(">>");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnforward, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnforward)
                    .addComponent(btnLast)
                    .addComponent(btnNext))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Số thứ tự", "Mã khách hàng", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Ngày đăng ký"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-find-30.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimkiem)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTimkiem)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (Validate("Them")) {
            int check = DAO.Them(getForm());
            switch (check) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadAll();
                    break;
                case 2627:
                    JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseClicked
        index = 0;
        ShowInfo();
    }//GEN-LAST:event_btnFirstMouseClicked

    private void btnLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseClicked
        index = list.size() - 1;
        ShowInfo();
    }//GEN-LAST:event_btnLastMouseClicked

    private void btnforwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnforwardMouseClicked
        if (!list.isEmpty()) {
            index--;
        }
        if (index < 0) {
            index = 0;
        }
        ShowInfo();
    }//GEN-LAST:event_btnforwardMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        if (!list.isEmpty()) {
            index++;
        }
        if (index >= list.size()) {
            index = list.size() - 1;
        }
        ShowInfo();
    }//GEN-LAST:event_btnNextMouseClicked

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        index = tblKhachHang.getSelectedRow();
        ShowInfo();
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        loadByFind();
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (!txtMaKhachHang.getText().isBlank())
            if (Utility.UtilityNotificate.confirmDialog("Xác nhận xóa khách hàng : "+txtMaKhachHang.getText())==1)
                if (DAO.Xoa(getForm()) == 1) {
                    index--;
                    loadByFind();
                    clearForm();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");

                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Validate("")) {
            int check = DAO.Sua(getForm());
            switch (check) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    loadByFind();
                    break;
                case 2627:
                    JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnforward;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooserNgayDangKy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgaydangky;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtSodt;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
