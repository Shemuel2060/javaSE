package sealed_types_02;

public record MomoPayment() implements PaymentMethod {

	@Override
	public String reference() {
		return "Processed mobile money payment: Momo-003";
	}

}
