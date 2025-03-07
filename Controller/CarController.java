package Controller;

import Model.*;
import View.CarAddListener;

import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements ControlMedium{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    CarShop<Volvo240> shop = new CarShop<>(10, new int[] {300,300});

    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    public CarShop<Volvo240> getShop() {
        return shop;
    }

    public void addCar(Vehicle car) {cars.add(car);}

    public ArrayList<Vehicle> getCars() {
        return (ArrayList<Vehicle>) cars.clone();
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Vehicle car : cars) {
           if (!(car instanceof Scania && ((Scania) car).getRampUp())) {
               if (!car.getStored()) {
                   car.gas(gas);
               }
           }

        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    public void turnLeft() {
        for (Vehicle car : cars) {
            if (!car.getStored()) {
                car.turnLeft();
            }
        }
    }

    public void turnRight() {
        for (Vehicle car : cars) {
            if (!car.getStored()) {
                car.turnRight();
            }
        }
    }
    public void stopAllCars() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
    public void startAllCars(){
        for (Vehicle car : cars) {
            if (!car.getStored()) {
                car.startEngine();
            }
        }
    }
    public void toggleSaabTurbo(boolean state) {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                if (state) {
                    ((Saab95) car).setTurboOn();
                }
                else {
                    ((Saab95) car).setTurboOff();
                }
            }
        }
    }

    public void toggleLiftBed(boolean state) {
        for (Vehicle car : cars) {
            if (car instanceof Scania && car.getCurrentSpeed() == 0) {
                if (state) {
                    ((Scania) car).adjustFlatbed();
                }
                else {
                    ((Scania) car).adjustFlatbed(0);
                }
            }
        }
    }

    public void addRandomCar(CarAddListener frame) {
        if (!(cars.size() >= 10)) {
            Random rand = new Random();
            int i = rand.nextInt(3);
            VehicleFactory factory;
            if (i == 0) {
                factory = new VolvoFactory();
            } else if (i == 1) {
                factory = new SaabFactory();
            } else {
                factory = new ScaniaFactory();
            }
            Vehicle car = factory.createVehicle(new int[] {0,0});
            addCar(car);
            frame.addCar(car);
        } else {
            System.out.println("Cannot add more cars");
        }
    }

    public void removeFirstCar(CarAddListener listener) {
        if (!(cars.isEmpty())) {
            listener.removeCar(cars.getFirst());
            cars.removeFirst();
            //System.out.println(cars.getFirst().getModel());
        }

    }

}
