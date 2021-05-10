package Snake;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends Applet implements Runnable, KeyListener{


	Graphics gfx;
	Image img;
	Thread thread;
	Snake snake;
	boolean gameOver;
	Token token;
	
	public void init() {
		this.resize(600,600);
		gameOver = false;
		img=createImage(600,600);
		gfx = img.getGraphics();
		this.addKeyListener(this);
		snake = new Snake();
		token = new Token(snake);
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, 600, 600);
		if(!gameOver) {
			token.draw(gfx);
			snake.draw(gfx);
		}
		else {
			gfx.setColor(Color.RED);
			gfx.drawString("Game over", 250, 280);
			gfx.drawString("Score: " + token.getScore(),250, 300);
		}
		
		
		g.drawImage(img, 0, 0, null);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void repaint(Graphics g) {
		paint(g);
	}

	public void run() {
		
		for(;;) {
			
			if(!gameOver) {
			snake.move();
			this.checkGameOver();
			token.snakeCollision();
			}
			this.repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void checkGameOver() {
		if(snake.getX() < 0 || snake.getX() > 594) {
			gameOver = true;
		}
		
		if (snake.getY() < 0 || snake.getY() > 594) {
			gameOver = true;
		}
		if(snake.snakeCollision()) {
			gameOver = true;
		}
	}

	public void keyPressed(KeyEvent e) {
		
		if(!snake.isMoving()) {
			if(e.getKeyCode()== KeyEvent.VK_UP || e.getKeyCode()== KeyEvent.VK_DOWN || 
					e.getKeyCode()== KeyEvent.VK_RIGHT ) {
				snake.setIsMoving(true);
			}
		}
		
		if(e.getKeyCode()== KeyEvent.VK_UP){
			if(snake.getYDir() != 1) {
				snake.setYDir(-1);
				snake.setXDir(0);
			}
		}
		
		if(e.getKeyCode()== KeyEvent.VK_DOWN){
			if(snake.getYDir() !=-1) {
				snake.setYDir(1);
				snake.setXDir(0);
			}
		}
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT){
			if(snake.getXDir() != 1) {
				snake.setXDir(-1);
				snake.setYDir(0);
			}
		}
		
		if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			if(snake.getXDir() != -1) {
				snake.setXDir(1);
				snake.setYDir(0);
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
