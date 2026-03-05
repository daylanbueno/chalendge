package tallertechnologies.payment_calculator.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tallertechnologies.payment_calculator.dtos.PaymentDto;
import tallertechnologies.payment_calculator.services.PaymentProcessorService;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
public class PaymentProcessorResource {

  private final PaymentProcessorService paymentProcessorService;

  @PostMapping
  public PaymentDto  create(@RequestBody PaymentDto paymentDto) {
      return paymentProcessorService.save(paymentDto);
  }

}
