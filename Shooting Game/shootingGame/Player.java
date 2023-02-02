package shootingGame;
//Pelin Su G�k-202011405-Section 1

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends GameObject {

	/*
	 * xPos = X Position 
	 * yPos = Y Position 
	 * height = Height of Player 
	 * width = Width of Player 
	 * health = Health of Player 
	 * image = image of Player 
	 * id = ID's of the players
	 */

	public Player(final int xPos, final int yPos, final int width, final int height, final int health,
			final String image) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.rectangle = new Rectangle(xPos, yPos, width, height);
		this.health = health;
		this.image = getImage(image);
	}

	public void draw(Graphics g) {
		// Draw the image at inputed coordinates
		g.drawImage(image, xPos, yPos, width, height, null);
	}

	@Override
	void update(final ShootingGame shooter, final int id) {

		if (id == 1) {
			if (shooter.player1Up) {
				// 50 is title bars height + health informations height
				// For player 1 to stop when it hits the title bar
				if (yPos > 50) {
					// Decremented yPos because top starts from 0
					yPos--;
					rectangle.y--;
				}
			}

			else if (shooter.player1Down) {
				// 98 is programs height
				// For player 1 to stop when it hits the bottom of the program
				if (yPos < shooter.getHeight() - 98) {
					yPos++;
					rectangle.y++;
				}
			}
		}

		// Does the same things for player 2
		else if (id == 2) {
			if (shooter.player2Up) {
				if (yPos > 50) {
					yPos--;
					rectangle.y--;
				} 
			}else if (shooter.player2Down) {
					if (yPos < shooter.getHeight() - 98) {
						yPos++;
						rectangle.y++;
					}
				}
			}
		}

	@Override
	Image getImage(String image) {
		return Toolkit.getDefaultToolkit().getImage(image);
	}

}
