package fileChooser;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;



/**
 * * Ramka z menu zawieraj�cym opcj� Otw�rz i obszarem do prezentacji otwartych
 * obraz�w
 */
public class ImageViewerFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	private JLabel label;
	private JFileChooser chooser;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ImageViewerFrame();
				frame.setTitle("DrawTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	public ImageViewerFrame()   
	{      
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	
      // Pasek menu      
		JMenuBar menuBar = new JMenuBar();      
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("Plik");      
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("Otw�rz");      
		menu.add(openItem);      
		openItem.addActionListener(new ActionListener()         
			{            
			public void actionPerformed(ActionEvent event)            
			{               
				chooser.setCurrentDirectory(new File("."));
			
			
				// Okno wyboru plik�w 
				int result = chooser.showOpenDialog(ImageViewerFrame.this);
				
				// Je�li plik obrazu zostanie zaakceptowany, ustaw go jako ikon� etykiety
				if (result == JFileChooser.APPROVE_OPTION)               
					{                  
					String name = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));
					pack();               
					}            
				}         
			});
		
		JMenuItem exitItem = new JMenuItem("Zamknij");      
		menu.add(exitItem);      
		exitItem.addActionListener(new ActionListener()
		{            
			public void actionPerformed(ActionEvent event)            
			{               
				System.exit(0);            
			}         
		});
		
		// Etykieta do wy�wietlania obraz�w      
		label = new JLabel();      
		add(label);
		
		// Utworzenie akcesorium wyboru plik�w      
		chooser = new JFileChooser();
		
		// Akceptuje wszystkie pliki obraz�w z rozszerzeniem .jpg, .jpeg, .gif      
		/*      
		final ExtensionFileFilter filter = new ExtensionFileFilter();      
		filter.addExtension("jpg");      
		filter.addExtension("jpeg");      
		filter.addExtension("gif");      
		filter.setDescription("Pliki obraz�w");      
		*/      
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Pliki obraz�w","jpg", "jpeg", "gif");      
		chooser.setFileFilter(filter);
		chooser.setAccessory(new ImagePreviewer(chooser));
		chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));   
	} 
}
