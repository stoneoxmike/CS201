import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class CirclesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Color c = Color.RED;
    // this font will be used to display the count
    private static final Font font = new Font("Dialog", Font.BOLD, 48);

	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	// TODO: add model field and outline disk fields
	private CirclesModel circlesModel;
	private int centerX;
	private int centerY;
	private int radius;
	
	// constructor
	public CirclesPanel() {
	
		// TODO: initialize the fields
		circlesModel = new CirclesModel();
		centerX = 0;
		centerY = 0;
		radius = CirclesModel.START_R;
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.WHITE);

		// Register mouse motion event handler
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				handleMouseMove(e);
			}
		});

		// Register mouse button click event handler
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});
	}
	
	// Controller methods
	private void handleMouseMove(MouseEvent e) {
		// TODO: update outline position
		centerX = e.getX();
		centerY = e.getY();
		repaint();
	}

	private void handleMouseClick(MouseEvent e) {
		// TODO: place new circle for left click
		//       increase radius for right click
		if (e.getButton() == MouseEvent.BUTTON1) {
			circlesModel.addCircle(centerX, centerY, radius);
			circlesModel.updateCount();
			radius = CirclesModel.START_R;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			radius = radius + CirclesModel.START_R;
		}
		repaint();
	}
	
	// View method
	@Override
	public void paint(Graphics g) {
		super.paint(g); // paint background
		
		// TODO: draw model Circle first - why?
		int modelRadius = circlesModel.getCircle().getR();
		int modelX = circlesModel.getCircle().getX() - modelRadius;
		int modelY = circlesModel.getCircle().getY() - modelRadius;
		g.fillOval(modelX, modelY, 2*modelRadius, 2*modelRadius);
		// TODO: draw the outline
		int ovalX = centerX - radius;
		int ovalY = centerY - radius;
		g.drawOval(ovalX, ovalY, 2*radius, 2*radius);
		// TODO: draw the count
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("" + circlesModel.getCount(), 25, 50);
	}
}
