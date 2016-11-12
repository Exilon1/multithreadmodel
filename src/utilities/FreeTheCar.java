package utilities;

import entity.Car;

import java.util.Date;
import java.util.List;

/**
 * Created by Nikotin on 03.11.2016.
 */
public class FreeTheCar {

    public static void freeTheCar(List<Car> carList) {
        for(Car c: carList) {
            Date date = new Date();
            if (Car.TYPE_OF_STATUS_RESERVED.equals(c.getCarStatus()) && date.after(c.getReservedTime())) {
                c.setCarStatus(Car.TYPE_OF_STATUS_FREE);
                c.setReservedTime(null);
            }
        }

    }
}
