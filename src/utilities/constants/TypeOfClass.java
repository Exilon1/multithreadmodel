package utilities.constants;

/**
 * Created by Alexey on 18.12.2016.
 */
public enum TypeOfClass {

    BUSYNESS(1), ECONOMIC(0);

    private int carClass;

    TypeOfClass(int carClass) {
        this.carClass = carClass;
    }

    public int getCarClass() {
        return carClass;
    }
}
