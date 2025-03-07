package Application;

import Controller.CarController;
import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import Model.Volvo240;
import View.GameGraphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        // Start a new view and send a reference of self
        GameGraphics frame = new GameGraphics("CarSim 1.0", cc, cc.getCars());
        int delay = 50;

        Timer timer = new Timer(delay, new TimerListener(frame, cc));
        // Start the timer
        timer.start();
    }


}
