package tallertechnologies.payment_calculator.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tallertechnologies.payment_calculator.dtos.PaymentDto;
import tallertechnologies.payment_calculator.entity.Payment;
import tallertechnologies.payment_calculator.repositories.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentProcessorService {

  private PaymentRepository repository;

  public PaymentDto save(PaymentDto paymentDto) {

      var entity = Payment.builder()
        .id(paymentDto.getCurrency())
        .build();
      return paymentDto;
  }
}
