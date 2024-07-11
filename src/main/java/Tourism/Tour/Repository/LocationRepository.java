package Tourism.Tour.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Tourism.Tour.Model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
