package Tourism.Tour.Controler;

import Tourism.Tour.Model.Tourguider;
import Tourism.Tour.Services.TourguiderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tourguiders")
public class TourguiderController {

    @Autowired
    private TourguiderServices tourguiderServices;

    @PostMapping
    public ResponseEntity<Tourguider> createTourguider(@RequestBody Tourguider tourguider) {
        Tourguider savedTourguider = tourguiderServices.createTourguider(tourguider);
        return new ResponseEntity<>(savedTourguider, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tourguider>> getAllTourguiders() {
        List<Tourguider> tourguiders = tourguiderServices.getAllTourguiders();
        return new ResponseEntity<>(tourguiders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tourguider> getTourguiderById(@PathVariable("id") Long id) {
        Tourguider tourguider = tourguiderServices.getTourguiderById(id);
        if (tourguider != null) {
            return new ResponseEntity<>(tourguider, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTourguider(@PathVariable("id") Long id) {
        tourguiderServices.deleteTourguider(id);
        return new ResponseEntity<>("Tourguider is already deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tourguider> updateTourguider(@PathVariable("id") Long id, @RequestBody Tourguider tourguider) {
        Tourguider updatedTourguider = tourguiderServices.updateTourguider(id, tourguider);
        if (updatedTourguider != null) {
            return new ResponseEntity<>(updatedTourguider, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
