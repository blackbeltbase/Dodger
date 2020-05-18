import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU = 0;
	final int AVATARSELECT = 1;
	final int LEVEL1 = 2;
	final int LEVEL2 = 3;
	final int LEVEL3 = 4;
	final int END = 5;
	final int INSTRUX = 6;
	public int currentState = MENU;
	ObjectManager microManager;
	Timer laserSpawn;
	Font titleFont;
	Font otherFont;
	Timer frameDraw;
	Player player;
	int score = 0;
	Font endFont;
	boolean invincible = false;
	boolean avatarSelected = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int whichAvatar;

	void startGame() {
		laserSpawn = new Timer(1500, microManager);
		laserSpawn.start();
	}

	public GamePanel() {
		endFont = new Font("Arial", Font.PLAIN, 24);
		player = new Player(400, 400, 30, 30);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		otherFont = new Font("Arial", Font.PLAIN, 24);
		microManager = new ObjectManager(player, currentState);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == AVATARSELECT) {
			drawAvatarSelect(g);
		} else if (currentState == LEVEL1) {
			drawLevel1(g);
		} else if (currentState == LEVEL2) {
			drawLevel2(g);
		} else if (currentState == LEVEL3) {
			drawLevel3(g);
		} else if (currentState == END) {
			drawEndState(g);
		} else if (currentState == INSTRUX) {
			drawInstrux(g);
		}
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Dodger.WIDTH, Dodger.HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(30, 30, Dodger.WIDTH - 80, Dodger.HEIGHT - 80);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("Dodger!", 350, 350);
		g.setFont(otherFont);
		g.drawString("Press SPACE to see instructions", 200, 400);

		g.drawString("Press ENTER to start", 320, 520);
	}

	void drawAvatarSelect(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Dodger.WIDTH, Dodger.HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(30, 30, Dodger.WIDTH - 80, Dodger.HEIGHT - 80);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("Avatar Select", 250, 200);
		needImage = true;
		gotImage = false;
		if (needImage) {
			loadImage("Avatar_1.png");
		}
		if (gotImage) {
			g.drawImage(image, 40, 500, 100, 100, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(10, 500, 100, 100);
		}
		needImage = true;
		gotImage = false;

		if (needImage) {
			loadImage("seal.png");
		}
		if (gotImage) {
			g.drawImage(image, 350, 500, 100, 100, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(10, 500, 100, 100);
		}
		needImage = true;
		gotImage = false;

		if (needImage) {
			loadImage("Avatar_3.png");
		}
		if (gotImage) {
			g.drawImage(image, 590, 500, 100, 100, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(10, 500, 100, 100);
		}
		needImage = true;
		gotImage = false;
		g.setFont(otherFont);
		g.drawString("1", 80, 500);
		g.drawString("2", 380, 500);
		g.drawString("3", 620, 500);
		g.drawString("Select your avatar by pressing the indicated NUMBER on your ", 40, 350);
		g.drawString("keyboard above each avatar", 50, 380);
		g.drawString("When you have selected your avatar, press ENTER", 50, 410);

	}

	void drawLevel1(Graphics g) {

		if (needImage) {
			loadImage("oceanlevel.jpg");
		}
		if (gotImage) {
			g.drawImage(image, 0, 0, Dodger.HEIGHT, Dodger.WIDTH, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(10, 500, 100, 100);
		}
		g.setFont(otherFont);
		g.setColor(Color.YELLOW);
		int getScore = microManager.getScore();
		String score = Integer.toString(getScore);
		g.drawString("Score: " + score, 30, 30);
		g.drawString("Level 1", 350, 430);
		microManager.draw(g);
	}

	void drawLevel2(Graphics g) {
		if (needImage) {
			loadImage("hillylevel.jpg");
		}
		if (gotImage) {
			g.drawImage(image, 0, 0, Dodger.HEIGHT, Dodger.WIDTH, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(10, 500, 100, 100);
		}
		needImage = true;
		gotImage = false;
		g.setFont(otherFont);
		g.setColor(Color.YELLOW);
		int getScore = microManager.getScore();
		String score = Integer.toString(getScore);
		g.drawString("Level 2", 350, 430);
		g.drawString("Score: " + score, 30, 30);
		microManager.draw(g);
	}

	void drawLevel3(Graphics g) {
		if (needImage) {
			loadImage("clouds.jpg");
		}
		if (gotImage) {
			g.drawImage(image, 0, 0, Dodger.HEIGHT, Dodger.WIDTH, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(10, 500, 100, 100);
		}
		g.setFont(otherFont);
		g.setColor(Color.YELLOW);
		int getScore = microManager.getScore();
		String score = Integer.toString(getScore);
		g.drawString("Level 3", 350, 430);
		g.drawString("Score: " + score, 30, 30);
		microManager.draw(g);
	}

	void drawInstrux(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Dodger.WIDTH, Dodger.HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(30, 30, Dodger.WIDTH - 80, Dodger.HEIGHT - 80);
		g.setFont(otherFont);
		g.setColor(Color.RED);
		g.drawString("You have been put in a dangerous trap!", 200, 200);
		g.drawString("Your chances of survival increase as your score increases!", 125, 400);
		g.drawString("When you hit 50 points in level 1, you move on to level 2.", 50, 430);
		g.drawString("When you hit 150 points in level 2, you move on to level 3.", 50, 460);
		g.drawString("When you hit 300 points in level 3, you finally escape!", 50, 490);
		g.drawString("When you are ready to move on to the next level, press ENTER.", 50, 520);
		g.drawString("You increase your score by dodging the lasers that appear in the trap!", 20, 550);
		g.drawString("Use ARROW KEYS or WASD to dodge the lasers!", 200, 580);
	}

	void drawEndState(Graphics g) {
		if (score < 300) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Dodger.WIDTH, Dodger.HEIGHT);
			g.setColor(Color.YELLOW);
			g.fillRect(30, 30, Dodger.WIDTH - 80, Dodger.HEIGHT - 80);
			g.setFont(titleFont);
			g.setColor(Color.RED);
			g.drawString("Game Over!", 250, 350);
			g.drawString("Your score was: " + score, 150, 400);
			g.setFont(otherFont);
			g.drawString("Press ENTER to restart", 270, 450);
		} else if (score > 300) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Dodger.WIDTH, Dodger.HEIGHT);
			g.setColor(Color.BLUE);
			g.fillRect(30, 30, Dodger.WIDTH - 80, Dodger.HEIGHT - 80);
			g.setFont(titleFont);
			g.setColor(Color.GREEN);
			g.drawString("Congrats!", 250, 350);
			setFont(endFont);
			g.drawString("You escaped the trap and won", 50, 400);
			g.drawString("with a score of " + score + " points!", 90, 450);
			g.drawString("Press ENTER to restart", 150, 500);
		}
	}

	void updateMenuState() {
	}

	void updateAvatarSelect() {

	}

	void updateLevel1() {
		if (player.isActive == false) {
			currentState = END;
		}

		if (score > 50) {
			currentState = LEVEL2;
		}
		microManager.update();
	}

	void updateLevel2() {
		if (player.isActive == false) {
			currentState = END;
		}

		if (score > 150) {
			currentState = LEVEL3;
		}
		microManager.update();
	}

	void updateLevel3() {
		if (player.isActive == false) {
			currentState = END;
		}
		if (score > 300) {
			currentState = END;
		}
		microManager.update();
	}

	void updateEndState() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == AVATARSELECT) {
			updateAvatarSelect();
		} else if (currentState == LEVEL1) {
			updateLevel1();
		} else if (currentState == LEVEL2) {
			updateLevel2();
		} else if (currentState == LEVEL3) {
			updateLevel3();
		} else if (currentState == END) {
			updateEndState();
		} else if (currentState == INSTRUX) {
			updateInstrux();
		}
		score = microManager.getScore();
		repaint();
	}

	private void updateInstrux() {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				laserSpawn.stop();
				player = new Player(400, 400, 30, 30);
				microManager = new ObjectManager(player, currentState);
				System.out.println("reset");
			}
			if (currentState == END) {
				laserSpawn.stop();
				currentState = MENU;
			} else if (currentState == LEVEL1) {
				if (score > 50) {
					currentState = LEVEL2;
				} else {
					currentState = END;
					laserSpawn.stop();
				}
			} else if (currentState == LEVEL2) {
				if (score > 150) {
					currentState = LEVEL3;
				} else {
					currentState = END;
					laserSpawn.stop();
				}
			} else if (currentState == LEVEL3) {
				currentState = END;
			} else {
				currentState++;
			}
			if (currentState == LEVEL1 || currentState == LEVEL2 || currentState == LEVEL3) {
				startGame();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			System.out.println("invincible");
			if (invincible == false) {
				invincible = true;
			} else {
				invincible = false;
			}
			if (invincible) {
				microManager.activateInvincibility();
			} else {
				microManager.deactivateInvincibility();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				currentState = INSTRUX;
			} else if (currentState == INSTRUX) {
				currentState = MENU;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (player.y >= 10) {
				player.up();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (player.y < Dodger.HEIGHT - 100) {
				player.down();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			if (player.x < Dodger.WIDTH - 70) {
				player.right();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if (player.x >= 10) {
				player.left();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_1 && currentState == AVATARSELECT) {
			player.setAvatar(1);
			avatarSelected = true;
			whichAvatar = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_2 && currentState == AVATARSELECT) {
			player.setAvatar(2);
			avatarSelected = true;
			whichAvatar = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_3 && currentState == AVATARSELECT) {
			player.setAvatar(3);
			avatarSelected = true;
			whichAvatar = 3;
		}
		microManager.changeCurrentState(currentState);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
