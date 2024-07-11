package Tourism.Tour.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tourism.Tour.Model.Tourist;
import Tourism.Tour.Repository.TouristRepository;

@Service
public class PaymentServices {

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

    public void deleteTourist(Long id) {
        touristRepo.deleteById(id);
    }

    public Tourist updateTourist(Long id, Tourist tourist) {
        Tourist oldTourist = touristRepo.findById(id).orElse(null);
        if (oldTourist != null) {
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
