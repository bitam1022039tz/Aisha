package Tourism.Tour.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Tourism.Tour.Model.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
