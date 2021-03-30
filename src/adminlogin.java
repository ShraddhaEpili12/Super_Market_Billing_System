import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class adminlogin extends JFrame implements ActionListener {

	JLabel l1, l2, l3,l4;
	JPasswordField p1;
	JTextField t1;
	JButton b1;

	adminlogin() {
		super("SuperMarket Billing System");
		setSize(500, 500);
		setLocationRelativeTo(null);
		//this.getContentPane().setBackground(Color.PINK);
		setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		
		l3 = new JLabel("Admin Login");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 40));
		l3.setBounds(150, 30, 500, 100);
		l3.setForeground(Color.WHITE);
		add(l3);

		l1 = new JLabel("Name");
		l1.setBounds(100, 150, 100, 30);
		l1.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 25));
		l1.setForeground(Color.WHITE);
		add(l1);

		t1 = new JTextField();
		t1.setBounds(250, 150, 150, 30);
		add(t1);

		l2 = new JLabel("Password");
		l2.setBounds(100, 200, 100, 30);
		l2.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 25));
		l2.setForeground(Color.WHITE);
		add(l2);

		p1 = new JPasswordField();
		p1.setBounds(250, 200, 150, 30);
		add(p1);

		b1 = new JButton("Login");
		b1.setBounds(200, 270, 100, 50);
		b1.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT, 20));
		add(b1);
		b1.addActionListener(this);
		setVisible(true);
		
		l4 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/admin.jpg")).getImage();
		l4.setIcon(new ImageIcon(img));
		l4.setBounds(0,0,500,900);
		getContentPane().add(l4);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String a = t1.getText();
		String b = p1.getText();
		String c = "admin";
		// System.out.println(c);

		if (a.equals(c) && b.equals(c)) {
			new admin();
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Login Invalid");
		}
	}
}
