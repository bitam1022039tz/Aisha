package Tourism.Tour.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Tourism.Tour.Model.Tourist;
import Tourism.Tour.Services.TouristServices;

@RestController
@RequestMapping("api/tourists")
public class PaymentController {

    @Autowired
    private TouristServices touristServices;

    @PostMapping
    public ResponseEntity<Tourist> createTourist(@RequestBody Tourist tourist) {
        Tourist savedTourist = touristServices.createTourist(tourist);
        return new ResponseEntity<>(savedTourist, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tourist>> getAllTourists() {
        List<Tourist> tourists = touristServices.getAllTourists();
        return new ResponseEntity<>(tourists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tourist> getTouristById(@PathVariable("id") Long id) {
        Tourist tourist = touristServices.getTouristById(id);
        if (tourist != null) {
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTourist(@PathVariable("id") Long id) {
        touristServices.deleteTourist(id);
        return new ResponseEntity<>("Tourist deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tourist> updateTourist(@PathVariable("id") Long id, @RequestBody Tourist tourist) {
        Tourist updatedTourist = touristServices.updateTourist(id, tourist);
        if (updatedTourist != null) {
            return new ResponseEntity<>(updatedTourist, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
