import javax.swing.*;
import java.awt.*;

public class CricketField extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        setBackground(Color.GREEN);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the boundary
        g2d.setColor(Color.WHITE);
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height) - 40;
        g2d.drawOval((width - diameter) / 2, (height - diameter) / 2, diameter, diameter);

        // Draw the pitch
        int pitchWidth = 20;
        int pitchHeight = 180;
        g2d.setColor(new Color(139, 69, 19)); // Brown color for the pitch
        g2d.fillRect((width - pitchWidth) / 2, (height - pitchHeight) / 2, pitchWidth, pitchHeight);

        // Draw the wickets
        int wicketWidth = 5;
        int wicketHeight = 30;
        int pitchCenterX = width / 2;
        int pitchCenterY = height / 2;
        
        g2d.setColor(Color.WHITE);
        // Stumps at one end
        g2d.fillRect(pitchCenterX - 10, pitchCenterY - pitchHeight / 2 - wicketHeight, wicketWidth, wicketHeight);
        g2d.fillRect(pitchCenterX, pitchCenterY - pitchHeight / 2 - wicketHeight, wicketWidth, wicketHeight);
        g2d.fillRect(pitchCenterX + 10, pitchCenterY - pitchHeight / 2 - wicketHeight, wicketWidth, wicketHeight);

        // Stumps at the other end
        g2d.fillRect(pitchCenterX - 10, pitchCenterY + pitchHeight / 2, wicketWidth, wicketHeight);
        g2d.fillRect(pitchCenterX, pitchCenterY + pitchHeight / 2, wicketWidth, wicketHeight);
        g2d.fillRect(pitchCenterX + 10, pitchCenterY + pitchHeight / 2, wicketWidth, wicketHeight);
        
        // Draw the crease lines
        g2d.drawLine(pitchCenterX - 40, pitchCenterY - pitchHeight / 2, pitchCenterX + 40, pitchCenterY - pitchHeight / 2);
        g2d.drawLine(pitchCenterX - 40, pitchCenterY + pitchHeight / 2, pitchCenterX + 40, pitchCenterY + pitchHeight / 2);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cricket Field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CricketField());
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CricketField::createAndShowGUI);
    }
}