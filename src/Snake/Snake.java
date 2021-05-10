package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	
	List<Point> snakePoints;
	
	int xDir, yDir;
	boolean isMoving, elongate;
	final int STARTSIZE = 20, STARTX = 200, STARTY = 200;
	
	
	
	public Snake() {
		snakePoints = new ArrayList<Point>();
		
		xDir=0;
		yDir=0;
		
		isMoving = false;
		elongate = false;
		snakePoints.add(new Point (STARTX, STARTY));
		
		for( int i = 1; i< STARTSIZE; i++) {
			snakePoints.add(new Point(STARTX - i*6, STARTY));
		}
			
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		for(Point p : snakePoints) {
			g.fillRect(p.getX(), p.getY(), 6, 6);
		}
	}
	
	public void move() {
		if(isMoving) {
		Point temp = snakePoints.get(0);
		Point last = snakePoints.get(snakePoints.size()-1);
		Point newStart = new Point(temp.getX() + xDir * 6, temp.getY() + yDir *6);
		
		for(int i = snakePoints.size() - 1; i>= 1; i--) {
			snakePoints.set(i, snakePoints.get(i-1));
		}
		snakePoints.set(0, newStart);
		if (elongate) {
			snakePoints.add(last);
			elongate = false;
		}
		}
	}
	
	public boolean snakeCollision() {
		int x = this.getX();
		int y = this.getY();
		
		for (int i = 1; i < snakePoints.size(); i++) {
			if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMoving() {
		return isMoving;
	}
	
	public void setIsMoving(boolean b) {
		isMoving = b;
	}
	
	
	public int getXDir() {
		return xDir;
	}
	
	public int getYDir() {
		return yDir;
	}
	
	public void setXDir(int x) {
		xDir = x;
	}
	
	public void setYDir(int y) {
		yDir = y;
	}
	
	
	//x position of head of snake
	public int getX() {
		return snakePoints.get(0).getX();
	}
	
	//y position of snake head
	public int getY() {
		return snakePoints.get(0).getY();
	}
	
	
	public void setElongate(boolean b) {
		elongate = b;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
