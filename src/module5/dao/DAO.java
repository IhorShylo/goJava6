package module5.dao;

import module5.Room;

/**
 * Created by Igor on 28.02.2017.
 */
public interface Dao {

    Room save(Room room);

    boolean delete(Room room);

    Room update(Room room);

    Room findById(long id);

    Room[] createDB();
}
