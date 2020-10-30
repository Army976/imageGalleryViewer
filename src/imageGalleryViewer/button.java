package imageGalleryViewer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class button extends JButton{
	
	private static final long serialVersionUID = 1L;
	
	public boolean isClicked=false;

	public button(String Default,String secondary) {
		try {
			setDefualt(Default);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		this.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isClicked){
					try {
						setDefualt(Default);
						isClicked=false;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {
					try {
						setSecondary(secondary);
						isClicked=true;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	protected void setSecondary(String secondary) throws IOException {
		
		File file = new File(secondary);
		BufferedImage img = ImageIO.read(file);
		this.setIcon(new ImageIcon(img));
	}
	
	protected void setDefualt(String default1) throws IOException {
		File file = new File(default1);
		BufferedImage img = ImageIO.read(file);
		this.setIcon(new ImageIcon(img));
	}

}
