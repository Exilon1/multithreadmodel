package utilities;

import entity.Car;
import entity.Driver;
import storage.CarList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Alexey on 30.10.2016.
 */
public class CarInitialization {

    private static String allChars = "abcdefghijklmnopqrstuvwxyz";
    private static String[] carMarks = {"Bugatti", "Lamborghini", "Ferrari", "McLaren"};

    public static List<Car> initCarArray() {
        return Stream.generate(CarInitialization::nextCar).limit(10).collect(Collectors.toCollection(CarList::getInstance));
    }

    private static int i=0;
    private static Random random = new Random();
    private static Car nextCar() {
        boolean isSmokeCar = random.nextBoolean();
        boolean isHaveBabySeat = random.nextBoolean();
        String carNumber = allChars.charAt(random.nextInt(allChars.length())) +
                Integer.toString((random.nextInt(9)+1)*100 + random.nextInt(100)); //генерирует номер вида a000

        if ( i>3 )
            i = 0;
        String carMark = carMarks[i];
        i++;

        int carClass;
        if (i%2==0)
            carClass = Car.TYPE_OF_CLASS_ECONOMIC;
        else carClass = Car.TYPE_OF_CLASS_BUSYNESS;


        Car car = new Car(carMark, carNumber, carClass);
        car.setSmokeCar(isSmokeCar);
        car.setHaveBabySeat(isHaveBabySeat);
        car.setCarStatus(Car.TYPE_OF_STATUS_FREE);
        car.setCarDriver(nextDriver());
        return car;
    }

    private static int j=1;
    private static Driver nextDriver() {
        Driver driver = new Driver("Driver name " + j);
        j++;
        String telephone = Integer.toString(((random.nextInt(9)+1)*100 + random.nextInt(100))*1000);
        driver.setTelephone(telephone);
        return driver;
    }

}
