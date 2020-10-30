package imageGalleryViewer;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class GUI extends JFrame{

public Gallery[] gallery = new Gallery[10];
	
	private static final long serialVersionUID = 1L;
	
	JPanel picturePanel =new JPanel();
	JLabel pictureLabel= new JLabel();
	JMenuBar menuBar =new JMenuBar();
	JMenu file=new JMenu("File");
	JMenuItem newAlbum =new JMenuItem("New Album");
	JMenuItem newProject = new JMenuItem("New project");
	JMenuItem open = new JMenuItem("Open image");
	JMenuItem help = new JMenuItem("Help");
	JMenu about = new JMenu("About");
	controlPanel controlPanel = new controlPanel(this);
	settingPanel settingPanel=  new settingPanel();
	albumPanel albumPanel = new albumPanel(this);
	private  Gallery currentGallery = new Gallery(pictureLabel);
	
	public GUI() throws IOException{
		makeGalleries();
		createUI(controlPanel,settingPanel,albumPanel);
		AddActions();
	}

	private void makeGalleries() {
		// TODO Auto-generated method stub
		for (int i=0;i<10;i++){
			gallery[i]= new Gallery(pictureLabel);
		}
	}

	private void createUI(controlPanel controlPanel, settingPanel settingPanel,albumPanel albumPanel) throws IOException {
		// TODO Auto-generated method stub
	
			menuBar.add(file);
			file.add(newAlbum);
			file.add(open);
			menuBar.add(about);
			about.add(help);
			picturePanel.add(pictureLabel);
			
			albumPanel.setLayout(new BoxLayout(albumPanel, BoxLayout.Y_AXIS));
			
			this.add(albumPanel,BorderLayout.WEST);
			this.add(menuBar,BorderLayout.NORTH);
			this.add(controlPanel, BorderLayout.SOUTH);
			this.add(settingPanel, BorderLayout.EAST);
			this.add(pictureLabel, BorderLayout.CENTER);
	}
	
	private void AddActions(){
		newAlbum.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addAlbum();
			}
		}); 
	
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					openFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String str = "In menu bar choose \"add Album\" to add a new album!"+"\n"+"Use \"open picture\" to add pictures to your album! ";
				JOptionPane.showMessageDialog(pictureLabel,str);
			}
		});
	}


	protected void openFile() throws IOException {
		// TODO Auto-generated method stub
		
		FileDialog dialog = new FileDialog(new JFrame());
		dialog.setMultipleMode(true);
		dialog.setVisible(true);
		
		currentGallery.addFile(dialog.getFiles());
		currentGallery.setFirstPicture();
	}

	protected void addAlbum() {
		albumPanel.addAlbum();
	}

	public void setCurrentGallary(int i) {
		currentGallery = gallery[i];
	}

	public void shownext() throws IOException {
		currentGallery.showNext();
	}

	public void showPrevious() throws IOException {
		currentGallery.showPrevious();
	}

	public void play() throws IOException {
		if(!Gallery.playClicked)
			currentGallery.play();
		else
			currentGallery.stop();
	}
}
