public class RightTurner extends BasicRobot {

    //constructor
    public RightTurner(int x, int y) {
        super(x, y);
    }

    public void turnRight() {
        int newDirection = (getDirection() + 1) % 4; // rotating 90 degrees to the right
        setDirection(newDirection);
    }
}
