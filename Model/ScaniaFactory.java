package Model;

public class ScaniaFactory implements VehicleFactory{
    @Override
    public Scania createVehicle(int[] pos) {
        return new Scania(pos);
    }
}
