package tallertechnologies.payment_calculator.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tallertechnologies.payment_calculator.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
  Collection<Payment> findByStatus(String status);
}
