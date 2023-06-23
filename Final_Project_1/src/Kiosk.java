import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Kiosk extends JFrame {

	private JPanel contentPane;
	private JButton btnHamburger;
	private JButton btnSide;
	private JButton btnDrink;
	private JButton btnSet;
	private JLayeredPane layeredPane;
	private JPanel hamburgerPanel;
	private JPanel sidePanel;
	private JPanel drinkPanel;
	private JPanel setPanel;
	private JLabel lbHamburger;
	private JLabel lbSide;
	private JLabel lbDrink;
	private JLabel lbSet;
	private JLabel picBigMac;
	private JLabel picBulgogi;
	private JButton btnBigMac;
	private JButton btnBulgogi;
	private JLabel lbBigMac;
	private JLabel lbBulgogiBurger;
	private JLabel lbFries;
	private JLabel picFries;
	private JButton btnFries;
	private JLabel lbMacNudget;
	private JLabel picNudget;
	private JButton btnMacNudget;
	private JLabel lbCoke;
	private JLabel picCola;
	private JButton btnCoke;
	private JLabel lbSprite;
	private JLabel picSprite;
	private JButton btnSprite;
	private JLabel lblBigMacSet;
	private JLabel picBigMac_3;
	private JButton btnBigMacSet;
	private JLabel lblBulgogiBurgerSet;
	private JLabel picBulgogi_3;
	private JButton btnBulgogiSet;
	private JLabel lbBigMacPrice;
	private JLabel lbBGGPrice;
	private JLabel lbBigMacSetPrice;
	private JLabel lblwon;
	private JLabel lbPotatoPrice;
	private JLabel lbNudgetPrice;
	private JLabel lbColaPrice;
	private JLabel lbSpritePrice;
	private JCheckBox checkBMSetLarge;
	private JCheckBox checkBGGSetFriesLarge;
	private JCheckBox chckBMSetBun;
	private JCheckBox chckBGGSetBun;
	private JCheckBox chckColaLarge;
	private JCheckBox chckSpriteLarge;
	private JScrollPane scrollPane;
	private JTable table;
	private JCheckBox chckBMBun;
	private JCheckBox chckBGGBun;
	private JCheckBox chckFiresLarge;
	private JCheckBox chckNudgetLarge;
	private JCheckBox chckBMSetNoIce;
	private JCheckBox chckBBGSetNoIce;
	private JCheckBox chckColaNoIce;
	private JCheckBox chckSpriteNoIce;
	private DefaultTableModel buyList;
	private int totalCost = 0;	// it saves total money that a customer chooses to buy.
	private JLabel lbTotalCost;
	private JTextField tfTotalCost;
	private JLabel lblYourPayment;
	private JTextField tfPayment;
	private JButton btnPay;
	private JButton btnDeleteAll;
	private JButton btnDelete;
	private JLabel picLogo;
	private JTextField timeText;
	private JLabel lbTime;
	private Thread countDownOrder;
	private int sales;	// it saves overall value that all customers bought.
	private int customerNum; // it represents number of customer who used kiosk.
	
	//this function returns value of customerNum, so that user can get customerNum value.
	public int getCustomerNum() {
		return customerNum;
	}
	// this function sets the value of customerNum
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	//this function returns value of sales, so that user can get sales value.
	public int getSales() {
		return sales;
	}
	// this function sets the value of sales
	public void setSales(int sales) {
		this.sales = sales;
	}
	//this function returns string value of timeText, so that user can get timeText value.
	public JTextField getTimeText() {
		return timeText;
	}
	// this function sets the value of timeText
	public void setTimeText(JTextField timeText) {
		this.timeText = timeText;
	}
	//this function returns value of customerNum, so that user can get customerNum value.
	public int getTotalCost() {
		return totalCost;
	}
	// this function sets the value of totalCost added to original totalCost.
	public void setTotalCost(int totalCost) {
		this.totalCost = this.totalCost + totalCost;
	}
	//it refreshes the value of totalCost to zero.
	public void clearTotalCost() {
		this.totalCost = 0;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kiosk frame = new Kiosk();
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
	public Kiosk() {
		addWindowListener(new WindowAdapter() {
			@Override
			//when window is opened, it starts to run thread that counts down for expiration of ordering.
			//and it gets total sales value and customer number from total_sales.txt file.
			public void windowOpened(WindowEvent e) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("total_sales.txt"));
					String line = br.readLine();
					int total = Integer.parseInt(line);
					setSales(total);
					String line2 = br.readLine();
					int customerNum = Integer.parseInt(line2);
					setCustomerNum(customerNum);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					FileOutputStream fileObject1;
					//if there is no total_sales.txt, it creates total_sales.txt with 0 and 0.
					try {
						fileObject1 = new FileOutputStream("total_sales.txt", false);
						PrintWriter writer1 = new PrintWriter(fileObject1);
						writer1.print("0\n");
						writer1.print("0\n");
						writer1.close();
						fileObject1.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					
				}
				countDownOrder = new Thread(new countDownKiosk());
				countDownOrder.start();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 847);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 13, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnHamburger = new JButton("Hamburger");
		//when btnHamburger is clicked, hamburgerPanel appears from layeredPane.
		btnHamburger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(hamburgerPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnHamburger.setBounds(12, 119, 108, 45);
		contentPane.add(btnHamburger);
		
		btnSide = new JButton("Side");
		//when btnSide is clicked, sidePanel appears from layeredPane.
		btnSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(sidePanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSide.setBounds(12, 164, 108, 45);
		contentPane.add(btnSide);
		
		btnDrink = new JButton("Drink");
		//when btnDrink is clicked, drinkPanel appears from layeredPane.
		btnDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(drinkPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnDrink.setBounds(12, 210, 108, 45);
		contentPane.add(btnDrink);
		
		btnSet = new JButton("Set");
		//when btnSet is clicked, setPanel appears from layeredPane.
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(setPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSet.setBounds(12, 75, 108, 45);
		contentPane.add(btnSet);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(121, 75, 481, 510);
		contentPane.add(layeredPane);
		
		setPanel = new JPanel();
		setPanel.setBounds(0, 0, 481, 510);
		layeredPane.add(setPanel);
		setPanel.setLayout(null);
		
		lbSet = new JLabel("set");
		lbSet.setHorizontalAlignment(SwingConstants.CENTER);
		lbSet.setBounds(221, 5, 46, 15);
		setPanel.add(lbSet);
		
		lblBigMacSet = new JLabel("Big Mac Set");
		lblBigMacSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblBigMacSet.setBounds(66, 30, 125, 15);
		setPanel.add(lblBigMacSet);
		
		picBigMac_3 = new JLabel("");
		picBigMac_3.setIcon(new ImageIcon(Kiosk.class.getResource("/image/빅맥세트크기조정.png")));
		picBigMac_3.setBounds(56, 55, 154, 148);
		setPanel.add(picBigMac_3);
		
		btnBigMacSet = new JButton("Add Cart");
		//when btnBigMacSet is clicked, it addes bigMac Set to table with chosen options.
		btnBigMacSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Set bmSet = new Set(6000);
				bmSet.setName("BigMac Set");
				//this if statement controls over the options that user selected for bigMac Set.
				if (checkBMSetLarge.isSelected()) {
					bmSet.setLarge(true);
					bmSet.setOption("+L ");
				}
				if (chckBMSetBun.isSelected()) {
					bmSet.setBrioshBun(true);
					bmSet.setOption("+Briosh Bun ");
				}
				if (chckBMSetNoIce.isSelected()) {
					bmSet.setNoIce(true);
					bmSet.setOption("+No ice ");
				}
				bmSet.calculateCost();
				setTotalCost(bmSet.getTotalCost());
				String[] rows = new String[3];
				rows[0] = bmSet.getName();
				rows[1] = bmSet.getOption();
				rows[2] = bmSet.getTotalCost()+"";
				buyList.addRow(rows);
				tfTotalCost.setText(getTotalCost()+"");
				checkBMSetLarge.setSelected(false);
				chckBMSetBun.setSelected(false);
				chckBMSetNoIce.setSelected(false);
			}
		});
		btnBigMacSet.setBounds(127, 221, 85, 23);
		setPanel.add(btnBigMacSet);
		
		lblBulgogiBurgerSet = new JLabel("Bulgogi Burger Set");
		lblBulgogiBurgerSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblBulgogiBurgerSet.setBounds(66, 260, 125, 15);
		setPanel.add(lblBulgogiBurgerSet);
		
		picBulgogi_3 = new JLabel("");
		picBulgogi_3.setIcon(new ImageIcon(Kiosk.class.getResource("/image/불고기버거세트크기조정.png")));
		picBulgogi_3.setBounds(56, 285, 154, 148);
		setPanel.add(picBulgogi_3);
		
		btnBulgogiSet = new JButton("Add Cart");
		//when btnBulgogiSet is clicked, it addes bulgogiburger Set to table with chosen options.
		btnBulgogiSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Set bggSet = new Set(5000);
				bggSet.setName("Bulgogi Burger Set");
				//this if statement controls over the options that user selected for bulgogi burger set.
				if (checkBGGSetFriesLarge.isSelected()) {
					bggSet.setLarge(true);
					bggSet.setOption("+L ");
				}
				if (chckBGGSetBun.isSelected()) {
					bggSet.setBrioshBun(true);
					bggSet.setOption("+Briosh Bun ");
				}
				if (chckBBGSetNoIce.isSelected()) {
					bggSet.setNoIce(true);
					bggSet.setOption("+No ice ");
				}
				bggSet.calculateCost();
				setTotalCost(bggSet.getTotalCost());
				String[] rows = new String[3];
				rows[0] = bggSet.getName();
				rows[1] = bggSet.getOption();
				rows[2] = bggSet.getTotalCost()+"";
				buyList.addRow(rows);
				tfTotalCost.setText(getTotalCost()+"");
				checkBGGSetFriesLarge.setSelected(false);
				chckBGGSetBun.setSelected(false);
				chckBBGSetNoIce.setSelected(false);
			}
		});
		btnBulgogiSet.setBounds(127, 451, 85, 23);
		setPanel.add(btnBulgogiSet);
		
		lbBigMacSetPrice = new JLabel("6000won");
		lbBigMacSetPrice.setBounds(56, 217, 57, 15);
		setPanel.add(lbBigMacSetPrice);
		
		lblwon = new JLabel("5000won");
		lblwon.setBounds(66, 447, 57, 15);
		setPanel.add(lblwon);
		
		checkBGGSetFriesLarge = new JCheckBox("Large (+1500won)");
		checkBGGSetFriesLarge.setBounds(259, 285, 146, 23);
		setPanel.add(checkBGGSetFriesLarge);
		
		chckBMSetBun = new JCheckBox("Briosh Bun (+1000won)");
		chckBMSetBun.setBounds(259, 80, 165, 23);
		setPanel.add(chckBMSetBun);
		
		chckBGGSetBun = new JCheckBox("Briosh Bun (+1000won)");
		chckBGGSetBun.setBounds(259, 310, 165, 23);
		setPanel.add(chckBGGSetBun);
		
		checkBMSetLarge = new JCheckBox("Large (+1500won)");
		checkBMSetLarge.setBounds(259, 55, 146, 23);
		setPanel.add(checkBMSetLarge);
		
		chckBMSetNoIce = new JCheckBox("No Ice");
		chckBMSetNoIce.setBounds(259, 102, 165, 23);
		setPanel.add(chckBMSetNoIce);
		
		chckBBGSetNoIce = new JCheckBox("No Ice");
		chckBBGSetNoIce.setBounds(259, 333, 165, 23);
		setPanel.add(chckBBGSetNoIce);
		
		drinkPanel = new JPanel();
		drinkPanel.setBounds(0, 0, 481, 510);
		layeredPane.add(drinkPanel);
		drinkPanel.setLayout(null);
		
		lbDrink = new JLabel("Drink");
		lbDrink.setHorizontalAlignment(SwingConstants.CENTER);
		lbDrink.setBounds(186, 5, 68, 15);
		drinkPanel.add(lbDrink);
		
		lbCoke = new JLabel("Coca Cola");
		lbCoke.setHorizontalAlignment(SwingConstants.CENTER);
		lbCoke.setBounds(67, 38, 125, 15);
		drinkPanel.add(lbCoke);
		
		picCola = new JLabel("");
		picCola.setIcon(new ImageIcon(Kiosk.class.getResource("/image/코카콜라 크기조정.png")));
		picCola.setBounds(57, 63, 154, 148);
		drinkPanel.add(picCola);
		
		btnCoke = new JButton("Add Cart");
		//when btnCoke is clicked, it addes coke to table with chosen options.
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drink coke = new Drink(1800);
				coke.setName("Coca Cola");
				//this if statement controls over the options that user selected for coke.
				if (chckColaLarge.isSelected()) {
					coke.setLarge(true);
					coke.setOption("+Large ");
				}
				if (chckColaNoIce.isSelected()) {
					coke.setNoIce(true);
					coke.setOption("+No ice ");
				}
				coke.calculateCost();
				setTotalCost(coke.getTotalCost());
				String[] rows = new String[3];
				rows[0] = coke.getName();
				rows[1] = coke.getOption();
				rows[2] = coke.getTotalCost()+"";
				buyList.addRow(rows);
				tfTotalCost.setText(getTotalCost()+"");
				chckColaLarge.setSelected(false);
				chckColaNoIce.setSelected(false);
			}
		});
		btnCoke.setBounds(127, 221, 85, 23);
		drinkPanel.add(btnCoke);
		
		lbSprite = new JLabel("Sprite");
		lbSprite.setHorizontalAlignment(SwingConstants.CENTER);
		lbSprite.setBounds(67, 268, 125, 15);
		drinkPanel.add(lbSprite);
		
		picSprite = new JLabel("");
		picSprite.setIcon(new ImageIcon(Kiosk.class.getResource("/image/스프라이트 크기조정.png")));
		picSprite.setBounds(57, 293, 154, 148);
		drinkPanel.add(picSprite);
		
		btnSprite = new JButton("Add Cart");
		//when btnSprite is clicked, it addes sprite to table with chosen options.
		btnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drink sprite = new Drink(1800);
				sprite.setName("Sprite");
				//this if statement controls over the options that user selected for sprite.
				if (chckSpriteLarge.isSelected()) {
					sprite.setLarge(true);
					sprite.setOption("+Large ");
				}
				if (chckSpriteNoIce.isSelected()) {
					sprite.setNoIce(true);
					sprite.setOption("+No ice ");
				}
				sprite.calculateCost();
				setTotalCost(sprite.getTotalCost());
				String[] rows = new String[3];
				rows[0] = sprite.getName();
				rows[1] = sprite.getOption();
				rows[2] = sprite.getTotalCost()+"";
				buyList.addRow(rows);
				tfTotalCost.setText(getTotalCost()+"");
				chckSpriteLarge.setSelected(false);
				chckSpriteNoIce.setSelected(false);
			}
		});
		btnSprite.setBounds(127, 451, 85, 23);
		drinkPanel.add(btnSprite);
		
		lbColaPrice = new JLabel("2000won");
		lbColaPrice.setBounds(67, 225, 57, 15);
		drinkPanel.add(lbColaPrice);
		
		lbSpritePrice = new JLabel("2000won");
		lbSpritePrice.setBounds(67, 455, 57, 15);
		drinkPanel.add(lbSpritePrice);
		
		chckColaLarge = new JCheckBox("Large (+1000won)");
		chckColaLarge.setBounds(259, 55, 146, 23);
		drinkPanel.add(chckColaLarge);
		
		chckSpriteLarge = new JCheckBox("Large (+1000won)");
		chckSpriteLarge.setBounds(259, 285, 146, 23);
		drinkPanel.add(chckSpriteLarge);
		
		chckColaNoIce = new JCheckBox("No Ice");
		chckColaNoIce.setBounds(259, 80, 165, 23);
		drinkPanel.add(chckColaNoIce);
		
		chckSpriteNoIce = new JCheckBox("No Ice");
		chckSpriteNoIce.setBounds(259, 310, 165, 23);
		drinkPanel.add(chckSpriteNoIce);
		
		sidePanel = new JPanel();
		sidePanel.setBounds(0, 0, 481, 510);
		layeredPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		lbSide = new JLabel("Side");
		lbSide.setBounds(228, 5, 25, 15);
		sidePanel.add(lbSide);
		
		lbFries = new JLabel("French Fries");
		lbFries.setHorizontalAlignment(SwingConstants.CENTER);
		lbFries.setBounds(67, 40, 125, 15);
		sidePanel.add(lbFries);
		
		picFries = new JLabel("");
		picFries.setIcon(new ImageIcon(Kiosk.class.getResource("/image/감튀 크기조정.png")));
		picFries.setBounds(57, 65, 154, 148);
		sidePanel.add(picFries);
		
		btnFries = new JButton("Add Cart");
		//when btnFries is clicked, it addes fires to table with chosen options.
		btnFries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Side fries = new Side(1800);
				fries.setName("French Fries");
				//this if statement controls over the options that user selected for fries.
				if (chckFiresLarge.isSelected()) {
					fries.setLarge(true);
					fries.setOption("+Large");
				}
				fries.calculateCost();
				setTotalCost(fries.getTotalCost());
				String[] rows = new String[3];
				rows[0] = fries.getName();
				rows[1] = fries.getOption();
				rows[2] = fries.getTotalCost()+"";
				buyList.addRow(rows);
				tfTotalCost.setText(getTotalCost()+"");
				chckFiresLarge.setSelected(false);
			}
		});
		btnFries.setBounds(127, 221, 85, 23);
		sidePanel.add(btnFries);
		
		lbMacNudget = new JLabel("MacNudget");
		lbMacNudget.setHorizontalAlignment(SwingConstants.CENTER);
		lbMacNudget.setBounds(67, 270, 125, 15);
		sidePanel.add(lbMacNudget);
		
		picNudget = new JLabel("");
		picNudget.setIcon(new ImageIcon(Kiosk.class.getResource("/image/정맥너겟 크기조.png")));
		picNudget.setBounds(57, 295, 154, 148);
		sidePanel.add(picNudget);
		
		btnMacNudget = new JButton("Add Cart");
		//when btnMacNudget is clicked, it addes MacNudget to table with chosen options.
		btnMacNudget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Side nudget = new Side(1800);
				nudget.setName("MacNudget");
				//this if statement controls over the options that user selected for MacNudget.
				if (chckNudgetLarge.isSelected()) {
					nudget.setLarge(true);
					nudget.setOption("+Large");
				}
				nudget.calculateCost();
				setTotalCost(nudget.getTotalCost());
				String[] rows = new String[3];
				rows[0] = nudget.getName();
				rows[1] = nudget.getOption();
				rows[2] = nudget.getTotalCost()+"";
				buyList.addRow(rows);
				tfTotalCost.setText(getTotalCost()+"");
				chckNudgetLarge.setSelected(false);
			}
		});
		btnMacNudget.setBounds(127, 451, 85, 23);
		sidePanel.add(btnMacNudget);
		
		lbPotatoPrice = new JLabel("1800won");
		lbPotatoPrice.setBounds(67, 227, 57, 15);
		sidePanel.add(lbPotatoPrice);
		
		lbNudgetPrice = new JLabel("1800won");
		lbNudgetPrice.setBounds(67, 457, 57, 15);
		sidePanel.add(lbNudgetPrice);
		
		chckFiresLarge = new JCheckBox("large (+1000won)");
		chckFiresLarge.setBounds(259, 55, 146, 23);
		sidePanel.add(chckFiresLarge);
		
		chckNudgetLarge = new JCheckBox("large (+1000won)");
		chckNudgetLarge.setBounds(259, 285, 146, 23);
		sidePanel.add(chckNudgetLarge);
		
		hamburgerPanel = new JPanel();
		hamburgerPanel.setBackground(Color.WHITE);
		hamburgerPanel.setBounds(0, 0, 481, 510);
		layeredPane.add(hamburgerPanel);
		hamburgerPanel.setLayout(null);
		
		picBigMac = new JLabel("");
		picBigMac.setIcon(new ImageIcon(Kiosk.class.getResource("/image/빅맥 사이즈 조정.png")));
		picBigMac.setBounds(58, 63, 154, 148);
		hamburgerPanel.add(picBigMac);
		
		lbHamburger = new JLabel("Hamburger");
		lbHamburger.setBounds(206, 10, 70, 15);
		hamburgerPanel.add(lbHamburger);
		
		picBulgogi = new JLabel("");
		picBulgogi.setIcon(new ImageIcon(Kiosk.class.getResource("/image/불고기 크기조정.png")));
		picBulgogi.setBounds(58, 293, 154, 148);
		hamburgerPanel.add(picBulgogi);
		
		btnBigMac = new JButton("Add Cart");
		//when btnBigMac is clicked, it addes bigMac to table with chosen options.
		btnBigMac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hamburger bigMac = new Hamburger(4000);
				bigMac.setName("BigMac");
				//this if statement controls over the options that user selected for BigMac.
				if (chckBMBun.isSelected()) {
					bigMac.setBrioshBun(true);
					bigMac.setOption("+Briosh Bun");
				}
				bigMac.calculateCost();
				setTotalCost(bigMac.getTotalCost());
				String[] rows = new String[3];
				rows[0] = bigMac.getName();
				rows[1] = bigMac.getOption();
				rows[2] = bigMac.getTotalCost()+"";
				buyList.addRow(rows);
				tfTotalCost.setText(getTotalCost()+"");
				chckBMBun.setSelected(false);
			}
		});
		btnBigMac.setBounds(127, 221, 85, 23);
		hamburgerPanel.add(btnBigMac);
		
		btnBulgogi = new JButton("Add Cart");
		//when btnBulgogi is clicked, it addes bulgogi burger to table with chosen options.
		btnBulgogi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hamburger bulgogi = new Hamburger(3000);
				bulgogi.setName("Bulgogi Burger");
				//this if statement controls over the options that user selected for bulgogi burger.
				if (chckBGGBun.isSelected()) {
					bulgogi.setBrioshBun(true);
					bulgogi.setOption("+Briosh Bun");
				}
				bulgogi.calculateCost();
				setTotalCost(bulgogi.getTotalCost());
				String[] rows = new String[3];
				rows[0] = bulgogi.getName();
				rows[1] = bulgogi.getOption();
				rows[2] = bulgogi.getTotalCost()+"";
				buyList.addRow(rows);
				chckBGGBun.setSelected(false);
			}
		});
		btnBulgogi.setBounds(127, 451, 85, 23);
		hamburgerPanel.add(btnBulgogi);
		
		lbBigMac = new JLabel("Big Mac");
		lbBigMac.setHorizontalAlignment(SwingConstants.CENTER);
		lbBigMac.setBounds(68, 38, 125, 15);
		hamburgerPanel.add(lbBigMac);
		
		lbBulgogiBurger = new JLabel("Bulgogi Burger");
		lbBulgogiBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lbBulgogiBurger.setBounds(68, 268, 125, 15);
		hamburgerPanel.add(lbBulgogiBurger);
		
		lbBigMacPrice = new JLabel("4000 won");
		lbBigMacPrice.setBounds(58, 225, 57, 15);
		hamburgerPanel.add(lbBigMacPrice);
		
		lbBGGPrice = new JLabel("3000 won");
		lbBGGPrice.setBounds(58, 455, 57, 15);
		hamburgerPanel.add(lbBGGPrice);
		
		chckBMBun = new JCheckBox("Briosh Bun (+1000won)");
		chckBMBun.setBounds(259, 55, 146, 23);
		hamburgerPanel.add(chckBMBun);
		
		chckBGGBun = new JCheckBox("Briosh Bun (+1000won)");
		chckBGGBun.setBounds(259, 285, 146, 23);
		hamburgerPanel.add(chckBGGBun);
		
		String header[] = {"Name","Quantity","Price"};
		String content[][] = {};
		buyList = new DefaultTableModel(new String[] {"Name", "Option", "Price"}, 0);
		table = new JTable(buyList);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(122, 595, 480, 175);
		contentPane.add(scrollPane);
		
		lbTotalCost = new JLabel("Total Cost: ");
		lbTotalCost.setForeground(Color.YELLOW);
		lbTotalCost.setFont(new Font("굴림", Font.BOLD, 15));
		lbTotalCost.setBounds(121, 783, 98, 15);
		contentPane.add(lbTotalCost);
		
		tfTotalCost = new JTextField();
		tfTotalCost.setEditable(false);
		tfTotalCost.setBounds(205, 780, 108, 21);
		contentPane.add(tfTotalCost);
		tfTotalCost.setColumns(10);
		
		lblYourPayment = new JLabel("Your Payment:");
		lblYourPayment.setForeground(Color.YELLOW);
		lblYourPayment.setFont(new Font("굴림", Font.BOLD, 15));
		lblYourPayment.setBounds(325, 783, 127, 15);
		contentPane.add(lblYourPayment);
		
		tfPayment = new JTextField();
		tfPayment.setColumns(10);
		tfPayment.setBounds(441, 780, 108, 21);
		contentPane.add(tfPayment);
		
		btnPay = new JButton("Pay");
		//when btnPay is clicked, it calculates the price and payment, and when payment is higher than price, it writes receipt file and total sales file.
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int payment = Integer.parseInt(tfPayment.getText());//it saves user input coming from tfPayment textfield, and changes type to int.
					int price = Integer.parseInt(tfTotalCost.getText());//it saves user input coming from tfTotalCost textfield, and changes type to int
					// if user input of payment is not the type int, it throws NumberFormatException and error message appears.
					// if the payment is lower than actual price, it throws PriceAbovePaymentException and error message appears.
					if (price > payment) {
						throw new PriceAbovePaymentException();
					}
					setCustomerNum(getCustomerNum()+1);
					FileOutputStream fileObject1 = new FileOutputStream("total_sales.txt", false);
					PrintWriter writer1 = new PrintWriter(fileObject1);
					int addedTotal = getSales() + price; //it saves value that is sum of sales which contains overall sales and price that the user bought.
					writer1.print(addedTotal+"\n");
					writer1.print(getCustomerNum()+"\n");
					writer1.close();
					fileObject1.close();
					FileOutputStream fileObject2 = new FileOutputStream("receipt"+getCustomerNum()+".txt", false);
					PrintWriter writer2 = new PrintWriter(fileObject2);
					int rowCount = buyList.getRowCount();
					int columnCount = buyList.getColumnCount();
					int change = payment-price;
					// this for loop collects substances in table and write it to the file.
					for (int row =0;row<rowCount;row++) {
						for (int column = 0; column<columnCount;column++) {
							Object value = buyList.getValueAt(row, column);
							String valueStr = String.valueOf(value);
							writer2.print(valueStr+"\n");
						}
					}

					writer2.print("Total Price: "+price+"\n");			
					writer2.print("Your Payment: "+payment+"\n");	
					writer2.print("Change: "+change+"\n");
					writer2.close();
					fileObject2.close();
					countDownOrder.stop();
					JOptionPane.showMessageDialog(null, "Thank you for enjoying our meal!");
					FirstScreen screen = new FirstScreen();
					screen.setVisible(true);
					dispose();
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "You should select product and enter with integer number.","Error Message", JOptionPane.ERROR_MESSAGE);
				} catch(PriceAbovePaymentException e2) {
					JOptionPane.showMessageDialog(null, "You have not enough money to buy the products.","Error Message", JOptionPane.ERROR_MESSAGE);
				} catch(IOException e3) {
					e3.printStackTrace();
				}
			}
		});
		btnPay.setBounds(551, 779, 63, 23);
		contentPane.add(btnPay);
		
		btnDeleteAll = new JButton("Delete All");
		// when btnDeleteAll is clicked, all the things that user chose are deleted and table is cleared.
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyList.setNumRows(0);
				clearTotalCost();
				tfTotalCost.setText(getTotalCost()+"");
			}
		});
		btnDeleteAll.setBounds(12, 747, 97, 23);
		contentPane.add(btnDeleteAll);
		
		btnDelete = new JButton("Delete");
		// when user chose certain thing in table and press btnDelete, it only deletes the chosen one.
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if nothing is chosen in the table, nothing happens.
				if(table.getSelectedRow()==-1) {
					return;
				}
				else {
					int row = table.getSelectedRow();
					String value = String.valueOf(table.getValueAt(row, 2));
					int intValue = Integer.parseInt(value);
					buyList.removeRow(table.getSelectedRow());
					setTotalCost(-intValue);
					tfTotalCost.setText(getTotalCost()+"");
				}
			}
		});
		btnDelete.setBounds(12, 725, 97, 23);
		contentPane.add(btnDelete);
		
		picLogo = new JLabel("");
		picLogo.setIcon(new ImageIcon(Kiosk.class.getResource("/image/로고2.png")));
		picLogo.setBounds(37, 10, 63, 55);
		contentPane.add(picLogo);
		
		timeText = new JTextField();
		timeText.setBounds(522, 32, 80, 28);
		contentPane.add(timeText);
		timeText.setColumns(10);
		timeText.setEditable(false);
		
		lbTime = new JLabel("Time left: ");
		lbTime.setBounds(439, 35, 86, 22);
		contentPane.add(lbTime);
		
	}
	
	// this thread counts down 30 seconds for user choosing their meals. if count down is over, time expires message appears and return to first screen.
	class countDownKiosk implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//this for loop counts down 30 seconds.
			for (int i =100;i>=0;i--) {
				try {
					getTimeText().setText(i+"");
					Thread.sleep(1000);


				} catch(Exception e) {
					
				}
			}
			JOptionPane.showMessageDialog(null, "Time expires! Please order again.");
			FirstScreen screen = new FirstScreen();
			screen.setVisible(true);
			dispose();
		}
		
	}
}


