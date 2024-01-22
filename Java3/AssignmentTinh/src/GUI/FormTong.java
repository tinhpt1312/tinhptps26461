package GUI;

import DAO.KetNoiCSDL;
import DAO.StudentsDAO;
import DAO.GradeDAO;
import ENTITY.GRADE;
import ENTITY.STUDENTS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormTong extends javax.swing.JFrame {

    String strImg = null;
    List<STUDENTS> list1 = new ArrayList<>();
    List<GRADE> list2 = new ArrayList<>();
    int index = -1;
    String head1[] = {"MaSV", "HoTen", "Email", "SoDT", "Gioitinh", "Diachi", "Hinh"};
    DefaultTableModel model1 = new DefaultTableModel(head1, 0);

    String head2[] = {"ID", "MaSV", "HoTen", "Tiếng Anh", "Tin học", "GDTC", "Điểm TB"};
    DefaultTableModel model2 = new DefaultTableModel(head2, 0);

    /**
     * width: 204 height: 569
     */
    public FormTong() {
        initComponents();
        fillTable1();
        fillTable2();
        openMenuBar();
        txtMasv_1.setEnabled(false);
        txtHoten_1.setEnabled(false);
        txtEmail_1.setEnabled(false);
        txtSodt_1.setEnabled(false);
        txtAddress_1.setEnabled(false);

        txtMasv_2.setEnabled(false);
        txtTa.setEnabled(false);
        txtTh.setEnabled(false);
        txtTc.setEnabled(false);
    }
    int width = 204;
    int height = 569;

    public void khoaSinhvien() {
        lbSinhvien.setEnabled(false);
    }

    public void khoaDiem() {
        lbDiem.setEnabled(false);
    }

    public void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    panelMenu.setSize(width, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FormTong.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void closeMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    panelMenu.setSize(i, height);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FormTong.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void fillTable1() {
        list1.clear();
        model1.setRowCount(0);
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select * from STUDENTS";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                STUDENTS sv = new STUDENTS();
                sv.setMaSV(rs.getString("MaSV"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.seteMail(rs.getString("Email"));
                sv.setSoDT(rs.getString("SoDT"));
                sv.setGioiTinh(rs.getInt("GioiTinh"));
                sv.setDiaChi(rs.getString("Diachi"));
                sv.setHinh(rs.getString("Hinh"));
                list1.add(sv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (STUDENTS sv : list1) {
            Vector row = new Vector();
            row.add(sv.getMaSV());
            row.add(sv.getHoTen());
            row.add(sv.geteMail());
            row.add(sv.getSoDT());
            if(sv.getGioiTinh() == 1){
                row.add("Nam");
            }else if(sv.getGioiTinh() == 0){
                row.add("Nữ");
            }
            row.add(sv.getDiaChi());
            row.add(sv.getHinh());
            model1.addRow(row);
        }
        tblShow_1.setModel(model1);
    }

    public void fillTable2() {
        list2.clear();
        model2.setRowCount(0);
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select ID,st.MASV,Hoten,Tienganh,Tinhoc,GDTC from STUDENTS st inner join GRADE gr on st.MASV = gr.MASV;";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                GRADE sv = new GRADE();
                sv.setID(rs.getInt("ID"));       
                sv.setMaSv(rs.getString("MaSV"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
                list2.add(sv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (GRADE sv : list2) {
            Vector row = new Vector();
            row.add(sv.getID());
            row.add(sv.getMaSv());
            row.add(sv.getHoTen());
            row.add(sv.getDiemTa());
            row.add(sv.getDiemTh());
            row.add(sv.getDiemTc());
            row.add(sv.getDiemTb());
            model2.addRow(row);
        }
        tblShow_2.setModel(model2);

    }

    public void showDetail1(STUDENTS sv) {
        newSv1();
        txtMasv_1.setText(sv.getMaSV());
        txtHoten_1.setText(sv.getHoTen());
        txtEmail_1.setText(sv.geteMail());
        txtSodt_1.setText(sv.getSoDT());
        if (sv.getGioiTinh() == 1) {
            rdoNam.setSelected(true);
            rdoNu.setSelected(false);
        } else if (sv.getGioiTinh() == 0) {
            rdoNam.setSelected(false);
            rdoNu.setSelected(true);
        }
        txtAddress_1.setText(sv.getDiaChi());
        lblImg.setIcon(new ImageIcon("D:\\tinhpt26461\\Java3\\AssignmentTinh\\src\\Img\\" + sv.getHinh()));
        tblShow_1.setRowSelectionInterval(index, index);
    }

    public void showDetail2(GRADE sv) {
        newSv2();
        lblTen.setText(sv.getHoTen());
        txtMasv_2.setText(sv.getMaSv());
        txtTa.setText(String.valueOf(sv.getDiemTa()));
        txtTh.setText(String.valueOf(sv.getDiemTh()));
        txtTc.setText(String.valueOf(sv.getDiemTc()));
        lblDiemTB.setText(String.valueOf(sv.getDiemTb()));
        tblShow_2.setRowSelectionInterval(index, index);
    }

    public void clear() {
        txtMasv_1.setText("");
        txtHoten_1.setText("");
        txtEmail_1.setText("");
        txtSodt_1.setText("");
        txtAddress_1.setText("");
        lblImg.setIcon(null);
        lblImg.setText("IMG");

        lblTen.setText("");
        txtMasv_2.setText("");
        txtTa.setText("");
        txtTh.setText("");
        txtTc.setText("");
        lblDiemTB.setText("");
    }

    public void newSv1() {
        clear();
        txtMasv_1.setEnabled(true);
        txtHoten_1.setEnabled(true);
        txtEmail_1.setEnabled(true);
        txtSodt_1.setEnabled(true);
        txtAddress_1.setEnabled(true);
        txtMasv_1.requestFocus();
    }

    public void newSv2() {
        clear();
        txtMasv_2.setEnabled(true);
        txtTa.setEnabled(true);
        txtTh.setEnabled(true);
        txtTc.setEnabled(true);
        txtMasv_2.requestFocus();
    }

    public void save1() {
        index = tblShow_1.getSelectedRow();
        if (txtMasv_1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Nhập mã sv");
            txtMasv_1.requestFocus();
        } else {
            STUDENTS sv = new STUDENTS();
            StudentsDAO st = new StudentsDAO();
            sv.setMaSV(txtMasv_1.getText());
            sv.setHoTen(txtHoten_1.getText());
            sv.seteMail(txtEmail_1.getText());
            sv.setSoDT(txtSodt_1.getText());
            sv.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
            sv.setDiaChi(txtAddress_1.getText());
            sv.setHinh(strImg);
            list1.add(sv);
            st.insert(sv);
            fillTable1();
            clear();
        }
    }

    public void save2() {
        if (txtMasv_2.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Nhập mã sv");
            txtMasv_2.requestFocus();
        } else {
            GRADE sv = new GRADE();
            GradeDAO st = new GradeDAO();
            sv.setMaSv(txtMasv_2.getText());
            sv.setDiemTa(Float.parseFloat(txtTa.getText()));
            sv.setDiemTh(Float.parseFloat(txtTh.getText()));
            sv.setDiemTc(Float.parseFloat(txtTc.getText()));
            list2.add(sv);
            st.insert(sv);
            fillTable2();
            clear();
        }
    }

    public void update1() {
        index = tblShow_1.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên để sửa");
        } else {
            STUDENTS sv = new STUDENTS();
            StudentsDAO st = new StudentsDAO();
            sv.setHoTen(txtHoten_1.getText());
            sv.seteMail(txtEmail_1.getText());
            sv.setSoDT(txtSodt_1.getText());
            sv.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
            sv.setDiaChi(txtAddress_1.getText());
            sv.setHinh(strImg);
            sv.setMaSV(txtMasv_1.getText());
            list1.set(index, sv);
            st.update(sv);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            clear();
            fillTable1();
        }
    }

    public void update2() {
        index = tblShow_2.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên để sửa");
        } else {
            GRADE sv = new GRADE();
            GradeDAO st = new GradeDAO();
            sv.setDiemTa(Float.parseFloat(txtTa.getText()));
            sv.setDiemTh(Float.parseFloat(txtTh.getText()));
            sv.setDiemTc(Float.parseFloat(txtTc.getText()));
            sv.setMaSv(txtMasv_2.getText());
            list2.set(index, sv);
            st.update(sv);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            clear();
            fillTable2();
        }
    }

    public void delete1() {
        index = tblShow_1.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Không còn Sinh viên để xóa");
        } else {
            STUDENTS sv = new STUDENTS();
            StudentsDAO st = new StudentsDAO();
            sv.setMaSV(txtMasv_1.getText());
            list1.remove(sv);
            st.delete(sv);
            fillTable1();
            JOptionPane.showMessageDialog(null, "Xóa Sinh viên thành công");
            clear();
        }
    }

    public void delete2() {
        index = tblShow_2.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Không còn Sinh viên để xóa");
            txtMasv_2.requestFocus();
        } else {
            GRADE sv = new GRADE();
            GradeDAO st = new GradeDAO();
            sv.setMaSv(txtMasv_2.getText());
            list2.remove(sv);
            st.delete(sv);
            fillTable2();
            clear();
        }
    }

    public int searchSv(String sMa) {
        int found = -1;
        int i = 0;
        while (i < list2.size()) {
            if (list2.get(i).getMaSv().equalsIgnoreCase(sMa)) {
                found = i;
                break;
            }
            i++;
        }
        return found;

    }

    public String selectTen(String Masv) {
        String ten = "";
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select Hoten from STUDENTS st where st.MaSv like '" + Masv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("HoTen");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }

    public void sapxepTA() {
        list2.clear();
        model2.setRowCount(0);
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select top 3 ID,st.MASV,Hoten,Tienganh,Tinhoc,GDTC from STUDENTS st inner join GRADE gr on st.MASV = gr.MASV order by Tienganh desc";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                GRADE sv = new GRADE();
                sv.setID(rs.getInt("ID"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setMaSv(rs.getString("MaSV"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
                list2.add(sv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (GRADE sv : list2) {
            Vector row = new Vector();
            row.add(sv.getID());
            row.add(sv.getHoTen());
            row.add(sv.getMaSv());
            row.add(sv.getDiemTa());
            row.add(sv.getDiemTh());
            row.add(sv.getDiemTc());
            row.add(sv.getDiemTb());
            model2.addRow(row);
        }
        tblShow_2.setModel(model2);

    }

    public void sapxepTH() {
        list2.clear();
        model2.setRowCount(0);
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select top 3 ID,st.MASV,Hoten,Tienganh,Tinhoc,GDTC from STUDENTS st inner join GRADE gr on st.MASV = gr.MASV order by Tinhoc desc";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                GRADE sv = new GRADE();
                sv.setID(rs.getInt("ID"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setMaSv(rs.getString("MaSV"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
                list2.add(sv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (GRADE sv : list2) {
            Vector row = new Vector();
            row.add(sv.getID());
            row.add(sv.getHoTen());
            row.add(sv.getMaSv());
            row.add(sv.getDiemTa());
            row.add(sv.getDiemTh());
            row.add(sv.getDiemTc());
            row.add(sv.getDiemTb());
            model2.addRow(row);
        }
        tblShow_2.setModel(model2);
    }

    public void sapxepTC() {
        list2.clear();
        model2.setRowCount(0);
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select top 3 ID,st.MASV,Hoten,Tienganh,Tinhoc,GDTC from STUDENTS st inner join GRADE gr on st.MASV = gr.MASV order by GDTC desc";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                GRADE sv = new GRADE();
                sv.setID(rs.getInt("ID"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setMaSv(rs.getString("MaSV"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
                list2.add(sv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (GRADE sv : list2) {
            Vector row = new Vector();
            row.add(sv.getID());
            row.add(sv.getHoTen());
            row.add(sv.getMaSv());
            row.add(sv.getDiemTa());
            row.add(sv.getDiemTh());
            row.add(sv.getDiemTc());
            row.add(sv.getDiemTb());
            model2.addRow(row);
        }
        tblShow_2.setModel(model2);
    }

    public void sapxepTB() {
        list2.clear();
        model2.setRowCount(0);
        try (Connection con = KetNoiCSDL.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select top 3 ID,st.MASV,Hoten,Tienganh,Tinhoc,GDTC from STUDENTS st inner join GRADE gr on st.MASV = gr.MASV order by (Tienganh+Tinhoc+GDTC)/3 desc";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                GRADE sv = new GRADE();
                sv.setID(rs.getInt("ID"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setMaSv(rs.getString("MaSV"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
                list2.add(sv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (GRADE sv : list2) {
            Vector row = new Vector();
            row.add(sv.getID());
            row.add(sv.getHoTen());
            row.add(sv.getMaSv());
            row.add(sv.getDiemTa());
            row.add(sv.getDiemTh());
            row.add(sv.getDiemTc());
            row.add(sv.getDiemTb());
            model2.addRow(row);
        }
        tblShow_2.setModel(model2);
    }

    public void selectIteam() {
        String cboValue = (String) cboDiem.getSelectedItem();
        if (cboValue.equals("Điểm Tiếng Anh")) {
            sapxepTA();
        } else if (cboValue.equals("Điểm Tin Học")) {
            sapxepTH();
        } else if (cboValue.equals("Điểm GDTC")) {
            sapxepTC();
        } else if (cboValue.equals("Điểm Trung Bình")) {
            sapxepTB();
        } else {
            fillTable2();
        }
    }

    public void timkiem() {
        try (Connection con = KetNoiCSDL.openConnection()) {
            String sql = "select gr.ID,st.MASV,st.Hoten,gr.Tienganh,gr.Tinhoc,gr.GDTC \n"
                    + "from STUDENTS st inner join GRADE gr on st.MASV = gr.MASV \n"
                    + "where gr.Masv = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, txtSearch.getText());
            ResultSet rs = st.executeQuery();
            list2.clear();
            while (rs.next()) {
                GRADE sv = new GRADE();
                sv.setID(rs.getInt("ID"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setMaSv(rs.getString("MaSV"));
                sv.setDiemTa(rs.getFloat("TiengAnh"));
                sv.setDiemTh(rs.getFloat("TinHoc"));
                sv.setDiemTc(rs.getFloat("GDTC"));
                list2.add(sv);
            }
            model2.setRowCount(0);
            for (GRADE sv : list2) {
                Vector row = new Vector();
                row.add(sv.getID());
                row.add(sv.getHoTen());
                row.add(sv.getMaSv());
                row.add(sv.getDiemTa());
                row.add(sv.getDiemTh());
                row.add(sv.getDiemTc());
                row.add(sv.getDiemTb());
                model2.addRow(row);
            }
            tblShow_2.setModel(model2);
            txtSearch.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void role(){
        lbRole.setText("Cán bộ đào tạo");
    }
    
    public void role1(){
        lbRole.setText("Giảng viên");
    }
    
    public void role2(){
        lbRole.setText("Hiệu trưởng");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbDiem = new javax.swing.JLabel();
        lbSinhvien = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbSinhvien1 = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelTong = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelDiem = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblShow_2 = new javax.swing.JTable();
        lblImg1 = new javax.swing.JLabel();
        btnNew2 = new javax.swing.JButton();
        btnSave2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtMasv_2 = new javax.swing.JTextField();
        txtTa = new javax.swing.JTextField();
        txtTh = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTc = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnUpdate2 = new javax.swing.JButton();
        lblDiemTB = new javax.swing.JLabel();
        cboDiem = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        panelSinhvien = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMasv_1 = new javax.swing.JTextField();
        txtHoten_1 = new javax.swing.JTextField();
        txtSodt_1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress_1 = new javax.swing.JTextArea();
        txtEmail_1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        btnNew1 = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblShow_1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        panelMenu.setBackground(new java.awt.Color(153, 255, 255));
        panelMenu.setMaximumSize(new java.awt.Dimension(0, 0));
        panelMenu.setPreferredSize(new java.awt.Dimension(0, 0));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ASM JAVA3");

        lbHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbHome.setForeground(new java.awt.Color(0, 0, 0));
        lbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHome.setText("Trang chủ");
        lbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbHomeMouseEntered(evt);
            }
        });

        lbDiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDiem.setForeground(new java.awt.Color(0, 0, 0));
        lbDiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiem.setText("Quản lý điểm");
        lbDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDiemMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbDiemMouseReleased(evt);
            }
        });

        lbSinhvien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSinhvien.setForeground(new java.awt.Color(0, 0, 0));
        lbSinhvien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSinhvien.setText("Quản lý sinh viên");
        lbSinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSinhvienMouseClicked(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Giới thiệu");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Đăng xuất");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        lbSinhvien1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbSinhvien1.setForeground(new java.awt.Color(0, 0, 0));
        lbSinhvien1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSinhvien1.setText("Truy cập:");
        lbSinhvien1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSinhvien1MouseClicked(evt);
            }
        });

        lbRole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbRole.setForeground(new java.awt.Color(232, 41, 39));
        lbRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRoleMouseClicked(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(16, 16, 16))))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelMenuLayout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelMenuLayout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(lbSinhvien1))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbSinhvien)
                                .addGroup(panelMenuLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDiem)
                                        .addGroup(panelMenuLayout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(lbHome))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator3)
                    .addContainerGap()))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbHome)
                .addGap(42, 42, 42)
                .addComponent(lbDiem)
                .addGap(44, 44, 44)
                .addComponent(lbSinhvien)
                .addGap(33, 33, 33)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lbSinhvien1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                    .addContainerGap(456, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(100, 100, 100)))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/more.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        panelTong.setLayout(new java.awt.CardLayout());

        panelHome.setBackground(new java.awt.Color(0, 102, 102));
        panelHome.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Đây là ASM Java 3 của Phạm Thế Tình");

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        panelTong.add(panelHome, "card2");

        panelDiem.setBackground(new java.awt.Color(0, 102, 102));

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setForeground(new java.awt.Color(0, 0, 0));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/left.png"))); // NOI18N
        jButton13.setBorder(new javax.swing.border.MatteBorder(null));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setForeground(new java.awt.Color(0, 0, 0));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        jButton14.setBorder(new javax.swing.border.MatteBorder(null));

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setForeground(new java.awt.Color(0, 0, 0));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/right (1).png"))); // NOI18N
        jButton15.setBorder(new javax.swing.border.MatteBorder(null));

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setForeground(new java.awt.Color(0, 0, 0));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/right.png"))); // NOI18N
        jButton16.setBorder(new javax.swing.border.MatteBorder(null));

        tblShow_2.setBackground(new java.awt.Color(255, 255, 255));
        tblShow_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblShow_2.setForeground(new java.awt.Color(0, 0, 0));
        tblShow_2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblShow_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblShow_2MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblShow_2);

        lblImg1.setForeground(new java.awt.Color(255, 255, 255));
        lblImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg1.setText("Điểm TB:");
        lblImg1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnNew2.setBackground(new java.awt.Color(255, 255, 255));
        btnNew2.setForeground(new java.awt.Color(0, 0, 0));
        btnNew2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnNew2.setText("New");
        btnNew2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnNew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew2ActionPerformed(evt);
            }
        });

        btnSave2.setBackground(new java.awt.Color(255, 255, 255));
        btnSave2.setForeground(new java.awt.Color(0, 0, 0));
        btnSave2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save.png"))); // NOI18N
        btnSave2.setText("Save");
        btnSave2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave2ActionPerformed(evt);
            }
        });

        btnDelete2.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete2.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnDelete2.setText("Delete");
        btnDelete2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Họ tên:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mã SV:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tiếng Anh:");

        txtMasv_2.setBackground(new java.awt.Color(255, 255, 255));
        txtMasv_2.setForeground(new java.awt.Color(0, 0, 0));
        txtMasv_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMasv_2KeyPressed(evt);
            }
        });

        txtTa.setBackground(new java.awt.Color(255, 255, 255));
        txtTa.setForeground(new java.awt.Color(0, 0, 0));

        txtTh.setBackground(new java.awt.Color(255, 255, 255));
        txtTh.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tin Học:");

        txtTc.setBackground(new java.awt.Color(255, 255, 255));
        txtTc.setForeground(new java.awt.Color(0, 0, 0));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("GDTC:");

        lblTen.setForeground(new java.awt.Color(255, 255, 255));
        lblTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Search:");

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMasv_2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTa, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(txtTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMasv_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel20)
                        .addComponent(txtTh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnUpdate2.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate2.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnUpdate2.setText("Update");
        btnUpdate2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });

        lblDiemTB.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblDiemTB.setForeground(new java.awt.Color(255, 255, 255));
        lblDiemTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiemTB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        cboDiem.setBackground(new java.awt.Color(255, 255, 255));
        cboDiem.setForeground(new java.awt.Color(0, 0, 0));
        cboDiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đầy đủ", "Điểm Tiếng Anh", "Điểm Tin Học", "Điểm GDTC", "Điểm Trung Bình" }));
        cboDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiemActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Top 3:");

        javax.swing.GroupLayout panelDiemLayout = new javax.swing.GroupLayout(panelDiem);
        panelDiem.setLayout(panelDiemLayout);
        panelDiemLayout.setHorizontalGroup(
            panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiemLayout.createSequentialGroup()
                .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDiemLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDiemLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImg1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(lblDiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDiemLayout.createSequentialGroup()
                        .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDiemLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDiemLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDiemLayout.setVerticalGroup(
            panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiemLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDiemLayout.createSequentialGroup()
                        .addComponent(lblImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lblDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(panelDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTong.add(panelDiem, "card3");

        panelSinhvien.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)), "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Họ tên:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mã SV:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Số ĐT:");

        txtMasv_1.setBackground(new java.awt.Color(255, 255, 255));
        txtMasv_1.setForeground(new java.awt.Color(0, 0, 0));

        txtHoten_1.setBackground(new java.awt.Color(255, 255, 255));
        txtHoten_1.setForeground(new java.awt.Color(0, 0, 0));

        txtSodt_1.setBackground(new java.awt.Color(255, 255, 255));
        txtSodt_1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Giới tính:");

        rdoNam.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(rdoNam);
        rdoNam.setForeground(new java.awt.Color(255, 255, 255));
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        rdoNu.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(rdoNu);
        rdoNu.setForeground(new java.awt.Color(255, 255, 255));
        rdoNu.setText("Nữ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Địa chỉ:");

        txtAddress_1.setBackground(new java.awt.Color(255, 255, 255));
        txtAddress_1.setColumns(20);
        txtAddress_1.setForeground(new java.awt.Color(0, 0, 0));
        txtAddress_1.setRows(5);
        jScrollPane1.setViewportView(txtAddress_1);

        txtEmail_1.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail_1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMasv_1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtHoten_1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSodt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail_1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNam)
                        .addGap(26, 26, 26)
                        .addComponent(rdoNu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtMasv_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtHoten_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtSodt_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtEmail_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblImg.setForeground(new java.awt.Color(255, 255, 255));
        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg.setText("IMG");
        lblImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lblImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImgMouseClicked(evt);
            }
        });

        btnNew1.setBackground(new java.awt.Color(255, 255, 255));
        btnNew1.setForeground(new java.awt.Color(0, 0, 0));
        btnNew1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnNew1.setText("New");
        btnNew1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew1ActionPerformed(evt);
            }
        });

        btnSave1.setBackground(new java.awt.Color(255, 255, 255));
        btnSave1.setForeground(new java.awt.Color(0, 0, 0));
        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save.png"))); // NOI18N
        btnSave1.setText("Save");
        btnSave1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        btnDelete1.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete1.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnUpdate1.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate1.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnUpdate1.setText("Update");
        btnUpdate1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setForeground(new java.awt.Color(0, 0, 0));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/left.png"))); // NOI18N
        jButton9.setBorder(new javax.swing.border.MatteBorder(null));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        jButton10.setBorder(new javax.swing.border.MatteBorder(null));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setForeground(new java.awt.Color(0, 0, 0));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/right (1).png"))); // NOI18N
        jButton11.setBorder(new javax.swing.border.MatteBorder(null));

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/right.png"))); // NOI18N
        jButton12.setBorder(new javax.swing.border.MatteBorder(null));

        tblShow_1.setBackground(new java.awt.Color(255, 255, 255));
        tblShow_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblShow_1.setForeground(new java.awt.Color(0, 0, 0));
        tblShow_1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblShow_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblShow_1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblShow_1);

        javax.swing.GroupLayout panelSinhvienLayout = new javax.swing.GroupLayout(panelSinhvien);
        panelSinhvien.setLayout(panelSinhvienLayout);
        panelSinhvienLayout.setHorizontalGroup(
            panelSinhvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSinhvienLayout.createSequentialGroup()
                .addGroup(panelSinhvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSinhvienLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSinhvienLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelSinhvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSinhvienLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelSinhvienLayout.setVerticalGroup(
            panelSinhvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSinhvienLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelSinhvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSinhvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSinhvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelTong.add(panelSinhvien, "card4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 727, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(518, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 57, Short.MAX_VALUE)
                    .addComponent(panelTong, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        openMenuBar();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        closeMenuBar();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void lbSinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSinhvienMouseClicked
        panelHome.setVisible(false);
        panelDiem.setVisible(false);
        panelSinhvien.setVisible(true);
    }//GEN-LAST:event_lbSinhvienMouseClicked

    private void lbDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDiemMouseClicked
        panelHome.setVisible(false);
        panelSinhvien.setVisible(false);
        panelDiem.setVisible(true);
    }//GEN-LAST:event_lbDiemMouseClicked

    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked

        panelSinhvien.setVisible(false);
        panelDiem.setVisible(false);
        panelHome.setVisible(true);
    }//GEN-LAST:event_lbHomeMouseClicked

    private void lbDiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDiemMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbDiemMouseReleased

    private void lbHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseEntered

    }//GEN-LAST:event_lbHomeMouseEntered

    private void tblShow_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShow_2MousePressed
        index = tblShow_2.getSelectedRow();
        showDetail2(list2.get(index));
    }//GEN-LAST:event_tblShow_2MousePressed

    private void lblImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgMouseClicked
        try {
            JFileChooser jfc = new JFileChooser("D:\\tinhpt26461\\Java3\\AssignmentTinh\\src\\Img");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            strImg = file.getName();
            Image img = ImageIO.read(file);
            lblImg.setText("");
            int rong = lblImg.getWidth();
            int cao = lblImg.getHeight();
            lblImg.setIcon(new ImageIcon(img.getScaledInstance(rong, cao, 0)));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.toString());
        }
    }//GEN-LAST:event_lblImgMouseClicked

    private void tblShow_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShow_1MousePressed
        index = tblShow_1.getSelectedRow();
        showDetail1(list1.get(index));
    }//GEN-LAST:event_tblShow_1MousePressed

    private void txtMasv_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMasv_2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            lblTen.setText(selectTen(txtMasv_2.getText()));
        }
    }//GEN-LAST:event_txtMasv_2KeyPressed

    private void btnNew2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew2ActionPerformed
        newSv2();
        //sapxepTA();
    }//GEN-LAST:event_btnNew2ActionPerformed

    private void btnSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave2ActionPerformed
        save2();
    }//GEN-LAST:event_btnSave2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        delete2();
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        update2();
    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew1ActionPerformed
        newSv1();
    }//GEN-LAST:event_btnNew1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        save1();
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        delete1();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        update1();
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int key = JOptionPane.showConfirmDialog(null, "bạn có muốn đăng xuất không?", "đăng xuất", JOptionPane.YES_NO_OPTION);
        if (key == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            LoginForm login = new LoginForm();
            login.setVisible(true);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        String str = "ASM Java 3";
        str += "\nAuthor: Phạm Thế Tình";
        str += "\nLast Update: 3 Aug, 2023";
        JOptionPane.showMessageDialog(null, str, "Giới thiệu",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        String sMa = txtSearch.getText();
//        if (sMa.equals("")) {
//            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sv cần tìm");
//            txtSearch.requestFocus();
//        } else {
//            if (index >= -1) {
//                int k = searchSv(sMa);
//                if (k >= 0) {
//                    index = k;
//                    showDetail2(list2.get(k));
//                    txtSearch.setText("");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Không tìm thấy sv ");
//                    txtSearch.requestFocus();
//                }
//            }
//        }
        timkiem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiemActionPerformed
        selectIteam();
    }//GEN-LAST:event_cboDiemActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void lbSinhvien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSinhvien1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSinhvien1MouseClicked

    private void lbRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRoleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbRoleMouseClicked

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
            java.util.logging.Logger.getLogger(FormTong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTong.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnNew1;
    private javax.swing.JButton btnNew2;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSave2;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboDiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbDiem;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbSinhvien;
    private javax.swing.JLabel lbSinhvien1;
    private javax.swing.JLabel lblDiemTB;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblImg1;
    private javax.swing.JLabel lblTen;
    private javax.swing.JPanel panelDiem;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelSinhvien;
    private javax.swing.JPanel panelTong;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblShow_1;
    private javax.swing.JTable tblShow_2;
    private javax.swing.JTextArea txtAddress_1;
    private javax.swing.JTextField txtEmail_1;
    private javax.swing.JTextField txtHoten_1;
    private javax.swing.JTextField txtMasv_1;
    private javax.swing.JTextField txtMasv_2;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSodt_1;
    private javax.swing.JTextField txtTa;
    private javax.swing.JTextField txtTc;
    private javax.swing.JTextField txtTh;
    // End of variables declaration//GEN-END:variables
}
