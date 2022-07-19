package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Personal_kurse extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal_kurse frame = new Personal_kurse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Personal_kurse() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 743, 325);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"kursnummer", "lehrerin", "kurskontigent", "kurspakette", "gebaeude"
			}
		));
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personal_home home = new Personal_home();
				home.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aktualisieren");
		btnNewButton_1.setForeground(new Color(25, 25, 112));
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					Statement st = con.createStatement();
					String sql = "select * from kurse";
					
					ResultSet rs = st.executeQuery(sql);	
					
					//Clear old table
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged(); 
					
					while(rs.next()) {
						String kursnummer   = rs.getString("kursnummer");
						String kursname = rs.getString("kursname");
						String lehrerin = rs.getString("lehrerin");
						String kurskontingent = rs.getString("kurskontingent");
						String kurspakette = rs.getString("kurspakette");
						String gebaeude = rs.getString("gebaeude");
						
						
						String tbData[]= {kursnummer, kursname, lehrerin, kurskontingent, kurspakette, gebaeude};
						DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
					}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(278, 424, 178, 56);
		contentPane.add(btnNewButton_1);
	}

}
