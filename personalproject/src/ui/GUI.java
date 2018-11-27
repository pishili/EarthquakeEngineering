package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public
class GUI {
    private JFrame mainFrame;

    public
    GUI() {
        prepareGui();
    }

    public static
    void main(String[] args) {
        GUI gui = new GUI();
        gui.showGui();
    }


    private
    void prepareGui() {
        // Main Frame
        mainFrame = new JFrame("Earthquake Monitor");
        mainFrame.setSize(900, 900);
        mainFrame.setLayout(new GridLayout(3, 1));

        // Top label
        JLabel topLabel = new JLabel("", JLabel.CENTER);
        topLabel.setText("Monitor your Area Earthquake");

        // Date selection panel
        JPanel dateSelectionPanel = new JPanel();
        dateSelectionPanel.setLayout(new FlowLayout());
        JTextField fromTextField = new JTextField("From Date");
        JTextField toTextField = new JTextField("To Date");
        JButton submitButton = new JButton("Submit");
        dateSelectionPanel.add(fromTextField);
        dateSelectionPanel.add(toTextField);
        dateSelectionPanel.add(submitButton);

        // Bottom label
        JLabel bottomLabel = new JLabel("", JLabel.CENTER);
        bottomLabel.setSize(350, 100);

        // Add items to main frame
        mainFrame.add(topLabel);
        mainFrame.add(dateSelectionPanel);
        mainFrame.add(bottomLabel);
    }


    private
    void showGui() {
        mainFrame.setVisible(true);
    }

}
