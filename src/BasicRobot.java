import java.awt.*;

public class BasicRobot {
    //variables
    private int x;
    private int y;
    private int direction; // 0: up, 1: right, 2: down, 3: left

    //constructor
    public BasicRobot(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 0; // default direction
    }
    //getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    //setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        direction = (direction + 3) % 4; // rotating 90 degrees to the left
    }

    public void move() throws IllegalMoveException {
        // Calculate the new position based on the direction
        int newX = x;
        int newY = y;
        switch (direction) {
            case 0: // up
                newY--;
                break;
            case 1: // right
                newX++;
                break;
            case 2: // down
                newY++;
                break;
            case 3: // left
                newX--;
                break;
        }
        // Check if the new position is within the boundaries
        if (newX < 0 || newY < 0 || newX >= RobotsWorldPanel.N || newY >= RobotsWorldPanel.N) {
            throw new IllegalMoveException("Cannot move to the specified location");
        }
        // update the current position
        x = newX;
        y = newY;
    }


    public void draw(Graphics g, int tileSize) {
        // Draw the robot at its current position
        g.setColor(Color.RED);
        g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
    }
}