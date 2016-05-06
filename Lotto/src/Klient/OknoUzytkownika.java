package Klient;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class OknoUzytkownika implements ActionListener {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton btnStw, btnZamknij;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoUzytkownika window = new OknoUzytkownika();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	
	
	
	/**
	 * Create the application.
	 */
	public OknoUzytkownika() {
		initialize();
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblPodajSwojLogin = new JLabel("Podaj swoj login");
		lblPodajSwojLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblPodajSwojeHaslo = new JLabel("Podaj swoje haslo");
		lblPodajSwojeHaslo.setFont(new Font("Tahoma", Font.PLAIN, 13));

		passwordField = new JPasswordField();

		btnStw = new JButton("Stworz konto");
		btnStw.addActionListener((ActionListener) this);


		btnZamknij = new JButton("Zamknij");
		btnZamknij.addActionListener((ActionListener) this);







		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(95)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(passwordField, Alignment.LEADING)
								.addComponent(lblPodajSwojeHaslo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPodajSwojLogin, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(btnStw)
										.addGap(47)
										.addComponent(btnZamknij)))
						.addContainerGap(138, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(50)
						.addComponent(lblPodajSwojLogin, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblPodajSwojeHaslo)
						.addGap(18)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnStw)
								.addComponent(btnZamknij))
						.addGap(41))
				);
		frame.getContentPane().setLayout(groupLayout);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btnStw) {
			String user = textField.getText();
			String password = new String (passwordField.getPassword());
			if(user.equals("admin") && password.equals("password"));
			{
				createFrame();
			}
		} else if (source == btnZamknij) {
			System.exit(0);
		}
		
	}
	
	public static void createFrame()
	{
	    EventQueue.invokeLater(new Runnable()
	    {
	        @Override
	        public void run()
	        {
	            JFrame frame = new JFrame("Test");
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            frame.pack();
	            frame.setBounds(100, 100, 450, 300);
	            frame.setLocationByPlatform(true);
	            frame.setVisible(true);
	            frame.setResizable(false);
	        }
	    });
	}
}


