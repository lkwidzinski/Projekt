package pl.edu.pjwstk.project.gui;

import javax.swing.*;

public class GUIMainWindow extends JFrame{
	
	public static void main(String[] args){
		
		showWindow();
		
	}
	
	private static void showWindow(){
		
		JFrame MW=new GUIWindow();
		MW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
