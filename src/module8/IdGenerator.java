package module8;

/**
 * Created by Igor on 29.03.2017.
 */
public final class IdGenerator {
    private static int id = 0;

    private IdGenerator() {
    }

    public static int generateId() {
        return id++;
    }
}
