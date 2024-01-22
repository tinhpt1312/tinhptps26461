package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.controller_qlsb;

public class FromDangKiSan extends JFrame{
	public JFrame jFrame;
	public JButton btnout;
	public FromDangKiSan() {
		jFrame = new JFrame();
		jFrame.setTitle("DangKiSanBong");
		jFrame.setSize(900, 700);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(null);
		btnout = new JButton("Đăng Xuất");
		btnout.setBounds(740, 610, 132, 40);
		btnout.setFont(new Font("Serif", Font.BOLD, 20));
		
		ActionListener ac = new controller_qlsb(this);
		btnout.addActionListener(ac);
		jFrame.add(btnout);
		jFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		FromDangKiSan f = new FromDangKiSan();
	}
}
