package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
class GUI {
    private JFrame mainFrame;
    private JLabel bottomLabel = new JLabel("", JLabel.CENTER);
    private final JTextField fromTextField = new JTextField("From Date");
    private final JTextField toTextField = new JTextField("To Date");

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
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonClickListener());
        dateSelectionPanel.add(fromTextField);
        dateSelectionPanel.add(toTextField);
        dateSelectionPanel.add(submitButton);

        // Bottom label
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

    private
    class SubmitButtonClickListener implements ActionListener {
        public
        void actionPerformed(ActionEvent e) {
            bottomLabel.setText("Selecting Earthquake from date: " + fromTextField.getText() + ", to date: " + toTextField.getText());
        }
    }

}
