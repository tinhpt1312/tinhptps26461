/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import Lab2.User;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class User_Manager extends javax.swing.JFrame {

    /* Khai báo biến toàn cục */
    ArrayList<User> lUser = new ArrayList<>();
    DefaultTableModel model;
    int index = -1;

    public User_Manager() {
        initComponents();
        this.setTitle("User Manager");
        this.setLocationRelativeTo(null);
        lUser.add(new User("Tinh", "666", "admin"));
        lUser.add(new User("Long", "111", "user"));
        lUser.add(new User("Tho", "222", "user"));
        lUser.add(new User("Trinh", "333", "user"));
        /* Lấy model của Table lưu vào biến model */
        model = (DefaultTableModel) tblUser.getModel();
        /* Thiết lập in cột cho Table */
        String[] colNames = {"Username", "Password", "Role"};
        model.setColumnIdentifiers(colNames);
        tblUser.getTableHeader().setFont(new Font("Arial", 1, 30));
        fillTable();
    }

    public void fillTable() {
        /* Đổi dữ liệu từ List vào model của Table */
        /* Xóa các dòng cũ trong table */
        model.setRowCount(0);
        for (User u : lUser) {
            model.addRow(new Object[]{
                u.getUserName(),
                u.getPassWord(),
                u.getRole()
            });
        }
    }

    public void writeForm(User u) {
        txtUser.setText(u.getUserName());
        txtPass.setText(u.getPassWord());
        rdoUser.setSelected(u.getRole().equals("user"));
        rdoAdmin.setSelected(u.getRole().equals("admin"));
    }
    
    public void clearForm(){
        // Xóa trống form
        txtUser.setText("");
        txtPass.setText("");
        rdoUser.setSelected(true); // user là delfaut
        
        // Nhảy tới txtUser
        txtUser.requestFocus();
    }
    
    public User readForm(){
        // tạo 1 đối tượng User từ thông tin trên Form
        String uname = txtUser.getText();
        String pass = txtPass.getText();
        String role = (rdoUser.isSelected()?"user":"admin");
        User u = new User(uname, pass, role);
        return u;
    }
    
    public void addUser(){
        // Lấy User mà người dùng nhập mới vào ArrayList
        User u = readForm();
        lUser.add(u); // thêm vào list
        // Cho hiện lên Table
        fillTable();
    }
    
    public void updateUser(){
        User u = readForm();
        lUser.set(index, u);
        fillTable();
        
    }
    
    public void removeUser(){
        lUser.remove(index);
        fillTable();
        clearForm();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tpManager = new javax.swing.JTabbedPane();
        pList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        pEdit = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdoAdmin = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        rdoUser = new javax.swing.JRadioButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Manager");

        tpManager.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        pList.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pList.setLayout(null);

        tblUser.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUser.setName(""); // NOI18N
        tblUser.setRowHeight(31);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUserMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblUser);

        pList.add(jScrollPane2);
        jScrollPane2.setBounds(0, 20, 660, 290);

        tpManager.addTab(" List  ", pList);

        pEdit.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pEditPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setText("Password : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel4.setText("Role : ");

        buttonGroup1.add(rdoAdmin);
        rdoAdmin.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        rdoAdmin.setText("Admin");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("Username : ");

        buttonGroup1.add(rdoUser);
        rdoUser.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        rdoUser.setText("User");
        rdoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoUserActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        javax.swing.GroupLayout pEditLayout = new javax.swing.GroupLayout(pEdit);
        pEdit.setLayout(pEditLayout);
        pEditLayout.setHorizontalGroup(
            pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEditLayout.createSequentialGroup()
                .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEditLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pEditLayout.createSequentialGroup()
                                .addComponent(rdoUser)
                                .addGap(28, 28, 28)
                                .addComponent(rdoAdmin))
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pEditLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        pEditLayout.setVerticalGroup(
            pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEditLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(pEditLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtPass)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAdmin)
                    .addComponent(jLabel4)
                    .addComponent(rdoUser))
                .addGap(41, 41, 41)
                .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemove)
                        .addComponent(btnUpdate)
                        .addComponent(btnReset))
                    .addComponent(btnAdd))
                .addGap(33, 33, 33))
        );

        tpManager.addTab("  Edit ", pEdit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpManager)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(tpManager))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened


    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            addUser();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
            updateUser();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked

    }//GEN-LAST:event_tblUserMouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
            removeUser();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void pEditPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pEditPropertyChange

    }//GEN-LAST:event_pEditPropertyChange

    private void tblUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMousePressed
        /* Lấy dòng đang được chọn trên Table lưu vào biến index */
        index = tblUser.getSelectedRow();
        /* Ghi thông tin của user có vị trí index vào Form */
        writeForm(lUser.get(index));
    }//GEN-LAST:event_tblUserMousePressed

    private void rdoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoUserActionPerformed

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
            java.util.logging.Logger.getLogger(User_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pEdit;
    private javax.swing.JPanel pList;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoUser;
    private javax.swing.JTable tblUser;
    private javax.swing.JTabbedPane tpManager;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
