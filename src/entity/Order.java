package entity;

/**
 * Created by дима on 30.10.2016.
 */
public class Order {
    private String startPoint;
    private String endPoint;
    private boolean isNeedBabySeat;
    private boolean isNeedSmokeCar;
    private int needCarClass;
    private Car car;
    private Driver driver;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Order(String startPoint, String endPoint, boolean isNeedBabySeat, boolean isNeedSmokeCar, int needCarClass) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.isNeedBabySeat = isNeedBabySeat;
        this.isNeedSmokeCar = isNeedSmokeCar;
        this.needCarClass = needCarClass;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public boolean isNeedBabySeat() {
        return isNeedBabySeat;
    }

    public boolean isNeedSmokeCar() {
        return isNeedSmokeCar;
    }

    public int getNeedCarClass() {
        return needCarClass;
    }

}
