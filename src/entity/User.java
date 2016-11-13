package entity;

/**
 * Created by Alexey on 13.11.2016.
 */
public class User {

    private int id;
    private String phoneNumber;
    private int discountPercent;

    public User(int id, String phoneNumber, int discountPercent) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.discountPercent = discountPercent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
}
