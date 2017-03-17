package module5.api.impl;

import module5.Room;
import module5.api.API;
import module5.dao.Dao;
import module5.dao.impl.DaoImpl;

import java.util.Date;

/**
 * Created by Igor on 28.02.2017.
 */
public class BookingComAPI implements API {
    static public Room[] rooms;
    public static final int BASE_PRICE = 200;
    public static final int DEFAULT_NUMBER_OF_ROOMS = 5;
    public Dao dao = new DaoImpl();


    public BookingComAPI() {
        rooms = dao.createDB();
        for (int i = 0; i < DEFAULT_NUMBER_OF_ROOMS; i++) {
            rooms[i] = new Room(i, BASE_PRICE + (20 * i), i, new Date(), "Hotel " + i, "City " + i);
        }
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        dao.createDB();

        Room[] result = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i] == null) continue;

            if (rooms[i].getPrice() <= price && rooms[i].getPersons() == persons
                    && rooms[i].getCityName().equals(city) && rooms[i].getHotelName().equals(hotel)) {
                result[i] = rooms[i];
            }
        }

        return result;
    }
}
