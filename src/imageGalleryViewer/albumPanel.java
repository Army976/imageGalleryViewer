package imageGalleryViewer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class albumPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private  JButton[] albumButton = new JButton[10];
	private  int currentButton=0;
		
	public albumPanel(GUI mainFrame){
		
		this.setLayout(new GridLayout(10, 1));
		for (int i=0;i<10;i++){
			albumButton[i]= new JButton();
			int temp =i;
			albumButton[i].addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					mainFrame.setCurrentGallary(temp);
				}
			});
			this.add(albumButton[i]);
			albumButton[i].setVisible(false);
			}
	}
		
	public void addAlbum(){
		
		String str = JOptionPane.showInputDialog("please enter name of the Album");
		albumButton[currentButton].setText(str);
		albumButton[currentButton].setVisible(true);
		currentButton++;
	}
	
}
