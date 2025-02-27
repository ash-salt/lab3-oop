package Model;

import java.awt.*;

public class Saab95 extends Vehicle {
    //Ärver majoritet från Car

    private boolean turboOn;

    public Saab95(double[] position){

        super(2, 125, Color.red, "Model.Saab95");
        //Initierar från car med bestämda värden.

	    turboOn = false;
        setPos(position);

        stopEngine();

    }

    public void setTurboOn(){

	    turboOn = true;

    }

    public void setTurboOff(){

	    turboOn = false;

    }

    @Override
    public double speedFactor(){

        double turbo = 1;

        if(turboOn) turbo = 1.3;

        return getEnginePower() * 0.01 * turbo;

    }




}
