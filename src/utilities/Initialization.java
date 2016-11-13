package utilities;

import entity.Car;
import entity.Driver;
import entity.User;
import storage.Storage;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Alexey on 30.10.2016.
 */
public class Initialization {

    private static Storage storage = Storage.getInstance();

    public static List<Car> initCarList() {
        storage.getCarList().addAll(
                Stream.generate(EntitiesGenerator::nextCar).limit(10).collect(Collectors.toList()));
        return storage.getCarList();
    }

    public static List<Driver> initDriverList() {
        storage.getDriverList().addAll(
                Stream.generate(EntitiesGenerator::nextDriver).limit(10).collect(Collectors.toList()));
        return storage.getDriverList();
    }

    public static List<User> initUserList() {
        storage.getUserList().addAll(
                Stream.generate(EntitiesGenerator::nextUser).limit(10).collect(Collectors.toList()));
        return storage.getUserList();
    }

    public static void initDriversByCars() {
        for(int i=0; i<storage.getDriverList().size(); i++) {
            storage.getDriverList().get(i).setCar(storage.getCarList().get(i));
        }
    }
}
