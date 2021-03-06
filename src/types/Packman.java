package types;

import Geom.Point3D;
/**
 * This class represents a single pacman 
 * @author moshe and ariel
 *
 */

public class Packman {
private int id;
private Point3D p;
private double speed;
private double raduis;
public Packman(){
	
}
/**
 * Constructor 
 * @param _id the packman id
 * @param _speed the pakman speed
 * @param _p the packman point location
 * @param _raduis the packman radius eat
 */
public Packman(int _id,double _speed,Point3D _p ,double _raduis) {
	this.id=_id;
	this.speed=_speed;
	this.p=_p;
	this.raduis=_raduis;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Point3D getP() {
	return p;
}
public void setP(Point3D p) {
	this.p = p;
}
public double getSpeed() {
	return speed;
}
public void setSpeed(double speed) {
	this.speed = speed;
}
public double getRadius() {
	return raduis;
}
public void setRadius(double radius) {
	this.raduis = radius;
}

}
