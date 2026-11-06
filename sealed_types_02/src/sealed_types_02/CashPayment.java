package sealed_types_02;

public record CashPayment() implements PaymentMethod {

	@Override
	public String reference() {
		return "Cash-001";
	}

}
