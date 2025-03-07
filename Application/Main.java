package Application;

import Controller.Controller;
import Model.CarController;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;
import View.CarView;
import View.GameGraphics;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        CarController cc = new CarController();

        // Start a new view and send a reference of self
        GameGraphics frame = new GameGraphics("CarSim 1.0", cc, cc.getCars());

        CarView cv = frame.getCarView();

        Controller.initButtonFunctions(cc, frame.getDrawPanel(), cv.getButtonArray(), cv.getStartButtonArray(), cv.getGasSpinner());


        int delay = 50;
        Timer timer = new Timer(delay, new TimerListener(frame, cc));
        // Start the timer
        timer.start();
    }


}
