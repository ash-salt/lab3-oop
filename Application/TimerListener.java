package Application;

import Controller.CarController;
import Model.Scania;
import Model.Vehicle;
import Model.Volvo240;
import View.GameGraphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    public GameGraphics frame;
    public CarController cc;

    public TimerListener(GameGraphics frame, CarController cc) {
        this.frame = frame;
        this.cc = cc;
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : cc.getCars()) {
            if (!car.getStored() && !(car instanceof Scania && ((Scania) car).getRampUp())) {
                car.move();
                try {
                    cc.getShop().checkCollideWithVehicle((Volvo240) car);
                } catch (RuntimeException _) {
                }
                int x = car.getPos()[0];
                int y = car.getPos()[1];
                if (x > 700 || x < 0 || y > 500 || y < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                //Bör returnera X och Y värdena så att main kan exekvera denna kod istället
                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
            }
        }
    }
}
