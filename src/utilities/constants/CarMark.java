package utilities.constants;

/**
 * Created by Alexey on 18.12.2016.
 */
public enum CarMark {

    BUGATTI("Bugatti"), LAMBIRGHINI("Lamborghini"), FERRARI("Ferrari"), MCLAREN("McLaren");

    private String name;

    CarMark(String name) {
        this.name = name;
    }

    public String getMark() {
        return name;
    }
}
