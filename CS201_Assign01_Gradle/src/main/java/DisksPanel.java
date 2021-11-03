import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DisksPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	private static final Font FONT = new Font("Dialog", Font.BOLD, 24);
	
	private Timer timer;
	// other fields you need for the model and outline
	private DiskModel diskModel;
	private Disk disk;
	private int centerX;
	private int centerY;
	private Random r;
	private int outlineRadius;
	private boolean gameOver;
	private int timerLength;

	public DisksPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.GRAY);
		// initialize all fields
		diskModel = new DiskModel();
		r = new Random();
		outlineRadius = r.nextInt(44-10) + 10;
		gameOver = false;
		timerLength = WIDTH;
		
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				handleMouseMove(e);
			}
		});
		
		// Schedule timer events to fire every 100 milliseconds (0.1 seconds)
		this.timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleTimerEvent(e);
			}
		});
	}

	// You can call this method to convert a DiskColor value into
	// a java.awt.Color object.
	public Color colorOf(DiskColor dc) {
		return new Color(dc.red(), dc.green(), dc.blue());
	}

	// This method is called whenever the mouse is moved
	private void handleMouseMove(MouseEvent e) {
		// as long as game is not over, get x and y of mouse coordinates and repaint
		if (!gameOver) {
			centerX = e.getX();
			centerY = e.getY();
			repaint();
		}
	}
	
	// This method is called whenever the mouse is clicked
	private void handleMouseClick(MouseEvent e) {
		// make new disk and check if it is out of bounds, end game if it is
		timer.stop();
		DiskColor newDiskColor = DiskColor.values()[r.nextInt(15-1) + 1];
		disk = new Disk(e.getX(), e.getY(), outlineRadius, newDiskColor);
		if (disk.isOutOfBounds(WIDTH, HEIGHT)) {
			gameOver = true;

		}
		// checks every disk in the model if it overlaps with current disk, ends game if it does
		for (int i = 0; i < diskModel.getNumDisks(); i++) {
			if (disk.overlaps(diskModel.getDisks().get(i))) {
				gameOver = true;
			}
		}
		// as long as game is not over add disk to the model, randomize radius, and reset timer bar
		if (!gameOver) {
			diskModel.addDisk(disk);
			outlineRadius = r.nextInt(44-10) + 10;
			timerLength = WIDTH;
			timer.start();
		}
		repaint();
	}
	
	// This method is called whenever a timer event fires
	private void handleTimerEvent(ActionEvent e) {
		// as long as the game is not over, timer decreases exponentially as more disks are added
		if (!gameOver) {
			timerLength = timerLength - diskModel.getNumDisks();
			repaint();
		}
		// if timer runs out end game
		if (timerLength <= 0) {
			gameOver = true;
		}
	}
	

	// This method is called automatically whenever the contents of
	// the window need to be redrawned.
	@Override
	public void paint(Graphics g) {
		// Paint the window background
		super.paint(g);
		// draw everything that needs to be drawn

		// draw disks from model
		for (int i = 0; i < diskModel.getNumDisks(); i++) {
			int modelRadius = (int) diskModel.getDisks().get(i).getRadius();
			int modelX = (int) diskModel.getDisks().get(i).getX() - modelRadius;
			int modelY = (int) diskModel.getDisks().get(i).getY() - modelRadius;
			g.setColor(colorOf(diskModel.getDisks().get(i).getColor()));
			g.fillOval(modelX, modelY, 2 * modelRadius, 2 * modelRadius);
		}

		// draw outline
		int outlineX = (centerX - outlineRadius);
		int outlineY = (centerY - outlineRadius);
		g.setColor(Color.black);
		g.drawOval(outlineX, outlineY, 2*outlineRadius, 2*outlineRadius);

		// draw count
		g.setFont(FONT);
		g.setColor(Color.BLACK);
		g.drawString("" + diskModel.getNumDisks(), 25, 30);

		// draw timer bar
		g.setColor(Color.RED);
		g.fillRect(0, HEIGHT-10, timerLength, 10);

		// draw game over text if game is over
		if (gameOver) {
			g.setFont(FONT);
			g.setColor(Color.BLACK);
			g.drawString("Game Over", 150, 150);
		}
	}
}
