import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CountFrame extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CountFrame frame = new CountFrame();

                // embed a CountPanel in the frame
                frame.add(new CountPanel());

                // "packing" the frame causes it to adjust its size based
                // on the panel's preferred size
                frame.pack();

                // when the frame is closed, exit the program
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // making the frame visible starts the program
                frame.setVisible(true);
            }
        });
    }
}
