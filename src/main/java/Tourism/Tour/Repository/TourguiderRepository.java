package Tourism.Tour.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Tourism.Tour.Model.Tourguider;

@Repository
public interface TourguiderRepository extends JpaRepository<Tourguider, Long> {
}
