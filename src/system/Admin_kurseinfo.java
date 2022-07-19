package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Admin_kurseinfo extends JFrame {

	private JPanel contentPane;
	private JTable kursetable;
	private JTextField kursname;
	private JTextField lehrerin;
	private JTextField kontingent;
	private JTextField kursnummer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_kurseinfo frame = new Admin_kurseinfo();
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
	public Admin_kurseinfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 356, 432);
		contentPane.add(scrollPane);
		
		kursetable = new JTable();
		scrollPane.setViewportView(kursetable);
		kursetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"kursnummer", "klasse", "lehrerin", "kurskontingent", "kurspakett"
			}
		));
		kursetable.getColumnModel().getColumn(0).setPreferredWidth(68);
		kursetable.getColumnModel().getColumn(1).setPreferredWidth(51);
		kursetable.getColumnModel().getColumn(2).setPreferredWidth(65);
		kursetable.getColumnModel().getColumn(3).setPreferredWidth(77);
		
		JLabel lblNewLabel = new JLabel("Kursname:");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(403, 85, 106, 30);
		contentPane.add(lblNewLabel);
		
		kursname = new JTextField();
		kursname.setBounds(581, 89, 141, 30);
		contentPane.add(kursname);
		kursname.setColumns(10);
		
		JLabel lblLehrerin = new JLabel("Lehrerin:");
		lblLehrerin.setForeground(new Color(25, 25, 112));
		lblLehrerin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLehrerin.setBounds(403, 129, 106, 30);
		contentPane.add(lblLehrerin);
		
		JLabel lblKurskontengent = new JLabel("Kurskontingent:");
		lblKurskontengent.setForeground(new Color(25, 25, 112));
		lblKurskontengent.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKurskontengent.setBounds(403, 184, 151, 30);
		contentPane.add(lblKurskontengent);
		
		JLabel lblKurspakette = new JLabel("Kurspakette:");
		lblKurspakette.setForeground(new Color(25, 25, 112));
		lblKurspakette.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKurspakette.setBounds(403, 254, 151, 30);
		contentPane.add(lblKurspakette);
		
		JLabel lblGebaeude = new JLabel("Gebaeude:");
		lblGebaeude.setForeground(new Color(25, 25, 112));
		lblGebaeude.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGebaeude.setBounds(403, 317, 151, 30);
		contentPane.add(lblGebaeude);
		
		lehrerin = new JTextField();
		lehrerin.setColumns(10);
		lehrerin.setBounds(581, 133, 141, 30);
		contentPane.add(lehrerin);
		
		kontingent = new JTextField();
		kontingent.setColumns(10);
		kontingent.setBounds(581, 188, 140, 30);
		contentPane.add(kontingent);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Golden", "Silber", "Bronze"}));
		comboBox.setBounds(581, 255, 141, 30);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(25, 25, 112));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Gebaeude A", "Gebaeude B", "Atelier", "Hinterhof", "Vorgarten"}));
		comboBox_1.setBounds(581, 320, 141, 30);
		contentPane.add(comboBox_1);
		
		JButton add = new JButton("Neu Erstellen");
		add.setBackground(new Color(176, 224, 230));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");
					String query1= "insert into kurse(kursnummer,kursname, kurskontingent,lehrerin, kurspakette, gebaeude) "
							+ "values(?,?,?,?,?,?)";
					
					PreparedStatement pst= con.prepareStatement(query1);
					pst.setString(1, kursnummer.getText());
					pst.setString(2, kursname.getText());
					pst.setString(3, kontingent.getText());
					pst.setString(4, lehrerin.getText());
					
					String kurspakett;
					kurspakett  = comboBox.getSelectedItem().toString();
					pst.setString(5, kurspakett);
					
					String gebaeude;
					gebaeude = comboBox_1.getSelectedItem().toString();
					pst.setString(6, gebaeude);
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Erfolgreich hinzugefügt!");
					
				} catch (Exception exp) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, exp);
				}
			}
		});
		add.setForeground(new Color(25, 25, 112));
		add.setFont(new Font("Tahoma", Font.BOLD, 18));
		add.setBounds(376, 393, 178, 54);
		contentPane.add(add);
		
		JButton delete = new JButton("L\u00F6schen");
		delete.setBackground(new Color(176, 224, 230));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row  = kursetable.getSelectedRow();
				String selection  = kursetable.getModel().getValueAt(row,0).toString();
				String query = "delete from kurse where kursnummer="+selection;
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					PreparedStatement pst = con.prepareStatement(query);
					pst.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//visual delete
				DefaultTableModel tblModel = (DefaultTableModel)kursetable.getModel();
				if(kursetable.getSelectedRowCount()==1) {
					tblModel.removeRow(kursetable.getSelectedRow());
					
				}else {
					if(kursetable.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Es gibt keine Datei in der Tabelle!");
						
					}else {
						JOptionPane.showMessageDialog(null, "Bitte waehlen Sie eine Reihe!");
					}
				}
			}
		});
		delete.setForeground(new Color(25, 25, 112));
		delete.setFont(new Font("Tahoma", Font.BOLD, 18));
		delete.setBounds(575, 393, 178, 54);
		contentPane.add(delete);
		
		JButton aktualisieren = new JButton("Aktualisieren");
		aktualisieren.setBackground(new Color(176, 224, 230));
		aktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					Statement st = con.createStatement();
					String sql = "select * from kurse";
					
					ResultSet rs = st.executeQuery(sql);	
					
					//Clear old table
					DefaultTableModel dm = (DefaultTableModel)kursetable.getModel();
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
						DefaultTableModel tblModel =(DefaultTableModel)kursetable.getModel();
						
						tblModel.addRow(tbData);
					}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		aktualisieren.setForeground(new Color(25, 25, 112));
		aktualisieren.setFont(new Font("Tahoma", Font.BOLD, 18));
		aktualisieren.setBounds(102, 481, 178, 54);
		contentPane.add(aktualisieren);
		
		JButton reset = new JButton("Reset");
		reset.setBackground(new Color(176, 224, 230));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kursnummer.setText(" ");
				kursname.setText("");
				lehrerin.setText("");
				kontingent.setText("");
				
				
			}
		});
		reset.setForeground(new Color(25, 25, 112));
		reset.setFont(new Font("Tahoma", Font.BOLD, 18));
		reset.setBounds(480, 481, 178, 54);
		contentPane.add(reset);
		
		kursnummer = new JTextField();
		kursnummer.setColumns(10);
		kursnummer.setBounds(581, 36, 141, 30);
		contentPane.add(kursnummer);
		
		JLabel lblKursnummer = new JLabel("Kursnummer:");
		lblKursnummer.setForeground(new Color(25, 25, 112));
		lblKursnummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKursnummer.setBounds(403, 32, 129, 30);
		contentPane.add(lblKursnummer);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_home home = new Admin_home();
				home.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 6, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
