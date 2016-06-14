package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class FileRead extends JFrame {
	private JTextField addressField;
	private JEditorPane display; //only support webs that are 3.2 or lower in terms of HTML 
	
	//constructor
	public FileRead(){
		super("Virtual Browser"); //name of browser
		
		addressField = new JTextField("Please enter a URL");
		
		addressField.addActionListener(
			new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//load read html files and isplay on screen
					loadURL(e.getActionCommand());
				}
			}
		);
		add(addressField, BorderLayout.NORTH);
		//end of address bar being displayed
		
		
		display = new JEditorPane();
		//prevent user from being able to view only
		display.setEditable(false);
		
		//grabs URL of a link and will change the display
		display.addHyperlinkListener(
				new HyperlinkListener(){

					@Override
					public void hyperlinkUpdate(HyperlinkEvent e) {
						//
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							//user has clicked a linked
							loadURL(e.getURL().toString());
						}else if(e.getEventType()==HyperlinkEvent.EventType.ENTERED){
							//user has hovered over
						}
					}
				}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(720, 480);
		setVisible(true);
	}
	
	//load URL to display on the projected screen
	private void loadURL(String userInput){
		try{
			display.setPage(userInput);//sets display on the url if correct
			addressField.setText(userInput); //wipes the old address displayed and replaces it
		}catch(Exception failure){
			System.out.println("Something has gone wrong");
		}
	}
	
}//end of FileRead
