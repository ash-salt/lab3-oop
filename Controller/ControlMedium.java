package Controller;

public interface ControlMedium {
    void gas(int amount);
    void brake(int amount);
    void turnLeft();
    void turnRight();
    void stopAllCars();
    void startAllCars();
    void toggleSaabTurbo(boolean state);
    void toggleLiftBed(boolean state);
}
