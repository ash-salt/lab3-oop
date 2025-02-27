package View;
import Controller.ControlMedium;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JPanel{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    ControlMedium carC;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton leftButton = new JButton("Turn Left");
    JButton rightButton = new JButton("Turn Right");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Model.Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton[] buttonArray = {
            gasButton, leftButton, turboOnButton, liftBedButton, brakeButton, rightButton, turboOffButton, lowerBedButton
    };

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(){
    }

    private JSpinner generateSpinner(int initialvalue, int min, int max, int step) {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(initialvalue, //initial value
                        min, //min
                        max, //max
                        step);//step
        return new JSpinner(spinnerModel);
    }

    private void generateButtonLayout(JPanel panel, int nrRows, int nrCols, JButton[] buttonArray) {
        panel.setLayout(new GridLayout(nrRows, nrCols));
        for (int i = 0; i < buttonArray.length; i++) {
            controlPanel.add(buttonArray[i], i);
        }

    }

    private void initButtonFunctions() {
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turnLeft();
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turnRight();
            }
        });
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        gasSpinner = generateSpinner(0, 0, 100, 1);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        generateButtonLayout(controlPanel, 2, 5, buttonArray);

        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        //skapar funktion för knapparna
        initButtonFunctions();

    }
}