package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.FromDangKiSan;
import view.Login;

public class controller_qlsb extends JFrame implements ActionListener{
	private FromDangKiSan f;
	

	public controller_qlsb(FromDangKiSan f) {
		this.f = f;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String ev = e.getActionCommand();
		if(ev.equals("Đăng Xuất")) {
			this.dispose();
			Login l = new Login();
			l.setVisible(true);
		}
	}

}
