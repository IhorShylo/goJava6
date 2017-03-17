package module5.dao.impl;

import module5.Room;
import module5.dao.Dao;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Igor on 28.02.2017.
 */
public class DaoImpl implements Dao {

    public static final int DATABASE_START_SIZE = 10;
    private static Room[] rooms  = new Room[DATABASE_START_SIZE];
    public static final int BASE_PRICE = 200;
    static {
        for (int i = 0; i < DATABASE_START_SIZE; i++) {
            rooms[i] = new Room(i, BASE_PRICE + (20 * i), i, new Date(), "Hotel " + i, "City " + i);
        }
    }


    @Override
    public Room save(Room room) {
        System.out.println("Save method start...");
        System.out.println("Object = " + room);
        Room[] result = new Room[DATABASE_START_SIZE + 1];
        System.arraycopy(rooms, 0, result, 0, result.length);
        System.out.println("Rooms after saving + " + Arrays.asList(result));
        return room;
    }

    @Override
    public boolean delete(Room room) {
        System.out.println("Delete method start...");
        System.out.println("Object = " + room);
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(room)) {
                rooms[i] = null;
                System.out.println("Room was deleted: " + room);
                System.out.println("Rooms after delete + " + Arrays.asList(rooms));
                return true;
            }
        }
        System.out.println("Can't delete room: " + room + "from db");
        return false;
    }

    @Override
    public Room update(Room room) {
        System.out.println("Update method start...");
        System.out.println("Object = " + room);

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getId() == room.getId()) {
                rooms[i] = room;
                System.out.println("Room was updated: " + room);
                System.out.println("Rooms after update + " + Arrays.asList(rooms));
                return room;
            }
        }

        return null;
    }

    @Override
    public Room findById(long id) {
        System.out.println("FindByid method start...");
        System.out.println("id = " + id);
        for (Room room : rooms) {
            if (room.getId() == id) {
                System.out.println("Room was find: " + room);
                return room;
            }
        }
        return null;
    }

    @Override
    public Room[] createDB() {
        return rooms;
    }
}
