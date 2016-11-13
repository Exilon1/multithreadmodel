import entity.*;
import storage.Storage;
import utilities.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by дима on 30.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> carList = Initialization.initCarList();
        Initialization.initDriverList();
        Initialization.initDriversByCars();

        Storage storage = Storage.getInstance();
        storage.getCarList().addAll(carList);

        Scanner scanner = new Scanner(System.in);


        while (true) {
            String request = scanner.nextLine();

            FreeTheCar.freeTheCar(carList);
            Order order = null;
            try {
                order = OrderReader.orderRead(request);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            Car car = CarSearch.searchFreeCar(carList, order);
            if (car == null) {
                System.out.println("All cars are reserved. Please, try again later.");
                continue;
            }
            System.out.println("Your car:");
            System.out.println(car);
        }
    }
}
