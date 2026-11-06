package sealed_types_02;

public class Main {
	
	public static void main(String a[]) {
		
		// payment method
		PaymentMethod method = new MomoPayment();
		
		
		PaymentProcessor processor = new PaymentProcessor();
		System.out.println(processor.validatePayment(method));

	}

}
