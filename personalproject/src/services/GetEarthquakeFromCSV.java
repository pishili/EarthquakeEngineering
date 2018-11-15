package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class GetEarthquakeFromCSV {

    private static List<Earthquake> earthquakes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        //url: https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.csv
//        String csvFile = "/Users/ladan/code/data_earth/all_day.csv";
//        String csvFile = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.csv";

        // Use URL
        URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.csv");
        URLConnection connection = url.openConnection();
        InputStreamReader input = new InputStreamReader(connection.getInputStream());

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        Boolean isHeader = true;
        try {

//            br = new BufferedReader(new FileReader(csvFile));
            br = new BufferedReader(input);
            while ((line = br.readLine()) != null) {

                // Skip the header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // use comma as separator
                String[] earthquake = line.split(cvsSplitBy);

                Earthquake earthquakeObject = new Earthquake(Double.valueOf(earthquake[1]),
                                                              Double.valueOf(earthquake[2]),
                                                              Double.valueOf(earthquake[3]),
                                                              Double.valueOf(earthquake[4]),
                                                              earthquake[0]);
//
                earthquakes.add(earthquakeObject);

            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // Print all earthquakes by loopinhg through earthquakes
        for (int i=0; i<earthquakes.size(); i++) {
            System.out.println(earthquakes.get(i));
        }

    }

//    @Override
//    public String toString() {
//        String result = "ToDoList Title: " + name + "\n";
//        result += tasks.values().toString();
//        return result;
//    }
}