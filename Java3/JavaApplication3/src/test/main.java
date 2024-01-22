package test;

import javax.swing.UIManager;

import view.Login;

public class main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Login lg = new Login();
            lg.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
