// CS201 Fall 2021 Exam 1
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class StackPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, 
										   Color.YELLOW, Color.CYAN, Color.MAGENTA,
										   Color.PINK, Color.GRAY, Color.ORANGE,
										   Color.WHITE};

	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	private Stack stack;
	private int x, y;
	
	// constructor
	public StackPanel() {
	
		// Initialize the model
		stack = new Stack();
		stack.addBox(new Box(180, 150));
		stack.addBox(new Box(120, 95));
		stack.addBox(new Box(90, 60));
		stack.addBox(new Box(40, 30));
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.WHITE);

		// Register mouse button click event handler
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});
	}
	
	// TODO: Set x, y coordinates for left click
	private void handleMouseClick(MouseEvent e) {
		// TODO: Add click handler
		if (e.getButton() == MouseEvent.BUTTON1) {
			x = e.getX();
			y = e.getY();
			repaint();
		}
	}
	
	// View method
	@Override
	public void paint(Graphics g) {
		super.paint(g); // paint background

		// TODO: Draw the stack using filled rectangles
		for (int i = 0; i < stack.getStackSize(); i++) {
			int newx = x - (stack.getBoxes().get(i).getWidth())/2;
			int newy = y - (stack.getBoxes().get(i).getHeight())/2;
			g.setColor(colors[i]);
			g.fillRect(newx, newy, stack.getBoxes().get(i).getWidth(), stack.getBoxes().get(i).getHeight());
		}
	}
}
