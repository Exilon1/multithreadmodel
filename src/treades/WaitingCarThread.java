package treades;

import entity.Car;
import entity.Order;
import storage.Storage;
import utilities.Dispatcher;

import java.util.List;

/**
 * Created by Alexey on 25.12.2016.
 */
public class WaitingCarThread implements Runnable {

    private Order order;
    private List<Car> carList = Storage.getInstance().getCarList();

    public WaitingCarThread(Order order) {
        this.order = order;
    }

    Car car;

    @Override
    public void run() {
        car = Dispatcher.searchFreeCar(carList, order);
        if(car==null) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            car = Dispatcher.searchFreeCar(carList, order);
            if(car==null) {
                System.out.println("All cars are reserved. Please, try again later.");
                return;
            }
            System.out.println("Ожидайте машину:");
            System.out.println(car.getCarMark() + ", nunber " + car.getCarNumber());
        }
        System.out.println("Ожидайте машину:");
        System.out.println(car.getCarMark() + ", nunber " + car.getCarNumber());
    }
}
