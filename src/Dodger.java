import javax.swing.JFrame;

public class Dodger {
	JFrame gameFrame;
	GamePanel gamePanel;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	public static void main(String[] args) {
		Dodger dodgeGame = new Dodger();
		dodgeGame.setup();
	}

	public Dodger() {
		gameFrame = new JFrame();
		gamePanel = new GamePanel();
	}

	void setup() {
		gameFrame.add(gamePanel);
		gameFrame.addKeyListener(gamePanel);
		gameFrame.setSize(WIDTH, HEIGHT);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
	}
}
