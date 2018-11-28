package ui;

import services.Earthquake;
import services.GetEarthquakeFromCSV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JOptionPane.ERROR_MESSAGE;


public
class GUI {
    private JFrame mainFrame;
    private JLabel bottomLabel = new JLabel("", JLabel.CENTER);;
    private DefaultListModel earthquakeModel = new DefaultListModel();
    private JComboBox earthquakeMagnitude;
    private JComboBox earthquakePeriod;
    private JList<Earthquake> earthquakeList;
    private ImageIcon imageIcon;
    private JLabel mapJLabel;

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
        mainFrame.setSize(1000, 800);
        mainFrame.setLayout(new GridLayout(4, 1));

        // Magnitude selection panel
        JPanel magnitudeSelectorPanel = new JPanel();
        magnitudeSelectorPanel.setLayout(new FlowLayout());
        // Label for Magnitude
        JLabel dropDownLabel = new JLabel("Magnitude:");
        // Magnitude
        DefaultComboBoxModel earthquakeMagnitudeModel = new DefaultComboBoxModel();
        earthquakeMagnitudeModel.addElement("all");
        earthquakeMagnitudeModel.addElement("1.0");
        earthquakeMagnitudeModel.addElement("2.5");
        earthquakeMagnitudeModel.addElement("4.5");
        earthquakeMagnitudeModel.addElement("significant");
        earthquakeMagnitude = new JComboBox(earthquakeMagnitudeModel);

        // Label for Period
        JLabel dropDownLabelForPeriod = new JLabel("Period:");
        // Period
        DefaultComboBoxModel earthquakePeriodModel = new DefaultComboBoxModel();
        earthquakePeriodModel.addElement("hour");
        earthquakePeriodModel.addElement("day");
        earthquakePeriodModel.addElement("week");
        earthquakePeriod = new JComboBox(earthquakePeriodModel);
        // Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonClickListener());
        // Adding to JPanel
        magnitudeSelectorPanel.add(dropDownLabel);
        magnitudeSelectorPanel.add(earthquakeMagnitude);
        magnitudeSelectorPanel.add(dropDownLabelForPeriod);
        magnitudeSelectorPanel.add(earthquakePeriod);
        magnitudeSelectorPanel.add(submitButton);

        // Bottom label
        bottomLabel.setSize(350, 100);

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

        // Map Image
        imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
                .getImage().getScaledInstance(630, 600,
                        java.awt.Image.SCALE_SMOOTH));
        mapJLabel = new JLabel(imageIcon);

        // Bottom label
        bottomLabel = new JLabel("", JLabel.CENTER);
        bottomLabel.setSize(350, 100);

        // Add items to main frame
        mainFrame.add(magnitudeSelectorPanel);
        mainFrame.add(earthquakeSelectionPanel);
        mainFrame.add(mapJLabel);
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
                for (Earthquake eq: getEarthquakeFromCSV.getEarthquakes(earthquakeMagnitude.getSelectedItem().toString(), earthquakePeriod.getSelectedItem().toString())) {
                    earthquakeModel.addElement(eq);
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
            String color;
            if (earthquakeList.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(mainFrame, "Please select an earthquake first", "Oops", ERROR_MESSAGE);
            } else {
                Earthquake earthquake = earthquakeList.getSelectedValue();



                GoogleMapAPI googleMapAPI = new GoogleMapAPI();
                googleMapAPI.getImageURL(earthquake.getLatitude().toString(), earthquake.getlongitude().toString(), getMarkerColorWithMagnitude(earthquake));
                imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
                        .getImage().getScaledInstance(700, 700,
                                java.awt.Image.SCALE_SMOOTH));
                // mapJLabel = new JLabel(imageIcon);
                mapJLabel.setIcon(imageIcon);

                bottomLabel.setText("Clicked Show: " + earthquake);

            }
        }

        public String getMarkerColorWithMagnitude(Earthquake e) {
            String color = null;
            Earthquake earthquake = earthquakeList.getSelectedValue();
            if (e.getMagnitude()<3) {
                color = "green";
            } else if(e.getMagnitude()<4 ) {
                color = "yellow";
            } else if(e.getMagnitude()<5 ) {
                color = "orange";
            } else {
                color = "red";
            }
            return color;
        }
    }
}
