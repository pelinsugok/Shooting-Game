package shootingGame;
//Pelin Su G�k-202011405-Section 1

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {

	protected Rectangle rectangle;
	protected int xPos;
	protected int yPos;
	protected int height;
	protected int width;
	protected int health;
	protected Image image;

	abstract void draw(Graphics g);

	// For updating the position and bullet
	abstract void update(final ShootingGame shooter, final int id);

	abstract Image getImage(String image);

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
