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
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Personal_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal_home frame = new Personal_home();
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
	public Personal_home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal Homeseite");
		lblNewLabel.setForeground(new Color(135, 206, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(242, 0, 241, 83);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(135, 206, 250)));
		panel.setBounds(10, 69, 730, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(240, 128, 128));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\search.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personal_suche suche = new Personal_suche();
				suche.show();
				dispose();				
			}
		});
		btnNewButton.setBounds(217, 21, 169, 87);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personal_kurse kurse = new Personal_kurse();
				kurse.show();
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\kindergarten.png"));
		btnNewButton_1.setBounds(217, 118, 169, 87);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personal_personal personal = new Personal_personal();
				personal.show();
				dispose();
			}
		});
		btnNewButton_1_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\personal-information.png"));
		btnNewButton_1_1.setBounds(217, 305, 169, 87);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sucheseite");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(396, 49, 129, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kurse Info");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(396, 147, 129, 27);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Personal Info");
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(401, 333, 160, 27);
		panel.add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personal_veranstaltungen ver = new Personal_veranstaltungen();
				ver.show();
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\aycan\\Downloads\\father.png"));
		btnNewButton_2.setBackground(new Color(205, 92, 92));
		btnNewButton_2.setBounds(217, 215, 169, 80);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Veranstaltungen");
		lblNewLabel_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_2_1.setBounds(396, 241, 197, 27);
		panel.add(lblNewLabel_1_2_1);
	}
}
