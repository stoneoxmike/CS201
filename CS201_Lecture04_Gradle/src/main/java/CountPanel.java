import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class CountPanel extends JPanel {
    // constants defining the preferred width and height of the panel
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    // this font will be used to display the count
    private static final Font font = new Font("Dialog", Font.BOLD, 48);

    // field storing the current model
    private CountModel countModel;

    // constructor
    public CountPanel() {
    	// Initialize model
        countModel = new CountModel();

        setBackground(Color.GRAY);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // install event handlers
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });
    }

	// Controller methods (event handlers)
    private void handleMouseClick(MouseEvent e) {
        // change the "state" of the model on mouse click
        countModel.incrementCount();
        countModel.incrementColorIndex();

        // now that the state is changed,
        // redraw the panel to reflect the state change
        repaint();
    }

	// View methods (paint)
    @Override
    public void paint(Graphics g) {
        super.paint(g); // call the superclass's paint() method to paint the background

        // draw the rectangle
        g.setColor(countModel.colors[countModel.getColorIndex()]);
        g.fillRect(20, 20, WIDTH - 40, HEIGHT - 40);

        // draw the count
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("" + countModel.getCount(), 50, 150);
    }
}
