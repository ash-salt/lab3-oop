package Model;

public class VolvoFactory implements VehicleFactory{
    @Override
    public Volvo240 createVehicle(int[] pos) {
        return new Volvo240(pos);
    }
}
