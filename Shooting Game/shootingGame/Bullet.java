package shootingGame;

//Pelin Su G�k-202011405-Section 1

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bullet extends GameObject {

	private Player player;

	// The way bullet moves
	// if the left player is shooting it'll be 1 to bullet to go right
	// if the right player is shooting it'll be -1 to bullet to go left
	private int deltaX;

	public Bullet(final Player player, final int deltaX, final int xPos, final int yPos, final int width,
			final int height, final String image) {
		this.player = player;
		this.deltaX = deltaX;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.rectangle = new Rectangle(xPos, yPos, width, height);
		this.image = getImage(image);
	}

	public void draw(Graphics g) {
		// Draw the image at inputed coordinates
		g.drawImage(image, xPos, yPos, width, height, null);
	}

	@Override
	void update(final ShootingGame shooter, final int id) {
		// if rectangle of the bullet collides with the rectangle of the player it
		// removes it
		if (rectangle.intersects(player.rectangle)) {
			player.setHealth(player.getHealth() - 1);
			shooter.bullets.remove(this);
		}
		// if it goes off the screen
		else if (xPos < 5 || xPos > 595) {
			shooter.bullets.remove(this);
		}
		// For moving the bullets
		else {
			xPos += deltaX;
			rectangle.x += deltaX;
		}
	}

	@Override
	Image getImage(String image) {
		return Toolkit.getDefaultToolkit().getImage(image);
	}

	public int getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
