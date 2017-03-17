package module5.controller;

import module5.Room;
import module5.api.API;
import module5.api.impl.BookingComAPI;
import module5.api.impl.GoogleAPI;
import module5.api.impl.TripAdvisorAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Igor on 01.03.2017.
 */
public class Controller {

    public API[] apies = {new BookingComAPI(), new GoogleAPI(), new TripAdvisorAPI()};

    public Room[] requstRooms(int price, int persons, String city, String hotel) {
        Room[] allFoundRooms = null;
        for (API api : apies) {
            Room[] foundRooms = api.findRooms(price, persons, city, hotel);
            if (allFoundRooms == null) {
                allFoundRooms = foundRooms;
                continue;
            }


            if(foundRooms == null || Arrays.asList(foundRooms).isEmpty()) continue;

            System.arraycopy(foundRooms, 0, allFoundRooms, allFoundRooms.length - 1, foundRooms.length);
        }
        return allFoundRooms;
    }

    public Room[] check(API api1, API api2) {
        Room[] api1Rooms = getApiDB(api1);
        Room[] api2Rooms = getApiDB(api2);
        List<Room> result = new ArrayList<>();

        for (Room api1Room : api1Rooms) {
            for (Room api2Room : api2Rooms) {
                if (api1Room.equals(api2Room)) result.add(api1Room);
            }

        }
        return result.toArray(new Room[result.size()]);

    }

    private Room[] getApiDB(API api) {
        if (api == null) return null;

        if (api instanceof BookingComAPI) {
            return BookingComAPI.rooms;
        } else if (api instanceof GoogleAPI) {
            return GoogleAPI.rooms;
        } else return TripAdvisorAPI.rooms;
    }


}
