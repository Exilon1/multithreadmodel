package storage;

import entity.Car;
import entity.Driver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 12.11.2016.
 */
public class Storage {

    private Storage() {
    }

    private static class SingletonHelper {
        private static final Storage SINGLETON = new Storage();
    }

    public static Storage getInstance() {
        return Storage.SingletonHelper.SINGLETON;
    }

    private static List<Car> carList = new ArrayList<Car>();
    private static List<Driver> driverList = new ArrayList<Driver>();
  //  private List<User> carList = new ArrayList<User>();

    public static List<Car> getCarList() {
        return carList;
    }

    public static List<Driver> getDriverList() {
        return driverList;
    }
}
