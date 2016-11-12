package entity;

/**
 * Created by дима on 30.10.2016.
 */
public class Driver {

    private String name;
    private String telephone;
    private Car car;

    public Driver(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
