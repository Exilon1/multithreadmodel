package storage;

import entity.Car;

import java.util.ArrayList;

/**
 * Created by Nikotin on 02.11.2016.
 */
public class CarList extends ArrayList<Car> {

    private CarList() {
        super(10);
    }

    private static class SingletonHelper {
        private static final CarList SINGLETON = new CarList();
    }

    public static CarList getInstance() {
        return CarList.SingletonHelper.SINGLETON;
    }


}
