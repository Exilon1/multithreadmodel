package storage;

import entity.Car;
import entity.Driver;
import entity.User;

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

    private List<Car> carList = new ArrayList<Car>();
    private List<Driver> driverList = new ArrayList<Driver>();
    private List<User> userList = new ArrayList<User>();

    public List<Car> getCarList() {
        return carList;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public List<User> getUserList() {
        return userList;
    }
}
