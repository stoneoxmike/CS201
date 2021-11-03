import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// You won't need to modify this class.
public class StackFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StackFrame frame = new StackFrame();
				frame.add(new StackPanel());
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Exam 01");
				frame.setVisible(true);
			}
		});
	}
}
