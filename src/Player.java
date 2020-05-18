import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
boolean avatarSelected;
Random ran = new Random();
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 6;
	}

	void setAvatar(int avatarNumber) {
		avatarSelected = true;
		if (avatarNumber == 1) {
			if (needImage) {
				loadImage("Avatar_1.png");
			}
		} else if (avatarNumber == 2) {
			if (needImage) {
				loadImage("seal.png");
			}
		} else if (avatarNumber == 3) {
			if (needImage) {
				loadImage("Avatar_3.png");
			}
		} 
	}
void avatarNotSelected() {
	avatarSelected = false;
}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(getColor());
			g.fillRect(x, y, width, height);
		}
	}
Color getColor() {
	int random = ran.nextInt(8);
	if(random == 0) {
		return Color.RED;
	}
	else if(random == 1) {
		return Color.GREEN;
	}
	else if(random == 2) {
		return Color.BLUE;
	}
	else if(random == 3) {
		return Color.YELLOW;
	}
	else if(random == 4) {
		return Color.ORANGE;
	}
	else if(random == 5) {
		return Color.GRAY;
	}
	else if(random == 6) {
		return Color.WHITE;
	}
	else if(random == 7) {
		return Color.PINK;
	}
	else {
		return null;
	}
	
}
	void up() {
		y -= speed;
	}

	void down() {
		y += speed;
	}

	void left() {
		x -= speed;
	}

	void right() {
		x += speed;
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
