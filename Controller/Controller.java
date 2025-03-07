package Controller;

import Model.ControlMedium;
import View.CarAddListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private static int gasAmount;
    public static void initButtonFunctions(ControlMedium carC, CarAddListener listener, JButton[] buttonList, JButton[] startButtonList, JSpinner gasSpinner) {
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        buttonList[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        buttonList[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });

        buttonList[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turnLeft();
            }
        });

        buttonList[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turnRight();
            }
        });

        buttonList[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.toggleSaabTurbo(true);
            }
        });

        buttonList[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.toggleSaabTurbo(false);
            }
        });

        buttonList[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.toggleLiftBed(false);
            }
        });

        buttonList[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { carC.toggleLiftBed(true);}
        });

        startButtonList[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { carC.startAllCars();}
        });
        startButtonList[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { carC.stopAllCars();}
        });
        buttonList[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { carC.addRandomCar(listener);}
        });
        buttonList[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { carC.removeFirstCar(listener);}
        });


    }
}
