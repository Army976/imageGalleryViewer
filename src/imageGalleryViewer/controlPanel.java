package imageGalleryViewer;

import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class controlPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JButton repeat =new button("images/repeat.png","images/repeatOff.png");
	JButton back =new JButton();
	JButton play =new button("images/play.png","images/pause.png");
	JButton next =new JButton();
	JButton shuffle =new button("images/shuffle.png", "images/shuffleOff.png");
	
	public controlPanel (GUI mainFrame)throws IOException {
	
		BufferedImage image = ImageIO.read(new File("images/next.png"));
		next.setIcon(new ImageIcon(image));
		image = ImageIO.read(new File("images/back.png"));
		back.setIcon(new ImageIcon(image));
		this.add(repeat);
		this.add(back);
		this.add(play);
		this.add(next);
		this.add(shuffle);
		addButtonActions(mainFrame);
	}

	private void addButtonActions(GUI mainFrame) {
		
		next.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					mainFrame.shownext();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
	
		back.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					mainFrame.showPrevious();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		repeat.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gallery.repeatEnabled=true;
			}
		});
		
		shuffle.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gallery.shuffleEnabled=true;
			}
		});
		
		play.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					mainFrame.play();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
	}

}
