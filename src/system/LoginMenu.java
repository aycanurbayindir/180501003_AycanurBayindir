package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class LoginMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu frame = new LoginMenu();
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
	public LoginMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aycan\\Desktop\\362398.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Administrator");
		btnNewButton.setIcon(null);
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminlogin admin = new Adminlogin();
				admin.show();
				
				dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Himmel");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 46));
		lblNewLabel_1.setBounds(264, 47, 189, 91);
		contentPane.add(lblNewLabel_1);
		btnNewButton.setBounds(236, 210, 282, 124);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.setBackground(new Color(176, 224, 230));
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.show();
				
				dispose();
			}
		});
		btnPersonal.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPersonal.setBounds(236, 369, 282, 124);
		contentPane.add(btnPersonal);
		
		JLabel lblNewLabel_2 = new JLabel("Kindergarten Management System");
		lblNewLabel_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(28, 68, 710, 142);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aycan\\Desktop\\Ekran g\u00F6r\u00FCnt\u00FCs\u00FC 2022-07-12 152059.png"));
		lblNewLabel.setBounds(0, 0, 786, 545);
		contentPane.add(lblNewLabel);
	}
}
