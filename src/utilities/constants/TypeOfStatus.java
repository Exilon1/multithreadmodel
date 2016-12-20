package utilities.constants;

/**
 * Created by Alexey on 18.12.2016.
 */
public enum TypeOfStatus {

    FREE("Свободен"), RESERVED("Занят");

    private String status;

    TypeOfStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
