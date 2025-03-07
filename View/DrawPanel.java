package View;

import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import Model.Volvo240;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements CarAddListener{

    // Just a single image, TODO: Generalize
    private Map<Vehicle, BufferedImage> carDict = new Hashtable<>();



    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a single car's position

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> carList) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "View.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: View.pics -> MOVE *.jpg to View.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        for (Vehicle car: carList) {
            BufferedImage selectedImage = switch (car) {
                case Volvo240 volvo240 -> volvoImage;
                case Saab95 saab95 -> saabImage;
                case Scania scania -> scaniaImage;
                case null, default -> throw new IllegalArgumentException("Vehicle is of unsupported type");
            };

            carDict.put(car, selectedImage);
        }

    }

    public void addCar(Vehicle car) {
        BufferedImage selectedImage;
        switch (car) {
            case Volvo240 volvo240 -> selectedImage = volvoImage;
            case Saab95 saab95 -> selectedImage = saabImage;
            case Scania scania -> selectedImage = scaniaImage;
            case null, default -> throw new IllegalArgumentException("Vehicle is of unsupported type");
        }
        carDict.put(car, selectedImage);
    }

    public void removeCar(Vehicle car) {
        carDict.remove(car);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Map.Entry<Vehicle, BufferedImage> entry : carDict.entrySet()) {
            Vehicle key = entry.getKey();
            BufferedImage val = entry.getValue();
            g.drawImage(val, key.getPos()[0], key.getPos()[1], null);
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
