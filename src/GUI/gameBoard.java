package GUI;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;



public class gameBoard extends JFrame {
	private File file;
	private ImageBoard ImageBoard;
	public gameBoard() {
		initGUI();	

	}
	private void initGUI() {
		ImageBoard=new ImageBoard();
		this.setContentPane(ImageBoard);
		this.setSize(1433,640);
		this.setVisible(true);
		this.setDefaultCloseOperation(gameBoard.EXIT_ON_CLOSE); 
		Menu add = new Menu("add");
		Menu Run = new Menu ("RUN");
		Menu Clear = new Menu ("Clear");
		MenuItem addCsv = new MenuItem("Add Csv");
		MenuItem addPlayer = new MenuItem("Add Player");
		MenuItem clear = new MenuItem("Clear Game");
		MenuItem step=new MenuItem("step");
		MenuItem auto=new MenuItem("auto");
		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);
		menuBar.add(add);
		menuBar.add(Clear);
		menuBar.add(Run);
		Clear.add(clear);
		add.add(addPlayer);
		add.add(addCsv);
		Run.add(step);
		Run.add(auto);
		class Addcsv implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser= new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
				fileChooser.setFileFilter(filter);
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					String s=file.getAbsolutePath();
					ImageBoard.addFile(s);
				}

			}
		}
		class stepBy implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
//				ImageBoard.setPlayer("steps");
				ImageBoard.x=1;
				System.out.println("b");
				ImageBoard.runStep();
			}
		}
		class Addplayer implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ImageBoard.setPlayer("player");
			}
		}
		addCsv.addActionListener(new Addcsv());
		addPlayer.addActionListener(new Addplayer());
		step.addActionListener(new stepBy());
	}
	public static void main(String[] args) {
		new gameBoard();
	}
}
