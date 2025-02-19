import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    CarShop<Volvo240> shop = new CarShop<Volvo240>(10, new double[] {300,300});

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Saab95 saab = new Saab95();
        saab.setPos(new double[] {0,100});

        Scania scania = new Scania();
        scania.setPos(new double[] {0,200});

        cc.cars.add(new Volvo240());
        cc.cars.add(saab);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                if (!car.getStored()) {
                    car.move();
                    if ((shop.getPos()[0] < car.getPos()[0] && car.getPos()[0] < shop.getPos()[0] + 101) && (shop.getPos()[1] < car.getPos()[1] && car.getPos()[1] < shop.getPos()[0] + 96)) {
                        if (car instanceof Volvo240) {
                            shop.loadCar((Volvo240) car);
                            car.setPos(shop.getPos());

                        } else {
                            car.setPos(new double[]{0, 0});
                            car.turnLeft();
                            car.turnLeft();
                        }
                    }
                    int x = (int) Math.round(car.getPos()[0]);
                    int y = (int) Math.round(car.getPos()[1]);
                    if (x > 700 || x < 0 || y > 500 || y < 0) {
                        car.turnLeft();
                        car.turnLeft();
                    }
                    frame.drawPanel.moveit(x, y, car);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Vehicle car : cars) {
           if (!car.getStored()) {
               car.gas(gas);
           }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void turnLeft() {
        for (Vehicle car : cars) {
            if (!car.getStored()) {
                car.turnLeft();
            }
        }
    }

    void turnRight() {
        for (Vehicle car : cars) {
            if (!car.getStored()) {
                car.turnRight();
            }
        }
    }
}
