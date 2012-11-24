package pl.edu.pjwstk.project.gui;

import javax.swing.*;

public class GUIWindow extends JFrame{
	
	private static JFrame MW;
	
	public GUIWindow(){
		
		MW=new JFrame("Airport");
		//new user;
	}

	public static JFrame getFrame(){
		return MW;
	}
}
