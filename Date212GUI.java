import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Date212GUI extends JFrame{
	public Date212GUI(){
		initializeGUI();
	} //no-argument constructor

	private void initializeGUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
		createMenu();
        this.setSize(600, 300);
        this.setLocation(100, 100);
        this.setTitle("Date Display");
        this.getContentPane();
        this.setLayout(new GridLayout(0,2));
	} //establishes GUI

	private void createMenu(){
		JMenuBar menuBar  = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem item;
		FileMenuHandler fmh  = new FileMenuHandler(this);
		
		item = new JMenuItem("Open"); 
		item.addActionListener(fmh);
		
		fileMenu.add(item);
		fileMenu.addSeparator(); 
		
		item = new JMenuItem("Quit"); 
		item.addActionListener(fmh);
		
		fileMenu.add(item);
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	} //createMenu
} //class Date212GUI