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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
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
import java.awt.Font;
import java.awt.Color;

public class Admin_personalinfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField name;
	private JTextField vorname;
	private JTextField email;
	private JTextField username;
	private JTextField telefonnummer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_personalinfo frame = new Admin_personalinfo();
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
	public Admin_personalinfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 743, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idpersonal", "personalname", "personalvorname", "abteilung", "telefonnummer", "email", "username"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Personal ID:");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 290, 125, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblPersonalName = new JLabel("Personal Name:");
		lblPersonalName.setForeground(new Color(25, 25, 112));
		lblPersonalName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPersonalName.setBounds(20, 324, 147, 13);
		contentPane.add(lblPersonalName);
		
		JLabel lblPersonalVorname = new JLabel("Personal Vorname:");
		lblPersonalVorname.setForeground(new Color(25, 25, 112));
		lblPersonalVorname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPersonalVorname.setBounds(20, 347, 183, 28);
		contentPane.add(lblPersonalVorname);
		
		JLabel lblAbte = new JLabel("Abteilung:");
		lblAbte.setForeground(new Color(25, 25, 112));
		lblAbte.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAbte.setBounds(20, 392, 107, 19);
		contentPane.add(lblAbte);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(25, 25, 112));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(20, 458, 105, 19);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(25, 25, 112));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setBounds(20, 487, 125, 16);
		contentPane.add(lblUsername);
		
		id = new JTextField();
		id.setBounds(223, 290, 125, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(223, 324, 125, 19);
		contentPane.add(name);
		
		vorname = new JTextField();
		vorname.setBounds(223, 355, 125, 19);
		contentPane.add(vorname);
		vorname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(223, 458, 125, 19);
		contentPane.add(email);
		email.setColumns(10);
		
		username = new JTextField();
		username.setBounds(223, 489, 125, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lehrerschaft", "Buchhaltung", "Reinigungspersonal", "Sicherheitspersonal", "Verwaltungspersonal"}));
		comboBox.setBounds(223, 392, 125, 21);
		contentPane.add(comboBox);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		JButton add = new JButton("Neu Erstellen");
		add.setForeground(new Color(25, 25, 112));
		add.setBackground(new Color(176, 224, 230));
		add.setFont(new Font("Tahoma", Font.BOLD, 18));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");
					String query1= "insert into personal(idpersonal, personalname, personalvorname, abteilung, telefonnummer, email,username)"
							+ "values(?,?,?,?,?,?,?)";
					
					PreparedStatement pst= con.prepareStatement(query1);
					pst.setString(1, id.getText());
					pst.setString(2, name.getText());
					pst.setString(3, vorname.getText());
					String abteilung;
					abteilung = comboBox.getSelectedItem().toString();
					pst.setString(4, abteilung);
					pst.setString(5, telefonnummer.getText());
					pst.setString(6, email.getText());
					pst.setString(7, username.getText());
					
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Erfolgreich neu erstellt!");
					
				} catch (Exception exp) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, exp);
				}
			}
		});
		add.setBounds(457, 287, 184, 48);
		contentPane.add(add);
		
		JButton aktualisieren = new JButton("Aktualisieren");
		aktualisieren.setForeground(new Color(25, 25, 112));
		aktualisieren.setBackground(new Color(176, 224, 230));
		aktualisieren.setFont(new Font("Tahoma", Font.BOLD, 18));
		aktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					Statement st = con.createStatement();
					String sql = "select * from personal";
					
					ResultSet rs = st.executeQuery(sql);	
					
					//Clear old table
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged(); 
					
					while(rs.next()) {
						String idpersonal   = rs.getString("idpersonal");
						String personalname = rs.getString("personalname");
						String personalvorname = rs.getString("personalvorname");
						String abteilung = rs.getString("abteilung");
						String telefonnummer = rs.getString("telefonnummer");
						String email = rs.getString("email");
						String username = rs.getString("username");

						
						String tbData[]= {idpersonal, personalname, personalvorname, abteilung, telefonnummer, email, username};
						DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
					}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		aktualisieren.setBounds(457, 355, 183, 47);
		contentPane.add(aktualisieren);
		
		JButton delete = new JButton("L\u00F6schen");
		delete.setForeground(new Color(25, 25, 112));
		delete.setBackground(new Color(176, 224, 230));
		delete.setFont(new Font("Tahoma", Font.BOLD, 18));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row  =table.getSelectedRow();
				String selection  = table.getModel().getValueAt(row,0).toString();
				String query = "delete from personal where idpersonal="+selection;
				
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
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				if(table.getSelectedRowCount()==1) {
					tblModel.removeRow(table.getSelectedRow());
					
				}else {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Es gibt keine Datei in der Tabelle!");
						
					}else {
						JOptionPane.showMessageDialog(null, "Bitte waehlen Sie eine Reihe!");
					}
				}
				
			}
		});
		delete.setBounds(457, 412, 184, 48);
		contentPane.add(delete);
		
		JButton reset = new JButton("Reset");
		reset.setForeground(new Color(25, 25, 112));
		reset.setFont(new Font("Tahoma", Font.BOLD, 18));
		reset.setBackground(new Color(176, 224, 230));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText(" ");
				name.setText("");
				vorname.setText("");
				telefonnummer.setText("");
				username.setText("");	
				email.setText("");
			}
		});
		reset.setBounds(457, 474, 184, 48);
		contentPane.add(reset);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
		lblTelefonnummer.setForeground(new Color(25, 25, 112));
		lblTelefonnummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelefonnummer.setBounds(20, 421, 173, 28);
		contentPane.add(lblTelefonnummer);
		
		telefonnummer = new JTextField();
		telefonnummer.setColumns(10);
		telefonnummer.setBounds(223, 423, 125, 19);
		contentPane.add(telefonnummer);
		
		JButton back = new JButton("< Back");
		back.setBackground(new Color(176, 224, 230));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_home home = new Admin_home();
				home.show();
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 14));
		back.setBounds(10, 10, 85, 21);
		contentPane.add(back);
		
		
	}

}
