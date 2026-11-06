package streams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	
	// data for problem 1
	static List<String> references = List.of(
		    "TXN-101",
		    "TXN-102",
		    "TXN-103",
		    "TXN-104"
		);
	
	// problem 2: create a stream from values
	Stream<Double> doubles = Stream.of(1000.0, 2500.0, 3750.0);
	
	// problem 3 data
	static List<Integer> amounts = List.of(500, 1200, 3000, 450, 8000);
	
	// problem 4 data
	static List<Integer> amounts2 = List.of(1000, 2000, 3000);
	
	// problem 6 data
	static List<Integer> values = List.of(10, 20, 30, 40);
	
	// problem 7 data 
	static IntStream numbers = IntStream.of(10, 20, 30, 40);
	
	// problem 8 data
	static List<Integer> transactionIds = List.of(101, 102, 103, 104, 105);
	
	// problem 10 data
	static List<Integer> amounts10 = List.of(500, 1500, 2000, 750, 4000);
	
	
	public static void main(String[] args) {
		// problem 1
		
//		references.stream() // creating a stream
//				  .forEach(ref -> System.out.println(ref)); // with lambda
		
		// problem 3 - filter >1000
//		amounts.stream()
//			   .filter(amount -> amount>1000)
//			   .forEach(System.out::println); // with method reference
		
		// problem 4 - transform a list
		
//		List<Integer> newAmounts = amounts2.stream()
//			    .map(amount -> amount*2)
//			    .toList();
//		
//		for(Integer am : newAmounts) {
//			System.out.println(am);
//		}
		
		
		// problem 5: create primitive range
		
//		IntStream numbers = IntStream.rangeClosed(1, 10);
//		numbers.forEach(System.out::println);
		
		// problem 6
		
		// convert the list to Stream<Integer>
//		Stream<Integer> valueStream = values.stream();
//		// convert the stream to intStream
//		IntStream valueIntStream = valueStream.mapToInt(x->x);
//		System.out.println(valueIntStream.sum());
		
		// when chained
		
//		System.out.println(values.stream()
//			  .mapToInt(value -> value)
//			  .sum());
		
		// problem 7
//		System.out.println(numbers.boxed()
//			   .toList());
		
		// problem 8
		
//		transactionIds.parallelStream()
//				      .forEach(System.out::println);
		
		// alternatively
//		transactionIds.stream()
//					  .parallel()
//					  .forEach(System.out::println);
		
		// problem 9 - lazy evaluation of streams
		
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);

//		numbers.stream()
//		       .filter(n -> {
//		           System.out.println("Checking " + n);
//		           return n > 3;
//		       })
//		       .forEach(System.out::println);
		
		
		// problem 10
		int sum = amounts10.stream()
				.mapToInt(amount -> amount)
				.filter(amount -> amount >= 1500)
				.sum();
		System.out.println(sum);
		
	}

}
