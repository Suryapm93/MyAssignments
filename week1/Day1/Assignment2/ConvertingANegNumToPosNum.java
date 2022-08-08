package week1.Day1.Assignment2;

public class ConvertingANegNumToPosNum {
	
	public static void main(String[] args) {
		
		int NegNum = -5;
		
		if (NegNum<0)
		{
			System.out.println("The Positive Number of " + NegNum + " is " + (NegNum*(-1)));
		}
		else
		{
			System.out.println("The given number is not a negative number");
	    }
}
}