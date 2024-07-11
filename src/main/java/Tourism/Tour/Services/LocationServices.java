package Tourism.Tour.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tourism.Tour.Model.Location;
import Tourism.Tour.Repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServices {

    @Autowired
    private LocationRepository locationRepo;

    public Location createLocation(Location location) {
        return locationRepo.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    public Location getLocationById(Long id) {
        Optional<Location> location = locationRepo.findById(id);
        return location.orElse(null);
    }

    public void deleteLocation(Long id) {
        locationRepo.deleteById(id);
    }

    public Location updateLocation(Long id, Location location) {
        Location oldLocation = locationRepo.findById(id).orElse(null);
        if (oldLocation != null) {
            oldLocation.setLocationName(location.getLocationName());
            oldLocation.setPrice(location.getPrice());
            oldLocation.setImage(location.getImage());
            return locationRepo.save(oldLocation);
        }
        return null;
    }
}
