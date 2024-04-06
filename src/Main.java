import javax.swing.*;

class Main {
    public static void main(String[] args) {
        //run the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RobotWorldGUI gui = new RobotWorldGUI();
                gui.setVisible(true);
            }
        });
    }
}