import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

public class newproduct extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l6;
	JTextField t1, t2, t3, t4;
	JButton b1, b2, b3, b4, b5;
	JTable ta;
	JScrollPane sp;
	int cec;

	public void productid() {

		try {
			Connection cn = connection.mycon();
			Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select product_id from addnew order by product_id");
			rs.afterLast();

			if (rs.previous()) {
				cec = rs.getInt(1);
			} else {
				cec = 0;
			}
			cn.close();
			int cec1 = ++cec;
			t1.setText(Integer.toString(cec1));
		}

		catch (Exception e4) {
			JOptionPane.showMessageDialog(this, "Error");
		}
	}

	public void updatetable() {
		try {
			Connection cn = connection.mycon();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from addnew order by product_id");
			ta.setModel(DbUtils.resultSetToTableModel(rs));
			cn.close();
		} catch (Exception e4) {
			JOptionPane.showMessageDialog(this, "Error");
		}
	}

	newproduct() {
		super("SuperMarket Billing System");

		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l6 = new JLabel("Add New Product");
		l6.setFont(new Font("Times New Roman", Font.BOLD, 40));
		l6.setBounds(300, 30, 500, 100);
		add(l6);

		l1 = new JLabel("Product Id");
		l1.setBounds(50, 210, 100, 30);
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(l1);

		t1 = new JTextField();
		t1.setBounds(220, 210, 150, 30);
		add(t1);
		productid();

		l2 = new JLabel("Product Name");
		l2.setBounds(50, 260, 120, 30);
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(l2);

		t2 = new JTextField();
		t2.setBounds(220, 260, 150, 30);
		add(t2);

		l3 = new JLabel("Price");
		l3.setBounds(50, 310, 100, 30);
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(l3);

		t3 = new JTextField();
		t3.setBounds(220, 310, 150, 30);
		add(t3);

		l4 = new JLabel("Quantity");
		l4.setBounds(50, 360, 100, 30);
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(l4);

		t4 = new JTextField();
		t4.setBounds(220, 360, 150, 30);
		add(t4);

		b1 = new JButton("Add");
		b1.setBounds(100, 450, 150, 40);
		add(b1);
		b1.addActionListener(this);
		b1.setFont(new Font("Arial", Font.PLAIN, 20));
		Image img = new ImageIcon(this.getClass().getResource("/Button-Add-icon (1).png")).getImage();
		b1.setIcon(new ImageIcon(img));

		b2 = new JButton("Update");
		b2.setBounds(250, 450, 150, 40);
		add(b2);
		b2.addActionListener(this);
		b2.setFont(new Font("Arial", Font.PLAIN, 20));

		b3 = new JButton("Delete");
		b3.setBounds(400, 450, 150, 40);
		add(b3);
		b3.addActionListener(this);
		b3.setFont(new Font("Arial", Font.PLAIN, 20));
		Image img2 = new ImageIcon(this.getClass().getResource("/Button-Delete-icon.png")).getImage();
		b3.setIcon(new ImageIcon(img2));

		b4 = new JButton("New");
		b4.setBounds(700, 450, 150, 40);
		add(b4);
		b4.addActionListener(this);
		b4.setFont(new Font("Arial", Font.PLAIN, 20));
		// Image img1=new ImageIcon(this.getClass().getResource("/Refresh-icon
		// (1).png")).getImage();
		// b4.setIcon(new ImageIcon(img1));

		b5 = new JButton("Load");
		b5.setBounds(550, 450, 150, 40);
		add(b5);
		b5.addActionListener(this);
		b5.setFont(new Font("Arial", Font.PLAIN, 20));

		ta = new JTable();
		ta.setBounds(400, 160, 470, 280);
		add(ta);
		ta.setEnabled(false);
		ta.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 12));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) ta.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		ta.getTableHeader().setBackground(Color.LIGHT_GRAY);
		// ta.getTableHeader().setForeground(Color.WHITE);
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(240, 240, 240));

		JScrollPane sp = new JScrollPane(ta);
		sp.setBounds(400, 160, 470, 280);
		add(sp);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			String a = t1.getText();
			String b = t2.getText();
			String c = t3.getText();
			String d = t4.getText();

			try {
				Connection cn = connection.mycon();
				Statement st = cn.createStatement();
				st.executeUpdate("insert into addnew values('" + a + "','" + b + "','" + c + "','" + d + "')");
				cn.close();
				JOptionPane.showMessageDialog(this, "Insert Successfully");
			} catch (Exception e1) {
				System.out.println(e1);
				JOptionPane.showMessageDialog(this, "Insert Unsuccessful");
			}
			updatetable();
		}
		else if (e.getSource() == b2) {
			String a = t1.getText();
			String b = t2.getText();
			String c = t3.getText();
			String d = t4.getText();
			try {
				Connection cn = connection.mycon();
				Statement st = cn.createStatement();
				st.executeUpdate("update addnew set product_name='" + b + "',price='" + c + "',quantity='" + d
						+ "' where product_id='" + a + "'");
				cn.close();
				JOptionPane.showMessageDialog(this, "Update Successfully");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Update Unsuccessful");
			}
			updatetable();
		}
		else if (e.getSource() == b3) {

			String a = t1.getText();
			try {
				Connection cn = connection.mycon();
				Statement st = cn.createStatement();
				st.executeUpdate("delete from addnew where product_id='" + a + "' ");
				cn.close();
				JOptionPane.showMessageDialog(this, "Delete Successfully");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Deletion Unsuccessful");
			}
			updatetable();
		}
		else if (e.getSource() == b5) {
			updatetable();
		}
		else {
			productid();
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}

	}
}
