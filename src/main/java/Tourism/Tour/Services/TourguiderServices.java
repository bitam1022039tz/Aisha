package Tourism.Tour.Services;

import java.util.List;
import java.util.Optional;

import Tourism.Tour.Model.Tourguider;
import Tourism.Tour.Repository.TourguiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourguiderServices {

    @Autowired
    private TourguiderRepository tourguiderRepo;

    public Tourguider createTourguider(Tourguider tourguider) {
        return tourguiderRepo.save(tourguider);
    }

    public List<Tourguider> getAllTourguiders() {
        return tourguiderRepo.findAll();
    }

    public Tourguider getTourguiderById(Long id) {
        Optional<Tourguider> tourguider = tourguiderRepo.findById(id);
        return tourguider.orElseThrow();
    }

    public void deleteTourguider(Long id) {
        tourguiderRepo.deleteById(id);
    }

    public Tourguider updateTourguider(Long id, Tourguider tourguider) {
        Tourguider oldTourguider = tourguiderRepo.findById(id).orElseThrow();
        oldTourguider.setName(tourguider.getName());
        oldTourguider.setNumber(tourguider.getNumber());
        oldTourguider.setAddress(tourguider.getAddress());
        return tourguiderRepo.save(oldTourguider);
    }
}
