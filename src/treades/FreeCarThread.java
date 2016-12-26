package treades;

import entity.Car;
import storage.Storage;
import utilities.Dispatcher;
import utilities.FreeTheCar;

import java.util.zip.Deflater;

/**
 * Created by Alexey on 25.12.2016.
 */
public class FreeCarThread implements Runnable {

    private Storage storage = Storage.getInstance();

    @Override
    public void run() {
        while (true) {
            FreeTheCar.freeTheCar(storage.getCarList());
        }
    }
}
