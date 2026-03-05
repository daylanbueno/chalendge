package tallertechnologies.payment_calculator.resources;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tallertechnologies.payment_calculator.dtos.PaymentDto;
import tallertechnologies.payment_calculator.dtos.PaymentStatisticDto;
import tallertechnologies.payment_calculator.services.PaymentProcessorService;

@RestController
@RequestMapping("api/payments")
@RequiredArgsConstructor
public class PaymentProcessorResource {

  private final PaymentProcessorService paymentProcessorService;

  @PostMapping
  public PaymentDto  create(@RequestBody PaymentDto paymentDto) {
      return paymentProcessorService.save(paymentDto);
  }

  @GetMapping
  public Collection<PaymentDto> findAll() {
      return paymentProcessorService.findAll();
  }

  @GetMapping("/status")
  public Collection<PaymentDto> findAllByStatus(@RequestParam String status) {
      return paymentProcessorService.findByStatus(status);
  }

  @GetMapping("/statistic")
  public PaymentStatisticDto findPaymentStatistic() {
    return paymentProcessorService.findPaymentStatistic();
  }

}
