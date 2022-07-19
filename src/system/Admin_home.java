package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class Admin_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_home frame = new Admin_home();
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
	public Admin_home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrator Homepage");
		lblNewLabel.setForeground(new Color(255, 182, 193));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(203, 10, 342, 61);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 182, 193), new Color(255, 182, 193), new Color(255, 182, 193), new Color(255, 182, 193)));
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(42, 61, 689, 453);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(253, 315, 143, 68);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_veranstaltung veranstaltung = new Admin_veranstaltung();
				veranstaltung.show();
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\father (1).png"));
		
		JLabel lblNewLabel_1_1 = new JLabel("Veranstaltungen");
		lblNewLabel_1_1.setBounds(253, 393, 156, 28);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\search.png"));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KundeSearch suche = new KundeSearch();
				suche.show();
				dispose();
				
			}
		});
		btnNewButton_1_3.setBackground(new Color(100, 149, 237));
		btnNewButton_1_3.setBounds(423, 41, 143, 68);
		panel.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Personal Info");
		lblNewLabel_1_3_1.setBounds(82, 265, 133, 13);
		panel.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.setForeground(Color.GRAY);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setBounds(72, 187, 143, 68);
		panel.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_personalinfo personal = new Admin_personalinfo();
				personal.show();
				dispose();
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\personal-information.png"));
		btnNewButton_1_2.setBackground(new Color(216, 191, 216));
		
		JLabel lblNewLabel_1_3 = new JLabel("Kurse Info");
		lblNewLabel_1_3.setBounds(443, 265, 112, 13);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setForeground(Color.GRAY);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnNewButton_1_2_1 = new JButton("");
		btnNewButton_1_2_1.setBounds(423, 187, 143, 68);
		panel.add(btnNewButton_1_2_1);
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_kurseinfo kurse  =new Admin_kurseinfo();
				kurse.show();
				dispose();
			}
		});
		btnNewButton_1_2_1.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\kindergarten.png"));
		btnNewButton_1_2_1.setBackground(new Color(240, 128, 128));
		
		JLabel lblNewLabel_1_4 = new JLabel("Suche");
		lblNewLabel_1_4.setForeground(Color.GRAY);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(463, 119, 92, 13);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1 = new JLabel("Registrierungsseite");
		lblNewLabel_1.setBounds(58, 111, 182, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnNewButton_1_3_1 = new JButton("");
		btnNewButton_1_3_1.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\edit.png"));
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registiration rg = new registiration();
				rg.show();
				dispose();
			}
		});
		btnNewButton_1_3_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1_3_1.setBounds(72, 41, 143, 68);
		panel.add(btnNewButton_1_3_1);
	}
}
