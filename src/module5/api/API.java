package module5.api;

import module5.Room;

/**
 * Created by Igor on 28.02.2017.
 */
public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);
}
