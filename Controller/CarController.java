package Controller;

import Model.*;
import View.CarView;
import View.GameGraphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    public GameGraphics frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    CarShop<Volvo240> shop = new CarShop<Volvo240>(10, new double[] {300,300});

    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                if (!car.getStored()) {
                    car.move();
                    try {
                        shop.checkCollideWithVehicle((Volvo240) car);
                    } catch (RuntimeException ex) {
                        car.reset();
                    }
                    int x = (int) Math.round(car.getPos()[0]);
                    int y = (int) Math.round(car.getPos()[1]);
                    if (x > 700 || x < 0 || y > 500 || y < 0) {
                        car.turnLeft();
                        car.turnLeft();
                    }
                    //Bör returnera X och Y värdena så att main kan exekvera denna kod istället
                    frame.getDrawPanel().moveit(x, y, car);
                    // repaint() calls the paintComponent method of the panel
                    frame.getDrawPanel().repaint();
                }
            }
        }
    }

    public void addCar(Vehicle car) {cars.add(car);}

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
