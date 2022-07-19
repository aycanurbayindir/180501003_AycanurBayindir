package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class registiration extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField kindernachname;
	private JTextField kindervorname;
	private JTextField elternname;
	private JTextField gd;
	private JTextField elternid;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField telefon;
	private JTextField email;
	
	String geschlecht;
	String kurspakett;
	String lehrerin;
	String kursnum;
	String zahlung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registiration frame = new registiration();
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
	public registiration() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1207, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 1173, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idkinder", "nachname", "vorname", "geschlecht", "geburtsdatum", "lehrerin", "kurspakett", "ideltern", "eltern_name", "kursnummer"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 238));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), new Color(255, 175, 175), Color.PINK, Color.PINK));
		panel.setBounds(10, 316, 1173, 421);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kinder ID:");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(39, 27, 100, 13);
		panel.add(lblNewLabel);
		
		JLabel lblKinderNachname = new JLabel("Kinder Nachname:");
		lblKinderNachname.setForeground(new Color(25, 25, 112));
		lblKinderNachname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKinderNachname.setBounds(39, 78, 182, 13);
		panel.add(lblKinderNachname);
		
		JLabel lblKinderVorname = new JLabel("Kinder Vorname:");
		lblKinderVorname.setForeground(new Color(25, 25, 112));
		lblKinderVorname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKinderVorname.setBounds(39, 129, 182, 13);
		panel.add(lblKinderVorname);
		
		JLabel lblKinderGeschlecht = new JLabel("Kinder Geschlecht:");
		lblKinderGeschlecht.setForeground(new Color(25, 25, 112));
		lblKinderGeschlecht.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKinderGeschlecht.setBounds(39, 188, 182, 13);
		panel.add(lblKinderGeschlecht);
		
		JLabel lblKinderGeburtsdatum = new JLabel("Kinder Geburtsdatum:");
		lblKinderGeburtsdatum.setForeground(new Color(25, 25, 112));
		lblKinderGeburtsdatum.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKinderGeburtsdatum.setBounds(39, 242, 214, 13);
		panel.add(lblKinderGeburtsdatum);
		
		JLabel lblLehrerin = new JLabel("Lehrerin:");
		lblLehrerin.setForeground(new Color(25, 25, 112));
		lblLehrerin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLehrerin.setBounds(39, 293, 100, 13);
		panel.add(lblLehrerin);
		
		JLabel lblElternId = new JLabel("Eltern ID:");
		lblElternId.setForeground(new Color(25, 25, 112));
		lblElternId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblElternId.setBounds(459, 27, 100, 13);
		panel.add(lblElternId);
		
		JLabel lblElternName = new JLabel("Eltern Name:");
		lblElternName.setForeground(new Color(25, 25, 112));
		lblElternName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblElternName.setBounds(459, 78, 132, 13);
		panel.add(lblElternName);
		
		JLabel lblKursnummer = new JLabel("Kursnummer:");
		lblKursnummer.setForeground(new Color(25, 25, 112));
		lblKursnummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKursnummer.setBounds(39, 344, 145, 13);
		panel.add(lblKursnummer);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
		lblTelefonnummer.setForeground(new Color(25, 25, 112));
		lblTelefonnummer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelefonnummer.setBounds(459, 129, 159, 13);
		panel.add(lblTelefonnummer);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(25, 25, 112));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(459, 183, 100, 22);
		panel.add(lblEmail);
		
		JLabel lblZahlungssitiation = new JLabel("Zahlungssitiation:");
		lblZahlungssitiation.setForeground(new Color(25, 25, 112));
		lblZahlungssitiation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblZahlungssitiation.setBounds(459, 314, 182, 22);
		panel.add(lblZahlungssitiation);
		
		JLabel lblKurspakett = new JLabel("Kurspakett:");
		lblKurspakett.setForeground(new Color(25, 25, 112));
		lblKurspakett.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKurspakett.setBounds(459, 242, 127, 22);
		panel.add(lblKurspakett);
		
		id = new JTextField();
		id.setBounds(247, 24, 145, 25);
		panel.add(id);
		id.setColumns(10);
		
		kindernachname = new JTextField();
		kindernachname.setColumns(10);
		kindernachname.setBounds(247, 75, 145, 25);
		panel.add(kindernachname);
		
		kindervorname = new JTextField();
		kindervorname.setColumns(10);
		kindervorname.setBounds(247, 123, 145, 25);
		panel.add(kindervorname);
		
		elternname = new JTextField();
		elternname.setColumns(10);
		elternname.setBounds(638, 75, 145, 25);
		panel.add(elternname);
		
		gd = new JTextField();
		gd.setColumns(10);
		gd.setBounds(247, 239, 145, 25);
		panel.add(gd);
		
		elternid = new JTextField();
		elternid.setColumns(10);
		elternid.setBounds(638, 24, 145, 25);
		panel.add(elternid);
		
		JComboBox lehrerin_box = new JComboBox();
		lehrerin_box.setBackground(new Color(255, 255, 255));
		lehrerin_box.setForeground(new Color(105, 105, 105));
		lehrerin_box.setFont(new Font("Tahoma", Font.BOLD, 16));
		lehrerin_box.setModel(new DefaultComboBoxModel(new String[] {"Frau Koehler", "Frau Meyer", "Frau Lorenz", "Frau Kraus", "Frau Engel"}));
		lehrerin_box.setBounds(247, 288, 145, 25);
		panel.add(lehrerin_box);
		
		JRadioButton Junge = new JRadioButton("Junge");
		buttonGroup.add(Junge);
		Junge.setBackground(new Color(255, 245, 238));
		Junge.setForeground(new Color(25, 25, 112));
		Junge.setFont(new Font("Tahoma", Font.BOLD, 14));
		Junge.setBounds(247, 166, 103, 21);
		panel.add(Junge);
		
		JRadioButton Maedchen = new JRadioButton("Maedchen");
		buttonGroup.add(Maedchen);
		Maedchen.setForeground(new Color(25, 25, 112));
		Maedchen.setFont(new Font("Tahoma", Font.BOLD, 14));
		Maedchen.setBackground(new Color(255, 245, 238));
		Maedchen.setBounds(247, 199, 103, 21);
		panel.add(Maedchen);
		
		JComboBox kursnummer_box = new JComboBox();
		kursnummer_box.setBackground(new Color(255, 255, 255));
		kursnummer_box.setModel(new DefaultComboBoxModel(new String[] {"Klasse 1", "Klasse 2", "Klasse 3", "Klasse 4", "Klasse 5", "Klasse 6", "Klasse 7"}));
		kursnummer_box.setForeground(new Color(105, 105, 105));
		kursnummer_box.setFont(new Font("Tahoma", Font.BOLD, 16));
		kursnummer_box.setBounds(247, 332, 145, 25);
		panel.add(kursnummer_box);
		
		telefon = new JTextField();
		telefon.setColumns(10);
		telefon.setBounds(638, 126, 145, 25);
		panel.add(telefon);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(638, 185, 145, 25);
		panel.add(email);
		
		JComboBox kurspakett_box = new JComboBox();
		kurspakett_box.setBackground(new Color(255, 255, 255));
		kurspakett_box.setForeground(new Color(105, 105, 105));
		kurspakett_box.setFont(new Font("Tahoma", Font.BOLD, 16));
		kurspakett_box.setModel(new DefaultComboBoxModel(new String[] {"Golden ", "Silber", "Bronze"}));
		kurspakett_box.setBounds(638, 239, 145, 25);
		panel.add(kurspakett_box);
		
		JComboBox zahlung_box = new JComboBox();
		zahlung_box.setBackground(new Color(255, 255, 255));
		zahlung_box.setForeground(new Color(105, 105, 105));
		zahlung_box.setFont(new Font("Tahoma", Font.BOLD, 16));
		zahlung_box.setModel(new DefaultComboBoxModel(new String[] {"Bezahlt", "2 Ratenzahlung", "4 Ratenzahlung", "8 Ratenzahlung"}));
		zahlung_box.setBounds(638, 311, 145, 25);
		panel.add(zahlung_box);
		
		JButton btnNewButton = new JButton("Aktualisieren");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					Statement st = con.createStatement();
					String query =  "select * from kinder";
					ResultSet rs = st.executeQuery(query);
					
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setBounds(882, 27, 182, 52);
		panel.add(btnNewButton);
		
		JButton btnHinzufgen = new JButton("L\u00F6schen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row  =table.getSelectedRow();
				String selection  = table.getModel().getValueAt(row,0).toString();
				String query1 = "delete from kinder where idkinder="+selection;
				String query2 = "delete from eltern where ideltern="+selection;
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					PreparedStatement pst1 = con.prepareStatement(query1);
					PreparedStatement pst2 = con.prepareStatement(query2);
					pst1.execute();
					pst2.execute();
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
		btnHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHinzufgen.setBackground(new Color(176, 224, 230));
		btnHinzufgen.setBounds(882, 203, 182, 52);
		panel.add(btnHinzufgen);
		
		JButton btnLschen = new JButton("Hinzuf\u00FCgen");
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");
					String querykinder= "insert into kinder(idkinder, nachname, vorname, geschlecht, geburtsdatum, lehrerin ,kurspakett, eltern_name, ideltern, kursnummer)"
							+ "values(?,?,?,?,?,?,?,?,?,?)";
					//String queryeltern= "insert into eltern(ideltern, elternname, telefonnummer, email ,kurspakett,zahlungssitiation, kinder)"
							//+ "values(?,?,?,?,?,?,?)";
					PreparedStatement pstkinder= con.prepareStatement(querykinder);
					//PreparedStatement psteltern= con.prepareStatement(queryeltern);
					
					pstkinder.setString(1, id.getText());
					pstkinder.setString(2, kindernachname.getText());
					pstkinder.setString(3, kindervorname.getText());
					
					
					if(Junge.isSelected()) {
						geschlecht = "Junge";
					}
					if(Maedchen.isSelected()) {
						geschlecht = "Maedchen";
					}
					
					pstkinder.setString(4, geschlecht);
					pstkinder.setString(5, gd.getText());
					
					
					lehrerin = lehrerin_box.getSelectedItem().toString();
					pstkinder.setString(6, lehrerin);
					
					kurspakett=kurspakett_box.getSelectedItem().toString();
					pstkinder.setString(7, kurspakett);
					
					pstkinder.setString(8, elternname.getText());
					pstkinder.setString(9,elternid.getText());
					
					kursnum = kursnummer_box.getSelectedItem().toString();
					pstkinder.setString(10, kursnum);
					/*		
					psteltern.setString(1, elternid.getText());
					psteltern.setString(2, elternname.getText());
					psteltern.setString(3, telefon.getText());
					psteltern.setString(4, email.getText());

					psteltern.setString(5, kurspakett);
					
					zahlung=zahlung_box.getSelectedItem().toString();
					psteltern.setString(6, zahlung);
					
					psteltern.setString(7, id.getText());
					
					pstkinder.executeUpdate();
					psteltern.executeUpdate();
					*/
					JOptionPane.showMessageDialog(null, "Erfolgreich hinzugefügt!");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLschen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLschen.setBackground(new Color(176, 224, 230));
		btnLschen.setBounds(882, 109, 182, 52);
		panel.add(btnLschen);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBackground(new Color(176, 224, 230));
		btnReset.setBounds(882, 292, 182, 52);
		panel.add(btnReset);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_home home = new Admin_home();
				home.show();
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 10, 93, 29);
		contentPane.add(btnNewButton_1);
	}
}
