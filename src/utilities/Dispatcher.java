package utilities;

import entity.Car;
import entity.Order;
import utilities.constants.TypeOfStatus;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Alexey on 13.11.2016.
 */
public class Dispatcher {

    static Random random = new Random();

    public synchronized static Car searchFreeCar(List<Car> carArrayList, Order order) {
        Car car = null;
        for(Car c: carArrayList) {
            if (isSuitableCar(c, order)) {
                car = c;
                car.setCarStatus(TypeOfStatus.RESERVED.getStatus());
                car.setReservedTime(new Date(System.currentTimeMillis() + random.nextInt(20)*1000));
                break;
            }
        }
        return car;
    }


    private static boolean isSuitableCar(Car car, Order order) {
        boolean isSuitableCar = car.getCarClass()==order.getNeedCarClass() &&
                car.isHaveBabySeat()==order.isNeedBabySeat() &&
                car.isSmokeCar()==order.isNeedSmokeCar() &&
                car.getCarStatus().equals(TypeOfStatus.FREE.getStatus());
        return isSuitableCar;
    }
}
