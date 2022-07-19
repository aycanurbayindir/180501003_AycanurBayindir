package system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Personal_suche extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nachname;
	private JTextField vorname;
	private JTextField geschlecht;
	private JTextField geburtsdatum;
	private JTextField kursnummer;
	private JTextField elternname;
	private JTextField elternid;
	private JTextField kurspakett_entry;
	private JTextField lehrerin;
	private JTextField kindersearch;
	private JTextField ideltern;
	private JTextField nameeltern;
	private JTextField teleltern;
	private JTextField emaileltern;
	private JTextField kurspaketteltern;
	private JTextField zahlungssitiationeltern;
	private JTextField kinderideltern;
	private JTextField elternsearch;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal_suche frame = new Personal_suche();
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
	public Personal_suche() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 34, 743, 501);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 238));
		tabbedPane.addTab("Kinder Suche", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Suche nach Kinder ID");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 9, 186, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(211, 17, 39, 20);
		panel.add(lblNewLabel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idkinder", "nachname", "vorname", "geschlecht", "geburtsdatum", "lehrerin", "kurspakett", "ideltern", "eltern_name", "kursnummer"
			}
		));
		
		JButton aktualisieren = new JButton("Aktualisieren");
		aktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					Statement st = con.createStatement();
					String displayquery = "select * from kinder";
					
					ResultSet rs = st.executeQuery(displayquery);	
					
					//Clear old table
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged(); 
					
					while(rs.next()) {
						String idkinder  = rs.getString("idkinder");
						String nachname= rs.getString("nachname");
						String vorname = rs.getString("vorname");
						String geschlecht = rs.getString("geschlecht");
						String geburtsdatum = rs.getString("geburtsdatum");
						String lehrerin = rs.getString("lehrerin");
						String kurspakett = rs.getString("kurspakett");
						String eltern_name = rs.getString("eltern_name");
						String ideltern = rs.getString("ideltern");
						String kursnummer = rs.getString("kursnummer");
						

						
						String tbData[]= {idkinder,nachname, vorname, geschlecht, geburtsdatum, lehrerin, kurspakett, ideltern,eltern_name,  kursnummer};
						DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
					}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		aktualisieren.setForeground(new Color(25, 25, 112));
		aktualisieren.setFont(new Font("Tahoma", Font.BOLD, 16));
		aktualisieren.setBackground(new Color(176, 224, 230));
		aktualisieren.setBounds(294, 194, 149, 33);
		panel.add(aktualisieren);
		
		JLabel lblNewLabel_3 = new JLabel("Kinder ID:");
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(22, 247, 100, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Kinder Nachname:");
		lblNewLabel_3_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(22, 298, 155, 13);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Kinder Vorname:");
		lblNewLabel_3_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_1.setBounds(22, 348, 155, 13);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Geschlecht:");
		lblNewLabel_3_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_1_1.setBounds(22, 393, 155, 13);
		panel.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Geburtsdatum:");
		lblNewLabel_3_1_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_1_1_1.setBounds(22, 440, 155, 13);
		panel.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Lehrerin:");
		lblNewLabel_3_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(408, 247, 100, 13);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Kurspakett:");
		lblNewLabel_3_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(408, 298, 100, 13);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Eltern ID:");
		lblNewLabel_3_4.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_4.setBounds(408, 348, 100, 13);
		panel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Eltern Name:");
		lblNewLabel_3_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_5.setBounds(408, 393, 114, 13);
		panel.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("Kursnummer:");
		lblNewLabel_3_6.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_6.setBounds(408, 440, 114, 13);
		panel.add(lblNewLabel_3_6);
		
		JButton suche = new JButton("Suche");
		suche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");
					
						
					
					String suchequery = "select * from kinder where idkinder=?";
					PreparedStatement suche_pst = con.prepareStatement(suchequery);
					suche_pst.setString(1, kindersearch.getText());
					
					
					ResultSet rs = suche_pst.executeQuery();
					
					if(rs.next()) {
						String idkinder = rs.getString("idkinder");
						id.setText(idkinder);
						
						String nachnamekinder = rs.getString("nachname");
						nachname.setText(nachnamekinder);
						
						String vornamekinder = rs.getString("vorname");
						vorname.setText(vornamekinder);
						
						String geschlechtkinder = rs.getString("geschlecht");
						geschlecht.setText(geschlechtkinder);
						
						String geburtsdatumkinder = rs.getString("geburtsdatum");
						geburtsdatum.setText(geburtsdatumkinder);
						
						String lehrerinkinder = rs.getString("lehrerin");
						lehrerin.setText(lehrerinkinder);
						
						String kurspakettkinder = rs.getString("kurspakett");
						kurspakett_entry.setText(kurspakettkinder);
						
						String elternidkinder = rs.getString("ideltern");
						elternid.setText(elternidkinder);
						
						String elternnamekinder = rs.getString("eltern_name");
						elternname.setText(elternnamekinder);
						
						String kursnummerkinder = rs.getString("kursnummer");
						kursnummer.setText(kursnummerkinder);
					
					}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		suche.setBackground(new Color(176, 224, 230));
		suche.setForeground(new Color(25, 25, 112));
		suche.setFont(new Font("Tahoma", Font.BOLD, 16));
		suche.setBounds(508, 12, 107, 33);
		panel.add(suche);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(179, 245, 155, 20);
		panel.add(id);
		id.setColumns(10);
		
		nachname = new JTextField();
		nachname.setEditable(false);
		nachname.setColumns(10);
		nachname.setBounds(179, 297, 155, 20);
		panel.add(nachname);
		
		vorname = new JTextField();
		vorname.setEditable(false);
		vorname.setColumns(10);
		vorname.setBounds(179, 341, 155, 20);
		panel.add(vorname);
		
		geschlecht = new JTextField();
		geschlecht.setEditable(false);
		geschlecht.setColumns(10);
		geschlecht.setBounds(179, 392, 155, 20);
		panel.add(geschlecht);
		
		geburtsdatum = new JTextField();
		geburtsdatum.setEditable(false);
		geburtsdatum.setColumns(10);
		geburtsdatum.setBounds(179, 439, 155, 20);
		panel.add(geburtsdatum);
		
		kursnummer = new JTextField();
		kursnummer.setEditable(false);
		kursnummer.setColumns(10);
		kursnummer.setBounds(528, 439, 155, 20);
		panel.add(kursnummer);
		
		elternname = new JTextField();
		elternname.setEditable(false);
		elternname.setColumns(10);
		elternname.setBounds(528, 392, 155, 20);
		panel.add(elternname);
		
		elternid = new JTextField();
		elternid.setEditable(false);
		elternid.setColumns(10);
		elternid.setBounds(528, 347, 155, 20);
		panel.add(elternid);
		
		kurspakett_entry = new JTextField();
		kurspakett_entry.setEditable(false);
		kurspakett_entry.setColumns(10);
		kurspakett_entry.setBounds(528, 297, 155, 20);
		panel.add(kurspakett_entry);
		
		lehrerin = new JTextField();
		lehrerin.setEditable(false);
		lehrerin.setColumns(10);
		lehrerin.setBounds(528, 246, 155, 20);
		panel.add(lehrerin);
		
		kindersearch = new JTextField();
		kindersearch.setBounds(235, 21, 164, 19);
		panel.add(kindersearch);
		kindersearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 53, 695, 135);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idkinder", "nachname", "vorname", "geschlecht", "geburtsdatum", "lehrerin", "kurspakett", "ideltern", "eltern_name", "kursnummer"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 218, 185));
		tabbedPane.addTab("Eltern Suche", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Suche nach Eltern ID");
		lblNewLabel_2.setBounds(22, 10, 207, 30);
		lblNewLabel_2.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel(":");
		lblNewLabel_1_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(205, 18, 28, 13);
		panel_1.add(lblNewLabel_1_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ideltern", "elternname", "telefonnummer", "email", "kurspakett", "zahlungssitiation", "kinder"
			}
		));
		
		JButton aktualisieren_1 = new JButton("Aktualisieren");
		aktualisieren_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					Statement st = con.createStatement();
					String displayquery_2 = "select * from eltern";
				
					
					ResultSet rs = st.executeQuery(displayquery_2);	
					
					//Clear old table
					DefaultTableModel dm1 = (DefaultTableModel)table_1.getModel();
					dm1.getDataVector().removeAllElements();
					dm1.fireTableDataChanged(); 
					
					while(rs.next()) {
						String ideltern  = rs.getString("ideltern");
						String nameeltern= rs.getString("elternname");
						String telefonnummer = rs.getString("telefonnummer");
						String emaileltern = rs.getString("email");
						String kurspakett = rs.getString("kurspakett");
						String zahlungssitiationeltern = rs.getString("zahlungssitiation");
						String kinder = rs.getString("kinder");
						
						

						
						String tbData1[]= {ideltern, nameeltern, telefonnummer, emaileltern, kurspakett, zahlungssitiationeltern, kinder};
						DefaultTableModel tblModel2 =(DefaultTableModel)table_1.getModel();
						
						tblModel2.addRow(tbData1);
					}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		aktualisieren_1.setForeground(new Color(25, 25, 112));
		aktualisieren_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		aktualisieren_1.setBackground(new Color(176, 224, 230));
		aktualisieren_1.setBounds(285, 207, 149, 33);
		panel_1.add(aktualisieren_1);
		
		JLabel lblNewLabel_3_7 = new JLabel("Eltern ID:");
		lblNewLabel_3_7.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_7.setBounds(38, 282, 100, 13);
		panel_1.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("Elternname:");
		lblNewLabel_3_8.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_8.setBounds(38, 328, 126, 30);
		panel_1.add(lblNewLabel_3_8);
		
		JLabel lblNewLabel_3_9 = new JLabel("Telefonnummer:");
		lblNewLabel_3_9.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_9.setBounds(38, 368, 163, 40);
		panel_1.add(lblNewLabel_3_9);
		
		JLabel lblNewLabel_3_10 = new JLabel("Email:");
		lblNewLabel_3_10.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_10.setBounds(38, 429, 100, 13);
		panel_1.add(lblNewLabel_3_10);
		
		JLabel lblNewLabel_3_11 = new JLabel("Kurspakett:");
		lblNewLabel_3_11.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_11.setBounds(391, 268, 135, 40);
		panel_1.add(lblNewLabel_3_11);
		
		JLabel txt = new JLabel("Zahlungssitiation:");
		txt.setForeground(new Color(25, 25, 112));
		txt.setFont(new Font("Tahoma", Font.BOLD, 18));
		txt.setBounds(391, 337, 172, 23);
		panel_1.add(txt);
		
		JLabel lblNewLabel_3_13 = new JLabel("Kinder ID:");
		lblNewLabel_3_13.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_13.setBounds(391, 394, 100, 30);
		panel_1.add(lblNewLabel_3_13);
		
				
		JButton btnNewButton_1 = new JButton("Suche");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");						
					String suchequery = "select * from eltern where ideltern=?";
					PreparedStatement suche2_pst = con.prepareStatement(suchequery);
					suche2_pst.setString(1, elternsearch.getText());
					ResultSet rs2 = suche2_pst.executeQuery();
					
					if(rs2.next()) {
						String id_eltern = rs2.getString("ideltern");
						ideltern.setText(id_eltern);
						
						String name_eltern = rs2.getString("elternname");
						nameeltern.setText(name_eltern);
						
						String telefon_eltern = rs2.getString("telefonnummer");
						teleltern.setText(telefon_eltern);
						
						String email_eltern = rs2.getString("email");
						emaileltern.setText(email_eltern);
						
						String kurspakett_eltern = rs2.getString("kurspakett");
						kurspaketteltern.setText(kurspakett_eltern);
						
						String zahlung = rs2.getString("zahlungssitiation");
						zahlungssitiationeltern.setText(zahlung);
						
						String kinderid_eltern = rs2.getString("kinder");
						kinderideltern.setText(kinderid_eltern);
					
					}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(25, 25, 112));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.setBounds(509, 5, 107, 40);
		panel_1.add(btnNewButton_1);
		
		ideltern = new JTextField();
		ideltern.setEditable(false);
		ideltern.setBounds(206, 282, 135, 19);
		panel_1.add(ideltern);
		ideltern.setColumns(10);
		
		nameeltern = new JTextField();
		nameeltern.setEditable(false);
		nameeltern.setColumns(10);
		nameeltern.setBounds(206, 337, 135, 19);
		panel_1.add(nameeltern);
		
		teleltern = new JTextField();
		teleltern.setEditable(false);
		teleltern.setColumns(10);
		teleltern.setBounds(206, 382, 135, 19);
		panel_1.add(teleltern);
		
		emaileltern = new JTextField();
		emaileltern.setEditable(false);
		emaileltern.setColumns(10);
		emaileltern.setBounds(206, 423, 135, 19);
		panel_1.add(emaileltern);
		
		kurspaketteltern = new JTextField();
		kurspaketteltern.setEditable(false);
		kurspaketteltern.setColumns(10);
		kurspaketteltern.setBounds(576, 282, 135, 19);
		panel_1.add(kurspaketteltern);
		
		zahlungssitiationeltern = new JTextField();
		zahlungssitiationeltern.setEditable(false);
		zahlungssitiationeltern.setColumns(10);
		zahlungssitiationeltern.setBounds(576, 337, 135, 19);
		panel_1.add(zahlungssitiationeltern);
		
		kinderideltern = new JTextField();
		kinderideltern.setEditable(false);
		kinderideltern.setColumns(10);
		kinderideltern.setBounds(576, 403, 135, 19);
		panel_1.add(kinderideltern);
		
		elternsearch = new JTextField();
		elternsearch.setBounds(226, 18, 155, 19);
		panel_1.add(elternsearch);
		elternsearch.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 54, 718, 143);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ideltern", "elternname", "telefonnummer", "email", "kurspakett", "zahlungssitiation", "kinder"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personal_home home = new Personal_home();
				home.show();
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 3, 100, 28);
		contentPane.add(btnNewButton);
	}
}
