package Tourism.Tour.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tourism.Tour.Model.Tourist;
import Tourism.Tour.Repository.TouristRepository;

@Service
public class TouristServices {

    @Autowired
    private TouristRepository touristRepo;

    public Tourist createTourist(Tourist tourist) {
        return touristRepo.save(tourist);
    }

    public List<Tourist> getAllTourists() {
        return touristRepo.findAll();
    }

    public Tourist getTouristById(Long id) {
        Optional<Tourist> tourist = touristRepo.findById(id);
        return tourist.orElse(null);
    }

    public boolean deleteTourist(Long id) {
        if (touristRepo.existsById(id)) {
            touristRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Tourist updateTourist(Long id, Tourist tourist) {
        Optional<Tourist> existingTouristOpt = touristRepo.findById(id);
        if (existingTouristOpt.isPresent()) {
            Tourist oldTourist = existingTouristOpt.get();
            oldTourist.setLanguage(tourist.getLanguage());
            oldTourist.setEmail(tourist.getEmail());
            oldTourist.setPhone(tourist.getPhone());
            oldTourist.setCountry(tourist.getCountry());
            oldTourist.setFullName(tourist.getFullName());
            return touristRepo.save(oldTourist);
        }
        return null;
    }
}
