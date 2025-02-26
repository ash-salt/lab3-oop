import Controller.CarController;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;
import View.CarView;
import View.GameGraphics;

public class Main {
    public static void main(String[] args) {
        CarController cc = new CarController();

        Saab95 saab = new Saab95();
        saab.setPos(new double[] {0,100});

        Scania scania = new Scania();
        scania.setPos(new double[] {0,200});

        cc.cars.add(new Volvo240());
        cc.cars.add(saab);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new GameGraphics("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
