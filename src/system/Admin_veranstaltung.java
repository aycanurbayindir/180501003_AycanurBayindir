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

public class Admin_veranstaltung extends JFrame {

	private JPanel contentPane;
	private JTextField nummer;
	private JTextField name;
	private JTextField start;
	private JTextField duration;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_veranstaltung frame = new Admin_veranstaltung();
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
	public Admin_veranstaltung() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veranstaltungnummer:");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(391, 72, 225, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblVeranstaltungname = new JLabel("Name:");
		lblVeranstaltungname.setForeground(new Color(25, 25, 112));
		lblVeranstaltungname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVeranstaltungname.setBounds(391, 133, 121, 13);
		contentPane.add(lblVeranstaltungname);
		
		JLabel lblStartzeit = new JLabel("Startzeit:");
		lblStartzeit.setForeground(new Color(25, 25, 112));
		lblStartzeit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStartzeit.setBounds(391, 181, 103, 13);
		contentPane.add(lblStartzeit);
		
		JLabel lblDauer = new JLabel("Dauer:");
		lblDauer.setForeground(new Color(25, 25, 112));
		lblDauer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDauer.setBounds(391, 238, 103, 13);
		contentPane.add(lblDauer);
		
		JLabel lblGebaeude = new JLabel("Gebaeude:");
		lblGebaeude.setForeground(new Color(25, 25, 112));
		lblGebaeude.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGebaeude.setBounds(391, 290, 121, 13);
		contentPane.add(lblGebaeude);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gebaeude A", "Gebaeude B", "Atelier", "Hinterhof", "Vorgarten"}));
		comboBox.setBounds(558, 284, 142, 26);
		contentPane.add(comboBox);
		
		nummer = new JTextField();
		nummer.setBounds(626, 76, 74, 21);
		contentPane.add(nummer);
		nummer.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(582, 131, 119, 21);
		contentPane.add(name);
		
		start = new JTextField();
		start.setColumns(10);
		start.setBounds(582, 179, 118, 21);
		contentPane.add(start);
		
		duration = new JTextField();
		duration.setColumns(10);
		duration.setBounds(579, 236, 121, 21);
		contentPane.add(duration);
		
		
		JButton add = new JButton("Neu Erstellen");
		add.setBackground(new Color(176, 224, 230));
		add.setFont(new Font("Tahoma", Font.BOLD, 18));
		add.setForeground(new Color(25, 25, 112));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");
					String query1= "insert into veranstaltung(nummer, name, start, dauer, gebaeude) "
							+ "values(?,?,?,?,?)";
					
					PreparedStatement pst= con.prepareStatement(query1);
					pst.setString(1, nummer.getText());
					pst.setString(2, name.getText());
					pst.setString(3,start.getText());
					pst.setString(4, duration.getText());
					
					String gebaeude;
					gebaeude = comboBox.getSelectedItem().toString();
					
					pst.setString(5, gebaeude);
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Erfolgreich hinzugefügt!");
					
				} catch (Exception exp) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, exp);
				}
			}
		});
	
		
		
		JButton delete = new JButton("L\u00F6schen");
		delete.setBackground(new Color(176, 224, 230));
		delete.setForeground(new Color(25, 25, 112));
		delete.setFont(new Font("Tahoma", Font.BOLD, 18));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row  = table.getSelectedRow();
				String selection  = table.getModel().getValueAt(row,0).toString();
				String query = "delete from veranstaltung where nummer="+selection;
				
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
		delete.setBounds(391, 435, 170, 45);
		contentPane.add(delete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(176, 224, 230));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setForeground(new Color(25, 25, 112));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nummer.setText(" ");
				name.setText("");
				start.setText("");
				duration.setText("");
				
			}
		});
		btnReset.setBounds(582, 435, 170, 45);
		contentPane.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 41, 345, 448);
		contentPane.add(scrollPane);
		
		add.setBounds(391, 351, 170, 45);
		contentPane.add(add);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nummer", "veranstaltung", "startzeit", "dauer", "gebaeude"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		

		JButton aktualisieren = new JButton("Aktualisieren");
		aktualisieren.setBackground(new Color(176, 224, 230));
		aktualisieren.setForeground(new Color(25, 25, 112));
		aktualisieren.setFont(new Font("Tahoma", Font.BOLD, 18));
		aktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,
							"root", "12345678");
					Statement st = con.createStatement();
					String sql = "select * from veranstaltung";
					
					ResultSet rs = st.executeQuery(sql);	
					
					//Clear old table
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged(); 
					
					while(rs.next()) {
						String nummer   = rs.getString("nummer");
						String veranstaltung = rs.getString("name");
						String startzeit = rs.getString("start");
						String dauer = rs.getString("dauer");
						String gebaeude = rs.getString("gebaeude");
				
						
						
						String tbData[]= {nummer,veranstaltung, startzeit, dauer,  gebaeude};
						DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
					}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		aktualisieren.setBounds(582, 351, 170, 45);
		contentPane.add(aktualisieren);
		
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
		btnNewButton.setBounds(20, 10, 85, 21);
		contentPane.add(btnNewButton);
			
		
	}

}
