package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<Dog> animals = new ArrayList<>();
		animals.add(new Dog());
		animals.add(new Dog());
		animals.add(new Dog());
		
		fun(animals);

	}
	
	// a generic with no limitations
	public class General<U>{
		U value;
		
		// methods here.....
	}
	
	// a generic class with limitations to only Number and its subtypes
	public class DataHolder<T> {
		private T value;
		
		public void setData(T value) {
			this.value = value;
		}
		
		public T getData() {
			return this.value;
		}
	}
	
	// a generic method
	// Modifier <T> returnType methodName(T parameter){....}
	
	
	// wildcards with upbounds
	public static void fun(List<? extends Animal> animals) {
		for(Animal a : animals) {
			a.walk();
			
		}
	}
	
	public static class Animal{
		
		public void eat() {
			System.out.println("Eating");
		}
		public void walk() {
			System.out.println("walking");
		}
	}
	
	public static class Dog extends Animal{
		
		public void bark() {
			System.out.println("Barking");
		}
	}
	
	
}


