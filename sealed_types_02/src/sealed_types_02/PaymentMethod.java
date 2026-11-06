package sealed_types_02;

public sealed interface PaymentMethod 
permits CashPayment,BankPayment, MomoPayment{
	
	String reference();

}
