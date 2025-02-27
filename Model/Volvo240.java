package Model;

import java.awt.*;

public class Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;

    public Volvo240(double[] position){

        super(4, 100, Color.black, "Model.Volvo240");
        stopEngine();
        setPos(position);

    }

    @Override
    public double speedFactor(){

        return getEnginePower() * 0.01 * trimFactor;

    }




}


