package Snake;

import java.awt.Color;
import java.awt.Graphics;

public class Token {

	private int x, y, score;
	
	private Snake snake;
	
	
	public Token(Snake s) {
		x = (int)(Math.random() * 570);
		y = (int)(Math.random() * 570);
		snake = s;
	}
	public void changePosition() {
		x = (int)(Math.random() * 570);
		y = (int)(Math.random() * 570);
	}
	public int getScore() {
		return score;
	}
	
	
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 9, 9);
	}
	public boolean snakeCollision() {
		int snakeX = snake.getX() + 3;
		int snakeY = snake.getY() + 3;
		
		if(snakeX >= x-1 && snakeX <= (x+10))
			if(snakeY >= y-1 && snakeY <= (y+10)) {
				changePosition();
				score++;
				snake.setElongate(true);
				return true;
			}
		return false;
	}
	
}
