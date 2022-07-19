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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField personal_user;
	//Manually created
	static String username;
	private JPasswordField personal_pass;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception evt) {
					evt.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Benutzername:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(178, 225, 169, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPasswort.setBounds(178, 301, 151, 45);
		contentPane.add(lblPasswort);
		
		JLabel lblNewLabel_1 = new JLabel("Anmeldungsseite");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(234, 121, 274, 67);
		contentPane.add(lblNewLabel_1);
		
		personal_user = new JTextField();
		personal_user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		personal_user.setBounds(357, 242, 180, 32);
		contentPane.add(personal_user);
		personal_user.setColumns(10);
		
	
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal");
		lblNewLabel_1_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_1_1.setBounds(276, 57, 169, 67);
		contentPane.add(lblNewLabel_1_1);
		
		JButton back = new JButton("< Back");
		back.setBackground(new Color(192, 192, 192));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				LoginMenu menu = new LoginMenu();
				menu.show();
				
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 16));
		back.setBounds(10, 10, 109, 31);
		contentPane.add(back);
		
		personal_pass = new JPasswordField();
		personal_pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		personal_pass.setBounds(357, 312, 180, 32);
		contentPane.add(personal_pass);
		
		
		JButton btnNewButton = new JButton("Einloggen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useTimezone=true&serverTimezone=UTC" ,"root", "12345678");
					String sql= "Select * from user where username=? and passwort=? and usertyp=0";
					PreparedStatement pst= con.prepareStatement(sql);
					pst.setString(1, personal_user.getText());
					pst.setString(2, personal_pass.getText());
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Erfolgreich einloggen als Personal.");
						
						Personal_home home = new Personal_home();
						home.show();
						
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Falsche Benutzertyp oder Passwort!");
						personal_user.setText("");
						personal_pass.setText("");
						
					}
					con.close();
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(300, 387, 145, 56);
		contentPane.add(btnNewButton);
		
	}
}
