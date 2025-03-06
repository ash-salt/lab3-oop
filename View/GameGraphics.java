package View;

import Controller.ControlMedium;
import Model.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGraphics extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;
    DrawPanel drawPanel;
    CarView carView = new CarView();

    public GameGraphics(String framename, ControlMedium cc, ArrayList<Vehicle> carList){
        drawPanel = new DrawPanel(X, Y-240, carList);
        constructInterface(framename, cc);
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public CarView getCarView() {
        return carView;
    }

    public void constructInterface(String title, ControlMedium cc) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        carView.initComponents(this, cc, drawPanel);

        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //kod här
    }


}
