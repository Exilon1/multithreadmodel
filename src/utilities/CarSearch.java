package utilities;

import entity.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static utilities.Constants.TYPE_OF_STATUS_FREE;
import static utilities.Constants.TYPE_OF_STATUS_RESERVED;

/**
 * Created by Alexey on 30.10.2016.
 */
public class CarSearch {

    static Random random = new Random();

    public static Car searchFreeCar(List<Car> carArrayList, Order order) {
        Car car = null;
        for(Car c: carArrayList) {
            if (isSuitableCar(c, order)) {
                car = c;
                break;
            }
        }
        car.setCarStatus(TYPE_OF_STATUS_RESERVED);
        car.setReservedTime(new Date(System.currentTimeMillis() + random.nextInt(15)*10000));
        return car;
    }

    private static boolean isSuitableCar(Car car, Order order) {
        boolean isSuitableCar = car.getCarClass()==order.getNeedCarClass() &&
                                car.isHaveBabySeat()==order.isNeedBabySeat() &&
                                car.isSmokeCar()==order.isNeedSmokeCar() &&
                                car.getCarStatus().equals(TYPE_OF_STATUS_FREE);
        return isSuitableCar;
    }
}
