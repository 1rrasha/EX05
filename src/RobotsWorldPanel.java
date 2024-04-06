import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class RobotsWorldPanel extends JPanel {

    //attributes
    private Vector<BasicRobot> robots;
    public static final int N = 10;

    //constructor
    public RobotsWorldPanel() {
        robots = new Vector<>();
    }

    //methods
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the world grid
        g.setColor(Color.BLACK);
        int tileSize = getWidth() / N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }
        // Draw the robots
        for (BasicRobot robot : robots) {
            robot.draw(g, tileSize);
        }
    }

    public void addRobot(int x, int y) {
        // Create and add a new robot to the world
        RightTurner robot = new RightTurner(x, y);
        robots.add(robot);
        repaint();
    }

    public void moveRobots() {
        for (BasicRobot robot : robots) {
            try {
                robot.move();
            } catch (IllegalMoveException e) {
                if (robot instanceof RightTurner) {
                    RightTurner rightTurner = (RightTurner) robot;
                    rightTurner.turnRight();
                }
            }
        }
        repaint();
    }

    public void removeAllRobots() {
        robots.clear();
        repaint();
    }
}
