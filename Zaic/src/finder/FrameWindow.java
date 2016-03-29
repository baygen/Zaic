package finder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.util.Locale;

public class FrameWindow {

	private static Date date= new Date();
	static JListM jlistm = new JListM();
	static JListTodayPacient todayPacient = new JListTodayPacient();
	static JList<PacientClass> list;
	private static JList<DataPacienta> listData;
	static JList<PacClassToday> list_Today;
	private static JButton btnNewPacient, btnDelpac, btnSave ;
	private static JLabel lblTodaypacient;
	private static JTextField txtFamilia,txtName,textField,txtDiagnoz;
	static MapPacient mapPacient= new MapPacient();
	private static JComboBox<Integer> cBday, cBmonth, cByear;
	static JComboBox<Double> cBtime;

	
	public  FrameWindow() {
		MainWindow();
//		newPacientFrame();
	}
	
	public static void MainWindow(){
		JFrame mainframe = new JFrame("MainFrame");
		mainframe.setLocale(new Locale("uk", "UA"));
		mainframe.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		mainframe.getContentPane().setBackground(new Color(255, 250, 205));
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setLocation(80, 80);;
		mainframe.setSize(1080, 800);
		mainframe.setVisible(true);
		
		@SuppressWarnings("deprecation")
		int year = date.getYear() + 1900;
		@SuppressWarnings("deprecation")
		int month = date.getMonth()+1;
		@SuppressWarnings({ "deprecation", "unused" })
		String datestr = " " + date.getDate()+"."+0+month+"."+year;
		SpringLayout springLayout = new SpringLayout();
		mainframe.getContentPane().setLayout(springLayout);
		
		list = new JList<PacientClass>();
		springLayout.putConstraint(SpringLayout.NORTH, list, 46, SpringLayout.NORTH, mainframe.getContentPane());
		list.setForeground(new Color(0, 0, 0));
		list.setModel(jlistm);
		list.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(255, 255, 255), new Color(105, 105, 105), new Color(255, 255, 255)));
		list.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		list.setBackground(new Color(224, 255, 255));
		mainframe.getContentPane().add(list);
		
		lblTodaypacient = new JLabel(" \u0421\u044C\u043E\u0433\u043E\u0434\u043D\u0456 : 16.03.2016 ");
		springLayout.putConstraint(SpringLayout.NORTH, lblTodaypacient, 10, SpringLayout.NORTH, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblTodaypacient, -130, SpringLayout.EAST, mainframe.getContentPane());
		lblTodaypacient.setForeground(new Color(0, 0, 0));
		lblTodaypacient.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mainframe.getContentPane().add(lblTodaypacient);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, list, -302, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, list, -6, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTodaypacient, -6, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 195, SpringLayout.NORTH, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, -298, SpringLayout.EAST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 46, SpringLayout.NORTH, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, mainframe.getContentPane());
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(85, 107, 47), new Color(0, 0, 0), new Color(85, 107, 47), new Color(0, 0, 0)));
		panel.setBackground(new Color(154, 205, 50));
		mainframe.getContentPane().add(panel);
		JLabel label_1 = new JLabel("                         ");		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));		panel.add(label_1);
		
		btnNewPacient = new JButton("       \u0420\u0435\u0434\u0430\u0433\u0443\u0432\u0430\u0442\u0438 \u0434\u0430\u043D\u0456 \u043F\u0430\u0446\u0456\u0435\u043D\u0442\u0430    ");
		btnNewPacient.setForeground(new Color(0, 0, 0));
		btnNewPacient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newPacientFrame();
			}
		});
		btnNewPacient.setBackground(UIManager.getColor("Button.light"));
		btnNewPacient.setVerticalAlignment(SwingConstants.TOP);
		panel.add(btnNewPacient);
		springLayout.putConstraint(SpringLayout.WEST, btnNewPacient, 47, SpringLayout.EAST, list);
		btnNewPacient.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewPacient, 0, SpringLayout.NORTH, list);
		
		JLabel label_3 = new JLabel("                                             ");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(label_3);
		
		
		btnDelpac = new JButton("\u0412\u0438\u0434\u0430\u043B\u0435\u043D\u043D\u044F \u0434\u0430\u043D\u0438\u0445 \u043F\u0430\u0446\u0456\u0435\u043D\u0442\u0430");
		panel.add(btnDelpac);
		springLayout.putConstraint(SpringLayout.NORTH, btnDelpac, 147, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, btnDelpac, -151, SpringLayout.EAST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDelpac, -56, SpringLayout.EAST, mainframe.getContentPane());
		
		btnDelpac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{MapPacient.mapa.remove(list.getSelectedValue());
				jlistm.RemovePac(list.getSelectedValue());
				JListTodayPacient.todayMap.get(JListTodayPacient.dateToPac()).remove(list_Today.getSelectedValue());
				}catch(NullPointerException e){System.out.println("non data to delete");}
				MapPacient.save(MapPacient.mapa,"mapas");
				MapPacient.save(JListM.PacientList,"lists");
				MapPacient.save(JListTodayPacient.todayMap,"todays");
				list.updateUI();
				list_Today.updateUI();
				JOptionPane.showMessageDialog(null, "Del complete");
			}
		});
		
		listData = new JList<DataPacienta>();
		springLayout.putConstraint(SpringLayout.SOUTH, list, 0, SpringLayout.SOUTH, listData);
		springLayout.putConstraint(SpringLayout.EAST, listData, 340, SpringLayout.WEST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listData, 748, SpringLayout.NORTH, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, listData, 469, SpringLayout.NORTH, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, listData, 30, SpringLayout.WEST, mainframe.getContentPane());
		listData.setForeground(new Color(0, 0, 0));
		listData.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		listData.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(105, 105, 105), new Color(255, 255, 255), new Color(105, 105, 105), new Color(255, 255, 255)));
		listData.setBackground(new Color(245, 255, 250));
		mainframe.getContentPane().add(listData);
		
		JLabel lblDataPacient = new JLabel("Data Pacient");
		springLayout.putConstraint(SpringLayout.WEST, lblDataPacient, 30, SpringLayout.WEST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDataPacient, -342, SpringLayout.WEST, list);
		lblDataPacient.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataPacient.setForeground(Color.BLACK);
		lblDataPacient.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mainframe.getContentPane().add(lblDataPacient);
		
		list_Today = new JList<PacClassToday>();
		springLayout.putConstraint(SpringLayout.WEST, list_Today, 30, SpringLayout.WEST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list_Today, 0, SpringLayout.EAST, listData);
		list_Today.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(105, 105, 105), new Color(255, 255, 255), new Color(105, 105, 105), new Color(255, 255, 255)));
		list_Today.setForeground(Color.BLACK);
		list_Today.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		list_Today.setBackground(new Color(240, 255, 255));
		list_Today.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JListDataPacient d = new JListDataPacient();
				listData.setModel(d);
				listData.updateUI();					}
		});
		mainframe.getContentPane().add(list_Today);
		list_Today.setModel(todayPacient);
		list_Today.updateUI();
		
		JLabel label = new JLabel("\u0421\u043F\u0438\u0441\u043E\u043A \u0443\u0441\u0456\u0445 \u043F\u0430\u0446\u0456\u0435\u043D\u0442\u0456\u0432:");
		springLayout.putConstraint(SpringLayout.WEST, lblTodaypacient, 6, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, -629, SpringLayout.EAST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.EAST, label, -304, SpringLayout.EAST, mainframe.getContentPane());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Times New Roman", Font.BOLD, 17));
		mainframe.getContentPane().add(label);
		
		JLabel label_4 = new JLabel("\u0414\u0430\u043D\u0456 \u043F\u0430\u0446\u0456\u0435\u043D\u0442\u0430:            ");
		springLayout.putConstraint(SpringLayout.WEST, label_4, 30, SpringLayout.WEST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_4, -227, SpringLayout.WEST, list);
		springLayout.putConstraint(SpringLayout.SOUTH, list_Today, -18, SpringLayout.NORTH, label_4);
		springLayout.putConstraint(SpringLayout.NORTH, lblDataPacient, 2, SpringLayout.SOUTH, label_4);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDataPacient, -32, SpringLayout.NORTH, label_4);
		springLayout.putConstraint(SpringLayout.NORTH, label_4, 433, SpringLayout.NORTH, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label_4, 463, SpringLayout.NORTH, mainframe.getContentPane());
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mainframe.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u0421\u043F\u0438\u0441\u043E\u043A \u043F\u0430\u0446\u0456\u0435\u043D\u0442\u0456\u0432 \u043D\u0430 \u0441\u044C\u043E\u0433\u043E\u0434\u043D\u0456:");
		springLayout.putConstraint(SpringLayout.WEST, label_5, 40, SpringLayout.WEST, mainframe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label_5, -131, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.NORTH, list_Today, 6, SpringLayout.SOUTH, label_5);
		springLayout.putConstraint(SpringLayout.SOUTH, label_5, 40, SpringLayout.NORTH, mainframe.getContentPane());
		label_5.setForeground(new Color(0, 0, 0));
		springLayout.putConstraint(SpringLayout.NORTH, label_5, 10, SpringLayout.NORTH, mainframe.getContentPane());
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mainframe.getContentPane().add(label_5);
	}
	
	@SuppressWarnings("deprecation")
	private static void newPacientFrame() {
		JFrame frame = new JFrame("New Pacient");
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.setLocation(500, 200);;
		frame.setSize(265, 362);
		frame.getContentPane().setLayout(null);
		
		txtFamilia = new JTextField();
		if(list.getSelectedValue()!=null){
			txtFamilia.setText(list.getSelectedValue().getFamilia());		}
		txtFamilia.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtFamilia.setBounds(90, 11, 159, 20);
		frame.getContentPane().add(txtFamilia);
		txtFamilia.setColumns(10);
		
		txtName = new JTextField();
		if(list.getSelectedValue()!=null){
			txtName.setText(list.getSelectedValue().getName());		}
		txtName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtName.setColumns(10);
		txtName.setBounds(90, 42, 159, 20);
		frame.getContentPane().add(txtName);
		
		textField = new JTextField();
		if(list.getSelectedValue()!=null){
			textField.setText(""+list.getSelectedValue().getAge());		}
		textField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBounds(90, 73, 159, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblFamilia = new JLabel("\u0424\u0430\u043C\u0456\u043B\u0456\u044F :");
		lblFamilia.setForeground(new Color(0, 0, 0));
		lblFamilia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblFamilia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFamilia.setBounds(10, 14, 70, 17);
		frame.getContentPane().add(lblFamilia);
		
		JLabel label = new JLabel("\u0406\u043C'\u044F:");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 45, 70, 17);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0412\u0456\u043A:");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setBackground(new Color(255, 0, 255));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 76, 70, 17);
		frame.getContentPane().add(label_1);
		
		btnSave = new JButton("\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				PacientClass pac = new PacientClass(txtFamilia.getText(), "", txtName.getText(), Integer.parseInt(textField.getText()));
				PacDate dates = new PacDate((int)cByear.getSelectedItem(),(int) cBmonth.getSelectedItem(), (int)cBday.getSelectedItem());
				DataPacienta dat = new DataPacienta(dates, txtDiagnoz.getText(),(double) cBtime.getSelectedItem());
				PacClassToday pactoday =new PacClassToday(txtFamilia.getText(), "", txtName.getText(), Integer.parseInt(textField.getText()), (double) cBtime.getSelectedItem());
				
				if(MapPacient.equalsHour(dates, (double) cBtime.getSelectedItem())){
					JOptionPane.showMessageDialog(null, "ќбрана година "+dates+" Ї зан€та!");
					return;
				}else{
				JListTodayPacient.puttoTodaymap(dates, pactoday);
				MapPacient.newPacient(pac, dat);
				
				try{
					if(JListM.PacientList.contains(pac)==false){
					JListM.PacientList.add(pac);}
				}catch(NullPointerException exe){System.out.println("Create List");JListM.PacientList =new ArrayList<PacientClass>();JListM.PacientList.add(pac); }
				}
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(null, "¬вед≥ть число у строку в≥к");
					return;
				}
				MapPacient.save(JListM.PacientList, "lists");
				list_Today.updateUI();
				list.updateUI();
				JOptionPane.showMessageDialog(null, "Adding complete!");
			}
		});
		btnSave.setBackground(UIManager.getColor("Button.highlight"));
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.setBounds(129, 294, 120, 23);
		frame.getContentPane().add(btnSave);
		
		cBday = new JComboBox<Integer>();
		cBday.setForeground(new Color(0, 0, 0));
		cBday.setBackground(new Color(245, 255, 250));
		for(int i=1;i<32;i++){
		cBday.addItem(i);	}
		cBday.setSelectedIndex((date.getDate()-1));
		cBday.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cBday.setBounds(129, 160, 120, 20);
		frame.getContentPane().add(cBday);
		
		cBmonth = new JComboBox<Integer>();
		cBmonth.setForeground(new Color(0, 0, 0));
		cBmonth.setBackground(new Color(255, 255, 255));
		cBmonth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		for(int i=1;i<13;i++){
			cBmonth.addItem(i);	}
		cBmonth.setSelectedIndex(date.getMonth());
		cBmonth.setBounds(129, 187, 120, 20);
		frame.getContentPane().add(cBmonth);
		
		cByear = new JComboBox<Integer>();
		cByear.setForeground(new Color(0, 0, 0));
		cByear.setBackground(new Color(255, 255, 255));
		cByear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		for(int i=2014;i<2022;i++){
			cByear.addItem(i);	}
		cByear.setSelectedIndex((date.getYear()-114));
		cByear.setBounds(129, 214, 120, 20);
		frame.getContentPane().add(cByear);
		
		JLabel label_2 = new JLabel("\u0427\u0438\u0441\u043B\u043E \u043C\u0456\u0441\u044F\u0446\u044F:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_2.setBackground(Color.MAGENTA);
		label_2.setBounds(10, 160, 109, 20);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u041C\u0456\u0441\u044F\u0446\u044C:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_3.setBackground(Color.MAGENTA);
		label_3.setBounds(10, 187, 109, 20);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u0420\u0456\u043A:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_4.setBackground(Color.MAGENTA);
		label_4.setBounds(10, 214, 109, 20);
		frame.getContentPane().add(label_4);
		
		JLabel lblDiagnoz = new JLabel("\u0422\u0435\u043B\u0435\u0444\u043E\u043D:");
		lblDiagnoz.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiagnoz.setForeground(Color.BLACK);
		lblDiagnoz.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDiagnoz.setBounds(10, 104, 70, 20);
		frame.getContentPane().add(lblDiagnoz);
		
		txtDiagnoz = new JTextField();
		txtDiagnoz.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		txtDiagnoz.setColumns(10);
		txtDiagnoz.setBounds(90, 104, 159, 20);
		frame.getContentPane().add(txtDiagnoz);
		
		JLabel lblChooseDataPryjom = new JLabel("\u0412\u0438\u0431\u0435\u0440\u0456\u0442\u044C \u0434\u0430\u0442\u0443 \u043F\u0440\u0438\u0439\u043E\u043C\u0443:");
		lblChooseDataPryjom.setForeground(Color.BLACK);
		lblChooseDataPryjom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblChooseDataPryjom.setBounds(10, 135, 185, 20);
		frame.getContentPane().add(lblChooseDataPryjom);
		
		JLabel label_5 = new JLabel("\u0413\u043E\u0434\u0438\u043D\u0430 \u043F\u0440\u0438\u0439\u043E\u043C\u0443:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_5.setBackground(Color.MAGENTA);
		label_5.setBounds(10, 240, 109, 20);
		frame.getContentPane().add(label_5);
		
		cBtime = new JComboBox<Double>();
		cBtime.setForeground(new Color(0, 0, 0));
		cBtime.setBackground(new Color(255, 255, 255));
		cBtime.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		for(int i=9;i<19;i++){
			double t =.3;
			t = t+i;
			cBtime.addItem((double) i);
			cBtime.addItem(t);
		}
		cBtime.setBounds(129, 241, 120, 20);
		frame.getContentPane().add(cBtime);
		frame.setVisible(true);
	}
	
	public static void newSaanse() {
		JFrame frame = new JFrame("New seanse");
		frame.setVisible(true);
		
	}
}
