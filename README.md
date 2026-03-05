Title: Payment Statistics Calculator						
						
Scenario:						
You are asked to implement a small Java program that processes a list of Payment objects. Each payment has:						
- `id` (String)						
- `amount` (double)						
- `currency` (String)						
- `status` (enum: `PENDING`, `SUCCESS`, `FAILED`)						
						
Requirements:						
1. Create the `Payment` class with proper encapsulation and `toString()`.						
2. Implement a `PaymentProcessor` class with methods to:						
- Add a new payment.						
- Retrieve all payments.						
- Retrieve payments filtered by status.						
- Calculate statistics:						
- Total number of payments.						
- Total amount of successful payments.						
- Average amount of successful payments.						
3. Demonstrate usage in a `main()` method:						
- Create a few sample payments.						
- Process them.						
- Print statistics.						
4. Bonus (if time allows):						
- Sort payments by amount (descending).						
- Use Java Streams to implement filtering and statistics.						
- Add a simple concurrency simulation: process payments in parallel using `CompletableFuture` or `parallelStream()`.		

## Technologies
- Java 21
- Spring boot
- Maven
- Lombok
- H2 database
- Git
