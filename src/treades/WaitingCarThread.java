package treades;

import entity.Car;
import entity.Order;
import storage.Storage;
import utilities.CarSearch;

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

    @Override
    public void run() {
        Car car = CarSearch.searchFreeCar(carList, order);
        if(car==null)
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
}
