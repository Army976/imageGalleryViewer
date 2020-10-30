package imageGalleryViewer;

import java.awt.image.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Gallery {
	
	public BufferedImage image=null;
	public static boolean playClicked;
	public static int galleryCount=0;
	public static boolean repeatEnabled = false;
	public static boolean shuffleEnabled = false;
	private int pictureCount=0;
	private Timer timer;
	private TimerTask timerTask;
	ArrayList<File> pictureFiles = new ArrayList<File>();
	JLabel pictureLabel;
	
	public Gallery(JLabel PJ){
		pictureLabel = PJ;
		galleryCount++;
	}
	public void addFile(File[] files) {
		for (int i=0;i<files.length;i++){
			pictureFiles.add(files[i]);
		}
	}
	public void setFirstPicture() throws IOException {
		BufferedImage image = ImageIO.read(pictureFiles.get(0));
		pictureLabel.setIcon(new ImageIcon(image));
	}
	public void showNext() throws IOException{
		if (pictureCount==pictureFiles.size()-1){
			if (!(repeatEnabled))
			return;
			else {
				pictureCount=0;
			}
		}
		 else{
		pictureCount++;
		}
		image = ImageIO.read(pictureFiles.get(pictureCount));
		pictureLabel.setIcon(new ImageIcon(image));
	}
	public void showPrevious() throws IOException{
		if (pictureCount==0){
			if (!(repeatEnabled))
			return;
			else {
				pictureCount=pictureFiles.size()-1;
			}
		}
		 else{
		pictureCount--;
		}
		image = ImageIO.read(pictureFiles.get(pictureCount));
		pictureLabel.setIcon(new ImageIcon(image));
	}
	
	public void play() throws IOException{
		playClicked= true;
		if (shuffleEnabled){
			playShuffle();
			return;
		}
		else{
			timer = new Timer();
			timerTask = new TimerTask() {
				
				@Override
				public void run() {
					try {
						showNext();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			timer.schedule(timerTask, settingPanel.currentSpeed,
					settingPanel.currentSpeed);
			
			
		}
	}
	public void stop() {
		timer.cancel();
		timer.purge();
		playClicked=false;
	}
	private void playShuffle() throws IOException {
		Random random = new Random();
		timer = new Timer();
		timerTask = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int temp = random.nextInt(pictureFiles.size()-1);
				BufferedImage image = null;
				try {
					image = ImageIO.read(pictureFiles.get(temp));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pictureLabel.setIcon(new ImageIcon(image));
			}
		};
		timer.schedule(timerTask, settingPanel.currentSpeed,settingPanel.currentSpeed);
	}

}
