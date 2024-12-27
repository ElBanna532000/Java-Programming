import javax.swing.*;
import java.awt.*;

public class DateTimeApp extends JFrame implements Runnable {

    private Thread th;
    private int xPosition = 0; // Current x-axis position of the string
    private final int yPosition = 200; // Fixed y-axis position of the string
    private final String text = "Hello, Mahmoud";
    private final int delay = 20; // Animation delay in milliseconds
    private int direction = 1; // 1 for right, -1 for left

    public DateTimeApp() {
        this.setTitle("Moving Text Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400); // size of the initial window
        this.setVisible(true);
        th = new Thread(this);
        th.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(text, xPosition, yPosition);
    }

    public static void main(String[] args) {
        new DateTimeApp();
    }

    @Override
    public void run() {
        while (true) {
            // Update xPosition for movement
            xPosition += direction * 2;

            // Reverse direction if the text reaches the frame boundaries
            if (xPosition + getFontMetrics(new Font("Arial", Font.BOLD, 24)).stringWidth(text) > getWidth()
                    || xPosition < 0) {
                direction *= -1;
            }

            repaint();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}