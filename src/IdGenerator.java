/**
 * Created by Nikotin on 09.01.2017.
 */
public class IdGenerator {

    private static int count=0;

    public static int nextId() {
        return count++;
    }
}
