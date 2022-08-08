package week1.Day1.Assignment2;

public class NumIsPosOrNeg {

	int num = 3;
	
	public static void main(String[] args) {
		
		NumIsPosOrNeg obj = new NumIsPosOrNeg();
		
		if (obj.num>0)
		{
			System.out.println( obj.num + " is Positive");
		}
		else if (obj.num<0)
		{
			System.out.println( obj.num + " is Negative");
		}
		else
			System.out.println ( obj.num + " is neither positive nor negative");
	}
	
}
