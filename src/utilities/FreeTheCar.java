package utilities;

import entity.Car;

import java.util.Date;
import java.util.List;

import static utilities.constants.Constants.TYPE_OF_STATUS_FREE;
import static utilities.constants.Constants.TYPE_OF_STATUS_RESERVED;

/**
 * Created by Nikotin on 03.11.2016.
 */
public class FreeTheCar {

    public static void freeTheCar(List<Car> carList) {
        for(Car c: carList) {
            Date date = new Date();
            if (TYPE_OF_STATUS_RESERVED.equals(c.getCarStatus()) && date.after(c.getReservedTime())) {
                c.setCarStatus(TYPE_OF_STATUS_FREE);
                c.setReservedTime(null);
            }
        }

    }
}
