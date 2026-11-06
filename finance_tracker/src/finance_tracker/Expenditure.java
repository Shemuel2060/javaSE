package finance_tracker;

public record Expenditure(
		String reference,
        String department,
        long amountInUgx,
        String currency) {
}
