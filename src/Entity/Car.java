package Entity;

import java.util.Date;

/**
 * Created by дима on 30.10.2016.
 */
public class Car {
    private String carMark;
    private Driver carDriver;
    private String carNumber;
    private boolean isHaveBabySeat;
    private boolean isSmokeCar;
    private int carClass;
    private String carStatus;
    public static final int TYPE_OF_CLASS_ECONOMIC = 0;
    public static final int TYPE_OF_CLASS_BUSYNESS = 1;
    public static final String TYPE_OF_STATUS_FREE = "Свободен";
    public static final String TYPE_OF_STATUS_RESERVED = "Занят";

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

    public Driver getCarDriver() {
        return carDriver;
    }

    public void setCarDriver(Driver carDriver) {
        this.carDriver = carDriver;
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
                ", carDriver=" + carDriver +
                ", carNumber='" + carNumber + '\'' +
                ", isHaveBabySeat=" + isHaveBabySeat +
                ", isSmokeCar=" + isSmokeCar +
                ", carClass=" + carClass +
                ", carStatus='" + carStatus + '\'' +
                '}';
    }
}
