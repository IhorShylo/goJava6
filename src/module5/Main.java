package module5;

import module5.dao.Dao;
import module5.dao.impl.DaoImpl;

import java.util.Date;

/**
 * Created by Igor on 28.02.2017.
 */
public class Main {
    static Dao dao = new DaoImpl();
    public static void main(String[] args) {
//        Controller controller = new Controller();
//        controller.requstRooms(50, 1, "City1", "Hotel1");

        Room[] baseRooms = dao.createDB();

        Room newRoom = new Room(1, 777, 777, new Date(), "Hotel777", "City777");

        dao.update(newRoom);


    }
}
