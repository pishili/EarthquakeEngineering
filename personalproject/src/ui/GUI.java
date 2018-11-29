package ui;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
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
    private JLabel bottomLabel = new JLabel("", JLabel.CENTER);
    private DefaultListModel earthquakeModel = new DefaultListModel();
    private JComboBox earthquakeMagnitude;
    private JComboBox earthquakePeriod;
    private JList<Earthquake> earthquakeList;
    private ImageIcon imageIcon;
    private JLabel mapJLabel;
    private JXMapKit jXMapKit = new JXMapKit();


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
        mainFrame.setLayout(new GridBagLayout());

        // selection panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
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
        inputPanel.add(dropDownLabel);
        inputPanel.add(earthquakeMagnitude);
        inputPanel.add(dropDownLabelForPeriod);
        inputPanel.add(earthquakePeriod);
        inputPanel.add(submitButton);

        // Bottom label
        bottomLabel.setSize(350, 100);

        // Earthquake Selection Panel
        JPanel earthquakeSelectionPanel = new JPanel();

        // creating earthquakeList using JList
        earthquakeList = new JList(earthquakeModel);
        // using setters on earthquakeList
        earthquakeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        earthquakeList.setSelectedIndex(0);
        earthquakeList.setVisibleRowCount(10);
        // creating JScrollPane
        JScrollPane listScrollPane = new JScrollPane(earthquakeList);
        // creating showButton
        JButton showButton = new JButton("Show");
        // adding listener to show button
        showButton.addActionListener(new ShowButtonClickListener());
        // adding the listScrollPane and showButton to
        earthquakeSelectionPanel.add(listScrollPane);
        earthquakeSelectionPanel.add(showButton);

        // Map Image
        imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
                .getImage().getScaledInstance(600, 300,
                        java.awt.Image.SCALE_SMOOTH));
        mapJLabel = new JLabel(imageIcon);

        // Interactive Map
        // TileFactoryInfo info = new OSMTileFactoryInfo();
        TileFactoryInfo info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);
        jXMapKit.setZoom(11);

        // Bottom label
        bottomLabel = new JLabel("", JLabel.CENTER);
        bottomLabel.setSize(350, 100);

        // Add items to main frame
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        mainFrame.add(inputPanel, c);
        c.gridy = 1;
        mainFrame.add(earthquakeSelectionPanel, c);
        c.gridy = 2;
        mainFrame.add(mapJLabel, c);
        c.gridy = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jXMapKit, c);
        c.gridy = 4;
        mainFrame.add(bottomLabel, c);
    }


    private
    void showGui() {
        mainFrame.setVisible(true);
    }

    private
    class SubmitButtonClickListener implements ActionListener {
        @Override
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
                JOptionPane.showMessageDialog(mainFrame, "Make sure to connect to internet", "Oops", ERROR_MESSAGE);
            }
        }
    }

    private
    class ShowButtonClickListener implements ActionListener {

        @Override
        public
        void actionPerformed(ActionEvent e) {
            String color;
            if (earthquakeList.getSelectedValue() == null) {
                JOptionPane.showMessageDialog(mainFrame, "Please select an earthquake first", "Oops", ERROR_MESSAGE);
            } else {
                Earthquake earthquake = earthquakeList.getSelectedValue();

                GoogleMapAPI googleMapAPI = new GoogleMapAPI();
                String fileDestination = googleMapAPI.getImageFilDestination(earthquake.getLatitude().toString(), earthquake.getlongitude().toString(), getMarkerColorWithMagnitude(earthquake));
                imageIcon = new ImageIcon((new ImageIcon(fileDestination))
                        .getImage().getScaledInstance(600, 300,
                                java.awt.Image.SCALE_SMOOTH));
                // mapJLabel = new JLabel(imageIcon);
                mapJLabel.setIcon(imageIcon);

                // Adding Interactive Map location
                final GeoPosition gp = new GeoPosition(earthquake.getLatitude(), earthquake.getlongitude());
                jXMapKit.setAddressLocation(gp);

                bottomLabel.setText(earthquake.toString());
            }
        }

        public String getMarkerColorWithMagnitude(Earthquake e) {
            String color;
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
