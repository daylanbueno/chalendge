package tallertechnologies.payment_calculator.services;


import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tallertechnologies.payment_calculator.dtos.PaymentDto;
import tallertechnologies.payment_calculator.entity.Payment;
import tallertechnologies.payment_calculator.repositories.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentProcessorService {

  private final PaymentRepository repository;

  public PaymentDto save(PaymentDto paymentDto) {
      var entity = convertToEntity(paymentDto);
      repository.save(entity);
      return converterToDto(entity);
  }

  private static PaymentDto converterToDto(Payment entity) {
    return PaymentDto.builder()
      .id(entity.getId())
      .amount(entity.getAmount())
      .currency(entity.getCurrency())
      .status(entity.getStatus())
      .build();
  }

  private static Payment convertToEntity(PaymentDto paymentDto) {
    return Payment.builder()
      .id(paymentDto.getId())
      .amount(paymentDto.getAmount())
      .currency(paymentDto.getCurrency())
      .status(paymentDto.getStatus())
      .build();
  }

  public Collection<PaymentDto> findAll() {
    return repository.findAll().stream()
      .map(PaymentProcessorService::converterToDto)
      .toList();
  }

  public Collection<PaymentDto> findByStatus(String status) {
    return repository.findByStatus(status).stream()
      .map(PaymentProcessorService::converterToDto)
      .toList();
  }
}
