package sealed_types_02;

public record BankPayment() implements PaymentMethod {

	@Override
	public String reference() {
		return "Bank-002";
	}

}
