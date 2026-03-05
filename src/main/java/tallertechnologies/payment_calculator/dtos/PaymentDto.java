package tallertechnologies.payment_calculator.dtos;

import jdk.jshell.Snippet.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {
  private String id;
  private Double amount;
  private String currency;
  private Status status;
}
