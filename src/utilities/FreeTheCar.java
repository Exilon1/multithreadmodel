package utilities;

import entity.Car;
import utilities.constants.TypeOfStatus;

import java.util.Date;
import java.util.List;


/**
 * Created by Nikotin on 03.11.2016.
 */
public class FreeTheCar {

    public static void freeTheCar(List<Car> carList) {
        for(Car c: carList) {
            Date date = new Date();
            if (TypeOfStatus.RESERVED.getStatus().equals(c.getCarStatus()) && date.after(c.getReservedTime())) {
                c.setCarStatus(TypeOfStatus.FREE.getStatus());
                c.setReservedTime(null);
            }
        }
    }
}
