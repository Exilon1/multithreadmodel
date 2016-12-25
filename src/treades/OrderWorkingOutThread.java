package treades;

import entity.Car;

/**
 * Created by Alexey on 25.12.2016.
 */
public class OrderWorkingOutThread implements Runnable {

    Car car;

    public OrderWorkingOutThread(Car c) {
        car = c;
    }

    @Override
    public void run() {

    }
}
