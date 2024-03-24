/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Items.ItemNhanVien;
import DAO.NhanVienDAO;
import Model.NhanVien;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.MouseInputListener;
import Utility.UtilityDate;
import Utility.UtilityImage;
import Model.User;
import Utility.UtilityFormat;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class QuanLyNhanVien extends javax.swing.JPanel {

    int pnlItemsHeight = 630;
    NhanVienDAO DAO = new NhanVienDAO();
    List<NhanVien> list;
    int index = -1;

    /**
     * Creates new form NewJPanel
     */
    public QuanLyNhanVien() {
        initComponents();
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 8);
        pnlItems.setLayout(layout);
        clearForm();
        loadAllActive();
        Status(false);
    }

    private boolean Validate(String action) {
        String patternEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        String patternMaNhanVien = "^(?i)NV\\d+$";
        String patternMatKhau = "^(?=.*[!@#$%^&*()-_+=])[A-Za-z\\d!@#$%^&*()-_+=]{8,}$";
        String patternTen = "\\d+";

        char[] kytuMatKhau = txtMatKhau.getPassword();
        String MatKhau = new String(kytuMatKhau);

        Date NgaySinh = UtilityDate.StringToDate(txtNgaysinh.getText());
        LocalDate NgayBatDau = UtilityDate.StringToLocalDate(txtNgaybatdau.getText());
        LocalDate NgayKetThuc = UtilityDate.StringToLocalDate(txtNgayketthuc.getText());

        LocalDate NgayHienTai = LocalDate.now();

        if (!txtMaNhanVien.getText().matches(patternMaNhanVien)) {
            JOptionPane.showMessageDialog(this, "Sai mã nhân viên");
            return false;
        }
        if (!MatKhau.matches(patternMatKhau)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không đúng định dạng ( >8 ký tự )");
            return false;
        }
        if (txtHoVaTen.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Điền tên nhân viên");
            return false;
        }
        if (txtHoVaTen.getText().matches(patternTen)) {
            JOptionPane.showMessageDialog(this, "Tên là chữ không số hay ký tự đặc biệt");
            return false;
        }
        //vallidate ngay sinh
        if (NgaySinh == null) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng");
            return false;
        }
        if (UtilityDate.tinhTuoi(NgaySinh) < 18) {
            JOptionPane.showMessageDialog(this, "Nhân viên phải trên 18 tuổi");
            return false;
        }
        //validate ngay bat dau
        if (NgayBatDau == null) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không đúng định dạng");
            return false;
        }
        if (action.equals("Them")) {
            if (NgayBatDau.isBefore(NgayHienTai)) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải là ngày hiện tại trở đi");
                return false;
            }
        }
        //validate ngay ket thuc
        if (NgayKetThuc != null) {
            if (NgayKetThuc.isBefore(NgayBatDau)) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu");
                return false;
            }
        }
        //con lai
        if (!rdoNhanvien.isSelected() && !rdoTruongphong.isSelected()) {
            JOptionPane.showMessageDialog(this, "Chọn vai trò");
            return false;
        }
        if (!txtEmail.getText().matches(patternEmail)) {
            JOptionPane.showMessageDialog(this, "Enail không đúng định dạng");
            return false;
        }

        return true;
    }

    private void LoadTable() {
        index = -1;
        pnlItems.removeAll();
        pnlItemsHeight = 630;
        pnlItems.setPreferredSize(new Dimension(650, pnlItemsHeight));
        int i = 0;
        for (NhanVien x : list) {
            ItemNhanVien Item = new ItemNhanVien(x, i);
            i++;
            Item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    RemoveSelected();
                    index = Item.getIndex();//luu vi tri index moi
                    SelectItem();
                }
            }
            );
            addListItem(Item);
        }
        pnlItems.revalidate();
        pnlItems.repaint();
    }

    private void loadAllActive() {
        list = DAO.selectAllnvActive();
        LoadTable();
    }

    private void loadAllDeactive() {
        list = DAO.selectAllnvDeactive();
        LoadTable();
    }

    private void loadAll() {
        list = DAO.SelectAll();
        LoadTable();
    }

    private void loadbyIDbyName() {
        list = DAO.SelectByIdByName(txtTimkiem.getText());
        LoadTable();
    }

    private void Status(boolean check) {
        btnSua.setEnabled(check);
        if (User.isTruongPhong()) {
            btnXoa.setEnabled(check);
        } else {
            btnXoa.setEnabled(false);
        }
        btnThem.setEnabled(!check);
        txtMaNhanVien.setFocusable(!check);
    }

    private void ShowInfo(NhanVien x) {
        txtMaNhanVien.setText(x.getMaNhanVien());
        txtHoVaTen.setText(x.getHovaTen());
        txtEmail.setText(x.getMail());
        txtMatKhau.setText(x.getMatKhau());
        txtNgaysinh.setText(UtilityDate.DateToString(x.getNgaysinh()));
        txtNgaybatdau.setText(UtilityDate.DateToString(x.getNgaybatdau()));
        if (x.getNgayketthuc() == null) {
            txtNgayketthuc.setText(null);
        } else {
            txtNgayketthuc.setText(UtilityDate.DateToString(x.getNgayketthuc()));
        }
        if (x.getVaiTro()) {
            rdoTruongphong.setSelected(true);
        } else {
            rdoNhanvien.setSelected(true);
        }
        if (x.getHinh() != null) {
            ImageIcon icon = UtilityImage.BytesToImageIcon(x.getHinh());
            lblHinh.setIcon(UtilityImage.ResizeHinh(lblHinh, icon));
        } else {
            lblHinh.setIcon(null);
        }
    }

    private void addListItem(JPanel pnl) {
        pnlItems.add(pnl);
        if (pnlItems.getComponentCount() % 4 == 0) {
            pnlItemsHeight += 630;
            pnlItems.setPreferredSize(new Dimension(650, pnlItemsHeight));
        }
    }

    private void RemoveSelected() {
        if (index > -1 && !list.isEmpty()) {
            ItemNhanVien x = (ItemNhanVien) pnlItems.getComponents()[index];
            if (x.isClicked()) {
                x.RemoveChoose();
            }
        }
    }

    private void SelectItem() {
        if (index > -1 && !list.isEmpty()) {
            ItemNhanVien Item = (ItemNhanVien) pnlItems.getComponents()[index];
            Item.Choose();
            ShowInfo(list.get(index));
            Status(true);
        }
    }

    private NhanVien getForm() {
        NhanVien x = new NhanVien();

        ImageIcon icon = (ImageIcon) lblHinh.getIcon();
        if (icon != null) {
            x.setHinh(UtilityImage.imageIconToByteArray(icon));
        } else {
            x.setHinh(null);
        }

        x.setHovaTen(txtHoVaTen.getText());
        x.setMaNhanVien(txtMaNhanVien.getText().toUpperCase());
        x.setMail(txtEmail.getText());
        x.setMatKhau(txtMatKhau.getText());
        x.setVaiTro(rdoTruongphong.isSelected());
        x.setNgaysinh(UtilityDate.StringToDate(txtNgaysinh.getText()));
        x.setNgaybatdau(UtilityDate.StringToDate(txtNgaybatdau.getText()));
        if (txtNgayketthuc.getText().isBlank()) {
            x.setNgayketthuc(null);
        } else {
            x.setNgayketthuc(UtilityDate.StringToDate(txtNgayketthuc.getText()));
        }
        return x;
    }

    private void clearForm() {
        lblHinh.setIcon(null);
        txtEmail.setText(null);
        txtMaNhanVien.setText(autoId());
        txtHoVaTen.setText(null);
        txtMatKhau.setText(null);
        RemoveSelected();
    }

    public String autoId() {
        int nextId = DAO.getLastId() + 1;
        return "NV" + nextId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgVaitro = new javax.swing.ButtonGroup();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        dateChooser4 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField(20);
        rdoTruongphong = new javax.swing.JRadioButton();
        rdoNhanvien = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNgaysinh = new javax.swing.JTextField(20);
        txtNgaybatdau = new javax.swing.JTextField(20);
        txtNgayketthuc = new javax.swing.JTextField(20);
        lblPathhinh = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlItems = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnforward = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        cboTrangThai = new javax.swing.JComboBox<>();

        dateChooser2.setTextRefernce(txtNgayketthuc);

        dateChooser3.setTextRefernce(txtNgaysinh);

        dateChooser4.setTextRefernce(txtNgaybatdau);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(940, 510));

        jPanel1.setBackground(new java.awt.Color(171, 171, 215));

        lblHinh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinh.setPreferredSize(new java.awt.Dimension(2, 2));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        txtMaNhanVien.setBackground(new java.awt.Color(204, 204, 255));
        txtMaNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã nhân viên :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Họ và tên :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Email :");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

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

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Vai Trò :");

        txtHoVaTen.setMaximumSize(new java.awt.Dimension(134, 2147483647));

        btgVaitro.add(rdoTruongphong);
        rdoTruongphong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoTruongphong.setForeground(new java.awt.Color(255, 255, 255));
        rdoTruongphong.setText("Trưởng phòng");

        btgVaitro.add(rdoNhanvien);
        rdoNhanvien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNhanvien.setForeground(new java.awt.Color(255, 255, 255));
        rdoNhanvien.setText("Nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mật khẩu :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ngày sinh :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày bắt đầu :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Ngày kết thúc :");

        txtNgaysinh.setMaximumSize(new java.awt.Dimension(134, 2147483647));

        txtNgaybatdau.setMaximumSize(new java.awt.Dimension(134, 2147483647));

        txtNgayketthuc.setMaximumSize(new java.awt.Dimension(134, 2147483647));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgaybatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaNhanVien))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdoNhanvien)
                                            .addComponent(rdoTruongphong)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPathhinh)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPathhinh))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoTruongphong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoNhanvien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnThem)
                    .addComponent(btnMoi))
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 50));

        pnlItems.setBackground(new java.awt.Color(250, 243, 243));
        pnlItems.setAutoscrolls(true);
        pnlItems.setPreferredSize(new java.awt.Dimension(800, 370));

        javax.swing.GroupLayout pnlItemsLayout = new javax.swing.GroupLayout(pnlItems);
        pnlItems.setLayout(pnlItemsLayout);
        pnlItemsLayout.setHorizontalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        pnlItemsLayout.setVerticalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pnlItems);

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

        txtTimkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-find-30.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang làm việc", "Đã nghĩ việc" }));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimkiem)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTimkiem)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTrangThai)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (Validate("Them")) {
            NhanVien x = getForm();
            int check = DAO.Them(x);
            switch (check) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadAllActive();
                    break;
                case 2627:
                    JOptionPane.showMessageDialog(this, "Mã xe đã tồn tại");
                    break;
                case 547:
                    JOptionPane.showMessageDialog(this, "Hãng xe không đúng");
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (!txtMaNhanVien.getText().equals(User.getUser().getMaNhanVien())) {
            if (Utility.UtilityNotificate.confirmDialog("Xác nhận xóa nhân viên : "+txtMaNhanVien.getText()) == 1) {
                NhanVien x = getForm();
                Date ngayhientai = new Date();
                x.setNgayketthuc(ngayhientai);
                if (DAO.suaNgayKetThuc(x) == 1) {
                    index--;
                    loadAllActive();
                    clearForm();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không được xóa bản thân");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearForm();
        Status(false);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        String path = UtilityImage.ChoosePathImage("src//HinhNhanVien");
        if (path.isBlank()) {
            lblHinh.setIcon(null);
        } else {
            lblHinh.setIcon(UtilityImage.ResizeHinh(lblHinh, path));
        }

    }//GEN-LAST:event_lblHinhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Validate("")) {
            int check;
            if (index > -1 && txtMatKhau.getText().equals(list.get(index).getMatKhau())) {
                check = DAO.SuaKhongMatKhau(getForm());
            } else {
                check = DAO.Sua(getForm());
            }
            switch (check) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    loadAllActive();
                    break;
                case 2627:
                    JOptionPane.showMessageDialog(this, "Mã xe đã tồn tại");
                    break;
                case 547:
                    JOptionPane.showMessageDialog(this, "Hãng xe không đúng");
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseClicked
        RemoveSelected();
        index = 0;
        SelectItem();
    }//GEN-LAST:event_btnFirstMouseClicked

    private void btnLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseClicked
        RemoveSelected();
        index = list.size() - 1;
        SelectItem();
    }//GEN-LAST:event_btnLastMouseClicked

    private void btnforwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnforwardMouseClicked
        RemoveSelected();
        index--;
        if (index < 0) {
            index = 0;
        }
        SelectItem();
    }//GEN-LAST:event_btnforwardMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        RemoveSelected();
        index++;
        if (index > list.size() - 1) {
            index = list.size() - 1;
        }
        SelectItem();
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        loadbyIDbyName();
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        int cboIndex = cboTrangThai.getSelectedIndex();
        switch (cboIndex) {
            case 0:
                loadAll();
                break;
            case 1:
                loadAllActive();
                break;
            case 2:
                loadAllDeactive();
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_cboTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgVaitro;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnforward;
    private javax.swing.JComboBox<String> cboTrangThai;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private com.raven.datechooser.DateChooser dateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblPathhinh;
    private javax.swing.JPanel pnlItems;
    private javax.swing.JRadioButton rdoNhanvien;
    private javax.swing.JRadioButton rdoTruongphong;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtNgaybatdau;
    private javax.swing.JTextField txtNgayketthuc;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
