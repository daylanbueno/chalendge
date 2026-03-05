package tallertechnologies.payment_calculator;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tallertechnologies.payment_calculator.dtos.PaymentDto;
import tallertechnologies.payment_calculator.enums.StatusEnum;
import tallertechnologies.payment_calculator.services.PaymentProcessorService;

@SpringBootApplication
public class PaymentCalculatorApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(PaymentCalculatorApplication.class);

	private final PaymentProcessorService paymentProcessorService;

	public PaymentCalculatorApplication(PaymentProcessorService paymentProcessorService) {
		this.paymentProcessorService = paymentProcessorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentCalculatorApplication.class, args);
	}

	@Bean
	CommandLineRunner demonstratePaymentProcessor() {
		return args -> {
			var samplePayments = List.of(
				PaymentDto.builder().amount(100.0).currency("USD").status(StatusEnum.SUCCESS).build(),
				PaymentDto.builder().amount(220.0).currency("USD").status(StatusEnum.FAILED).build(),
				PaymentDto.builder().amount(50.0).currency("USD").status(StatusEnum.SUCCESS).build(),
				PaymentDto.builder().amount(10.0).currency("USD").status(StatusEnum.PENDING).build()
			);

			samplePayments.forEach(paymentProcessorService::save);

			var stats = paymentProcessorService.findPaymentStatistic();
			LOGGER.info("=== Payment statistics demo ===");
			LOGGER.info("Total payments: {} ",stats.getTotalPayments());
			LOGGER.info("Total successful amount: {} ", stats.getTotalAmountSuccess());
			LOGGER.info("Average successful amount: {} ", stats.getTotalAvarageAmountSuccess());
		};
	}
}
