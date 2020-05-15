import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Lasers extends GameObject {
	int currentState;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Lasers(int x, int y, int width, int height, int currentState) {
		super(x, y, width, height);
		this.currentState = currentState;
		if (needImage) {
			loadImage("laser.png");
		}
		Random ran = new Random();

		speed = ran.nextInt(5) + 1;
	}
	void update() {
		y -= speed;
		super.update();
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
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
