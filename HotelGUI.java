/*
 * GUI class.  This class will provide the interface for our system.
 * Authors: Jason Cain, Van Chadrick Villondo, Marcus Goodwin
 * Date: 05/07/2020
 *
 * Revision 1 (MG): Initial creation
 * Revision 2 (MG): Updated frame titles and commenting
 * Revision 3 (MG): Added check in/out date to search frame & more comments
 * Revision 4 (MG): Added search results frame
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class HotelGUI {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenX = screenSize.width/3;
	private int screenY = screenSize.height/4;
	
	private JFrame loginFrame; // Login frame
	private JTextField userField;
	private JPasswordField pwField;
	
	private JFrame hotelFrame; // Main menu frame
	
	private JFrame regFrame; // Register frame
	private JTextField usernameField;
	private JPasswordField passField;
	private JTextField firstField;
	private JTextField lastField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	
	private JFrame searchFrame; // Search rooms frame
	private JTextField searchInField;
	private JTextField searchOutField;
	
	private JFrame bookingFrame; // Make a reservation frame
	private JTextField rmNumberField;
	private JTextField checkInField;
	private JTextField checkOutField;
	
	private JFrame cancelFrame; // Delete reservation frame
	private JTextField userCancelField;
	private JTextField roomCancelField;
	
	private JFrame resultsFrame; // Search results frame
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelGUI window = new HotelGUI();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HotelGUI() {
		initializeLogin();
	}

	/*
	 *  Show login frame
	 */
	private void initializeLogin() {
		loginFrame = new JFrame();
		loginFrame.getContentPane().setBackground(Color.DARK_GRAY);
		loginFrame.setResizable(false);
		loginFrame.setTitle("Hotel Reservation System");
		loginFrame.setBounds(screenX, screenY, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		userField = new JTextField();
		userField.setFont(new Font("Arial", Font.PLAIN, 16));
		userField.setBounds(150, 70, 200, 40);;
		userField.setText("");
		loginFrame.getContentPane().add(userField);
		userField.setColumns(10);
		
		pwField = new JPasswordField();
		pwField.setFont(new Font("Arial", Font.PLAIN, 16));
		pwField.setColumns(10);
		pwField.setBounds(150, 120, 200, 40);
		pwField.setText("");
		loginFrame.getContentPane().add(pwField);
		
		JButton loginBtn = new JButton("Log In");
		loginBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		loginBtn.setBounds(70, 200, 150, 40);
		loginFrame.getContentPane().add(loginBtn);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		registerBtn.setBounds(230, 200, 150, 40);
		loginFrame.getContentPane().add(registerBtn);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		userLabel.setBounds(60, 83, 80, 20);
		loginFrame.getContentPane().add(userLabel);
		
		JLabel pwLabel = new JLabel("Password");
		pwLabel.setForeground(Color.WHITE);
		pwLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		pwLabel.setBounds(60, 133, 80, 20);
		loginFrame.getContentPane().add(pwLabel);
		
		JLabel titleLabel = new JLabel("Hotel Services Log In / Register");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		titleLabel.setBounds(100, 20, 250, 40);
		loginFrame.getContentPane().add(titleLabel);
		
		/*
		 * Action listeners for login/register
		 */
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// * * * code to be added (validate information through database) * * *
				
				
				if (!userField.getText().equals("") && !pwField.getText().equals("")) { 
					initializeMenu(); // only logs in if form is not blank
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String un = userField.getText();
				String pw = pwField.getText();
				initializeRegister(un, pw);
			}
		});
		
	}
	
	/*
	 * Show the main menu
	 */
	private void initializeMenu() {
		loginFrame.dispose();
		hotelFrame = new JFrame();
		hotelFrame.getContentPane().setBackground(Color.DARK_GRAY);
		hotelFrame.getContentPane().setLayout(null);
		hotelFrame.setResizable(false);
		hotelFrame.setTitle("Hotel Reservation System");
		
		JLabel optionLabel = new JLabel("Choose an Option");
		optionLabel.setForeground(Color.WHITE);
		optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionLabel.setFont(new Font("Arial", Font.BOLD, 16));
		optionLabel.setBounds(40, 20, 300, 40);
		hotelFrame.getContentPane().add(optionLabel);
		
		JButton searchBtn = new JButton("Search Rooms");
		searchBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		searchBtn.setBounds(90, 100, 200, 40);
		hotelFrame.getContentPane().add(searchBtn);
		
		JButton bookBtn = new JButton("Make a Reservation");
		bookBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		bookBtn.setBounds(90, 151, 200, 40);
		hotelFrame.getContentPane().add(bookBtn);
		
		JButton editBtn = new JButton("Cancel Reservation");
		editBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		editBtn.setBounds(90, 202, 200, 40);
		hotelFrame.getContentPane().add(editBtn);
		hotelFrame.setBounds(screenX, screenY, 400, 350);
		hotelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hotelFrame.setVisible(true);
		
		/*
		 * Main menu action listeners
		 */
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initializeSearch();
			}
		});
		
		bookBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initializeBooking();
			}
		});
		
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initializeCancel();
			}
		});
		
	}
	
	/*
	 *  Show register frame
	 */
	private void initializeRegister(String user, String pass) {
		regFrame = new JFrame();
		regFrame.getContentPane().setBackground(Color.DARK_GRAY);
		regFrame.getContentPane().setLayout(null);
		regFrame.setResizable(false);
		regFrame.setTitle("Hotel Reservation System");
		
		JLabel regLabel = new JLabel("Register Account");
		regLabel.setForeground(Color.WHITE);
		regLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regLabel.setFont(new Font("Arial", Font.BOLD, 16));
		regLabel.setBounds(150, 20, 300, 40);
		regFrame.getContentPane().add(regLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameLabel.setBounds(50, 80, 80, 30);
		regFrame.getContentPane().add(usernameLabel);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		passLabel.setBounds(50, 125, 80, 30);
		regFrame.getContentPane().add(passLabel);
		
		JLabel firstLabel = new JLabel("First Name");
		firstLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		firstLabel.setForeground(Color.WHITE);
		firstLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		firstLabel.setBounds(50, 170, 80, 30);
		regFrame.getContentPane().add(firstLabel);
		
		JLabel lastLabel = new JLabel("Last Name");
		lastLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastLabel.setForeground(Color.WHITE);
		lastLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lastLabel.setBounds(50, 215, 80, 30);
		regFrame.getContentPane().add(lastLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameField.setBounds(140, 80, 125, 30);
		usernameField.setText(user);
		regFrame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Arial", Font.PLAIN, 16));
		passField.setColumns(10);
		passField.setBounds(140, 125, 125, 30);
		passField.setText(pass);
		regFrame.getContentPane().add(passField);
		
		firstField = new JTextField();
		firstField.setFont(new Font("Arial", Font.PLAIN, 16));
		firstField.setColumns(10);
		firstField.setBounds(140, 170, 125, 30);
		regFrame.getContentPane().add(firstField);
		
		lastField = new JTextField();
		lastField.setFont(new Font("Arial", Font.PLAIN, 16));
		lastField.setColumns(10);
		lastField.setBounds(140, 215, 125, 30);
		regFrame.getContentPane().add(lastField);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		addressLabel.setForeground(Color.WHITE);
		addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		addressLabel.setBounds(320, 80, 70, 30);
		regFrame.getContentPane().add(addressLabel);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		phoneLabel.setBounds(320, 125, 70, 30);
		regFrame.getContentPane().add(phoneLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLabel.setBounds(320, 170, 70, 30);
		regFrame.getContentPane().add(emailLabel);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Arial", Font.PLAIN, 16));
		addressField.setColumns(10);
		addressField.setBounds(400, 80, 125, 30);
		regFrame.getContentPane().add(addressField);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Arial", Font.PLAIN, 16));
		phoneField.setColumns(10);
		phoneField.setBounds(400, 125, 125, 30);
		regFrame.getContentPane().add(phoneField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Arial", Font.PLAIN, 16));
		emailField.setColumns(10);
		emailField.setBounds(400, 170, 125, 30);
		regFrame.getContentPane().add(emailField);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		registerBtn.setBounds(360, 215, 130, 30);
		regFrame.getContentPane().add(registerBtn);
		
		JButton regCancelBtn = new JButton("Cancel");
		regCancelBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		regCancelBtn.setBounds(360, 256, 130, 30);
		regFrame.getContentPane().add(regCancelBtn);
		regFrame.setBounds(screenX, screenY, 600, 350);
		regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regFrame.setVisible(true);
		
		/*
		 * Register frame action listeners
		 */
		registerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// * * * code to be added (add registry to database) * * *
				// create error if registry already exists
				
				regFrame.dispose();
				initializeMenu();
			}
		});
		
		regCancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				regFrame.dispose();
			}
		});
	}
	
	/*
	 * Show search frame
	 */
	private void initializeSearch() {
		searchFrame = new JFrame();
		searchFrame.getContentPane().setBackground(Color.DARK_GRAY);
		searchFrame.getContentPane().setLayout(null);
		searchFrame.setResizable(false);
		searchFrame.setTitle("Hotel Reservation System");
		
		JLabel searchLabel = new JLabel("Search for a Room");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setForeground(Color.WHITE);
		searchLabel.setFont(new Font("Arial", Font.BOLD, 16));
		searchLabel.setBounds(135, 20, 150, 30);
		searchFrame.getContentPane().add(searchLabel);
		
		JComboBox guestCombo = new JComboBox();
		guestCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		guestCombo.setModel(new DefaultComboBoxModel(new String[] {"2", "4"}));
		guestCombo.setBounds(60, 100, 90, 30);
		searchFrame.getContentPane().add(guestCombo);
		
		JLabel guestLabel = new JLabel("Number of Guests");
		guestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		guestLabel.setForeground(Color.WHITE);
		guestLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		guestLabel.setBounds(40, 70, 130, 30);
		searchFrame.getContentPane().add(guestLabel);
		
		JLabel bedLabel = new JLabel("Number of Beds");
		bedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bedLabel.setForeground(Color.WHITE);
		bedLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		bedLabel.setBounds(40, 150, 130, 30);
		searchFrame.getContentPane().add(bedLabel);
		
		JRadioButton radioOne = new JRadioButton("1");
		radioOne.setFont(new Font("Arial", Font.BOLD, 16));
		radioOne.setForeground(Color.WHITE);
		radioOne.setBackground(Color.DARK_GRAY);
		radioOne.setBounds(60, 180, 40, 30);
		searchFrame.getContentPane().add(radioOne);
		
		JRadioButton radioTwo = new JRadioButton("2");
		radioTwo.setForeground(Color.WHITE);
		radioTwo.setFont(new Font("Arial", Font.BOLD, 16));
		radioTwo.setBackground(Color.DARK_GRAY);
		radioTwo.setBounds(110, 180, 40, 30);
		searchFrame.getContentPane().add(radioTwo);
		
		JLabel smokingLabel = new JLabel("Smoking friendly?");
		smokingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		smokingLabel.setForeground(Color.WHITE);
		smokingLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		smokingLabel.setBounds(240, 70, 130, 30);
		searchFrame.getContentPane().add(smokingLabel);
		
		JLabel petLabel = new JLabel("Pet friendly?");
		petLabel.setHorizontalAlignment(SwingConstants.CENTER);
		petLabel.setForeground(Color.WHITE);
		petLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		petLabel.setBounds(240, 150, 130, 30);
		searchFrame.getContentPane().add(petLabel);
		
		JComboBox smokingCombo = new JComboBox();
		smokingCombo.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No", "Either"}));
		smokingCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		smokingCombo.setBounds(260, 100, 90, 30);
		searchFrame.getContentPane().add(smokingCombo);
		
		JComboBox petCombo = new JComboBox();
		petCombo.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No", "Either"}));
		petCombo.setFont(new Font("Arial", Font.PLAIN, 16));
		petCombo.setBounds(260, 180, 90, 30);
		searchFrame.getContentPane().add(petCombo);
		
		JButton doSearchButton = new JButton("Search");
		doSearchButton.setFont(new Font("Arial", Font.PLAIN, 16));
		doSearchButton.setBounds(110, 325, 90, 30);
		searchFrame.getContentPane().add(doSearchButton);
		
		JButton cancelSearchButton = new JButton("Cancel");
		cancelSearchButton.setFont(new Font("Arial", Font.PLAIN, 16));
		cancelSearchButton.setBounds(220, 325, 90, 30);
		searchFrame.getContentPane().add(cancelSearchButton);
		
		JLabel searchInLabel = new JLabel("Check-In Date");
		searchInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchInLabel.setForeground(Color.WHITE);
		searchInLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		searchInLabel.setBounds(50, 230, 120, 30);
		searchFrame.getContentPane().add(searchInLabel);
		
		searchInField = new JTextField();
		searchInField.setBounds(60, 260, 100, 30);
		searchFrame.getContentPane().add(searchInField);
		searchInField.setColumns(10);
		
		searchOutField = new JTextField();
		searchOutField.setColumns(10);
		searchOutField.setBounds(255, 260, 100, 30);
		searchFrame.getContentPane().add(searchOutField);
		
		JLabel searchOutLabel = new JLabel("Check-Out Date");
		searchOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchOutLabel.setForeground(Color.WHITE);
		searchOutLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		searchOutLabel.setBounds(245, 230, 120, 30);
		searchFrame.getContentPane().add(searchOutLabel);
		
		JLabel dateLabel = new JLabel("(mm/dd/yyyy)");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		dateLabel.setBounds(160, 260, 95, 30);
		searchFrame.getContentPane().add(dateLabel);
		searchFrame.setBounds(screenX, screenY, 425, 420);
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchFrame.setVisible(true);
		
		/*
		 * Search frame action listeners
		 */
		guestCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// If user selects 4 guests, only 2 bed option can be chosen
				if (guestCombo.getSelectedIndex() == 1) {
					radioOne.setSelected(false);
					radioOne.setEnabled(false);
					radioTwo.setSelected(true);
					radioTwo.setEnabled(false);
				}
				if (guestCombo.getSelectedIndex() == 0) {
					radioOne.setEnabled(true);
					radioTwo.setEnabled(true);
				}
			}
		});
		
		radioOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioOne.isSelected()) {
					radioTwo.setSelected(false);
				}
			}
		});
		
		radioTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioTwo.isSelected()) {
					radioOne.setSelected(false);
				}
			}
		});
		
		doSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedGuests;
				int selectedBeds;
				boolean optSmoking;
				boolean optPets;
				
				// * * * need to declare dates for search * * *
				
				if (guestCombo.getSelectedIndex() == 0) {
					selectedGuests = 2;
				}
				else if (guestCombo.getSelectedIndex() == 1) {
					selectedGuests = 4;
				}
				
				if (radioOne.isSelected()) {
					selectedBeds = 1;
				}
				else if (radioTwo.isSelected()) {
					selectedBeds = 2;
				}
				
				if (smokingCombo.getSelectedIndex() == 0) {
					optSmoking = true;
				}
				else if (smokingCombo.getSelectedIndex() == 1) {
					optSmoking = false;
				}
				
				if (petCombo.getSelectedIndex() == 0) {
					optPets = true;
				}
				else if (petCombo.getSelectedIndex() == 1) {
					optPets = false;
				}
				
				
				// * * * code to be added (perform search) * * *
				
				
				initializeResults();
			}
		});
		
		cancelSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchFrame.dispose();
			}
		});
	}
	
	/*
	 * Show reservation booking frame
	 */
	private void initializeBooking() {
		bookingFrame = new JFrame();
		bookingFrame.getContentPane().setBackground(Color.DARK_GRAY);
		bookingFrame.getContentPane().setLayout(null);
		bookingFrame.setResizable(false);
		bookingFrame.setTitle("Hotel Reservation System");
		
		JLabel makeResLabel = new JLabel("Make a Reservation");
		makeResLabel.setHorizontalAlignment(SwingConstants.CENTER);
		makeResLabel.setForeground(Color.WHITE);
		makeResLabel.setFont(new Font("Arial", Font.BOLD, 16));
		makeResLabel.setBounds(200, 32, 170, 30);
		bookingFrame.getContentPane().add(makeResLabel);
		
		JLabel rmNumberLabel = new JLabel("Room Number");
		rmNumberLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		rmNumberLabel.setForeground(Color.WHITE);
		rmNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		rmNumberLabel.setBounds(20, 90, 120, 30);
		bookingFrame.getContentPane().add(rmNumberLabel);
		
		JLabel checkInLabel = new JLabel("Check-In Date\r");
		checkInLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		checkInLabel.setForeground(Color.WHITE);
		checkInLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		checkInLabel.setBounds(20, 150, 120, 30);
		bookingFrame.getContentPane().add(checkInLabel);
		
		JLabel checkOutLabel = new JLabel("Check-Out Date");
		checkOutLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		checkOutLabel.setForeground(Color.WHITE);
		checkOutLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		checkOutLabel.setBounds(20, 210, 120, 30);
		bookingFrame.getContentPane().add(checkOutLabel);
		
		rmNumberField = new JTextField();
		rmNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
		rmNumberField.setBounds(150, 90, 65, 30);
		bookingFrame.getContentPane().add(rmNumberField);
		rmNumberField.setColumns(10);
		
		checkInField = new JTextField();
		checkInField.setFont(new Font("Arial", Font.PLAIN, 16));
		checkInField.setColumns(10);
		checkInField.setBounds(150, 150, 140, 30);
		bookingFrame.getContentPane().add(checkInField);
		
		checkOutField = new JTextField();
		checkOutField.setFont(new Font("Arial", Font.PLAIN, 16));
		checkOutField.setColumns(10);
		checkOutField.setBounds(150, 210, 140, 30);
		bookingFrame.getContentPane().add(checkOutField);
		
		JTextPane infoTextPane = new JTextPane();
		infoTextPane.setText("Room Number:\r\nGuests:\r\nBeds:\r\nSmoking:\r\nPets:");
		infoTextPane.setFont(new Font("Arial", Font.PLAIN, 16));
		infoTextPane.setEditable(false);
		infoTextPane.setBounds(330, 90, 200, 150);
		bookingFrame.getContentPane().add(infoTextPane);
		
		JButton reserveButton = new JButton("Reserve");
		reserveButton.setFont(new Font("Arial", Font.PLAIN, 16));
		reserveButton.setBounds(150, 300, 120, 30);
		bookingFrame.getContentPane().add(reserveButton);
		
		JButton cancelResButton = new JButton("Cancel");
		cancelResButton.setFont(new Font("Arial", Font.PLAIN, 16));
		cancelResButton.setBounds(300, 300, 120, 30);
		bookingFrame.getContentPane().add(cancelResButton);
		
		JButton checkButton = new JButton("Check");
		checkButton.setFont(new Font("Arial", Font.PLAIN, 12));
		checkButton.setBounds(220, 90, 70, 30);
		bookingFrame.getContentPane().add(checkButton);
		
		JLabel dateLabel = new JLabel("(mm/dd/yyyy)");
		dateLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		dateLabel.setBounds(20, 180, 120, 30);
		bookingFrame.getContentPane().add(dateLabel);
		bookingFrame.setBounds(screenX, screenY, 600, 400);
		bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bookingFrame.setVisible(true);
		
		/*
		 * Booking frame action listeners
		 */
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 0;
				try { 
					num = Integer.parseInt(rmNumberField.getText());
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Invalid Room Number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (num < 25) {
					infoTextPane.setText("Room Number: " + num + 
							"\r\nGuests: 2\r\nBeds: 1" + 
							"\r\nSmoking: Yes\r\nPets: Yes");
				}
				else if (num >= 25 && num < 50) {
					infoTextPane.setText("Room Number: " + num + 
							"\r\nGuests: 4\r\nBeds: 2" + 
							"\r\nSmoking: No\r\nPets: Yes");
				}
				else if (num >= 50 && num < 75) {
					infoTextPane.setText("Room Number: " + num + 
							"\r\nGuests: 4\r\nBeds: 2" + 
							"\r\nSmoking: Yes\r\nPets: No");
				}
				else if (num >= 75 && num < 100) {
					infoTextPane.setText("Room Number: " + num + 
							"\r\nGuests: 2\r\nBeds: 2" + 
							"\r\nSmoking: No\r\nPets: No");
				}
				else {
					infoTextPane.setText("Invalid Room Number");
				}
				
			}
		});
		
		reserveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// * * * code to be added (make sure room is available and add reservation) * * *
				
				bookingFrame.dispose();
			}
		});
		
		cancelResButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bookingFrame.dispose();
			}
		});
	}
	
	/*
	 * Show edit reservation frame
	 */
	private void initializeCancel() {
		cancelFrame = new JFrame();
		cancelFrame.getContentPane().setBackground(Color.DARK_GRAY);
		cancelFrame.getContentPane().setLayout(null);
		cancelFrame.setResizable(false);
		cancelFrame.setTitle("Hotel Reservation System");
		
		JLabel cancelLabel = new JLabel("Cancel Reservation");
		cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cancelLabel.setForeground(Color.WHITE);
		cancelLabel.setFont(new Font("Arial", Font.BOLD, 16));
		cancelLabel.setBounds(90, 20, 160, 30);
		cancelFrame.getContentPane().add(cancelLabel);
		
		JLabel userCancelLabel = new JLabel("Username");
		userCancelLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		userCancelLabel.setForeground(Color.WHITE);
		userCancelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		userCancelLabel.setBounds(20, 70, 120, 30);
		cancelFrame.getContentPane().add(userCancelLabel);
		
		JLabel roomCancelLabel = new JLabel("Room Number");
		roomCancelLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		roomCancelLabel.setForeground(Color.WHITE);
		roomCancelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		roomCancelLabel.setBounds(20, 110, 120, 30);
		cancelFrame.getContentPane().add(roomCancelLabel);
		
		userCancelField = new JTextField();
		userCancelField.setFont(new Font("Arial", Font.PLAIN, 16));
		userCancelField.setBounds(150, 70, 120, 30);
		cancelFrame.getContentPane().add(userCancelField);
		userCancelField.setColumns(10);
		
		roomCancelField = new JTextField();
		roomCancelField.setFont(new Font("Arial", Font.PLAIN, 16));
		roomCancelField.setColumns(10);
		roomCancelField.setBounds(150, 110, 120, 30);
		cancelFrame.getContentPane().add(roomCancelField);
		
		JButton cancelResBtn = new JButton("Cancel Reservation");
		cancelResBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		cancelResBtn.setBounds(90, 160, 170, 30);
		cancelFrame.getContentPane().add(cancelResBtn);
		
		JButton cancelMenuBtn = new JButton("Main Menu");
		cancelMenuBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		cancelMenuBtn.setBounds(90, 201, 170, 30);
		cancelFrame.getContentPane().add(cancelMenuBtn);
		cancelFrame.setBounds(screenX, screenY, 360, 300);
		cancelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cancelFrame.setVisible(true);
		
		/*
		 * Edit frame action listeners
		 */
		cancelResBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// * * * code to be added (make sure reservation is valid & delete it) * * *
				// create error if reservation is not valid
				
			}
		});
		cancelMenuBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelFrame.dispose();
			}
		});
	}
	
	/*
	 * Show search results frame
	 */
	private void initializeResults() {
		resultsFrame = new JFrame();
		resultsFrame.getContentPane().setBackground(Color.DARK_GRAY);
		resultsFrame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Results");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(145, 20, 90, 30);
		resultsFrame.getContentPane().add(lblNewLabel);
		
		JScrollPane resultsScrollPane = new JScrollPane();
		resultsScrollPane.setBounds(70, 60, 240, 200);
		resultsFrame.getContentPane().add(resultsScrollPane);
		
		JTextPane resultsList = new JTextPane();
		resultsList.setEditable(false);
		resultsList.setText("");
		resultsList.setFont(new Font("Arial", Font.PLAIN, 14));
		resultsScrollPane.setViewportView(resultsList);
		
		JButton goBookButton = new JButton("Go to Booking");
		goBookButton.setFont(new Font("Arial", Font.PLAIN, 16));
		goBookButton.setBounds(60, 295, 150, 30);
		resultsFrame.getContentPane().add(goBookButton);
		
		JButton goCancelButton = new JButton("Cancel");
		goCancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
		goCancelButton.setBounds(220, 295, 100, 30);
		resultsFrame.getContentPane().add(goCancelButton);
		resultsFrame.setBounds(screenX, screenY, 400, 400);
		resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultsFrame.setResizable(false);
		resultsFrame.setVisible(true);
		
		/*
		 * Results frame action listeners
		 */
		goBookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchFrame.dispose();
				resultsFrame.dispose();
				initializeBooking();
			}
		});
		
		goCancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultsFrame.dispose();
			}
		});
		
	}
}
