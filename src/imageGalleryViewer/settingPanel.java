package imageGalleryViewer;

import javax.swing.*;
import java.awt.event.*;

public class settingPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	ButtonGroup bg = new ButtonGroup();
	JRadioButton slow =new JRadioButton("slow");
	JRadioButton normal=new JRadioButton("normal");		
	JRadioButton fast =new JRadioButton("fast");
	JButton custom =new JButton("custom");
 	
	static int currentSpeed = 2000;
	
 	public settingPanel(){

 		makeRadio();
 		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    this.add(slow);
	    this.add(normal);
	    this.add(fast);
	    this.add(custom);
	    
	    custom.addActionListener(new ActionListener() {
		
		@Override
			public void actionPerformed(ActionEvent arg0) {
		
				String str=JOptionPane.showInputDialog("please enter your time in miliseconds");
				char[] ch = str.toCharArray();
				int speedTime=0;
				for (int i=0;i<ch.length;i++){
					speedTime=speedTime*10+((int)(ch[i]-48));
					setCustomSpeed(speedTime);
				}
			}
	    });

 	}

    protected void setCustomSpeed(int speedTime) {
    	// TODO Auto-generated method stub
    	
    	currentSpeed = speedTime;
    }

    private void makeRadio() {
	
    	fast.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			setCustomSpeed(1000);
		}
	});
	   
    	normal.addActionListener(new ActionListener() {
		
		@Override
			public void actionPerformed(ActionEvent arg0) {
				setCustomSpeed(2500);
			}
    	});
	   
    	slow.addActionListener(new ActionListener() {
		
		@Override
			public void actionPerformed(ActionEvent arg0) {
				setCustomSpeed(5000);
			}
    	});
    	
    	bg.add(fast);
	    bg.add(normal);
	    bg.add(slow);
   }

}
