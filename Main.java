import Controller.CarController;
import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import Model.Volvo240;
import View.CarView;
import View.GameGraphics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240(new int[] {0,0});

        Saab95 saab = new Saab95(new int[] {0,100});

        Scania scania = new Scania(new int[] {0,200});

        cc.addCar(volvo);
        cc.addCar(saab);
        cc.addCar(scania);

        ArrayList<Vehicle> drawCarList = new ArrayList<>();
        drawCarList.add(volvo);
        drawCarList.add(saab);
        drawCarList.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new GameGraphics("CarSim 1.0", cc, drawCarList);

        // Start the timer
        cc.timer.start();
    }
}
