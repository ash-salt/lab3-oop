package Model;

import java.util.ArrayList;

public class CarShop<T extends Vehicle> {
    private final int capacity;
    private ArrayList<T> storage;
    private final int[] position;

    public CarShop(int capacity, int[] position){
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not be negative or 0");
        }
        this.capacity = capacity;
        this.storage = new ArrayList<>();
        this.position = position;
    }

    public void checkCollideWithVehicle(T car) {
        if ((getPos()[0] < car.getPos()[0] && car.getPos()[0] < getPos()[0] + 101) && (getPos()[1] < car.getPos()[1] && car.getPos()[1] < getPos()[0] + 96)) {
            loadCar((T) car);
        }
    }

    public int[] getPos() {
        return position;
    }

    public ArrayList<T> getStorage() {
        return storage;
    }

    public void loadCar(T car) {
        if (storage.size() == capacity) {
            throw new IndexOutOfBoundsException("Shop is already full, please release a car");
        }
        car.setStored(true);
        car.setPos(getPos());
        storage.add(car);
    }

    public void releaseCar(T car) {
        car.setStored(false);
        storage.remove(car);
        int[] newPos = new int[] {getPos()[0] - 1, getPos()[1] - 1};
        car.setPos(newPos);
    }


}
