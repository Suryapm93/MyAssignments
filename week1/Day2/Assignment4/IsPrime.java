package week1.Day2.Assignment4;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=17, count=0;
		for(int i=2; i<=n-1 ;i++)
		{
			if(n%i==0)
			{
				System.out.println("The given number " +n+" is not a prime");
				count++;
				break;
			}
		}
		if(count==0)
		{
			System.out.println("The given number " +n+" is a prime");
		}

	}

}