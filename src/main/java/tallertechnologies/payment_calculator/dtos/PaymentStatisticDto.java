package tallertechnologies.payment_calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatisticDto {
  private Integer totalPayments;
  private Double totalAmountSuccess;
  private Double totalAvarageAmountSuccess;
}
