package repositories;

import models.Company;
import models.Location;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {

    void add(Location c);
    Optional<List<Location>> listAll ();
    Optional<Location> findLocationByLocationName(String name);

    static LocationRepository build(Type type) {
        switch (type) {
            case FILE: return new FileLocationRepository();
            //  case ARRAY:return new ArrayEventRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        FILE, ARRAY
    }
}
