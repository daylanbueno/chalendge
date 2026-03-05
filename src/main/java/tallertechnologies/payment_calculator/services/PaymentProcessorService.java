package tallertechnologies.payment_calculator.services;


import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tallertechnologies.payment_calculator.dtos.PaymentDto;
import tallertechnologies.payment_calculator.dtos.PaymentStatisticDto;
import tallertechnologies.payment_calculator.entity.Payment;
import tallertechnologies.payment_calculator.enums.StatusEnum;
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

  public PaymentStatisticDto findPaymentStatistic() {
    var payments = repository.findAll();

    var totalPayments = payments.size();

    var amountSuccess = calculateTotalAmountSuccess(payments);

    var averageAmountSuccess = calculateAverageAmountSuccess(payments);


    return PaymentStatisticDto.builder()
      .totalPayments(totalPayments)
      .totalAmountSuccess(amountSuccess)
      .totalAvarageAmountSuccess(averageAmountSuccess)
      .build();
  }

  private static double calculateTotalAmountSuccess(List<Payment> payments) {
    return payments.stream()
      .filter(payment -> payment.getStatus().name().equals(StatusEnum.SUCCESS.name()))
      .mapToDouble(Payment::getAmount)
      .sum();
  }

  private static double calculateAverageAmountSuccess(List<Payment> payments) {
    return payments.stream()
      .filter(payment -> payment.getStatus().name().equals(StatusEnum.SUCCESS.name()))
      .mapToDouble(Payment::getAmount)
      .average()
      .orElse(0.0);
  }
}
