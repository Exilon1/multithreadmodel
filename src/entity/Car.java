package entity;

import java.util.Date;

/**
 * Created by дима on 30.10.2016.
 */
public class Car {
    private String carMark;
    private String carNumber;
    private boolean isHaveBabySeat;
    private boolean isSmokeCar;
    private int carClass;
    private String carStatus;

    private Date reservedTime;

    public Car(String carMark, String carNumber, int carClass) {
        this.carMark = carMark;
        this.carNumber = carNumber;
        this.carClass = carClass;
    }

    public String getCarMark() {
        return carMark;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getCarClass() {
        return carClass;
    }

    public boolean isHaveBabySeat() {
        return isHaveBabySeat;
    }

    public void setHaveBabySeat(boolean haveBabySeat) {
        isHaveBabySeat = haveBabySeat;
    }

    public boolean isSmokeCar() {
        return isSmokeCar;
    }

    public void setSmokeCar(boolean smokeCar) {
        isSmokeCar = smokeCar;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Date getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(Date reservedTime) {
        this.reservedTime = reservedTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carMark='" + carMark + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", isHaveBabySeat=" + isHaveBabySeat +
                ", isSmokeCar=" + isSmokeCar +
                ", carClass=" + carClass +
                '}';
    }
}
