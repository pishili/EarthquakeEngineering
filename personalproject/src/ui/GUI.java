package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
class GUI {
    private JFrame mainFrame;
    private JLabel bottomLabel = new JLabel("", JLabel.CENTER);;
    private final JTextField fromTextField = new JTextField("From Date");
    private final JTextField toTextField = new JTextField("To Date");
    private DefaultListModel earthquakeModel = new DefaultListModel();
    private JList earthquakeList;

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
        mainFrame.setLayout(new GridLayout(4, 1));

        // Date selection panel
        JPanel dateSelectionPanel = new JPanel();
        dateSelectionPanel.setLayout(new FlowLayout());
        JButton submitButton = new JButton("Submit");
        // Add ActionListener
        submitButton.addActionListener(new SubmitButtonClickListener());
        // Adding to JPanel
        dateSelectionPanel.add(fromTextField);
        dateSelectionPanel.add(toTextField);
        dateSelectionPanel.add(submitButton);

        // Bottom label
        bottomLabel.setSize(350, 100);

        // Add items to main frame
        mainFrame.add(dateSelectionPanel);
        mainFrame.add(bottomLabel);

        // Earthquake Selection Panel
        JPanel earthquakeSelectionPanel = new JPanel();
        earthquakeList = new JList(earthquakeModel);
        earthquakeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        earthquakeList.setSelectedIndex(0);
        earthquakeList.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(earthquakeList);
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ShowButtonClickListener());
        earthquakeSelectionPanel.add(listScrollPane);
        earthquakeSelectionPanel.add(showButton);

        // Bottom label
        bottomLabel = new JLabel("", JLabel.CENTER);
        bottomLabel.setSize(350, 100);

        // Add items to main frame
        mainFrame.add(dateSelectionPanel);
        mainFrame.add(earthquakeSelectionPanel);
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
            earthquakeModel.addElement("ladan");
        }
    }

    private
    class ShowButtonClickListener implements ActionListener {
        public
        void actionPerformed(ActionEvent e) {
            bottomLabel.setText("Clicked Show: " + earthquakeList.getSelectedValue());
        }
    }

}
