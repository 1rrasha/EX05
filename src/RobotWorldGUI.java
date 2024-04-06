import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RobotWorldGUI extends JFrame {

    //attributes
    private final RobotsWorldPanel worldPanel;

        public RobotWorldGUI() {
        setTitle("Abdallah, Robot World");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

            // Set icon for the JFrame
            ImageIcon icon = new ImageIcon("img.png");
            setIconImage(icon.getImage());

        worldPanel = new RobotsWorldPanel();
        getContentPane().add(worldPanel, BorderLayout.CENTER);

        JButton cmdAddRobot = new JButton("Add Robot");
            cmdAddRobot.setBackground(Color.BLUE);
            cmdAddRobot.setForeground(Color.WHITE);
        cmdAddRobot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ask the user for coordinates and add robot
                String input = JOptionPane.showInputDialog("Enter x and y coordinates (separated by space):");
                if (input != null) {
                    String[] c = input.split(" ");
                    if (c.length == 2) {
                        try {
                            int x = Integer.parseInt(c[0]);
                            int y = Integer.parseInt(c[1]);
                            worldPanel.addRobot(x, y);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid coordinates. Please enter integers :(.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter both x and y coordinates ^-^.");
                    }
                }
            }
        });

        JButton cmdMove = new JButton("Move Robots");
            cmdMove.setBackground(Color.GREEN);
            cmdMove.setForeground(Color.WHITE);
        cmdMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worldPanel.moveRobots();
            }
        });

        JButton cmdRemove = new JButton("Remove All Robots");
            cmdRemove.setBackground(Color.RED);
            cmdRemove.setForeground(Color.WHITE);
        cmdRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worldPanel.removeAllRobots();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cmdAddRobot);
        buttonPanel.add(cmdMove);
        buttonPanel.add(cmdRemove);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

}
