package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Adminlogin extends JFrame {

	private JPanel contentPane;
	private JTextField admin_user;
	private JPasswordField admin_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlogin frame = new Adminlogin();
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
	public Adminlogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Anmeldungsseite");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_1.setBounds(212, 95, 313, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Administrator");
		lblNewLabel_1_1.setForeground(new Color(255, 182, 193));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(261, 46, 215, 56);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Benutzername:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(212, 242, 154, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPasswort.setBounds(212, 310, 151, 32);
		contentPane.add(lblPasswort);
		
		admin_user = new JTextField();
		admin_user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		admin_user.setColumns(10);
		admin_user.setBounds(395, 244, 180, 32);
		contentPane.add(admin_user);
		
		JButton btnNewButton = new JButton("Einloggen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");
					String sql= "Select * from user where username=? and passwort=? and usertyp=1";
					PreparedStatement pst= con.prepareStatement(sql);
					pst.setString(1, admin_user.getText());
					pst.setString(2, admin_pass.getText());
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Erfolgreich als Administrator angemeldet.");
						
						Admin_home home = new Admin_home();
						home.show();
						
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Falsche Benutzertyp oder Passwort!");
						admin_user.setText("");
						admin_pass.setText("");
						
					}
					con.close();
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}			
			}
		});
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(274, 399, 145, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMenu menu = new LoginMenu();
				menu.show();
				
				dispose();
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 10, 106, 31);
		contentPane.add(btnNewButton_1);
		
		admin_pass = new JPasswordField();
		admin_pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		admin_pass.setBounds(393, 311, 182, 32);
		contentPane.add(admin_pass);
	}

}
