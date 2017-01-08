import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product());
        list.add(new Product());
        list.add(0,null);
        list.remove(null);
        System.out.println(list.contains(null));
        for (Product p: list) {
            System.out.println(p);
        }

    }
}
