package ui;

import services.Earthquake;
import services.GetEarthquakeFromCSV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public
class GUI {
    private JFrame mainFrame;
    private JLabel bottomLabel = new JLabel("", JLabel.CENTER);;
    private DefaultListModel earthquakeModel = new DefaultListModel();
    private JComboBox earthquakeMagnitude;
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

        // Magnitude selection panel
        JPanel magnitudeSelectorPanel = new JPanel();
        magnitudeSelectorPanel.setLayout(new FlowLayout());
        DefaultComboBoxModel earthquakeMagnitudeModel = new DefaultComboBoxModel();
        earthquakeMagnitudeModel.addElement("all");
        earthquakeMagnitudeModel.addElement("1.0");
        earthquakeMagnitudeModel.addElement("2.5");
        earthquakeMagnitudeModel.addElement("4.5");
        earthquakeMagnitudeModel.addElement("significant");
        earthquakeMagnitude = new JComboBox(earthquakeMagnitudeModel);
        JLabel dropDownLabel = new JLabel("Magnitude in Richter");
        JButton submitButton = new JButton("Submit");
        // Add ActionListener
        submitButton.addActionListener(new SubmitButtonClickListener());
        // Adding to JPanel
        magnitudeSelectorPanel.add(dropDownLabel);
        magnitudeSelectorPanel.add(earthquakeMagnitude);
        magnitudeSelectorPanel.add(submitButton);

        // Bottom label
        bottomLabel.setSize(350, 100);

        // Add items to main frame
        mainFrame.add(magnitudeSelectorPanel);
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
        mainFrame.add(magnitudeSelectorPanel);
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
            bottomLabel.setText("Selecting Earthquake for magnitude: " + earthquakeMagnitude.getSelectedItem());
            earthquakeModel.removeAllElements();
            GetEarthquakeFromCSV getEarthquakeFromCSV = new GetEarthquakeFromCSV();

            try {
                for (Earthquake eq: getEarthquakeFromCSV.getEarthquakes(earthquakeMagnitude.getSelectedItem().toString())) {
                    earthquakeModel.addElement(eq.toString());
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
