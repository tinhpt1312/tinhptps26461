/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.HangXeDAO;
import DAO.NhanVienDAO;
import Items.ItemXemay;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import DAO.XeMayDAO;
import Model.HangXe;
import Model.NhanVien;
import Model.XeMay;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.MouseInputListener;
import Utility.UtilityDate;
import Utility.UtilityImage;
import Model.User;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import Utility.UtilityFormat;
import Utility.UtilityConvert;
import Utility.UtilityMail;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class QuanLyXeMay extends javax.swing.JPanel {

    int pnlItemsHeight = 630;
    XeMayDAO DAO = new XeMayDAO();
    ArrayList<XeMay> list;
    int index = -1;

    public QuanLyXeMay() {
        initComponents();
        fillcboHangXe();
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 24, 12);
        pnlItems.setLayout(layout);

        clearForm();
        loadAll();
        Status(false);
    }

    private void LoadTable() {
        index = -1;
        pnlItems.removeAll();
        pnlItemsHeight = 630;
        pnlItems.setPreferredSize(new Dimension(650, pnlItemsHeight)); //set kich thuong pnlItems ve gia tri ban dau

        int i = 0;
        for (XeMay x : list) {
            ItemXemay Item = new ItemXemay(x, i);
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

    private void loadAll() {
        list = (ArrayList<XeMay>) DAO.SelectAll();
        LoadTable();
    }

    private void loadFind(String find) {
        list = (ArrayList<XeMay>) DAO.FindbyNamebyIdbyCarmaker(find);
        if (!list.isEmpty() && list != null) {
            LoadTable();
        } else {
            LoadTable();
        }

    }

    private void addListItem(JPanel pnl) {
        pnlItems.add(pnl);
        if (pnlItems.getComponentCount() % 6 == 0) {
            pnlItemsHeight += 630;
            pnlItems.setPreferredSize(new Dimension(650, pnlItemsHeight));
        }
    }

    private boolean Validate(String action) {
        String patternMaxe = "^[Xx]\\d+$";
        String Maxe = txtMaxe.getText();
        int Soluong = (int) txtSoluong.getValue();
        float Gia;
        LocalDate NgayNhap = UtilityDate.StringToLocalDate(txtNgaynhap.getText());
        LocalDate NgayHienTai = LocalDate.now();

        if (!Maxe.matches(patternMaxe)) {
            JOptionPane.showMessageDialog(this, "Sai mã xe");
            return false;
        }
        if (txtTenxe.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "nhập tên xe");
            return false;
        }
        if (cboHangXe.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Chọn hãng xe");
            return false;
        }
        if (Soluong < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng lón hơn hoặc bằng 0");
            return false;
        }
        //validate gia
        try {
            Gia = UtilityFormat.DinhdangStringtoFloat(txtGiatien.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải là số");
            return false;
        }
        if (Gia < 0) {
            JOptionPane.showMessageDialog(this, "Giá tiền lón hơn hoặc bằng 0");
            return false;
        }
        if (NgayNhap == null) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống ngày nhập");
            return false;
        }
        if (action.equals("Them")) {
            if (NgayNhap.isBefore(NgayHienTai)) {
                JOptionPane.showMessageDialog(this, "Ngày nhập phải lớn hơn hoặc bằng ngày hiện tại");
                return false;
            }
        }
        return true;
    }

    private void Status(boolean check) {
        btnThemgiohang.setEnabled(check);
        btnSua.setEnabled(check);
        if (User.isTruongPhong()) {
            btnXoa.setEnabled(check);
        } else {
            btnXoa.setEnabled(false);
        }
        txtMaxe.setFocusable(!check);
        btnThem.setEnabled(!check);
    }

    private void ShowInfo(XeMay x) {
        txtMaxe.setText(x.getMaXeMay());
        setSelectCbo(x);
        txtGiatien.setText(UtilityFormat.DinhdangFloat(x.getGiaTien()));
        txtNgaynhap.setText(UtilityDate.DateToString(x.getNgayNhap()));
        txtTenxe.setText(x.getTenXe());
        txtSoluong.setValue(x.getSoluong());
        if (x.getHinh() != null) {
            ImageIcon icon = UtilityImage.BytesToImageIcon(x.getHinh());
            lblHinh.setIcon(UtilityImage.ResizeHinh(lblHinh, icon));
        } else {
            lblHinh.setIcon(null);
        }
    }

    private void RemoveSelected() {
        if (index > -1 && !list.isEmpty()) {
            ItemXemay x = (ItemXemay) pnlItems.getComponents()[index];
            if (x.isClicked()) {
                x.RemoveChoose();
            }
        }
    }

    private void SelectItem() {
        if (index > -1 && !list.isEmpty()) {
            ItemXemay Item = (ItemXemay) pnlItems.getComponents()[index];
            Item.Choose();
            ShowInfo(list.get(index));
            Status(true);
        }
    }

    private XeMay getForm() {
        XeMay x = new XeMay();
        x.setMaXeMay(txtMaxe.getText().toUpperCase());
        x.setMaHangXe(getIdHangXe());
        x.setSoluong((int) txtSoluong.getValue());
        x.setTenXe(txtTenxe.getText());
        ImageIcon icon = (ImageIcon) lblHinh.getIcon();
        if (icon != null) {
            x.setHinh(UtilityImage.imageIconToByteArray(icon));
        } else {
            x.setHinh(null);
        }
        x.setNgayNhap(UtilityDate.StringToDate(txtNgaynhap.getText()));
        x.setGiaTien(UtilityFormat.DinhdangStringtoFloat(txtGiatien.getText()));
        x.setMaNhanVien(User.getUser().getMaNhanVien());
        return x;
    }

    private void fillcboHangXe() {
        List<HangXe> list = new HangXeDAO().SelectAll();
        if (list != null && !list.isEmpty()) {
            for (HangXe hangXe : list) {
                cboHangXe.addItem(hangXe.getTenHang());
            }
        }
    }

    private String getIdHangXe() {
        return new HangXeDAO().SelectIDbyName((String) cboHangXe.getSelectedItem()).getMaHangXe();
    }

    private void setSelectCbo(XeMay x) {
        String mahangxe = new HangXeDAO().SelectNamebyid(x.getMaHangXe()).getMaHangXe();
        List<HangXe> listHX = new HangXeDAO().SelectAll();
        for (int i = 0; i < listHX.size(); i++) {
            if (listHX.get(i).getMaHangXe().equals(mahangxe)) {
                cboHangXe.setSelectedIndex(i);
                break;
            }
        }

    }

    private void clearForm() {
        index = -1;
        RemoveSelected();
        lblHinh.setIcon(null);
        txtMaxe.setText(autoId());
        cboHangXe.setSelectedIndex(-1);
        lblHinh.setToolTipText(null);
        txtGiatien.setText(null);
        txtNgaynhap.setText(null);
        txtSoluong.setValue(0);
        txtTenxe.setText(null);
        Date ngayHienTai = new Date();
        txtNgaynhap.setText(UtilityDate.DateToString(ngayHienTai));
        Status(false);
    }

    public String autoId() {
        int nextId = DAO.getLastId() + 1;
        return "X" + nextId;
    }

//    public String KiemTraSua() {
//        boolean check = false;
//        String sua = "Nhân viên : " + User.getUser().getMaNhanVien()
//                + "\nĐã chỉnh sửa xe " + getForm().getMaXeMay();
//        if (list.get(index).getSoluong() != getForm().getSoluong()) {
//            check = true;
//            sua += "\nSố lượng cũ : " + list.get(index).getSoluong() + "\n"
//                    + "Số lượng mới : " + getForm().getSoluong() + "\n";
//        }
//        if (!list.get(index).getTenXe().equals(getForm().getTenXe())) {
//            check = true;
//            sua += "\nTên cũ : " + list.get(index).getTenXe() + "\n"
//                    + "Tên mới : " + getForm().getTenXe() + "\n";
//        }
//        if (!list.get(index).getMaHangXe().equals(getForm().getMaHangXe())) {
//            check = true;
//            sua += "\nMã hãng cũ : " + list.get(index).getMaHangXe()+ "\n"
//                    + "Mã hãng mới : " + getForm().getMaHangXe()+ "\n";
//        }
//        if(list.get(index).getGiaTien() != getForm().getGiaTien()){
//            check = true;
//            sua += "\nGiá cũ : " + UtilityFormat.DinhdangVnd(list.get(index).getGiaTien())+ "\n"
//                    + "Giá mới : " + UtilityFormat.DinhdangVnd(getForm().getGiaTien())+ "\n";      
//        }
//        if(list.get(index).getNgayNhap().equals(getForm().getNgayNhap())){
//             check = true;
//            sua += "\nNgày nhập cũ : " + UtilityDate.DateToString(list.get(index).getNgayNhap())+ "\n"
//                    + "Ngày nhập mới : " + UtilityDate.DateToString(getForm().getNgayNhap())+ "\n";    
//        
//        }
//        if (check) {
//            return sua;
//        } else {
//            return null;
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        txtMaxe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenxe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGiatien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgaynhap = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThemgiohang = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JSpinner();
        cboHangXe = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlItems = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnforward = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();

        dateChooser1.setForeground(new java.awt.Color(204, 204, 255));
        dateChooser1.setTextRefernce(txtNgaynhap);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(940, 500));

        jPanel1.setBackground(new java.awt.Color(171, 171, 215));

        lblHinh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinh.setPreferredSize(new java.awt.Dimension(2, 2));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        txtMaxe.setBackground(new java.awt.Color(204, 204, 255));
        txtMaxe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtMaxe.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã xe :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên xe :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Hãng xe :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Giá /xe :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ngày Nhập :");

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

        btnThemgiohang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemgiohang.setText("Thêm giỏ hàng");
        btnThemgiohang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemgiohangActionPerformed(evt);
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
        jLabel6.setText("Số lượng :");

        txtSoluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSoluongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgaynhap))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiatien))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenxe))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaxe))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboHangXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(2, 2, 2)
                                        .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThemgiohang, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboHangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiatien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi)
                    .addComponent(btnThemgiohang))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 50));

        pnlItems.setBackground(new java.awt.Color(250, 243, 243));
        pnlItems.setAutoscrolls(true);
        pnlItems.setPreferredSize(new java.awt.Dimension(650, 500));

        javax.swing.GroupLayout pnlItemsLayout = new javax.swing.GroupLayout(pnlItems);
        pnlItems.setLayout(pnlItemsLayout);
        pnlItemsLayout.setHorizontalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        pnlItemsLayout.setVerticalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
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

        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-find-30.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 391, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTimKiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if (!txtMaxe.getText().isBlank())
            if (Utility.UtilityNotificate.confirmDialog("Xác nhận xóa xe máy : "+txtMaxe.getText()) == 1)
                if (DAO.Xoa(getForm()) == 1) {
                    index--;
                    loadFind(txtTimKiem.getText());
                    clearForm();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");

                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemgiohangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemgiohangActionPerformed
        new ThemGioHang(UtilityConvert.XemayToSanpham(getForm())).setVisible(true);
    }//GEN-LAST:event_btnThemgiohangActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed

        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        String path = UtilityImage.ChoosePathImage("src//HinhXe");
        if (path.isBlank()) {
            lblHinh.setIcon(null);
        } else {
            lblHinh.setIcon(UtilityImage.ResizeHinh(lblHinh, path));
        }
    }//GEN-LAST:event_lblHinhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Validate("")) {
//            String reason = JOptionPane.showInputDialog("lý do sửa");

            int check = DAO.Sua(getForm());
            switch (check) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
//                    String Mailtruongphong = new NhanVienDAO().SelectMailbyID("NV01");
                    loadAll();
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

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String TimKiem = txtTimKiem.getText();
        loadFind(txtTimKiem.getText());
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtSoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoluongMouseClicked

    }//GEN-LAST:event_txtSoluongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemgiohang;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnforward;
    private javax.swing.JComboBox<String> cboHangXe;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JPanel pnlItems;
    private javax.swing.JTextField txtGiatien;
    private javax.swing.JTextField txtMaxe;
    private javax.swing.JTextField txtNgaynhap;
    private javax.swing.JSpinner txtSoluong;
    private javax.swing.JTextField txtTenxe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
