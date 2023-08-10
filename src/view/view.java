package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.ListDb;
import db.User;
import db.WorkDb;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class view extends JFrame {

	private JPanel contentPane;
	static String userName = null;
	static String tel = null;
	static ListDb ldb = new ListDb();
	static WorkDb wdb = new WorkDb();
	static User user;
	static Connection con = null;
	static ResultSet resultSet = null;
	private JTable table;
	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */
	static Object a[][] = new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },
			{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
			{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
			{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
			{ null, null }, { null, null }, };
	private JScrollPane scrollPane;
	private JTextPane textPane;
	private JButton btnNewButton_1;
	private JTextPane textPane_2;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblTel;
	private JLabel lblNewLabel_4;

	public static void main(String[] args) throws SQLException {
		try {
			con = ldb.getCon();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ldb.list();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view view = new view();
					view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public view() {
		window w = new window();
		wdb.select(con, a);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 69, 420, 160);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(a, new String[] { "userName", "tel" }));

		textPane = new JTextPane();
		textPane.setBounds(183, 245, 120, 24);
		contentPane.add(textPane);
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(328, 242, 63, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				Object a[][] = new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, };
				String userName = textPane.getText();
				user = new User(userName, tel);
				try {
					resultSet = wdb.getUsers(user, con);
					while (resultSet.next()) {
						String username = resultSet.getString("userName");
						String tel = resultSet.getString("tel");
						a[i][0] = username;
						a[i][1] = tel;
						i++;
					}
					table.setModel(new DefaultTableModel(a, new String[] { "userName", "tel" }));
					w.window1();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		textPane_2 = new JTextPane();
		textPane_2.setBounds(183, 282, 120, 24);
		contentPane.add(textPane_2);
		btnNewButton_1 = new JButton("添加");
		btnNewButton_1.setBounds(328, 279, 63, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object a[][] = new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, };
				int or = 2;
				userName = textPane.getText();
				tel = textPane_2.getText();
				user = new User(userName, tel);
				try {
					or = wdb.add(user, con);
					if (or == 1) {
						w.window2();
					}
					if (or == 0) {
						w.window3();
					}
					wdb.select(con, a);
					table.setModel(new DefaultTableModel(a, new String[] { "userName", "tel" }));
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBounds(412, 279, 63, 27);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object a[][] = new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, };
				int or = 2;
				userName = textPane.getText();
				user = new User(userName, tel);
				try {
					or = wdb.delete(user, con);
					if (or == 1) {
						w.window4();
					}
					if (or == 0) {
						w.window5();
					}
					wdb.select(con, a);
					table.setModel(new DefaultTableModel(a, new String[] { "userName", "tel" }));
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("修改");
		btnNewButton_3.setBounds(412, 242, 63, 27);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object a[][] = new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, };
				int or = 1;
				userName = textPane.getText();
				tel = textPane_2.getText();
				user = new User(userName, tel);
				try {
					or = wdb.modify(user, con);
					w.window6();
					if (or == 0) {
						w.window7();
					} else {
						w.window6();
					}
					wdb.select(con, a);
					table.setModel(new DefaultTableModel(a, new String[] { "userName", "tel" }));
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(btnNewButton_3);

		lblNewLabel = new JLabel("电话簿");
		lblNewLabel.setBounds(283, 32, 60, 24);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("userName:");
		lblNewLabel_1.setBounds(104, 251, 72, 18);
		contentPane.add(lblNewLabel_1);

		lblTel = new JLabel("tel:");
		lblTel.setBounds(148, 288, 32, 18);
		contentPane.add(lblTel);
		
		JLabel lblNewLabel_2 = new JLabel("查询时，只需要输入userName！");
		lblNewLabel_2.setBounds(253, 322, 214, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("删除时，输入tel会导致删除错误！");
		lblNewLabel_3.setBounds(254, 342, 234, 18);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("温馨提示：");
		lblNewLabel_4.setBounds(174, 330, 75, 18);
		contentPane.add(lblNewLabel_4);
	}
}
