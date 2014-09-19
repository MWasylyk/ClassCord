package cordPackage;
/* By Michael Wasylyk
 * Example swing application using the SwingSeek component
 */

import seekPackage.SeekBar;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static SeekBar seekBar = new SeekBar();
	JFrame mainFrame = new JFrame();
	
	public static void main(String[] args) {
		// Instantiate the JFrame object
		@SuppressWarnings("unused")
		Main m = new Main();
		seekBar.setSeekLocation(0);
		final Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  public void run() {
				  if(seekBar.getSeekLocation()+1 < seekBar.getMaxTime()+1) {
					  seekBar.setSeekLocation(seekBar.getSeekLocation()+1);
				  }
			  }
		}, 0, 1000);
		
	}
	
	// Swing startup code
	public Main(){
		mainFrame.setTitle("Main Window");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		mainFrame.setVisible(true);
		init();
	}
	
	public void init(){
		//TODO Add play pause stop and record functionality and buttons 
		JButton play = new JButton();
		JButton record = new JButton();
		// Panel for holding main JComponents
		JPanel mainPanel = new JPanel();
		mainFrame.setSize(600, 150);
		
		// Setup code for the main panel
		mainPanel.setLayout(null);
		mainPanel.setOpaque(true);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		play.setText("Play");
		play.setSize(50, 30);
		play.setLocation(0, 0);
		
		record.setText("Rec");
		record.setSize(50,30);
		record.setLocation(45, 0);
		
		seekBar.addMouseListener(seekBar);
		seekBar.addMouseMotionListener(seekBar);
		
		// Set location of seekBar
		seekBar.setLocation(25, 50);
		
		// Set size of seekBar
		seekBar.setSize(550, 65);
		seekBar.setMaxTime(300);
		//seekBar.setSeekLocation(150);
		
		// Add JComponents to the main panel and the JFrame
		mainPanel.add(seekBar);
		mainPanel.add(play);
		mainPanel.add(record);
		mainFrame.add(mainPanel);
		mainFrame.setResizable(true);
	}

}
