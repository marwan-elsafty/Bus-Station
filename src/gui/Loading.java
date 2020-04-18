package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Loading extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JLabel lbLoading;
	private JLabel lblX;
	private JLabel lblLoading;
	private JLabel label_1;
	private JLabel lblIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
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
	public Loading() {
		setUndecorated(true);
		
		setSize(400, 250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 47, 65));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbLoading = new JLabel("99");
		lbLoading.setForeground(Color.WHITE);
		lbLoading.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lbLoading.setBounds(212, 185, 20, 30);
		contentPane.add(lbLoading);
		
		JLabel label = new JLabel("X");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tunga", Font.PLAIN, 22));
		label.setBounds(374, 11, 16, 16);
		contentPane.add(label);
		
		lblX = new JLabel("<html>BUS<br>STATION</html>");
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblX.setBounds(10, 11, 120, 60);
		contentPane.add(lblX);
		
		lblLoading = new JLabel("Loading");
		lblLoading.setForeground(Color.WHITE);
		lblLoading.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblLoading.setBounds(148, 185, 70, 30);
		contentPane.add(lblLoading);
		
		label_1 = new JLabel("%");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		label_1.setBounds(232, 185, 16, 30);
		contentPane.add(label_1);
		
		lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("icons\\frontalBusSilhouette.png"));
		lblIcon.setForeground(Color.WHITE);
		lblIcon.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblIcon.setBounds(119, 11, 64, 64);
		contentPane.add(lblIcon);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}
