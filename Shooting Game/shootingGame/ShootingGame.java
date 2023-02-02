package shootingGame;
//Pelin Su G�k-202011405-Section 1
//Two-Player Shooting Game
//Player 1 moves with W and S and shoots bullets with spacebar
//Player 2 moves with up and down arrow keys and shoots bullets with enter

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//Used copyOnWrite because game might read and delete bullets at the same time
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JFrame;

public class ShootingGame extends JFrame implements KeyListener {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private Player player1;
	private Player player2;
	private Image image;
	private Graphics graphics;
	public boolean player1Up = false;
	public boolean player1Down = false;
	public boolean player2Up = false;
	public boolean player2Down = false;
	//ArrayList holds the bullets
	CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();

	public ShootingGame() {

		// setTitle("2D Shooter Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Shuts down background codes
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setBackground(Color.BLACK);
		setResizable(false);
		addKeyListener(this);

		// To be able to see the JFrame
		setVisible(true);

		player1 = new Player(10, 150, 20, 90, 10, "Images/Player1.jpg");
		player2 = new Player(570, 150, 20, 90, 10, "Images/Player2.jpg");
	}

	public void paint(Graphics g) {
		// Created a new image for the screen going to be used for double buffering
		image = createImage(getWidth(), getHeight());
		// graphics will be used for double buffering also but only image will be drawn
		graphics = image.getGraphics();

		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);
		repaint();
	}

	// For drawing player and bullets
	public void paintComponent(Graphics g) {
		if (player1.getHealth() > 0 && player2.getHealth() > 0) {
			
			Integer player1Health = player1.getHealth();
			Integer player2Health = player2.getHealth();
			
			//For printing the health of players on the screen
			g.setColor(Color.WHITE);
			g.drawString("Player1 Health:  " + player1Health.toString(), 15, 48);
			g.drawString("Player2 Health:  " + player2Health.toString(), 480, 48);
			
			for (Bullet bullet : bullets) {
				bullet.draw(g);
				// Second parameter is 0 because update function expects an ID but bullets
				// doesn't have ID
				bullet.update(this, 0);
			}		
		} else if (player1.getHealth() == 0) {
			g.setColor(Color.RED);
			g.drawString("Player2 has won!", 250, 190);
		} else if (player2.getHealth() == 0) {
			g.setColor(Color.RED);
			g.drawString("Player1 has won!", 250, 190);
		}

		player1.draw(g);
		player1.update(this, 1);
		player2.draw(g);
		player2.update(this, 2);
	}

	// Works when pressing a key and hold it
	@Override
	public void keyPressed(KeyEvent e) {
		// When pressed players attributes changes to true
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player1Up = true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_S) {
			player1Down = true;
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2Up = true;
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player2Down = true;
		}
	}

	// Works when pressing the key
	@Override
	public void keyTyped(KeyEvent e) {

	}

	// Works when you press and hold a key and release it
	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			player1Up = false;
		}

		else if (e.getKeyCode() == KeyEvent.VK_S) {
			player1Down = false;
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2Up = false;
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player2Down = false;
		}
		// Left player1
		// if player 1 shoots a bullet its going to hit player2
		// Every time when pressed the space key it adds a new bullet to the bullets
		// ArrayList
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Bullet player1Bullet = new Bullet(player2, 1, player1.getxPos() + 20, player1.getyPos() + 45, 4, 4,
					"Images/Bullet.jpg");
			bullets.add(player1Bullet);
		}
		// Right player2
		// if player 1 shoots a bullet its going to hit player2
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Bullet player2Bullet = new Bullet(player1, -1, player2.getxPos() - 4, player2.getyPos() + 45, 4, 4,
					"Images/Bullet.jpg");
			bullets.add(player2Bullet);
		}
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public static void main(String[] args) {
		new ShootingGame();

	}

}
