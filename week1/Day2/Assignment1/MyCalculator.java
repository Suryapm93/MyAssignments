package week1.Day2.Assignment1;

public class MyCalculator {

	public static void main(String[] args) {

		Calculator calobj = new Calculator();
		System.out.println("Addition: " + calobj.add(4,4,2));
		System.out.println("Subtraction: " + calobj.sub(100,50));
		System.out.println("Multiplication: " + calobj.mul(2.5,2.5));
		System.out.println("Division: " + calobj.divide(10.5f,0.5f));

	}

}