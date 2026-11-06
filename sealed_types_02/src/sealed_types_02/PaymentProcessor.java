package sealed_types_02;

public class PaymentProcessor {
	
	public String validatePayment(PaymentMethod paymentMethod) {
		
		return switch(paymentMethod) {
		case CashPayment cash -> paymentMethod.reference();
		case BankPayment bank -> paymentMethod.reference();
		case MomoPayment momo -> momo.reference();
		};
	}

}
