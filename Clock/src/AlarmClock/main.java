package AlarmClock;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static main frame;
	private JLabel currenttime;
	private JButton stopwatch,timer,worldclock,alarm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new main();
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
	public main() 
	{
		Timer ti=new Timer(1000,this);
		ti.start();
		setTitle("Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setForeground(new Color(0, 0, 0));
//		contentPane.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		alarm = new JButton("Alarm");
		alarm.setFont(new Font("Calibri", Font.PLAIN, 20));
		alarm.setForeground(new Color(255, 255, 255));
		alarm.setBackground(new Color(0, 128, 128));
		alarm.setFocusPainted(false);
		
		
		
		alarm.addActionListener(this);
		alarm.setBounds(61, 134, 167, 52);
		contentPane.add(alarm);
		
		timer = new JButton("Timer");
		timer.setForeground(new Color(255, 255, 255));
		timer.setFont(new Font("Calibri", Font.PLAIN, 20));
		timer.setBackground(new Color(0, 128, 128));
		timer.setBounds(61, 259, 167, 52);
		timer.setFocusPainted(false);
		contentPane.add(timer);
		timer.addActionListener(this);
		
		stopwatch =new JButton("Stop Watch");
		stopwatch.setBackground(new Color(0, 128, 128));
		stopwatch.setForeground(new Color(255, 255, 255));
		stopwatch.setFont(new Font("Calibri", Font.PLAIN, 20));
		stopwatch.setFocusPainted(false);
		stopwatch.addActionListener(this);
		stopwatch.setBounds(251, 134, 166, 52);
		contentPane.add(stopwatch);
		
		worldclock = new JButton("World Clock");
		worldclock.addActionListener(this);
		worldclock.setForeground(new Color(255, 255, 255));
		worldclock.setFont(new Font("Calibri", Font.PLAIN, 20));
		worldclock.setBackground(new Color(0, 128, 128));
		worldclock.setBounds(251, 259, 167, 52);
		worldclock.setFocusPainted(false);

		contentPane.add(worldclock);
		
		JLabel lblClock = new JLabel("Clock");
		lblClock.setForeground(new Color(0, 0, 128));
		lblClock.setFont(new Font("Square721 BT", Font.BOLD, 25));
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setBounds(133, 11, 192, 52);
	

		contentPane.add(lblClock);
		
		currenttime = new JLabel("");
		currenttime.setForeground(Color.GRAY);
		currenttime.setFont(new Font("Square721 BT", Font.BOLD, 20));
		currenttime.setHorizontalAlignment(SwingConstants.CENTER);
		currenttime.setBounds(10, 407, 464, 43);
		contentPane.add(currenttime);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		LocalTime now=LocalTime.now();
		if(now.getHour()>=12)
		{
			if(now.getHour()==12)
			{
			currenttime.setText("Current Time = 12:"+now.getMinute()+":"+now.getSecond()+" PM");
			}
			else
			{
				currenttime.setText("Current Time = "+(now.getHour()-12)+":"+now.getMinute()+":"+now.getSecond()+" PM");
			}
		}
		else
		{
		currenttime.setText("Current Time = "+now.getHour()+":"+now.getMinute()+":"+now.getSecond()+" AM");
		}	
		if(e.getSource()==worldclock)
		{
			WorldClock wd=new WorldClock();
			wd.setVisible(true);
			this.dispose();
		}
		if(e.getSource()==alarm)
		{
			AlarmClock cd=new AlarmClock();
			cd.setVisible(true);
			this.dispose();
		}
		if(e.getSource()==timer)
		{
			Timerclock tc=new Timerclock();
			tc.setVisible(true);
			this.dispose();
		}
		if(e.getSource()==stopwatch)
		{
			StopWatch sw=new StopWatch();
			sw.setVisible(true);
			this.dispose();
			
		}
	}
}