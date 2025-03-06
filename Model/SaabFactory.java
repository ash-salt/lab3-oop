package Model;

public class SaabFactory implements VehicleFactory{
    @Override
    public Saab95 createVehicle(int[] pos) {
        return new Saab95(pos);
    }
}
