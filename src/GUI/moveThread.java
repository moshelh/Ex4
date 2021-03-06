package GUI;

import types.Game;

import java.awt.event.MouseEvent;

import Coords.MyCoords;
import Geom.Point3D;
import Maps.Convert;
import Robot.Play;
import SQL.readSQL;
/**
 * this class represents the automatic  running. 
 * the class using thread and the server to move the element on the board by clicking .
 * @author moshe and ariel 
 *
 */

public class moveThread extends Thread{

	private ImageBoard image;
	private Game game;
	private Play play;
	private MouseEvent e;
	private Convert c;
	private MyCoords m;
	int counter=1;
	 // Constructor
	public moveThread(ImageBoard _image, Game _game,Play _play,MouseEvent _e) {
		this.image=_image;
		this.game=_game;
		this.play=_play;
		this.e=_e;
		this.c=new Convert();
		m=new MyCoords();
	}
	
	public void run() {
		image.threadFlag=false;
		//setting the player location.
		play.setInitLocation(game.getPlayerP().getP().y(), game.getPlayerP().getP().x());
		play.setIDs(313383259,307967992);
		play.start();
		double [] e=new double[3];
		while(play.isRuning())
		{
			//ensure the calculation of the azimut been done only when the user clicks on the board to change the direction.
			if(counter+1==image.counterAzimut) {
				Point3D p=image.getPointclicked();
				e=m.azimuth_elevation_dist(game.getPlayerP().getP(),p);
				play.rotate(e[0]);
				game.update(play);
				image.update();
				counter++;
			}
			else {
				play.rotate(e[0]);
				game.update(play);
				image.update();
			}
			try {
				this.sleep(75);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(play.getStatistics());
		}
	System.out.println("***final statistics***\n"+play.getStatistics());
	 System.out.println("**********sql resulte**********");
	 readSQL sql=new readSQL();
	 sql.getSqlresulte();
	}

}
