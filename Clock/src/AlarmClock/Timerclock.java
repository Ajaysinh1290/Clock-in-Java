package AlarmClock;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Timerclock extends JFrame implements ActionListener,KeyListener
{

	private JPanel contentPane;
	private JTextField hourtext,minutetext,secondstext;
	private JButton start,btnback;
	private JComboBox secondcombo,minutecombo;
	private static int hour=0,seconds=0,minutes=15;
	private static String strhour,strminute,strseconds;
	private String  hourarr[]= {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
	private String  minutearr[]= {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
			"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
	private String  secondarr[]= {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
			"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
	private JComboBox hourcombo;
	private JLabel label;
	private JLabel label_1;
	private boolean alarmstart=false;
	private JLabel message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timerclock frame = new Timerclock();
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
	public Timerclock() {
		addKeyListener(this);
		setFocusable(true);
		
		Timer timer=new Timer(1000,this);
		timer.start();
		setTitle("Timer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		hourcombo = new JComboBox(hourarr);
		hourcombo.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		hourcombo.setBackground(new Color(255, 255, 255));
		hourcombo.setBounds(69, 141, 78, 60);
		contentPane.add(hourcombo);
		hourcombo.setVisible(true);
		
	 minutecombo = new JComboBox(minutearr);
	 minutecombo.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		minutecombo.setBackground(new Color(255, 255, 255));
		minutecombo.setBounds(204, 141, 78, 60);
		contentPane.add(minutecombo);
		minutecombo.setVisible(true);
		minutecombo.setSelectedIndex(1);
		
		
		 secondcombo = new JComboBox(secondarr);
		 secondcombo.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		secondcombo.setBackground(new Color(255, 255, 255));
		secondcombo.setBounds(329, 141, 78,60);
		contentPane.add(secondcombo);
		secondcombo.setVisible(true);		
		JLabel lblTimer = new JLabel("Timer");
		lblTimer.setForeground(new Color(0, 0, 128));
		lblTimer.setFont(new Font("Square721 BT", Font.BOLD, 25));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(0, 43, 484, 34);
		contentPane.add(lblTimer);
		
		 start = new JButton("Start");
		start.setForeground(new Color(255, 255, 255));
		start.setBackground(new Color(0, 128, 128));
		start.setBounds(119, 231, 103, 43);
		contentPane.add(start);
		start.addActionListener(this);
		start.setFont(new Font("Calibri", Font.PLAIN, 17));
		start.setFocusPainted(false);
		
		 btnback = new JButton("Back");
		btnback.setForeground(Color.WHITE);
		btnback.setBackground(new Color(0, 128, 128));
		btnback.setBounds(243, 231, 103, 43);
		contentPane.add(btnback);
		btnback.addActionListener(this);
		btnback.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnback.setFocusPainted(false);

		hourtext = new JTextField();
		hourtext.setBounds(69, 141, 78, 60);
		contentPane.add(hourtext);
		hourtext.setColumns(10);

		hourtext.setHorizontalAlignment(SwingConstants.CENTER);
		hourtext.setFont(new Font("Square721 BT", Font.BOLD, 25));
		hourtext.setForeground(Color.white);
		hourtext.setBackground(Color.gray);
		hourtext.setVisible(false);

		minutetext = new JTextField();
		minutetext.setBounds(204, 141, 78, 60);
		contentPane.add(minutetext);
		minutetext.setColumns(10);

		minutetext.setHorizontalAlignment(SwingConstants.CENTER);
		minutetext.setFont(new Font("Square721 BT", Font.BOLD, 25));
		minutetext.setForeground(Color.white);
		minutetext.setBackground(Color.gray);
		minutetext.setVisible(false);
		
		secondstext = new JTextField();
		secondstext.setBounds(329, 141, 78, 60);
		contentPane.add(secondstext);
		secondstext.setColumns(10);

		secondstext.setHorizontalAlignment(SwingConstants.CENTER);
		secondstext.setFont(new Font("Square721 BT", Font.BOLD, 25));
		secondstext.setForeground(Color.white);
		secondstext.setBackground(Color.gray);
		
		label = new JLabel(":");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(148, 156, 46, 27);
		contentPane.add(label);
		
		label_1 = new JLabel(":");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(284, 156, 46, 27);
		contentPane.add(label_1);
		
		message = new JLabel("");
		message.setForeground(new Color(255, 0, 0));
		message.setBackground(new Color(255, 0, 0));
		message.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(10, 414, 452, 36);
		contentPane.add(message);
		secondstext.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==btnback)
		{
			if(btnback.getText()=="Back")
			{
			main m=new main();
			m.setVisible(true);
			this.dispose();
			}
			else if(btnback.getText()=="Pause")
			{
				alarmstart=false;
				btnback.setText("Continue");
				
			}
			else if(btnback.getText()=="Continue")
			{
				alarmstart=true;
				btnback.setText("Pause");
				seconds++;
				
			}
		}
		if(e.getSource()==start)
		{
			if(start.getText()=="Start")
			{
				hour=hourcombo.getSelectedIndex();
				minutes=minutecombo.getSelectedIndex();
				seconds=secondcombo.getSelectedIndex();

				
				if(hour==0 && minutes==0 &&seconds<10)
				{
					message.setText("Minimum Timer limit is 10 seconds");
				}
				else
				{
					message.setText("");
				alarmstart=true;
				hourcombo.setVisible(false);
				hourtext.setVisible(true);
				hourtext.setEditable(false);
			
			
			
				minutecombo.setVisible(false);
				minutetext.setVisible(true);
				minutetext.setEditable(false);
				minutetext.setText(""+minutecombo.getSelectedItem());
			


			
					secondcombo.setVisible(false);
					secondstext.setVisible(true);
					secondstext.setEditable(false);
					secondstext.setText(""+secondcombo.getSelectedItem());
					
				
					start.setText("Cancel");
					start.setBackground(Color.red);
					start.setForeground(Color.white);
					btnback.setText("Pause");
					btnback.setBackground(Color.white);
					btnback.setForeground(Color.black);
			}
			
			}
			else if(start.getText()=="Cancel")
			{
				alarmstart=false;
				btnback.setText("Back");
				btnback.setForeground(new Color(255, 255, 255));
				btnback.setBackground(new Color(0, 128, 128));
			
				
				start.setText("Start");
				start.setForeground(new Color(255, 255, 255));
				start.setBackground(new Color(0, 128, 128));
			
				hourcombo.setVisible(true);
				hourtext.setVisible(false);
				hourtext.setEditable(false);
				
				
				minutecombo.setVisible(true);
				minutetext.setVisible(false);
				minutetext.setEditable(false);
		



				
				secondcombo.setVisible(true);
				secondstext.setVisible(false);
				secondstext.setEditable(false);
			
				
			}

		}
		if(alarmstart)
		{
			
			seconds--;
			if(hour==0 && minutes==0 && seconds==0)
			{
				alarmstart=false;
				String time=hourcombo.getSelectedItem()+":"+minutecombo.getSelectedItem()+":"+secondcombo.getSelectedItem();
				AlarmRing ar=new AlarmRing(time,"Timer done",6);
				ar.setVisible(true);
				alarmstart=false;
				btnback.setText("Back");
				btnback.setForeground(new Color(255, 255, 255));
				btnback.setBackground(new Color(0, 128, 128));
			
				
				start.setText("Start");
				start.setForeground(new Color(255, 255, 255));
				start.setBackground(new Color(0, 128, 128));
			
				hourcombo.setVisible(true);
				hourtext.setVisible(false);
				hourtext.setEditable(false);
				
				
				minutecombo.setVisible(true);
				minutetext.setVisible(false);
				minutetext.setEditable(false);
		



				
				secondcombo.setVisible(true);
				secondstext.setVisible(false);
				secondstext.setEditable(false);
			
				
			}
			else if(seconds<0)
			{
				if(minutes>0)
				{
				seconds=59;
				}
				else
				{
					seconds=0;
				}
				
				minutes--;
				if(minutes<0)
				{
					
					
					
					if(hour>0)
					{
					hour--;	
					minutes=59;
					}
					else
					{
						hour=0;
						minutes=0;
					}
				}
			}
			if(hour>=0 && hour<=9)
			{
				strhour="0"+hour;
			}
			else
			{
				strhour=hour+"";
			}
			if(minutes>=0 && minutes<=9)
			{
				strminute="0"+minutes;
			}
			else
			{
				strminute=minutes+"";
			}
			if(seconds>=0 && seconds<=9)
			{
				strseconds="0"+seconds;
			}
			else
			{
				strseconds=seconds+"";
			}
			hourtext.setText(strhour);
			minutetext.setText(strminute);
			secondstext.setText(strseconds);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
		{
			main m=new main();
			m.setVisible(true);
			this.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
