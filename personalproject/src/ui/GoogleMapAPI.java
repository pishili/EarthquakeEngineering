package ui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class GoogleMapAPI {

    public String getImageFilDestination(String latitude, String longitude, String markerColor) {
        String destinationFile = null;
        try {
            // change the numbers based on the centre of the screen
            // change as the user
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
                    + latitude
                    + ","
                    + longitude
                    + "&size=600x300"
                    + "&zoom=5"
                    + "&markers=color:"
                    +  markerColor
                    + "%7Clabel:S%7C"
                    + latitude
                    + ","
                    + longitude
                    // change to sattelite map
                    + "&key=AIzaSyCcYrfTKZz2qXMLfn2EbllCCWQf_9CW74A";
            destinationFile = "image.jpg";

            System.out.println(imageUrl);

            // read the map image from Google
            // then save it to a local file: image.jpg
            // downloading image
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            //2048
            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationFile;
    }
}
