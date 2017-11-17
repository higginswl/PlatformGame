import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Platform{
	
	Image img;
	private int x;
	private int y;
	private int originx;
	private int originy;
	private int numBlocks;
	public boolean see;
	public boolean end;
	private Rectangle collisionBox;


	
	public Platform(int newx, int newy) {
		numBlocks = (int) (Math.random()*5 + 1);

		x = newx;
		y = newy;
		see = true;
		
		collisionBox = new Rectangle(x, y, PlayPanel.TILE_SIZE * numBlocks, PlayPanel.TILE_SIZE);
	}

	//constructor for when wanting control of how long the platform is.  Mainly used to set the size of the first platform
	public Platform(int newx, int newy, int numBlocks) {
		this.numBlocks = numBlocks;
		x = newx;
		y = newy;
		see = true;
		
		collisionBox = new Rectangle(x, y, PlayPanel.TILE_SIZE * numBlocks, PlayPanel.TILE_SIZE);
	}


	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public int getOriginy() {
		return originy;
	}


	public void setOriginy(int originy) {
		this.originy = originy;
	}


	public boolean isSee() {
		return see;
	}


	public void setSee(boolean see) {
		this.see = see;
	}


	public void move()
	{
		x = x - 2;
		collisionBox.setLocation(x, y);
		if (x + (64*numBlocks) < 0)
			see = false;
		
	}
	
	public Rectangle getCollisionBox(){
		return collisionBox;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getNumBlocks() {
		return numBlocks;
	}


	public void setNumBlocks(int numBlocks) {
		this.numBlocks = numBlocks;
	}
	
	
}
