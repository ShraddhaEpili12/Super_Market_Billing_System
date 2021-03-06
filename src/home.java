import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class home extends JFrame implements ActionListener
{
	JLabel l1, l2, l3;
	JButton b1, b2;
	ImageIcon image;

	public void marque() {
		Thread head = new Thread() {
			public void run() {
				try {
					int a = 0, b = 40, c = 750, d = 50;
					for (;;) {
						if (a == 800) {
							a = -650;
						} else {
							a = a + 10;
						}
						l1.setBounds(a, b, c, d);
						sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		head.start();
	}

	public void marque1() {
		Thread head = new Thread() {
			public void run() {
				try {
					int a = 20, b = 120, c = 150, d = 30;
					for (;;) {
						if ((a == 700) && (b != 440)) {
							b = b + 20;
						} else if ((b == 440) && (a != 20)) {
							a = a - 20;
						} else if (b == 120) {
							a = a + 20;
						} else {
							b = b - 20;
						}

						l2.setBounds(a, b, c, d);
						sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		head.start();
	}

	home() {

		super("SuperMarket Billing System");

		l1 = new JLabel("Welcome To Supermarket Billing System");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		add(l1);
		l1.setBounds(40, 40, 750, 50);
		l1.setForeground(Color.WHITE);
		// marque();
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setForeground(Color.WHITE);
		setLayout(null);
		this.getContentPane().setBackground(Color.getHSBColor(154, 254,25));
		setResizable(false);

		b1 = new JButton("Admin Login");
		b1.setBounds(300, 200, 200, 50);
		add(b1);
		b1.setFont(new Font("Arial", Font.PLAIN, 20));
		b1.addActionListener(this);
		Image img1 = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		b1.setIcon(new ImageIcon(img1));
		
		b2 = new JButton("Cashier Login");
		b2.setBounds(300, 280, 200, 50);
		add(b2);
		b2.addActionListener(this);
		b2.setFont(new Font("Arial", Font.PLAIN, 20));
		Image img2 = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		b2.setIcon(new ImageIcon(img2));

		l3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/shop.jpg")).getImage();
		l3.setIcon(new ImageIcon(img));
		l3.setBounds(0,0,800,600);
		getContentPane().add(l3);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	public static void main(String[] args) {
		new home();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			dispose();
			new adminlogin();
		} else {
			dispose();
			new cashierlogin();
		}

	}

}