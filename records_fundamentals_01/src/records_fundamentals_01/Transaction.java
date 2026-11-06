package records_fundamentals_01;

import java.util.List;

public record Transaction(
		
		String transactionId,
		String description,
		long amountInCents,
		String currency,
		List<String> tags		
		) {
	
	public Transaction{
		
		// defensive copying - ensures data immutability
		tags = List.copyOf(tags);
		
		if(transactionId == null || transactionId == "") {
			throw new IllegalArgumentException("Transaction Id cannot be null");
		}
		
		if(description == null || description == "") {
			throw new IllegalArgumentException("Description cannot be null");
		}
		
		if(amountInCents == 0 || amountInCents <0) {
			throw new IllegalArgumentException("Amount cannot be zero or negative");
		}
		
		if(currency != null && currency.length() ==3) {
			currency.toUpperCase();
		}
	}
	
	public static void main(String args[]) {
		// create a valid Transaction
		Transaction validTransaction = new Transaction("trans-001", 
				"description001", 34L, "ugx", List.of("tag1","tag2","tag3") );
		
		System.out.println("Valid Transaction: "+validTransaction);
		validTransaction.tags.add("James"); // fails
		System.out.println("Valid Transaction: "+validTransaction + "\n");
		
		// create an invalid transaction
		Transaction inValidTransaction = new Transaction("trans-002", "",
				54L, "usd", List.of("tagx"));
		
		System.out.println(inValidTransaction);
	}
	
	
	

}
