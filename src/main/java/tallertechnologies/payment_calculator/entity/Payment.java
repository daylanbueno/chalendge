package tallertechnologies.payment_calculator.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jshell.Snippet.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private Double amount;
  private String currency;
  private Status status;
}
